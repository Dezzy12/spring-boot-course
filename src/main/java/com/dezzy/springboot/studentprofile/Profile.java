package com.dezzy.springboot.studentprofile;

import com.dezzy.springboot.student.Student;
import jakarta.persistence.*;

@Entity
public class Profile {

    @Id
    @GeneratedValue
    private String Id;

    private String bio;

    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;

    public Profile() {
    }

    public Profile(String bio) {
        this.bio = bio;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
