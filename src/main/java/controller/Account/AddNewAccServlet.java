/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Account;

import DAOs.AccountDAO;
import DAOs.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Admin
 */
public class AddNewAccServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddNewAccServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddNewAccServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String fullName = request.getParameter("fullname");
        String BD = request.getParameter("birthday");
        String img="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5OjcBCgoKDQwNGg8PGjclHyU3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3N//AABEIAIIAmgMBIgACEQEDEQH/xAAbAAEAAgMBAQAAAAAAAAAAAAAABAUBAwYCB//EADMQAQACAQIDBQYDCQAAAAAAAAABAgMEEQUhMRMyQVFxEiJSYYHBQpKxFCM0U2KCkaHR/8QAFAEBAAAAAAAAAAAAAAAAAAAAAP/EABQRAQAAAAAAAAAAAAAAAAAAAAD/2gAMAwEAAhEDEQA/APpgAAAAAAAAAAAAAAAAAAAAAAAAABJ1naOs9FlpeG7xFtR+SPuCtjeZ2iN5bOxyzHLFf8sr7HipjjbHSKx8oewc3atqd+s19eTHXo6SYiY2mImPKULUcOx5ImcXuX/1IKgesuO+G80yRtLyAAAAAAAAAAADbpcfbZ6UnpM8/QFhw3SxWsZske9bux5QsGI6MgAAAAj6zTV1GLbpaO7KimJraa2jaYnaYdKqOLYopmrkjpeOfrAIIAAAAAAAAACdwiN9RafKqCmcIttqrR8VZBcgAAAAAIPFo309Z8rf9TkDjFttPWvjNvsCpCAAAAAAAAABswZOxzUyR4S1gOkrMWrExO8T0llVcN1cU2wZJ5fhmf0WoAAAACm4nm7TUezE71py+vina7Vxhp7NOeSeny+al8dwAAAAAAAAAAAAEzTcQyYY9nLE3r4ecIZIL3FrNPkjlkiJ8rcm726z0tH+XO0pe/cpa3pDZ+y5/wCTf8oLrJqcGOPey1j6oOo4nv7unjb+qY+yDbDkp3sd4/tlrB6tM2mZtMzM9ZnxYAAAAAAAAAAAAE3h+j7ae1yx+78I+IGrS6PJqOce7T4pjr6LTDocGLb3fat525pERERtEcmQI5QAA05tNhzd/HEz5xyluAVGp4dfFE2wz7VfLxQXSoGv0UZInJija8dY+IFSEfMAAAAAAAABt02Ht81aeHW3ov61itYrWNoiNohA4Rj2xWy/FO0fRYAAAAAAAAAp+KaeMeSMtI2rfr6oS+1uPtdPevjtvHrCh5AAAAAAAEgC84d/BY/r+qSAAAAAAAAAMS5v8UgAAAAD/9k=";
        
        String gender = request.getParameter("gender");
        Account acc = new Account(img, username, password, fullName, gender, BD);
        AccountDAO accdao = new AccountDAO();
        accdao.addToAcc(acc);
        HttpSession session = request.getSession();
        session.setAttribute("acc", acc);
        session.setMaxInactiveInterval(1000);
        response.sendRedirect("home");
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
