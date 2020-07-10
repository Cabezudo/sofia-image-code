package net.cabezudo.sofia.sic.objects;

import net.cabezudo.sofia.SofiaImage;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2020.06.14
 */
public abstract class SICObject {

  public abstract SofiaImage run(SofiaImage sofiaImage) throws SICRuntimeException;

  public SofiaImage run() throws SICRuntimeException {
    return run(null);
  }
}
