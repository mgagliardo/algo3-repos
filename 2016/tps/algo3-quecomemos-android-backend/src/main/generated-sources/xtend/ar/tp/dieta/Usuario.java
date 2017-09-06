package ar.tp.dieta;

import ar.tp.dieta.BusinessException;
import ar.tp.dieta.Busqueda;
import ar.tp.dieta.Condicion;
import ar.tp.dieta.ContadorConsultas;
import ar.tp.dieta.ElementoDeReceta;
import ar.tp.dieta.Grupo;
import ar.tp.dieta.Ingrediente;
import ar.tp.dieta.Miembro;
import ar.tp.dieta.Receta;
import ar.tp.dieta.RecetaBuilder;
import ar.tp.dieta.Rutina;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors
@SuppressWarnings("all")
public class Usuario extends Miembro {
  private String contrasenia;
  
  private Double peso;
  
  private Double altura;
  
  private GregorianCalendar fechaDeNacimiento;
  
  private GregorianCalendar diaDeHoy;
  
  private String sexo;
  
  private Rutina rutina;
  
  private List<Condicion> condicionesPreexistentes = new ArrayList<Condicion>();
  
  private List<String> comidasQueNoMeGustan = new ArrayList<String>();
  
  private List<Receta> misRecetas = new ArrayList<Receta>();
  
  private List<Grupo> misGrupos = new ArrayList<Grupo>();
  
  private List<String> recetasFavoritas = new ArrayList<String>();
  
  private Busqueda busqueda = new Busqueda();
  
  private String direccionCorreo;
  
  private Boolean resultadoDeConsultasAFavoritos = Boolean.valueOf(false);
  
  private List<Receta> recetasFavoritas2 = new ArrayList<Receta>();
  
  private ContadorConsultas observerConsulta;
  
  private List<Receta> recetasBuscadas = new ArrayList<Receta>();
  
  public GregorianCalendar setFechaDeNacimiento(final int ano, final int mes, final int diaDelMes) {
    GregorianCalendar _gregorianCalendar = new GregorianCalendar(ano, mes, diaDelMes);
    return this.fechaDeNacimiento = _gregorianCalendar;
  }
  
  public double indiceDeMasaCorporal() {
    double _pow = Math.pow((this.altura).doubleValue(), 2);
    return ((this.peso).doubleValue() / _pow);
  }
  
  protected boolean validarIMC() {
    boolean _and = false;
    double _indiceDeMasaCorporal = this.indiceDeMasaCorporal();
    boolean _greaterEqualsThan = (18 >= _indiceDeMasaCorporal);
    if (!_greaterEqualsThan) {
      _and = false;
    } else {
      double _indiceDeMasaCorporal_1 = this.indiceDeMasaCorporal();
      boolean _lessEqualsThan = (_indiceDeMasaCorporal_1 <= 30);
      _and = _lessEqualsThan;
    }
    return _and;
  }
  
  public boolean sigoUnaRutinaSaludable() {
    return this.rutina.rutinaSaludable(this);
  }
  
  public void agregarCondicion(final Condicion unaCondicion) {
    this.condicionesPreexistentes.add(unaCondicion);
  }
  
  public void agregarPreferencia(final String unaComida) {
    this.preferencias.add(unaComida);
  }
  
  public void agregarComidaQueMeDisgusta(final String unaComida) {
    this.comidasQueNoMeGustan.add(unaComida);
  }
  
  protected boolean subsanaTodasLasCondiciones() {
    final Function1<Condicion, Boolean> _function = new Function1<Condicion, Boolean>() {
      public Boolean apply(final Condicion condicion) {
        boolean _seSubsana = condicion.seSubsana(Usuario.this);
        return Boolean.valueOf((!_seSubsana));
      }
    };
    return IterableExtensions.<Condicion>exists(this.condicionesPreexistentes, _function);
  }
  
  protected boolean rutinaEsIntensiva() {
    return this.rutina.rutinaEsIntensiva();
  }
  
  protected boolean rutinaEsActiva() {
    return this.rutina.rutinaEsActiva();
  }
  
  protected boolean meGustaLaCarne() {
    return this.preferencias.contains("carne");
  }
  
  protected boolean meGustaLaFruta() {
    return this.preferencias.contains("fruta");
  }
  
  public void agregarRecetaPublicaAMiColeccion(final Receta unaReceta, final String nombreReceta) {
    String _nombreDeLaReceta = unaReceta.getNombreDeLaReceta();
    Receta recetaTemporal = this.recetario.copiarReceta(_nombreDeLaReceta, nombreReceta);
    this.misRecetas.add(recetaTemporal);
  }
  
