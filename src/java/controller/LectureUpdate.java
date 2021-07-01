/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import bean.Lecture;
import static controller.AddStudent.num;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.lectureDao;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author ADMIN
 */
public class LectureUpdate extends HttpServlet {
private final lectureDao lect_dao = new lectureDao();
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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        List errorMsgs=new LinkedList();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
          String lect_id = request.getParameter("lect_id");
         String lect_name = request.getParameter("lect_name");
          String lect_email = request.getParameter("lect_email");
          String room_no = request.getParameter("room_no");
          String lect_status = request.getParameter("lect_status");
          
          
          if(!num(lect_id))
          {
              errorMsgs.add("Please enter the right Id");
          }
          if(lect_id == null || lect_id.trim().length() == 0)
          {
              errorMsgs.add("Please enter  Id");
          }
          if(lect_name == null || lect_name.trim().length() == 0)
           {
               errorMsgs.add("Please enter name.");
           }
       
          if(lect_email == null || lect_email.trim().length() == 0)
          {
              errorMsgs.add("Please enter Email");
          }
          if(room_no == null || room_no.trim().length() == 0)
          {
              errorMsgs.add("Please enter room_no");
          }
        
     
          if(lect_status == null || lect_status.trim().length() == 0)
          {
              errorMsgs.add("Please enter status");
          }

     
          
           if(! errorMsgs.isEmpty())
           {
               request.setAttribute("errorMsgs", errorMsgs);
               RequestDispatcher view = request.getRequestDispatcher("/error.jsp");
               view.forward(request, response);
               return;
           }
           
          Lecture lecture = new Lecture();
          lecture.setLect_id(lect_id);
          lecture.setLect_name(lect_name);
          lecture.setLect_email(lect_email);
          lecture.setRoom_no(room_no);
          lecture.setStatus(lect_status);
          
          lect_dao.updateLecture(lecture);
          
           RequestDispatcher view = request.getRequestDispatcher("/LectList.jsp");
           view.forward(request,response);
           
           request.setAttribute("lect",lecture);
        }
         catch(RuntimeException e){
            errorMsgs.add("An unexpected error: " + e.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/error.jsp");
                view.forward(request, response);
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
    try {
        processRequest(request, response);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(LectureDelete.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(LectureDelete.class.getName()).log(Level.SEVERE, null, ex);
    }
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
    try {
        processRequest(request, response);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(LectureDelete.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(LectureDelete.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static boolean num(String number) {
        if (number == null) {
            return false;
        }
        try {
            double n = Double.parseDouble(number);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
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
