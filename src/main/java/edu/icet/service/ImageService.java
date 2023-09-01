package edu.icet.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    String uploadImage(MultipartFile imageFile) throws IOException;
    byte[] getImage(String imageName);
}
