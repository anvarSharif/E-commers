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
import java.util.List;

@WebServlet("/product/update")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
    static String absolutPath = "C:/java/PDP java/7-modul-jsp/E-commerce-jsp/files/";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("productImage");
        Integer productId = Integer.parseInt(req.getParameter("productId"));
        String photoUrl="";
        List<Product> productList = ProductRepo.findAll();
        if (!part.getSubmittedFileName().isEmpty()){
            Files.write(
                    Path.of(absolutPath + part.getSubmittedFileName() + ".jpg")
                    , part.getInputStream().readAllBytes());
            part.getInputStream().close();
            photoUrl = part.getSubmittedFileName() + ".jpg";
            part.getInputStream().close();
        }else{
            photoUrl=productList.stream().filter(item->item.getId().equals(productId)).findAny().map(Product::getPhotoUrl).get();
        }

        String name = req.getParameter("name");
        Integer price = Integer.parseInt(req.getParameter("price"));
        Integer categoryId = Integer.parseInt(req.getParameter("categoryId"));


        Product product=new Product(
                categoryId,price,name,photoUrl
        );
        ProductRepo.update(product,productId);
        resp.sendRedirect("/admin/product.jsp");
    }
}
