package ar.tp.dieta;

import ar.tp.dieta.Email;

@SuppressWarnings("all")
public interface MessageSender {
  public abstract void send(final Email mail);
}
