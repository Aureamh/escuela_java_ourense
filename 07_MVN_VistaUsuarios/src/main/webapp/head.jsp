<%-- 
    Document   : head
    Created on : 21-feb-2019, 20:45:25
    Author     : IEUser
--%>

<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--Para declarar funciones se hace así <%! --%>
<%--le faltaba añadir a lo de abajo la línea del (+ "<title>...)POSIBLE EXAMEN --%>

<%!
    String head() {  
        return "<head><meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"UTF-8\"/>"
                + "<title>Aplicación Gestión Usuarios MVC JSP</title></head>";
    } 
%>