package com.twu.biblioteca.controller;

import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.MovieRepositoryImp;

import java.util.List;

/**
 * Created by pezhang on 20/09/2017.
 */
public class MovieManager {
    public List<Movie> getMovieLists(){
        MovieRepository movieRepository = new MovieRepositoryImp();
        return movieRepository.getMovies();
    }

}
