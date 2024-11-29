package uz.pdp.ecommercejsp.repo;

import uz.pdp.ecommercejsp.DB;
import uz.pdp.ecommercejsp.entity.Order;

import java.util.List;

public class OrderRepo {
    public static List<Order> findAll(){
        return DB.orders;
    }
}
