package com.rony.creditinfix.models.financialInfo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagementDTO {
    private Long id;
    private int version;

    private String itemCode;
    private String itemValue;
    private int sequence;
}
