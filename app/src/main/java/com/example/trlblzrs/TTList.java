package com.example.trlblzrs;

public class TTList {
    String subject;
    String time;

    public TTList(String subject, String time) {
        this.subject = subject;
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}