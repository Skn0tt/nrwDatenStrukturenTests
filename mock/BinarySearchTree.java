public class BinarySearchTree<T extends ComparableContent<T>> {
  public T getContent() {
    return null;
  }
  public BinarySearchTree<T> getLeftTree() {
    return null;
  }
  public BinarySearchTree<T> getRightTree() {
    return null;
  }
  private void setContent(T to) {}
  private void setLeftTree(BinarySearchTree<T> to) {}
  private void setRightTree(BinarySearchTree<T> to) {}
  public boolean isEmpty() {
    return false;
  }
  public void insert(T item) {}
  public T search(T item) {
    return null;
  }
  public void remove(T item) {}
}
interface ComparableContent<T> {
  boolean isLess(T than);
  boolean isEqual(T than);
  boolean isGreater(T than);
}

