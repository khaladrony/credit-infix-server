package com.rony.creditinfix.services.auth.featureMapping;

import com.rony.creditinfix.entity.auth.FeatureMapping;
import com.rony.creditinfix.exception.GeneralException;
import com.rony.creditinfix.exception.NotFoundException;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.auth.FeatureMappingDTO;
import com.rony.creditinfix.models.auth.FeatureMappingListResponseDTO;
import com.rony.creditinfix.repository.auth.FeatureMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FeatureMappingServiceImpl implements FeatureMappingService {


    @Autowired
    FeatureMappingRepository featureMappingRepository;


    @Override
    public FeatureMappingDTO create(FeatureMappingDTO featureMappingDTO) {
        FeatureMapping featureMapping = new FeatureMapping(featureMappingDTO);

        this.duplicateCheck(featureMappingDTO, "save");

        return new FeatureMappingDTO(featureMappingRepository.save(featureMapping));
    }

    @Override
    public FeatureMappingDTO update(Long id, FeatureMappingDTO featureMappingDTO) {
        FeatureMappingDTO _featureMappingDTO = this.findById(id);
        if (_featureMappingDTO == null) throw new NotFoundException();

        this.duplicateCheck(featureMappingDTO, "");

        _featureMappingDTO.setRoleId(featureMappingDTO.getRoleId());
        _featureMappingDTO.setFeatureId(featureMappingDTO.getFeatureId());
        _featureMappingDTO.setStatus(featureMappingDTO.getStatus());

        FeatureMapping featureMapping = new FeatureMapping(_featureMappingDTO);

        return new FeatureMappingDTO(featureMappingRepository.save(featureMapping));
    }

    @Override
    public Boolean delete(Long id) {
        FeatureMappingDTO featureMappingDTO = this.findById(id);
        if (featureMappingDTO == null) throw new NotFoundException();

        featureMappingRepository.deleteById(id);
        return true;
    }

    @Override
    public FeatureMappingDTO findById(Long id) {
        Optional<FeatureMapping> featureMappingData = featureMappingRepository.findById(id);
        return new FeatureMappingDTO(featureMappingData.orElse(null));
    }

    @Override
    public Page<FeatureMappingDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<FeatureMappingDTO> findAll() {
        return null;
    }

    private void duplicateCheck(FeatureMappingDTO featureMappingDTO, String type) throws ServiceException {
        FeatureMapping mapping = this.findByRoleIdAndFeatureId(featureMappingDTO.getRoleId(),featureMappingDTO.getFeatureId());
        if (mapping == null) return;

        if (type.equalsIgnoreCase("save")) {
            throw new GeneralException("Mapping exists");
        } else {
            int count = featureMappingRepository.countByRoleAndFeature(featureMappingDTO.getRoleId(), featureMappingDTO.getFeatureId());
            if (count >= 1) {
                throw new GeneralException("Mapping exists");
            }
        }
    }

    @Override
    public List<FeatureMappingListResponseDTO> findAllFeatureMapping() {
        return featureMappingRepository.findAllFeatureMapping();
    }

    @Override
    public FeatureMapping findByRoleIdAndFeatureId(Long roleId, Long featureId) {
        return featureMappingRepository.findByRoleIdAndFeatureId(roleId, featureId);
    }
}
