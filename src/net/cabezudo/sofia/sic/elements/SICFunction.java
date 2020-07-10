package net.cabezudo.sofia.sic.elements;

import java.nio.file.Path;
import net.cabezudo.sofia.sic.Utils;
import net.cabezudo.sofia.sic.objects.ObjectFactory;
import net.cabezudo.sofia.sic.objects.SICObject;
import net.cabezudo.sofia.sic.objects.SICObjectFunction;
import net.cabezudo.sofia.sic.tokens.Token;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2020.06.13
 */
public class SICFunction extends SICParameterOrFunction {

  private final SICParameters parameters = new SICParameters();

  public SICFunction(Token token) {
    super(token.getValue(), token);
  }

  public SICParameters getParameter() {
    return parameters;
  }

  @Override
  public String toString(int deep) {
    int newDeep = deep;
    StringBuilder sb = new StringBuilder();
    sb.append(Utils.repeat(' ', newDeep * 2));
    sb.append(getName()).append("(\n");
    newDeep++;
    for (SICElement parameter : parameters) {
      sb.append(parameter.toString(newDeep));
      sb.append(",\n");
    }
    if (parameters.size() > 0) {
      sb = Utils.chop(sb, 2);
    }
    sb.append("\n");
    newDeep--;
    sb.append(Utils.repeat(' ', newDeep * 2));
    sb.append(")");
    return sb.toString();
  }

  public void add(SICElement sicParameterOrFunction) {
    parameters.add(sicParameterOrFunction);
  }

  @Override
  public SICObject compile(Path basePath) throws SICCompileTimeException {
    SICObjectFunction sicObjectFunction = ObjectFactory.get(basePath, getToken(), parameters);
    return sicObjectFunction;
  }
}
