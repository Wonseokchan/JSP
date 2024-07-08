package common;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.MemberVO;

@WebFilter("/MemberCheckFilter")
public class MemberCheckFilter extends HttpFilter {
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		if (member != null) {
			chain.doFilter(req, res);
		} else {
			// 원래 실행하려고 했던 요청 정보를 세션에 담아준다
			String retUrl = req.getRequestURI() + (req.getQueryString() != null ? "?" + req.getQueryString() : "");
			session.setAttribute("retUrl", req.getRequestURI() + "?" + req.getQueryString());
			res.sendRedirect(req.getContextPath() + "/login");
		}
	}
}
