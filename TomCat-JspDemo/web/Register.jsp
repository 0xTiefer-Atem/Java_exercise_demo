<%--suppress JSAnnotator --%>
<%--
  Created by IntelliJ IDEA.
  User: wq
  Date: 18-6-24
  Time: 下午10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding = "gb2312"  language="java" %>


<html>
<head>
    <title>注册界面</title>
    <style rel="stylesheet" type="text/css">
        .cancel{
            position: absolute;
            top: 7.3cm;
            left: 16.5cm;

        }

        .submit{
            position: absolute;
        }

        .reset{
            position: absolute;
            left: 13.9cm;
        }
    </style>

    <script>
        function cancel() {
            var flag = confirm("是否取消注册?");
            if(flag){
                self.location="index.jsp"
            }
        }
    </script>

</head>
<body background="/img/timg.jpg">
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<h2 align="center">注册页面</h2>
<form action="/Register" method="post">
    <table align="center">
        <tr>
            <td width="66" height="20"><small>用户名:</small></td>
            <td width="115" height="20">
            <input type="text" id="user" name="user" autocomplete="off">
            </td>
        </tr>
        <tr>
            <td width="66" height="20"><small>密码:</small></td>
            <td width="115" height="20">
            <input type="text" id="pwd" name="pwd" autocomplete="off">
            </td>
        </tr>

        <tr align="center">
            <td height="20" colspan="" >
                <div class="submit">
                    <input type="submit" id="submit" value="确定" >
                </div>
            </td>
            <td height="20" colspan="" >
                <div class="reset">
                    <input type="reset" id="reset" value="重置">
                </div>
            </td>
        </tr>
    </table>
</form>

<div class="cancel">
    <input type="button" id="cancel" name="cancel"  value="取消" onclick="cancel()">
</div>
</body>
</html>
