package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Shop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession currentSession = request.getSession();
		initBasketForSession(currentSession);
		
		ArrayList<String> basket = (ArrayList<String>) currentSession.getAttribute("basket");
		String orderedItem = request.getParameter("item");
		if (orderedItem != null) {
			basket.add(orderedItem);
			
			String basketPageHTML = generateHtmlFromBasket(basket);
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter output = response.getWriter();
			output.println(basketPageHTML);
		}
	}
	
	protected void initBasketForSession(HttpSession session) {
		if (session.getAttribute("basket") == null) {
			session.setAttribute( "basket", new ArrayList<String>() );
		}
	}
	
	protected String generateHtmlFromBasket(ArrayList<String> basket) {
		StringBuilder pageHTML = new StringBuilder( 
			"<!DOCTYPE html>" +
			"<html>" +
			"<head>" +
				"<meta charset='UTF-8'>" +
			"</head>" +
			"<body>" +
				"<h1>Shop</h1>" +
				"<hr>" +
				"<a href='shop.html'>Shop</a> |" +
				"<hr> <br>" +
				"Items in basket: <br>"	
		);
		
		for (int i = 0; i < basket.size(); ++i) {
			String basketItem = basket.get(i);
			pageHTML.append(" - " + basketItem + "<br>");
		}
		pageHTML.append("</body>" + "</html>");
		
		return pageHTML.toString();
	}

}
