package no.taardal.mvpdaggerexample.api;

import com.android.volley.Response;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.movie.Movie;

public class TheMovieDatabaseApiMock implements MovieApi {

    private Movie[] movies;

    @Inject
    public TheMovieDatabaseApiMock() {
        movies = getMovies();
    }

    @Override
    public void requestUpcomingMovies(Response.Listener<Movie[]> responseListener, Response.ErrorListener errorListener) {
        responseListener.onResponse(movies);
    }

    @Override
    public void requestSearch(String query, Response.Listener<Movie[]> responseListener, Response.ErrorListener errorListener) {
        responseListener.onResponse(movies);
    }

    private Movie[] getMovies() {
        Movie[] movies = new Movie[10];
        for (int i = 0; i < movies.length; i++) {
            Movie movie = new Movie();
            movie.setTitle("MockMovie_" + (i + 1));
            movies[i] = movie;
        }
        return movies;
    }

}
