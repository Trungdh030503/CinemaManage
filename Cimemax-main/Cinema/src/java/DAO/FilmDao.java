/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ViewMode.FilmSlide;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Country;
import model.Film;
import model.Genres;

/**
 *
 * @author Admin
 */
public class FilmDao extends DBContext {

    public int countFilmActive() {
        try {
            String sql = "select count(FilmId) as countFilm from Films where status = 1";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("countFIlm");
                return count;
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public List<Film> getAllFilm() {
        List<Film> films = new ArrayList<>();
        try {
            String sql = "select * from Films f \n"
                    + "left join Genres g on f.GenreID = g.GenreID \n"
                    + "left join Countries c on f.CountryCode = c.CountryCode where status = 1";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Film fl = new Film();
                fl.setFilmId(rs.getInt("FilmID"));
                fl.setTitle(rs.getString("title"));
                fl.setImage(rs.getString("img"));
                fl.setImageSlide(rs.getString("images_slide"));
                fl.setActor(rs.getString("actor"));
                fl.setAuthor(rs.getString("author"));
                fl.setDescription(rs.getString("description"));
                fl.setTime(rs.getInt("time"));
                fl.setPremiere(rs.getDate("premiere"));
                Genres gen = new Genres();
                gen.setGenresId(rs.getInt("GenreId"));
                gen.setName(rs.getString("name"));
                fl.setGenres(gen);
                Country country = new Country();
                country.setCode(rs.getString("CountryCode"));
                country.setCountryName(rs.getString("CountryName"));
                fl.setCountry(country);
                films.add(fl);
            }
            return films;
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Film> getFilmByCondition(String title, String date, String genres, String country,
            String order, int page, int page_Size) {
        List<Film> films = new ArrayList<>();
        try {
            String sql = "select * from Films f  left join Genres g on f.GenreID = g.GenreID \n"
                    + "left join Countries c on f.CountryCode = c.CountryCode \n"
                    + "where Title like ? and premiere like ? \n"
                    + "and f.GenreID like ? and f.CountryCode like ? and [status] = 1 \n"
                    + "order by " + order + " offset (?-1)*? row fetch next ? row only";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, "%" + title + "%");
            stm.setString(2, "%" + date + "%");
            stm.setString(3, "%" + genres + "%");
            stm.setString(4, "%" + country + "%");
            stm.setInt(5, page);
            stm.setInt(6, page_Size);
            stm.setInt(7, page_Size);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Film fl = new Film();
                fl.setFilmId(rs.getInt("FilmID"));
                fl.setTitle(rs.getString("title"));
                fl.setImage(rs.getString("img"));
                fl.setImageSlide(rs.getString("images_slide"));
                fl.setActor(rs.getString("actor"));
                fl.setAuthor(rs.getString("author"));
                fl.setDescription(rs.getString("description"));
                fl.setTime(rs.getInt("time"));
                fl.setPremiere(rs.getDate("premiere"));

                Genres gen = new Genres();
                gen.setGenresId(rs.getInt("GenreId"));
                gen.setName(rs.getString("name"));
                fl.setGenres(gen);

                Country ctry = new Country();
                ctry.setCode(rs.getString("CountryCode"));
                ctry.setCountryName(rs.getString("CountryName"));
                fl.setCountry(ctry);
                films.add(fl);
            }
            return films;
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int totalFilmByCondition(String title, String date, String genres, String country) {
        try {
            String sql = "select count(*) as count from Films f  left join Genres g on f.GenreID = g.GenreID \n"
                    + "left join Countries c on f.CountryCode = c.CountryCode \n"
                    + "where Title like ? and premiere like ? \n"
                    + "and f.GenreID like ? and f.CountryCode like ? and [status] = 1\n";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, "%" + title + "%");
            stm.setString(2, "%" + date + "%");
            stm.setString(3, "%" + genres + "%");
            stm.setString(4, "%" + country + "%");
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count;
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int registerFilm(int genID, String title, String code, String image,
            Date premiere, String actor, String author, int time, String image_slide, String description) {
        try {
            String sql = "INSERT INTO [dbo].[Films]\n"
                    + "           ([GenreID]\n"
                    + "           ,[Title]\n"
                    + "           ,[CountryCode]\n"
                    + "           ,[img]\n"
                    + "           ,[premiere]\n"
                    + "           ,[actor]\n"
                    + "           ,[author]\n"
                    + "           ,[time]\n"
                    + "           ,[images_slide]\n"
                    + "           ,[description]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,1)";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, genID);
            stm.setString(2, title);
            stm.setString(3, code);
            stm.setString(4, image);
            stm.setDate(5, premiere);
            stm.setString(6, actor);
            stm.setString(7, author);
            stm.setInt(8, time);
            stm.setString(9, description);
            stm.setString(10, image_slide);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

    public Film getFilmByID(int filmId) {
        try {
            String sql = "select * from Films f \n"
                    + "left join Genres g on f.GenreID = g.GenreID \n"
                    + "left join Countries c on f.CountryCode = c.CountryCode \n"
                    + "where filmId = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, filmId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Film fl = new Film();
                fl.setFilmId(rs.getInt("FilmID"));
                fl.setTitle(rs.getString("title"));
                fl.setImage(rs.getString("img"));
                fl.setImageSlide(rs.getString("images_slide"));
                fl.setActor(rs.getString("actor"));
                fl.setAuthor(rs.getString("author"));
                fl.setDescription(rs.getString("description"));
                fl.setTime(rs.getInt("time"));
                fl.setPremiere(rs.getDate("premiere"));
                Genres gen = new Genres();
                gen.setGenresId(rs.getInt("GenreId"));
                gen.setName(rs.getString("name"));
                fl.setGenres(gen);
                Country country = new Country();
                country.setCode(rs.getString("CountryCode"));
                country.setCountryName(rs.getString("CountryName"));
                fl.setCountry(country);
                return fl;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Film> getFilmByCategory(int genreId) {
        List<Film> films = new ArrayList<>();
        try {
            String sql = "select * from Films f \n"
                    + "left join Genres g on f.GenreID = g.GenreID \n"
                    + "left join Countries c on f.CountryCode = c.CountryCode"
                    + "where f.GenreID = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, genreId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Film fl = new Film();
                fl.setFilmId(rs.getInt("FilmID"));
                fl.setTitle(rs.getString("title"));
                fl.setImage(rs.getString("img"));
                fl.setImageSlide(rs.getString("images_slide"));
                fl.setActor(rs.getString("actor"));
                fl.setAuthor(rs.getString("author"));
                fl.setDescription(rs.getString("description"));
                fl.setTime(rs.getInt("time"));
                Genres gen = new Genres();
                gen.setGenresId(rs.getInt("GenreId"));
                gen.setName(rs.getString("name"));
                fl.setGenres(gen);
                Country country = new Country();
                country.setCode(rs.getString("CountryCode"));
                country.setCountryName(rs.getString("CountryName"));
                fl.setCountry(country);
                films.add(fl);
            }
            return films;
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Film> getNewFilmTop6() {
        List<Film> films = new ArrayList<>();
        try {
            String sql = "select top 6 * from Films f \n"
                    + "left join Genres g on f.GenreID = g.GenreID \n"
                    + "left join Countries c on f.CountryCode = c.CountryCode";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Film fl = new Film();
                fl.setFilmId(rs.getInt("FilmID"));
                fl.setTitle(rs.getString("title"));
                fl.setImage(rs.getString("img"));
                fl.setImageSlide(rs.getString("images_slide"));
                fl.setActor(rs.getString("actor"));
                fl.setAuthor(rs.getString("author"));
                fl.setDescription(rs.getString("description"));
                fl.setTime(rs.getInt("time"));
                Genres gen = new Genres();
                gen.setGenresId(rs.getInt("GenreId"));
                gen.setName(rs.getString("name"));
                fl.setGenres(gen);
                Country country = new Country();
                country.setCode(rs.getString("CountryCode"));
                country.setCountryName(rs.getString("CountryName"));
                fl.setCountry(country);
                films.add(fl);
            }
            return films;
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<FilmSlide> getFilmSlideTop3() {
        List<FilmSlide> films = new ArrayList<>();
        try {
            String sql = "select top 3 * from Films f \n"
                    + "left join Genres g on f.GenreID = g.GenreID \n"
                    + "left join Countries c on f.CountryCode = c.CountryCode";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                FilmSlide fl = new FilmSlide();
                fl.setFilmId(rs.getInt("FilmID"));
                fl.setTitle(rs.getString("title"));
                fl.setImageSlide(rs.getString("images_slide"));
                films.add(fl);
            }
            return films;
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int deleteFilm(int film) {
        try {
            String sql = "DELETE FROM [dbo].[Films]\n"
                    + "      WHERE filmId = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, film);
            stm.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

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

    public List<Country> getAllCountry() {
        List<Country> country = new ArrayList<>();
        try {
            String sql = "select * from Countries";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Country c = new Country();
                c.setCode(rs.getString("CountryCode"));
                c.setCountryName(rs.getString("CountryName"));
                country.add(c);
            }
            return country;
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int updateFilm(int filmId) {
        try {
            String sql = "UPDATE [dbo].[Films]\n"
                    + "   SET [status] = 0\n"
                    + " WHERE FilmID = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, filmId);
            stm.executeUpdate();
            return (1);
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int updateFilm(int genresId, String title, String code, String img, Date date, String actor,
            String author, int time, String slide, String descrition, int filmId) {
        try {
            String sql = "UPDATE [dbo].[Films]\n"
                    + "   SET [GenreID] = ?\n"
                    + "      ,[Title] = ?\n"
                    + "      ,[CountryCode] = ?\n"
                    + "      ,[img] = ?\n"
                    + "      ,[premiere] = ?\n"
                    + "      ,[actor] = ?\n"
                    + "      ,[author] = ?\n"
                    + "      ,[time] = ?\n"
                    + "      ,[images_slide] = ?\n"
                    + "      ,[description] = ?\n"
                    + " WHERE FilmID = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, genresId);
            stm.setString(2, title);
            stm.setString(3, code);
            stm.setString(4, img);
            stm.setDate(5, date);
            stm.setString(6, actor);
            stm.setString(7, author);
            stm.setInt(8, time);
            stm.setString(9, slide);
            stm.setString(10, descrition);
            stm.setInt(11, filmId);
            stm.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public static void main(String[] args) {
        FilmDao db = new FilmDao();
//        List<Film> film = db.getFilmByCondition("", "", "", "", " filmid asc", 1, 10);
        Film fl = db.getFilmByID(1);
        List<Country> c = db.getAllCountry();
        System.out.println(db.registerFilm(1, "test", "USA", "null", Date.valueOf("2022-01-01"), "ad", "aDA", 100, null, "test"));
    }
}
