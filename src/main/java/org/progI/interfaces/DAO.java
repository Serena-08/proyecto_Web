package org.progI.interfaces;

import java.util.List;

/*
Clases Genericas o Tiopos Parametrizados, no spermiten crear clases, interfaces y métodos en los que los tipos
de datos que queremos operar, se envien como argumentos al instanciar la clase.
 */

public interface DAO <O,K>  {
  //O objeto, K clave primaria

  /*
  insert
  update
  delete
  getAll
  getById
  exists
   */

  public List<O> getAll();
  public void insert(O objeto);
  public void update(O objeto);
  public void delete(K id);
  public O getById(K id);
  public boolean existsById(K id);

}
