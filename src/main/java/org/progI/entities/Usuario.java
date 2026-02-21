package org.progI.entities;

public class Usuario {
  private int idUsuario;
  private String nombre;
  private String apellido;
  private String email;
  private String telefono;
  private String contrasenia;

  public Usuario() {idUsuario = - 1;}

  public Usuario(int idUsuario, String nombre, String apellido, String email, String telefono, String contrasenia) {
    this.idUsuario = idUsuario;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.telefono = telefono;
    this.contrasenia = contrasenia;
  }

  //Getters y Setters


  public int getIdUsuario() {return idUsuario;}

  public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

  public String getNombre() {return nombre;}

  public void setNombre(String nombre) {this.nombre = nombre;}

  public String getApellido() {return apellido;}

  public void setApellido(String apellido) {this.apellido = apellido;}

  public String getEmail() {return email;}

  public void setEmail(String email) {this.email = email;}

  public String getTelefono() {return telefono;}

  public void setTelefono(String telefono) {this.telefono = telefono;}

  public String getcontrasenia() {return contrasenia;}

  public void setcontrasenia(String contrasenia) {this.contrasenia = contrasenia;}

  @Override
  public String toString() {
    return "Usuario{" +
        "idUsuario=" + idUsuario +
        ", nombre='" + nombre + '\'' +
        ", apellido='" + apellido + '\'' +
        ", email='" + email + '\'' +
        ", telefono='" + telefono + '\'' +
        ", contrasenia='" + contrasenia + '\'' +
        '}';
  }
}
