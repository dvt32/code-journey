package net.dvt32.jpa.hibernate.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.dvt32.jpa.hibernate.demo.entity.Course;

@RepositoryRestResource(path="courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
	List<Course> findByNameAndId(String name, Long id);
	List<Course> findByName(String name);
	List<Course> countByName(String name);
	List<Course> findByNameOrderByIdDesc(String name);
	List<Course> deleteByName(String name);
	
	@Query("SELECT c FROM Course c WHERE name LIKE '%100 Steps'")
	List<Course> courseswWith100StepsInName();
	
	@Query(value = "SELECT * FROM Course c WHERE name LIKE '%100 Steps'", nativeQuery=true)
	List<Course> courseswWith100StepsInNameUsingNativeQuery();
	
	@Query(name = "query_get_100_Step_courses")
	List<Course> courseswWith100StepsInNameUsingNamedQuery();
}
