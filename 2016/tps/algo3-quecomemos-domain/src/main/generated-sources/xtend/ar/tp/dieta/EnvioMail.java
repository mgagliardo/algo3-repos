package ar.tp.dieta;

import ar.tp.dieta.Accion;
import ar.tp.dieta.Email;
import ar.tp.dieta.StubMailSender;
import ar.tp.dieta.Usuario;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import queComemos.entrega3.dominio.Dificultad;
import queComemos.entrega3.repositorio.BusquedaRecetas;

@SuppressWarnings("all")
public class EnvioMail implements Accion {
  private final String[] usuariosQueAplican = { "Juan", "Miguel" };
  
  private final String mailDestino = "test@mail.com";
  
  @Override
  public void execute(final Usuario usuario, final BusquedaRecetas busqueda, final List<String> nombresRecetas) {
    String _nombre = usuario.getNombre();
    boolean _contains = ((List<String>)Conversions.doWrapArray(this.usuariosQueAplican)).contains(_nombre);
    if (_contains) {
      Email mail = new Email();
      String _direccionCorreo = usuario.getDireccionCorreo();
      mail.setFrom(_direccionCorreo);
      String _nombre_1 = usuario.getNombre();
      String _plus = ("Consulta de " + _nombre_1);
      mail.setSubject(_plus);
      mail.setTo(this.mailDestino);
      String _nombre_2 = busqueda.getNombre();
      String _plus_1 = ("Busqueda - nombre: " + _nombre_2);
      String _plus_2 = (_plus_1 + "| Busqueda - dificultad: ");
      Dificultad _dificultad = busqueda.getDificultad();
      String _plus_3 = (_plus_2 + _dificultad);
      String _plus_4 = (_plus_3 + "| Resultados: ");
      int _size = nombresRecetas.size();
      String _plus_5 = (_plus_4 + Integer.valueOf(_size));
      mail.setContent(_plus_5);
      StubMailSender _instance = StubMailSender.getInstance();
      _instance.send(mail);
    }
  }
}
