package net.cabezudo.sofia.sic.objects.values;

import net.cabezudo.sofia.sic.elements.SICCompileTimeException;
import net.cabezudo.sofia.sic.tokens.Token;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2020.06.14
 */
public class SICGrayShades extends SICInteger {

  public static final String TYPE_NAME = "grayShades";

  private final Integer value;

  public SICGrayShades(Token token) throws SICCompileTimeException {
    super(token);
    try {
      value = Integer.parseInt(getToken().getValue());
    } catch (NumberFormatException e) {
      throw new SICCompileTimeException("Invalid parameter value.", getToken());
    }
    if (value < 2 || value > 255) {
      throw new SICCompileTimeException("The value must be a between 2 and 255.", getToken());
    }
  }

  @Override
  public String getTypeName() {
    return TYPE_NAME;
  }

  @Override
  public boolean isInteger() {
    return true;
  }

  @Override
  public boolean isZero() {
    return getValue() == 0;
  }

  @Override
  public Integer getValue() {
    return value;
  }

}
