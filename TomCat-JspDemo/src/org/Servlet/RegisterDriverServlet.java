package org.Servlet;

import org.Jdbc.DataDase;

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
 * Date: 18-6-25 下午8:34
 */
@WebServlet(name = "RegisterDriverServlet")
public class RegisterDriverServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
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
        System.out.println(owner_id + "   " + car_owner + "    " + owner_age + "    " + gender + "   " + tele_num + "   " + owner_dress + "   " +
                drive_time + "   " + register_date + "    " + car_id + "    " + car_type);
        String insertsql = "insert into driver_car_mess (owner_id,car_owner,gender,tele_num,owner_dress,drive_time," +
                "register_date,car_id,car_type,owner_age) values(?,?,?,?,?,?,?,?,?,?)";
        DataDase database = new DataDase();
        Connection conn;
        conn = database.getConn();
        int res = 0;
        try {
            PreparedStatement pst = conn.prepareStatement(insertsql);
            pst.setString(1, owner_id);
            pst.setString(2, car_owner);
            pst.setString(3, gender);
            pst.setString(4, tele_num);
            pst.setString(5, owner_dress);
            pst.setString(6, drive_time);
            pst.setString(7, register_date);
            pst.setString(8, car_id);
            pst.setString(9, car_type);
            pst.setString(10, owner_age);
            res = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter prt = response.getWriter();
        if (res != 0) {
            prt.println("<script>alert('Successful');" +
                    "window.location.href='/DriverManager/Manager.html';</script>");
            prt.flush();
        } else {
            prt.println("<script>alert('Fail,Please Register Again');" + "window.location.href='/DriverManager/RegisterCar.html';</script>");
            prt.flush();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
