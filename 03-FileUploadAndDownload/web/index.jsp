<%--
  Created by IntelliJ IDEA.
  User: 97694
  Date: 2020/12/16
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>欢迎光临</title>
  </head>
  <body>
  <form action="upload2" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"><br/>
    头像：<input type="file" name="headering"/><br/>
    <input type="submit" value="上传">

  </form>
  </body>
</html>
