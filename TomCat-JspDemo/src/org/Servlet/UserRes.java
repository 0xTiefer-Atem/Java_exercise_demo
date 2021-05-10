package org.Servlet;

import org.Jdbc.DataDase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:WangQian
 * Date: 18-7-10 下午11:18
 */
@WebServlet(name = "UserRes")
public class UserRes extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String tele_num = request.getParameter("tele_num");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        System.out.println(name+"   "+tele_num+"   "+start+"  "+end);
        DataDase dt = new DataDase();
        String insert_user = "insert into user_res (name,tele_num,start,end) values('"+name+"','"+tele_num
                +"','"+start+"','"+end+"')";
        boolean flag = dt.insert(insert_user);
        PrintWriter prt = response.getWriter();
        if(flag){
            prt.println("<script>var flag = confirm(ok,again?);" +
                    "if(flag){" +
                    "    self.location = /User/UserRes.jsp;" +
                    "}else {" +
                    "    self.location = /User/User.html;" +
                    "}</script>");
            prt.flush();
        }else {
            prt.println("<script>var flag = confirm(fail,again?);" +
                    "if(flag){" +
                    "    self.location = /User/UserRes.jsp;" +
                    "}else {" +
                    "    self.location = /User/User.html;" +
                    "}</script>");
            prt.flush();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
