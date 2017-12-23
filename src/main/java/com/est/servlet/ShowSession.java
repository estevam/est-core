/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author estevam
 */
@SuppressWarnings("serial")
public class ShowSession extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
// create function for check if user and pass word exist
// if user exist with password  -->  HttpSession session = req.getSession(true);         
        resp.setContentType("text/html");

        //Get session object
        HttpSession session = req.getSession(true);
        // session.setAttribute("username", username);
        String id = session.getId();

        StringBuffer requestURL = req.getRequestURL(); //returns the part of the full URL before query string separator character ?
        String queryString = req.getQueryString();//returns the part of the full URL after query string separator character ?

        if (queryString == null) {
            System.out.println(requestURL.toString());
        } else {
            System.out.println(requestURL.append('?').append(queryString).toString());
        }

 
		String scheme = req.getScheme();             // http
        String serverName = req.getServerName();     // hostname.com
        int serverPort = req.getServerPort();        // 80
        String contextPath = req.getContextPath();   // /mywebapp
        String servletPath = req.getServletPath();   // /servlet/MyServlet
        String pathInfo = req.getPathInfo();         // /a/b;c=123

        
        System.out.println(scheme+" "+serverName+" "+ serverPort+ " "+ contextPath + " "+ servletPath +" "+pathInfo );
        
        PrintWriter out;
        String title = "Session play";

        // then write the data of the response
        out = resp.getWriter();

        out.println("<html><head><title>");
        out.println(title);
        out.println(id);
        out.println("</title></head><body>");
        out.println("<h1>" + title + "</h1>");

        if (session.isNew()) {
            out.println("<p>Welcome new comer</p>");
            out.println("<p>" + id + "</p>");
        } else {
            out.println("<p>Welcome back</p>");
            out.println("<p>" + id + "</p>");
        }

        out.println("<form action=SessionPlay method=get>");
        out.println("<input type=input name=param1>");
        out.println("<input type=submit>");
        out.println("</form>");

        out.println("</body></html>");
        out.close();

    }

    @SuppressWarnings("unused")
	private void doLogout(HttpServletRequest req) {
        HttpSession sess = req.getSession(false);
        if (sess != null) {
            sess.invalidate();
        }
    }
}
