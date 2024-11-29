package uz.pdp.ecommercejsp.entity;

import lombok.Data;

@Data
public class OrderItem {
    private Integer id=genId++;
    private Integer orderId;
    private Integer productId;
    private Integer amount;
    private static Integer genId=0;

    public OrderItem(Integer orderId, Integer productId, Integer amount) {
        this.orderId = orderId;
        this.productId = productId;
        this.amount = amount;
    }
}
