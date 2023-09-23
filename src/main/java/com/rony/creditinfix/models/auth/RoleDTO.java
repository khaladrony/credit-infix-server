package com.rony.creditinfix.models.auth;


import com.rony.creditinfix.entity.auth.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private Long id;
    private int version;
    private String name;
    private String description;
    private String status;


    public RoleDTO(Role role){
        this.setId(role.getId());
        this.setName(role.getName());
        this.setDescription(role.getDescription());
        this.setStatus(role.getStatus());
        this.setVersion(role.getVersion());
    }
}
