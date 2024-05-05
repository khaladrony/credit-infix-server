package com.rony.creditinfix.entity.financialInfo;

import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.ContactDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contact")
public class Contact extends CommonColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_info_id", nullable = false)
    private CompanyInfo companyInfo;

    @Column(name = "telephone_no")
    private String telephoneNo;

    @Column(name = "fax_no")
    private String faxNo;

    @Column(name = "email")
    private String email;

    @Column(name = "website")
    private String website;

    public Contact(ContactDTO contactDTO){
        this.setId(contactDTO.getId());
        this.setVersion(contactDTO.getVersion());
        this.setCompanyInfo(contactDTO.getCompanyInfo());
        this.setTelephoneNo(contactDTO.getTelephoneNo());
        this.setFaxNo(contactDTO.getFaxNo());
        this.setEmail(contactDTO.getEmail());
        this.setWebsite(contactDTO.getWebsite());
    }
}
