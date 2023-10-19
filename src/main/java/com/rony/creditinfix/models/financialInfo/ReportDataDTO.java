package com.rony.creditinfix.models.financialInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportDataDTO {
    private int rowspan;
    private int colspan;
    private String text;

}
