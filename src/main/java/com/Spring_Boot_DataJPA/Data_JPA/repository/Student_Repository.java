package com.Spring_Boot_DataJPA.Data_JPA.repository;

import com.Spring_Boot_DataJPA.Data_JPA.entity.Guardian;
import com.Spring_Boot_DataJPA.Data_JPA.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Student_Repository extends JpaRepository<Student, Long>{


    /* All the below are define for testing purpose Onlyl*/


    //Sample to call inside method
    List<Student> findByFirstName(String firstName);

    /*List<Student> findByGuardianName(String guardianName);*/


    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress (String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress (String emailId);


    /*Native Query*/
    @Query(
            value = "SELECT * FROM table_student s where s.email_address = ?1;",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);


    /*Query named params (parameters)*/
    @Query(
            value = "SELECT * FROM table_student s where s.email_address = :emailId;",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeName(@Param("emailId") String emailId);


    /*Update */
    @Modifying
    @Transactional
    @Query(
            value = "update table_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);

}


