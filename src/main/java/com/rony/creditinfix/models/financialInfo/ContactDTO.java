package com.rony.creditinfix.models.financialInfo;

import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.Contact;
import com.rony.creditinfix.models.CommonColumnDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO extends CommonColumnDTO {
    private CompanyInfo companyInfo;
    private String telephoneNo;
    private String faxNo;
    private String email;
    private String website;

    public ContactDTO(Contact contact){
        this.setId(contact.getId());
        this.setVersion(contact.getVersion());
        this.setCompanyInfo(contact.getCompanyInfo());
        this.setTelephoneNo(contact.getTelephoneNo());
        this.setFaxNo(contact.getFaxNo());
        this.setEmail(contact.getEmail());
        this.setWebsite(contact.getWebsite());
    }
}
