<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
<title>Read Users</title>
<link href="webjars/bootstrap/4.6.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Users</h1>
<div class="container">
<table class="table table-striped">>
    <tr>
        
        <th>Nome</th>
        <th>Email</th>
        <th>Telefone</th>
        <th>CEP</th>
        <th>Foto</th>
        <th>Endereço</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.nome}</td>
            <td>${user.email}</td>            
            <td>${user.telefone}</td>
            <td>${user.cep}</td>
            <td>${user.fileUrl}</td>
            <td>${user.cepUser}</td>
            <td><a href="/update-user/${user.email}">Update</a></td>
            <td><a href="/delete-user/${user.email}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<div>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.6.1/js/bootstrap.min.js"></script>
<br/>
<a href="/create-user">Create User</a>
</body>
