package com.buddyFriends.buddyFriends.controller;

import com.buddyFriends.buddyFriends.base.dto.ProfileDto;
import com.buddyFriends.buddyFriends.base.dto.UserDto;
import com.buddyFriends.buddyFriends.base.projection.GetUser;
import com.buddyFriends.buddyFriends.service.PostService;
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
    public String editProfile(@RequestBody ProfileDto profileDto){

        String res = userService.editProfile(profileDto);

        return res;
    }

    @PutMapping("/smell")
    public  String updateSmell(@RequestParam("postId") Long postId, @RequestParam("userId") String userId, @RequestParam("smell") float smell) {

        String res = userService.updateSmell(postId, userId, smell);

        return res;
    }

}
