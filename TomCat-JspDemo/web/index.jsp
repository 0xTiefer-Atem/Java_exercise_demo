<%--
  Created by IntelliJ IDEA.
  User: wq
  Date: 18-4-15
  Time: 下午11:27
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登陆界面</title>
  <style rel="stylesheet" type="text/css">
    .submit{
      position: absolute;
      left:11.75cm;
    }
    .reset{
      position: absolute;
      left: 15.95cm;
    }

  </style>
</head>
<body background="/img/timg.jpg">

<form action="/LogIn" method="post">
    <table align="center">
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <h3 align="center">用车管理系统</h3>
      <tr>
        <td width="66" height="20" class="login_td">用户名:</td>
        <td width="115" height="20" class="login_td">
          <input class="login_input" type="text" name="user" autocomplete="off">
        </td>
      </tr>
      <tr>
        <td height="20" class="login_td">密码:</td>
        <td height="20" class="login_td">
          <input type="password" name="pwd" class="login_input">
        </td>
        <td class="login_td" align="left" width=71>
          <a href="Register.jsp"> <small>新用户注册</small></a>
        </td>
      </tr>
      <tr>
        <td height="20" colspan="2" align="center">
          <div class="submit">
          <input type="submit"  id="submit" value="登录" class="login_button" alt="notnull"/>
          </div>
          <div class="reset">
            <input type="reset" value="重置" class="login_button" alt="notnull"/>
          </div>
        </td>
      </tr>
    </table>
</form>



</body>
</html>
