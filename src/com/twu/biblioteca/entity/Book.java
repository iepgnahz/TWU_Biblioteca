package com.twu.biblioteca.entity;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

public class Book {
    private String name;
    private String author;
    private String publishYear;
    private Boolean isCheckedOut;

    public Book(String name, String author, String publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.isCheckedOut = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public Boolean getCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(Boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }
}
