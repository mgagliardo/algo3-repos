package controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors
@SuppressWarnings("all")
public class infoCopia {
  private String nombre;
  
  private String nombreCopia;
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public String getNombreCopia() {
    return this.nombreCopia;
  }
  
  public void setNombreCopia(final String nombreCopia) {
    this.nombreCopia = nombreCopia;
  }
}
