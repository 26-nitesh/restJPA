package com.stackroute.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;

/* Add annotation to declare this class as REST Controller */
@RestController
@RequestMapping("/api/v1/")
public class BlogController {

    /* Provide implementation code for these methods */
//@GetMapping("/test")
//public String ftets() {
//	return "OKKKKKKKKK";
//}
	@Autowired
	private BlogService blogService;
	
    /*This method should save blog and return savedBlog Object */
	@PostMapping("/blog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) throws Exception {
       Blog savedBlog = blogService.saveBlog(blog);
////       if(saveBlog!=null)
//    	   return new ResponseEntity<Blog>(HttpStatus.CREATED);
////       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedBlog);
    }
    

    /*This method should fetch all blogs and return the list of all blogs */
	@GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs() {
      List<Blog> allBlogs = blogService.getAllBlogs();
//      if(allBlogs!=null && !allBlogs.isEmpty())
    	  return new ResponseEntity<>(allBlogs,HttpStatus.FOUND);
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*This method should fetch the blog taking its id and return the respective blog */
	@GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable int id){
    	 Blog blogById = blogService.getBlogById(id);
         if(blogById!=null)
       	  return new ResponseEntity<>(blogById,HttpStatus.OK);
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*This method should delete the blog taking its id and return the deleted blog */
	@DeleteMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogAfterDeleting(@PathVariable int id) {
        Blog blogById = blogService.deleteBlog(id);
        if(blogById!=null) {
        	return new ResponseEntity<>(blogById,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        return ResponseEntity.ok().build();
    }

    /*This method should update blog and return the updatedBlog */
	@PutMapping("/blog")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) {
       Blog updateBlog = blogService.updateBlog(blog);
       if(updateBlog!=null) {
       	return new ResponseEntity<>(updateBlog,HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}