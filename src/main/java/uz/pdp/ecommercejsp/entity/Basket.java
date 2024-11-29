package uz.pdp.ecommercejsp.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class Basket {
    private Map<Product,Integer> map=new HashMap<>();
}
