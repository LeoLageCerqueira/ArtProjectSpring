<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Create Contact</h1>
<form:form 
    method="POST" 
    action="/create-user"
    enctype = "multipart/form-data"
    >
    <table>
        
        <tr>
            <td>Nome: </td>
            <td><form:input path="nome"/></td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Telefone: </td>
            <td><form:input  path="telefone"/></td>
        </tr>
        <tr>
            <td>CEP: </td>
            <td><form:input path="cep"/></td>
        </tr>
        <tr>
            <td>Foto: </td>
            <td><form:input path="fileUrl" type="file"          
                /></td>                         
        </tr>        
        <tr>
            <td><input type="submit"/></td>
        </tr>
    </table>
</form:form>
