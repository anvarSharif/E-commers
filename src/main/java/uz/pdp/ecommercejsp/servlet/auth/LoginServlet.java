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

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneInp = req.getParameter("phone_inp");
        if (phoneInp != null) {
            String passwordInp = req.getParameter("password_inp");
            Optional<User> optionalUser = UserRepo.findAll().stream()
                    .filter(item -> item.getPassword().equals(passwordInp)
                            && item.getPhone().equals(phoneInp)).findFirst();
            if (optionalUser.isPresent()) {
                User currentUser = optionalUser.get();
                HttpSession session = req.getSession();
                session.setAttribute("user",currentUser);
                Basket basket = (Basket) session.getAttribute("basket");

                if (currentUser.getRole().equals(Role.ADMIN)){
                    resp.sendRedirect("/admin/category.jsp");
                    return;
                }

                if (basket==null||basket.getMap().isEmpty()){
                    resp.sendRedirect("/home.jsp");
                    return;
                }
                resp.sendRedirect("/basket.jsp");
                return;
            }
        }
        resp.sendRedirect("/auth/login.jsp");
    }
}
