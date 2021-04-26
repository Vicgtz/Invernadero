<%-- 
    Document   : Registrar Sensor
    Created on : 26/04/2021, 03:13:45 AM
    Author     : AnaCastillo

    Página JSP para registrar un sensor.
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
                Registrar Sensor
            </h1>
            <div>
                
                <form id="formulario">
                    <p>Ingresa los datos del sensor a registrar</p>
                    <br>
                    <p>ID Sensor:</p>
                    <input id="sensor" class="obligaorio" name="idSensor" min="1" max="1000000" placeholder="Ej.1"  type="number" required/>
                    <br>
                    <p>Invernadero:</p>
                    <input id="invernadero" class="obligaorio" name="invernadero" type="text" placeholder="Ej.Hortalizas" required/>
                    <br>
                    <p>Marca:</p>
                    <input id="marca" class="obligaorio" name="marca" type="text" placeholder="Ej.AgroBio" required/>
                    <br><br>
                    <button id="boton" type="button"  onclick="registrar()">Registrar</button>
                    <button id="boton" type="reset"  onclick="limpirar()">Restaurar</button>
                </form>
            </div>
        </section>
        <%-- Incluye el pir de pagina --%>
        <%@include file="jspf/piePagina.jspf"%>
    </body>
</html>
