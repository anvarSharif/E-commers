package uz.pdp.ecommercejsp.repo;

import uz.pdp.ecommercejsp.DB;
import uz.pdp.ecommercejsp.entity.Product;
import uz.pdp.ecommercejsp.entity.User;

import java.util.List;

public class UserRepo {
    public static List<User> findAll(){
        return DB.users;
    }
    public static User findById(Integer id){
        return DB.users.stream().filter(item->item.getId().equals(id)).findFirst().get();
    }

    public static void save(User user) {
        DB.users.add(user);
    }
}
