package com.codewitches.codefellowship.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String firstName;
    String lastName;
    Date dateOfBirth;
    String bio;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    List<Post> posts;

    public List<Post> getPosts() {
        return this.posts;
    }

    @ManyToMany
    @JoinTable(
            name="user_follows",
            joinColumns = {@JoinColumn(name = "PrimaryUser")},
            inverseJoinColumns = { @JoinColumn(name = "followedUser")}
    )
    Set<ApplicationUser> usersThatIFollow;

    @ManyToMany(mappedBy = "usersThatIFollow")
    Set<ApplicationUser> usersThatFollowMe;

    public void addFollow(ApplicationUser followedUser) {
        usersThatIFollow.add(followedUser);
    }

    public Set<ApplicationUser> getUsersThatIFollow() {
        return this.usersThatIFollow;
    }

    public ApplicationUser(String username, String password,
                           String firstName, String lastName,
                           Date dateOfBirth, String bio) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
    }

    public ApplicationUser() {}


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder usersIFollowString = new StringBuilder();
        if( this.usersThatIFollow.size() > 0) {
            usersIFollowString.append(" has posted ");
            for (ApplicationUser followedUser : this.usersThatIFollow) {
                usersIFollowString.append(followedUser.username);
                usersIFollowString.append(", ");
            }

        }
        return String.format(usersIFollowString.toString());
    }
}
