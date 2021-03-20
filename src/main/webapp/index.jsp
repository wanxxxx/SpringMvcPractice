<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button").click(function () {
                $.ajax({
                    url:"returnVoid.do",
                    data:{
                        username:"fangxi",
                        password:"123",
                    },
                    type:"post",
                    dataType:"json",
                    success:function (resp) {
alert(resp)
                    }
                })
            })
        })

    </script>
</head>
<body>
<p>提交参数</p>
    <form action="user/register.do" method="post">
        用户名：<input type="text" name="username">
        密码：<input type="text" name="password">
        <p><input type="submit" value="注册"></p>
    </form>

    <p>返回String</p>
    <form action="user/returnString.do" method="post">
        用户名：<input type="text" name="username">
        密码：<input type="text" name="password">
        <p><input type="submit" value="注册"></p>
    </form>
    <p>返回void</p>
    <button id="btn">发起ajax请求</button>

</body>
</html>
