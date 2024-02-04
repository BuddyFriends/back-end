package com.buddyFriends.buddyFriends.controller;

import com.buddyFriends.buddyFriends.base.dto.PostDto;
import com.buddyFriends.buddyFriends.entity.PostEntity;
import com.buddyFriends.buddyFriends.repository.PostRepository;
import com.buddyFriends.buddyFriends.repository.UserRepository;
import com.buddyFriends.buddyFriends.repository.PetRepository;
import com.buddyFriends.buddyFriends.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public String createPost(@RequestBody PostDto postDto) {
        String res = postService.createPost(postDto);
        return res;
    }

    @GetMapping("/bySpecies/{species}")
    public ResponseEntity<List<PostEntity>> getPostsBySpecies(@PathVariable String species) {
        List<PostEntity> posts = postService.getPostsByPetSpecies(species);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostEntity> getPost(@PathVariable Long postId) {
        PostEntity post = postService.getPost(postId);
        return ResponseEntity.ok(post);
    }
}
