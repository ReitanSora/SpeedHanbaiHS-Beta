/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author stive
 */
public class Encrypt {

    private SecretKey key;
    private int KEY_SIZE = 128;
    private int T_LEN = 128;
    private byte[] IV;

    private String loadSecretKey() {
        Properties propiedades = new Properties();
        InputStream is = null;
        String secretKey = "";

        try {
            is = new FileInputStream("/web/WEB-INF/aes.properties");
            propiedades.load(is);

            secretKey = propiedades.getProperty("secret_key");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return secretKey;
    }

    private String loadInitializeVector() {
        Properties propiedades = new Properties();
        InputStream is = null;
        String iv = "";

        try {
            is = new FileInputStream("/web/WEB-INF/aes.properties");
            propiedades.load(is);

            iv = propiedades.getProperty("iv");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return iv;
    }

    private void initFromStrings() {
        key = new SecretKeySpec(decode("vNyDt2P5fp+Z0FToMbk8+fQScz62GAtZR1b87uMXx/Q="), "AES");
        this.IV = decode("Le+CdBJ7pa0w3uDk");
    }

    public String encrypt(String value) throws Exception {
        initFromStrings();
        byte[] messageInBytes = value.getBytes();
        Cipher encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(T_LEN, IV);

        encryptionCipher.init(Cipher.ENCRYPT_MODE, key, spec);
        byte[] encryptedBytes = encryptionCipher.doFinal(messageInBytes);
        
        this.key = null;
        this.IV = null;
        
        return encode(encryptedBytes);
    }

    public String decrypt(String encryptedValue) throws Exception {
        initFromStrings();
        byte[] messageInBytes = decode(encryptedValue);
        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(T_LEN, IV);

        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes = decryptionCipher.doFinal(messageInBytes);
        
        this.key = null;
        this.IV = null;
        
        return new String(decryptedBytes);
    }

    private String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    private void exportKeys() {
        System.err.println("SecretKey: " + encode(key.getEncoded()));
        System.err.println("IV: " + encode(IV));
    }
    /**
     *
     * String LLAVE = "Flus1902shhs2024";
     *
     * public SecretKeySpec crearLlave(String llave){ try { byte[] cadena =
     * llave.getBytes("UTF-8"); MessageDigest md =
     * MessageDigest.getInstance("SHA-1"); cadena = md.digest(cadena); cadena =
     * Arrays.copyOf(cadena, 16); SecretKeySpec sks = new SecretKeySpec(cadena,
     * "AES"); return sks; } catch (Exception e) { return null; } }
     *
     * public String encriptar(String cadenaEncriptar){
     *
     * try { SecretKeySpec sks = crearLlave(LLAVE); Cipher cipher =
     * Cipher.getInstance("AES"); cipher.init(Cipher.ENCRYPT_MODE, sks);
     *
     * byte[] cadena = cadenaEncriptar.getBytes("UTF-8"); byte[] encriptada =
     * cipher.doFinal(cadena); String cadenaEncriptada =
     * Base64.encode(encriptada);
     *
     * return cadenaEncriptada; } catch (Exception e) { return ""; }
     *
     * }
     *
     *
     * public static String encrypt(String secretKey, String password, byte[]
     * initialVector) { try { Cipher cipher = Cipher.getInstance("AES");
     * SecretKeySpec sks = new SecretKeySpec(secretKey.getBytes("UTF-8"),
     * "AES"); cipher.init(Cipher.ENCRYPT_MODE, sks, new
     * IvParameterSpec(initialVector));
     *
     * byte[] encrypted = cipher.doFinal(password.getBytes("UTF-8"));
     *
     * String resultado = DatatypeConverter.printBase64Binary(encrypted); return
     * resultado; } catch (Exception e) {
     *
     * }
     *
     * return null; }
     *
     * private String decrypt(String secretKey, String encrypted, byte[]
     * initialVector) { try { Cipher cipher =
     * Cipher.getInstance("AES/CBC/PKCS5PADDING"); SecretKeySpec sks = new
     * SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");
     * cipher.init(Cipher.DECRYPT_MODE, sks, new
     * IvParameterSpec(initialVector));
     *
     * byte[] decrypted =
     * cipher.doFinal(DatatypeConverter.parseBase64Binary(encrypted)); return
     * new String(decrypted);
     *
     * } catch (Exception e) {
     *
     * }
     *
     * return null; }
     *
     *
     *
     */
}
