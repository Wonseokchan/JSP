package config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/*")
public class TestFilter extends HttpFilter implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("필터가 초기화됨");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		System.out.println("서블릿 호출 전");
		chain.doFilter(request, response);
		System.out.println("서블릿 호출 후");
	}

	public void destroy() {
		System.out.println("필터가 사라짐");
	}

}
