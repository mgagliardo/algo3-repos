package pantallaPrincipal;

import CopiarReceta.CopiarReceta;
import ar.tp.dieta.ContadorConsultas;
import ar.tp.dieta.CriterioBusqueda;
import ar.tp.dieta.Receta;
import ar.tp.dieta.RecetarioPublico;
import ar.tp.dieta.Usuario;
import detalleReceta.DetalleReceta;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections15.Transformer;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.widgets.tables.labelprovider.BackgroundProvider;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import pantallaPrincipal.LetrasFilter;
import pantallaPrincipal.NumeroFilter;
import pantallaPrincipal.PantallaPrincipalAplicationModel;

@SuppressWarnings("all")
public class PantallaPrincipal extends TransactionalDialog<PantallaPrincipalAplicationModel> {
  public PantallaPrincipal(final WindowOwner owner, final Usuario usuario) {
    super(owner, new PantallaPrincipalAplicationModel(usuario));
  }
  
  @Override
  protected void createFormPanel(final Panel mainPanel) {
    final NotNullObservable elementSelected = new NotNullObservable("recetaSeleccionada");
    this.setTitle("Consulta de recetas");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    final Panel PanelConsulta = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    PanelConsulta.setLayout(_columnLayout);
    final Panel PanelIzq = new Panel(PanelConsulta);
    final Panel PanelDerecho = new Panel(PanelConsulta);
    Label _label = new Label(PanelIzq);
    _label.setText("Nombre");
    TextBox _textBox = new TextBox(PanelIzq);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      @Override
      public void apply(final TextBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("busquedaUsuario.nombre");
        LetrasFilter _letrasFilter = new LetrasFilter();
        it.withFilter(_letrasFilter);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    Label _label_1 = new Label(PanelIzq);
    _label_1.setText("Dificultad");
    Selector<String> _selector = new Selector<String>(PanelIzq);
    final Procedure1<Selector<String>> _function_1 = new Procedure1<Selector<String>>() {
      @Override
      public void apply(final Selector<String> it) {
        it.bindItemsToProperty("busquedaUsuario.dificultades");
        it.<Object, ControlBuilder>bindValueToProperty("busquedaUsuario.dificultad");
      }
    };
    ObjectExtensions.<Selector<String>>operator_doubleArrow(_selector, _function_1);
    Label _label_2 = new Label(PanelIzq);
    _label_2.setText("Que contenga ingrediente");
    TextBox _textBox_1 = new TextBox(PanelIzq);
    final Procedure1<TextBox> _function_2 = new Procedure1<TextBox>() {
      @Override
      public void apply(final TextBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("busquedaUsuario.ingrediente");
        LetrasFilter _letrasFilter = new LetrasFilter();
        it.withFilter(_letrasFilter);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_1, _function_2);
    Label _label_3 = new Label(PanelDerecho);
    _label_3.setText("Calorias");
    final Panel PanelCalorias = new Panel(PanelDerecho);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    PanelCalorias.setLayout(_horizontalLayout);
    Label _label_4 = new Label(PanelCalorias);
    _label_4.setText("De ");
    TextBox _textBox_2 = new TextBox(PanelCalorias);
    final Procedure1<TextBox> _function_3 = new Procedure1<TextBox>() {
      @Override
      public void apply(final TextBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("busquedaUsuario.caloriasMinimas");
        NumeroFilter _numeroFilter = new NumeroFilter();
        it.withFilter(_numeroFilter);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_2, _function_3);
    Label _label_5 = new Label(PanelCalorias);
    _label_5.setText(" a ");
    TextBox _textBox_3 = new TextBox(PanelCalorias);
    final Procedure1<TextBox> _function_4 = new Procedure1<TextBox>() {
      @Override
      public void apply(final TextBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("busquedaUsuario.caloriasMaximas");
        NumeroFilter _numeroFilter = new NumeroFilter();
        it.withFilter(_numeroFilter);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_3, _function_4);
    Label _label_6 = new Label(PanelDerecho);
    _label_6.setText("Temporada");
    Selector<String> _selector_1 = new Selector<String>(PanelDerecho);
    final Procedure1<Selector<String>> _function_5 = new Procedure1<Selector<String>>() {
      @Override
      public void apply(final Selector<String> it) {
        it.bindItemsToProperty("busquedaUsuario.temporadas");
        it.<Object, ControlBuilder>bindValueToProperty("busquedaUsuario.temporada");
      }
    };
    ObjectExtensions.<Selector<String>>operator_doubleArrow(_selector_1, _function_5);
    final Panel PanelFiltroUsuario = new Panel(PanelDerecho);
    HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
    PanelFiltroUsuario.setLayout(_horizontalLayout_1);
    CheckBox _checkBox = new CheckBox(PanelFiltroUsuario);
    final Procedure1<CheckBox> _function_6 = new Procedure1<CheckBox>() {
      @Override
      public void apply(final CheckBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("busquedaUsuario.aplicarFiltro");
      }
    };
    ObjectExtensions.<CheckBox>operator_doubleArrow(_checkBox, _function_6);
    Label _label_7 = new Label(PanelFiltroUsuario);
    _label_7.setText("Aplicar filtros del perfil de usuario");
    final Panel PanelBotoneraBusqueda = new Panel(PanelDerecho);
    HorizontalLayout _horizontalLayout_2 = new HorizontalLayout();
    PanelBotoneraBusqueda.setLayout(_horizontalLayout_2);
    Button _button = new Button(PanelBotoneraBusqueda);
    final Procedure1<Button> _function_7 = new Procedure1<Button>() {
      @Override
      public void apply(final Button it) {
        it.setCaption("Buscar");
        final Action _function = new Action() {
          @Override
          public void execute() {
            PantallaPrincipalAplicationModel _modelObject = PantallaPrincipal.this.getModelObject();
            _modelObject.limpiarRecetas();
            PantallaPrincipalAplicationModel _modelObject_1 = PantallaPrincipal.this.getModelObject();
            _modelObject_1.filtrar();
            PantallaPrincipalAplicationModel _modelObject_2 = PantallaPrincipal.this.getModelObject();
            CriterioBusqueda _criterioBusqueda = new CriterioBusqueda();
            _modelObject_2.setBusquedaUsuario(_criterioBusqueda);
            PantallaPrincipalAplicationModel _modelObject_3 = PantallaPrincipal.this.getModelObject();
            _modelObject_3.setMensaje("Este es el resultado de su consulta");
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_7);
    Button _button_1 = new Button(PanelBotoneraBusqueda);
    final Procedure1<Button> _function_8 = new Procedure1<Button>() {
      @Override
      public void apply(final Button it) {
        it.setCaption("Volver");
        final Action _function = new Action() {
          @Override
          public void execute() {
            PantallaPrincipal.this.close();
            PantallaPrincipal.super.executeTask();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_8);
    Label _label_8 = new Label(mainPanel);
    _label_8.<Object, ControlBuilder>bindValueToProperty("mensaje");
    this.grillaConsulta(mainPanel);
    final Panel PanelBotonera = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout_3 = new HorizontalLayout();
    PanelBotonera.setLayout(_horizontalLayout_3);
    Button _button_2 = new Button(PanelBotonera);
    final Procedure1<Button> _function_9 = new Procedure1<Button>() {
      @Override
      public void apply(final Button it) {
        it.setCaption("Ver");
        final Action _function = new Action() {
          @Override
          public void execute() {
            PantallaPrincipal.this.verReceta();
          }
        };
        it.onClick(_function);
        it.<Object, ControlBuilder>bindEnabled(elementSelected);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_9);
    Button _button_3 = new Button(PanelBotonera);
    final Procedure1<Button> _function_10 = new Procedure1<Button>() {
      @Override
      public void apply(final Button it) {
        it.setCaption("Favorita");
        final Action _function = new Action() {
          @Override
          public void execute() {
            PantallaPrincipalAplicationModel _modelObject = PantallaPrincipal.this.getModelObject();
            _modelObject.agregarORemoverRecetaFavorita();
          }
        };
        it.onClick(_function);
        it.<Object, ControlBuilder>bindEnabled(elementSelected);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_3, _function_10);
    Button _button_4 = new Button(PanelBotonera);
    final Procedure1<Button> _function_11 = new Procedure1<Button>() {
      @Override
      public void apply(final Button it) {
        it.setCaption("Copiar receta");
        final Action _function = new Action() {
          @Override
          public void execute() {
            PantallaPrincipal.this.copiar();
          }
        };
        it.onClick(_function);
        it.<Object, ControlBuilder>bindEnabled(elementSelected);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_4, _function_11);
  }
  
  public Column<Receta> grillaConsulta(final Panel mainPanel) {
    Column<Receta> _xblockexpression = null;
    {
      Table<Receta> _table = new Table<Receta>(mainPanel, Receta.class);
      final Procedure1<Table<Receta>> _function = new Procedure1<Table<Receta>>() {
        @Override
        public void apply(final Table<Receta> it) {
          it.setWidth(400);
          it.setHeight(2000);
          it.bindItemsToProperty("recetas");
          it.<Object, ControlBuilder>bindValueToProperty("recetaSeleccionada");
        }
      };
      final Table<Receta> grilla = ObjectExtensions.<Table<Receta>>operator_doubleArrow(_table, _function);
      Column<Receta> _column = new Column<Receta>(grilla);
      final Procedure1<Column<Receta>> _function_1 = new Procedure1<Column<Receta>>() {
        @Override
        public void apply(final Column<Receta> it) {
          it.setFixedSize(200);
          it.setTitle("Nombre");
          it.bindContentsToProperty("nombreDeLaReceta");
          PantallaPrincipal.this.colorear(it);
        }
      };
      ObjectExtensions.<Column<Receta>>operator_doubleArrow(_column, _function_1);
      Column<Receta> _column_1 = new Column<Receta>(grilla);
      final Procedure1<Column<Receta>> _function_2 = new Procedure1<Column<Receta>>() {
        @Override
        public void apply(final Column<Receta> it) {
          it.setFixedSize(200);
          it.setTitle("Calorias");
          it.bindContentsToProperty("calorias");
          PantallaPrincipal.this.colorear(it);
        }
      };
      ObjectExtensions.<Column<Receta>>operator_doubleArrow(_column_1, _function_2);
      Column<Receta> _column_2 = new Column<Receta>(grilla);
      final Procedure1<Column<Receta>> _function_3 = new Procedure1<Column<Receta>>() {
        @Override
        public void apply(final Column<Receta> it) {
          it.setFixedSize(200);
          it.setTitle("Dificultad");
          it.bindContentsToProperty("dificultadDePreparacion");
          PantallaPrincipal.this.colorear(it);
        }
      };
      ObjectExtensions.<Column<Receta>>operator_doubleArrow(_column_2, _function_3);
      Column<Receta> _column_3 = new Column<Receta>(grilla);
      final Procedure1<Column<Receta>> _function_4 = new Procedure1<Column<Receta>>() {
        @Override
        public void apply(final Column<Receta> it) {
          it.setFixedSize(200);
          it.setTitle("Temporada");
          it.bindContentsToProperty("temporadaALaQueCorresponde");
          PantallaPrincipal.this.colorear(it);
        }
      };
      _xblockexpression = ObjectExtensions.<Column<Receta>>operator_doubleArrow(_column_3, _function_4);
    }
    return _xblockexpression;
  }
  
  public void colorear(final Column<Receta> it) {
    BackgroundProvider<Receta, Color> _bindBackground = it.bindBackground("devolverme");
    final Transformer<Receta, Color> _function = new Transformer<Receta, Color>() {
      @Override
      public Color transform(final Receta recibe) {
        Color _xifexpression = null;
        PantallaPrincipalAplicationModel _modelObject = PantallaPrincipal.this.getModelObject();
        Usuario _usuario = _modelObject.getUsuario();
        List<Receta> _misRecetas = _usuario.getMisRecetas();
        boolean _contains = _misRecetas.contains(recibe);
        if (_contains) {
          _xifexpression = Color.RED;
        } else {
          Color _xifexpression_1 = null;
          PantallaPrincipalAplicationModel _modelObject_1 = PantallaPrincipal.this.getModelObject();
          Usuario _usuario_1 = _modelObject_1.getUsuario();
          RecetarioPublico _recetario = _usuario_1.getRecetario();
          List<Receta> _recetas = _recetario.getRecetas();
          boolean _contains_1 = _recetas.contains(recibe);
          if (_contains_1) {
            _xifexpression_1 = Color.GREEN;
          } else {
            _xifexpression_1 = Color.BLUE;
          }
          _xifexpression = _xifexpression_1;
        }
        return _xifexpression;
      }
    };
    _bindBackground.setTransformer(_function);
  }
  
  public void verReceta() {
    ArrayList<Receta> temporal = new ArrayList<Receta>();
    PantallaPrincipalAplicationModel _modelObject = this.getModelObject();
    Receta _recetaSeleccionada = _modelObject.getRecetaSeleccionada();
    temporal.add(_recetaSeleccionada);
    PantallaPrincipalAplicationModel _modelObject_1 = this.getModelObject();
    Usuario _usuario = _modelObject_1.getUsuario();
    ContadorConsultas _observerConsulta = _usuario.getObserverConsulta();
    _observerConsulta.seRealizoBusqueda(temporal);
    PantallaPrincipalAplicationModel _modelObject_2 = this.getModelObject();
    Usuario _usuario_1 = _modelObject_2.getUsuario();
    _usuario_1.agregarRecetasBuscadas(temporal);
    PantallaPrincipalAplicationModel _modelObject_3 = this.getModelObject();
    Receta _recetaSeleccionada_1 = _modelObject_3.getRecetaSeleccionada();
    PantallaPrincipalAplicationModel _modelObject_4 = this.getModelObject();
    Usuario _usuario_2 = _modelObject_4.getUsuario();
    DetalleReceta _detalleReceta = new DetalleReceta(this, _recetaSeleccionada_1, _usuario_2);
    _detalleReceta.open();
  }
  
  public void copiar() {
    PantallaPrincipalAplicationModel _modelObject = this.getModelObject();
    Receta _recetaSeleccionada = _modelObject.getRecetaSeleccionada();
    PantallaPrincipalAplicationModel _modelObject_1 = this.getModelObject();
    Usuario _usuario = _modelObject_1.getUsuario();
    CopiarReceta _copiarReceta = new CopiarReceta(this, _recetaSeleccionada, _usuario);
    _copiarReceta.open();
  }
}
