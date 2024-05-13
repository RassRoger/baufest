package com.baufest.interview.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.*;


@Entity
@Table(name = "lecture")
public class Lecture {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long lecture_id;

    String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "LECTURE_STUDENT_MAPPING", joinColumns = @JoinColumn(name = "lecture_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    Set<Student> students;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Long getLectureId() {
        return lecture_id;
    }

    public void setLectureId(Long lecture_id) {
        this.lecture_id = lecture_id;
    }


}
