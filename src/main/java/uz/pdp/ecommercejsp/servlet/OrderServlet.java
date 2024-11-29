package uz.pdp.ecommercejsp.servlet;

import uz.pdp.ecommercejsp.entity.*;
import uz.pdp.ecommercejsp.repo.OrderItemRepo;
import uz.pdp.ecommercejsp.repo.OrderRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        if (basket==null||basket.getMap().isEmpty()){
            resp.sendRedirect("/home.jsp");
            return;
        }
        Map<Product, Integer> savatcha = basket.getMap();

        if (session.getAttribute("user")==null){
            resp.sendRedirect("/auth/login.jsp");
            return;
        }
        List<OrderItem> tempOrderItems = new ArrayList<>();
        User user = (User) session.getAttribute("user");
        Order order = new Order(user.getId());
        OrderRepo.save(order);
        savatcha.forEach(
                (key, value) -> {
                    tempOrderItems.add(new OrderItem(
                            order.getId(),
                            key.getId(),
                            value
                    ));
                }
        );
        for (OrderItem tempOrderItem : tempOrderItems) {
            OrderItemRepo.save(tempOrderItem);
        }
        savatcha.clear();
        session.setAttribute("basket",basket);
        resp.sendRedirect("/home.jsp");
    }
}
