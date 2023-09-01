package edu.icet.controller;

import com.sun.net.httpserver.Authenticator;
import edu.icet.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        imageService.uploadImage(imageFile);
        return "Image uploaded :" + imageFile.getOriginalFilename();
    }

    @GetMapping("/{imageName}")
    public byte[] getImage(@PathVariable String imageName){
        return imageService.getImage(imageName);
    }

}
