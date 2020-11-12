package com.github.in.ghippargi.api.dw.db.mapper;

import com.github.in.ghippargi.api.dw.db.entity.Movie;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

/**
 * RowMapper used to map data from movie sql table to objects of Movie class
 * @author ghippargi
 */
public class MovieMapper implements RowMapper<Movie> {

    @Override
    public Movie map(ResultSet rs, StatementContext ctx) throws SQLException {

        Movie toRet = new Movie();
        toRet.setId(rs.getLong("id"));
        toRet.setName(rs.getString("name"));
        toRet.setRated(rs.getString("rated"));
        toRet.setLanguage(rs.getString("lang"));
        toRet.setActors(rs.getString("actors"));
        toRet.setCrew(rs.getString("crew"));
        toRet.setGenres(rs.getString("genres"));
        toRet.setPlot(rs.getString("plot"));
        Timestamp timestamp = rs.getTimestamp("release_date");
        if (timestamp != null) {
            toRet.setReleaseDate(timestamp.toLocalDateTime().toLocalDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }
        toRet.setViewerRating(rs.getDouble("viewer_rating"));
        return toRet;
    }

}
