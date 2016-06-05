/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classes.Conexao;
import conexao.UsuarioCrud;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author rafael
 */
@WebServlet(name = "CadastraUsrBanco", urlPatterns = {"/CadastraUsrBanco"})
public class CadastraUsrBanco extends HttpServlet {

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
        processRequest(request, response);
        
        System.out.println("Entrou no login");
        
        String email = (String)request.getParameter("email");
        String senha = (String)request.getParameter ("senha");
    
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            usuarios = UsuarioCrud.buscaUsr();
            
            System.out.println("E-mail(Login): "+email);
            System.out.println("Senha: "+ senha);
            
            for(Usuario usr : usuarios){
                
                System.out.println("E-mail(Banco): "+usr.getEmail());
                System.out.println("Senha: "+usr.getSenha());
                
                if(( email.equals(usr.getEmail()) && senha.equals(usr.getSenha()))){
                    System.out.println("Entrou");
                    try{
                        RequestDispatcher rd = request.getRequestDispatcher("./home.jsp");
                        request.setAttribute("usr", usr);
                        rd.forward(request, response);
                        return;
                    }
                    catch(Exception e){
                        System.out.println("Erro: "+e.getMessage());
                    }
                    
                    
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher("./index.html");
            rd.forward(request, response);
            return;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastraUsrBanco.class.getName()).log(Level.SEVERE, null, ex);
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
