/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function descargarCSV(e) {
    
    e.preventDefault();
    var req;

    if (window.XMLHttpRequest)
    {
        req = new XMLHttpRequest();
    } else
    {
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }

    req.responseType = "blob";
    req.onload = function (event) {

        //Para debuggear
        //alert("Sirvió existosamente");

        //Dato curioso: capturar las excepciones en el backend impide que se puedan
        //arrojar un status diferente por causa de un error en el servidor.
        if (req.status === 200) {
            var blob = req.response;
            //var fileName = req.getResponseHeader("filename"); //if you have the fileName header available
            var link = document.createElement('a');
            link.href = window.URL.createObjectURL(blob);
            link.download = "archivo.csv";
            link.click();
        } else {
            //O sea, este if es inútil hasta que me deshaga del try-catch del link que está 
            //Atendiendo esta request.
            document.getElementById("resultado").innerHTML = "Hubo un error";

        }


    };

    req.open("GET", "../../convocatoriasCSV");
//req.open("get","../Busqueda?documento="+string1);
//https://stackoverflow.com/questions/9713058/send-post-data-using-xmlhttprequest
    req.send();
}