  public void agregarRecetaDeGrupo(final Grupo unGrupo, final String nombreReceta) {
    Receta recetaNueva = new Receta();
    Receta _copiarReceta = unGrupo.copiarReceta(this, unGrupo, recetaNueva, nombreReceta);
    this.misRecetas.add(_copiarReceta);
  }
  
  public void crearReceta(final String nombre, final int calorias, final String autor, final String dificultad, final String preparacion, final String temporada, final Ingrediente ingrediente1, final Ingrediente ingrediente2) {
    RecetaBuilder _recetaBuilder = new RecetaBuilder(nombre);
    RecetaBuilder _autor = _recetaBuilder.autor(autor);
    RecetaBuilder _calorias = _autor.calorias(calorias);
    RecetaBuilder _dificultad = _calorias.dificultad(dificultad);
    RecetaBuilder _procesoPreparacion = _dificultad.procesoPreparacion(preparacion);
    RecetaBuilder _temporada = _procesoPreparacion.temporada(temporada);
    RecetaBuilder _agregarIngrediente = _temporada.agregarIngrediente(ingrediente1);
    RecetaBuilder _agregarIngrediente_1 = _agregarIngrediente.agregarIngrediente(ingrediente2);
    Receta _build = _agregarIngrediente_1.build();
    this.misRecetas.add(_build);
  }
  
  public Receta devolverReceta(final String nombre) {
    Receta _xblockexpression = null;
    {
      final Function1<Receta, Boolean> _function = new Function1<Receta, Boolean>() {
        public Boolean apply(final Receta receta) {
          String _devolverNombre = receta.devolverNombre();
          return Boolean.valueOf(_devolverNombre.equals(nombre));
        }
      };
      Receta receta = IterableExtensions.<Receta>findFirst(this.misRecetas, _function);
      _xblockexpression = receta;
    }
    return _xblockexpression;
  }
  
  public ElementoDeReceta devolverSubReceta(final String nombreReceta, final String nombreSubreceta) {
    ElementoDeReceta _xblockexpression = null;
    {
      Receta _devolverReceta = this.devolverReceta(nombreReceta);
      List<ElementoDeReceta> _elementosDeReceta = _devolverReceta.getElementosDeReceta();
      final Function1<ElementoDeReceta, Boolean> _function = new Function1<ElementoDeReceta, Boolean>() {
        public Boolean apply(final ElementoDeReceta subReceta) {
          String _nombre = subReceta.getNombre();
          return Boolean.valueOf(_nombre.equals(nombreSubreceta));
        }
      };
      ElementoDeReceta subReceta = IterableExtensions.<ElementoDeReceta>findFirst(_elementosDeReceta, _function);
      boolean _equals = subReceta.equals(null);
      if (_equals) {
        throw new BusinessException("No existe la subreceta en la lista de subrecetas.");
      }
      _xblockexpression = subReceta;
    }
    return _xblockexpression;
  }
  
  public void modificarReceta(final String nombreOriginal, final String nombreNuevo, final int calorias, final String proceso, final String dificultad, final String temporada) {
    Receta nuevaReceta = new Receta();
    Receta _devolverReceta = this.devolverReceta(nombreOriginal);
    nuevaReceta = _devolverReceta;
    final Procedure1<Receta> _function = new Procedure1<Receta>() {
      public void apply(final Receta it) {
        it.setProcesoDePreparacion(proceso);
        it.setCalorias(calorias);
        it.setDificultadDePreparacion(dificultad);
        it.setTemporadaALaQueCorresponde(temporada);
        it.cambiarNombre(nombreNuevo);
      }
    };
    ObjectExtensions.<Receta>operator_doubleArrow(nuevaReceta, _function);
  }
  
  public boolean meConvieneReceta(final Receta receta) {
    return receta.esInadecuadaParaUsuario(this);
  }
  
  public void agregarRecetaFavorita(final String nombre) {
    boolean _contains = this.recetasFavoritas.contains(nombre);
    boolean _not = (!_contains);
    if (_not) {
      this.recetasFavoritas.add(nombre);
    }
  }
  
  public void agregarRecetaFavorita(final Grupo unGrupo, final String nombre) {
    Receta _devolverRecetaDeMiembro = unGrupo.devolverRecetaDeMiembro(nombre);
    String _nombreDeLaReceta = _devolverRecetaDeMiembro.getNombreDeLaReceta();
    this.recetasFavoritas.add(_nombreDeLaReceta);
  }
  
