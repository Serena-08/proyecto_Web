package org.progI.dao;

//Implements= Palabra clave usada por una clase para que pueda implementar una o más interfaces.
//Interfaces= Contrato que define un conjunto de métodos abstractos (sin cuerpos) y constantes.

import org.progI.entities.Usuario;
import org.progI.interfaces.AdmConexion;
import org.progI.interfaces.DAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioImpl implements AdmConexion, DAO<Usuario, Integer> {

  private Connection conn = null;

  //Preparamos el Statement (Buscar que es y para que sirve para entender mucho mejor.)
  private PreparedStatement psInsertar;
  private PreparedStatement psBuscar;
  private PreparedStatement psEliminar;

  //ver porque va el final, o preguntarle a ara para que es
  private static final String SQL_INSERT =
      "INSERT INTO usuarios (nombre, apellido, email, telefono, contraseña)" +
      "VALUES (?, ?, ?, ?, ?)";


  private static final String SQL_UPDATE =
      "UPDATE usuarios SET " +
          "nombre = ?, " +
          "apellido = ?, " +
          "email = ?, " +
          "telefono = ?, " +
          "WHERE idUsuario = ?";

  private static final String SQL_DELETE =
      "DELETE FROM usuario WHERE idUsuario = ?";

  private static final String SQL_GETALL =
      "SELECT * FROM usuario ORDER BY idUsuario";

  private static final String SQL_GETBYID =
      "SELECT * FROM usuario WHERE idUsuario = ?";

  @Override
  public List<Usuario> getAll() {
    //Conectamos la BD
    conn = obtenerConexion();

    PreparedStatement pst = null;
    ResultSet rs = null;

    List<Usuario> listaUsuarios = new ArrayList();

    try {
      pst = conn.prepareStatement(SQL_GETALL);
      rs = pst.executeQuery();
      while (rs.next()){
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(rs.getInt("idUsuario"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setApellido(rs.getString("apellido"));
        usuario.setEmail(rs.getString("email"));
        usuario.setTelefono(rs.getString("telefono"));
        usuario.setContrasenia(rs.getString("contrasenia"));

        listaUsuarios.add(usuario);
      }

      //cierro
      rs.close();
      pst.close();
      conn.close();
    } catch (SQLException e) {
      System.out.println("Error al obtener todos los datos del usuario");
      throw new RuntimeException(e);
    }
    return listaUsuarios;
  }

  @Override
  public void insert(Usuario objeto) {
    Usuario usuario = objeto;
    conn = obtenerConexion();
    
    PreparedStatement pst = null;
    
    try {
      pst = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
      
      pst.setString(1, usuario.getNombre());
      pst.setString(2, usuario.getApellido());
      pst.setString(3, usuario.getEmail());
      pst.setString(4, usuario.getTelefono());
      pst.setString(5, usuario.getContrasenia());

      int resultado = pst.executeUpdate();
      if (resultado == 1){
        System.out.println("Usuario insertado correctamente");
      }else {
        System.out.println("No se pudo agregar el usuario");
      }

      pst.close();
      conn.close();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void update(Usuario objeto) {
    Usuario usuario = objeto;

    if (this.existsById(usuario.getIdUsuario())){
      conn = obtenerConexion();
      PreparedStatement pst = null;

      try {
        pst = conn.prepareStatement(SQL_UPDATE );

        pst.setString(1, usuario.getNombre());
        pst.setString(2, usuario.getApellido());
        pst.setString(3, usuario.getEmail());
        pst.setString(4, usuario.getTelefono());
        pst.setString(5, usuario.getContrasenia());

        int resultado = pst.executeUpdate();
        if (resultado == 1){
          System.out.println("Se actualizo correctamente el usuario");
        }else {
          System.out.println("No se logro actualizar el usuario");
        }

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

      int resultado = pst.executeUpdate();
      if (resultado == 1){
        System.out.println("Usuario eliminado correctamente");
      }else {
        System.out.println("No se logró elminiar el usuario");
      }
      pst.close();
      conn.close();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Usuario getById(Integer id) {
    conn = obtenerConexion();

    PreparedStatement pst = null;
    ResultSet rs = null;
    Usuario usuario = null;

    try {
      pst = conn.prepareStatement(SQL_GETBYID);
      pst.setInt(1, id);
      rs = pst.executeQuery();

      if (rs.next()){
        usuario = new Usuario();
        usuario.setIdUsuario(rs.getInt("idUsuario"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setApellido(rs.getString("apellido"));
        usuario.setEmail(rs.getString("email"));
        usuario.setTelefono(rs.getString("telefono"));
        usuario.setContrasenia(rs.getString("contrasenia"));
      }

      rs.close();
      pst.close();
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return usuario;
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

      if (rs.next()){
        existe = true;
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return existe;
  }
}
