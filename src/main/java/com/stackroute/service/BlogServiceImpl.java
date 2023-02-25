package com.stackroute.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Override
	public Blog saveBlog(Blog blog)  {
		return blogRepository.save(blog);
	}

	@Override
	public List<Blog> getAllBlogs() {
		List<Blog> allBlogs = null;
		try {
			allBlogs = blogRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allBlogs;
	}

	@Override
	public Blog getBlogById(int id) {
		try {
			Optional<Blog> findById = blogRepository.findById(id);
			if (findById.isPresent())
				return findById.get();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Blog deleteBlog(int id) {
		Optional<Blog> findById = blogRepository.findById(id);
		if (findById.isPresent()) {
			Blog blog = blogRepository.findById(id).get();
			blogRepository.deleteById(id);
			return blog;
		}
		return null;
	}

	@Override
	public Blog updateBlog(Blog blog) {
		Optional<Blog> findById = blogRepository.findById(blog.getBlogId());
		if (findById.isPresent()) {
			blogRepository.save(blog);
			return blogRepository.findById(blog.getBlogId()).get();
		}
		return null;
	}

}
