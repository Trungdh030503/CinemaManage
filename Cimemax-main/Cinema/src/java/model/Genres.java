/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author int.thong.nk
 */
public class Genres {

    private int genresId;
    private String name;

    public Genres() {
    }

    public Genres(int genresId, String name) {
        this.genresId = genresId;
        this.name = name;
    }

    public int getGenresId() {
        return genresId;
    }

    public void setGenresId(int genresId) {
        this.genresId = genresId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
