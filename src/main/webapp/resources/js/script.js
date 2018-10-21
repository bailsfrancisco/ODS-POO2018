/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateLogin(){
    var email = document.forms["form"]["email"].value;
    expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if(email === ""){
        alert("El email es obligatorio!");
        return false;
    }else{
        if( !expr.test(email)){
            alert("El email es incorrecto!");
            return false;
        }   
    }
    var password = document.forms["form"]["password"].value;
    regex = /^(?=.*\d)(?=.*[a-záéíóúüñ]).*[A-ZÁÉÍÓÚÜÑ]/;
    if(password === ""){
        alert("La password es obligatoria!");
        return false;
    }else{
        if(password.length < 8 || !(regex.test(password))){
            alert("El password es incorrecto!");
            return false;
        }
    }
    
    //Falta validar si el email es valido y que la contraseña tenga al menos 8 caracteres
}