  public void agregarResultadosDeConsultasAFavoritos() {
    this.resultadoDeConsultasAFavoritos = Boolean.valueOf(true);
  }
  
  public void noAgregarResultadosDeConsultasAFavoritos() {
    this.resultadoDeConsultasAFavoritos = Boolean.valueOf(false);
  }
  
  public boolean contenesEstaRecetaEnFavs(final String nombreReceta) {
    return this.recetasFavoritas.contains(nombreReceta);
  }
  
  public void agregarRecetaFavorita(final Receta receta) {
    boolean _contains = this.recetasFavoritas2.contains(receta);
    boolean _not = (!_contains);
    if (_not) {
      this.recetasFavoritas2.add(receta);
    }
  }
  
  public void eliminarRecetaFavorita(final Receta receta) {
    boolean _contains = this.recetasFavoritas2.contains(receta);
    if (_contains) {
      this.recetasFavoritas2.remove(receta);
    }
  }
  
  public boolean contenesEstaRecetaEnFavs(final Receta receta) {
    return this.recetasFavoritas2.contains(receta);
  }
  
  public List<Receta> recetasQuePuedoVer() {
    List<Receta> _xblockexpression = null;
    {
      final List<Receta> recetasQueVeo = new ArrayList<Receta>();
      List<Receta> _recetas = this.recetario.getRecetas();
      final Consumer<Receta> _function = new Consumer<Receta>() {
        public void accept(final Receta receta) {
          recetasQueVeo.add(receta);
        }
      };
      _recetas.forEach(_function);
      final Consumer<Grupo> _function_1 = new Consumer<Grupo>() {
        public void accept(final Grupo grupo) {
          final Iterable<Receta> _function = new Iterable<Receta>() {
            public Iterator<Receta> iterator() {
              Iterable<Receta> _recetasDelGrupoPara = grupo.recetasDelGrupoPara(Usuario.this);
              return _recetasDelGrupoPara.iterator();
            }
          };
          Iterables.<Receta>addAll(recetasQueVeo, _function);
        }
      };
      this.misGrupos.forEach(_function_1);
      final Iterable<Receta> _function_2 = new Iterable<Receta>() {
        public Iterator<Receta> iterator() {
          return Usuario.this.misRecetas.iterator();
        }
      };
      Iterables.<Receta>addAll(recetasQueVeo, _function_2);
      _xblockexpression = recetasQueVeo;
    }
    return _xblockexpression;
  }
  
  public boolean tePuedoSugerirEstaReceta(final Receta receta) {
    boolean _and = false;
    boolean _esInadecuadaParaUsuario = receta.esInadecuadaParaUsuario(this);
    boolean _not = (!_esInadecuadaParaUsuario);
    if (!_not) {
      _and = false;
    } else {
      boolean _noMeGustaEstaReceta = this.noMeGustaEstaReceta(receta);
      boolean _not_1 = (!_noMeGustaEstaReceta);
      _and = _not_1;
    }
    return _and;
  }
  
