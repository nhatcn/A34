/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.product;

import DAOs.CategoryDAO;
import DAOs.ProductDAO;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.MultipartConfig;
import model.Category;
import model.Product;

/**
 *
 * @author acer
 */
@MultipartConfig
public class AddNewProductServlet extends HttpServlet {

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
            out.println("<title>Servlet NewProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewProductServlet at " + request.getContextPath() + "</h1>");
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
        CategoryDAO dao = new CategoryDAO();
        List<Category> listC = dao.getAllCategory();
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("addnewproduct.jsp").forward(request, response);

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

        String title = request.getParameter("ptitle");
        double price = Double.parseDouble(request.getParameter("price"));
        String descr = request.getParameter("pDescrip");
        int cid = Integer.parseInt(request.getParameter("cID"));
        // Lấy file upload 
        Part filePart = (Part) request.getPart("pImg"); // Tên input file trong form
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        // Xử lý lưu file vào thư mục
        // Lấy đường dẫn thư mục gốc của ứng dụng web
        String uploadPath = getServletContext().getRealPath("/img");

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // Sử dụng mkdirs() để tạo các thư mục con nếu cần
        }

        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);

        // Lấy đường dẫn file
        // Sử dụng đường dẫn tương đối đến thư mục lưu ảnh
        String imgRelativePath = request.getContextPath() + "/img/" + fileName;

        // Khởi tạo đối tượng Product
        ProductDAO pdao = new ProductDAO();
        pdao.addnewProduct(new Product(0, imgRelativePath, price, title, descr, cid));

        response.sendRedirect("listManage");

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
