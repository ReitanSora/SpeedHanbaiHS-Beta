let toggle = document.querySelector(".toggle");
let main = document.querySelector(".main");
let sidebar = document.querySelector(".sidebar-admin-primary");

toggle.onclick = function(){
    sidebar.classList.toggle("active");
    main.classList.toggle("active");
}