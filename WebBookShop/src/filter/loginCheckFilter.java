package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Users;

/**
 * Servlet Filter implementation class loginCheckFilter
 */
@WebFilter("/*")
public class loginCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Users user = (Users)req.getSession().getAttribute("user");
		String requestUrl = req.getRequestURL().toString();
		if (requestUrl.contains("shopCartActionServlet")) {
			//已经登录
			if(user==null) {
				request.setAttribute("result","<script>alert('您还没有登录，请先登录');</script>");
				request.getRequestDispatcher("/user/login.jsp").forward(req,res);
			}else {
				chain.doFilter(request, response);
			}
		}else {
			chain.doFilter(request, response);
		} 

		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
