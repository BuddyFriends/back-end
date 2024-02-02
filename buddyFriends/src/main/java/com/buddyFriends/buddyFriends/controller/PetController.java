package com.buddyFriends.buddyFriends.controller;

import com.buddyFriends.buddyFriends.base.dto.PetDto;
import com.buddyFriends.buddyFriends.entity.PetEntity;
import com.buddyFriends.buddyFriends.service.AmazonS3Service;
import com.buddyFriends.buddyFriends.service.PetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pet")
public class PetController {

    private final PetService petService;
    private final AmazonS3Service amazonS3Service;

    @PostMapping("/add")
    public String addPet(@RequestParam("pet") String petDto, @RequestParam("image") MultipartFile multipartFile) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        PetDto mapperPetDto = mapper.readValue(petDto, PetDto.class);

        String imageFile  = amazonS3Service.saveFile(multipartFile);
        mapperPetDto.setPetImage(imageFile);

        String success = petService.addPet(mapperPetDto);

        return success;
    }


    @GetMapping("/list/{userId}")
    public ResponseEntity<List<PetDto>> getAllPetsByUserId(@PathVariable String userId) {
        List<PetDto> pets = petService.getAllPetsByUserId(userId);
        return ResponseEntity.ok(pets);
    }
}
