package uz.pdp.ecommercejsp.servlet.admin;

import uz.pdp.ecommercejsp.repo.CategoryRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/category/delete")
public class DeleteCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer categoryId = Integer.parseInt(req.getParameter("categoryId"));
        CategoryRepo.deleteById(categoryId);
        resp.sendRedirect("/admin/category.jsp");
    }
}
