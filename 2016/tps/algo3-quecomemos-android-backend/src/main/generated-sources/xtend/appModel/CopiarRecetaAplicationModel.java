package appModel;

import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class CopiarRecetaAplicationModel {
  private String nombreCopia;
  
  private Receta receta;
  
  private Usuario usuario;
  
  public CopiarRecetaAplicationModel() {
  }
  
  public CopiarRecetaAplicationModel(final Receta parametroReceta, final Usuario parametroUsuario) {
    this.receta = parametroReceta;
    this.usuario = parametroUsuario;
  }
  
  public void copiar() {
    this.usuario.existeReceta(this.receta, this.nombreCopia);
  }
  
  public void nombreRecetaVacio() {
    this.usuario.nombreRecetaVacio(this.nombreCopia);
  }
  
  public void copiar(final String nombre) {
    Receta _devolverReceta = this.usuario.devolverReceta(nombre);
    this.usuario.existeReceta(_devolverReceta, nombre);
  }
  
  @Pure
  public String getNombreCopia() {
    return this.nombreCopia;
  }
  
  public void setNombreCopia(final String nombreCopia) {
    this.nombreCopia = nombreCopia;
  }
  
  @Pure
  public Receta getReceta() {
    return this.receta;
  }
  
  public void setReceta(final Receta receta) {
    this.receta = receta;
  }
  
  @Pure
  public Usuario getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(final Usuario usuario) {
    this.usuario = usuario;
  }
}
