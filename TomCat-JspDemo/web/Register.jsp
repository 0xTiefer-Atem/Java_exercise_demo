<%--suppress JSAnnotator --%>
<%--
  Created by IntelliJ IDEA.
  User: wq
  Date: 18-6-24
  Time: ����10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding = "gb2312"  language="java" %>


<html>
<head>
    <title>ע�����</title>
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
            var flag = confirm("�Ƿ�ȡ��ע��?");
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
<h2 align="center">ע��ҳ��</h2>
<form action="/Register" method="post">
    <table align="center">
        <tr>
            <td width="66" height="20"><small>�û���:</small></td>
            <td width="115" height="20">
            <input type="text" id="user" name="user" autocomplete="off">
            </td>
        </tr>
        <tr>
            <td width="66" height="20"><small>����:</small></td>
            <td width="115" height="20">
            <input type="text" id="pwd" name="pwd" autocomplete="off">
            </td>
        </tr>

        <tr align="center">
            <td height="20" colspan="" >
                <div class="submit">
                    <input type="submit" id="submit" value="ȷ��" >
                </div>
            </td>
            <td height="20" colspan="" >
                <div class="reset">
                    <input type="reset" id="reset" value="����">
                </div>
            </td>
        </tr>
    </table>
</form>

<div class="cancel">
    <input type="button" id="cancel" name="cancel"  value="ȡ��" onclick="cancel()">
</div>
</body>
</html>
