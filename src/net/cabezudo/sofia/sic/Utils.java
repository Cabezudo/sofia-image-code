package net.cabezudo.sofia.sic;

import java.util.Arrays;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2020.07.09
 */
public class Utils {

  public static String repeat(char c, int length) {
    char[] array = new char[length];
    Arrays.fill(array, c);
    return new String(array);
  }

  public static String chop(String string, int i) {
    return string.substring(0, string.length() - i);
  }

  public static StringBuilder chop(StringBuilder sb, int i) {
    String s = sb.substring(0, sb.length() - i);
    StringBuilder newStringBuilder = new StringBuilder(s);
    return newStringBuilder;
  }
}
