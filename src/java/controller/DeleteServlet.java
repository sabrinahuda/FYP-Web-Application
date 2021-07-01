/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Lecture;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Student;
import dao.projectDao;
import dao.studentDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import bean.Project;
import static controller.DeleteServlet.num;
import dao.lectureDao;
/**
 *
 * @author ADMIN
 */
public class DeleteServlet extends HttpServlet {

    private static final long servletVersionUID = 1L;
     private final projectDao proj_dao = new projectDao();
     private final studentDao stud_dao = new studentDao();
    
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        List errorMsgs=new LinkedList();
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
          String stud_id = request.getParameter("stud_id");
          String stud_Name = request.getParameter("stud_Name");
          String stud_Email = request.getParameter("stud_Email");
          String stud_phone = request.getParameter("stud_phone");
          
          String proj_id = request.getParameter("proj_id");
          String proj_title = request.getParameter("proj_title");
          String objective = request.getParameter("objective");
          
          String lect_id = request.getParameter("lect_id");
         
          
           if(!num(stud_id))
          {
              errorMsgs.add("Please enter the right Id");
          }
          if(stud_id == null || stud_id.trim().length() == 0)
          {
              errorMsgs.add("Please enter Student Id");
          }
          if(stud_Name == null || stud_Name.trim().length() == 0)
           {
               errorMsgs.add("Please enter name.");
           }
       
          if(stud_Email == null || stud_Email.trim().length() == 0)
          {
              errorMsgs.add("Please enter Email");
          }
          if(stud_phone == null || stud_phone.trim().length() == 0)
          {
              errorMsgs.add("Please enter phone number. Phone number must be numeric");            
          }
          if(stud_phone == null || stud_phone.trim().length() == 0)
          {
              errorMsgs.add("Please enter Student phone");
          }
          
          
          if(!num(proj_id))
          {
              errorMsgs.add("Please enter the right Id");
          }
          
          if(proj_id == null || proj_id.trim().length() == 0)
          {
              errorMsgs.add("Please enter Project Id");
          }
          if(proj_title== null || proj_title.trim().length() == 0)
           {
               errorMsgs.add("Please enter Project name.");
           }
       
          if(objective == null || objective.trim().length() == 0)
          {
              errorMsgs.add("Please enter Objective");
          }
          
          
          
         
           if(! errorMsgs.isEmpty())
           {
               request.setAttribute("errorMsgs", errorMsgs);
               RequestDispatcher view = request.getRequestDispatcher("/error.jsp");
               view.forward(request, response);
               return;
           }
           
           Student stud = new Student(stud_id,stud_Name,stud_Email,stud_phone);
           
           
          Project project = new Project();
          project.setProj_id(proj_id);
          project.setProj_title(proj_title);
          project.setObjective(objective);
          
         
          
          Project proj = new Project();
          proj.setProj_id(proj_id);
          
          Lecture lect = new Lecture();
          lect.setLect_id(lect_id);
          
          request.setAttribute("proj", project);
          request.setAttribute("stud", stud);
          
          proj_dao.deleteProject(project);
          stud_dao.deleteStudent(stud,proj,lect);
          
          
          
          request.setAttribute("stud", stud);
          request.setAttribute("proj", project);
           
           RequestDispatcher view = request.getRequestDispatcher("/Current.jsp");
           view.forward(request,response);
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
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
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
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
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
