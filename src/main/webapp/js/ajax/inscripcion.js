/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function descargarArchivo(e) {
    e.preventDefault();
    string1 = document.getElementById("documento").value;
    string2 = document.getElementById("convocatoria").value;

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
            var fileName = req.getResponseHeader("filename"); //if you have the fileName header available
            var link = document.createElement('a');
            link.href = window.URL.createObjectURL(blob);
            link.download = fileName;
            link.click();
        } else {
            //O sea, este if es inútil hasta que me deshaga del try-catch del link que está 
            //Atendiendo esta request.
            document.getElementById("resultado").innerHTML = "Hubo un error";

        }


    };

    req.open("GET", "../../descArchivo?documento=" + string1 + "&convocatoria=" + string2);
//req.open("get","../Busqueda?documento="+string1);
//https://stackoverflow.com/questions/9713058/send-post-data-using-xmlhttprequest
    req.send();
}

function inscripcionConvocatoria(e) {
    e.preventDefault();
    let formData = new FormData();
    formData.append("documento", document.getElementById("documento").value);
    formData.append("convocatoria", document.getElementById("convocatoria").value);
    formData.append("archivo", document.getElementById("ajaxfile").files[0]);
    //console.log(formData);

    // Puro debug
    //console.log(formData.get("archivo"));

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

    //req.open("post", "../resp/respInscripcion.jsp");
    //req.open("post",'respuestas/debug.jsp');
    //
    //TUVE QUE UTILIZAR UN SERVLET PARA ESTO. NO ENCONTRÉ UNA FORMA DE SOLUCIONAR ESTE PROBLEMA SIN USAR UN SERVLET
    //https://www.moreofless.co.uk/unable-process-parts-no-multi-part-configuration-provided/
    req.open("POST", "../../regInscripcion");
    req.send(formData);
}

// Función de arriba en AJAX, pero escrita en JQuery, para futura referencia
//function inscripcionConvocatoria(e) {
//    $('#subir_archivo').submit(
//            function (e) {
//                e.preventDefault();
//                var formData = new FormData();
//                formData.append("documento", document.getElementById("documento").value);
//                formData.append("convocatoria", document.getElementById("convocatoria").value);
//                formData.append("archivo", document.getElementById("ajaxfile").files[0]);
//
//                $.ajax({
//                    type: "POST",
//                    enctype: 'multipart/form-data',
//                    url: "../../regInscripcion",
//                    data: formData,
//                    processData: false,
//                    contentType: false,
//                    cache: false,
//                    timeout: 800000,
//                    success: function (response) {
//
//                        $("#resultado").html(response);
//
//                    }/*,
//                     error: function (e) {
//                     
//                     $("#output").text(e.responseText);
//                     console.log("ERROR : ", e);
//                     $("#btnSubmit").prop("disabled", false);
//                     
//                     }*/
//                });
//
//            }
//    );
//}


