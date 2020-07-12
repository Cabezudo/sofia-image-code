package net.cabezudo.sofia.sic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2020.07.03
 */
public class Messages {

  private final List<Message> list = new ArrayList<>();

  public void add(Message message) {
    list.add(message);
  }

//  public JSONArray toJSON() {
//    JSONArray jsonArray = new JSONArray();
//    list.forEach((message) -> {
//      jsonArray.add(message.toJSON());
//    });
//    return jsonArray;
//  }

  public int size() {
    return list.size();
  }
}
