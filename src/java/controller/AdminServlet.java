/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Admin;

/**
 *
 * @author ADMIN
 */

public class AdminServlet extends HttpServlet {
   
    
    
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
            throws ServletException, IOException{
        
        List errorMsgs=new LinkedList();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
        
        String admin_id = request.getParameter("admin_id");
        String admin_name = request.getParameter("admin_name");
        String admin_pass = request.getParameter("admin_pass");
        String admin_phone = request.getParameter("admin_phone");
        
        if( admin_id == null || admin_id.trim().length() == 0){
                errorMsgs.add("Please enter the id.");
            }
           
        if( admin_name == null || admin_name.trim().length() == 0 ){
                    errorMsgs.add("Please enter name.");
            } 
            if( admin_pass == null || admin_pass.trim().length() == 0){
                errorMsgs.add("Please enter the password.");
            } 
        if( admin_phone == null || admin_phone.trim().length() == 0){
                errorMsgs.add("Please enter phone number.");
            } 
          if(! errorMsgs.isEmpty())
           {
               request.setAttribute("errorMsgs", errorMsgs);
               RequestDispatcher view = request.getRequestDispatcher("/error.jsp");
               view.forward(request, response);
               return;
           }
          
          
          Admin admin = new Admin(admin_id,admin_name,admin_pass,admin_phone);
         
           
           request.setAttribute("admin",admin);
           
           RequestDispatcher view = request.getRequestDispatcher("/AdRegisSuccess.jsp");
           view.forward(request,response);
           
           
    } catch(RuntimeException e){
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
        
        
            //todo auto-generated method stub
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
       
      
            processRequest(request, response);
        
        
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
