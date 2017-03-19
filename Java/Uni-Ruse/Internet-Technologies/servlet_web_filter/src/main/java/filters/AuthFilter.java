package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession currentSession = ( (HttpServletRequest) request ).getSession();
		String username = (String) currentSession.getAttribute("user");
		
		if ( username != null && username.equals("admin") ) {
			chain.doFilter(request, response);
		}
		else {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter output = response.getWriter();
			output.print("You don't have access to this resource!");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
