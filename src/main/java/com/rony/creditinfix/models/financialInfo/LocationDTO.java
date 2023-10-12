package com.rony.creditinfix.models.financialInfo;

import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {
    private Long id;
    private int version;

    private CompanyInfo companyInfo;
    private String itemCode;
    private String itemValue;

    public LocationDTO(Location location){
        this.setId(location.getId());
        this.setVersion(location.getVersion());
        this.setCompanyInfo(location.getCompanyInfo());
        this.setItemCode(location.getItemCode());
        this.setItemValue(location.getItemValue());
    }
}
