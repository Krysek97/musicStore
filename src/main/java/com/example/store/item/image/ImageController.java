package com.example.store.item.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/add/{itemId}")
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file, @PathVariable Long itemId) throws IOException{
        String uploadImage = imageService.uploadImage(file, itemId);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<?> downloadImage (@PathVariable Long itemId){
        byte[] imageData = imageService.downloadImage(itemId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(MediaType.IMAGE_PNG_VALUE))
                .body(imageData);
    }

}
