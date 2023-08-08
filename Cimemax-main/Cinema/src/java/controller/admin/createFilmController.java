/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import DAO.FilmDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.sql.Date;
import java.util.List;
import model.Country;
import model.Genres;

/**
 *
 * @author Admin
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class createFilmController extends HttpServlet {

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
            out.println("<title>Servlet createFilmController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet createFilmController at " + request.getContextPath() + "</h1>");
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
        FilmDao db = new FilmDao();
        List<Genres> genres = db.getAllGenres();
        List<Country> country = db.getAllCountry();
        request.setAttribute("genres", genres);
        request.setAttribute("country", country);
        request.getRequestDispatcher("view/admin/createFilm.jsp").forward(request, response);
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
        String title = request.getParameter("title");
        Date premiere = Date.valueOf(request.getParameter("premiere"));
        String actor = request.getParameter("actor");
        String author = request.getParameter("author");
        int duration = Integer.valueOf(request.getParameter("duration"));
        int genres = Integer.valueOf(request.getParameter("genres"));
        String code = request.getParameter("country");
        String descrip = request.getParameter("description");
        Part part = request.getPart("file");
        Part slide = request.getPart("slide");
        String slide1;
        if (!extractFileName(slide).equals("")) {
            String fileName = extractFileName(slide);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            slide.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
            slide1 = fileName;
        } else {
            slide1 = null;
        }
        String fileName = extractFileName(part);
        // refines the fileName in case it is an absolute path
        fileName = new File(fileName).getName();
        part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
        FilmDao db = new FilmDao();
        if (db.registerFilm(genres, title, code, fileName, premiere, actor, author, duration, slide1, descrip) != 1) {
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

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    public File getFolderUpload() {
        File folderUpload = new File("C:\\WorkFromHome\\Cimemax\\Cinema\\web\\view\\images");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }

}
