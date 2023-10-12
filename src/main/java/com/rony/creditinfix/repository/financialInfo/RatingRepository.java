package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RatingRepository  extends JpaRepository<Rating, Long> {


    @Query(value = "select * from rating r where r.start_range <= ?1 AND r.end_range >= ?1 ",  nativeQuery = true)
    Rating findRatingBetweenRange(int creditRating);
}
