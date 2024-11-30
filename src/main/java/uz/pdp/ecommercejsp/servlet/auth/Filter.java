package uz.pdp.ecommercejsp.servlet.auth;

import uz.pdp.ecommercejsp.entity.Role;
import uz.pdp.ecommercejsp.entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class Filter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getRequestURI().contains("/admin")){
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            if (user==null||!user.getRole().equals(Role.ADMIN)){
                res.sendRedirect("/auth/login.jsp");
                return;
            }
        }
        chain.doFilter(req,res);
    }
}
