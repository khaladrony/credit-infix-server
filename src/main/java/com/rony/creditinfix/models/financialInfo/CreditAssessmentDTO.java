package com.rony.creditinfix.models.financialInfo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditAssessmentDTO {

    private String currency;
    private String maximumCredit;
    private String grade;
    private String gradeRange;
    private String creditRating;
    private String creditRatingStatus;
    private String riskStatus;
    private String colorCode;
    private String paddingPercent;
}
