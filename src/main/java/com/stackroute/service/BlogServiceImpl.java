package com.stackroute.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;import org.jvnet.fastinfoset.sax.helpers.FastInfosetDefaultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;

import net.bytebuddy.asm.Advice.Return;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Override
	public Blog saveBlog(Blog blog) throws RuntimeException {
//		Blog savedBlog=null;
//		try {
//			savedBlog = blogRepository.save(blog);
//		} catch (RuntimeException e) {
//		   e.printStackTrace();
//		}
//		return savedBlog;
		return blogRepository.save(blog);
	}

	@Override
	public List<Blog> getAllBlogs() {
		List<Blog> allBlogs =null;
	try {
		allBlogs= blogRepository.findAll();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return allBlogs;	
	}

	@Override
	public Blog getBlogById(int id) {
//		Blog blogByID =null;
//		Optional<Blog> findById;
       try {
   		 Optional<Blog> findById = blogRepository.findById(id);
//   				.
//   				orElseThrow(
//   						()->new RuntimeException("blog Not Found with given ID"));

   		 if(findById.isPresent())
   			 return findById.get();
	} catch (Exception e) {
		e.printStackTrace();
	}
     
       return null;
	}

	@Override
	public Blog deleteBlog(int id) {
	   Optional<Blog> findById = blogRepository.findById(id);
	   if(findById.isPresent()) {
		   Blog blog = blogRepository.findById(id).get();
		   blogRepository.deleteById(id);
		   return blog;
	   }
	return null;
	}

	@Override
	public Blog updateBlog(Blog blog) {
//		Blog data = getBlogById(blog.getBlogId());
//		if(data!=null)
//		    return saveBlog(blog);
////		if(data!=null)
////		return blogRepository.updateBlogById(blog.getBlogId(), blog.getAuthorName(), blog.getBlogTitle(), blog.getBlogContent());
//		return null;
		Optional<Blog> findById = blogRepository.findById(blog.getBlogId());
		if(findById.isPresent())
		{
			 blogRepository.save(blog);
			return blogRepository.findById(blog.getBlogId()).get();
		}
		return null;
	}

}
