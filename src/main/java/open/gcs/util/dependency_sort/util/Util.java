package open.gcs.util.dependency_sort.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.google.gson.Gson;

public final class Util {

  public static boolean compare(Object a, Object b) {
    String objectString1 = new Gson().toJson(a);
    String objectString2 = new Gson().toJson(b);

    if (objectString1.equals(objectString2)) {
      return true;
    }

    return false;
  }

  public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
    List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
    list.sort(Entry.comparingByValue());

    Map<K, V> result = new LinkedHashMap<>();
    for (Entry<K, V> entry : list) {
      result.put(entry.getKey(), entry.getValue());
    }

    return result;
  }

  public static <K, V> void printMap(Map<K, V> map, String path) {
    String pathname = path + "/OrdenAplica.txt";
    File archivo = new File(pathname);

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
      
      for (Map.Entry<K, V> entry : map.entrySet()) {
        bw.write(entry.getKey() + "|" + entry.getValue());
        bw.newLine();
        System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
      }
      

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
