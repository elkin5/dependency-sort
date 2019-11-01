package open.gcs.util.dependency_sort.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.stage.Stage;
import open.gcs.util.dependency_sort.model.Assembly;

public class AssemblyController {

  private Graph<Assembly> graph;
  private List<Assembly> assemblies;

  public AssemblyController() {
    assemblies = new ArrayList<>();
    graph = new Graph<>();
  }

  public void setAssemblies(String path) {
    try {
      Files.walk(Paths.get(path)).forEach(ruta -> {
        if (Files.isRegularFile(ruta)) {
          Assembly a = this.getAssembly(ruta.toString());
          System.out.println(a.getAssemblyName());
          assemblies.add(a);
        }
      });
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public List<Assembly> getAssemblies() {
    return assemblies;
  }

  public Map<String, Integer> assemblyLevels(List<Assembly> assem) {
    Map<String, Integer> levels = new HashMap<String, Integer>();
    for (Assembly ass : assem) {
      int leve = graph.getLevel(ass);
      System.out.println(ass.getAssemblyName() + "|" + leve);
      levels.put(ass.getFilename(), leve);
    }

    return levels;
  }

  public void setGraph() {
    this.setNodes();
    this.setArch();
  }

  private void setNodes() {
    for (Assembly assembly : assemblies) {
      graph.setNode(assembly);
    }
  }

  private void setArch() {
    System.out.println("Creando los Arcos del grafo");
    for (Assembly assembly : assemblies) {
      System.out.println("Assembly: " + assembly.getAssemblyName());
      List<String> dependencies = DependencyController.setDependencies(assembly.getPathname());

      for (String dependency : dependencies) {
        Assembly ass = this.getAssemblyByName(dependency);
        if (ass != null) {
          System.out.println(assembly.getAssemblyName() + " --> " + ass.getAssemblyName());
          graph.setArch(assembly, ass);
        }
      }
    }
  }

  private Assembly getAssembly(String pathname) {
    Assembly assembly = new Assembly();
    pathname = pathname.replace("\\", "/");
    String[] array = pathname.split("/");
    int count = array.length;
    assembly.setPathname(pathname);
    assembly.setFilename("/Giras_Export/" + array[count - 1]);
    assembly.setAssemblyName(array[count - 1].replace(".sql", "").replace("_", "."));

    return assembly;
  }

  private Assembly getAssemblyByName(String name) {
    for (Assembly a : this.assemblies) {
      if (a.getAssemblyName().toUpperCase().equals(name.toUpperCase())) {
        return a;
      }
    }

    return null;
  }
}
