<%@ page import="org.Daolevel.DriverDao" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="org.Info.DriverCarMess" %>
<%@ page import="org.Servlet.DriverMess" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: wq
  Date: 18-7-11
  Time: 上午9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人查询信息</title>
    <script>
        function del(pid) {
            if(confirm("确定删除吗？")){
                document.forms.item(0).id.value = pid;
                document.forms[1].submit();
                return true;
            }else {
                return false;
            }
        }

        function edit(pid) {
            console.log(pid);
            document.forms.item(0).id.value = pid;
        }

        function return1() {
            self.location="DriverMess.jsp";
        }
    </script>
</head>
<body background="/img/timg.jpg">
<h1 align="center"></h1>
<%  String key = (String)request.getParameter("select2");
    String value = request.getParameter("searchName");
    System.out.println(key+"==========="+value);
    DriverDao dao = DriverDao.getNewIntences();
    ArrayList<DriverCarMess> dcmslist = dao.getDrivermesseslist(key,value);
%>

<br>
<br>
<br>
<br>
<h1 align="center">司机信息</h1>
<br>
<form class="form" action="/DriverMess"  method="post">
<table border="" align="center">
    <input  type="hidden" id="id" name="id">
    <tr>
        <td><small>工号</small></td>
        <td><small>姓名</small></td>
        <td><small>年龄</small></td>
        <td><small>性别</small></td>
        <td><small>联系方式</small></td>
        <td><small>家庭住址</small></td>
        <td><small>车牌号</small></td>
        <td><small>车辆类型</small></td>
        <td><small>驾车时间</small></td>
        <td><small>录入时间</small></td>
        <td align="center"><small>操作</small></td>
    </tr>
    <%
        for (DriverCarMess dcms: dcmslist) {%>
    <tr>

        <td><small><%=dcms.getOwner_id()%></small></td>
        <td><small><%=dcms.getCar_owner()%></small></td>
        <td><small><%=dcms.getOwner_age()%></small></td>
        <td><small><%=dcms.getGender()%></small></td>
        <td><small><%=dcms.getTele_num()%></small></td>
        <td><small><%=dcms.getOwner_dress()%></small></td>
        <td><small><%=dcms.getCar_id()%></small></td>
        <td><small><%=dcms.getCar_type()%></small></td>
        <td><small><%=dcms.getDrive_time()%></small></td>
        <td><small><%=dcms.getRegister_date()%></small></td>
        <td>
            <input type="submit"  value="修改"  formaction="UpDate.jsp" onclick="return edit('<%=dcms.getOwner_id()%>')"/>
            <input type="submit"  value="删除" onclick="return del('<%=dcms.getOwner_id()%>')"/>
        </td>
        <%}%>
    </tr>
</table>
</form>
<div>
    <input type="button" value="返回" onclick="return1()"></input>
</div>
</body>
</html>
