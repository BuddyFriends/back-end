package com.buddyFriends.buddyFriends.controller;

import com.buddyFriends.buddyFriends.base.dto.UserDto;
import com.buddyFriends.buddyFriends.base.projection.GetUser;
import com.buddyFriends.buddyFriends.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public String join(@RequestBody UserDto userDto){
        String success = userService.join(userDto);

        return success;
    }

    @PostMapping("/login")
    public GetUser login(@RequestBody UserDto userDto){

        GetUser user = userService.login(userDto);

        return user;
    }

}
