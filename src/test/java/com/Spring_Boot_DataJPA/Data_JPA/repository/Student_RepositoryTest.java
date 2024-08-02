package com.Spring_Boot_DataJPA.Data_JPA.repository;

import com.Spring_Boot_DataJPA.Data_JPA.entity.Guardian;
import com.Spring_Boot_DataJPA.Data_JPA.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Student_RepositoryTest {

    @Autowired
    private Student_Repository studentRepository;
    private Guardian guardian;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("anojrawal09@gmail.com")
                .firstName("Anoj")
                .lastName("Rawal")
                /*.guardianName("Kul Bahadur Rawal")
                .guardianEmail("kulrawal12345@gmail.com")
                .guardianMobile("9848682901")*/
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudent1(){
        Student student = Student.builder()
                .emailId("paru09@gmail.com")
                .firstName("pramila")
                .lastName("khadka")
                /*.guardianName("chetman khadka")
                .guardianEmail("chetmanKhadka12345@gmail.com")
                .guardianMobile("9785739423")*/
                .build();

        studentRepository.save(student);
    }


    @Test
    /*With guardian method*/
    public void save_with_Guardian13(){
        Guardian guardian2 = Guardian.builder()
                .Email("Hii12345@gamil.com")
                .Mobile("9892407324")
                .Name("Hii")
                .build();

        Student student1 = Student.builder()
                .emailId("Hello039@gmail.com")
                .firstName("Good N")
                .lastName("Night")
                .guardian(guardian2)
                .build();

        studentRepository.save(student1);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }


    @Test
    public void printByFirstName(){
        List<Student> students =
                studentRepository.findByFirstName("Pramila");

        System.out.println("students = " + students);
    }


/*
    @Test
    public void printByGuardianName(){
        List<Student> students=
                studentRepository.findByGuardianName("kul");

        System.out.println("students = " + students);
    }*/


    /*JPQL*/
    @Test
    public void printgetStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress("paru09@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String student =
                studentRepository.getStudentFirstNameByEmailAddress("paru09@gmail.com");

        System.out.println("student = " + student);
    }


    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student=
                studentRepository.getStudentByEmailAddressNative("anojrawal09@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void PrintGetStudentByEmailAddressNativeParams(){
        Student student=
                studentRepository.getStudentByEmailAddressNativeName("anojrawal09@gmail.com");

        System.out.println("student = " + student);
    }
    
    /*Test for Update*/
    @Test
    public void TestupdateStudentNameByEmailId(){
       studentRepository.updateStudentNameByEmailId("Good Morning","Hello039lll@gmail.com");

        System.out.println("studentRepository = " + studentRepository);
    }

}