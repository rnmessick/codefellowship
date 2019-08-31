package com.codewitches.codefellowship.controllers;

import com.codewitches.codefellowship.models.ApplicationUser;
import com.codewitches.codefellowship.models.ApplicationUserRepository;
import com.codewitches.codefellowship.models.Post;
import com.codewitches.codefellowship.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Date;

@Controller
public class PostController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    PostRepository postRepository;

    @GetMapping("/posts/newPost")
    public String getNewPostForm() {
        return "addPost";
    }

    @PostMapping("/posts")
    public RedirectView createPost(String body, Date createdAt, Principal p) {
        ApplicationUser loggedInUser = applicationUserRepository.findByUsername(p.getName());
        Post newPost = new Post(body, createdAt, loggedInUser);
        postRepository.save(newPost);
        return new RedirectView("/userProfile");
    }


}
