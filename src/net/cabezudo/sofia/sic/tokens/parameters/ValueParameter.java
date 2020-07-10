package net.cabezudo.sofia.sic.tokens.parameters;

import java.nio.file.Path;
import net.cabezudo.sofia.sic.elements.SICParameter;
import net.cabezudo.sofia.sic.objects.SICObject;
import net.cabezudo.sofia.sic.tokens.Token;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2020.06.13
 */
public class ValueParameter extends SICParameter {

  public ValueParameter(Token name, Token value) {
    super(name, value);
  }

  @Override
  public boolean isValueParameter() {
    return true;
  }

  @Override
  public SICObject compile(Path basePath) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
