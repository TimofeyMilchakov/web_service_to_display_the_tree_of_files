<%--
  Created by IntelliJ IDEA.
  User: ttt
  Date: 20.08.2017
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./content/font-awesome-4.7.0/css/font-awesome.css">
    <style>
        li {
            list-style-type: none;
        }
    </style>
    <script src="./scripts/jquery.min.js"></script>
    <script src="scripts/myFunction.js"></script>
    <title>$Title$</title>
</head>
<body>
<script>getFiestFolder()</script>
<div>
    <button onclick="addNewFolder()">добавить папку</button>
    <button onclick="deleteFolder()">удалить папку</button>
    <button onclick="renameFolder()">изменить имя папки</button>
    <button onclick="powerButton()" id="moveButton">переместить выбранную папку</button>
</div>
<div>
    имя папки:<input type="text" size="30" value="" name="name" id="inputBox" >
</div>
<div id="fF"></div>




</body>
</html>
