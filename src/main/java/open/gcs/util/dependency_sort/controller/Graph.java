package open.gcs.util.dependency_sort.controller;

import java.util.ArrayList;
import open.gcs.util.dependency_sort.model.Arch;
import open.gcs.util.dependency_sort.model.Node;
import open.gcs.util.dependency_sort.util.Util;

public class Graph<T> {

  private ArrayList<Node<T>> nodes;
  private ArrayList<Arch<T>> archs;
  private int countNodes;
  private int countArchs;

  public Graph() {
    nodes = new ArrayList<Node<T>>();
    archs = new ArrayList<Arch<T>>();
    countNodes = 0;
    countArchs = 0;
  }

  public ArrayList<Node<T>> getNodes() {
    return nodes;
  }

  public ArrayList<Arch<T>> getArchs() {
    return archs;
  }

  public int lengthNodes() {
    return countNodes;
  }

  public int lengthArchs() {
    return countArchs;
  }

  public void setNode(T contenido) {
    countNodes += 1;
    nodes.add(new Node<T>(contenido));
  }

  public Node<T> getNode(T content) {
    for (Node<T> node : nodes) {
      if (Util.compare(node.getContents(), content)) {
        return node;
      }
    }

    return null;
  }

  public void setArch(T init, T end) {
    Node<T> nodeInitial = getNode(init);
    Node<T> nodeEnding = getNode(end);

    if (nodes.isEmpty() || nodeInitial == null || nodeEnding == null) {
      System.out.println("Nodos ingresados no existen");
    } else {
      if (!existArch(nodeInitial, nodeEnding)) {
        countArchs += 1;
        archs.add(new Arch<T>(nodeInitial, nodeEnding, countArchs));
      } else
        System.out.println("Arco ya existe");
    }
  }

  public int getLevel(T initial) {
    Node<T> nodeInit = this.getNode(initial);
    ArrayList<Node<T>> lstSuccessors = this.getSuccessors(nodeInit);
    int level = 0;
    if (nodeInit != null) {
      if (lstSuccessors.size() != 0) {
        for (Node<T> suc : lstSuccessors) {
          nodeInit.setMark(true);
          int valor1 = level(suc, 1);
          if (valor1 > level) {
            level = valor1;
          }
          this.uncheck();
        }
      }
    } else {
      System.out.println("Nodo no existe");
    }

    nodeInit.setLevel(level);
    return level;
  }

  private int level(Node<T> init, int level) {
    ArrayList<Node<T>> lstSuccessors = this.getSuccessors(init);
    if (lstSuccessors.size() != 0) {
      for (Node<T> suc : lstSuccessors) {
        int valor1 = level(suc, ++level);
        if (valor1 > level) {
          level = valor1;
        }
      }
    }

    return level;
  }

  private boolean existArch(Node<T> init, Node<T> end) {
    Arch<T> arch = new Arch<T>(init, end, 1);

    for (Arch<T> arc : archs) {
      if (Util.compare(arch, arc)) {
        return true;
      }
    }

    return false;
  }

  private ArrayList<Node<T>> getSuccessors(Node<T> init) {
    ArrayList<Node<T>> lstArchs = new ArrayList<Node<T>>();

    for (Arch<T> a : archs) {
      if (Util.compare(a.getInitial(), init) && !a.getEnding().isMark()) {
        a.getEnding().setMark(true);
        lstArchs.add(a.getEnding());
      }
    }

    return lstArchs;
  }

  private void uncheck() {
    for (Node<T> node : nodes) {
      node.setMark(false);
    }
  }
}
