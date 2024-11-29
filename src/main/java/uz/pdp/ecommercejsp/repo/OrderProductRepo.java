package uz.pdp.ecommercejsp.repo;

import uz.pdp.ecommercejsp.DB;
import uz.pdp.ecommercejsp.entity.Category;

import java.util.List;

public class OrderProductRepo {
    public static List<Category> findAll(){
        return DB.categories;
    }
}
