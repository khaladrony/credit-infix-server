package com.rony.creditinfix.entity.auth;

import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.auth.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;


    public Role(RoleDTO roleDTO){
        this.setId(roleDTO.getId());
        this.setName(roleDTO.getName());
        this.setDescription(roleDTO.getDescription());
        this.setStatus(roleDTO.getStatus());
        this.setVersion(roleDTO.getVersion());
    }
}
