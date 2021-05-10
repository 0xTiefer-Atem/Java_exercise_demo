<%@ page import="org.omg.CORBA.INTERNAL" %>
<%@ page import="org.Daolevel.DriverDao" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="org.Info.DriverCarMess" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: wq
  Date: 18-7-4
  Time: 下午3:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>司机信息修改页面</title>
    <script>

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

        function cancel() {
            var is_return = confirm("是否取消修改?");
            if (is_return) {
                self.location = "DriverMess.jsp";
                return false;
            }
        }

    </script>
    <style rel="stylesheet">
        .cancel{
            position: absolute;
            left: 20.8cm;
            top: 7.7cm;

        }
    </style>
</head>

<body background="/img/timg.jpg">
<%  String id = request.getParameter("id");
    DriverDao dr = DriverDao.getNewIntences();
    System.out.println(id);
    DriverCarMess driverMess = dr.getDriver(id);
    PrintWriter prt = response.getWriter();
    if(driverMess == null){
        prt.println("<script>alert('DriverMess is null');" +
                "window.location.href='DriverMess.jsp';</script>");
        prt.flush();
    }
%>
<form action="/EditServlet" method="post" onsubmit="return doValidata()">
    <h1 align="center">司机信息修改</h1>
    <table align="center">
        <tr><td>修改个人信息</td></tr>
        <tr>
            <td>
                <input type="hidden" id="id" name="id" value="<%=driverMess.getId()%>">
                <small>工号:</small>
            </td>
            <td>
                <input type="text" id="owner_id" name="owner_id" value="<%=driverMess.getOwner_id()%>" autocomplete="off">
            </td>
            <td>
                <small style="margin-left: 0.5cm">车主姓名:</small>
            </td>
            <td>
                <input type="text" id="car_owner" name="car_owner" value="<%=driverMess.getCar_owner()%>"  autocomplete="off">
            </td>
        </tr>
        <tr>

            <td><small>车主年龄:</small></td>
            <td>
                <input type="text" id="owner_age" name="owner_age" value="<%=driverMess.getOwner_age()%>" autocomplete="off">
            </td>
            <td><small style="margin-left: 0.5cm">性别选择:  </small></td>
            <td>
                <%if(driverMess.getGender().equals("male")){%>
                    <input id="r1" type="radio" value="0" name="gender" checked><small>男</small></input>
                    <input id="r2" type="radio" value="1" name="gender"><small>女</small></input>
                <%}else {%>
                <input id="r1" type="radio" value="0" name="gender"><small>男</small></input>
                <input id="r2" type="radio" value="1" name="gender" checked><small>女</small></input>
                <%}%>
            </td>
        </tr>
        <tr>
            <td>
                <small>车辆负责人联系方式:</small>
            </td>
            <td>
                <input type="text" id="tele_num" name="tele_num" value="<%=driverMess.getTele_num()%>" autocomplete="off">
            </td>
            <td>
                <small style="margin-left: 0.5cm">家庭住址:</small>
            </td>
            <td>
                <input type="text" id="owner_dress" name="owner_dress" value="<%=driverMess.getOwner_dress()%>" autocomplete="off">
            </td>
        </tr>
        <tr>
            <br><br>
        </tr>
        <tr>
            <td>修改车辆信息</td>
        </tr>
        <tr>
            <td>
                <small>车牌号:</small>
            </td>
            <td>
                <input type="text" id="car_id" name="car_id" value="<%=driverMess.getCar_id()%>" autocomplete="off">
            </td>
            <td>
                <small style="margin-left: 0.5cm">车辆类型:</small>
            </td>
            <td>
                <input type="text" id="car_type" name="car_type" value="<%=driverMess.getCar_type()%>" autocomplete="off"><br>
            </td>
        </tr>

        <tr>
            <td>
                <small>驾车时间:</small>
            </td>
            <td>
                <input type="text" id="drive_time" name="drive_time"  value="<%=driverMess.getDrive_time()%>" autocomplete="off">
            </td>

            <td>
                <small style="margin-left: 0.5cm">录入时间:</small>
            </td>
            <td>
                <input type="text" name="register_date"  value="<%=driverMess.getRegister_date()%>" autocomplete="off">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" align="center" id="submit" value="确认">
            </td>
        </tr>
    </table>
</form>
<div class="cancel" id="cancel">
    <button type="submit"  id="exit" name="exit" onclick="cancel()">返回</button>
</div>

</body>
</html>
