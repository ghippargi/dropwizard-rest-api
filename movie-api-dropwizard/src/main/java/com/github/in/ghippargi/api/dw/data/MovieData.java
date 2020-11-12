package com.github.in.ghippargi.api.dw.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This data class will be used as input in REST request
 *
 * @author ghippargi
 */
public class MovieData {
    private Long id;

    @NotBlank
    private String name;

    private String rated;

    private String language;

    private String actors;

    private String crew;

    private String genres;

    private String plot;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate releaseDate;

    private Double viewerRating;

    //----- getter & setter -----//
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String cast) {
        this.actors = cast;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String storyline) {
        this.plot = storyline;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getViewerRating() {
        return viewerRating;
    }

    public void setViewerRating(Double viewerRating) {
        this.viewerRating = viewerRating;
    }

    public String getReleaseDateString() {
        if (getReleaseDate() != null) {
            return getReleaseDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
        else {
            return null;
        }
    }
}
