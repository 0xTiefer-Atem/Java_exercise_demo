<%--
  Created by IntelliJ IDEA.
  User: wq
  Date: 18-7-7
  Time: 下午2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>预约结果</title>
</head>
<body background="/img/timg.jpg">
<h2 align="center">预约结果</h2>
<form>
    <table align="center">
        <tr>
            <td>请输入具体信息</td>
        </tr>
        <tr>
            <td><small>姓名:</small></td>
            <td><input type="text" id="name" name="name" autocomplete="false"></td>
        </tr>
        <tr>
            <td><small>联系方式:</small></td>
            <td><input type="text" id="tele_num" name="tele_num" autocomplete="false"></td>
        </tr>
        <tr>
            <td><small>出发地:</small></td>
            <td><input type="text" id="start" name="start" autocomplete="false"></td>
        </tr>
        <tr>
            <td><small>目的地:</small></td>
            <td><input type="text" id="end" name="end" autocomplete="false"></td>
        </tr>
        <tr>
            <td>
                <div class="submit1">
                    <input type="submit" id="submit" value="确认">
                </div>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
