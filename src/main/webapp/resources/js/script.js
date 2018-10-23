/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateLogin(){
    var email = document.forms["form"]["email"].value;
    if(email === ""){
        alert("El email es obligatorio!");
        return false;
    }
    var password = document.forms["form"]["password"].value;
    if(password === ""){
        alert("La password es obligatoria!");
        return false;
    }
    
    //Falta validar si el email es valido y que la contraseña tenga al menos 8 caracteres
}