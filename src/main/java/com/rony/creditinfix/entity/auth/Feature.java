package com.rony.creditinfix.entity.auth;


import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.auth.FeatureDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "features")
public class Feature extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "path", nullable = false)
    private String path;

    @Column(name = "icon")
    private String icon;

    @Column(name = "type")
    private String type;        //link,''

    @Column(name = "is_collapsed", columnDefinition = "boolean default false")
    private boolean isCollapsed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @Column(name = "menu_type")
    private String menuType;    //Main, Sub

    @Column(name = "status")
    private String status;


    public Feature(FeatureDTO featureDTO){
        this.setId(featureDTO.getId());
        this.setVersion(featureDTO.getVersion());
        this.setName(featureDTO.getName());
        this.setPath(featureDTO.getPath());
        this.setIcon(featureDTO.getIcon());
        this.setType(featureDTO.getType());
        this.setCollapsed(featureDTO.isCollapsed());
        this.setMenu(featureDTO.getMenu());
        this.setMenuType(featureDTO.getMenuType());
        this.setStatus(featureDTO.getStatus());
    }
}
