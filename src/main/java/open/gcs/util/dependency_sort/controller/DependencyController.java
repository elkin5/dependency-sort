package open.gcs.util.dependency_sort.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class DependencyController {

  public static List<String> setDependencies(String ruta) {
    boolean flag = true;
    List<String> lstDependencies = new ArrayList<>();

    File archivo = new File(ruta);
    try (FileReader fileReader = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fileReader)) {
      String line;
      while ((line = br.readLine()) != null && flag == true) {
        if (line.contains("ut_trace.trace('Inicia insercion de datos de ambiente origen',1);")) {
          String assembly = br.readLine();
          while (!assembly
              .contains("ut_trace.trace('Finaliza insercion de datos de ambiente origen',1);")) {
            if (assembly.length() != 0) {
              String assemblyName = assembly.substring(assembly.indexOf(":="));
              assemblyName =
                  assemblyName.replace(":=", "").replaceAll("'", "").replace(";", "").trim();
              lstDependencies.add(assemblyName);
            }
            assembly = br.readLine();
          }
          flag = false;
        }

        if (line.contains("<DEPENDENCIES>")) {
          String assembly = br.readLine();
          while (!assembly.contains("</DEPENDENCIES>")) {
            if (assembly.contains("<ASSEMBLY>")) {
              String assemblyName =
                  assembly.replace("<ASSEMBLY>", "").replaceAll("</ASSEMBLY>", "").trim();
              lstDependencies.add(assemblyName);
            }
            assembly = br.readLine();
            flag = false;
          }
        }
        
        if (line.contains("dbms_lob.append("))
          flag = false;
      }

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } ;

    return lstDependencies;
  }

}
