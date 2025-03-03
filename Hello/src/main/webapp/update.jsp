<%@ page import="com.pojo.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User Details</title>
<style>
body {
    background-image: url('https://images.unsplash.com/photo-1521587760476-6c12a4b040da?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8bGlicmFyeXxlbnwwfHwwfHx8MA%3D%3D'); 
    background-size: cover;
    background-position: center;
    font-family: Arial, sans-serif;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 0;
}

.container {
    background: white;
    padding: 25px;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
    width: 350px;
    text-align: center;
}

.container h2 {
	
    color: black;
    text-align: center;
}

label {
    font-weight: bold;
    display: block;
    text-align: left;
    margin-top: 10px;
}

input {
    width: 100%;
    padding: 10px;
    margin-top: 5px;
    border: 2px solid #ccc;
    border-radius: 25px;
    outline: none;
    font-size: 14px;
    transition: border 0.3s;
}

input:focus {
    border-color: #007bff;
}

input[type="submit"] {
    background-color: black;
    color: white;
    border: none;
    padding: 10px 15px;
    font-size: 16px;
    cursor: pointer;
    border-radius: 25px;
    margin-top: 15px;
    transition: background 0.3s;
}

input[type="submit"]:hover {
    background-color: grey;
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

<% Emp emp_obj=(Emp)request.getAttribute("user"); %>
<div class="navbar ">
    <span class="fw-bold">📚 Library Management</span>
    <a href="index.html" class="text-white" style="text-decoration: none; font-size: 24px;">
        🏠
    </a>
</div>
<div class="container">
    <h2>Update User Details</h2>
    <form action="Update" method="post">
        <input type="hidden" name="id" value="<%= emp_obj.getId()%>" /> 

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<%= emp_obj.getName()%>" required/><br/><br/>

        <label for="dept">Department:</label>
        <input type="text" id="dept" name="dept" value="<%= emp_obj.getDept()%>" required/><br/><br/>

        <label for="clg">Roll-No:</label>
        <input type="text" id="clg" name="clg" value="<%= emp_obj.getClg()%>" required/><br/><br/>

        <input type="submit" value="Update User"/>
    </form>
</div>

</body>
</html>
