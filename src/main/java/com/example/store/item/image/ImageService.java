package com.example.store.item.image;

import com.example.store.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;
    private ItemService itemService;

    public ImageService(ImageRepository imageRepository, ItemService itemService) {
        this.imageRepository = imageRepository;
        this.itemService = itemService;
    }

    public String uploadImage(MultipartFile file, Long itemId) throws IOException {
        Image imageToSave = Image.builder()
                .name(file.getOriginalFilename())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .itemId(itemId)
                .build();
        imageRepository.save(imageToSave);
        return "file uploaded successfully: " + file.getOriginalFilename();
    }

    public byte[] downloadImage(String imageName){
        Optional<Image> dbImage = imageRepository.findByName(imageName);
        return dbImage.map(image ->
            ImageUtil.decompressImage(image.getImageData())
        ).orElse(null);
    }
}
