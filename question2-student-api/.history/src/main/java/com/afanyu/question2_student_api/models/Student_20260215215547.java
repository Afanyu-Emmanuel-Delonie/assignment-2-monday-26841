package com.afanyu.question2_student_api.models;

public class Student {
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;

    public Students() {}

    public Student(Long studentId, String firstName, String lastName, String email, String major, Double gpa) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
    }

}
