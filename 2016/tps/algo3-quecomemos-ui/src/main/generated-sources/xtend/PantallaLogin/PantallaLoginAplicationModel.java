package PantallaLogin;

import ar.tp.dieta.RepositorioUsuarios;
import ar.tp.dieta.Usuario;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class PantallaLoginAplicationModel {
  private RepositorioUsuarios repoUsuarios = new RepositorioUsuarios();
  
  private String nombre;
  
  private String contraseña;
  
  private Usuario usuario;
  
  public Usuario validar() {
    Usuario _validarLogin = this.repoUsuarios.validarLogin(this.nombre, this.contraseña);
    return this.usuario = _validarLogin;
  }
  
  @Pure
  public RepositorioUsuarios getRepoUsuarios() {
    return this.repoUsuarios;
  }
  
  public void setRepoUsuarios(final RepositorioUsuarios repoUsuarios) {
    this.repoUsuarios = repoUsuarios;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public String getContraseña() {
    return this.contraseña;
  }
  
  public void setContraseña(final String contraseña) {
    this.contraseña = contraseña;
  }
  
  @Pure
  public Usuario getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(final Usuario usuario) {
    this.usuario = usuario;
  }
}
