package ar.tp.dieta;

import ar.tp.dieta.Busqueda;
import ar.tp.dieta.Condimento;
import ar.tp.dieta.ElementoDeReceta;
import ar.tp.dieta.Ingrediente;
import ar.tp.dieta.Miembro;
import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Grupo extends Miembro {
  private List<Usuario> miembros = new ArrayList<Usuario>();
  
  public void eliminarUsuario(final Usuario unUsuario) {
    this.miembros.remove(unUsuario);
    List<Grupo> _misGrupos = unUsuario.getMisGrupos();
    _misGrupos.remove(this);
  }
  
  public Iterable<Receta> recetasDelGrupoPara(final Usuario unUsuario) {
    final Function1<Usuario, Boolean> _function = new Function1<Usuario, Boolean>() {
      @Override
      public Boolean apply(final Usuario usr) {
        return Boolean.valueOf((!Objects.equal(usr, unUsuario)));
      }
    };
    Iterable<Usuario> _filter = IterableExtensions.<Usuario>filter(this.miembros, _function);
    final Function1<Usuario, List<Receta>> _function_1 = new Function1<Usuario, List<Receta>>() {
      @Override
      public List<Receta> apply(final Usuario it) {
        return it.getMisRecetas();
      }
    };
    Iterable<List<Receta>> _map = IterableExtensions.<Usuario, List<Receta>>map(_filter, _function_1);
    return Iterables.<Receta>concat(_map);
  }
  
  public boolean esMiembro(final Usuario unUsuario) {
    return this.miembros.contains(unUsuario);
  }
  
  public boolean agregarUsuario(final Usuario unUsuario) {
    return this.miembros.add(unUsuario);
  }
  
  public Receta devolverRecetaDeMiembro(final String nombreReceta) {
    Receta _xblockexpression = null;
    {
      Usuario miembro = null;
      final Function1<Usuario, Boolean> _function = new Function1<Usuario, Boolean>() {
        @Override
        public Boolean apply(final Usuario usuario) {
          Receta _devolverReceta = usuario.devolverReceta(nombreReceta);
          return Boolean.valueOf((!Objects.equal(_devolverReceta, null)));
        }
      };
      Usuario _findFirst = IterableExtensions.<Usuario>findFirst(this.miembros, _function);
      miembro = _findFirst;
      _xblockexpression = miembro.devolverReceta(nombreReceta);
    }
    return _xblockexpression;
  }
  
  public Receta copiarReceta(final Usuario unUsuario, final Grupo unGrupo, final Receta unaReceta, final String nombreReceta) {
    Receta _xblockexpression = null;
    {
      Receta recetaTemporal = this.devolverRecetaDeMiembro(nombreReceta);
      String _nombreDeLaReceta = recetaTemporal.getNombreDeLaReceta();
      unaReceta.setNombreDeLaReceta(_nombreDeLaReceta);
      double _calorias = recetaTemporal.getCalorias();
      unaReceta.setCalorias(_calorias);
      String _procesoDePreparacion = recetaTemporal.getProcesoDePreparacion();
      unaReceta.setProcesoDePreparacion(_procesoDePreparacion);
      String _dificultadDePreparacion = recetaTemporal.getDificultadDePreparacion();
      unaReceta.setDificultadDePreparacion(_dificultadDePreparacion);
      String _temporadaALaQueCorresponde = recetaTemporal.getTemporadaALaQueCorresponde();
      unaReceta.setTemporadaALaQueCorresponde(_temporadaALaQueCorresponde);
      List<Ingrediente> _ingredientes = recetaTemporal.getIngredientes();
      ArrayList<Ingrediente> _arrayList = new ArrayList<Ingrediente>(_ingredientes);
      unaReceta.setIngredientes(_arrayList);
      List<Condimento> _condimentos = recetaTemporal.getCondimentos();
      ArrayList<Condimento> _arrayList_1 = new ArrayList<Condimento>(_condimentos);
      unaReceta.setCondimentos(_arrayList_1);
      _xblockexpression = unaReceta;
    }
    return _xblockexpression;
  }
  
  public List<Usuario> devolverTodosLosMiembros() {
    return this.miembros;
  }
  
  public boolean tePuedoSugerirEstaReceta(final Receta receta) {
    boolean _and = false;
    final Function1<Usuario, Boolean> _function = new Function1<Usuario, Boolean>() {
      @Override
      public Boolean apply(final Usuario usuario) {
        return Boolean.valueOf(receta.esInadecuadaParaUsuario(usuario));
      }
    };
    boolean _exists = IterableExtensions.<Usuario>exists(this.miembros, _function);
    boolean _not = (!_exists);
    if (!_not) {
      _and = false;
    } else {
      boolean _meGustaEstaReceta = this.meGustaEstaReceta(receta);
      _and = _meGustaEstaReceta;
    }
    return _and;
  }
  
  public boolean meGustaEstaReceta(final Receta receta) {
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String ingrediente) {
        List<ElementoDeReceta> _elementosDeReceta = receta.getElementosDeReceta();
        final Function1<ElementoDeReceta, Boolean> _function = new Function1<ElementoDeReceta, Boolean>() {
          @Override
          public Boolean apply(final ElementoDeReceta elem) {
            String _nombre = elem.getNombre();
            return Boolean.valueOf(_nombre.equals(ingrediente));
          }
        };
        return Boolean.valueOf(IterableExtensions.<ElementoDeReceta>exists(_elementosDeReceta, _function));
      }
    };
    return IterableExtensions.<String>exists(this.preferencias, _function);
  }
  
  public List<Receta> devolverRecetas() {
    List<Receta> _xblockexpression = null;
    {
      final List<Receta> recetasDeGrupo = new ArrayList<Receta>();
      List<Receta> _recetas = this.recetario.getRecetas();
      recetasDeGrupo.addAll(_recetas);
      final Function1<Usuario, List<Receta>> _function = new Function1<Usuario, List<Receta>>() {
        @Override
        public List<Receta> apply(final Usuario it) {
          return it.getMisRecetas();
        }
      };
      List<List<Receta>> _map = ListExtensions.<Usuario, List<Receta>>map(this.miembros, _function);
      Iterable<Receta> _flatten = Iterables.<Receta>concat(_map);
      Iterables.<Receta>addAll(recetasDeGrupo, _flatten);
      _xblockexpression = recetasDeGrupo;
    }
    return _xblockexpression;
  }
  
  public List<Receta> busquedaFiltrada() {
    List<Receta> _xblockexpression = null;
    {
      List<Receta> recetasFiltradas = this.devolverRecetas();
      boolean _isEmpty = this.misBusquedas.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        Iterator<Busqueda> iterBusqueda = this.misBusquedas.iterator();
        while (iterBusqueda.hasNext()) {
          Busqueda _next = iterBusqueda.next();
          List<Receta> _aplicarBusquedaGrupo = _next.aplicarBusquedaGrupo(this, recetasFiltradas);
          recetasFiltradas = _aplicarBusquedaGrupo;
        }
      }
      _xblockexpression = recetasFiltradas;
    }
    return _xblockexpression;
  }
  
  @Pure
  public List<Usuario> getMiembros() {
    return this.miembros;
  }
  
  public void setMiembros(final List<Usuario> miembros) {
    this.miembros = miembros;
  }
}
