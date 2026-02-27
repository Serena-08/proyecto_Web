package org.progI.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.progI.dao.MensajeImpl;
import org.progI.entities.Mensaje;
import org.progI.interfaces.DAO;

import java.io.IOException;

public class MensajesServlet extends HttpServlet {

  private DAO<Mensaje, Integer> mensajeDAO = new MensajeImpl();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    //Configuramos para que acepte tilde y ñ
    req.setCharacterEncoding("UTF-8");
    req.setAttribute("mensaje", "Hola desde el servlet de mensajes");

    System.out.println("Inicio del Servlet seMensajes");

    //Obtenemos las operaciones
    String operacion = req.getParameter("operacion");

    String mensaje = req.getParameter("mensaje");
    String fecha = req.getParameter("fecha");
    String hora = req.getParameter("hora");
    String destinatario = req.getParameter("plataforma");

    //Editar o eliminar
    int idMensaje = -1;
    String idStr = req.getParameter("idMensaje");
  }

}
