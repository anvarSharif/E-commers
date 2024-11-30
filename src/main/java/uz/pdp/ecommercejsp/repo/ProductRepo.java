package uz.pdp.ecommercejsp.repo;

import lombok.Data;
import uz.pdp.ecommercejsp.DB;
import uz.pdp.ecommercejsp.entity.Product;
import uz.pdp.ecommercejsp.entity.User;

import java.util.List;
import java.util.Optional;

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

    public static void save(Product product) {
        DB.products.add(product);
    }

    public static void update(Product newProduct, Integer productId) {
        DB.products.removeIf(item->item.getId().equals(productId));
        DB.products.add(newProduct);
    }
}
