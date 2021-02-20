<%--
  Created by IntelliJ IDEA.
  User: 97694
  Date: 2020/12/26
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style type="text/css">
      img{
        width: 200px;
        height: 170px;
      }
      .imgs{
        float: left;
        width: 220px;
      }
    </style>
  </head>
  <body>
  <h1>欢迎光临网上图库</h1>
  <form action="uploadpic" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username">
    图片：<input type="file" name="pic">
    <input type="submit" value="上传">
  </form>
  <hr/>
  <div>
    <div class="imgs">
      <img src="pics/1.jpg">
    </div>

    <div class="imgs">
      <img src="pics/1.jpg">
    </div>

    <div class="imgs">
      <img src="pics/1.jpg">
    </div>

    <div class="imgs">
      <img src="pics/1.jpg">
    </div>

  </div>
  </body>
</html>
