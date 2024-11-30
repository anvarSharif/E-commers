package uz.pdp.ecommercejsp.servlet.admin;



import uz.pdp.ecommercejsp.entity.Category;
import uz.pdp.ecommercejsp.repo.CategoryRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/add")
@MultipartConfig
public class AddCategory extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        CategoryRepo.save(new Category(name));
        resp.sendRedirect("/admin/category.jsp");
    }
}
