/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Genres;

/**
 *
 * @author int.thong.nk
 */
public class GenresDao extends DBContext {

    public List<Genres> getAllGenres() {
        List<Genres> genres = new ArrayList<>();
        String sql = "select * from [Genres]";
        try {
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Genres gen = new Genres();
                gen.setGenresId(rs.getInt("GenreID"));
                gen.setName(rs.getString("name"));
                genres.add(gen);
            }
            return genres;
        } catch (SQLException ex) {
            Logger.getLogger(GenresDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void main(String[] args) {
        GenresDao db = new GenresDao();
        List<Genres> gen = db.getAllGenres();
        System.out.println(gen.size());
    }
}
