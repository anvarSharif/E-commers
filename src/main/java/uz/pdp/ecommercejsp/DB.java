package uz.pdp.ecommercejsp;

import uz.pdp.ecommercejsp.entity.Category;
import uz.pdp.ecommercejsp.entity.*;

import java.util.ArrayList;
import java.util.List;

public class DB {
    public static List<Category> categories =new ArrayList<>(List.of(
            new Category(1, "Yegulik"),
            new Category(2, "Ichimlik"),
            new Category(3, "Kiygulik"),
            new Category(4, "Texnika")
    ));

    public static List<Product> products = new ArrayList<>(List.of(
            new Product(1, 1, 100, "Non","non.jpg"),
            new Product(2, 1, 300, "Muzqaymoq", "muzqaymoq.jpg"),

            new Product(3, 2, 100, "Kofe", "kofe.jpg"),
            new Product(4, 2, 300, "Sok", "sok.jpg"),

            new Product(5, 3, 100, "Shim", "shim.jpg"),
            new Product(6, 3, 80, "Kuylak", "kuylak.jpg"),

            new Product(7, 4, 300, "Telefon", "telefon.jpg"),
            new Product(8, 4, 150, "Televizor", "televizor.jpg")
    ));

    public static List<User> users=new ArrayList<>(List.of(
            new User(101, "1111", "aa",Role.ADMIN, "user1.jpg"),
            new User(102, "2222", "aa", "user.jpg"),
            new User(103, "3333", "aa", "user.jpg")
    ));
    public static List<Order> orders=new ArrayList<>();
    public static List<OrderItem> orderItems=new ArrayList<>();

}
