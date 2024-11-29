package uz.pdp.ecommercejsp.servlet;


import uz.pdp.ecommercejsp.entity.Basket;
import uz.pdp.ecommercejsp.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operator = req.getParameter("operator");
        Integer productId = Integer.parseInt(req.getParameter("productId"));
        HttpSession session = req.getSession();
        Basket basket=(Basket)Objects.requireNonNullElse(session.getAttribute("basket"),new Basket());
        Map<Product, Integer> savatcha = basket.getMap();
        if (operator.equals("plus")) {
            savatcha.entrySet().stream().filter(item -> item.getKey().getId().equals(productId))
                    .findFirst().ifPresent(item -> savatcha.put(item.getKey(), item.getValue() + 1));
        } else if (operator.equals("minus")) {
           savatcha.entrySet().stream().filter(item -> item.getKey().getId().equals(productId))
                    .findFirst().ifPresent(item -> {
                        if (item.getValue() == 1) {
                            savatcha.keySet().removeIf(i -> i.getId().equals(productId));
                        } else {
                            savatcha.put(item.getKey(), item.getValue() - 1);
                        }
                    });
        }
        session.setAttribute("basket",basket);
        resp.sendRedirect("/basket.jsp");
    }
}

