package com.github.in.ghippargi.api.dw.resources;

import com.codahale.metrics.annotation.Timed;
import com.github.in.ghippargi.api.dw.data.MovieData;
import com.github.in.ghippargi.api.dw.db.dao.MovieDao;
import com.github.in.ghippargi.api.dw.db.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * This Resource exposes all REST APIs
 * Base URL is "/movies"
 * Response is in JSON format
 *
 * @author ghippargi
 */
@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieResource.class);

    private final MovieDao movieDao;

    public MovieResource(MovieDao dao) {
        movieDao = dao;
    }

    @GET
    @Timed
    public Response getMovies() {
        LOGGER.info("Fetching movies");
        try {
            List<Movie> movies = movieDao.getAll();
            if (movies != null) {
                LOGGER.info("Fetched movies count - " + movies.size());
                return Response.ok(movies).build();
            }
            else {
                return Response.ok().build();
            }
        }
        catch (Exception e) {
            LOGGER.error("Error while fetching movies", e);
            return Response.serverError().build();
        }
    }

    @GET
    @Timed
    @Path("{id}")
    public Response getMovie(@PathParam("id") final Long id) {

        LOGGER.debug("Fetch movie for id {}", id);
        try {
            Movie movie = movieDao.getById(id);
            if (movie != null) {
                return Response.ok(movie).build();
            }
            else {
                return Response.ok().build();
            }
        }
        catch (Exception e) {
            LOGGER.error("Error while fetching movie", e);
            return Response.serverError().build();
        }
    }

    @POST
    @Timed
    public Response addMovie(@NotNull @Valid final MovieData movie) {
        LOGGER.debug("Adding movie {}", movie.getName());
        try {
            Long id = movieDao.addMovie(movie.getName(), movie.getRated(), movie.getLanguage(), movie.getActors(),
                    movie.getCrew(), movie.getGenres(), movie.getPlot(), movie.getReleaseDate(), movie.getViewerRating());
            Movie movieFromDb = movieDao.getById(id);
            if (movieFromDb != null) {
                return Response.ok(movieFromDb).build();
            }
            else {
                return Response.ok().build();
            }
        }
        catch (Exception e) {
            LOGGER.error("Error while adding movie", e);
            return Response.serverError().build();
        }
    }

    @PUT
    @Timed
    @Path("{id}")
    public Response updateMovieUserRating(@NotNull @Valid final MovieData input,
                                         @PathParam("id") final Long id) {
        LOGGER.debug("Updating movie with id {}", id);
        try {
            movieDao.updateMovieViewerRating(id, input.getViewerRating());
            Movie movieFromDb = movieDao.getById(id);
            if (movieFromDb != null) {
                return Response.ok(movieFromDb).build();
            }
            else {
                return Response.ok().build();
            }
        }
        catch (Exception e) {
            LOGGER.error("Error while updating movie", e);
            return Response.serverError().build();
        }
    }

    @DELETE
    @Timed
    @Path("{id}")
    public Response deletePart(@PathParam("id") final Long id) {
        LOGGER.debug("deleting movie with id {}", id);
        try {
            movieDao.deleteById(id);
            return Response.ok().build();
        }
        catch (Exception e) {
            LOGGER.error("Error while deleting movie", e);
            return Response.serverError().build();
        }
    }
}
