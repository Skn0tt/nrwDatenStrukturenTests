import org.testng.annotations.Test;
import static org.fest.assertions.api.Assertions.assertThat;

public class SortedListTest {
  private class Item implements Sortable<Item> {
    private String iD;
    public Item(String pID) { this.iD = pID; }

    public String getID() { return iD; }
  
    @Override
    public int compareTo(Item pItem) { return iD.compareTo(pItem.getID()); }
  
    @Override
    public String toString() { return iD; }
  }

  boolean isSorted(SortedList<Item> list) {
    list.toFirst();

    Item last = list.getContent();
    list.next();

    while (list.hasAccess()) {
      if (list.getContent().compareTo(last) <= 0) { return false; }
      list.next();
    }

    return true;
  }
  
  @Test
  void testConstructor() {
    SortedList<Item> list = new SortedList<>();

    assertThat(list.isEmpty()).isTrue();
  }

  @Test
  void testInsert() {
    SortedList<Item> list = new SortedList<Item>();

    list.insert(new Item("1"));

    list.toFirst();
    assertThat(list.getContent().getID()).isEqualTo("1");

    list.toLast();
    assertThat(list.getContent().getID()).isEqualTo("1");
  }

  @Test
  void testInsertMassive() {
    SortedList<Item> list = new SortedList<Item>();

    for (int i = 0; i < 100; i++) {
      list.insert(new Item("" + i));
    }

    list.toFirst();
    assertThat(list.getContent().getID()).isEqualTo("0");

    list.toLast();
    assertThat(list.getContent().getID()).isEqualTo("99");

    assertThat(isSorted(list)).isTrue();
  }
  @Test
  void testConcat() {
    SortedList<Item> list = new SortedList<>();

    for (int i = 100; i < 300; i += 2) {
      list.insert(new Item("" + i));
    }

    SortedList<Item> list2 = new SortedList<>();

    for (int i = 0; i < 500; i += 5) {
      list2.insert(new Item("" + i));
    }

    list.concat(list2);

    list.toFirst();
    assertThat(list.getContent().getID()).isEqualTo("0");

    list.toLast();
    assertThat(list.getContent().getID()).isEqualTo("95");

    assertThat(isSorted(list)).isTrue();
  }


  
}