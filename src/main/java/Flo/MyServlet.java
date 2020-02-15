package Flo;

import java.io.*;

import javax.servlet.*;

import javax.servlet.http.*;



public class MyServlet extends HttpServlet {

 private final String  LOGIN_CORRECT = "HWD1";
 private final String  PASS_CORRECT = "HWD1";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n=request.getParameter("username");
        String p=request.getParameter("userpass");

        if(LOGIN_CORRECT.equals(n)&&PASS_CORRECT.equals(p)){
            RequestDispatcher rd=request.getRequestDispatcher("servlet2");
            rd.forward(request,response);
        }
        else{

            RequestDispatcher rd=request.getRequestDispatcher("index.html");
            rd.include(request,response);
            out.print("<div class=\"box3\">Username or password are not correct<div>");
        }

        out.close();

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        processRequest(request, response);

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        processRequest(request, response);

    }

}