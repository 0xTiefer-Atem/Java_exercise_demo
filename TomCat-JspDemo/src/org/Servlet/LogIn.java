package org.Servlet;

import org.Info.CountAndPwd;
import sun.rmi.server.Dispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "LogIn")
public class LogIn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String user = request.getParameter("user").trim();
        String pwd = request.getParameter("pwd").trim();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset = utf-8");
        PrintWriter prt = response.getWriter();
        try {
            CountAndPwd countAndPwd = new CountAndPwd();
            HashMap<String,String> counthash = countAndPwd.getCounthash();
            HashMap<String,String> typehash = countAndPwd.getTypehash();
                if (counthash.containsKey(user)) {
                    if (counthash.get(user).equals(pwd)) {
                        String persontype = typehash.get(pwd);
                        switch(persontype){
                            case "1" :response.sendRedirect("/DriverManager/Manager.html");break;//1类型为车辆负责人
                            case "2" :response.sendRedirect("/User/User.html");break;//2类型为约车客户
                            default:prt.println("<script language='javascript'>alert('用户不存在请注册!');" +
                                    "window.location.href='Register.jsp';</script>");
                                prt.flush();
                        }

                    } else {
                        prt.println("<script language='javascript'>alert('密码错误');" +
                                "window.location.href='index.jsp';</script>");
                        prt.flush();
                    }
                } else {
                    prt.println("<script language='javascript'>alert('用户不存在请注册!');" +
                            "window.location.href='Register.jsp';</script>");
                    prt.flush();
                }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
