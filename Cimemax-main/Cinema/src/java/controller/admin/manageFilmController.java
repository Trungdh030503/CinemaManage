/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import DAO.FilmDao;
import DAO.ShowDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Country;
import model.Film;
import model.Genres;

/**
 *
 * @author Admin
 */
public class manageFilmController extends HttpServlet {

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
            out.println("<title>Servlet manageFilmController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet manageFilmController at " + request.getContextPath() + "</h1>");
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
        String title = request.getParameter("title");
        String date = request.getParameter("date");
        String genres = request.getParameter("genres");
        String country = request.getParameter("country");
        String order = request.getParameter("order");
        String dimesion = request.getParameter("dimesion");
        int page = Integer.parseInt(request.getParameter("page"));
        FilmDao db = new FilmDao();
        List<Film> film = db.getFilmByCondition(title, date, genres, country, order + " " + dimesion, page, 10);
        List<Genres> gen = db.getAllGenres();
        List<Country> coun = db.getAllCountry();
        int total = db.totalFilmByCondition(title, date, genres, country);
        request.setAttribute("gen", gen);
        request.setAttribute("coun", coun);
        request.setAttribute("title", title);
        request.setAttribute("date", date);
        request.setAttribute("genres", genres);
        request.setAttribute("country", country);
        request.setAttribute("page", page);
        request.setAttribute("order", order);
        request.setAttribute("dimesion", dimesion);
        request.setAttribute("film", film);
        request.setAttribute("total", Math.ceil((double) total / 10));
        request.getRequestDispatcher("view/admin/manage_film.jsp").forward(request, response);
        return;
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
        int filmId = Integer.parseInt(request.getParameter("filmId"));
        FilmDao db = new FilmDao();
        int status = db.updateFilm(filmId);
        if (status != 1) {
            response.sendRedirect("error");
            return;
        }
        response.sendRedirect("manageFilmController?title=&date=&genres=&country=&order=filmId&dimesion=asc&page=1");
        return;
        
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
