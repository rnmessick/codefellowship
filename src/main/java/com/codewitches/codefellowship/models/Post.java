package com.codewitches.codefellowship.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String body;
    Date createdAt;

    @ManyToOne
    ApplicationUser owner;

    public long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public ApplicationUser getOwner() {
        return owner;
    }

    public Post(String body, Date createdAt) {
        this.body = body;
        this.createdAt = createdAt;
    }

    public Post() {}
}
