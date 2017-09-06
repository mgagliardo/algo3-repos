package CopiarReceta;

import ar.tp.dieta.Condimento;
import ar.tp.dieta.CondimentoBuilder;
import ar.tp.dieta.Ingrediente;
import ar.tp.dieta.IngredienteBuilder;
import ar.tp.dieta.Receta;
import ar.tp.dieta.RecetaBuilder;
import ar.tp.dieta.Usuario;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class CopiarRecetaAplicationModel {
  private String nombreCopia;
  
  private Receta receta;
  
  private Usuario usuario;
  
  public CopiarRecetaAplicationModel(final Receta parametroReceta, final Usuario parametroUsuario) {
    this.receta = parametroReceta;
    this.usuario = parametroUsuario;
    String _nombreDeLaReceta = this.receta.getNombreDeLaReceta();
    this.nombreCopia = _nombreDeLaReceta;
  }
  
  public void copiar() {
    String _nombreDeLaReceta = this.receta.getNombreDeLaReceta();
    boolean _repitoReceta = this.usuario.repitoReceta(_nombreDeLaReceta);
    boolean _not = (!_repitoReceta);
    if (_not) {
      RecetaBuilder _recetaBuilder = new RecetaBuilder(this.nombreCopia);
      double _calorias = this.receta.getCalorias();
      RecetaBuilder _calorias_1 = _recetaBuilder.calorias(_calorias);
      String _nombre = this.usuario.getNombre();
      RecetaBuilder _autor = _calorias_1.autor(_nombre);
      String _dificultadDePreparacion = this.receta.getDificultadDePreparacion();
      RecetaBuilder _dificultad = _autor.dificultad(_dificultadDePreparacion);
      String _procesoDePreparacion = this.receta.getProcesoDePreparacion();
      RecetaBuilder _procesoPreparacion = _dificultad.procesoPreparacion(_procesoDePreparacion);
      String _temporadaALaQueCorresponde = this.receta.getTemporadaALaQueCorresponde();
      RecetaBuilder _temporada = _procesoPreparacion.temporada(_temporadaALaQueCorresponde);
      final Receta recetaTemporal = _temporada.build();
      List<Ingrediente> _ingredientes = this.receta.getIngredientes();
      final Consumer<Ingrediente> _function = new Consumer<Ingrediente>() {
        @Override
        public void accept(final Ingrediente ingrediente) {
          List<Ingrediente> _ingredientes = recetaTemporal.getIngredientes();
          String _nombre = ingrediente.getNombre();
          IngredienteBuilder _ingredienteBuilder = new IngredienteBuilder(_nombre);
          int _cantidad = ingrediente.getCantidad();
          IngredienteBuilder _cantidad_1 = _ingredienteBuilder.cantidad(_cantidad);
          Ingrediente _build = _cantidad_1.build();
          _ingredientes.add(_build);
        }
      };
      _ingredientes.forEach(_function);
      List<Condimento> _condimentos = this.receta.getCondimentos();
      final Consumer<Condimento> _function_1 = new Consumer<Condimento>() {
        @Override
        public void accept(final Condimento condimento) {
          List<Condimento> _condimentos = recetaTemporal.getCondimentos();
          String _nombre = condimento.getNombre();
          CondimentoBuilder _condimentoBuilder = new CondimentoBuilder(_nombre);
          int _cantidad = condimento.getCantidad();
          CondimentoBuilder _cantidad_1 = _condimentoBuilder.cantidad(_cantidad);
          Condimento _build = _cantidad_1.build();
          _condimentos.add(_build);
        }
      };
      _condimentos.forEach(_function_1);
      List<Receta> _misRecetas = this.usuario.getMisRecetas();
      _misRecetas.add(recetaTemporal);
    } else {
      throw new UserException("Ya tiene una receta con ese nombre");
    }
  }
  
  @Pure
  public String getNombreCopia() {
    return this.nombreCopia;
  }
  
  public void setNombreCopia(final String nombreCopia) {
    this.nombreCopia = nombreCopia;
  }
  
  @Pure
  public Receta getReceta() {
    return this.receta;
  }
  
  public void setReceta(final Receta receta) {
    this.receta = receta;
  }
  
  @Pure
  public Usuario getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(final Usuario usuario) {
    this.usuario = usuario;
  }
}
