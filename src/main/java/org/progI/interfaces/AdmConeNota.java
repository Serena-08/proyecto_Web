/*package org.progI.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface AdmConexion {

  // 1. CONSTANTES DE CONEXIÓN
  // Al ponerlas aquí, son 'public static final' automáticamente.
  // Es el lugar centralizado para configurar tu BD.
  String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
  String DB_URL = "jdbc:mysql://127.0.0.1:3306/proyecto_Web"; // Asegúrate que este nombre sea correcto
  String DB_USER = "root";
  String DB_PASS = "1234";

  // 2. MÉTODO DEFAULT
  // Permite que cualquier clase que implemente esta interfaz tenga acceso a 'obtenerConexion'
  default Connection obtenerConexion() {
    Connection conn = null;

    try {
      // Nota: En versiones modernas de Java/JDBC, 'Class.forName' ya no es obligatorio,
      // pero no hace daño dejarlo si tu profesor lo pide explícitamente.
      // Class.forName(DB_DRIVER);

      // Intentamos conectar usando las constantes de arriba
      conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

      System.out.println(">> Conexión exitosa a la Base de Datos 'proyecto_Web'");

    } catch (SQLException e) {
      // Error de conexión (usuario incorrecto, base caída, url mal escrita)
      System.err.println("!! Error Crítico: No se pudo conectar a la Base de Datos.");
      System.err.println("Mensaje: " + e.getMessage());
      throw new RuntimeException(e);
    }

    return conn;
  }
}

 */