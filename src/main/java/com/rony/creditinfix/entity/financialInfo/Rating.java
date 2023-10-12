package com.rony.creditinfix.entity.financialInfo;

import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.RatingDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rating")
public class Rating extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_range")
    private int startRange;

    @Column(name = "end_range")
    private int endRange;

    @Column(name = "grade", length = 5)
    private String grade;

    @Column(name = "color_code", length = 10)
    private String colorCode;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "description")
    private String description;

    public Rating(RatingDTO ratingDTO){
        this.setId(ratingDTO.getId());
        this.setStartRange(ratingDTO.getStartRange());
        this.setEndRange(ratingDTO.getEndRange());
        this.setGrade(ratingDTO.getGrade());
        this.setColorCode(ratingDTO.getColorCode());
        this.setRemarks(ratingDTO.getRemarks());
        this.setDescription(ratingDTO.getDescription());
    }
}
