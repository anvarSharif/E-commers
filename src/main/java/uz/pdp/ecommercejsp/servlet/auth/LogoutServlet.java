package uz.pdp.ecommercejsp.servlet.auth;

import uz.pdp.ecommercejsp.entity.Basket;
import uz.pdp.ecommercejsp.entity.Role;
import uz.pdp.ecommercejsp.entity.User;
import uz.pdp.ecommercejsp.repo.UserRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/auth/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/home.jsp");
    }
}
