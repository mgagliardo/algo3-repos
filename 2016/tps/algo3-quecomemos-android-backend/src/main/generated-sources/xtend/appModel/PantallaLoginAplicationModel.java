package appModel;

import ar.tp.dieta.RepositorioUsuarios;
import ar.tp.dieta.Usuario;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class PantallaLoginAplicationModel {
  public RepositorioUsuarios repoUsuarios;
  
  private String nombre = "Miguel";
  
  private String contrasenia = "miguel";
  
  public Usuario usuario;
  
  public PantallaLoginAplicationModel() {
    RepositorioUsuarios _repositorioUsuarios = new RepositorioUsuarios();
    this.repoUsuarios = _repositorioUsuarios;
  }
  
  public Usuario validar() {
    Usuario _validarLogin = this.repoUsuarios.validarLogin(this.nombre, this.contrasenia);
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
  public String getContrasenia() {
    return this.contrasenia;
  }
  
  public void setContrasenia(final String contrasenia) {
    this.contrasenia = contrasenia;
  }
  
  @Pure
  public Usuario getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(final Usuario usuario) {
    this.usuario = usuario;
  }
}
