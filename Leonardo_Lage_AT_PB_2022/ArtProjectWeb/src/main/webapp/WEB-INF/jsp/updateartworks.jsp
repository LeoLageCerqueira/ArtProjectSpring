<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Update Art</h1>
<form:form method="post" 
           enctype = "multipart/form-data"
           action="/update-artworks/${id}">
    <table>               
        <tr>
            <td>Nome: </td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Preço: </td>
            <td><form:input path="price"/></td>
        </tr>        
        <tr>
            <td>Foto: </td>
            <td><form:input path="photo" type="file"/></td>
        </tr>   
        <tr>
            <td>Artista: </td>
            <td><form:input path="artist"/></td>
        </tr>       
        <tr>
            <td></td>
            <td><input type="submit" value="Update" /></td>
        </tr>
    </table>
</form:form>
