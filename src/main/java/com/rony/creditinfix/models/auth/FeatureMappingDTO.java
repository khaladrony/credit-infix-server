package com.rony.creditinfix.models.auth;

import com.rony.creditinfix.entity.auth.FeatureMapping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureMappingDTO {

    private Long id;
    private Long roleId;
    private Long featureId;
    private String status;

    public FeatureMappingDTO(FeatureMapping featureMapping){
        this.setId(featureMapping.getId());
        this.setRoleId(featureMapping.getRoleId());
        this.setFeatureId(featureMapping.getFeatureId());
        this.setStatus(featureMapping.getStatus());
    }

}
