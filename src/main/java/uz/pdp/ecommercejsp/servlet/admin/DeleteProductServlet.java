package uz.pdp.ecommercejsp.servlet.admin;

import uz.pdp.ecommercejsp.repo.CategoryRepo;
import uz.pdp.ecommercejsp.repo.ProductRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/delete")
public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer categoryId = Integer.parseInt(req.getParameter("productId"));
        ProductRepo.deleteById(categoryId);
        resp.sendRedirect("/admin/product.jsp");
    }
}
