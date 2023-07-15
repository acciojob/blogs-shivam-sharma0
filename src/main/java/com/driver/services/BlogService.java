package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        User user =userRepository1.findById(userId).get();
        List<Blog> blogList= user.getBlogList();

        Blog blog=new Blog(title,content, LocalDate. now());
        blog=blogRepository1.save(blog);
        blogList.add(blog);
        user.setBlogList(blogList);
        userRepository1.save(user);

        return blog;

    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
//        Blog blog=blogRepository1.findById(blogId).get();
//
//        List<Image> imageList=
    blogRepository1.deleteById(blogId);
    }
}