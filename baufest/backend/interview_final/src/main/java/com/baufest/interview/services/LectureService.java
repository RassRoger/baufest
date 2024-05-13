package com.baufest.interview.services;

import com.baufest.interview.model.Lecture;
import com.baufest.interview.model.Student;
import com.baufest.interview.repositories.LectureRepository;
import com.baufest.interview.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LectureService {

    LectureRepository lectureRepository;
    StudentRepository studentRepository;
    @Autowired
    public LectureService(LectureRepository lectureRepository,
                          StudentRepository studentRepository) {
        this.lectureRepository = lectureRepository;
        this.studentRepository = studentRepository;
    }

    public List<Lecture> getLectures(){
        return lectureRepository.findAll();
    }

    public Lecture getLectureById(Long id) {
        return lectureRepository.findById(id).orElseGet(null);
    }

    public void saveLecture(Lecture lecture){
        lectureRepository.save(lecture);
    }

    public void deleteLecture(Long id) {
        lectureRepository.deleteById(id);
    }

    public Lecture assignLectureToStudents(Long id, Long studentId){
        // lectureRepository.updateStudents(id, students);
        Lecture lecture = getLectureById(id);
        Set<Student> lstStudents = new HashSet<>();
        if (studentId != 0L){
            Student student = studentRepository.findById(studentId).orElseGet(null);
            if (student != null) {
                lstStudents.add(student);
            }
        }
        lecture.setStudents(lstStudents);
        lectureRepository.save(lecture);
        return getLectureById(id);
    }
}
