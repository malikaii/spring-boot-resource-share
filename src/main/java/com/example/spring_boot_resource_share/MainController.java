package com.example.spring_boot_resource_share;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_resource_share.dao.PostRepository;
import com.example.spring_boot_resource_share.entity.Post;
import com.example.spring_boot_resource_share.service.PostService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MainController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @Autowired
    private Environment env;

    @GetMapping(path ="/")
    public String status() {
        return "Working on port " + env.getProperty("server.port") + "!";
    }

    @GetMapping(path ="/listings/all")
    public Iterable<Post> getAllListings() {
        return postService.getAllPosts();
    }

    @GetMapping(path ="/listing/category")
    public List<Post> getListingByCategory(@RequestParam String category) {
        return postService.getPostsByCategory(category);
    }

    @PostMapping(path = "/listing/new")
    public Post createListing(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @PutMapping(path = "/listing/update")
    public Post updateListing(@RequestBody Post post) {
        return postService.updatePost(post);
    }

}
