package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastVisited extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String DATE_OF_LAST_VISIT_COOKIE_NAME = "dateOfLastVisit";
	public static final int ONE_MINUTE_IN_SECONDS = 60;
	public static final int ONE_HOUR_IN_SECONDS = 60 * ONE_MINUTE_IN_SECONDS;
	public static final int ONE_DAY_IN_SECONDS = 24 * ONE_HOUR_IN_SECONDS;
	public static final int ONE_MONTH_IN_SECONDS = 30 * ONE_DAY_IN_SECONDS;
	public static final int ONE_YEAR_IN_SECONDS = 12 * ONE_MONTH_IN_SECONDS;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter output = response.getWriter();
		String dateOfLastVisitCookieValue = getDateOfLastVisitCookieValue(request);
		StringBuilder pageHTML = new StringBuilder(
			"<!DOCTYPE html>"+
			"<html>" +
			"<body>"+
				"<h1>My website</h1> " +
				"<hr><br>" + 
				"Your last visit was on: "
		);
		
		if (dateOfLastVisitCookieValue != null) {
			pageHTML.append(dateOfLastVisitCookieValue);
		}
		pageHTML.append("</body></html>");
		
		setDateOfLastVisitCookie(response);
		
		output.println(pageHTML);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected String getDateOfLastVisitCookieValue(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				if ( cookieName.equals(DATE_OF_LAST_VISIT_COOKIE_NAME) ) {
					String cookieValue = cookie.getValue();
					return cookieValue;
				}
			}
		}
		
		return null; // no cookies available or date cookie not found
	}
	
	protected void setDateOfLastVisitCookie(HttpServletResponse response) {
		String currentDate = new Date().toString(); // value of cookie
		
		Cookie myCookie = new Cookie(DATE_OF_LAST_VISIT_COOKIE_NAME, currentDate);
		myCookie.setMaxAge(ONE_MONTH_IN_SECONDS);
		
		response.addCookie(myCookie);
	}

}
