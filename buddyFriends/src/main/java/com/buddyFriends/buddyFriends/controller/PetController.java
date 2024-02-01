package com.buddyFriends.buddyFriends.controller;

import com.buddyFriends.buddyFriends.base.dto.PetDto;
import com.buddyFriends.buddyFriends.entity.PetEntity;
import com.buddyFriends.buddyFriends.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pet")
public class PetController {

    private final PetService petService;

    @PostMapping("/add")
    public String addPet(@RequestBody PetDto petDto) {
        String success = petService.addPet(petDto);
        return success;
    }


    @GetMapping("/list/{userId}")
    public ResponseEntity<List<PetDto>> getAllPetsByUserId(@PathVariable String userId) {
        List<PetDto> pets = petService.getAllPetsByUserId(userId);
        return ResponseEntity.ok(pets);
    }
}
