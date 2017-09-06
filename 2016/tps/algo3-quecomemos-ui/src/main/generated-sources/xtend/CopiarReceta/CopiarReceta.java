package CopiarReceta;

import CopiarReceta.CopiarRecetaAplicationModel;
import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class CopiarReceta extends TransactionalDialog<CopiarRecetaAplicationModel> {
  public CopiarReceta(final WindowOwner owner, final Receta receta, final Usuario usuario) {
    super(owner, new CopiarRecetaAplicationModel(receta, usuario));
  }
  
  @Override
  public void createFormPanel(final Panel mainPanel) {
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    this.setTitle("Copiar receta");
    final Panel panelNombre = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    panelNombre.setLayout(_horizontalLayout);
    Label _label = new Label(panelNombre);
    _label.setText("Receta:  ");
    Label _label_1 = new Label(panelNombre);
    _label_1.<Object, ControlBuilder>bindValueToProperty("receta.nombreDeLaReceta");
    final Panel panelNombreCopia = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
    panelNombreCopia.setLayout(_horizontalLayout_1);
    Label _label_2 = new Label(panelNombreCopia);
    _label_2.setText("Nombre de copia:  ");
    TextBox _textBox = new TextBox(panelNombreCopia);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      @Override
      public void apply(final TextBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("nombreCopia");
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      @Override
      public void apply(final Button it) {
        it.setCaption("Copiar");
        final Action _function = new Action() {
          @Override
          public void execute() {
            CopiarRecetaAplicationModel _modelObject = CopiarReceta.this.getModelObject();
            _modelObject.copiar();
            CopiarReceta.super.executeTask();
            CopiarReceta.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
  }
}
