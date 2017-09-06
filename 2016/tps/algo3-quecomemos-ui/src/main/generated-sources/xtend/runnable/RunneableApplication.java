package runnable;

import PantallaLogin.PantallaLogin;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

@SuppressWarnings("all")
public class RunneableApplication extends Application {
  public static void main(final String[] args) {
    RunneableApplication _runneableApplication = new RunneableApplication();
    _runneableApplication.start();
  }
  
  @Override
  protected Window<?> createMainWindow() {
    return new PantallaLogin(this);
  }
}
