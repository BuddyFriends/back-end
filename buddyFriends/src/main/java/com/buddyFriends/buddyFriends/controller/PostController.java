package com.buddyFriends.buddyFriends.controller;

import com.buddyFriends.buddyFriends.base.dto.post.PostDto;
import com.buddyFriends.buddyFriends.base.dto.post.PostResponseDto;
import com.buddyFriends.buddyFriends.base.dto.post.SimplifiedPostDto;
import com.buddyFriends.buddyFriends.entity.PostEntity;
import com.buddyFriends.buddyFriends.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public String createPost(@RequestBody PostDto postDto) {
        String res = postService.createPost(postDto);
        return res;
    }

    @GetMapping("/bySpecies")
    public ResponseEntity<List<PostEntity>> getPostsBySpecies(@RequestParam("species") String species) {
        List<PostEntity> posts = postService.getPostsByPetSpecies(species);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/detail")
    public ResponseEntity<PostResponseDto> getPost(@RequestParam("postId") Long postId) {
        PostEntity post = postService.getPost(postId);
        PostResponseDto responseDto = new PostResponseDto();

        responseDto.setPostId(post.getPostId());
        responseDto.setUserId(post.getUserId().getUserId());
        responseDto.setPetId(post.getPetId().getPetId());
        responseDto.setTitle(post.getTitle());
        responseDto.setContent(post.getContent());
        responseDto.setPeriodStart(post.getPeriodStart().toString());
        responseDto.setPeriodEnd(post.getPeriodEnd().toString());
        responseDto.setHelperSex(post.getHelperSex());
        responseDto.setDone(post.isDone());
        responseDto.setPickId(post.getPickId());
        responseDto.setCareDone(post.isCareDone());
        responseDto.setSmellDone(post.isSmellDone());

        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/select")
    public String selectApplicant(@RequestParam("postId") Long postId, @RequestParam("userId") String userId) {
        String res = postService.selectApplicant(postId, userId);

        return res;
    }


    @GetMapping("/log")
    public ResponseEntity<List<SimplifiedPostDto>> getLog(
            @RequestParam("care") boolean careDone,
            @RequestParam("userId") String userId,
            @RequestParam("role") String role) {

        List<SimplifiedPostDto> logs = postService.getLog(careDone, userId, role);
        return ResponseEntity.ok(logs);
    }

}

