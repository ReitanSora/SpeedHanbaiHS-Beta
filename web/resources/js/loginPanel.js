
const container = document.querySelector(".card-container");
const registerBtn = document.querySelector("#register");
const loginBtn = document.querySelector("#login");


registerBtn.addEventListener('click', () => {
    container.classList.add("active");
});

loginBtn.addEventListener('click', () => {
    container.classList.remove("active");
});
/*
 * 
 
 var items = document.getElementsByClassName("sidebar-nav-item").length;
 for (let i = 0; i < items; i++) {
 window["linkBtn" + i.toString()] = document.querySelector('#link-sidebar-' + i.toString());
 }
 for (let j = 0; j < items; j++) {
 console.log(j);
 window["listItem" + j.toString()] = document.querySelector("#sidebar-item-" + j.toString());
 }
 
 
 
 linkBtn0.addEventListener('click', () => {
 console.log("0");
 });
 
 linkBtn1.addEventListener('click', () => {
 console.log("1");
 });
 
 for (var k = 0; k < items; k++) {
 window["linkBtn" + k.toString()].addEventListener('click', () => {
 console.log(window["listItem" + k.toString()]);
 window["listItem" + k.toString()].classList.add("active");
 });
 }
 */

