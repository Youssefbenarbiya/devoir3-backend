package com.youssef.equipes.RESTControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.youssef.equipes.entities.Image;
import com.youssef.equipes.services.ImageService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
    @Autowired
    ImageService imageService;

    @GetMapping("/load/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) {
        try {
            return imageService.getImage(id);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/getImagesEqip/{idEqip}")
    public List<Image> getImagesEqip(@PathVariable("idEqip") Long idEqip) throws IOException {
        return imageService.getImagesParProd(idEqip);
    }

    @GetMapping("/get/info/{id}")
    public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
        return imageService.getImageDetails(id);
    }

  
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable("id") Long id) {
        imageService.deleteImage(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public Image updateImage(@RequestParam("image") MultipartFile file) throws IOException {
        return imageService.uploadImage(file);
    }
    
    @PostMapping("/upload")
    public ResponseEntity<Image> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        Image image = imageService.uploadImage(file);
        return ResponseEntity.ok(image);
    }

    @PostMapping("/uploadImageEqip/{idEqip}")
    public ResponseEntity<Image> uploadImageForEquipe(@RequestParam("image") MultipartFile file, @PathVariable("idEqip") Long idEqip) throws IOException {
        Image image = imageService.uploadImageProd(file, idEqip);
        return ResponseEntity.ok(image);
    }
}
