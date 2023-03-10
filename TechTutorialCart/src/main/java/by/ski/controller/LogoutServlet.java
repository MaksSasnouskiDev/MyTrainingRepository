package by.ski.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.ski.connection.DBCon;
import by.ski.dao.UserDao;
import by.ski.model.User;

@WebServlet(urlPatterns = "/log-out", loadOnStartup = 0)
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		
		try (PrintWriter out = response.getWriter()) {
			if(request.getSession().getAttribute("auth")!=null){
				request.getSession().removeAttribute("auth");
				response.sendRedirect("login.jsp");
			}else {
				response.sendRedirect("index.jsp");
			}
			
		}

	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		}	
}
