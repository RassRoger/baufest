package com.baufest.interview.repositories;

import com.baufest.interview.model.Lecture;
import com.baufest.interview.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {


    @Query("UPDATE Lecture set students = :students WHERE lecture_id = :id")
    void updateStudents(@Param(value = "id")Long id, @Param(value = "students") List<Student> students);
}
