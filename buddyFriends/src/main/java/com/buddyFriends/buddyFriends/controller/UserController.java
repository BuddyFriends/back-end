package com.buddyFriends.buddyFriends.controller;

import com.buddyFriends.buddyFriends.base.dto.UserDto;
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
        String userId = userService.join(userDto);

        return userId + "의 가입 성공";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto){
        String userId = userService.login(userDto);

        return userId;
    }

}
