package detalleReceta;

import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
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
