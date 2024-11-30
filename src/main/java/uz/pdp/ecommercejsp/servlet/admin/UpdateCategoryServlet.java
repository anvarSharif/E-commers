package uz.pdp.ecommercejsp.servlet.admin;

import uz.pdp.ecommercejsp.entity.Category;
import uz.pdp.ecommercejsp.repo.CategoryRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/category/update")
public class UpdateCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name!=null){
            Integer categoryId = Integer.parseInt(req.getParameter("categoryId"));
            Category category = new Category(name);
            CategoryRepo.update(category,categoryId);
        }
        resp.sendRedirect("/admin/category.jsp");
    }
}
