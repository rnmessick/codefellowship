package com.codewitches.codefellowship.controllers;

import com.codewitches.codefellowship.models.ApplicationUser;
import com.codewitches.codefellowship.models.ApplicationUserRepository;
import com.codewitches.codefellowship.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PostController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    PostRepository postRepository;
}
