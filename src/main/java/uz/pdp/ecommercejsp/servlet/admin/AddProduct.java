package uz.pdp.ecommercejsp.servlet.admin;


import uz.pdp.ecommercejsp.entity.Product;
import uz.pdp.ecommercejsp.repo.ProductRepo;

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

@WebServlet("/product/add")
@MultipartConfig
public class AddProduct extends HttpServlet {
    static String absolutPath = "C:/java/PDP java/7-modul-jsp/E-commerce-jsp/files/";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("productImage");
        Files.write(
                Path.of(absolutPath + part.getSubmittedFileName() + ".jpg")
                , part.getInputStream().readAllBytes(),
                StandardOpenOption.CREATE_NEW);
        part.getInputStream().close();
        String photoUrl = part.getSubmittedFileName() + ".jpg";
        String name = req.getParameter("name");
        Integer price = Integer.parseInt(req.getParameter("price"));
        Integer categoryId = Integer.parseInt(req.getParameter("categoryId"));

        Product product = new Product(
                categoryId, price, name, photoUrl
        );
        ProductRepo.save(product);
        resp.sendRedirect("/admin/product.jsp");
    }
}
