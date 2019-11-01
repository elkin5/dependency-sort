package open.gcs.util.dependency_sort.model;

public class Node<T> {

  private T contents;
  private int level;  

  private boolean mark;

  public Node(T value) {
    this.contents = value;
    this.level = 9999;
    this.mark = false;
  }

  public T getContents() {
    return contents;
  }

  public void setContents(T contents) {
    this.contents = contents;
  }

  public boolean isMark() {
    return mark;
  }

  public void setMark(boolean mark) {
    this.mark = mark;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }
}
