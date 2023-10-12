package com.rony.creditinfix.services.financialInfo.creditAssessment;

import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.Rating;
import com.rony.creditinfix.entity.financialInfo.RiskLevel;
import com.rony.creditinfix.models.financialInfo.CreditAssessmentDTO;
import com.rony.creditinfix.repository.financialInfo.CompanyInfoRepository;
import com.rony.creditinfix.repository.financialInfo.RatingRepository;
import com.rony.creditinfix.repository.financialInfo.RiskLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CreditAssessmentImpl implements CreditAssessmentService {

    @Autowired
    private CompanyInfoRepository companyInfoRepository;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private RiskLevelRepository riskLevelRepository;

    @Override
    public CreditAssessmentDTO getDate(Long companyInfoId) {
        CompanyInfo companyInfo = null;
        Rating rating = null;
        RiskLevel riskLevel = null;
        CreditAssessmentDTO creditAssessmentDTO = null;

        Optional<CompanyInfo> companyInfos = companyInfoRepository.findById(companyInfoId);
        if (companyInfos.isPresent()) {
            companyInfo = companyInfoRepository.findById(companyInfoId).get();

            rating = ratingRepository.findRatingBetweenRange(Integer.parseInt(companyInfo.getCreditRating()));
            riskLevel = riskLevelRepository.findRiskLevelBetweenRange(Integer.parseInt(companyInfo.getCreditRating()));

            creditAssessmentDTO = new CreditAssessmentDTO();

            creditAssessmentDTO.setCurrency("USD");
            creditAssessmentDTO.setMaximumCredit(companyInfo.getMaximumCredit());
            creditAssessmentDTO.setCreditRating(companyInfo.getCreditRating());
            creditAssessmentDTO.setGrade(rating.getGrade());
            creditAssessmentDTO.setGradeRange(rating.getStartRange() + "-" + rating.getEndRange());
            creditAssessmentDTO.setCreditRatingStatus(companyInfo.getBusinessScale());
            creditAssessmentDTO.setRiskStatus(riskLevel.getCategory());
            creditAssessmentDTO.setColorCode(rating.getColorCode());
            creditAssessmentDTO.setPaddingPercent(this.getPaddingPercent(rating.getGrade()));

        }


        return creditAssessmentDTO;
    }

    private String getPaddingPercent(String grade){

        int value;
        switch (grade){
            case "A":
                value = 0;
                break;
            case "B":
                value = 1;
                break;
            case "C":
                value = 2;
                break;
            case "D":
                value = 3;
                break;
            case "E":
                value = 4;
                break;
            case "H":
                value = 5;
                break;
            default:
                value = 6;
        }

        return String.valueOf(15*value);
    }
}
