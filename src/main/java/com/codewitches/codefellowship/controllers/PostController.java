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

    @GetMapping("/posts")
    public String showPosts(@PathVariable long id, Principal p, Model m) {
        m.addAttribute("viewedUser", applicationUserRepository.findById(id).get());
        m.addAttribute("user", p);
        return "post";
    }
    @PostMapping("/posts")
    public RedirectView createPost(String body, Date createdAt) {
        Post newPost = new Post(body, createdAt);
        postRepository.save(newPost);
        return new RedirectView("/myProfile");
    }
}
