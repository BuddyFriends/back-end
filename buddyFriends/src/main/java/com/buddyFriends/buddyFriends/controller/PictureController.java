package com.buddyFriends.buddyFriends.controller;


import com.buddyFriends.buddyFriends.base.dto.PetDto;
import com.buddyFriends.buddyFriends.base.dto.PictureDto;
import com.buddyFriends.buddyFriends.entity.PictureEntity;
import com.buddyFriends.buddyFriends.service.AmazonS3Service;
import com.buddyFriends.buddyFriends.service.PictureService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/picture")
public class PictureController {

    private final PictureService pictureService;
    private final AmazonS3Service amazonS3Service;

    @PostMapping("/upload")
    public String upload(@RequestParam("pet") String pictureDto, @RequestParam("image")MultipartFile multipartFile) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        PictureDto mapperPictureDto = mapper.readValue(pictureDto, PictureDto.class);

        String imageFile  = amazonS3Service.saveFile(multipartFile);
        mapperPictureDto.setPictureAdd(imageFile);

        String success = pictureService.addPicture(mapperPictureDto);
        return success;
    }

    @GetMapping("/list")
    public List<PictureEntity> getList(@RequestParam("petId") Integer petId){

        List<PictureEntity> list = pictureService.pictureList(petId);

        return list;

    }


}
