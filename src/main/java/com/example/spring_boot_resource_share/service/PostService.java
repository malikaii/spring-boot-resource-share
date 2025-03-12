package com.example.spring_boot_resource_share.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.spring_boot_resource_share.dao.PostRepository;
import com.example.spring_boot_resource_share.entity.Post;



@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Post post) {
        if(!postRepository.findById(post.getId()).isPresent()) {
            return null;
        }
        return postRepository.save(post);
    }

    public void deletePost(Long postId){
        postRepository.deleteById(postId);
    }

//     public Post deletePostByTitle(String title){

//         try{
// List<Post> postToBeDeleted = postRepository.findByTitle(title);
//         postRepository.dele(postId);
//         }catch(EmptyResultDataAccessException e) {
//             return null;
//         }
        
//     }

    public Iterable<Post> getAllPosts(){
        return postRepository.findAll();
    }
    public List<Post> getPostsByUser(String user){
        return postRepository.findByUser(user);
    }
    public List<Post> getPostsByTitle(String title){
        return postRepository.findByTitle(title);
    }

    public List<Post> getPostsByCategory(String category){
        return postRepository.findByCategory(category);
    }


}
