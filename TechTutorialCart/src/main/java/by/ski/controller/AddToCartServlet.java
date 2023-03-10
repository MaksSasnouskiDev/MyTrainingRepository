package by.ski.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.ski.model.Cart;

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");

		try (PrintWriter out = response.getWriter()) {
			out.println("Servlet toCart called</br>");
			ArrayList<Cart> cartList = new ArrayList<>();
			int id = Integer.parseInt(request.getParameter("id"));
			Cart cm = new Cart();
			cm.setId(id);
			cm.setQuantity(1);

			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute(
				"cart-list");
			if(cart_list==null) {
				cartList.add(cm);			
				out.println("Session created and added to Attrs</br>");
			}else {
				out.println("Cart list already exists</br>");
				cartList=cart_list;
				boolean exist=false;
				for(Cart cart:cartList) {
					if(cart.getId()==id) {
						exist=true;
						out.println("product already exists in Cart</br>");
						cart.setQuantity(cart.getQuantity()+1);
						break;
					}
				}
				if(!exist) {
					cartList.add(cm);
				}
			}				
			session.setAttribute("cart-list", cartList);
			out.println(cartList);
			out.println("</br>");
			out.println("<a href='index.jsp'>Go to products</a>");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
