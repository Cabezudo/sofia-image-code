package net.cabezudo.sofia.sic.objects;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import net.cabezudo.sofia.SofiaImage;
import net.cabezudo.sofia.logger.Logger;
import net.cabezudo.sofia.sic.elements.SICCompileTimeException;
import net.cabezudo.sofia.sic.elements.SICElement;
import net.cabezudo.sofia.sic.elements.SICFunction;
import net.cabezudo.sofia.sic.elements.SICParameter;
import net.cabezudo.sofia.sic.elements.SICParameters;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2020.06.14
 */
public class MainFunctionObject extends SICObjectFunction {

  private final List<SICObject> list;

  public MainFunctionObject(Path basePath, SICParameters parameters) throws SICCompileTimeException {
    this.list = new ArrayList<>();
    SICElement parameterOrFunction = parameters.consume();
    while (parameterOrFunction != null) {
      if (parameterOrFunction.isParameter()) {
        SICParameter parameter = (SICParameter) parameterOrFunction;
        throw new SICCompileTimeException("Unexpected function parameter " + parameter.getName() + ".", parameter.getToken());
      }
      SICFunction functionParameter = (SICFunction) parameterOrFunction;
      SICObject sicObject = functionParameter.compile(basePath);
      list.add(sicObject);
      parameterOrFunction = parameters.consume();
    }
  }

  @Override
  public SofiaImage run(SofiaImage ignoredImage) throws SICRuntimeException {
    if (ignoredImage != null) {
      Logger.warning("[MainFunctionObject:run] Invalid image on parameter: %s", ignoredImage.getImagePath());
    }
    SofiaImage sofiaImage = null;
    for (SICObject sicObject : list) {
      sofiaImage = sicObject.run(sofiaImage);
    }
    return sofiaImage;
  }

}
