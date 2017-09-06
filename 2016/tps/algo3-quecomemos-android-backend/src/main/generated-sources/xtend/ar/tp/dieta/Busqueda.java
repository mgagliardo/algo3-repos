package ar.tp.dieta;

import ar.tp.dieta.Filtro;
import ar.tp.dieta.Grupo;
import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Busqueda {
  private List<Filtro> filtros = new ArrayList<Filtro>();
  
  public void agregarFiltro(final Filtro unFiltro) {
    this.filtros.add(unFiltro);
  }
  
  public void removerFiltro(final Filtro unFiltro) {
    this.filtros.remove(unFiltro);
  }
  
  public List<Receta> aplicarBusquedaUsuario(final Usuario usuario, final List<Receta> recetas) {
    List<Receta> _xblockexpression = null;
    {
      List<Receta> recetasFiltradas = recetas;
      int counter = 0;
      while ((counter < this.filtros.size())) {
        {
          Filtro _get = this.filtros.get(counter);
          List<Receta> _aplicarFiltroUsuario = _get.aplicarFiltroUsuario(usuario, recetasFiltradas);
          recetasFiltradas = _aplicarFiltroUsuario;
          counter++;
        }
      }
      _xblockexpression = recetasFiltradas;
    }
    return _xblockexpression;
  }
  
  public List<Receta> aplicarBusquedaGrupo(final Grupo unGrupo, final List<Receta> recetas) {
    List<Receta> _xblockexpression = null;
    {
      List<Receta> recetasFiltradas = recetas;
      int counter = 0;
      while ((counter < this.filtros.size())) {
        {
          Filtro _get = this.filtros.get(counter);
          List<Receta> _aplicarFiltroGrupo = _get.aplicarFiltroGrupo(unGrupo, recetasFiltradas);
          recetasFiltradas = _aplicarFiltroGrupo;
          counter++;
        }
      }
      _xblockexpression = recetasFiltradas;
    }
    return _xblockexpression;
  }
}
