<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/26 0026
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="starter-template">
    <h2>健康管理系统</h2>
    <form name="form"  action="/login" method="POST"> <!-- 3 -->

        <label >账号</label>
        <input type="text" class="form-control" name="username" value="" placeholder="账号" />
        <br/>

        <label >密码</label>
        <input type="password" class="form-control" name="password" placeholder="密码" />


        <br/>
        <img alt="验证码" onclick = "this.src='/defaultKaptcha?d='+new Date()*1" src="/defaultKaptcha" />
        <input type="text"  name="vrifyCode" placeholder="验证码" style="height: 20px;width: 80px;"  />
        <br/>

        <input type="submit" id="login" value="登录"  />
        <a  href="/pages/user/useradd.jsp"  >用户注册</a>

    </form>



</div>
</body>
</html>
