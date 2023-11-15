package com.rony.creditinfix.models.financialInfo;

import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.LocationImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationImageDTO {
    private Long id;
    private int version;
    private CompanyInfo companyInfo;
    private String name;
    private String type;

    public LocationImageDTO(LocationImage locationImage){
        this.setId(locationImage.getId());
        this.setVersion(locationImage.getVersion());
        this.setCompanyInfo(locationImage.getCompanyInfo());
        this.setName(locationImage.getName());
        this.setType(locationImage.getType());
    }
}
