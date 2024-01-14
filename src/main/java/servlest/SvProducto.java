/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlest;

import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import logica.ControladoraLogica;
import logica.ControladoraLogica;


@WebServlet(name = "SvProducto", urlPatterns = {"/SvProducto"})
public class SvProducto extends HttpServlet {

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
        
        
        String nombreProducto = request.getParameter("nombreProducto");
        String cantidadProducto = request.getParameter("cantidadProducto");
        int convertirCatidad = Integer.parseInt( cantidadProducto);
        String precioProducto = request.getParameter("precioProducto");
         double convertirPrecio = Double.parseDouble(precioProducto);
        String descripcionProducto = request.getParameter("descripcionProducto");
        String cargarImagenProducto = request.getParameter("cargarImagenProducto");
        String costoProducto = request.getParameter("costoProducto");
        double convertidocostoProducto = Double.parseDouble(costoProducto);
        String categoria = request.getParameter("cotegoriaProducto");
        
        //controLogica.crearProducto(nombreProducto, convertirCatidad, convertirPrecio, descripcionProducto,cargarImagenProducto, convertidocostoProducto, categoria);
        
         }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
