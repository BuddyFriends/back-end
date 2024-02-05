package com.buddyFriends.buddyFriends.controller;

import com.buddyFriends.buddyFriends.base.dto.PetDto;
import com.buddyFriends.buddyFriends.base.dto.ProfileDto;
import com.buddyFriends.buddyFriends.base.dto.UserDto;
import com.buddyFriends.buddyFriends.base.projection.GetUser;
import com.buddyFriends.buddyFriends.service.AmazonS3Service;
import com.buddyFriends.buddyFriends.service.PostService;
import com.buddyFriends.buddyFriends.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final AmazonS3Service amazonS3Service;
    private final PostService postService;

    @PostMapping("/join")
    public String join(@RequestBody UserDto userDto){
        String res = userService.join(userDto);

        return res;
    }

    @PostMapping("/login")
    public GetUser login(@RequestBody UserDto userDto){

        GetUser user = userService.login(userDto);

        return user;
    }

    @PostMapping("/logout")
    public String logout(@RequestParam("userId") String userId){

        String res = userService.logout(userId);

        return res;
    }

    @PutMapping("/update")
    public String editProfile(@RequestParam("profile") String profileDto, @RequestParam("image") MultipartFile multipartFile) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        ProfileDto mapperProfileDto = mapper.readValue(profileDto, ProfileDto.class);

        String imageFile  = amazonS3Service.saveFile(multipartFile);
        mapperProfileDto.setUserImage(imageFile);

        String res = userService.editProfile(mapperProfileDto);

        return res;
    }

    @PutMapping("/smell")
    public  String updateSmell(@RequestParam("postId") Long postId, @RequestParam("userId") String userId, @RequestParam("smell") float smell) {

        String res = userService.updateSmell(postId, userId, smell);

        return res;
    }

}
