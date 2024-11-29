package uz.pdp.ecommercejsp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private Integer id=idGen;
    private Integer categoryId;
    private Integer price;
    private String name;
    private String photoUrl;
    private static Integer idGen=9;

    public Product(Integer id, Integer categoryId, Integer price, String name, String photoUrl) {
        this.id = id;
        this.categoryId = categoryId;
        this.price = price;
        this.name = name;
        this.photoUrl = photoUrl;
    }

    public Product(Integer categoryId, Integer price, String name, String photoUrl) {
        this.categoryId = categoryId;
        this.price = price;
        this.name = name;
        this.photoUrl = photoUrl;
    }
}
