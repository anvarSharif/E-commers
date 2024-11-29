package uz.pdp.ecommercejsp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id=idGen++;
    private String phone;
    private String password;
    private Role role=Role.CUSTOMER;
    private String PhotoUrl;
    private static Integer idGen=3;

    public User(Integer id, String phone, String password, String photoUrl) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        PhotoUrl = photoUrl;
    }

    public User(String phone, String password, String photoUrl) {
        this.phone = phone;
        this.password = password;
        PhotoUrl = photoUrl;
    }
}
