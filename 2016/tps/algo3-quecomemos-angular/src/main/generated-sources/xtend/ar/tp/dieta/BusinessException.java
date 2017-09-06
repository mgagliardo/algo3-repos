package ar.tp.dieta;

@SuppressWarnings("all")
public class BusinessException extends RuntimeException {
  public BusinessException(final String message) {
    super(message);
  }
}
