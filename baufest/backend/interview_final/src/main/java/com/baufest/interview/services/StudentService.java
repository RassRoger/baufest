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
public class StudentService {

    private StudentRepository studentRepository;
    private LectureRepository lectureRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, LectureRepository lectureRepository){
        this.studentRepository = studentRepository;
        this.lectureRepository = lectureRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseGet(null);
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student assignStudentToLecture(Long id, Long lectureId){
        //studentRepository.updateLectures(id, lectures);
        Student student = getStudentById(id);
        Set<Lecture> lstLectures = new HashSet<>();
        if (lectureId != 0L) {
            Lecture lecture = lectureRepository.findById(lectureId).orElseGet(null);
            if (lecture != null) {
                lstLectures.add(lecture);
            }
        }
        student.setLectures(lstLectures);
        studentRepository.save(student);
        return getStudentById(id);
    }
}
