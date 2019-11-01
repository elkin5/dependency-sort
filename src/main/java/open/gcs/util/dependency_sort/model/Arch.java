package open.gcs.util.dependency_sort.model;

public class Arch<T> {

  private Node<T> initial;
  private Node<T> ending;
  private int id;

  public Arch(Node<T> init, Node<T> end, int c) {
    this.initial = init;
    this.ending = end;
    this.id = c;
  }

  public Node<T> getInitial() {
    return initial;
  }

  public void setInitial(Node<T> initial) {
    this.initial = initial;
  }

  public Node<T> getEnding() {
    return ending;
  }

  public void setEnding(Node<T> ending) {
    this.ending = ending;
  }

  public int getCost() {
    return id;
  }

  public void setCost(int cost) {
    this.id = cost;
  }

}
