package com.rony.creditinfix.services.financialInfo.creditAssessment;

import com.rony.creditinfix.models.financialInfo.CreditAssessmentDTO;

public interface CreditAssessmentService {

    CreditAssessmentDTO getDate(Long companyInfoId);
}
