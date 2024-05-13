package com.baufest.interview.controllers;

import com.baufest.interview.model.Lecture;
import com.baufest.interview.model.Student;
import com.baufest.interview.services.LectureService;
import com.baufest.interview.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lecture")
public class LecturesController {

    private LectureService lectureService;

    @Autowired
    public LecturesController(LectureService lectureService){
        this.lectureService = lectureService;
    }

    @GetMapping()
    public ResponseEntity<List<Lecture>> getLectures(){
        List<Lecture> lstLectures = lectureService.getLectures();
        return new ResponseEntity<>(lstLectures, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lecture> getLecture(@PathVariable Long id){
        Lecture lecture = lectureService.getLectureById(id);
        return new ResponseEntity<>(lecture, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> saveLecture(@RequestBody Lecture lecture) {
        lectureService.saveLecture(lecture);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLecture(@PathVariable Long id){
        lectureService.deleteLecture(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PatchMapping("/{id}/{studentId}")
    public ResponseEntity<Lecture> updateStudents(@PathVariable Long id, @PathVariable Long studentId){
        Lecture lecture = lectureService.assignLectureToStudents(id, studentId);
        return new ResponseEntity<>(lecture, HttpStatus.OK);
    }
}
