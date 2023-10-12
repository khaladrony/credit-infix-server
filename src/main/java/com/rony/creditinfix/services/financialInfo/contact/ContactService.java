package com.rony.creditinfix.services.financialInfo.contact;

import com.rony.creditinfix.models.financialInfo.ContactDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface ContactService extends AbstractService<ContactDTO> {

    List<ContactDTO> findAllByCompanyInfoId(Long companyInfoId);
}
