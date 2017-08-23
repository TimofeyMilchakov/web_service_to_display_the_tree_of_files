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
    <script src="./scripts/jquery.min.js"></script>
    <script>
      function getSubfolders(nameFolder,idFolder) {
        $.post("folder",{
          data:"qweqwe2"
        }).done(function (response) {
          $("#"+ idFolder).html(response)
        })


      }

    </script>
    <title>$Title$</title>
  </head>
  <body>
  <div id="testAjax"></div>
  <script>getSubfolders("qewqwe","fefe")</script>
  <i class="fa fa-folder-open" aria-hidden="true" id="fefe"></i>

  </body>
</html>
