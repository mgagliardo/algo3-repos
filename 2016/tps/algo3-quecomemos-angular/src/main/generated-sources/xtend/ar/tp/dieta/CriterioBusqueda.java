package ar.tp.dieta;

import ar.tp.dieta.Busqueda;
import ar.tp.dieta.FiltroPorCaloriasMaximas;
import ar.tp.dieta.FiltroPorCaloriasMinimas;
import ar.tp.dieta.FiltroPorDificultad;
import ar.tp.dieta.FiltroPorIngrediente;
import ar.tp.dieta.FiltroPorNombre;
import ar.tp.dieta.FiltroPorTemporada;
import ar.tp.dieta.Receta;
import ar.tp.dieta.RecetaBuilder;
import ar.tp.dieta.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors
@SuppressWarnings("all")
public class CriterioBusqueda {
  private Boolean aplicarFiltro = Boolean.valueOf(false);
  
  private String dificultad;
  
  private String nombre;
  
  private String ingrediente;
  
  private Integer caloriasMinimas;
  
  private Integer caloriasMaximas;
  
  private String temporada;
  
  private Busqueda busquedaFinal = new Busqueda();
  
  public List<String> getDificultades() {
    return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(RecetaBuilder.FACIL, RecetaBuilder.MEDIA, RecetaBuilder.DIFICIL));
  }
  
  public List<String> getTemporadas() {
    return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(RecetaBuilder.INVIERNO, RecetaBuilder.PRIMAVERA, RecetaBuilder.VERANO, RecetaBuilder.OTONIO, RecetaBuilder.TODOELANIO));
  }
  
  public List<Receta> filtrar(final Usuario usuario, final List<Receta> recetas) {
    List<Receta> _xblockexpression = null;
    {
      this.filtrarPorNombre();
      this.filtrarPorDificultad();
      this.filtrarPorIngrediente();
      this.filtrarPorCaloriasMinimas();
      this.filtrarPorCaloriasMaximas();
      this.filtrarPorTemporada();
      List<Receta> _aplicarBusquedaUsuario = this.busquedaFinal.aplicarBusquedaUsuario(usuario, recetas);
      _xblockexpression = this.filtrarPorFiltroUsuario(usuario, _aplicarBusquedaUsuario);
    }
    return _xblockexpression;
  }
  
  public void filtrarPorNombre() {
    boolean _equals = Objects.equal(this.nombre, null);
    boolean _not = (!_equals);
    if (_not) {
      FiltroPorNombre _filtroPorNombre = new FiltroPorNombre(this.nombre);
      this.busquedaFinal.agregarFiltro(_filtroPorNombre);
    }
  }
  
  public void filtrarPorDificultad() {
    boolean _equals = this.dificultad.equals("");
    boolean _not = (!_equals);
    if (_not) {
      FiltroPorDificultad _filtroPorDificultad = new FiltroPorDificultad(this.dificultad);
      this.busquedaFinal.agregarFiltro(_filtroPorDificultad);
    }
  }
  
  public void filtrarPorIngrediente() {
    boolean _equals = Objects.equal(this.ingrediente, null);
    boolean _not = (!_equals);
    if (_not) {
      FiltroPorIngrediente _filtroPorIngrediente = new FiltroPorIngrediente(this.ingrediente);
      this.busquedaFinal.agregarFiltro(_filtroPorIngrediente);
    }
  }
  
  public void filtrarPorTemporada() {
    boolean _equals = this.temporada.equals("");
    boolean _not = (!_equals);
    if (_not) {
      FiltroPorTemporada _filtroPorTemporada = new FiltroPorTemporada(this.temporada);
      this.busquedaFinal.agregarFiltro(_filtroPorTemporada);
    }
  }
  
  public void filtrarPorCaloriasMinimas() {
    boolean _equals = Objects.equal(this.caloriasMinimas, null);
    boolean _not = (!_equals);
    if (_not) {
      FiltroPorCaloriasMinimas _filtroPorCaloriasMinimas = new FiltroPorCaloriasMinimas((this.caloriasMinimas).intValue());
      this.busquedaFinal.agregarFiltro(_filtroPorCaloriasMinimas);
    }
  }
  
  public void filtrarPorCaloriasMaximas() {
    boolean _equals = Objects.equal(this.caloriasMaximas, null);
    boolean _not = (!_equals);
    if (_not) {
      FiltroPorCaloriasMaximas _filtroPorCaloriasMaximas = new FiltroPorCaloriasMaximas((this.caloriasMaximas).intValue());
      this.busquedaFinal.agregarFiltro(_filtroPorCaloriasMaximas);
    }
  }
  
  public List<Receta> filtrarPorFiltroUsuario(final Usuario usuario, final List<Receta> recetas) {
    List<Receta> temporal = recetas;
    if ((this.aplicarFiltro).booleanValue()) {
      List<Receta> _busquedaFiltrada2 = usuario.busquedaFiltrada2(recetas);
      temporal = _busquedaFiltrada2;
    }
    return temporal;
  }
  
  @Pure
  public Boolean getAplicarFiltro() {
    return this.aplicarFiltro;
  }
  
  public void setAplicarFiltro(final Boolean aplicarFiltro) {
    this.aplicarFiltro = aplicarFiltro;
  }
  
  @Pure
  public String getDificultad() {
    return this.dificultad;
  }
  
  public void setDificultad(final String dificultad) {
    this.dificultad = dificultad;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public String getIngrediente() {
    return this.ingrediente;
  }
  
  public void setIngrediente(final String ingrediente) {
    this.ingrediente = ingrediente;
  }
  
  @Pure
  public Integer getCaloriasMinimas() {
    return this.caloriasMinimas;
  }
  
  public void setCaloriasMinimas(final Integer caloriasMinimas) {
    this.caloriasMinimas = caloriasMinimas;
  }
  
  @Pure
  public Integer getCaloriasMaximas() {
    return this.caloriasMaximas;
  }
  
  public void setCaloriasMaximas(final Integer caloriasMaximas) {
    this.caloriasMaximas = caloriasMaximas;
  }
  
  @Pure
  public String getTemporada() {
    return this.temporada;
  }
  
  public void setTemporada(final String temporada) {
    this.temporada = temporada;
  }
  
  @Pure
  public Busqueda getBusquedaFinal() {
    return this.busquedaFinal;
  }
  
  public void setBusquedaFinal(final Busqueda busquedaFinal) {
    this.busquedaFinal = busquedaFinal;
  }
}
