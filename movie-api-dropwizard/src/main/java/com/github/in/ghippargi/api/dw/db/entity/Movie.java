package com.github.in.ghippargi.api.dw.db.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Entity class represents data from SQL table movie
 * @author ghippargi
 */
public class Movie {
    @NotNull
    private Long id; //id column in movie table

    @NotBlank
    private String name; //name column in movie table

    private String rated; //rated column in movie table

    private String language; //lang column in movie table

    private String actors; //actors column in movie table

    private String crew; //crew column in movie table

    private String genres; //genres column in movie table

    private String plot; //plot column in movie table

    private String releaseDate; //release_date timestamp column in movie table

    private Double viewerRating; //viewer_rating column in movie table

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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getViewerRating() {
        return viewerRating;
    }

    public void setViewerRating(Double viewerRating) {
        this.viewerRating = viewerRating;
    }
}
