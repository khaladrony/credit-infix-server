package com.rony.creditinfix.services.financialInfo.shareholder;

import com.rony.creditinfix.models.financialInfo.ShareholderDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface ShareholderService extends AbstractService<ShareholderDTO> {

    List<ShareholderDTO> saveAll(List<ShareholderDTO> shareholderDTOS, Long companyInfoId);

    List<ShareholderDTO> findAllByCompanyInfoId(Long companyInfoId);
}
