package ar.tp.dieta;

import ar.tp.dieta.ContadorRecetas;
import ar.tp.dieta.Receta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class ContadorConsultas {
  public Map<Receta, Integer> recetasMasConsultadas = new HashMap<Receta, Integer>();
  
  public String nombreMaximo;
  
  private List<Receta> recetasAux = new ArrayList<Receta>();
  
  private List<Receta> recetasFinales = new ArrayList<Receta>();
  
  public void seRealizoBusqueda(final List<Receta> recetas) {
    final Consumer<Receta> _function = new Consumer<Receta>() {
      @Override
      public void accept(final Receta receta) {
        boolean _containsKey = ContadorConsultas.this.recetasMasConsultadas.containsKey(receta);
        boolean _not = (!_containsKey);
        if (_not) {
          ContadorConsultas.this.recetasMasConsultadas.put(receta, Integer.valueOf(1));
          ContadorConsultas.this.recetasAux.add(receta);
        } else {
          Integer _get = ContadorConsultas.this.recetasMasConsultadas.get(receta);
          int _plus = ((_get).intValue() + 1);
          ContadorConsultas.this.recetasMasConsultadas.put(receta, Integer.valueOf(_plus));
        }
      }
    };
    recetas.forEach(_function);
  }
  
  public ArrayList<Receta> ordenar() {
    final ArrayList<Receta> recetasTemporales = new ArrayList<Receta>();
    final ArrayList<ContadorRecetas> contadores = new ArrayList<ContadorRecetas>();
    final Consumer<Receta> _function = new Consumer<Receta>() {
      @Override
      public void accept(final Receta rec) {
        ContadorRecetas _contadorRecetas = new ContadorRecetas();
        final Procedure1<ContadorRecetas> _function = new Procedure1<ContadorRecetas>() {
          @Override
          public void apply(final ContadorRecetas it) {
            it.setReceta(rec);
            Integer _get = ContadorConsultas.this.recetasMasConsultadas.get(rec);
            it.setCantidad((_get).intValue());
          }
        };
        ContadorRecetas _doubleArrow = ObjectExtensions.<ContadorRecetas>operator_doubleArrow(_contadorRecetas, _function);
        contadores.add(_doubleArrow);
      }
    };
    this.recetasAux.forEach(_function);
    final Function1<ContadorRecetas, Integer> _function_1 = new Function1<ContadorRecetas, Integer>() {
      @Override
      public Integer apply(final ContadorRecetas it) {
        return Integer.valueOf(it.getCantidad());
      }
    };
    IterableExtensions.<ContadorRecetas, Integer>sortBy(contadores, _function_1);
    final Consumer<ContadorRecetas> _function_2 = new Consumer<ContadorRecetas>() {
      @Override
      public void accept(final ContadorRecetas contador) {
        Receta _receta = contador.getReceta();
        recetasTemporales.add(_receta);
      }
    };
    contadores.forEach(_function_2);
    return recetasTemporales;
  }
  
  public List<Receta> getRecetasFinales() {
    ArrayList<Receta> _ordenar = this.ordenar();
    this.recetasFinales = _ordenar;
    return this.recetasFinales;
  }
  
  @Pure
  public Map<Receta, Integer> getRecetasMasConsultadas() {
    return this.recetasMasConsultadas;
  }
  
  public void setRecetasMasConsultadas(final Map<Receta, Integer> recetasMasConsultadas) {
    this.recetasMasConsultadas = recetasMasConsultadas;
  }
  
  @Pure
  public String getNombreMaximo() {
    return this.nombreMaximo;
  }
  
  public void setNombreMaximo(final String nombreMaximo) {
    this.nombreMaximo = nombreMaximo;
  }
  
  @Pure
  public List<Receta> getRecetasAux() {
    return this.recetasAux;
  }
  
  public void setRecetasAux(final List<Receta> recetasAux) {
    this.recetasAux = recetasAux;
  }
  
  public void setRecetasFinales(final List<Receta> recetasFinales) {
    this.recetasFinales = recetasFinales;
  }
}
