<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- Coding By CodingNepal - codingnepalweb.com -->
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Principle Page</title>
  <!-- CSS -->
  <link href="../css/insertstyle.css" rel="stylesheet">
  <!-- Boxicons CSS -->
  <link href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css" rel="stylesheet">
  <style>
    /* Google Fonts - Poppins */
    @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap");
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;900&display=swap');

    body, html {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: "Poppins", sans-serif;
      width: 100%;
      height: 100%;
      overflow: hidden;
    }

    body {
      display: flex;
      justify-content: center;
      align-items: center;
      background: #ecf0f3;
    }

    nav {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 70px;
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
      font-size: 24px;
      cursor: pointer;
      margin-right: 14px;
    }

    .logo .logo-name {
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
      background: #fff;
      box-shadow: 0 5px 1px rgba(0, 0, 0, 0.1);
      transition: all 0.4s ease;
    }

    nav.open .sidebar {
      left: 0;
    }

    .sidebar-content {
      display: flex;
      flex-direction: column;
      height: 100%;
      justify-content: space-between;
      padding: 30px 16px;
    }

    .lists {
      list-style: none;
    }

    .nav-link {
      display: flex;
      align-items: center;
      margin: 8px 0;
      padding: 14px 12px;
      border-radius: 8px;
      text-decoration: none;
      color: #707070;
    }

    .nav-link:hover {
      background-color: #4070f4;
      color: #fff;
    }

    .icon {
      margin-right: 14px;
      font-size: 20px;
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

    .container {
      width: 100%;
      max-width: 600px;
      padding: 30px;
      background: #fff;
      border-radius: 8px;
      box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
      display: flex;
      flex-direction: column;
      align-items: center;
    }

    .brand-title {
      font-size: 1.8rem;
      font-weight: 900;
      color: #1DA1F2;
      letter-spacing: 1px;
      margin-bottom: 20px;
    }

    form {
      width: 100%;
      display: flex;
      flex-direction: column;
    }

    label {
      font-weight: bold;
      margin-bottom: 8px;
    }

    input[type="text"], select, input[type="file"] {
      padding: 10px;
      margin-bottom: 20px;
      border: 1px solid #ddd;
      border-radius: 4px;
      font-size: 16px;
      background: #ecf0f3;
    }

    button {
      padding: 12px 20px;
      background: #1DA1F2;
      color: #fff;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
      transition: background 0.3s;
    }

    button:hover {
      background: #1c2dab;
    }

    .bx-plus-circle {
      display: block;
      margin: 10px auto;
    }

    @keyframes slideRight {
      from {
        transform: translateX(-100%);
        opacity: 0;
      }
      to {
        transform: translateX(0);
        opacity: 1;
      }
    }
  </style>
</head>
<body>
 <% String message = (String)request.getAttribute("message"); %>
    <% if (message != null && !message.isEmpty()) { %>
        <div class="message">
            <%= message %>
        </div>
    <% } %>
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
          <li class="list"><a href="home2.html" class="nav-link"><i class="bx bx-home-alt icon"></i><span class="link">Home</span></a></li>
          <li class="list"><a href="insert.html" class="nav-link"><i class="bx bxs-file"></i><span class="link">Insert Document</span></a></li>
          <li class="list"><a href="select.html" class="nav-link"><i class="bx bxs-file selected-icon"></i><span class="link">Select Document</span></a></li>
          <li class="list"><a href="update.html" class="nav-link"><i class="bx bx-edit"></i><span class="link">Update Document</span></a></li>
          <li class="list"><a href="delete.html" class="nav-link"><i class="bx bx-trash"></i><span class="link">Delete Document</span></a></li>
          <li class="list"><a href="#" class="nav-link"><i class="bx bx-folder-open icon"></i><span class="link">Files</span></a></li>
        </ul>
        <div class="bottom-content">
          <li class="list"><a href="#" class="nav-link"><i class="bx bx-cog icon"></i><span class="link">Settings</span></a></li>
          <li class="list"><a href="home.html" class="nav-link"><i class="bx bx-log-out icon"></i><span class="link">Logout</span></a></li>
        </div>
      </div>
    </div>
    <div class="overlay"></div>
  </nav>
  <div class="container">
    <div class="brand-title">Insert Document</div>
    <form id="uploadForm" action="upload.do" method="post" enctype="multipart/form-data">
      <label for="patientId">Patient ID:</label>
      <input type="text" id="patientId" name="patientId" required>
      <label for="description">Description:</label>
      <input type="text" id="description" name="description" required>
      <label for="fileType">File Type:</label>
      <select class="select" id="fileType" name="fileType" required>
        <option value="excel">Monitoring</option>
        <option value="pdf">Report</option>
        <option value="png">Image</option>
      </select>
      <label for="fileUpload">Select a file:</label>
      <input type="file" id="fileUpload" name="fileUpload" required>
    <input type="submit" class="submit" value="Submit">
    </form>
  </div>
  <script>
    function submitForm() {
      var patientId = document.getElementById("patientId").value;
      var fileType = document.getElementById("fileType").value;
      var fileInput = document.getElementById("fileUpload");
      var file = fileInput.files[0];
      var filePath = file ? file.name : "No file selected";

      // Do whatever you want with the patient ID, file type, and file path
      console.log("Patient ID:", patientId);
      console.log("File Type:", fileType);
      console.log("File Path:", filePath);
      // You can send this information to a server via an AJAX request, for example
    }

    const menuBtns = document.querySelectorAll(".menu-icon");
    const navBar = document.querySelector("nav");
    const overlay = document.querySelector(".overlay");

    menuBtns.forEach(menuBtn => {
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