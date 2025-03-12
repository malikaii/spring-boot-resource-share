package com.example.spring_boot_resource_share.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.spring_boot_resource_share.entity.Post;

public interface PostRepository extends CrudRepository<Post, Long>{

    List<Post> findByUser(String user);

    List<Post> findByTitle(String title);

    List<Post> findByCategory(String category);


}
