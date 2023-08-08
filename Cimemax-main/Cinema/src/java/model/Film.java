/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author int.thong.nk
 */
public class Film {

    private int filmId;
    private Genres genres;
    private String title;
    private Date premiere;
    private String image;

    private String actor;
    private Country country;
    private String author;
    private int time;
    private String imageSlide;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Film() {
    }

    public String getImageSlide() {
        return imageSlide;
    }

    public void setImageSlide(String imageSlide) {
        this.imageSlide = imageSlide;
    }

    public Film(int filmId, Genres genres, String title, Date premiere,
            String image, String actor, Country country, String author,
            int time, String imageSlide) {
        this.filmId = filmId;
        this.genres = genres;
        this.title = title;
        this.premiere = premiere;
        this.image = image;
        this.actor = actor;
        this.country = country;
        this.author = author;
        this.time = time;
        this.imageSlide = imageSlide;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Film{" + "filmId=" + filmId + ", genres=" + genres
                + ", title=" + title + ", premiere=" + premiere + ", image="
                + image + ", actor=" + actor + ", country=" + country
                + ", author=" + author + ", time=" + time + '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPremiere() {
        return premiere;
    }

    public void setPremiere(Date premiere) {
        this.premiere = premiere;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
