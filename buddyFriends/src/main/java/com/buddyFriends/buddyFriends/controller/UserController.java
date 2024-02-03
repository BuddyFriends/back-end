package com.buddyFriends.buddyFriends.controller;

import com.buddyFriends.buddyFriends.base.dto.ProfileDto;
import com.buddyFriends.buddyFriends.base.dto.UserDto;
import com.buddyFriends.buddyFriends.base.projection.GetUser;
import com.buddyFriends.buddyFriends.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

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

    @PutMapping("/update")
    public String editProfile(@RequestBody ProfileDto profileDto){

        String res = userService.editProfile(profileDto);

        return res;
    }

}
