 public class List<ContentType> {
  public List() {}
  
  public boolean isEmpty() {
    return false;
  }
  public boolean hasAccess() {
    return false;
  }
  public void next() {}
  public void toFirst() {}
  public void toLast() {}
  public ContentType getContent() {
    return null;
  }
  public void setContent(ContentType pContent) {}
  public void insert(ContentType pContent) {}
  public void append(ContentType pContent) {}
  public void concat(List<ContentType> pList) {}
  public void remove() {}
}
