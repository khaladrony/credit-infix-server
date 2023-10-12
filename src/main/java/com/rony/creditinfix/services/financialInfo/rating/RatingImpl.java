package com.rony.creditinfix.services.financialInfo.rating;

import com.rony.creditinfix.entity.financialInfo.Rating;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.RatingDTO;
import com.rony.creditinfix.repository.financialInfo.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RatingImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public RatingDTO create(RatingDTO ratingDTO) throws ServiceException {
        return null;
    }

    @Override
    public RatingDTO update(Long id, RatingDTO ratingDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public RatingDTO findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<RatingDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<RatingDTO> findAll() {
        List<RatingDTO> ratingDTOS = new ArrayList<>();
        List<Rating> ratings = ratingRepository.findAll();
        for (Rating rating : ratings) {
            RatingDTO ratingDTO = new RatingDTO(rating);
            ratingDTOS.add(ratingDTO);
        }
        return ratingDTOS;
    }

    @Override
    public Rating findRatingBetweenRange(int creditRating) {
        return ratingRepository.findRatingBetweenRange(creditRating);
    }
}
