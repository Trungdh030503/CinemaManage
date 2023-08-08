/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Country;
import model.Genres;

/**
 *
 * @author int.thong.nk
 */
public class FilmDao extends DBcontext {

    public List<Genres> getAllGenres() {
        List<Genres> genres = new ArrayList<>();
        try {
            String sql = "SELECT * FROM genres";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Genres g = new Genres();
                g.setGenresId(rs.getInt("genresId"));
                g.setGenresName(rs.getString("genresName"));
                genres.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return genres;
    }

    public List<Country> getAllCountry() {
        List<Country> countrys = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Country";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Country c = new Country();
                c.setCode(rs.getString("code"));
                c.setCountryName(rs.getString("countryName"));
                countrys.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return countrys;
    }

    public int addNewFile(String title, Date premiere, String image, String actor, String author, int time, String slide, String description, int genresId, String countryId) {
        try {
            String sql = "INSERT INTO `cinema_test`.`films`\n"
                    + "(`title`, `premiere`, `image`, `actor`, `author`,`time`, `imageSilde`,`description`,`genresId`, `countryId`)\n"
                    + "VALUES\n"
                    + "(?,\n" //1 : title
                    + "?,\n" //2:premiere
                    + "?,\n" //3: image
                    + "?,\n" //4: actor
                    + "?,\n" //5: author
                    + "?,\n" //6: time
                    + "?,\n" //7: imageSlide
                    + "?,\n" //8: description
                    + "?,\n" //9: genresId
                    + "?)";    //10: countryId
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, title);
            stm.setDate(2, premiere);
            stm.setString(3, image);
            stm.setString(4, actor);
            stm.setString(5, author);
            stm.setInt(6, time);
            stm.setString(7, slide);
            stm.setString(8, description);
            stm.setInt(9, genresId);
            stm.setString(10, countryId);
            stm.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    public static void main(String[] args) {
        FilmDao db = new FilmDao();
        List<Genres> gen = db.getAllGenres();
        System.out.println(gen.size());

        List<Country> coun = db.getAllCountry();
        System.out.println(coun.size());
        
        System.out.println(db.addNewFile("prokc", Date.valueOf("2022-02-02"), "123", "actor", "author", 123, "slide", "osd do voqof qhndoq qddsc qcaq ", 3, "c"));
    }

}
