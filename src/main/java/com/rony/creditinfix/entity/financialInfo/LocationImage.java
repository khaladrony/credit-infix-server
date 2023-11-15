package com.rony.creditinfix.entity.financialInfo;

import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.LocationImageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "location_image")
public class LocationImage extends CommonColumn {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_info_id", nullable = false)
    private CompanyInfo companyInfo;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    public LocationImage(LocationImageDTO locationImageDTO){
        this.setId(locationImageDTO.getId());
        this.setVersion(locationImageDTO.getVersion());
        this.setCompanyInfo(locationImageDTO.getCompanyInfo());
        this.setName(locationImageDTO.getName());
        this.setType(locationImageDTO.getType());
    }
}
