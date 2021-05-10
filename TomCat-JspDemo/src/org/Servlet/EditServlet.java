package org.Servlet;

import org.Daolevel.DriverDao;
import org.Jdbc.DataDase;
import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Author:WangQian
 * Date: 18-7-4 下午4:41
 */
@WebServlet(name = "EditServlet")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String owner_id = request.getParameter("owner_id");//工号
        String car_owner = request.getParameter("car_owner");//获取车主姓名
        String owner_age = request.getParameter("owner_age");//车主年龄
        String gender = request.getParameter("gender");//获取车主性别
        if (gender.equals("0")) {
            gender = "male";
        } else {
            gender = "female";
        }
        String tele_num = request.getParameter("tele_num").trim();//获取车主电话
        String owner_dress = request.getParameter("owner_dress").trim();//获取家庭住址
        String drive_time = request.getParameter("drive_time").trim();//获取车主车龄
        String register_date = request.getParameter("register_date").trim();//获取车主注册时间
        String car_id = request.getParameter("car_id").trim();//车牌
        String car_type = request.getParameter("car_type").trim();//车型
        /*接到数据,写入数据库*/
        System.out.println("     "+id+"    "+owner_id + "   " + car_owner + "    " + owner_age + "    " + gender + "   " + tele_num + "   " + owner_dress + "   " +
                drive_time + "   " + register_date + "    " + car_id + "    " + car_type);
        String updatesql = "update driver_car_mess set owner_id = '"+owner_id+
                "',car_owner = '"+car_owner+"',gender = '"+gender+"',tele_num = '"
                +tele_num+"',owner_dress= '"+owner_dress+"',drive_time= '"+drive_time+"'," +
                "register_date = '"+register_date+"',car_id = '"+car_id+
                "',car_type = '"+car_type+"',owner_age = '"+owner_age+"' where id = '"+id+"';";
        System.out.println(updatesql);


        DriverDao driverdao = DriverDao.getNewIntences();
        boolean flag =  driverdao.editDriver(updatesql);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter prt = response.getWriter();
        if (flag) {
            prt.println("<script>alert('Successful');" +
                    "window.location.href='/DriverManager/DriverMess.jsp';</script>");
            prt.flush();
        } else {
            prt.println("<script>alert('Fail,Please Edit Again');" + "window.location.href='/DriverManager/DriverMess.jsp';</script>");
            prt.flush();

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
