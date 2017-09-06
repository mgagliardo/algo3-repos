package ar.tp.dieta;

import ar.tp.dieta.Condicion;
import ar.tp.dieta.CondicionCeliaco;
import ar.tp.dieta.CondicionDiabetes;
import ar.tp.dieta.CondicionHipertension;
import ar.tp.dieta.CondicionVegano;
import ar.tp.dieta.Condimento;
import ar.tp.dieta.ElementoDeReceta;
import ar.tp.dieta.Grupo;
import ar.tp.dieta.Ingrediente;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class Receta extends ElementoDeReceta implements Cloneable {
  private List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
  
  private List<Condimento> condimentos = new ArrayList<Condimento>();
  
  private String autor;
  
  private String nombreDeLaReceta;
  
  private double calorias;
  
  private String procesoDePreparacion;
  
  private String dificultadDePreparacion;
  
  private String temporadaALaQueCorresponde;
  
  private int tiempoPreparacion;
  
  private int añoDeCreacion;
  
  public void agregarIngrediente(final Ingrediente unIngrediente) {
    List<ElementoDeReceta> _elementosDeReceta = this.getElementosDeReceta();
    _elementosDeReceta.add(unIngrediente);
    this.ingredientes.add(unIngrediente);
  }
  
  public void agregarCondimento(final Condimento unCondimento) {
    List<ElementoDeReceta> _elementosDeReceta = this.getElementosDeReceta();
    _elementosDeReceta.add(unCondimento);
    this.condimentos.add(unCondimento);
  }
  
  public void removerIngrediente(final Ingrediente unIngrediente) {
    List<ElementoDeReceta> _elementosDeReceta = this.getElementosDeReceta();
    _elementosDeReceta.remove(unIngrediente);
    this.ingredientes.remove(unIngrediente);
  }
  
  public void removerCondimento(final Condimento unCondimento) {
    List<ElementoDeReceta> _elementosDeReceta = this.getElementosDeReceta();
    _elementosDeReceta.remove(unCondimento);
    this.condimentos.remove(unCondimento);
  }
  
  public boolean validar() {
    boolean _and = false;
    boolean _validarCalorias = this.validarCalorias();
    if (!_validarCalorias) {
      _and = false;
    } else {
      List<ElementoDeReceta> _elementosDeReceta = this.getElementosDeReceta();
      boolean _isEmpty = _elementosDeReceta.isEmpty();
      boolean _not = (!_isEmpty);
      _and = _not;
    }
    return _and;
  }
  
  public boolean validarCalorias() {
    boolean _and = false;
    double _calorias = this.getCalorias();
    boolean _greaterEqualsThan = (10 >= _calorias);
    if (!_greaterEqualsThan) {
      _and = false;
    } else {
      double _calorias_1 = this.getCalorias();
      boolean _lessEqualsThan = (_calorias_1 <= 5000);
      _and = _lessEqualsThan;
    }
    return _and;
  }
  
  public boolean inadecuadaParaCondiciones(final Condicion unaCondicion) {
    List<ElementoDeReceta> _elementosDeReceta = this.getElementosDeReceta();
    final Function1<ElementoDeReceta, Boolean> _function = new Function1<ElementoDeReceta, Boolean>() {
      @Override
      public Boolean apply(final ElementoDeReceta elemento) {
        return Boolean.valueOf(elemento.soyInadecuadoParaCondicion(unaCondicion));
      }
    };
    return IterableExtensions.<ElementoDeReceta>exists(_elementosDeReceta, _function);
  }
  
  public boolean esInadecuadaParaUsuario(final Usuario unUsuario) {
    List<Condicion> _condicionesPreexistentes = unUsuario.getCondicionesPreexistentes();
    final Function1<Condicion, Boolean> _function = new Function1<Condicion, Boolean>() {
      @Override
      public Boolean apply(final Condicion condicion) {
        return Boolean.valueOf(Receta.this.soyInadecuadoParaCondicion(condicion));
      }
    };
    return IterableExtensions.<Condicion>exists(_condicionesPreexistentes, _function);
  }
  
  public boolean agregarSubreceta(final Receta unaSubreceta) {
    List<ElementoDeReceta> _elementosDeReceta = this.getElementosDeReceta();
    return _elementosDeReceta.add(unaSubreceta);
  }
  
  public void cambiarNombre(final String nombre) {
    this.setNombreDeLaReceta(nombre);
  }
  
  public String devolverNombre() {
    return this.getNombreDeLaReceta();
  }
  
  @Override
  public boolean soyInadecuadoParaCondicion(final Condicion unaCondicion) {
    List<ElementoDeReceta> _elementosDeReceta = this.getElementosDeReceta();
    final Function1<ElementoDeReceta, Boolean> _function = new Function1<ElementoDeReceta, Boolean>() {
      @Override
      public Boolean apply(final ElementoDeReceta elemento) {
        return Boolean.valueOf(elemento.soyInadecuadoParaCondicion(unaCondicion));
      }
    };
    boolean _exists = IterableExtensions.<ElementoDeReceta>exists(_elementosDeReceta, _function);
    return (!_exists);
  }
  
  public boolean exesoDeCalorias() {
    return (this.calorias > 500);
  }
  
  public boolean esInadecuadaParaGrupo(final Grupo grupo) {
    List<Usuario> _miembros = grupo.getMiembros();
    final Function1<Usuario, Boolean> _function = new Function1<Usuario, Boolean>() {
      @Override
      public Boolean apply(final Usuario miembro) {
        return Boolean.valueOf(Receta.this.esInadecuadaParaUsuario(miembro));
      }
    };
    return IterableExtensions.<Usuario>exists(_miembros, _function);
  }
  
  public boolean contieneIngrediente(final String nombreIngrediente) {
    List<ElementoDeReceta> _elementosDeReceta = this.getElementosDeReceta();
    final Function1<ElementoDeReceta, Boolean> _function = new Function1<ElementoDeReceta, Boolean>() {
      @Override
      public Boolean apply(final ElementoDeReceta elem) {
        String _nombre = elem.getNombre();
        return Boolean.valueOf(_nombre.equals(nombreIngrediente));
      }
    };
    return IterableExtensions.<ElementoDeReceta>exists(_elementosDeReceta, _function);
  }
  
  public boolean contieneAlguno(final List<String> nombresIngredientes) {
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String nombreIngrediente) {
        return Boolean.valueOf(Receta.this.contieneIngrediente(nombreIngrediente));
      }
    };
    return IterableExtensions.<String>exists(nombresIngredientes, _function);
  }
  
  public String ingredientesAString() {
    String _xblockexpression = null;
    {
      List<String> stringsList = new ArrayList<String>();
      List<ElementoDeReceta> _elementosDeReceta = this.getElementosDeReceta();
      for (final ElementoDeReceta elemento : _elementosDeReceta) {
        String _nombre = elemento.getNombre();
        stringsList.add(_nombre);
      }
      _xblockexpression = stringsList.toString();
    }
    return _xblockexpression;
  }
  
  public boolean tuNombreEsEste(final String nombre) {
    return this.nombreDeLaReceta.equals(nombre);
  }
  
  public void soyAptaParaVeganos(final List<String> condicionesPreexistentes) {
    CondicionVegano _condicionVegano = new CondicionVegano();
    boolean _soyInadecuadoParaCondicion = this.soyInadecuadoParaCondicion(_condicionVegano);
    if (_soyInadecuadoParaCondicion) {
      condicionesPreexistentes.add("Vegano");
    }
  }
  
  public void soyAptaParaDiabeticos(final List<String> condicionesPreexistentes) {
    CondicionDiabetes _condicionDiabetes = new CondicionDiabetes();
    boolean _soyInadecuadoParaCondicion = this.soyInadecuadoParaCondicion(_condicionDiabetes);
    if (_soyInadecuadoParaCondicion) {
      condicionesPreexistentes.add("Diabetico");
    }
  }
  
  public void soyAptaParaHipertensos(final List<String> condicionesPreexistentes) {
    CondicionHipertension _condicionHipertension = new CondicionHipertension();
    boolean _soyInadecuadoParaCondicion = this.soyInadecuadoParaCondicion(_condicionHipertension);
    if (_soyInadecuadoParaCondicion) {
      condicionesPreexistentes.add("Hipertenso");
    }
  }
  
  public void soyAptaParaCeliacos(final List<String> condicionesPreexistentes) {
    CondicionCeliaco _condicionCeliaco = new CondicionCeliaco();
    boolean _soyInadecuadoParaCondicion = this.soyInadecuadoParaCondicion(_condicionCeliaco);
    if (_soyInadecuadoParaCondicion) {
      condicionesPreexistentes.add("Celiaco");
    }
  }
  
  public ArrayList<String> getCondicionesPreexistentes() {
    ArrayList<String> _xblockexpression = null;
    {
      ArrayList<String> condiciones = new ArrayList<String>();
      this.soyAptaParaVeganos(condiciones);
      this.soyAptaParaHipertensos(condiciones);
      this.soyAptaParaCeliacos(condiciones);
      this.soyAptaParaDiabeticos(condiciones);
      _xblockexpression = condiciones;
    }
    return _xblockexpression;
  }
  
  public Receta devolverme() {
    return this;
  }
  
  public List<ElementoDeReceta> getElementosDeReceta() {
    ArrayList<ElementoDeReceta> _xblockexpression = null;
    {
      ArrayList<ElementoDeReceta> elementosDeReceta = new ArrayList<ElementoDeReceta>();
      elementosDeReceta.addAll(this.ingredientes);
      elementosDeReceta.addAll(this.condimentos);
      _xblockexpression = elementosDeReceta;
    }
    return _xblockexpression;
  }
  
  @Pure
  public List<Ingrediente> getIngredientes() {
    return this.ingredientes;
  }
  
  public void setIngredientes(final List<Ingrediente> ingredientes) {
    this.ingredientes = ingredientes;
  }
  
  @Pure
  public List<Condimento> getCondimentos() {
    return this.condimentos;
  }
  
  public void setCondimentos(final List<Condimento> condimentos) {
    this.condimentos = condimentos;
  }
  
  @Pure
  public String getAutor() {
    return this.autor;
  }
  
  public void setAutor(final String autor) {
    this.autor = autor;
  }
  
  @Pure
  public String getNombreDeLaReceta() {
    return this.nombreDeLaReceta;
  }
  
  public void setNombreDeLaReceta(final String nombreDeLaReceta) {
    this.nombreDeLaReceta = nombreDeLaReceta;
  }
  
  @Pure
  public double getCalorias() {
    return this.calorias;
  }
  
  public void setCalorias(final double calorias) {
    this.calorias = calorias;
  }
  
  @Pure
  public String getProcesoDePreparacion() {
    return this.procesoDePreparacion;
  }
  
  public void setProcesoDePreparacion(final String procesoDePreparacion) {
    this.procesoDePreparacion = procesoDePreparacion;
  }
  
  @Pure
  public String getDificultadDePreparacion() {
    return this.dificultadDePreparacion;
  }
  
  public void setDificultadDePreparacion(final String dificultadDePreparacion) {
    this.dificultadDePreparacion = dificultadDePreparacion;
  }
  
  @Pure
  public String getTemporadaALaQueCorresponde() {
    return this.temporadaALaQueCorresponde;
  }
  
  public void setTemporadaALaQueCorresponde(final String temporadaALaQueCorresponde) {
    this.temporadaALaQueCorresponde = temporadaALaQueCorresponde;
  }
  
  @Pure
  public int getTiempoPreparacion() {
    return this.tiempoPreparacion;
  }
  
  public void setTiempoPreparacion(final int tiempoPreparacion) {
    this.tiempoPreparacion = tiempoPreparacion;
  }
  
  @Pure
  public int getAñoDeCreacion() {
    return this.añoDeCreacion;
  }
  
  public void setAñoDeCreacion(final int añoDeCreacion) {
    this.añoDeCreacion = añoDeCreacion;
  }
}
