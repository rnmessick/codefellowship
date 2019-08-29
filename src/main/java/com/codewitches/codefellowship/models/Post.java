package com.codewitches.codefellowship.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String body;

    @CreationTimestamp
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Date createdAt;

    @ManyToOne
    ApplicationUser owner;

    public Post(String body, Date createdAt, ApplicationUser owner) {
        this.body = body;
        this.createdAt = createdAt;
        this.owner = owner;
    }

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

    @Override
    public String toString() {
        return String.format("From %s, on %s. %s.", this.owner.username, this.createdAt, this.body );
    }
}
