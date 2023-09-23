package com.rony.creditinfix.models.auth;


import com.rony.creditinfix.entity.auth.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {

    private Long id;
    private int version;
    private String name;
    private String description;
    private String status;


    public MenuDTO(Menu menu){
        this.setId(menu.getId());
        this.setName(menu.getName());
        this.setDescription(menu.getDescription());
        this.setStatus(menu.getStatus());
        this.setVersion(menu.getVersion());
    }
}
