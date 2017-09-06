package ar.tp.dieta;

import ar.tp.dieta.Admin;
import ar.tp.dieta.Condicion;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RepoUsuarios {
  private Admin administrador;
  
  private List<Usuario> usuarios = new ArrayList<Usuario>();
  
  public void agregarUsuario(final Usuario unUsuario) {
    this.administrador.solicitudAgregarUsuario(unUsuario);
  }
  
  public void removerUsuario(final Usuario unUsuario) {
    this.administrador.solicitudRemoverUsuario(unUsuario);
  }
  
  public boolean updatearUsuario(final Usuario UnUsuario) {
    return this.administrador.solicitudActualizarUsuario(UnUsuario);
  }
  
  public Usuario getUsuarioPorNombre(final String nombreDeUsuario) {
    final Function1<Usuario, Boolean> _function = new Function1<Usuario, Boolean>() {
      public Boolean apply(final Usuario usuario) {
        String _nombre = usuario.getNombre();
        return Boolean.valueOf(_nombre.equals(nombreDeUsuario));
      }
    };
    return IterableExtensions.<Usuario>findFirst(this.usuarios, _function);
  }
  
  public Iterable<Usuario> getListaDeUsuarios(final String nombreDeUsuario) {
    final Function1<Usuario, Boolean> _function = new Function1<Usuario, Boolean>() {
      public Boolean apply(final Usuario it) {
        String _nombre = it.getNombre();
        return Boolean.valueOf(_nombre.equals(nombreDeUsuario));
      }
    };
    return IterableExtensions.<Usuario>filter(this.usuarios, _function);
  }
  
  public Iterable<Usuario> getListaDeUsuarios(final Condicion unaCondicion) {
    final Function1<Usuario, Boolean> _function = new Function1<Usuario, Boolean>() {
      public Boolean apply(final Usuario it) {
        return Boolean.valueOf(it.tenesEstaCondicion(unaCondicion));
      }
    };
    return IterableExtensions.<Usuario>filter(this.usuarios, _function);
  }
  
  @Pure
  public Admin getAdministrador() {
    return this.administrador;
  }
  
  public void setAdministrador(final Admin administrador) {
    this.administrador = administrador;
  }
  
  @Pure
  public List<Usuario> getUsuarios() {
    return this.usuarios;
  }
  
  public void setUsuarios(final List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }
}
