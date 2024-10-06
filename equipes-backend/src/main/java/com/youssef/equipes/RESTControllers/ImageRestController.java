package com.youssef.equipes.RESTControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.youssef.equipes.entities.Equipe;
import com.youssef.equipes.entities.Image;
import com.youssef.equipes.services.EquipeService;
import com.youssef.equipes.services.ImageService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
    @Autowired
    ImageService imageService;
    @Autowired
    EquipeService equipeService;
    
    @RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
    public void uploadImageFS(@RequestParam("image") MultipartFile file,@PathVariable("id") Long id) throws IOException {
    	Equipe p = equipeService.getEquipe(id);
    	p.setImagePath(id+".jpg");
    	Files.write(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()), file.getBytes());
    	equipeService.saveEquipe(p);
    }
    @RequestMapping(value = "/loadfromFS/{id}" ,
    		method = RequestMethod.GET,
    		produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {
    	Equipe p = equipeService.getEquipe(id);
    	return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
    }

    // Corrected path with proper variable usage and typo fixed
    @PostMapping(value = "/uploadImageEqip/{idEqip}")
    public Image uploadMultiImages(@RequestParam("image") MultipartFile file, @PathVariable("idEqip") Long idEqip)
            throws IOException {
        return imageService.uplaodImageProd(file, idEqip);
    }

    // Example of other endpoints
    @RequestMapping(value = "/getImagesEqip/{idEqip}", method = RequestMethod.GET)
    public List<Image> getImagesEqip(@PathVariable("idEqip") Long idEqip) throws IOException {
        return imageService.getImagesParProd(idEqip);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }

    @RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
    public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
        return imageService.getImageDetails(id);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
        return imageService.getImage(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteImage(@PathVariable("id") Long id) {
        imageService.deleteImage(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Image updateImage(@RequestParam("image") MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }
}
