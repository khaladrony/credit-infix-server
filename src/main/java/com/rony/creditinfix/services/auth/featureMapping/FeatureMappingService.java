package com.rony.creditinfix.services.auth.featureMapping;

import com.rony.creditinfix.entity.auth.FeatureMapping;
import com.rony.creditinfix.models.auth.FeatureMappingDTO;
import com.rony.creditinfix.models.auth.FeatureMappingListResponseDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface FeatureMappingService  extends AbstractService<FeatureMappingDTO> {

    List<FeatureMappingListResponseDTO> findAllFeatureMapping();

    FeatureMapping findByRoleIdAndFeatureId(Long roleId, Long featureId);
}
