package com.example.musicalstructureappudacity;

import java.io.Serializable;

public class Book implements Serializable {
    private String bookName;
    private String bookAuthor;
    private int imgId=0;
    private int duration_minutes;
    private int duration_seconds;

    public Book(String bookName, String bookAuthor, int imgId, int duration_minutes, int duration_seconds) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.imgId = imgId;
        this.duration_minutes = duration_minutes;
        this.duration_seconds = duration_seconds;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getDuration_minutes() {
        return duration_minutes;
    }

    public void setDuration_minutes(int duration_minutes) {
        this.duration_minutes = duration_minutes;
    }

    public int getDuration_seconds() {
        return duration_seconds;
    }

    public void setDuration_seconds(int duration_seconds) {
        this.duration_seconds = duration_seconds;
    }
    public boolean hasImage(){
        return imgId!=0;
    }
}
