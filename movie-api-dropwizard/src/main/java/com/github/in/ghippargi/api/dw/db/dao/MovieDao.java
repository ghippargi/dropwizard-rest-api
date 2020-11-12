package com.github.in.ghippargi.api.dw.db.dao;

import com.github.in.ghippargi.api.dw.db.entity.Movie;
import com.github.in.ghippargi.api.dw.db.mapper.MovieMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.time.LocalDate;
import java.util.List;

/**
 * Using declarative mechanism provided by JDBI SQLObjectAPI for interacting with relational database.
 *
 * @author ghippargi
 */
public interface MovieDao {

    /**
     * Fetch the movie by the input id
     * @param id : unique identifier for each movie
     * @return Movie corresponding to provided id.
     */
    @SqlQuery("select id, name, rated, lang, actors, crew, genres, plot, release_date, viewer_rating from movie where id = :id")
    @RegisterRowMapper(MovieMapper.class)
    Movie getById(@Bind("id") Long id);

    /**
     * Fetch all Movies
     * @return List of movies
     */
    @SqlQuery("select id, name, rated, lang, actors, crew, genres, plot, release_date, viewer_rating from movie")
    @RegisterRowMapper(MovieMapper.class)
    List<Movie> getAll();

    /**
     * Insert a record in movie table
     * @param name : String
     * @param rated : String
     * @param lang : String
     * @param actors : String
     * @param crew : String
     * @param genres : String
     * @param plot : String
     * @param releaseDate : String. Date in dd-MM-yyyy format
     * @param viewerRating : Double
     * @return Long : id of the record created
     */
    @SqlUpdate("insert into movie (name, rated, lang, actors, crew, genres, plot, release_date, viewer_rating) values (:name, :rated, :lang, :actors, :crew, :genres, :plot, :releaseDate, :viewerRating)")
    @GetGeneratedKeys
    Long addMovie(@Bind("name") String name, @Bind("rated") String rated,
                  @Bind("lang") String lang, @Bind("actors") String actors, @Bind("crew") String crew,
                  @Bind("genres") String genres, @Bind("plot") String plot,
                  @Bind("releaseDate") LocalDate releaseDate, @Bind("viewerRating") Double viewerRating);

    /**
     * Update viewer_rating of a movie identified by input id
     * @param id : Long : unique id of the movie to be updated
     * @param viewerRating : The new viewer_rating to be set for the movie
     */
    @SqlUpdate("update movie set viewer_rating = :viewerRating where id = :id")
    void updateMovieViewerRating(@Bind("id") Long id, @Bind("viewerRating") Double viewerRating);

    /**
     * Delete a movie identified by input id
     * @param id : Long : unique id of the movie to be deleted
     */
    @SqlUpdate("delete from movie where id = :id")
    void deleteById(@Bind("id") long id);

}
