package net.cabezudo.sofia.sic.elements;

import java.nio.file.Path;
import net.cabezudo.sofia.sic.objects.SICObject;
import net.cabezudo.sofia.sic.tokens.SICToken;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2020.06.13
 */
public abstract class SICElement {

  private final SICToken token;

  public SICElement(SICToken token) {
    this.token = token;
  }

  public SICToken getToken() {
    return token;
  }

  public abstract String toString(int i);

  public abstract SICObject compile(Path basePath) throws SICCompileTimeException;

  public boolean isFunction() {
    return false;
  }

  public boolean isParameter() {
    return false;
  }
}
