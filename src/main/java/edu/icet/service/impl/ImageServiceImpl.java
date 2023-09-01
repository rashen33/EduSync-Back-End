package edu.icet.service.impl;

import edu.icet.dao.ImageEntity;
import edu.icet.repository.ImageRepository;
import edu.icet.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Override
    public String uploadImage(MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            byte[] bytes = imageFile.getBytes();
            String base64Image = Base64.getEncoder().encodeToString(bytes);

            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setImageData(base64Image);
            imageEntity.setImageName(imageFile.getOriginalFilename());
            imageEntity.setImageType(imageFile.getContentType());
            imageRepository.save(imageEntity);

            return "Image uploaded successfully.";
        } else {
            return "Image upload failed.";
        }
    }
    @Override
    public byte[] getImage(String imageName) {
        Optional<ImageEntity> imageEntityOptional = imageRepository.findByImageName(imageName);
        return Base64.getDecoder().decode(imageEntityOptional.get().getImageData());
    }
}
