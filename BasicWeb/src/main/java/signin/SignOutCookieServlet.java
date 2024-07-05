package signin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/signout")
public class SignOutCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie emailCookie = new Cookie("email", "");
		Cookie passwordCookie = new Cookie("password", "");
		emailCookie.setPath("/");
		emailCookie.setMaxAge(0);
		passwordCookie.setPath("/");
		passwordCookie.setMaxAge(0);

		resp.addCookie(emailCookie);
		resp.addCookie(passwordCookie);
		resp.sendRedirect(req.getContextPath() + "/members");
	}
}
