package open.gcs.util.dependency_sort.service;

import java.util.List;
import java.util.Map;
import open.gcs.util.dependency_sort.controller.AssemblyController;
import open.gcs.util.dependency_sort.model.Assembly;
import open.gcs.util.dependency_sort.util.Util;

public class OrderAssembly {

  private AssemblyController mgrAssembly;

  public OrderAssembly() {
    this.mgrAssembly = new AssemblyController();
  }

  public String setAsembly(String path) {
    mgrAssembly.setAssemblies(path);

    return "Asemblys agregados correctamente";
  }

  public String serGraph() {
    mgrAssembly.setGraph();

    return "Grafo creado correctamente";
  }

  public String setLevel(String path) {

    Map<String, Integer> assemblyLevels = mgrAssembly.assemblyLevels(mgrAssembly.getAssemblies());
    Map<String, Integer> assemblySort = Util.sortByValue(assemblyLevels);
    Util.printMap(assemblySort, path);

    return "Niveles finalizado exitosamente";
  }

  public String setLevelThe(String path) {
    List<Assembly> lstTotal = mgrAssembly.getAssemblies();
    int total = lstTotal.size();
    int div = total / 2;

    Runnable action = () -> {
      AssemblyController ass1 = mgrAssembly;
      List<Assembly> lstUno = lstTotal.subList(0, div);

      @SuppressWarnings("unused")
      Map<String, Integer> assemblyLevels = ass1.assemblyLevels(lstUno);
    };

    Thread t = new Thread(action);
    t.start();

    Runnable action2 = () -> {
      AssemblyController ass1 = mgrAssembly;
      List<Assembly> lstUno = lstTotal.subList(div, total);

      @SuppressWarnings("unused")
      Map<String, Integer> assemblyLevels = ass1.assemblyLevels(lstUno);
    };

    Thread t2 = new Thread(action2);
    t2.start();

    return "Niveles finalizado exitosamente";
  }

}
