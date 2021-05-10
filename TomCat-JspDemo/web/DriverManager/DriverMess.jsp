<%@ page import="org.Daolevel.DriverDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.Info.DriverCarMess" %>
<%--
  Created by IntelliJ IDEA.
  User: wq
  Date: 18-6-27
  Time: 上午12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <br>
    <br>
    <title>司机信息查询界面</title>
    <style rel="stylesheet" type="text/css">

        .select1{
            position: absolute;
            left: 2.7cm;
        }
        .form{
            position: absolute;
            top: 4.4cm;
            left: 100px;
        }
        .addition{
            position: absolute;
            left: 20.6cm;
        }
        .cancel{
            position: absolute;
            left: 23cm;
        }

        #main_table{
            float: left;
            table-layout: fixed;/*使table的宽度固定*/
            width: 850px;/*给table一个宽度*/
        }
        .opt{
            width: 3cm;
        }
        .telephone{
            width: 3cm;
        }
        .carid{
            width: 3cm;
        }
    </style>

    <script>
        function del(pid) {
            if(confirm("确定删除吗？")){
                document.forms[1].id.value = pid;
                document.forms[1].submit();
                return true;
            }else {
                return false;
            }
        }

        function addition() {
            self.location = "RegisterCar.html";
        }

        function cancel() {
            self.location = "Manager.html";
        }

        function edit(pid) {
            console.log(pid);
            document.forms.item(1).id.value = pid;
        }

    </script>
</head>
<% DriverDao driverDao = DriverDao.getNewIntences();
    ArrayList driverlist = driverDao.selectDriver();%>
<body background="/img/timg.jpg">

<h1 align="center">司机信息</h1>


<form>
    <div class="select1">
        <select name="select2" style="height: 22px">
            <option>--请选择--</option>
            <option value="id">工号</option>
            <option value="car_owner">姓名</option>
            <option value="age">年龄</option>
            <option value="gender">性别</option>
            <option value="address">家庭住址</option>
            <option value="cat_type">车辆类型</option>
            <option value="drive_time">驾车时间</option>
            <option value="register_time">录入时间</option>
        </select>
        <input type=text id=searchName1 name=searchName   autocomplete="off"/>
        <input type="submit" formaction="showdriver.jsp" value='查询' />
    </div>
</form>
    <div class="addition" id="addition">
        <input  type="submit" value='新增' onclick="addition()" />
    </div>

    <div class="cancel" id="cancel">
        <input  type="submit" value='取消' onclick="cancel()" />
    </div>



<form class="form" action="/DriverMess" method="post" >
    <input  type="hidden" id="id" name="id">

    <table id="main_table" border="" cellpadding="2"  cellspacing="0" bgcolor="" width="100%">

    <tr>
        <td><small>工号</small></td>
        <td><small>姓名</small></td>
        <td><small>年龄</small></td>
        <td><small>性别</small></td>
        <td class="telephone"><small>联系方式</small></td>
        <td><small>家庭住址</small></td>
        <td class="carid"><small>车牌号</small></td>
        <td><small>车辆类型</small></td>
        <td><small>驾车时间</small></td>
        <td><small>录入时间</small></td>
        <td align="center" class="opt"><small>操作</small></td>
    </tr>
        <%
            for (int i = 0; i < driverlist.size(); i++) {
                DriverCarMess driver =(DriverCarMess) driverlist.get(i);%>
    <tr >
        <td><small><%=driver.getOwner_id()%></small></td>
        <td><small><%=driver.getCar_owner()%></small></td>
        <td><small><%=driver.getOwner_age()%></small></td>
        <td><small><%=driver.getGender()%></small></td>
        <td><small><%=driver.getTele_num()%></small></td>
        <td><small><%=driver.getOwner_dress()%></small></td>
        <td><small><%=driver.getCar_id()%></small></td>
        <td><small><%=driver.getCar_type()%></small></td>
        <td><small><%=driver.getDrive_time()%></small></td>
        <td><small><%=driver.getRegister_date()%></small></td>
        <td>
            <input type="submit"  value="修改"  formaction="UpDate.jsp" formmethod="post" onclick="return edit('<%=driver.getOwner_id()%>')"/>
            <input type="submit"  value="删除" onclick="return del('<%=driver.getId()%>')"/>
        </td>
    </tr>
    <%}%>
</table>
</form>
</body>
</html>
