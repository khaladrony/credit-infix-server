package com.rony.creditinfix.services.imageUpload;


import com.rony.creditinfix.entity.ImageUpload;
import com.rony.creditinfix.models.ImageUploadDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.Optional;

public interface ImageUploadService extends AbstractService<ImageUploadDTO> {

    Optional<ImageUpload> findByName(String name);

    byte[] compressBytes(byte[] data);

    byte[] decompressBytes(byte[] data);
}
