package org.progI.dao;

//Implements= Palabra clave usada por una clase para que pueda implementar una o más interfaces.
//Interfaces= Contrato que define un conjunto de métodos abstractos (sin cuerpos) y constantes.

import org.progI.entities.Usuario;
import org.progI.interfaces.AdmConexion;
import org.progI.interfaces.DAO;


import java.sql.Connection;
import java.util.List;

public class UsuarioImpl implements AdmConexion, DAO<Usuario, Integer> {

  private Connection conn = null;

  private static String SQL_INSERT = "INSERT INTO usuarios (nombre, apellido, email, telefono, contraseña)" +
      "VALUES (?, ?, ?, ?, ?)";


  private static String SQL_UPDATE =
      "UPDATE usuarios SET " +
          "nombre = ?, " +
          "apellido = ?, " +
          "email = ?, " +
          "telefono = ?, " +
          "WHERE idUsuario = ?";

  @Override
  public List<Usuario> getAll() {
    return List.of();
  }

  @Override
  public void insert(Usuario objeto) {

  }

  @Override
  public void update(Usuario objeto) {

  }

  @Override
  public void delete(Integer id) {

  }

  @Override
  public Usuario getById(Integer id) {
    return null;
  }

  @Override
  public boolean existsById(Integer id) {
    return false;
  }
}
