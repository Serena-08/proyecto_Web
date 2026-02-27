package org.progI.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.progI.dao.UsuarioImpl;
import org.progI.entities.Usuario;
import org.progI.interfaces.DAO;

import java.io.IOException;

/*
¿Qué son los Servlets?
Servlets son programas escritos en Java que se ejecutan en un servidor web.
Permiten generar contenido web dinámico, como páginas HTML personalizadas.

¿Para qué sirven?
Procesan solicitudes HTTP (como formularios web).
Generan respuestas dinámicas (HTML, JSON, etc.).
Son la base de muchas aplicaciones web Java, como Java EE / Jakarta EE.
 */


// Definimos la URL que invocará el formulario
public class UsuarioServlet extends HttpServlet {

  private DAO<Usuario, Integer> usuarioDAO = new UsuarioImpl();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Configuramos la codificación para que acepte tildes y ñ
    req.setCharacterEncoding("UTF-8");
    req.setAttribute("mensaje", "Hola desde el servlet del Proyecto");

    System.out.println("Inicio servlet seUsuario");

    // 1. OBTENER LA OPERACIÓN (¿Qué quiere hacer el usuario?)
    // Puede ser: "nuevo", "editar", "eliminar"
    String operacion = req.getParameter("operacion");

    // Variables para los datos
    String nombre = req.getParameter("nombre");
    String apellido = req.getParameter("apellido");
    String email = req.getParameter("email");
    String telefono = req.getParameter("telefono");
    String contrasenia = req.getParameter("contrasenia"); //Borrar

    // ID para editar o eliminar (viene como String, hay que pasarlo a int)
    int idUsuario = -1;
    String idStr = req.getParameter("idUsuario");
    if (idStr != null && !idStr.isEmpty()) {
      try {
        idUsuario = Integer.parseInt(idStr);
      } catch (NumberFormatException e) {
        idUsuario = -1;
      }
    }

    try {
      // --- CASO 1: INSERTAR NUEVO ---
      if ("nuevo".equals(operacion)) {
        // Creamos el usuario (sin ID, constructor para registrar)
        Usuario nuevoUser = new Usuario(nombre, apellido, email, telefono, contrasenia);

        // NOTA: Aquí podrías agregar la lógica de hash de contraseña más adelante
        // NOTA 2: Si quieres validar si el email existe, necesitas crear ese método en el DAO primero.

        usuarioDAO.insert(nuevoUser);
        System.out.println("Usuario registrado: " + email);

        // Redirigir a éxito o login
        req.setAttribute("mensajeExito", "Usuario registrado correctamente.");
        // Asumiendo que tienes un index.jsp o login.jsp
        RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
      }

      // --- CASO 2: EDITAR EXISTENTE ---
      else if ("editar".equals(operacion)) {
        // Buscamos el original para no perder datos si alguno viene vacío
        Usuario usuarioEditar = usuarioDAO.getById(idUsuario);

        if (usuarioEditar != null) {
          usuarioEditar.setNombre(nombre);
          usuarioEditar.setApellido(apellido);
          usuarioEditar.setEmail(email);
          usuarioEditar.setTelefono(telefono);

          // Solo actualizamos la contraseña si el usuario escribió una nueva
          if (contrasenia != null && !contrasenia.trim().isEmpty()) {
            usuarioEditar.setContrasenia(contrasenia);
          }

          usuarioDAO.update(usuarioEditar);
          System.out.println("Usuario actualizado ID: " + idUsuario);
        }

        resp.sendRedirect("gestionUsuarios.jsp"); // Redirige a la lista para ver cambios
      }

      // --- CASO 3: ELIMINAR ---
      else if ("eliminar".equals(operacion)) {
        usuarioDAO.delete(idUsuario);
        System.out.println("Usuario eliminado ID: " + idUsuario);
        resp.sendRedirect("gestionUsuarios.jsp");
      }

    } catch (Exception e) {
      e.printStackTrace();
      req.setAttribute("error", "Ocurrió un error: " + e.getMessage());
      RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
      rd.forward(req, resp);
    }
  }
}