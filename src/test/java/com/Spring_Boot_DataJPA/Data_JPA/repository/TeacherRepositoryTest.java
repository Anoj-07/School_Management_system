package com.Spring_Boot_DataJPA.Data_JPA.repository;

import com.Spring_Boot_DataJPA.Data_JPA.entity.Course;
import com.Spring_Boot_DataJPA.Data_JPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveAllTeacher(){
        Course course = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(5)
                .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("Barnali")
                        .lastName("Barman")
                       /* .courses(List.of(course, courseJava))*/
                        .build();

        teacherRepository.save(teacher);
    }
    public void PrintAllTeacher(){

    }
}