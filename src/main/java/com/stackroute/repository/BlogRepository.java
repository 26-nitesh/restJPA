package com.stackroute.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.domain.Blog;

/* Add annotation to declare this class as a Repository class.
This interface should extend CRUD Repository
* */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer>{
//	@Transactional
//	@Modifying
//	@Query("update Blog b set b.authorName=:authorName, b.blogContent=:blogContent, b.blogTitle=:blogTitle where b.blogId=:blogId")
//	public Blog updateBlogById(@Param("blogId")int id,@Param("authorName") String authorName,@Param("blogTitle") String blogTitle,@Param("blogContent") String blogContent);
}
