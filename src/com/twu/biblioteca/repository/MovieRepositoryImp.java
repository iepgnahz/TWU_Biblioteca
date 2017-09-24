package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.Movie;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pezhang on 20/09/2017.
 */
public class MovieRepositoryImp implements MovieRepository {
    public static Movie movie1 = new Movie("movie1", "2015", "director1", "8");
    public static Movie movie2 = new Movie("movie2", "2015", "director2", "9");
    public static Movie[] movieList = new Movie[]{movie1, movie2};

    @Override
    public List<Movie> getMovies() {
        return Arrays.asList(movieList).stream().filter(movie -> movie.getAvailable()).collect(Collectors.toList());
    }

    @Override
    public Boolean updateMovie(String movieName) {
        for (int i = 0; i < movieList.length; i++) {
            if (movieList[i].getName().equals(movieName) && movieList[i].getAvailable()) {
                movieList[i].setAvailable(false);
                return true;
            }
        }
        return false;
    }
}
