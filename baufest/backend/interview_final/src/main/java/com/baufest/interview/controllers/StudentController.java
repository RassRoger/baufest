package com.baufest.interview.controllers;

import com.baufest.interview.model.Lecture;
import com.baufest.interview.model.Student;
import com.baufest.interview.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> lstStudents = studentService.getStudents();
        return new ResponseEntity<>(lstStudents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student Student = studentService.getStudentById(id);
        return new ResponseEntity<>(Student, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PatchMapping(value = {"/{id}/{lectureId}", "/{id}"})
    public ResponseEntity<Student> updateLectures(@PathVariable Long id, @PathVariable Long lectureId){
        Student student = studentService.assignStudentToLecture(id, lectureId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


}
