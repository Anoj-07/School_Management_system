package com.Spring_Boot_DataJPA.Data_JPA.repository;

import com.Spring_Boot_DataJPA.Data_JPA.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends  JpaRepository<Course, Long> {


    /*Custom method for paging and sorting*/
    Page<Course> findByTitleContaining(
            String title,
            Pageable pageable
    );
}
