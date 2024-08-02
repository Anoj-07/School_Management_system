package com.Spring_Boot_DataJPA.Data_JPA.repository;

import com.Spring_Boot_DataJPA.Data_JPA.entity.Course;
import com.Spring_Boot_DataJPA.Data_JPA.entity.Student;
import com.Spring_Boot_DataJPA.Data_JPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses =
                courseRepository.findAll();
        System.out.println("courses = " + courses);
    }


    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Nazural")
                .lastName("Aslam")
                .build();

        Course course = Course.builder()
                .title("python")
                .credit(5)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    /*Pagination and sorting*/
    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecord =
                PageRequest.of(0, 3);

        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecord).getContent();

        System.out.println("courses = " + courses);

        Long totalElements =
                courseRepository.findAll(firstPageWithThreeRecord).getTotalElements();

        System.out.println("totalElements = " + totalElements);


    }


    @Test
    public void findALlSorting(){
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                );

        List<Course> courses =
                courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }


    /*Custom Method*/
    @Test
    public void findByTitleContaining() {
        Pageable firstPageTenRecord =
                PageRequest.of(0, 10);

        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "J",
                        firstPageTenRecord
                ).getContent();

        System.out.println("courses = " + courses);
    }

    /*Many to many test*/
@Test
    public void sveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Manoj")
                .lastName("singh")
                .build();

        Student student = Student.builder()
                .firstName("arpan")
                .lastName("rawal")
                .emailId("arpan@gmail.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(4)
                .teacher(teacher)
                .build();

        course.addStudent(student);

        courseRepository.save(course);
    }
}