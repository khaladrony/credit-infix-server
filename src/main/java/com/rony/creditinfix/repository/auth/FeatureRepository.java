package com.rony.creditinfix.repository.auth;

import com.rony.creditinfix.entity.auth.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeatureRepository extends JpaRepository<Feature, Long> {

    @Query("select count(u) from User u where u.id <> ?1 AND u.username = ?2 ")
    List<Feature> findAllFeatureByParentFeatureName();
}
