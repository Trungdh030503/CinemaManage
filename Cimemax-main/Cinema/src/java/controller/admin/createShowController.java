/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import DAO.ShowDao;
import ViewMode.FilmSlide;
import ViewMode.Status;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import model.Film;
import model.Room;
import model.Show;
import model.Slot;

/**
 *
 * @author Admin
 */


public class createShowController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet createShowController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet createShowController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ShowDao db = new ShowDao();
        List<FilmSlide> films = db.getAllFilmShow();
        List<Slot> slots = db.getAllSlot();
        List<Room> rooms = db.getAllRoom();
        request.setAttribute("films", films);
        request.setAttribute("slots", slots);
        request.setAttribute("rooms", rooms);
        request.getRequestDispatcher("view/admin/createShow.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int film = Integer.parseInt(request.getParameter("film"));
        int slot = Integer.parseInt(request.getParameter("slot"));
        int room = Integer.parseInt(request.getParameter("room"));
        Date date = Date.valueOf(request.getParameter("date"));
        ShowDao db = new ShowDao();
        Show s = db.findShow(slot, date);
        if (s != null) {
            request.setAttribute("mess", new Status(400, "Shows are available at this time, please change the time or room."));
            doGet(request, response);
            return;
        } else {
            int addShow = db.createShow(date, slot, film, room);
            if (addShow == 1) {
                response.sendRedirect("manageShowController?title=&date=&order=showId&dimesion=asc&page=1");
            } else {
                response.getWriter().print("error");
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
