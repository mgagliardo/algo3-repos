package ar.tp.dieta;

import ar.tp.dieta.Grupo;
import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import java.util.List;

@SuppressWarnings("all")
public interface Filtro {
  public abstract List<Receta> aplicarFiltroUsuario(final Usuario unUsuario, final List<Receta> recetasSinFiltrar);
  
  public abstract List<Receta> aplicarFiltroGrupo(final Grupo unGrupo, final List<Receta> recetasSinFiltrar);
}
