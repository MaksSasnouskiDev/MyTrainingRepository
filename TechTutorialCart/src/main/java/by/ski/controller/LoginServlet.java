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

@WebServlet(urlPatterns = "/user-login", loadOnStartup = 0)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("login.jsp");

//		RequestDispatcher rd=request.getRequestDispatcher("/jsp/welcome.jsp");
//		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("email");
			String psw = request.getParameter("psw");

			DBCon dbCon = new DBCon();
			try {
				UserDao userDao = new UserDao(dbCon.getConnection());
				User user = userDao.userLogin(email, psw);

				if (user != null) {
					System.out.println("user login success");
					HttpSession session= request.getSession();
					session.setAttribute("auth", user);
					response.sendRedirect("welcome.jsp");
					
				} else {
					out.print("user login failed");
				}

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