  public boolean noMeGustaEstaReceta(final Receta receta) {
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      public Boolean apply(final String ingrediente) {
        List<ElementoDeReceta> _elementosDeReceta = receta.getElementosDeReceta();
        final Function1<ElementoDeReceta, Boolean> _function = new Function1<ElementoDeReceta, Boolean>() {
          public Boolean apply(final ElementoDeReceta elem) {
            String _nombre = elem.getNombre();
            return Boolean.valueOf(_nombre.equals(ingrediente));
          }
        };
        return Boolean.valueOf(IterableExtensions.<ElementoDeReceta>exists(_elementosDeReceta, _function));
      }
    };
    return IterableExtensions.<String>exists(this.comidasQueNoMeGustan, _function);
  }
  
  public boolean tieneSobrepeso() {
    double _indiceDeMasaCorporal = this.indiceDeMasaCorporal();
    return (_indiceDeMasaCorporal >= 30);
  }
  
  public boolean tenesEstaCondicion(final Condicion unaCondicion) {
    final Function1<Condicion, Boolean> _function = new Function1<Condicion, Boolean>() {
      public Boolean apply(final Condicion condicion) {
        Class<? extends Condicion> _class = condicion.getClass();
        Class<? extends Condicion> _class_1 = unaCondicion.getClass();
        return Boolean.valueOf(_class.equals(_class_1));
      }
    };
    return IterableExtensions.<Condicion>exists(this.condicionesPreexistentes, _function);
  }
  
  public List<Receta> busquedaFiltrada() {
    List<Receta> _xblockexpression = null;
    {
      List<Receta> recetasFiltradas = this.recetasQuePuedoVer();
      boolean _isEmpty = this.misBusquedas.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        Iterator<Busqueda> iterBusqueda = this.misBusquedas.iterator();
        while (iterBusqueda.hasNext()) {
          Busqueda _next = iterBusqueda.next();
          List<Receta> _aplicarBusquedaUsuario = _next.aplicarBusquedaUsuario(this, recetasFiltradas);
          recetasFiltradas = _aplicarBusquedaUsuario;
        }
      }
      this.observerConsulta.seRealizoBusqueda(recetasFiltradas);
      this.agregarRecetasBuscadas(recetasFiltradas);
      _xblockexpression = recetasFiltradas;
    }
    return _xblockexpression;
  }
  
  public List<Receta> busquedaFiltrada2(final List<Receta> recetasFiltradas) {
    List<Receta> temporal = recetasFiltradas;
    boolean _isEmpty = this.misBusquedas.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      Iterator<Busqueda> iterBusqueda = this.misBusquedas.iterator();
      while (iterBusqueda.hasNext()) {
        Busqueda _next = iterBusqueda.next();
        List<Receta> _aplicarBusquedaUsuario = _next.aplicarBusquedaUsuario(this, temporal);
        temporal = _aplicarBusquedaUsuario;
      }
      this.observerConsulta.seRealizoBusqueda(temporal);
      this.agregarRecetasBuscadas(recetasFiltradas);
      return temporal;
    }
    return null;
  }
  
  public boolean repitoReceta(final String nombre) {
    final Function1<Receta, Boolean> _function = new Function1<Receta, Boolean>() {
      public Boolean apply(final Receta receta) {
        String _nombreDeLaReceta = receta.getNombreDeLaReceta();
        return Boolean.valueOf(_nombreDeLaReceta.equals(nombre));
      }
    };
    return IterableExtensions.<Receta>exists(this.misRecetas, _function);
  }
  
  public void agregarRecetasBuscadas(final List<Receta> recetas) {
    final Consumer<Receta> _function = new Consumer<Receta>() {
      public void accept(final Receta receta) {
        boolean _contains = Usuario.this.recetasBuscadas.contains(receta);
        boolean _not = (!_contains);
        if (_not) {
          Usuario.this.recetasBuscadas.add(receta);
        }
      }
    };
    recetas.forEach(_function);
  }
  
  public void existeReceta(final Receta unaReceta, final String nombreReceta) {
    boolean _or = false;
    boolean _equals = Objects.equal(nombreReceta, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = Objects.equal(nombreReceta, "");
      _or = _equals_1;
    }
    if (_or) {
      throw new RuntimeException("Nombre de receta vacio");
    } else {
      boolean _existeRecetaConNombre = this.existeRecetaConNombre(nombreReceta);
      if (_existeRecetaConNombre) {
        throw new RuntimeException("Ya existe una receta con ese nombre en su recetario.");
      } else {
        this.agregarRecetaPublicaAMiColeccion(unaReceta, nombreReceta);
      }
    }
  }
  
  public void nombreRecetaVacio(final String nombreReceta) {
    boolean _or = false;
    boolean _equals = Objects.equal(nombreReceta, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = Objects.equal(nombreReceta, "");
      _or = _equals_1;
    }
    if (_or) {
      throw new RuntimeException("Nombre de receta vacio");
    }
  }
  
  public boolean existeRecetaConNombre(final String nombreReceta) {
    final Function1<Receta, Boolean> _function = new Function1<Receta, Boolean>() {
      public Boolean apply(final Receta receta) {
        String _nombreDeLaReceta = receta.getNombreDeLaReceta();
        return Boolean.valueOf(_nombreDeLaReceta.equals(nombreReceta));
      }
    };
    return IterableExtensions.<Receta>exists(this.misRecetas, _function);
  }
  
  public Receta buscarRecetaPorNombre(final String string) {
    List<Receta> _recetasQuePuedoVer = this.recetasQuePuedoVer();
    final Function1<Receta, Boolean> _function = new Function1<Receta, Boolean>() {
      public Boolean apply(final Receta receta) {
        String _nombreDeLaReceta = receta.getNombreDeLaReceta();
        return Boolean.valueOf(_nombreDeLaReceta.equals(string));
      }
    };
    return IterableExtensions.<Receta>findFirst(_recetasQuePuedoVer, _function);
  }
  
  public boolean AgregaroRemoverFavorita(final String nombre) {
    boolean _xblockexpression = false;
    {
      Receta receta = this.buscarRecetaPorNombre(nombre);
      boolean _xifexpression = false;
      boolean _contenesEstaRecetaEnFavs = this.contenesEstaRecetaEnFavs(receta);
      boolean _not = (!_contenesEstaRecetaEnFavs);
      if (_not) {
        _xifexpression = this.recetasFavoritas2.add(receta);
      } else {
        _xifexpression = this.recetasFavoritas2.remove(receta);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Pure
  public String getContrasenia() {
    return this.contrasenia;
  }
  
  public void setContrasenia(final String contrasenia) {
    this.contrasenia = contrasenia;
  }
  
  @Pure
  public Double getPeso() {
    return this.peso;
  }
  
  public void setPeso(final Double peso) {
    this.peso = peso;
  }
  
  @Pure
  public Double getAltura() {
    return this.altura;
  }
  
  public void setAltura(final Double altura) {
    this.altura = altura;
  }
  
  @Pure
  public GregorianCalendar getFechaDeNacimiento() {
    return this.fechaDeNacimiento;
  }
  
  public void setFechaDeNacimiento(final GregorianCalendar fechaDeNacimiento) {
    this.fechaDeNacimiento = fechaDeNacimiento;
  }
  
  @Pure
  public GregorianCalendar getDiaDeHoy() {
    return this.diaDeHoy;
  }
  
  public void setDiaDeHoy(final GregorianCalendar diaDeHoy) {
    this.diaDeHoy = diaDeHoy;
  }
  
  @Pure
  public String getSexo() {
    return this.sexo;
  }
  
  public void setSexo(final String sexo) {
    this.sexo = sexo;
  }
  
  @Pure
  public Rutina getRutina() {
    return this.rutina;
  }
  
  public void setRutina(final Rutina rutina) {
    this.rutina = rutina;
  }
  
  @Pure
  public List<Condicion> getCondicionesPreexistentes() {
    return this.condicionesPreexistentes;
  }
  
  public void setCondicionesPreexistentes(final List<Condicion> condicionesPreexistentes) {
    this.condicionesPreexistentes = condicionesPreexistentes;
  }
  
  @Pure
  public List<String> getComidasQueNoMeGustan() {
    return this.comidasQueNoMeGustan;
  }
  
  public void setComidasQueNoMeGustan(final List<String> comidasQueNoMeGustan) {
    this.comidasQueNoMeGustan = comidasQueNoMeGustan;
  }
  
  @Pure
  public List<Receta> getMisRecetas() {
    return this.misRecetas;
  }
  
  public void setMisRecetas(final List<Receta> misRecetas) {
    this.misRecetas = misRecetas;
  }
  
  @Pure
  public List<Grupo> getMisGrupos() {
    return this.misGrupos;
  }
  
  public void setMisGrupos(final List<Grupo> misGrupos) {
    this.misGrupos = misGrupos;
  }
  
  @Pure
  public List<String> getRecetasFavoritas() {
    return this.recetasFavoritas;
  }
  
  public void setRecetasFavoritas(final List<String> recetasFavoritas) {
    this.recetasFavoritas = recetasFavoritas;
  }
  
  @Pure
  public Busqueda getBusqueda() {
    return this.busqueda;
  }
  
  public void setBusqueda(final Busqueda busqueda) {
    this.busqueda = busqueda;
  }
  
  @Pure
  public String getDireccionCorreo() {
    return this.direccionCorreo;
  }
  
  public void setDireccionCorreo(final String direccionCorreo) {
    this.direccionCorreo = direccionCorreo;
  }
  
  @Pure
  public Boolean getResultadoDeConsultasAFavoritos() {
    return this.resultadoDeConsultasAFavoritos;
  }
  
  public void setResultadoDeConsultasAFavoritos(final Boolean resultadoDeConsultasAFavoritos) {
    this.resultadoDeConsultasAFavoritos = resultadoDeConsultasAFavoritos;
  }
  
  @Pure
  public List<Receta> getRecetasFavoritas2() {
    return this.recetasFavoritas2;
  }
  
  public void setRecetasFavoritas2(final List<Receta> recetasFavoritas2) {
    this.recetasFavoritas2 = recetasFavoritas2;
  }
  
  @Pure
  public ContadorConsultas getObserverConsulta() {
    return this.observerConsulta;
  }
  
  public void setObserverConsulta(final ContadorConsultas observerConsulta) {
    this.observerConsulta = observerConsulta;
  }
  
  @Pure
  public List<Receta> getRecetasBuscadas() {
    return this.recetasBuscadas;
  }
  
  public void setRecetasBuscadas(final List<Receta> recetasBuscadas) {
    this.recetasBuscadas = recetasBuscadas;
  }
}
