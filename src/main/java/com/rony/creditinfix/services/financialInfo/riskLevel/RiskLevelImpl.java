package com.rony.creditinfix.services.financialInfo.riskLevel;

import com.rony.creditinfix.entity.financialInfo.Rating;
import com.rony.creditinfix.entity.financialInfo.RiskLevel;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.RiskLevelDTO;
import com.rony.creditinfix.repository.financialInfo.RiskLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RiskLevelImpl implements RiskLevelService {

    @Autowired
    private RiskLevelRepository riskLevelRepository;


    @Override
    public RiskLevelDTO create(RiskLevelDTO riskLevelDTO) throws ServiceException {
        return null;
    }

    @Override
    public RiskLevelDTO update(Long id, RiskLevelDTO riskLevelDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public RiskLevelDTO findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<RiskLevelDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<RiskLevelDTO> findAll() {
        List<RiskLevelDTO> riskLevelDTOS = new ArrayList<>();
        List<RiskLevel> riskLevels = riskLevelRepository.findAll();
        for (RiskLevel riskLevel : riskLevels) {
            RiskLevelDTO riskLevelDTO = new RiskLevelDTO(riskLevel);
            riskLevelDTOS.add(riskLevelDTO);
        }
        return riskLevelDTOS;
    }

    @Override
    public RiskLevel findRiskLevelBetweenRange(int creditRating) {
        return riskLevelRepository.findRiskLevelBetweenRange(creditRating);
    }
}
