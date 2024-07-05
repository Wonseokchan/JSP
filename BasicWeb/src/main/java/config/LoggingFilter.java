package config;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/members/*")
public class LoggingFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long start = System.nanoTime();
		System.out.println("요청 처리 시작 시각 : " + LocalDateTime.now());
		chain.doFilter(request, response);
		long end = System.nanoTime();
		System.out.println("요청 처리 종료 시각 : " + LocalDateTime.now());
		System.out.println("요청 처리 소요 시간 : " + (end - start) + "ns");
		System.out.println("");
	}

}
