/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import DAO.ShowDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import model.Show;

/**
 *
 * @author Admin
 */
public class manageShowController extends HttpServlet {

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
            out.println("<title>Servlet manageShowController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet manageShowController at " + request.getContextPath() + "</h1>");
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
        String order = request.getParameter("order");
        String dimesion = request.getParameter("dimesion");
        Integer page = Integer.parseInt(request.getParameter("page"));
        ShowDao db = new ShowDao();
        List<Show> shows = db.getShowByCondition(title, date, order + " " + dimesion, page, 10);
        int count = db.countShowByCondition(title, date);
        request.setAttribute("total", Math.ceil((double) count / 10));
        request.setAttribute("show", shows);
        request.setAttribute("title", title);
        request.setAttribute("date", date);
        request.setAttribute("order", order);
        request.setAttribute("dimesion", dimesion);
        request.setAttribute("page", page);
        request.getRequestDispatcher("view/admin/manage_show.jsp").forward(request, response);
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
        int showId = Integer.parseInt(request.getParameter("showId"));
        ShowDao db = new ShowDao();
        int status = db.updatetatusShow(showId);
        if (status != 1) {
            response.sendRedirect("error");
            return;
        }
       response.sendRedirect("manageShowController?title=&date=&order=showId&dimesion=asc&page=1");

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
