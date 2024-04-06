
const container = document.querySelector(".card-container");
const registerBtn = document.querySelector("#register");
const loginBtn = document.querySelector("#login");

registerBtn.addEventListener('click', () => {
    container.classList.add("active");
    console.log("Agregado");
});

loginBtn.addEventListener('click', () => {
    container.classList.remove("active");
    console.log("Eliminado");
});