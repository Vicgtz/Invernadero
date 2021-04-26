<%-- 
    Document   : index
    Created on : 26/04/2021, 03:13:45 AM
    Author     : AnaCastillo

    Página JSP principal de la aplicación Web. Despliega el menú de opciones.
--%>

<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <title>Green House Garden</title>
    </head>
    <body>
        <header>
            <div id="encabezado">
                <div>
                    <img src="img/logo.png" width=160 height=100> 
                    <div id="menu">
                        <%-- Incluye el menu principal --%>
                        <%@include file="jspf/menu.jspf"%>
                    </div>
                </div>
            </div> 
        </header>
        <section>
            <br>
            <h1 id="titulo">
                ¡Bienvenidos!
                <p >
                    <img src="img/sensor.png" width=301 height=205> 
                </p>
            </h1>
            <p id="contendido">
                Previene y recoge información en tiempo real con los sensores para 
                invernaderos, teniendo la capacidad de programar alarmas para obter 
                la temperatura y humedad así como los indices en estadisticas de las mismas.
            </p>
        </section>
        <%-- Incluye el pir de pagina --%>
        <%@include file="jspf/piePagina.jspf"%>
    </body>
</html>
