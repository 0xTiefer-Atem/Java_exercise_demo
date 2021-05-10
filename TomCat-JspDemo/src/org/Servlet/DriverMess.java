package org.Servlet;

import org.Daolevel.DriverDao;
import org.Info.DriverCarMess;
import org.Jdbc.DataDase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Author:WangQian
 * Date: 18-6-27 上午12:56
 */
@WebServlet(name = "DriverMess")
public class DriverMess extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset = utf-8");
        PrintWriter prt = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        DriverDao driverdao = DriverDao.getNewIntences();
        boolean flag = driverdao.removeDriver(id);
        if(flag){
            response.sendRedirect("/DriverManager/DriverMess.jsp");
        }else{
            prt.println("<script language='javascript'>alert('Fail,Delete again');"
                    + "window.location.href='/DriverManager/DriverMess.jsp';</script>");
            prt.flush();
        }
        prt.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
