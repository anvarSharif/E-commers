package uz.pdp.ecommercejsp.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private Integer id=genId++;
    private LocalDateTime dateTime=LocalDateTime.now();
    private Integer userId;
    private Status status=Status.NEW;

    private static Integer genId=1;

    public Order(Integer userId) {
        this.userId = userId;
    }
}
