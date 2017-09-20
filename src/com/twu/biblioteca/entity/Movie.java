package com.twu.biblioteca.entity;

/**
 * Created by pezhang on 20/09/2017.
 */
public class Movie {
    private String name;
    private String year;
    private String director;
    private Boolean available;
    private String rating;

    public Boolean getAvailable() {
        return available;
    }

    public Movie(String name, String year, String director, String rating) {
        this.available = true;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
