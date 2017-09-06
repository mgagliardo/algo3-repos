package pantallaPrincipal;

import org.uqbar.arena.widgets.TextFilter;
import org.uqbar.arena.widgets.TextInputEvent;

@SuppressWarnings("all")
public class LetrasFilter implements TextFilter {
  @Override
  public boolean accept(final TextInputEvent event) {
    String _potentialTextResult = event.getPotentialTextResult();
    return _potentialTextResult.matches("[a-zA-Z ]*");
  }
}
