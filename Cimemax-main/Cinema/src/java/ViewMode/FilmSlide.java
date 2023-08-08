/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewMode;

/**
 *
 * @author Admin
 */
public class FilmSlide {

    private int filmId;
    private String title;
    private String imageSlide;

    public FilmSlide() {
    }

    public FilmSlide(int filmId, String title, String imageSlide) {
        this.filmId = filmId;
        this.title = title;
        this.imageSlide = imageSlide;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageSlide() {
        return imageSlide;
    }

    public void setImageSlide(String imageSlide) {
        this.imageSlide = imageSlide;
    }

    @Override
    public String toString() {
        return "FilmSlide{" + "filmId=" + filmId + ", title=" + title + ", imageSlide=" + imageSlide + '}';
    }

}
