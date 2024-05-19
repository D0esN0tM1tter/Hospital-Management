<%@ page import="com.jee.Models.Document" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Liste des Documents</title>
    <link rel="stylesheet" href="css/style.css" />
    <!-- Boxicons CSS -->
    <link href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/boxicons/2.0.7/css/boxicons.min.css" rel="stylesheet">
    <style>
        /* Include your CSS styles here */
        body {
            min-height: 100vh;
            background-image: url('img.jpg');
            background-size: cover;
            background-position: center;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
            height: 100%;
            width: 100%;
        }
        nav {
            position: fixed;
            top: 0;
            left: 0;
            height: 70px;
            width: 100%;
            display: flex;
            align-items: center;
            background: #fff;
            box-shadow: 0 0 1px rgba(0, 0, 0, 0.1);
        }
        nav .logo {
            display: flex;
            align-items: center;
            margin: 0 24px;
        }
        .logo .menu-icon {
            color: #333;
            font-size: 24px;
            margin-right: 14px;
            cursor: pointer;
        }
        .logo .logo-name {
            color: #333;
            font-size: 22px;
            font-weight: 500;
        }
        nav .sidebar {
            position: fixed;
            top: 0;
            left: -100%;
            height: 100%;
            width: 260px;
            padding: 20px 0;
            background-color: #fff;
            box-shadow: 0 5px 1px rgba(0, 0, 0, 0.1);
            transition: all 0.4s ease;
        }
        nav.open .sidebar {
            left: 0;
        }
        .sidebar .sidebar-content {
            display: flex;
            height: 100%;
            flex-direction: column;
            justify-content: space-between;
            padding: 30px 16px;
        }
        .sidebar-content .list {
            list-style: none;
        }
        .list .nav-link {
            display: flex;
            align-items: center;
            margin: 8px 0;
            padding: 14px 12px;
            border-radius: 8px;
            text-decoration: none;
        }
        .lists .nav-link:hover {
            background-color: #4070f4;
        }
        .nav-link .icon {
            margin-right: 14px;
            font-size: 20px;
            color: #707070;
        }
        .nav-link .link {
            font-size: 16px;
            color: #707070;
            font-weight: 400;
        }
        .lists .nav-link:hover .icon,
        .lists .nav-link:hover .link {
            color: #fff;
        }
        .overlay {
            position: fixed;
            top: 0;
            left: -100%;
            height: 100vh;
            width: 100%;
            opacity: 0;
            pointer-events: none;
            transition: all 0.4s ease;
            background: rgba(0, 0, 0, 0.3);
        }
        nav.open ~ .overlay {
            opacity: 1;
            left: 260px;
            pointer-events: auto;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #dddddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f2f2f2;
        }
        button {
            padding: 5px 10px;
            background-color: #007bff;
            color: #ffffff;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <nav>
        <div class="logo">
            <i class="bx bx-menu menu-icon"></i>
            <span class="logo-name">Docshere</span>
        </div>
        <div class="sidebar">
            <div class="logo">
                <i class="bx bx-menu menu-icon"></i>
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
                        <a href="insert.html" class="nav-link">
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
                <div class="bottom-content">
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
        <table border="1">
            <tr>
                <th>Identificateur</th>
                <th>Titre</th>
                <th>Date de création</th>
                <th>Action</th>
            </tr>
            <%
                List<Document> documents = (List<Document>) request.getAttribute("documents");
                for (Document doc : documents) {
            %>
            <tr>
                <td><%= doc.getId() %></td>
                <td><%= doc.getTitle() %></td>
                <td><%= doc.getCreationDate() %></td>
                <td>
                    <form action="selectDocument.do" method="post">
                        <input type="hidden" name="documentId" value="<%= doc.getId() %>" />
                        <button type="submit">Selectionner</button>
                    </form>
                </td>
            </tr>
            <%
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
