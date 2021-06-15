<%--
  Created by IntelliJ IDEA.
  User: kangt
  Date: 2021-6-11
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="user/testString">testString</a><br/>
<a href="user/testVoid">testVoid</a><br/>
<a href="user/testModelAndView">testModelAndView</a><br/>
<a href="user/testForwardOrRedirect">testForwardOrRedirect</a><br/>
<button id="btn">发送Ajax请求</button>
</body>
<script type="text/javascript">
    //页面加载绑定单击事件
    $(function () {
        $("#btn").click(function () {
            //alert("hello btn");
            //发送ajax请求
            $.ajax({
                //编写json格式，设置属性和值；
                url:"user/testAjax",
                contentType:"application/json;charset=UTF-8",
                data:'{"username":"Jack","password":"123","age":30}',
                dataType:"json",
                type:"post",
                success:function (data) {
                    //data服务器端响应的json的数据，进行解析
                    alert(data);
                    alert(data.username);
                    alert(data.password);
                }
            });
        });
    });
</script>

</html>
