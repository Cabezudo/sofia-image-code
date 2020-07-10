package net.cabezudo.sofia.sic.tokens;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2020.06.13
 */
public class CloseParenthesesToken extends Token {

  public CloseParenthesesToken(Position position) {
    super(")", position);
  }

  @Override
  public boolean isCloseParentheses() {
    return true;
  }

  @Override
  public String getCSSClass() {
    return "none";
  }

  @Override
  public TokenType getType() {
    return TokenType.CLOSE_PARENTHESES;
  }
}
