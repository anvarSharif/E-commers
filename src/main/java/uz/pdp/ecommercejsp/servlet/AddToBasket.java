package uz.pdp.ecommercejsp.servlet;


import uz.pdp.ecommercejsp.entity.Basket;
import uz.pdp.ecommercejsp.entity.Product;
import uz.pdp.ecommercejsp.repo.ProductRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/basket/add")
public class AddToBasket extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer productId = Integer.parseInt(req.getParameter("productId"));
        String categoryId = req.getParameter("categoryId");
        HttpSession session = req.getSession();
        Basket basket = (Basket) Objects.requireNonNullElse(session.getAttribute("basket"), new Basket());
        Product product = ProductRepo.findById(productId);
        basket.getMap().put(product, 1);
        session.setAttribute("basket",basket);

        if (categoryId.equals("non")){
            resp.sendRedirect("/home.jsp");
        }else {
            resp.sendRedirect("/home.jsp?categoryId="+categoryId);
        }
    }
}
