package com.dilip.StudentCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dilip.StudentCrud.beans.Student;

public interface StudentRepository extends JpaRepository<Student, Integer >{

}
