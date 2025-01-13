package com.rony.creditinfix.services.financialInfo.riskProfile;

import com.rony.creditinfix.entity.financialInfo.RiskProfile;
import com.rony.creditinfix.models.financialInfo.RiskProfileDTO;
import com.rony.creditinfix.repository.financialInfo.RiskProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiskProfileImpl implements RiskProfileService {

    @Autowired
    RiskProfileRepository riskProfileRepository;


    @Override
    public List<RiskProfileDTO> saveAll(List<RiskProfileDTO> riskProfileDTOS, Long companyInfoId) {
        List<RiskProfile> riskProfileList = new ArrayList<>();
        for (RiskProfileDTO riskProfileDTO : riskProfileDTOS) {
            RiskProfile riskProfile = new RiskProfile(riskProfileDTO);
            riskProfileList.add(riskProfile);
        }
        riskProfileRepository.saveAll(riskProfileList);
        return this.findAllByCompanyInfoId(companyInfoId);
    }

    @Override
    public List<RiskProfileDTO> findAllByCompanyInfoId(Long companyInfoId) {
        List<RiskProfileDTO> riskProfileDTOS = new ArrayList<>();
        List<RiskProfile> riskProfileList = riskProfileRepository.findAllByCompanyInfoId(companyInfoId);
        for (RiskProfile riskProfile : riskProfileList) {
            RiskProfileDTO riskProfileDTO = new RiskProfileDTO(riskProfile);
            riskProfileDTOS.add(riskProfileDTO);
        }
        return riskProfileDTOS;
    }

    @Override
    public RiskProfileDTO create(RiskProfileDTO riskProfileDTO) {
        return null;
    }

    @Override
    public RiskProfileDTO update(Long id, RiskProfileDTO riskProfileDTO) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public RiskProfileDTO findById(Long id) {
        return null;
    }

    @Override
    public Page<RiskProfileDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<RiskProfileDTO> findAll() {
        return null;
    }
}
