package net.cabezudo.sofia.sic.tokens.functions;

import net.cabezudo.sofia.sic.tokens.FunctionToken;
import net.cabezudo.sofia.sic.tokens.Position;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2020.06.13
 */
public class ResizeFunctionToken extends FunctionToken {

  public ResizeFunctionToken(Position position) {
    super("resize", position);
  }
}
