package controller;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class ayuda {
  private String nombre;
  
  private String Contrasenia;
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public String getContrasenia() {
    return this.Contrasenia;
  }
  
  public void setContrasenia(final String Contrasenia) {
    this.Contrasenia = Contrasenia;
  }
}
