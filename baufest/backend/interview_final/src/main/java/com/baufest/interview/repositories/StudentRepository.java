package com.baufest.interview.repositories;

import com.baufest.interview.model.Lecture;
import com.baufest.interview.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Student set lectures = :lectures WHERE student_id = :id")
    public void updateLectures(@Param(value = "id") Long id, @Param(value = "lectures") List<Lecture> lectures);

}
