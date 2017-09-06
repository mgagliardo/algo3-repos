package appModel;

import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class DetalleRecetaAplicationModel {
  private Usuario usuario;
  
  private Receta receta;
  
  public DetalleRecetaAplicationModel(final Receta recetaSeleccionada, final Usuario usuarioSeleccionado) {
    this.receta = recetaSeleccionada;
    this.usuario = usuarioSeleccionado;
  }
  
  public boolean getFavorita() {
    return this.usuario.contenesEstaRecetaEnFavs(this.receta);
  }
  
  public boolean getEsFavorita() {
    return this.usuario.contenesEstaRecetaEnFavs(this.receta);
  }
  
  public void setEsFavorita(final boolean unBool) {
    if (unBool) {
      this.usuario.agregarRecetaFavorita(this.receta);
    } else {
      this.usuario.eliminarRecetaFavorita(this.receta);
    }
  }
  
  public boolean getEditable() {
    return false;
  }
  
  @Pure
  public Usuario getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(final Usuario usuario) {
    this.usuario = usuario;
  }
  
  @Pure
  public Receta getReceta() {
    return this.receta;
  }
  
  public void setReceta(final Receta receta) {
    this.receta = receta;
  }
}
