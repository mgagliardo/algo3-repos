package detalleReceta;

import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import detalleReceta.DetalleRecetaAplicationModel;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class DetalleReceta extends TransactionalDialog<DetalleRecetaAplicationModel> {
  public DetalleReceta(final WindowOwner owner, final Receta receta, final Usuario usuario) {
    super(owner, new DetalleRecetaAplicationModel(receta, usuario));
  }
  
  @Override
  public void createFormPanel(final Panel mainPanel) {
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    this.setTitle("Consulta de recetas");
    final Panel panelNombreReceta = new Panel(mainPanel);
    final Panel panelSuperior = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    panelSuperior.setLayout(_horizontalLayout);
    final Panel panelInfo = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    panelInfo.setLayout(_columnLayout);
    final Panel panelMedio = new Panel(mainPanel);
    ColumnLayout _columnLayout_1 = new ColumnLayout(2);
    panelMedio.setLayout(_columnLayout_1);
    final Panel panelIzquierdo = new Panel(panelMedio);
    final Panel panelDerecho = new Panel(panelMedio);
    final Panel panelProceso = new Panel(mainPanel);
    Label _label = new Label(panelNombreReceta);
    _label.<Object, ControlBuilder>bindValueToProperty("receta.nombreDeLaReceta");
    Label _label_1 = new Label(panelSuperior);
    _label_1.<Object, ControlBuilder>bindValueToProperty("receta.calorias");
    Label _label_2 = new Label(panelSuperior);
    _label_2.setText("calorias  ---- creado por");
    Label _label_3 = new Label(panelSuperior);
    _label_3.<Object, ControlBuilder>bindValueToProperty("receta.autor");
    Label _label_4 = new Label(panelInfo);
    _label_4.setText("Dificultad");
    Label _label_5 = new Label(panelInfo);
    _label_5.setText("Temporada");
    Label _label_6 = new Label(panelInfo);
    _label_6.<Object, ControlBuilder>bindValueToProperty("receta.dificultadDePreparacion");
    Label _label_7 = new Label(panelInfo);
    _label_7.<Object, ControlBuilder>bindValueToProperty("receta.temporadaALaQueCorresponde");
    Label _label_8 = new Label(panelInfo);
    _label_8.setText("Ingredientes");
    Label _label_9 = new Label(panelInfo);
    _label_9.setText("Condimentos");
    this.grillaIngredientes(panelIzquierdo);
    List<Object> _list = new List<Object>(panelDerecho);
    _list.bindItemsToProperty("receta.condimentos");
    Label _label_10 = new Label(panelDerecho);
    _label_10.setText("Condiciones Preexistentes");
    List<Object> _list_1 = new List<Object>(panelDerecho);
    _list_1.bindItemsToProperty("receta.condicionesPreexistentes");
    final Panel panelFavo = new Panel(panelIzquierdo);
    HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
    panelFavo.setLayout(_horizontalLayout_1);
    Label _label_11 = new Label(panelFavo);
    _label_11.setText("Favorita");
    CheckBox _checkBox = new CheckBox(panelFavo);
    final Procedure1<CheckBox> _function = new Procedure1<CheckBox>() {
      @Override
      public void apply(final CheckBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("favorita");
        it.<ControlBuilder>bindEnabledToProperty("editable");
      }
    };
    ObjectExtensions.<CheckBox>operator_doubleArrow(_checkBox, _function);
    Label _label_12 = new Label(panelProceso);
    _label_12.setText("Proceso de preparacion");
    Label _label_13 = new Label(panelProceso);
    _label_13.<Object, ControlBuilder>bindValueToProperty("receta.procesoDePreparacion");
    Button _button = new Button(panelProceso);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      @Override
      public void apply(final Button it) {
        it.setCaption("Volver");
        final Action _function = new Action() {
          @Override
          public void execute() {
            DetalleReceta.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
    super.executeTask();
  }
  
  public Column<Receta> grillaIngredientes(final Panel panelMedio) {
    Column<Receta> _xblockexpression = null;
    {
      Table<Receta> _table = new Table<Receta>(panelMedio, Receta.class);
      final Procedure1<Table<Receta>> _function = new Procedure1<Table<Receta>>() {
        @Override
        public void apply(final Table<Receta> it) {
          it.setWidth(400);
          it.setHeight(1000);
          it.bindItemsToProperty("receta.ingredientes");
        }
      };
      final Table<Receta> grilla = ObjectExtensions.<Table<Receta>>operator_doubleArrow(_table, _function);
      Column<Receta> _column = new Column<Receta>(grilla);
      final Procedure1<Column<Receta>> _function_1 = new Procedure1<Column<Receta>>() {
        @Override
        public void apply(final Column<Receta> it) {
          it.setTitle("Ingrediente");
          it.bindContentsToProperty("nombre");
        }
      };
      ObjectExtensions.<Column<Receta>>operator_doubleArrow(_column, _function_1);
      Column<Receta> _column_1 = new Column<Receta>(grilla);
      final Procedure1<Column<Receta>> _function_2 = new Procedure1<Column<Receta>>() {
        @Override
        public void apply(final Column<Receta> it) {
          it.setTitle("Cantidad");
          it.bindContentsToProperty("cantidad");
        }
      };
      _xblockexpression = ObjectExtensions.<Column<Receta>>operator_doubleArrow(_column_1, _function_2);
    }
    return _xblockexpression;
  }
}
