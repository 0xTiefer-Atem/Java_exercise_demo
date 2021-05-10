<%@ page import="org.Info.User" %>
<%@ page import="org.Daolevel.UserDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.Daolevel.DriverDao" %>
<%@ page import="org.Info.DriverCarMess" %><%--
  Created by IntelliJ IDEA.
  User: wq
  Date: 18-7-7
  Time: 下午1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>负责人查看预约信息</title>

    <style type="text/css" rel="stylesheet">
        .user_font{
            position: absolute;
            left: 280px;
        }
        .user{
            position: absolute;
            top: 160px;
            left: 260px;
        }

        .driver_font{
            position: absolute;
            left: 650px;
        }
        .driver{
            top: 160px;
            position: absolute;
            left: 500px;
        }
    </style>
</head>
<body background="/img/timg.jpg">

<% UserDao userDao = UserDao.getnewInstance();
    ArrayList<User> userlist = userDao.getUserlist();
    DriverDao driverDao = DriverDao.getNewIntences();
    ArrayList driverlist = driverDao.selectDriver();%>
<br>
<br>
<br>
<br>
<br>
<div class="user_font">
    <h2 style="left: 260px">用户预约信息</h2>
</div>
<div class="driver_font">
    <h2 align="right">司机信息</h2>
</div>
<div class="user">
<table align="left" border="1">
    <tr>
        <td><small>姓名</small></td>
        <td><small>电话</small></td>
        <td><small>出发地</small></td>
        <td><small>目的地</small></td>

    </tr>
    <%
        for (User user: userlist) {%>
    <tr>
        <td><small><%=user.getName()%></small></td>
        <td><small><%=user.getTele_num()%></small></td>
        <td><small><%=user.getStart()%></small></td>
        <td><small><%=user.getEnd()%></small></td>
    </tr>
    <%}%>
</table>
</div>


<div class="driver">
<table align="right" id="main_table" border="" cellpadding="2"  cellspacing="0">

    <tr>
        <td><small>工号</small></td>
        <td><small>姓名</small></td>
        <td><small>性别</small></td>
        <td class="telephone"><small>联系方式</small></td>
        <td class="carid"><small>车牌号</small></td>
        <td><small>车辆类型</small></td>
        <td><small>驾车时间</small></td>
    </tr>
    <%
        for (int i = 0; i < driverlist.size(); i++) {
            DriverCarMess driver =(DriverCarMess) driverlist.get(i);%>
    <tr >
        <td><small><%=driver.getOwner_id()%></small></td>
        <td><small><%=driver.getCar_owner()%></small></td>
        <td><small><%=driver.getGender()%></small></td>
        <td><small><%=driver.getTele_num()%></small></td>
        <td><small><%=driver.getCar_id()%></small></td>
        <td><small><%=driver.getCar_type()%></small></td>
        <td><small><%=driver.getDrive_time()%></small></td>
    </tr>
    <%}%>
</table>
</div>
</body>
</html>
