package com.rony.creditinfix.services.financialInfo.rating;

import com.rony.creditinfix.entity.financialInfo.Rating;
import com.rony.creditinfix.models.financialInfo.RatingDTO;
import com.rony.creditinfix.services.AbstractService;

public interface RatingService extends AbstractService<RatingDTO> {

    Rating findRatingBetweenRange(int creditRating);
}
