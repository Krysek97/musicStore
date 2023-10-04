package com.example.store.item.image;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public String uploadImage(MultipartFile file) throws IOException {
        Image imageToSave = Image.builder()
                .name(file.getOriginalFilename())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .build();
        imageRepository.save(imageToSave);
        return "file uploaded successfully: " + file.getOriginalFilename();
    }

    public byte[] downloadImage(Long itemId){
        Optional<Image> dbImage = imageRepository.findByItemId(itemId);
        return dbImage.map(image ->
            ImageUtil.decompressImage(image.getImageData())
        ).orElse(null);
    }
}
