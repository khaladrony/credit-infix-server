package com.rony.creditinfix.entity.auth;


import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.auth.MenuDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menus")
public class Menu extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;


    public Menu(MenuDTO menuDTO){
        this.setId(menuDTO.getId());
        this.setName(menuDTO.getName());
        this.setDescription(menuDTO.getDescription());
        this.setStatus(menuDTO.getStatus());
        this.setVersion(menuDTO.getVersion());
    }
}
