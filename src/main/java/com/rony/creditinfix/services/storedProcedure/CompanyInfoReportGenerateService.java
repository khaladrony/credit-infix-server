package com.rony.creditinfix.services.storedProcedure;

import com.rony.creditinfix.models.report.CompanyInfoReportGenerateDTO;

public interface CompanyInfoReportGenerateService {
    CompanyInfoReportGenerateDTO execute(Long companyInfoId);
}
