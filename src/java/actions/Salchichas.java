/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import JDBC.DBConnection;
import com.dto.Salchicha;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import salchicha.jdbc.DaoSalchichaJDBC;

/**
 *
 * @author root
 */
@WebServlet(name = "Salchichas", urlPatterns = {"/Salchichas"})
public class Salchichas extends HttpServlet {


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
            response.setContentType("application/json");
            JSONArray jSONArray;
            JSONObject jsono = new JSONObject();
            DaoSalchichaJDBC salchichaJDBC = new DaoSalchichaJDBC();
            List salchichas = salchichaJDBC.select();
            jSONArray = new JSONArray(salchichas);
            jsono.put("Salchichas", jSONArray);
            System.out.println(jsono);
            PrintWriter pw = response.getWriter();
            pw.print(jsono.toString());
            pw.flush();
            
        } catch (SQLException ex) {
            Logger.getLogger(Salchichas.class.getName()).log(Level.SEVERE, null, ex);
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
