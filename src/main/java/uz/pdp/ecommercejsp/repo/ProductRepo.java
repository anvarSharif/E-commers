package uz.pdp.ecommercejsp.repo;

import lombok.Data;
import uz.pdp.ecommercejsp.DB;
import uz.pdp.ecommercejsp.entity.Product;
import uz.pdp.ecommercejsp.entity.User;

import java.util.List;

public class ProductRepo {
    public static List<Product> findAll(){
        return DB.products;
    }
    public static Product findById(Integer id){
        return DB.products.stream().filter(item->item.getId().equals(id)).findFirst().get();
    }

    public static void deleteById(Integer categoryId) {
        DB.products.removeIf(item->item.getId().equals(categoryId));
    }
}
