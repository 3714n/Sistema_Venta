/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import logica.ControladoraLogica;


@WebServlet(name = "SvCategoria", urlPatterns = {"/SvCategoria"})
public class SvCategoria extends HttpServlet {
    
    ControladoraLogica controLogica = new ControladoraLogica();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
       
        
        // Acciones posteriores a processRequest
        String descripcion = request.getParameter("nombreCategoria");
        controLogica.crearCategoria(descripcion);
        System.out.println("El nombre de la categoria es: " + descripcion);
       // response.sendRedirect("index.jsp");
   
}

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
