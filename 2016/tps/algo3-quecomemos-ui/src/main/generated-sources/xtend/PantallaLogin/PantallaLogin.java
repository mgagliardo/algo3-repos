package PantallaLogin;

import PantallaLogin.PantallaLoginAplicationModel;
import ar.tp.dieta.Usuario;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import pantallaPrincipal.PantallaPrincipal;

@SuppressWarnings("all")
public class PantallaLogin extends SimpleWindow<PantallaLoginAplicationModel> {
  public PantallaLogin(final WindowOwner parent) {
    super(parent, new PantallaLoginAplicationModel());
  }
  
  @Override
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Login");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Label _label = new Label(mainPanel);
    _label.setText("Usuario");
    TextBox _textBox = new TextBox(mainPanel);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      @Override
      public void apply(final TextBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("nombre");
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    Label _label_1 = new Label(mainPanel);
    _label_1.setText("Contraseña");
    TextBox _textBox_1 = new TextBox(mainPanel);
    final Procedure1<TextBox> _function_1 = new Procedure1<TextBox>() {
      @Override
      public void apply(final TextBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("contraseña");
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_1, _function_1);
    Panel _panel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    final Panel panelBotonera = _panel.setLayout(_horizontalLayout);
    Button _button = new Button(panelBotonera);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      @Override
      public void apply(final Button it) {
        it.setCaption("OK");
        final Action _function = new Action() {
          @Override
          public void execute() {
            PantallaLoginAplicationModel _modelObject = PantallaLogin.this.getModelObject();
            Usuario _validar = _modelObject.validar();
            PantallaPrincipal _pantallaPrincipal = new PantallaPrincipal(PantallaLogin.this, _validar);
            _pantallaPrincipal.open();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_2);
    Button _button_1 = new Button(panelBotonera);
    final Procedure1<Button> _function_3 = new Procedure1<Button>() {
      @Override
      public void apply(final Button it) {
        it.setCaption("Cancelar");
        final Action _function = new Action() {
          @Override
          public void execute() {
            PantallaLogin.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_3);
  }
  
  @Override
  protected void addActions(final Panel actionsPanel) {
  }
}
