package uz.pdp.ecommercejsp.repo;

import uz.pdp.ecommercejsp.DB;
import uz.pdp.ecommercejsp.entity.OrderItem;

import java.util.List;

public class OrderItemRepo {
    public static List<OrderItem> findAll(){
        return DB.orderItems;
    }
    public static void save(OrderItem orderItem) {
        DB.orderItems.add(orderItem);
    }
}
