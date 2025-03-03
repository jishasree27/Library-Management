<%@ page import="com.pojo.Emp" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

    <style>
        body {
             background-image: url('https://images.unsplash.com/photo-1521587760476-6c12a4b040da?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8bGlicmFyeXxlbnwwfHwwfHx8MA%3D%3D'); /* Replace with your image URL */
	        background-size: cover;
	        background-position: center;
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 80px;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #343a40;
        }
        a {
            text-decoration: none;
        }
        .table {
            text-align: center;
            margin-top: 20px;
        }
        .table th {
            background-color: brown;
            color: white;
        }
        .table tr:hover {
            background-color: #f1f1f1;
        }
        .btn {
            padding: 5px 10px;
            font-size: 14px;
        }
        .btn-update {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 5px 10px;
            border-radius: 5px;
        }
        .btn-update:hover {
            background-color: #218838;
        }
        .btn-delete {
            background-color: #dc3545;
            color: white;
            border: none;
            padding: 5px 10px;
            border-radius: 5px;
        }
        .btn-delete:hover {
            background-color: #c82333;
        }
        .add-user {
            text-align: center;
            margin-top: 10px;
        }
        .add-user a {
            color: #007bff;
            font-weight: bold;
        }
              .navbar {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        background-color: brown;
        padding: 15px 0;
        color: white;
        font-size: 24px;
        font-weight: bold;
    }
    </style>
</head>
<body>
<div class="navbar ">
    <span class="fw-bold">📚 Library Management</span>
    <a href="index.html" class="text-white" style="text-decoration: none; font-size: 24px;">
        🏠
    </a>
</div>

    <div class="container">
        <h1>View Users</h1>
        
        <div class="add-user">
            <a href="index.html">➕ Add More Users</a>
        </div>

        <% 
            List<Emp> empList = (List<Emp>) request.getAttribute("empList");
            if (empList != null && !empList.isEmpty()) {
        %>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Department</th>
                    <th>College</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% for(Emp mp : empList) { %>
                <tr>
                    <td><%= mp.getId() %></td>
                    <td><%= mp.getName() %></td>
                    <td><%= mp.getDept() %></td>
                    <td><%= mp.getClg() %></td>
                    <td>
                        <a href="Update?id=<%= mp.getId() %>" class="btn btn-update">✏ Update</a>
                        <a href="Delete?id=<%= mp.getId() %>" class="btn btn-delete">🗑 Delete</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        
        <% } else { %>
            <p class="text-center text-danger">No users found.</p>
        <% } %>
    </div>

</body>
</html>
