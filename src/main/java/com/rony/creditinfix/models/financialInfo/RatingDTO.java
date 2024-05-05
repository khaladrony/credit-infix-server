package com.rony.creditinfix.models.financialInfo;


import com.rony.creditinfix.entity.financialInfo.Rating;
import com.rony.creditinfix.models.CommonColumnDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDTO extends CommonColumnDTO {
    private int startRange;
    private int endRange;
    private String grade;
    private String colorCode;
    private String remarks;
    private String description;

    public RatingDTO(Rating rating){
        this.setId(rating.getId());
        this.setVersion(rating.getVersion());
        this.setStartRange(rating.getStartRange());
        this.setEndRange(rating.getEndRange());
        this.setGrade(rating.getGrade());
        this.setColorCode(rating.getColorCode());
        this.setRemarks(rating.getRemarks());
        this.setDescription(rating.getDescription());
    }
}
