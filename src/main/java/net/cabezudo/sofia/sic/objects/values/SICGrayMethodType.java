package net.cabezudo.sofia.sic.objects.values;

import net.cabezudo.sofia.sic.elements.SICCompileTimeException;
import net.cabezudo.sofia.sic.tokens.SICToken;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2020.06.14
 */
public class SICGrayMethodType extends SICString {

  public SICGrayMethodType(SICToken functionToken, SICString grayMethodToken, SICToken grayMethodTypeToken) throws SICCompileTimeException {
    super(grayMethodTypeToken);
    switch (grayMethodToken.getValue()) {
      case "luma":
        if (grayMethodTypeToken != null) {
          switch (grayMethodTypeToken.getValue()) {
            case "basic":
            case "bt709":
            case "bt601":
              break;
            default:
              throw new SICCompileTimeException("Invalid method type for Luma model.", grayMethodTypeToken);
          }
        }
        break;
      case "decomposition":
        if (grayMethodTypeToken == null) {
          throw new SICCompileTimeException("You MUST specify the type of decomposition.", functionToken);
        }
        switch (grayMethodTypeToken.getValue()) {
          case "maximum":
          case "minimum":
            break;
          default:
            throw new SICCompileTimeException("Invalid method type for decomposition model.", grayMethodTypeToken);
        }
        break;
      case "colorChannel":
        if (grayMethodTypeToken == null) {
          throw new SICCompileTimeException("You MUST specify the type of decomposition.", functionToken);
        }
        switch (grayMethodTypeToken.getValue()) {
          case "red":
          case "green":
          case "blue":
            break;
          default:
            throw new SICCompileTimeException("Invalid method type for single color channel model.", grayMethodTypeToken);
        }
        break;
      case "grayShades":
      case "averaging":
      case "desaturation":
        break;
      default:
        throw new SICCompileTimeException("Invalid model " + grayMethodToken.getValue() + " for gray function.", grayMethodToken.getToken());
    }
  }

  @Override
  public String getTypeName() {
    return "grayMethodType";
  }

  @Override
  public boolean isString() {
    return true;
  }

  @Override
  public String getValue() {
    return getToken().getValue();
  }
}
