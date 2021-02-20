<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: 97694
  Date: 2020/12/8
  Time: 下午9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--根据不同的区域信息，将这个页面动态显示出来--%>
<%--
    1.获取当前浏览器带来的区域信息
    2.使用ResourceBundle管理国际化资源文件
    3.动态获取配置文件中的值
--%>
<%
    String locale = request.getHeader("Accept-Language").split(",")[0];
    String[] loc = locale.split("-");
//    1.获取当前浏览器带来的区域信息
    Locale newLoc = new Locale(loc[0], loc[1]);
    //2.使用ResourceBundle管理国际化资源文件
    ResourceBundle bundle = ResourceBundle.getBundle("bookstore", newLoc);
    //3.动态获取配置文件中的值
    String username = bundle.getString("username");
    String password = bundle.getString("password");
    String loginBtn = bundle.getString("loginBtn");
%>
<form action="">
    <%=username %>:<input/><br/>
    <%=password %>:<input/><br/>
    <input type="submit" value="<%=loginBtn %>">
</form>
</body>
</html>
