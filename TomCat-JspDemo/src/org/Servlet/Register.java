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
 * Date: 18-6-24 下午10:18
 */
@WebServlet(name = "Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter prt = response.getWriter();
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        String cancel = request.getParameter("cancel");
        if(!cancel.equals("取消")){
            if (user == null || pwd == null) {
                prt.println("<script language='javascript'>alert('user or password is null !');"
                        + "window.location.href='index.jsp';</script>");
            } else {
                user = user.trim();
                pwd = pwd.trim();
                String sql = "insert into count_pwd (type,count,pwd) values ('" + 2 + "','" + user + "','" + pwd + "')";
                System.out.println(sql);
                boolean res;


                DataDase dataDase = new DataDase();
                res = dataDase.insert(sql);
                response.setContentType("text/html;charset=utf-8");
                if (res) {
                    prt.println("<script>alert('Successful,log again');" +
                            "window.location.href='index.jsp';</script>");
                    prt.flush();
                } else {
                    prt.println("<script language='javascript'>alert('Fail,Register again');"
                            + "window.location.href='Register.jsp';</script>");
                    prt.flush();
                }
                prt.close();
            }
        }else {
            //prt.println("<script>"+"window.location.href='index.jsp';</script>");
            response.sendRedirect("index.jsp");
            //prt.flush();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
