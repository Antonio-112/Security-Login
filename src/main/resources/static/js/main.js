document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("formulario").addEventListener('submit', validarFormulario);
});

function validarFormulario(evento) {
    evento.preventDefault();
    emailRegex = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i
        ;
    var email = document.getElementById('email').value;
    if (email.length == 0) {
        alert('No has escrito nada en el email');
        return;
    }

    const username = document.getElementById('username');
    if(username.length == 0){
        alert("No has escrito nada en el usuario");
    }
    if (!(emailRegex.test(email))) {
        alert('Email invalido');
        return;
    }
    var clave = document.getElementById('password').value;
    if (clave.length < 6) {
        alert('La clave no es válida');
        return;
    }
    var clave2 = document.getElementById('repeat-password').value;
    if(clave === clave2){
        alert('Las contraseñas no coinciden');
        return;
    }
    this.submit();
}