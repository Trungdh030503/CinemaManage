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
    private String genresName;

    public Genres() {
    }

    public Genres(int genresId, String genresName) {
        this.genresId = genresId;
        this.genresName = genresName;
    }

    public int getGenresId() {
        return genresId;
    }

    public void setGenresId(int genresId) {
        this.genresId = genresId;
    }

    public String getGenresName() {
        return genresName;
    }

    public void setGenresName(String genresName) {
        this.genresName = genresName;
    }
    
    

    @Override
    public String toString() {
        return "Genres{" + "genresId=" + genresId + ", genresName=" + genresName + '}';
    }
    
}
