package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String username;

    private String password;

    private String firstName;

    private  String lastName;

    public User(int id, String username, String password, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JoinColumn
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Blog> blogList=new ArrayList<>();

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}