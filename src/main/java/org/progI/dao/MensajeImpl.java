package org.progI.dao;

import org.progI.entities.Mensaje;
import org.progI.entities.Plataforma;
import org.progI.interfaces.AdmConexion;
import org.progI.interfaces.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MensajeImpl implements AdmConexion, DAO<Mensaje, Integer> {

  private Connection conn = null;

  // Consultas SQL
  private static final String SQL_INSERT =
      "INSERT INTO mensajes (mensaje, fecha, hora, destinatario, plataforma) VALUES (?, ?, ?, ?, ?)";

  private static final String SQL_UPDATE =
      "UPDATE mensajes SET mensaje = ?, fecha = ?, hora = ?, destinatario = ?, plataforma = ? WHERE idMensaje = ?";

  private static final String SQL_DELETE =
      "DELETE FROM mensajes WHERE idMensaje = ?";

  private static final String SQL_GETALL =
      "SELECT * FROM mensajes ORDER BY idMensaje";

  private static final String SQL_GETBYID =
      "SELECT * FROM mensajes WHERE idMensaje = ?";

  @Override
  public List<Mensaje> getAll() {
    conn = obtenerConexion();
    PreparedStatement pst = null;
    ResultSet rs = null;
    List<Mensaje> listaMensajes = new ArrayList<>();

    try {
      pst = conn.prepareStatement(SQL_GETALL);
      rs = pst.executeQuery();
      while (rs.next()) {
        Mensaje msg = new Mensaje();
        msg.setIdMensaje(rs.getInt("idMensaje"));
        msg.setMensaje(rs.getString("mensaje"));
        msg.setFecha(rs.getInt("fecha"));
        msg.setHora(rs.getInt("hora"));
        msg.setDestinatario(rs.getString("destinatario"));

        // Convertimos el String de la BD de nuevo al Enum
        String platBD = rs.getString("plataforma");
        if (platBD != null) {
          msg.setPlataforma(Plataforma.valueOf(platBD));
        }

        listaMensajes.add(msg);
      }
      rs.close();
      pst.close();
      conn.close();
    } catch (SQLException e) {
      System.out.println("Error al obtener los mensajes");
      throw new RuntimeException(e);
    }
    return listaMensajes;
  }

  @Override
  public void insert(Mensaje objeto) {
    conn = obtenerConexion();
    PreparedStatement pst = null;
    try {
      pst = conn.prepareStatement(SQL_INSERT);
      pst.setInt(1, objeto.getMensaje());
      pst.setInt(2, objeto.getFecha());
      pst.setInt(3, objeto.getHora());
      pst.setString(4, objeto.getDestinatario());
      // Guardamos el nombre del enum como String
      pst.setString(5, objeto.getPlataforma().name());

      int resultado = pst.executeUpdate();
      if (resultado == 1) {
        System.out.println("Mensaje enviado correctamente");
      }
      pst.close();
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void update(Mensaje objeto) {
    if (this.existsById(objeto.getIdMensaje())) {
      conn = obtenerConexion();
      PreparedStatement pst = null;
      try {
        pst = conn.prepareStatement(SQL_UPDATE);
        pst.setInt(1, objeto.getMensaje());
        pst.setInt(2, objeto.getFecha());
        pst.setInt(3, objeto.getHora());
        pst.setString(4, objeto.getDestinatario());
        pst.setString(5, objeto.getPlataforma().name());
        pst.setInt(6, objeto.getIdMensaje());

        pst.executeUpdate();
        pst.close();
        conn.close();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
  }

  @Override
  public void delete(Integer id) {
    conn = obtenerConexion();
    PreparedStatement pst = null;
    try {
      pst = conn.prepareStatement(SQL_DELETE);
      pst.setInt(1, id);
      pst.executeUpdate();
      pst.close();
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Mensaje getById(Integer id) {
    conn = obtenerConexion();
    PreparedStatement pst = null;
    ResultSet rs = null;
    Mensaje msg = null;

    try {
      pst = conn.prepareStatement(SQL_GETBYID);
      pst.setInt(1, id);
      rs = pst.executeQuery();

      if (rs.next()) {
        msg = new Mensaje();
        msg.setIdMensaje(rs.getInt("idMensaje"));
        msg.setMensaje(rs.getString("mensaje"));
        msg.setFecha(rs.getInt("fecha"));
        msg.setHora(rs.getInt("hora"));
        msg.setDestinatario(rs.getString("destinatario"));
        msg.setPlataforma(Plataforma.valueOf(rs.getString("plataforma")));
      }
      rs.close();
      pst.close();
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return msg;
  }

  @Override
  public boolean existsById(Integer id) {
    conn = obtenerConexion();
    PreparedStatement pst = null;
    ResultSet rs = null;
    boolean existe = false;
    try {
      pst = conn.prepareStatement(SQL_GETBYID);
      pst.setInt(1, id);
      rs = pst.executeQuery();
      existe = rs.next();
      rs.close();
      pst.close();
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return existe;
  }
}