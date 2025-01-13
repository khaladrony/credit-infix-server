package com.rony.creditinfix.services.auth.feature;

import com.rony.creditinfix.entity.auth.Feature;
import com.rony.creditinfix.entity.auth.Menu;
import com.rony.creditinfix.exception.NotFoundException;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.auth.FeatureDTO;
import com.rony.creditinfix.repository.auth.FeatureRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
@AllArgsConstructor
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;
    private final FeatureMapper featureMapper;

    @Override
    public FeatureDTO create(FeatureDTO featureDTO) {
        validateDuplicate(featureDTO, "save");
        Feature feature = featureMapper.dtoToEntity(featureDTO);
        Feature savedFeature = featureRepository.save(feature);

        return featureMapper.entityToDto(savedFeature);
    }

    @Override
    public FeatureDTO update(Long id, FeatureDTO featureDTO) {
        try {
            Feature feature = featureRepository.findById(id)
                    .orElseThrow(NotFoundException::new);
            featureMapper.updateEntityFromDto(featureDTO, feature);
            Feature updatedFeature = featureRepository.save(feature);

            return featureMapper.entityToDto(updatedFeature);
        } catch (NotFoundException e) {
            throw new RuntimeException("Failed to update feature", e);
        }
    }

    @Override
    public Boolean delete(Long id) {
        try {
            FeatureDTO featureDTO = this.findById(id);
            if (featureDTO == null) throw new NotFoundException();

            featureRepository.deleteById(id);
            return true;
        } catch (NotFoundException e) {
            throw new RuntimeException("Failed to delete feature", e);
        }
    }

    @Override
    public FeatureDTO findById(Long id) {
        try {
            return featureRepository.findById(id)
                    .map(featureMapper::entityToDto)
                    .orElseThrow(NotFoundException::new);
        }catch (NotFoundException e) {
            throw new RuntimeException("Failed to find feature", e);
        }

    }

    @Override
    public Page<FeatureDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return featureRepository.findAll(pageable)
                .map(featureMapper::entityToDto);
    }

    @Override
    public List<FeatureDTO> findAll() {
        return featureRepository.findAll()
                .stream()
                .map(featureMapper::entityToDto)
                .collect(Collectors.toList());
    }


    private void validateDuplicate(FeatureDTO featureDTO, String type) {
//        FeatureDTO featureDTOObj = this.findByName(roleDTO.getName());
//        if (roleDTOObj == null) return;
//
//        if (type.equalsIgnoreCase("save")
//                && this.findByName(roleDTO.getName()) != null) {
//            throw new GeneralException("The role exists");
//        } else {
//            int count = roleRepository.countByName(roleDTO.getId(), roleDTO.getName());
//            if (count >= 1) {
//                throw new GeneralException("The role exists");
//            }
//        }

    }

    public void setValue(Feature feature) {
//        if (feature.getParentFeatureId() == null) {
//            feature.setCollapsed(true);
//            feature.setType("submenu");
//        } else {
//            feature.setType("link");
//        }
    }

    public void menus() {
        List<Feature> featureList = featureRepository.findAll();

        List<Feature> features = new ArrayList<>();

        Map<Feature, List<Feature>> featureMap = new HashMap<>();

        List<Map<Feature, List<Feature>>> featureMapList = new ArrayList<>();

        Map<Menu, List<Feature>> list = featureList.stream()
                .collect(groupingBy(Feature::getMenu));

        System.out.println(list);

        list.forEach((menu, featureLst) -> {
            System.out.println(menu);
            System.out.println(featureLst);
        });


    }
}
