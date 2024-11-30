package uz.pdp.ecommercejsp.servlet.auth;

import uz.pdp.ecommercejsp.entity.User;
import uz.pdp.ecommercejsp.repo.UserRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@WebServlet("/auth/register")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
    static String absolutPathForGet = "C:/java/PDP java/7-modul-jsp/E-commerce-jsp/files/";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneInp = req.getParameter("phone_inp");
        if (phoneInp != null) {
            String passwordInp = req.getParameter("password_inp");
            String passwordRepeatInp = req.getParameter("password_repeat_inp");
            if (!passwordRepeatInp.equals(passwordInp)) {
                resp.sendRedirect("/auth/register.jsp");
                return;
            }
            Part part = req.getPart("image");
            Files.write(
                    Path.of(absolutPathForGet + part.getSubmittedFileName() + ".jpg"),
                    part.getInputStream().readAllBytes(),
                    StandardOpenOption.CREATE_NEW
            );
            String photoPath=part.getSubmittedFileName() + ".jpg";
            User user = new User(
                    phoneInp,
                    passwordInp,
                    photoPath
            );
            UserRepo.save(user);
            resp.sendRedirect("/auth/login.jsp");
        }
    }
}
