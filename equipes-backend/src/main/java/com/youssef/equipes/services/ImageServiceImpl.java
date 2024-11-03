package com.youssef.equipes.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.youssef.equipes.entities.Equipe;
import com.youssef.equipes.entities.Image;
import com.youssef.equipes.repo.EquipeRepository;
import com.youssef.equipes.repo.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    EquipeService equipeService;
    @Autowired
    EquipeRepository equipeRepository;
    
    @Override
    public Image uploadImage(MultipartFile file) throws IOException {
        return imageRepository.save(Image.builder()
            .name(file.getOriginalFilename())
            .type(file.getContentType())
            .image(file.getBytes())
            .build());
    }

    @Override
    public Image getImageDetails(Long id) throws IOException {
        final Optional<Image> dbImage = imageRepository.findById(id);
        if (dbImage.isPresent()) {
            return Image.builder()
                .idImage(dbImage.get().getIdImage())
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(dbImage.get().getImage())
                .build();
        } else {
            throw new IOException("Image not found");
        }
    }

    @Override
    public ResponseEntity<byte[]> getImage(Long id) throws IOException {
        final Optional<Image> dbImage = imageRepository.findById(id);
        if (dbImage.isPresent()) {
            return ResponseEntity.ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(dbImage.get().getImage());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }


    @Override
    public Image uploadImageProd(MultipartFile file, Long idProd) throws IOException {
        Equipe equipe = equipeRepository.findById(idProd).orElseThrow(() -> new IOException("Equipe not found"));
        Image image = Image.builder()
            .name(file.getOriginalFilename())
            .type(file.getContentType())
            .image(file.getBytes())
            .equipe(equipe)
            .build();
        image = imageRepository.save(image);

        equipe.addImage(image); // Add the image to the equipe
        equipeRepository.save(equipe); // Save the equipe with the new image

        return image;
    }

    @Override
    public List<Image> getImagesParProd(Long equipeId) {
        Equipe p = equipeRepository.findById(equipeId).orElseThrow(() -> new IllegalArgumentException("Equipe not found"));
        return p.getImages();
    }
}
