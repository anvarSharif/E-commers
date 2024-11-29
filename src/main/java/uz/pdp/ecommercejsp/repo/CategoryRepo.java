package uz.pdp.ecommercejsp.repo;

import uz.pdp.ecommercejsp.DB;
import uz.pdp.ecommercejsp.entity.Category;


import java.util.List;

public class CategoryRepo {
    public static List<Category> findAll(){
        return DB.categories;
    }

    public static void save(Category category){
        DB.categories.add(category);
    }
    public static void deleteById(Integer id){
        DB.categories.removeIf(item->item.getId().equals(id));
    }
    public static void update(Category category,Integer id){
        Category categoryById = findById(id);
        categoryById.setName(category.getName());
    }
    public static Category findById(Integer id){
      return DB.categories.stream().filter(item->item.getId().equals(id)).findFirst().get();
    }
}
