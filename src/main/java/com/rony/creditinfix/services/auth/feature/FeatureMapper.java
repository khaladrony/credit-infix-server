package com.rony.creditinfix.services.auth.feature;

import com.rony.creditinfix.entity.auth.Feature;
import com.rony.creditinfix.models.auth.FeatureDTO;
import com.rony.creditinfix.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface FeatureMapper extends BaseMapper<FeatureDTO, Feature> {

    @Mapping(target = "id", ignore = true) // Adjust mappings as needed
    void updateEntityFromDto(FeatureDTO featureDTO, @MappingTarget Feature feature);
}
