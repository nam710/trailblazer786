package com.example.trlblzrs;

public class ClassModel {
    String Title,Subject;

    public ClassModel(String title, String subject) {
        Title = title;
        Subject = subject;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
