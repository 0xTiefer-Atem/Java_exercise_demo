<%--
  Created by IntelliJ IDEA.
  User: wq
  Date: 18-7-7
  Time: 下午1:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户约车界面</title>

    <style rel="stylesheet" type="text/css">
        .submit1{
            position: absolute;
            top: 8.9cm;
            left: 10.7cm;

        }

        .cancel{
            position: absolute;
            left: 17.2cm;
        }
    </style>

    <script>
        function cancel() {
            var flag = confirm("是否取消预约?");
            if(flag){
                self.location = "User.html";
            }
        }


        function doValidata() {
            var phoneNumReg = /^1[3|4|5|7|8][0-9]{9}$/;
            <!--表示以1开头，第二位可能是3/4/5/7/8等的任意一个，在加上后面的\d表示数字[0-9]的9位，总共加起来11位结束。-->
            var is_phone = document.getElementById("tele_num");
            var phone = is_phone.value;

            if (phoneNumReg.test(phone)) {
                return true;
            } else {
                alert('手机号码有误，请重填，手机号码11位数字，目前支持前两位13、14、15、16、17、18手机号码');
                return false;
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
    <h1 align="center">用户约车</h1>
<form action="/UserRes" method="post" onsubmit="return doValidata()">
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
    <div class="cancel">
        <button type="submit" id="cancel" value="取消" onclick="cancel()">取消</button>
    </div>
</body>
</html>
