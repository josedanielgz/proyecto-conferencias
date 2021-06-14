/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// https://stackoverflow.com/questions/20800763/how-to-send-json-data-to-server-using-ajax
function registrar(e) {
    e.preventDefault();
    var objectData =
            {
                documento: document.getElementById('documento').value,
                primer_nombre: document.getElementById('primer_nombre').value,
                primer_apellido: document.getElementById('primer_apellido').value,
                fecha_nacimiento: document.getElementById('fecha_nacimiento').value,
                correo_electronico: document.getElementById('correo').value,
                clave: document.getElementById('clave').value,
            };
//es_admin: document.getElementById("es_admin").checked
    var objectDataString = JSON.stringify(objectData);
    // console.log(objectDataString);


    $.ajax({
        type: "POST",
        url: "../../regUsuario",
        dataType: "json",
        data: {
            data: objectDataString
        },
        success: function (data) {
            alert(data.msj);
            window.location.replace("../..");

        },
        error: function () {
            alert('Error: ' + data.msj);
        }
    });

}

function iniciarSesion(e) {
    e.preventDefault();
    //console.log("El botón funciona");

    var usuario = document.getElementById("usuario").value;
    var clave = document.getElementById("clave").value;

    var req;

    if (window.XMLHttpRequest)
    {
        req = new XMLHttpRequest();
    } else
    {
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }

    req.onreadystatechange = function () {
        if ((req.readyState === 4) && (req.status === 200)) {
            //Puro debug
            //console.log("Sirvió existosamente");
            document.getElementById("resultado").innerHTML = req.responseText;
        }
    };

    req.open("GET", "../../iniciarSesion?usuario=" + usuario + "&clave=" + clave);
    req.send();

}