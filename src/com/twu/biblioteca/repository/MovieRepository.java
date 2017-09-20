package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.Movie;

import java.util.List;

/**
 * Created by pezhang on 20/09/2017.
 */
public interface MovieRepository {
    public List<Movie> getMovies();
}
