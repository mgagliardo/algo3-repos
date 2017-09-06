package ar.tp.dieta;

import ar.tp.dieta.Email;
import ar.tp.dieta.MessageSender;
import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class StubMailSender implements MessageSender {
  private Map<String, Set<String>> mailsEnviados;
  
  @Override
  public void send(final Email mail) {
    String _from = mail.getFrom();
    String _content = mail.getContent();
    this.simularEnvioMail(_from, _content);
    String _from_1 = mail.getFrom();
    String _plus = ("Simulación envío de mail | From: " + _from_1);
    String _plus_1 = (_plus + " | To: ");
    String _to = mail.getTo();
    String _plus_2 = (_plus_1 + _to);
    String _plus_3 = (_plus_2 + " | Subject : ");
    String _subject = mail.getSubject();
    String _plus_4 = (_plus_3 + _subject);
    String _plus_5 = (_plus_4 + "| Message: ");
    String _content_1 = mail.getContent();
    String _plus_6 = (_plus_5 + _content_1);
    InputOutput.<String>println(_plus_6);
  }
  
  public Set<String> simularEnvioMail(final String from, final String message) {
    Set<String> _xblockexpression = null;
    {
      Set<String> mensajes = this.mailsDe(from);
      mensajes.add(message);
      _xblockexpression = this.mailsEnviados.put(from, mensajes);
    }
    return _xblockexpression;
  }
  
  public Set<String> mailsDe(final String from) {
    Set<String> _xblockexpression = null;
    {
      Set<String> mensajes = this.mailsEnviados.get(from);
      boolean _equals = Objects.equal(mensajes, null);
      if (_equals) {
        HashSet<String> _hashSet = new HashSet<String>();
        mensajes = _hashSet;
      }
      _xblockexpression = mensajes;
    }
    return _xblockexpression;
  }
  
  /**
   * IMPLEMENTACION DE SINGLETON
   */
  private static StubMailSender instance;
  
  private StubMailSender() {
    HashMap<String, Set<String>> _hashMap = new HashMap<String, Set<String>>();
    this.mailsEnviados = _hashMap;
  }
  
  public static StubMailSender getInstance() {
    StubMailSender _xblockexpression = null;
    {
      boolean _equals = Objects.equal(StubMailSender.instance, null);
      if (_equals) {
        StubMailSender _stubMailSender = new StubMailSender();
        StubMailSender.instance = _stubMailSender;
      }
      _xblockexpression = StubMailSender.instance;
    }
    return _xblockexpression;
  }
}
