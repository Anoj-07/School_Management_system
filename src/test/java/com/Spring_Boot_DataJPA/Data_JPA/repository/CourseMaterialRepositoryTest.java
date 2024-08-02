package com.Spring_Boot_DataJPA.Data_JPA.repository;

import com.Spring_Boot_DataJPA.Data_JPA.entity.Course;
import com.Spring_Boot_DataJPA.Data_JPA.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;



    @Test
    /*To save date in Date base*/
    public void SaveCourseMaterial(){

        /*Define the course object*/
        Course course = Course.builder()
                .title(".net")
                .credit(7)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.faceBook.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void PrintAllCoursesMaterials(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();

        System.out.println("courseMaterialList = " + courseMaterialList);
    }

    @Test
    public void PrintfindByUrl(){
        List<CourseMaterial> courseMaterial =
                courseMaterialRepository.findByUrl("www.whatsApp.com");

        System.out.println("courseMaterial = " + courseMaterial);

    }
}