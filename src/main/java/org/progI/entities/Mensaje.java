package org.progI.entities;

public class Mensaje {
  private int idMensaje;
  private String mensaje;
  private int fecha;
  private int hora;
  private String destinatario;
  private Plataforma plataforma;


  public Mensaje(String mensaje, int fecha, int hora, String destinatario, Plataforma plataforma){
    this.mensaje = mensaje;
    this.fecha = fecha;
    this.hora = hora;
    this.destinatario = destinatario;
    this.plataforma = plataforma;
  }

  public Mensaje(){}

  //Getters y Setters
 /*
  Los getters y setters en Java son métodos públicos utilizados para acceder (get) y modificar (set)
   de forma segura los atributos privados de una clase.
  */
  public int getIdMensaje() {return idMensaje;}

  public void setIdMensaje(int idMensaje) {this.idMensaje = idMensaje;}

  public String getMensaje() {return mensaje;}

  public void setMensaje(String mensaje) {this.mensaje = mensaje;}

  public int getFecha() {return fecha;}

  public void setFecha(int fecha) {this.fecha = fecha;}

  public int getHora() {return hora;}

  public void setHora(int hora) {this.hora = hora;}

  public String getDestinatario() {return destinatario;}

  public void setDestinatario(String destinatario) {this.destinatario = destinatario;}

  public Plataforma getPlataforma() {return plataforma;}

  public void setPlataforma(Plataforma plataforma) {this.plataforma = plataforma;}

  //Override
/*
La anotación @override en java, sirve para indicar explícitamente que un metodo en una subclase está reemplazando
o modificando el comportamiento de un metodo heredado de su superclase o interfaz
 */

  @Override
  public String toString() {
    return "Mensaje{" +
        "idMensaje=" + idMensaje +
        ", mensaje='" + mensaje + '\'' +
        ", fecha='" + fecha + '\'' +
        ", hora='" + hora + '\'' +
        ", destinatario='" + destinatario + '\'' +
        ", plataforma='" + plataforma +
        '}';


  }

}