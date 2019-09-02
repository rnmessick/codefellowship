package com.codewitches.codefellowship.controllers;

import com.codewitches.codefellowship.models.ApplicationUser;
import com.codewitches.codefellowship.models.ApplicationUserRepository;
import com.codewitches.codefellowship.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.*;

@Controller
public class ApplicationUserController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @PostMapping("/users")
    public RedirectView createUser(String username, String password, String firstName, String lastName, Date dateOfBirth, String bio) {
        ApplicationUser newUser = new ApplicationUser(username,
                // bcrypt handles hashing/salting
                encoder.encode(password),
                firstName, lastName, dateOfBirth, bio);
        applicationUserRepository.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/userProfile");
    }

    @GetMapping("/users/{id}")
    public String showOneUser(@PathVariable long id, Principal p, Model m) {
        m.addAttribute("viewedUser", applicationUserRepository.findById(id).get());
        m.addAttribute("user", p);
        return "userProfile";
    }

    @GetMapping("/userProfile")
    public String showUserProfile(Principal p, Model m) {
        m.addAttribute("viewedUser", applicationUserRepository.findByUsername(p.getName()));
        m.addAttribute("user", p);

        return "userProfile";
    }

    @GetMapping("/users/follow")
    public String getAllUsers(Model m) {
        m.addAttribute("users", applicationUserRepository.findAll());
        return "allUsers";
    }

    @PostMapping("users/follow")
    public RedirectView addUserFollow(Long id, Principal p) {
        ApplicationUser followingUserCurrent = applicationUserRepository.findByUsername(p.getName());
        ApplicationUser followedUser = applicationUserRepository.findById(id).get();
        followingUserCurrent.addFollow(followedUser);
        applicationUserRepository.save(followingUserCurrent);
        return new RedirectView("/feed");
    }

    @GetMapping("/feed")
    public String getFeed(Principal p, Model m) {
        ApplicationUser currentUser = applicationUserRepository.findByUsername(p.getName());
        Set<ApplicationUser> usersThatIFollow = currentUser.getUsersThatIFollow();
        List<Post> myFollowedFeed = new LinkedList<>();
        for (ApplicationUser user : usersThatIFollow) {
            myFollowedFeed.addAll( user.getPosts());
        }
        m.addAttribute("feed", myFollowedFeed);
        m.addAttribute("user", p);
        return "feed";
    }



}
