<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
<title>Read Artworks</title>
<link href="webjars/bootstrap/4.6.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Artworks</h1>
<div class="container">
<table class="table table-striped">>
    <tr>
        
        <th>Id</th>
        <th>Nome</th>
        <th>Preço</th>
        <th>Foto</th>
        <th>Artista</th>
        
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="artwork" items="${artworks}">
        <tr>
            <td>${artwork.id}</td>
            <td>${artwork.name}</td>            
            <td>${artwork.price}</td>
            <td>${artwork.photo}</td>
            <td>${artwork.artist}</td>
            
            <td><a href="/update-artworks/${artwork.id}">Update</a></td>
            <td><a href="/delete-artworks/${artwork.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<div>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.6.1/js/bootstrap.min.js"></script>
<br/>
<a href="/create-artwork">Create Artworks</a>
</body>