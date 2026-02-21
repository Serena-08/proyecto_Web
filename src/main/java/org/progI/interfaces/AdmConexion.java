package org.progI.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface AdmConexion {

  default Connection obtenerConexion () {

    //4 datos de conexión
    String dbDriver= "com.mysql.cj.jdbc.Driver";
    //Cadena de conexión a mi BD

    //String dbCadenaConexion= "jdbc:mysql://localhost:3306/progautos";
    String dbCadenaConexion = "jdbc:mysql://127.0.0.1:3306/proyecto_Web";

    //Nom usuario
    String dbUsuario="root";

    //Contraseña BD
    String dbPass="1234";

    Connection conn =null;

    /* Que es el try-catch
    estructura de control fundamental para el manejo de excepciones (errores en tiempo de ejecución)
    que permite "intentar" ejecutar un bloque de código y "atrapar" o gestionar errores potenciales
    sin que el programa finalice abruptamente.
     */

    try {
      //Código propenso a fallar
      Class.forName(dbDriver);

      conn = DriverManager.getConnection (dbCadenaConexion, dbUsuario, dbPass);
    }
    catch (ClassNotFoundException e) {
      //Código para manejar la excepción
      System.out.println("No se encontró el Driver de la BD");
      throw new RuntimeException(e); //Si se aparece otro fallo

    } catch (SQLException e){
      System.out.println("No se pudo conectar la Base de Datos");
      throw new RuntimeException(e);
    }
    System.out.println("Conexión exitosa a la Base de Datos");
    return conn; }

}
