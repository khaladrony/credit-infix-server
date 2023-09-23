package com.rony.creditinfix.models.auth;


import com.rony.creditinfix.entity.auth.Role;
import com.rony.creditinfix.entity.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private int version;
    private String username;
    private String password;
    private String email;
    private String phoneNo;
    private String address;
    private String status;
    private Role role;

    public UserDTO(User user){
        this.setId(user.getId());
        this.setVersion(user.getVersion());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setEmail(user.getEmail());
        this.setPhoneNo(user.getPhoneNo());
        this.setAddress(user.getAddress());
        this.setStatus(user.getStatus());
        this.setRole(user.getRole());
    }

}
