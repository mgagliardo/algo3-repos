package ar.tp.dieta;

import ar.tp.dieta.RepoUsuarios;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Admin {
  private RepoUsuarios repo;
  
  private List<Usuario> usuariosAAgregar = new ArrayList<Usuario>();
  
  private List<Usuario> usuariosARemover = new ArrayList<Usuario>();
  
  private List<Usuario> usuariosAActualizar = new ArrayList<Usuario>();
  
  public boolean solicitudAgregarUsuario(final Usuario usuario) {
    return this.usuariosAAgregar.add(usuario);
  }
  
  public boolean solicitudRemoverUsuario(final Usuario usuario) {
    return this.usuariosARemover.add(usuario);
  }
  
  public boolean solicitudActualizarUsuario(final Usuario usuario) {
    return this.usuariosAActualizar.add(usuario);
  }
  
  public boolean procesarUsuariosAAgregar() {
    boolean _xblockexpression = false;
    {
      List<Usuario> _usuarios = this.repo.getUsuarios();
      Usuario _get = this.usuariosAAgregar.get(0);
      _usuarios.add(_get);
      Usuario _get_1 = this.usuariosAAgregar.get(0);
      _xblockexpression = this.usuariosAAgregar.remove(_get_1);
    }
    return _xblockexpression;
  }
  
  public boolean usuarioAIngresarADescartar() {
    Usuario _get = this.usuariosAAgregar.get(0);
    return this.usuariosAAgregar.remove(_get);
  }
  
  public boolean procesarUsuariosARemover() {
    boolean _xblockexpression = false;
    {
      List<Usuario> _usuarios = this.repo.getUsuarios();
      Usuario _get = this.usuariosAAgregar.get(0);
      _usuarios.remove(_get);
      Usuario _get_1 = this.usuariosARemover.get(0);
      _xblockexpression = this.usuariosARemover.remove(_get_1);
    }
    return _xblockexpression;
  }
  
  public boolean usuarioARemoverRechazado() {
    Usuario _get = this.usuariosARemover.get(0);
    return this.usuariosARemover.remove(_get);
  }
  
  public void procesarUsuariosAActualizar() {
    final Consumer<Usuario> _function = new Consumer<Usuario>() {
      public void accept(final Usuario usuario) {
        String _nombre = usuario.getNombre();
        Usuario _usuarioPorNombre = Admin.this.repo.getUsuarioPorNombre(_nombre);
        Admin.this.repo.removerUsuario(_usuarioPorNombre);
        Admin.this.repo.agregarUsuario(usuario);
      }
    };
    this.usuariosAActualizar.forEach(_function);
  }
  
  @Pure
  public RepoUsuarios getRepo() {
    return this.repo;
  }
  
  public void setRepo(final RepoUsuarios repo) {
    this.repo = repo;
  }
  
  @Pure
  public List<Usuario> getUsuariosAAgregar() {
    return this.usuariosAAgregar;
  }
  
  public void setUsuariosAAgregar(final List<Usuario> usuariosAAgregar) {
    this.usuariosAAgregar = usuariosAAgregar;
  }
  
  @Pure
  public List<Usuario> getUsuariosARemover() {
    return this.usuariosARemover;
  }
  
  public void setUsuariosARemover(final List<Usuario> usuariosARemover) {
    this.usuariosARemover = usuariosARemover;
  }
  
  @Pure
  public List<Usuario> getUsuariosAActualizar() {
    return this.usuariosAActualizar;
  }
  
  public void setUsuariosAActualizar(final List<Usuario> usuariosAActualizar) {
    this.usuariosAActualizar = usuariosAActualizar;
  }
}
