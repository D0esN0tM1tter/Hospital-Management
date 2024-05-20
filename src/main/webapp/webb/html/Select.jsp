<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.jee.Models.Document" %>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="../css/styledocument.css">
</head>
<body>
 
    <nav>
      <div class="logo">
        <i class="bx bx-menu menu-icon"></i>
        <span class="logo-name">Docshere</span>
      </div>
      <div class="sidebar">
        <div class="logo">
          <i class=" bx bx-menu menu-icon"></i>
          <span class="logo-name">Docshere</span>
        </div>

        <div class="sidebar-content">
          <ul class="lists">
            <li class="list">
              <a href="page home.html" class="nav-link">
                <i class="bx bx-home-alt icon"></i>
                <span class="link">Home</span>
              </a>
            </li>
            <li class="list">
              <a href="insert.jsp" class="nav-link">
                <i class="bx bxs-file"></i>
                <span class="link">Insert Document</span>
              </a>
            </li>
            <li class="list">
              <a href="select.html" class="nav-link">
                <i class="bx bxs-file selected-icon"></i>
                <span class="link">Select Document</span>
              </a>
            </li>
            <li class="list">
              <a href="#" class="nav-link">
                <i class="bx bx-edit"></i>
                <span class="link">Update Document</span>
              </a>
            </li>
            <li class="list">
              <a href="delete.html" class="nav-link">
                <i class="bx bx-trash"></i>
                <span class="link">Delete Document</span>
              </a>
            </li>
        
            <li class="list">
              <a href="#" class="nav-link">
                <i class="bx bx-folder-open icon"></i>
                <span class="link">Files</span>
              </a>
            </li>
          </ul>

          <div class="bottom-cotent">
            <li class="list">
              <a href="#" class="nav-link">
                <i class="bx bx-cog icon"></i>
                <span class="link">Settings</span>
              </a>
            </li>
            <li class="list">
              <a href="#" class="nav-link">
                <i class="bx bx-log-out icon"></i>
                <span class="link">Logout</span>
              </a>
            </li>
          </div>
        </div>
      </div>
    </nav>
    <div class="container">
        <h1>Liste des Documents</h1>
        <table>
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
                <form action="SelectDocument.do" method="post">
                    <input type="hidden" name="documentId" value="<%= document.getId() %>" />
                    <button type="submit">select</button>
                </form>
            </td>
        </tr>
       <%
                }
            } 
        %>
        </table>
    </div>
    <section class="overlay"></section>

    <script>
        const navBar = document.querySelector("nav"),
       menuBtns = document.querySelectorAll(".menu-icon"),
       overlay = document.querySelector(".overlay");

     menuBtns.forEach((menuBtn) => {
       menuBtn.addEventListener("click", () => {
         navBar.classList.toggle("open");
       });
     });

     overlay.addEventListener("click", () => {
       navBar.classList.remove("open");
     });
    </script>
 

</body>
</html>