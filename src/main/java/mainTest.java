import java.util.List;
import open.gcs.util.dependency_sort.controller.Graph;
import open.gcs.util.dependency_sort.model.Arch;
import open.gcs.util.dependency_sort.model.Assembly;
import open.gcs.util.dependency_sort.model.Node;
import open.gcs.util.dependency_sort.util.Util;

public class mainTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Assembly assembly1 = new Assembly();
    assembly1.setPathname("/OpenSmartFlex/Giras_Export/a");
    assembly1.setFilename("a");
    assembly1.setAssemblyName("aaaa");

    Assembly assembly2 = new Assembly();
    assembly2.setPathname("/OpenSmartFlex/Giras_Export/b");
    assembly2.setFilename("b");
    assembly2.setAssemblyName("bbbb");

    Assembly assembly3 = new Assembly();
    assembly3.setPathname("/OpenSmartFlex/Giras_Export/c");
    assembly3.setFilename("c");
    assembly3.setAssemblyName("cccc");

    Assembly assembly4 = new Assembly();
    assembly4.setPathname("/OpenSmartFlex/Giras_Export/d");
    assembly4.setFilename("d");
    assembly4.setAssemblyName("dddd");

    Assembly assembly5 = new Assembly();
    assembly5.setPathname("/OpenSmartFlex/Giras_Export/e");
    assembly5.setFilename("e");
    assembly5.setAssemblyName("eeee");

    Assembly assembly6 = new Assembly();
    assembly6.setPathname("/OpenSmartFlex/Giras_Export/f");
    assembly6.setFilename("f");
    assembly6.setAssemblyName("ffff");
    
    Assembly assembly7 = new Assembly();
    assembly7.setPathname("/OpenSmartFlex/Giras_Export/g");
    assembly7.setFilename("g");
    assembly7.setAssemblyName("gggg");
    
    Assembly assembly8 = new Assembly();
    assembly8.setPathname("/OpenSmartFlex/Giras_Export/h");
    assembly8.setFilename("h");
    assembly8.setAssemblyName("hhhh");
    
    Assembly assembly9 = new Assembly();
    assembly9.setPathname("/OpenSmartFlex/Giras_Export/i");
    assembly9.setFilename("i");
    assembly9.setAssemblyName("iiii");

    Graph<Assembly> graph = new Graph<Assembly>();

    graph.setNode(assembly1);
    graph.setNode(assembly2);
    graph.setNode(assembly3);
    graph.setNode(assembly4);
    graph.setNode(assembly5);
    graph.setNode(assembly6);
    graph.setNode(assembly7);
    graph.setNode(assembly8);
    graph.setNode(assembly9);

//    graph.setArch(assembly1, assembly2);
    graph.setArch(assembly1, assembly3);
    graph.setArch(assembly2, assembly4);
    graph.setArch(assembly3, assembly4);
    graph.setArch(assembly4, assembly5);
    graph.setArch(assembly6, assembly3);
    
    graph.setArch(assembly1, assembly8);
    graph.setArch(assembly8, assembly9);
    graph.setArch(assembly9, assembly2);
    graph.setArch(assembly5, assembly7);
    graph.setArch(assembly7, assembly2);
    graph.setArch(assembly2, assembly3);

    List<Node<Assembly>> nodes = graph.getNodes();
    for (int i = 0; i < nodes.size(); i++)
      System.out.println(
          "vertice = " + nodes.get(i).getContents().getAssemblyName() + "\n ID = " + (i + 1));


    List<Arch<Assembly>> archs = graph.getArchs();
    for (int i = 0; i < archs.size(); i++) {
      System.out.println(
          "[" + archs.get(i).getInitial().getContents() + "]------------" + archs.get(i).getCost()
              + "------------->[" + archs.get(i).getEnding().getContents().getAssemblyName() + "]");
    }


    Assembly a = new Assembly();
    a.setPathname("1");
    a.setFilename("a");
    a.setAssemblyName("aaa");

    Assembly b = new Assembly();
    b.setPathname("1");
    b.setFilename("aa");
    b.setAssemblyName("aaa");

    graph.setArch(assembly6, assembly3);

    if (Util.compare(a, b)) {
      System.out.println("Si");
    } else
      System.out.println("No");

    Node<Assembly> nodebb = graph.getNode(assembly6);
    if (nodebb != null) {
      System.out.println("Si");
    }

    // listaCalles.sort(Comparator.comparing(Calle::getCodigo));;
    System.out.println("nivel A = " + graph.getLevel(assembly1)); // 3
    System.out.println("nivel B = " + graph.getLevel(assembly2)); // 2
    System.out.println("nivel C = " + graph.getLevel(assembly3)); // 2
    System.out.println("nivel D = " + graph.getLevel(assembly4)); // 1
    System.out.println("nivel E = " + graph.getLevel(assembly5)); // 0
    System.out.println("nivel F = " + graph.getLevel(assembly6)); // 3
    System.out.println("nivel G = " + graph.getLevel(assembly7)); // 3
    System.out.println("nivel H = " + graph.getLevel(assembly8)); // 3
    System.out.println("nivel I = " + graph.getLevel(assembly9)); // 3
  }

}
