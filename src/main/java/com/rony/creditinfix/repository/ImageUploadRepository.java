package com.rony.creditinfix.repository;

import com.rony.creditinfix.entity.ImageUpload;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageUploadRepository extends JpaRepository<ImageUpload, Long> {

    Optional<ImageUpload> findByName(String name);
}
