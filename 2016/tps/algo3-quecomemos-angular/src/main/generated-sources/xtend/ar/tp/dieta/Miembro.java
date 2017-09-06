package ar.tp.dieta;

import ar.tp.dieta.Busqueda;
import ar.tp.dieta.RecetarioPublico;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public abstract class Miembro {
  protected String nombre;
  
  protected List<String> preferencias = new ArrayList<String>();
  
  protected List<Busqueda> misBusquedas = new ArrayList<Busqueda>();
  
  protected RecetarioPublico recetario;
  
  public void agregarBusqueda(final Busqueda unaBusqueda) {
    this.misBusquedas.add(unaBusqueda);
  }
  
  public void removerBusqueda(final Busqueda unaBusqueda) {
    this.misBusquedas.remove(unaBusqueda);
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public List<String> getPreferencias() {
    return this.preferencias;
  }
  
  public void setPreferencias(final List<String> preferencias) {
    this.preferencias = preferencias;
  }
  
  @Pure
  public List<Busqueda> getMisBusquedas() {
    return this.misBusquedas;
  }
  
  public void setMisBusquedas(final List<Busqueda> misBusquedas) {
    this.misBusquedas = misBusquedas;
  }
  
  @Pure
  public RecetarioPublico getRecetario() {
    return this.recetario;
  }
  
  public void setRecetario(final RecetarioPublico recetario) {
    this.recetario = recetario;
  }
}
