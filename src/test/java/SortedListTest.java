import org.testng.annotations.Test;

import java.util.Random;

import static org.fest.assertions.api.Assertions.assertThat;

public class SortedListTest {
  private class Item implements Sortable<Item> {
    private int id;
    Item(int pID) { this.id = pID; }

    public String getID() { return "" + id; }
  
    @Override
    public int compareTo(Item pItem) { return Integer.compare(id, pItem.id); }
  
    @Override
    public String toString() { return "" + id; }
  }

  private boolean isSorted(SortedList<Item> list) {
    list.toFirst();

    Item last = list.getContent();
    list.next();

    while (list.hasAccess()) {
      if (list.getContent().compareTo(last) < 0) { return false; }
      list.next();
    }

    return true;
  }

  /*----- Test isEmpty() -----*/

  /**
   * isEmpty() with empty list
   * @author: Andreas, Benedikt E, Benedikt R
   */
  @Test
  void testIsEmptyOnEmpty() {
    SortedList<Item> list = new SortedList<>();

    assertThat(list.isEmpty()).isTrue();
  }

  /**
   * isEmpty() with filled list
   * @author: Andreas, Benedikt E, Benedikt R
   */

  @Test
  void testIsEmptyOnNonEmpty() {
    SortedList<Item> list = new SortedList<>();
    list.append(new Item(12));

    assertThat(list.isEmpty()).isFalse();
  }

  /**
   * isEmpty() with filled list
   * @author: Andreas, Benedikt E, Benedikt R
   */
  @Test
  void testIsEmptyOnNull() {
    SortedList<Item> list = new SortedList<>();
    list.append(null);

    assertThat(list.isEmpty()).isTrue();
  }

  /*----- Tests hasAccess() -----*/

  /**
   * hasAccess() with no current node
   * @author: Andreas, Benedikt E, Benedikt R
   */
  @Test
  void testHasAccessOnNoAccess() {
    SortedList<Item> list = new SortedList<>();

    assertThat(list.hasAccess()).isFalse();
  }

  /**
   * hasAccess() with current node is set.
   * @author: Andreas, Benedikt E, Benedikt R
   */
  @Test
  void testHasAccessOnAccess() {
    SortedList<Item> list = new SortedList<>();

    list.append(new Item(2));
    list.toFirst();

    assertThat(list.hasAccess()).isTrue();
  }
  
  @Test
  void testConstructor() {
    SortedList<Item> list = new SortedList<>();

    assertThat(list.isEmpty()).isTrue();
  }

  @Test
  void testInsert() {
    SortedList<Item> list = new SortedList<Item>();

    list.insert(new Item(1));

    list.toFirst();
    assertThat(list.getContent().getID()).isEqualTo("1");

    list.toLast();
    assertThat(list.getContent().getID()).isEqualTo("1");
  }

  @Test
  void testInsertRandom() {
    SortedList<Item> list = new SortedList<>();

    new Random()
      .ints(100, 0, 1000)
      .forEach(i -> list.insert(new Item(i)));

    assertThat(isSorted(list)).isTrue();
  }

  @Test
  void testInsertMassive() {
    SortedList<Item> list = new SortedList<Item>();

    for (int i = 0; i < 100; i++) {
      list.insert(new Item(i));
    }

    list.toFirst();
    assertThat(list.getContent().getID()).isEqualTo("0");

    list.toLast();
    assertThat(list.getContent().getID()).isEqualTo("99");

    assertThat(isSorted(list)).isTrue();
  }

  @Test
  void testAppendRandom() {
    SortedList<Item> list = new SortedList<>();

    new Random()
      .ints(1000, 0, 100)
      .forEach(i -> list.append(new Item(i)));

    assertThat(isSorted(list)).isTrue();
  }

  @Test
  void testGetById() {
    SortedList<Item> list = new SortedList<>();

    int[] values = { 1, 6, 23, 9, 9, 3, 6, 5, 3 };

    for (int i : values) { list.append(new Item(i)); }

    list.getByID("5");

    assertThat(list.getContent().getID()).isEqualTo("5");

    list.next();

    assertThat(list.getContent().getID()).isEqualTo("6");
  }

  @Test
  void testRemoveById() {
    SortedList<Item> list = new SortedList<>();

    int[] values = { 1, 6, 23, 9, 9, 3, 6, 5, 3 };

    for (int i : values) { list.append(new Item(i)); }

    list.removeByID("1");

    list.toFirst();

    assertThat(list.getContent().getID()).isEqualTo("3");
  }

  @Test
  void testSetContent() {
    SortedList<Item> list = new SortedList<>();

    int[] values = { 1, 6, 23, 9, 9, 3, 6, 5, 3 };

    for (int i : values) { list.append(new Item(i)); }

    list.toFirst();

    list.setContent(new Item(24));

    assertThat(list.getContent().getID()).isEqualTo("3");

    list.toLast();

    assertThat(list.getContent().getID()).isEqualTo("24");
  }

  @Test
  void testToFirst() {
    SortedList<Item> list = new SortedList<>();

    int[] values = { 1, 6, 23, 9, 9, 3, 6, 5, 3 };

    for (int i : values) { list.append(new Item(i)); }

    list.toFirst();

    assertThat(list.getContent().getID()).isEqualTo("1");
  }

  @Test
  void testToLast() {
    SortedList<Item> list = new SortedList<>();

    int[] values = { 1, 6, 23, 9, 9, 3, 6, 5, 3 };

    for (int i : values) { list.append(new Item(i)); }

    list.toLast();

    assertThat(list.getContent().getID()).isEqualTo("23");
  }

  @Test
  void testNext() {
    SortedList<Item> list = new SortedList<>();

    int[] values = { 1, 6, 23, 9, 9, 3, 6, 5, 3 };

    for (int i : values) { list.append(new Item(i)); }

    list.toFirst();
    assertThat(list.getContent().getID()).isEqualTo("1");

    list.next();
    assertThat(list.getContent().getID()).isEqualTo("3");

    list.next();
    assertThat(list.getContent().getID()).isEqualTo("3");

    list.next();
    assertThat(list.getContent().getID()).isEqualTo("5");
  }

  @Test
  void testPrevious() {
    SortedList<Item> list = new SortedList<>();

    int[] values = { 1, 6, 23, 9, 9, 3, 6, 5, 3 };

    for (int i : values) { list.append(new Item(i)); }

    list.toLast();
    assertThat(list.getContent().getID()).isEqualTo("23");

    list.previous();
    assertThat(list.getContent().getID()).isEqualTo("9");

    list.previous();
    assertThat(list.getContent().getID()).isEqualTo("9");

    list.previous();
    assertThat(list.getContent().getID()).isEqualTo("6");
  }



  @Test
  void testConcat() {
    SortedList<Item> list = new SortedList<>();
    SortedList<Item> list2 = new SortedList<>();

    int[] first = { 12, 43, 53, 34, 32, 9 };
    int[] second = { 1, 99 };

    for (int i : first) { list.insert(new Item(i)); }
    for (int i : second) { list2.insert(new Item(i)); }

    list.concat(list2);

    list.toFirst();
    assertThat(list.getContent().getID()).isEqualTo("1");

    list.next();
    assertThat(list.getContent().getID()).isEqualTo("9");

    list.toLast();
    assertThat(list.getContent().getID()).isEqualTo("99");

    assertThat(isSorted(list)).isTrue();
  }
  
}