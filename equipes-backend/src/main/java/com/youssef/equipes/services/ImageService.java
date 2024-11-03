package com.youssef.equipes.services;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.youssef.equipes.entities.Image;

public interface ImageService {
    Image uploadImage(MultipartFile file) throws IOException;
    Image getImageDetails(Long id) throws IOException;
    ResponseEntity<byte[]> getImage(Long id) throws IOException;
    void deleteImage(Long id);
    
    Image uploadImageProd(MultipartFile file, Long idProd) throws IOException;
    List<Image> getImagesParProd(Long prodId);
}
