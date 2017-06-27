package com.ai.demos.model.student;

public class Course {
    private Long id;

    private String name;

    private String teacherName;

    private String state;

    private byte[] teacherId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public byte[] getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(byte[] teacherId) {
        this.teacherId = teacherId;
    }
}