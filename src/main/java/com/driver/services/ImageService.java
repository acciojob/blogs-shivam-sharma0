package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog= blogRepository2.findById(blogId).get();
        Image image= new Image(description,dimensions,blog);
        blog.getImageList().add(image);
        blogRepository2.save(blog);
        return image;
    }

    public void deleteImage(Integer id){
       imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        String arr[] = screenDimensions.split("X");
        Integer x=Integer.parseInt(arr[0]);
        Integer y=Integer.parseInt(arr[1]);

        Image image=imageRepository2.findById(id).get();
        String imgeScr[]=image.getDimensions().split("X");


        int x1=Integer.parseInt(imgeScr[0]);
        int y1=Integer.parseInt(imgeScr[1]);

        int totalSizeOfImage=x1*y1;
        int screenSize=x*y;


        int firstDim=x/x1;
        int secondDim=y/y1;
        int totalImageCanBeFit=firstDim*secondDim;

       return totalImageCanBeFit;
    }
}
