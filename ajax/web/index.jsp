<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 97694
  Date: 2020/11/17
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="webContent/js/jquery-3.5.1.min.js"></script>
    <%
        pageContext.setAttribute("ctp",request.getContextPath());
    %>
</head>
<body>
$END$
<%=new Date()%>
<a href="getInfo" id="aBtn">获取信息</a>
<div id="haha">
    显示信息:
        ${msg}
</div>
</body>
<script type="text/javascript">
    // 一个复杂的js对象
    var student = {
        lastName: "张三",
        age: 18,
        car: {
            pp: "宝马",
            price: "30000$"
        },
        infos: [{
            bookName: "西游记",
            price: 98.98
        }, 18, true]
    };
    //js对象：属性操作特别方便
    // alert(student.car.pp); //宝马
    // alert(student.infos[2]); //true
    // alert(student);

    //JSON的要求是和js对象是一样的，只不过key必须是字符串
    //js对象在声明的时候key是否加双引号是可以选择的
    var student2 = {
        "lastName": "张三",
        "age": 18
    };
    // alert(student2);
    // alert(typeof student2);
    //JSON(js内置的对象)：将js对象转为json(应该是js对象字符串表示法)字符串
    var strJSON = JSON.stringify(student2);
    // alert(strJSON);
    // alert(typeof strJSON);
</script>

<script type="text/javascript">
<%--1. $.get --%>
    $("#aBtn").click(function () {
        //$.get(url, [data], [callback], [type])
        //[]代表这个参数可以不用传递
        //data：传递的数据："k=b&k=v"  传递一个js对象：会自动转为k1=v1&k2=v2
        //callback：定义一个回调函数，随便定义一个参数，这个参数就封装了服务器返回的数据
        //type: 返回的数据类型，可以不写，自动判断
        //type：返回内容格式，xml, html, script, json, text, _default
        $.get("${ctp}/getInfo", {lastName: "张三", age: 18}, function (abc) {
            //abc代表服务器给我们的数据，如果服务器转发到一个页面，data代表整个页面
            // alert(abc);
            $("#haha").append(abc);
        });
        return false;
    })
</script>


</html>
