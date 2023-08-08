/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ViewMode.FilmSlide;
import jakarta.servlet.jsp.jstl.sql.Result;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Film;
import model.Room;
import model.Show;
import model.Slot;

/**
 *
 * @author Admin
 */
// 1: san sang
// 2: da huy
public class ShowDao extends DBContext {

    public int countShowActive() {
        try {
            String sql = "select count(showId) as countShow from Show where status = 1";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("countShow");
                return count;
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(FilmDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public List<Slot> getAllSlot() {
        List<Slot> slots = new ArrayList<>();
        try {
            String sql = "select * from slot";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Slot s = new Slot();
                s.setId(rs.getInt("slotId"));
                s.setTime(rs.getString("time"));
                slots.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slots;
    }

    public List<Room> getAllRoom() {
        List<Room> rooms = new ArrayList<>();
        try {
            String sql = "select * from rooms";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt("roomId"));
                room.setRoomName(rs.getString("Name"));
                rooms.add(room);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return rooms;
    }

    public List<FilmSlide> getAllFilmShow() {
        List<FilmSlide> film = new ArrayList<>();
        try {
            String sql = "select * from Films where status = 1";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                FilmSlide f = new FilmSlide();
                f.setFilmId(rs.getInt("filmId"));
                f.setTitle(rs.getString("title"));
                film.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return film;
    }

    public int createShow(Date showDate, int slotId, int filmId, int roomId) {
        try {
            String sql = "INSERT INTO [dbo].[Show]\n"
                    + "           ([showDate]\n"
                    + "           ,[slotId]\n"
                    + "           ,[filmId]\n"
                    + "           ,[roomId]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,1)";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setDate(1, showDate);
            stm.setInt(2, slotId);
            stm.setInt(3, filmId);
            stm.setInt(4, roomId);
            stm.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ShowDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int updateShow(Date showDate, int slotId, int filmId, int roomId, int showId) {
        try {
            String sql = "UPDATE [dbo].[Show]\n"
                    + "   SET [showDate] = ?\n"
                    + "      ,[slotId] = ?\n"
                    + "      ,[filmId] = ?\n"
                    + "      ,[roomId] = ?\n"
                    + " WHERE showId = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setDate(1, showDate);
            stm.setInt(2, slotId);
            stm.setInt(3, filmId);
            stm.setInt(4, roomId);
            stm.setInt(5, showId);
            stm.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ShowDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int updatetatusShow(int status) {
        try {
            String sql = "UPDATE [dbo].[Show]\n"
                    + "   SET [status] = 0\n"
                    + " WHERE showId = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, status);
            stm.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ShowDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int deleteShow(int id) {
        try {
            String sql = "DELETE FROM [dbo].[Show]\n"
                    + "      WHERE showId = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ShowDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int countShowByCondition(String title, String date) {
        try {
            String sql = "  select count(s.showId) as countShow from show s left join Films f on s.filmId = f.FilmID \n"
                    + " left join Slot sl  on s.slotId = sl.slotId\n"
                    + "  left join Rooms r on s.roomId = r.RoomID"
                    + "  where f.Title like ? and s.showDate like ? and s.status = 1\n";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, "%" + title + "%");
            stm.setString(2, "%" + date + "%");
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("countShow");
                return count;
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(ShowDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public List<Show> getShowByCondition(String title, String date, String order, int page, int pageSize) {
        List<Show> shows = new ArrayList<>();
        try {
            String sql = "  select s.showId, s.showDate, s.slotId, sl.[Time] as slotTime, s.roomId, r.[Name] as roomName,\n"
                    + "  s.filmId, f.Title, s.status from show s left join Films f on s.filmId = f.FilmID \n"
                    + " left join Slot sl  on s.slotId = sl.slotId\n"
                    + "  left join Rooms r on s.roomId = r.RoomID"
                    + "  where f.Title like ? and s.showDate like ? and s.status = 1\n"
                    + " order by " + order + " offset (?-1)*? row fetch next ? row only";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, "%" + title + "%");
            stm.setString(2, "%" + date + "%");
            stm.setInt(3, page);
            stm.setInt(4, pageSize);
            stm.setInt(5, pageSize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Show s = new Show();
                s.setShowId(rs.getInt("showId"));
                s.setShowDate(rs.getDate("showDate"));
                Slot sl = new Slot();
                sl.setId(rs.getInt("slotId"));
                sl.setTime(rs.getString("slotTime"));
                s.setSlot(sl);
                Room r = new Room();
                r.setRoomId(rs.getInt("roomId"));
                r.setRoomName(rs.getString("roomName"));
                s.setRoom(r);
                Film f = new Film();
                f.setFilmId(rs.getInt("filmId"));
                f.setTitle(rs.getString("title"));
                s.setFilm(f);
                s.setStatus(rs.getInt("status"));
                shows.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return shows;
    }

    public Show findShow(int slot, Date date) {
        try {
            String sql = "  select s.showId, s.showDate, s.slotId, sl.[Time] as slotTime, s.roomId, r.[Name] as roomName,\n"
                    + "  s.filmId, f.Title, s.status from show s left join Films f on s.filmId = f.FilmID \n"
                    + " left join Slot sl  on s.slotId = sl.slotId\n"
                    + "  left join Rooms r on s.roomId = r.RoomID"
                    + "  where s.showDate = ? and  s.slotId = ? \n";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setDate(1, date);
            stm.setInt(2, slot);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Show s = new Show();
                s.setShowId(rs.getInt("showId"));
                s.setShowDate(rs.getDate("showDate"));
                Slot sl = new Slot();
                sl.setId(rs.getInt("slotId"));
                sl.setTime(rs.getString("slotTime"));
                s.setSlot(sl);
                Room r = new Room();
                r.setRoomId(rs.getInt("roomId"));
                r.setRoomName(rs.getString("roomName"));
                s.setRoom(r);
                Film f = new Film();
                f.setFilmId(rs.getInt("filmId"));
                f.setTitle(rs.getString("title"));
                s.setFilm(f);
                s.setStatus(rs.getInt("status"));
                return s;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ShowDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Show findShow(int showId) {
        try {
            String sql = "  select s.showId, s.showDate, s.slotId, sl.[Time] as slotTime, s.roomId, r.[Name] as roomName,\n"
                    + "  s.filmId, f.Title, f.time, s.status from show s left join Films f on s.filmId = f.FilmID \n"
                    + " left join Slot sl  on s.slotId = sl.slotId\n"
                    + "  left join Rooms r on s.roomId = r.RoomID"
                    + "  where s.showId = ? \n";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, showId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Show s = new Show();
                s.setShowId(rs.getInt("showId"));
                s.setShowDate(rs.getDate("showDate"));
                Slot sl = new Slot();
                sl.setId(rs.getInt("slotId"));
                sl.setTime(rs.getString("slotTime"));
                s.setSlot(sl);
                Room r = new Room();
                r.setRoomId(rs.getInt("roomId"));
                r.setRoomName(rs.getString("roomName"));
                s.setRoom(r);
                Film f = new Film();
                f.setFilmId(rs.getInt("filmId"));
                f.setTitle(rs.getString("title"));
                f.setTime(rs.getInt("time"));
                s.setFilm(f);
                s.setStatus(rs.getInt("status"));
                return s;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ShowDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Show> getShow(int filmId, Date date) {
        List<Show> show = new ArrayList<>();
        try {
            String sql = "  select s.showId, s.showDate, s.slotId, sl.[Time] as slotTime, s.roomId, r.[Name] as roomName,\n"
                    + "  s.filmId, f.Title, f.time, f.img, s.status from show s left join Films f on s.filmId = f.FilmID \n"
                    + " left join Slot sl  on s.slotId = sl.slotId\n"
                    + "  left join Rooms r on s.roomId = r.RoomID "
                    + "  where s.filmId = ? and s.showDate = ? order by s.slotId asc \n";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, filmId);
            stm.setDate(2, date);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Show s = new Show();
                s.setShowId(rs.getInt("showId"));
                s.setShowDate(rs.getDate("showDate"));
                Slot sl = new Slot();
                sl.setId(rs.getInt("slotId"));
                sl.setTime(rs.getString("slotTime"));
                s.setSlot(sl);
                Room r = new Room();
                r.setRoomId(rs.getInt("roomId"));
                r.setRoomName(rs.getString("roomName"));
                s.setRoom(r);
                Film f = new Film();
                f.setFilmId(rs.getInt("filmId"));
                f.setTitle(rs.getString("title"));
                f.setTime(rs.getInt("time"));
                f.setImage(rs.getString("img"));
                s.setFilm(f);
                s.setStatus(rs.getInt("status"));
                show.add(s);
            }
            return show;
        } catch (SQLException ex) {
            Logger.getLogger(ShowDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void main(String[] args) {
        ShowDao db = new ShowDao();
//        List<Slot> slot = db.getAllSlot();
//        List<Room> room = db.getAllRoom();
//        List<FilmSlide> film = db.getAllFilmShow();
        List<Show> show = db.getShow(1, Date.valueOf("2022-11-03"));
//        Show s = db.findShow(1);
        System.out.println(show.size());
    }
}
