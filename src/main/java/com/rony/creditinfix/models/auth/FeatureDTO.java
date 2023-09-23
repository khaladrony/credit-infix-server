package com.rony.creditinfix.models.auth;


import com.rony.creditinfix.entity.auth.Feature;
import com.rony.creditinfix.entity.auth.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureDTO {

    private Long id;
    private int version;
    private String name;
    private String path;
    private String icon;
    private String type;
    private boolean isCollapsed;
    private Menu menu;
    private String status;

    public FeatureDTO(Feature feature){
        this.setId(feature.getId());
        this.setVersion(feature.getVersion());
        this.setName(feature.getName());
        this.setPath(feature.getPath());
        this.setIcon(feature.getIcon());
        this.setType(feature.getType());
        this.setCollapsed(feature.isCollapsed());
        this.setMenu(feature.getMenu());
        this.setStatus(feature.getStatus());
    }
}
