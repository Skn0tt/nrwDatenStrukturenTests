public class SortedList<ContentType extends Sortable<ContentType>> extends List<ContentType> {
  interface Sortable<ContentType> {
    public int compareTo(ContentType pContent);
    public String getID();
  }

  public void setContent(ContentType pContent) {}
  public void insert(ContentType pContent) {}
  public void append(ContentType pContent) {}
  public void concat(List<ContentType> pList) {}
  public void previous() {}
  public void getByID(String pId) {}
  public void removeByID(String pId) {}
}
