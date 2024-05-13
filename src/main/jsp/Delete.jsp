<%@page import="com.jee.Models.Document" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Documents</title>
</head>
<body>
    <h1>Liste des Documents</h1>
    <table border="1">
        <tr>
            <th>Nom du Document</th>
             <th>la date de creation</th>
            <th>Action</th>
        </tr>
        <% 
            List<Document> documents = (List<Document>) request.getAttribute("documents");
            if (documents != null) {
                for (Document document : documents) {
        %>
        <tr>
            <td><%= document.getDescription()%></td>
             <td><%= document.getToc()%></td>
            <td>
                <form action="bouton.delete" method="post">
                    <input type="hidden" name="documentId" value="<%= document.getId() %>" />
                    <button type="submit">Supprimer</button>
                </form>
            </td>
        </tr>
        <% 
                }
            } 
        %>
    </table>
</body>
</html>
