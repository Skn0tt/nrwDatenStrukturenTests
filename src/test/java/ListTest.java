import org.testng.annotations.Test;
import static org.fest.assertions.api.Assertions.assertThat;

public class ListTest {
    /**
     * creating a new List
     *
     * @author: Andreas, Benedikt E, Benedikt R
     */
    @Test
    void testConstructor() {
        List<String> list = new List<String>();
    }

    /*----- Test isEmpty() -----*/

    /**
     * isEmpty() with empty list
     * @author: Andreas, Benedikt E, Benedikt R
     */
    @Test
    void testIsEmptyOnEmpty() {
        List<Integer> list = new List<Integer>();

        assertThat(list.isEmpty()).isTrue();
    }

    /**
     * isEmpty() with filled list
     * @author: Andreas, Benedikt E, Benedikt R
     */
    
    @Test
    void testIsEmptyOnNonEmpty() {
        List<Integer> list = new List<Integer>();
        list.append(12);

        assertThat(list.isEmpty()).isFalse();
    }

     /**
     * isEmpty() with filled list
     * @author: Andreas, Benedikt E, Benedikt R
     */
    @Test
    void testIsEmptyOnNull() {
        List<Integer> list = new List<Integer>();
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
        List<Integer> list = new List<Integer>();

        assertThat(list.hasAccess()).isFalse();
    }

    /**
     * hasAccess() with current node is set.
     * @author: Andreas, Benedikt E, Benedikt R
     */
    @Test
    void testHasAccessOnAccess() {
        List<Integer> list = new List<Integer>();

        list.append(2);
        list.toFirst();

        assertThat(list.hasAccess()).isTrue();
    }

    /*----- Tests next() -----*/

    /**
     * next() with empty List
     * @author: Andreas, Benedikt E, Benedikt R
     */
    @Test
    void testNextOnEmpty() {
        List<String> list = new List<String>();

        list.next();

        assertThat(list.hasAccess()).isFalse();
    }

    /**
     * next() with filled List && hasAccess() == false
     * @author: Andreas, Benedikt E, Benedikt R
     */
    @Test
    void testNextOnNonEmptyNoAccess() {
        List<String> list = new List<String>();

        list.insert("Test");
        list.next();

        assertThat(list.hasAccess()).isFalse();
    }

    /**
     * next() with filled List && hasAccess() == true && current == tail
     * @author: Andreas, Benedikt E, Benedikt R
     */
    @Test
    void testNextOnNonEmptyAtEnd() {
        List<String> list = new List<String>();

        list.insert("Test");
        list.toLast();
        list.next();

        assertThat(list.hasAccess()).isFalse();
    }

    /**
     * next() with filled List && hasAccess() == true && current != tail
     * @author: Andreas, Benedikt E, Benedikt R
     */
    @Test
    void testNextOnNonEmpty() {
        List<String> list = new List<String>();

        list.insert("Test");
        list.append("Test2");
        list.toFirst();
        list.next();

        assertThat(list.getContent()).isEqualTo("Test2");
    }

    /*----- Test toFirst() -----*/

    /**
     * toFirst() with empty List
     * @author: Andreas, Benedikt E, Benedikt R
     */
    @Test
    void testToFirstOnEmpty() {
        List<String> list = new List<String>();

        list.toFirst();

        assertThat(list.hasAccess()).isFalse();
    }

    /**
     * toFirst() with filled List
     * @author: Andreas, Benedikt E, Benedikt R
     */
    @Test
    void testToFirstOnNonEmpty() {
        List<String> list = new List<String>();

        list.insert("Test");
        list.toFirst();

        assertThat(list.getContent()).isEqualTo("Test");
    }

    /*----- Test toLast() -----*/

    /**
     * toLast() with empty List
     * @author: Andreas, Benedikt E, Benedikt R
     */
    @Test
    void testToLastOnEmpty() {
        List<String> list = new List<String>();

        list.toLast();

        assertThat(list.hasAccess()).isFalse();
    }

    /**
     * toLast() with filled List
     * @author: Andreas, Benedikt E, Benedikt R
     */
    @Test
    void testToLastOnNonEmpty() {
        List<String> list = new List<String>();

        list.insert("Test");
        list.toLast();

        assertThat(list.getContent()).isEqualTo("Test");
    }

    /*----- Tests getContent() -----*/

    /**
     * getContent() with empty list
     * @author: Andreas, Benedikt E, Benedikt R
     */
    @Test
    void testGetContentOnEmpty() {
        List<String> list = new List<String>();

        assertThat(list.getContent()).isNull();
    }

    /**
     * getContent() with a non-empty list
     * @author: Andreas, Benedikt E, Benedikt R
     */
    @Test
    void testGetContentOnNonEmpty() {
        List<String> list = new List<String>();

        list.append("Hallo");
        list.toFirst();

        assertThat(list.getContent()).isEqualTo("Hallo");
    }

    /*----- Tests setContent() -----*/

    /**
     * setContent() rewrite content
     * @author: Andreas, Benedikt E, Benedikt R
     */
    @Test
    void testSetContent() {
        List<String> list = new List<String>();
        String temp = "Hallo";

        list.append(temp);
        list.toFirst();

        list.setContent("Test");
        assertThat(list.getContent()).isEqualTo("Test");
    }

    /**
     * setContent() with pContent = null
     * @author: Andreas, Benedikt E, Benedikt R
     */
    @Test
    void testSetContentToNull() {
        List<String> list = new List<String>();
        String temp = "Test";

        list.append(temp);
        list.toFirst();

        list.setContent(null);

        assertThat(list.getContent()).isEqualTo(temp);
    }

    /*----- Tests concat() -----*/
    
    /** 
     * concat() a second list 
     * tail should be last element of second list
     * @author:JonasMoerchen
     */
    @Test     
    void testListConcatTail(){
        List<String> list = new List<>();
        list.append("Hallo");
        List<String> secondList = new List<>();
        secondList.append("tschuess");
        list.concat(secondList);
        list.toLast();

        assertThat(list.getContent()).isEqualTo("tschuess");
    }  
  
  
    /** 
     * concat() a second list 
     * second list should be concated
     * @author:JonasMoerchen   
     */
    @Test  
    void testListConcatSuccessful(){
        List<String> list = new List<>();
        list.append("Hallo");
        List<String> secondList = new List<>();
        secondList.append("und");
        secondList.append("tschuess");
        list.concat(secondList);
        list.toFirst();
        int counter = 0;
        while (list.hasAccess()) { 
            list.remove();
            counter++;
        }
        
        assertThat(counter).isEqualTo(3);
    }

    /** 
     * concat() a second list 
     * new List should be ordered
     * @author:JonasMoerchen
     */
    @Test
    void testListConcatOrder(){
        List<Integer> list = new List<>();
        list.append(1);
        List<Integer> secondList = new List<>();
        secondList.append(2);
        secondList.append(3);
        list.concat(secondList);
        list.toFirst();
        for (int i=1;i<=3;i++ ) {
            assertThat(list.getContent()).isEqualTo(i);
            list.remove();
        }
    }
  
    /**
     * Testet ob die übergebene liste geleert wird
     * @author: Jonathan Wassermann
     */
    @Test
    void testConcatIsEmpty() {
        List<String> liste = new List<>();
        List<String> liste2 = new List<>();
        liste2.append("Hello");
        liste.concat(liste2);
        assertThat(liste2.isEmpty()).isTrue();   
    }

    /**
     * Testet ob zu einer leeren Liste hinzugefuegt werden kann
     * @author: Jonathan Wassermann
     */
    @Test
    void testConcat2() {
        List<String> liste = new List<>();
        List<String> liste2 = new List<>();
        liste2.append("Hello");
        liste.concat(liste2);   
        assertThat(liste.isEmpty()).isFalse();
    }

    /**
     * Testet, ob list1 unverändert bleibt, wenn list2 leer ist.
     * @author: Wolfgang Buhl
     */
    @Test
    void testConcatEmpty(){
        List<String> list1 = new List<>();
        List<String> list2 = new List<>();
        list1.append("Hello");
        list1.concat(list2);
        list1.toLast();
        assertThat(list1.getContent()).isEqualTo("Hello");
    }

    /**
     * Testet, ob man list2 an list1 anhängen kann, wenn es extrem viele Werte sind.
     * @author: Wolfgang Buhl
     */
    @Test
    void testConcatMassive(){
        List<Integer> list1 = new List<>();
        List<Integer> list2 = new List<>();
        for (int i = 0; i <= 1000000; i++) list2.append(i);
        list1.concat(list2);
        list1.toLast();
        assertThat(list1.getContent()).isEqualTo(1000000);
    }

    /*----- Test append() -----*/
    
    /**
     * append() to empty List
     */
    @Test
    void testAppendOnEmpty(){
        List<Integer> list = new List<Integer>();
        
        list.append(5);
        list.toFirst();
        assertThat(list.getContent()).isEqualTo(5);
    }

    /**
     * append() on non-empty
     */
    @Test
    void testAppendOnNonEmpty(){
        List<Integer> list = new List<Integer>();
        
        list.append(5);
        list.append(6);
        list.toLast();
        assertThat(list.getContent()).isEqualTo(6);
        list.append(7);
        list.toLast();
        assertThat(list.getContent()).isEqualTo(7);
    }

    /**
     * append() null on Empty
     */
    @Test
    void testAppendNullOnEmpty(){
        List<Integer> list = new List<Integer>();
        
        assertThat(list.isEmpty()).isTrue();
        list.append(null);
        assertThat(list.isEmpty()).isTrue();
    }

    /**
     * append() null on non-empty
     */
    @Test
    void testAppendNullOnNonEmpty(){
        List<Integer> list = new List<Integer>();
        
        list.append(5);
        list.append(null);
        assertThat(list.isEmpty()).isFalse();
        list.toLast();
        assertThat(list.getContent()).isEqualTo(5);
    }

    /*----- Test insert() -----*/

    /**
     * Durch Insert wurde ein Element hinzugefügt.
     * Aktuell muss dabei null bleiben und das Element hinzugefügt werden.
     */
    @Test
    void testInsertOnEmpty() {
        List<String> list = new List<>();

        list.insert("Hallo");

        assertThat(list.getContent()).isNull();
        list.toFirst();
        assertThat(list.getContent()).isEqualTo("Hallo");
    }

    /**
     * Ein Element wird mit dem Wert null übergeben.
     * Dieser darf nicht in die Liste hinzugefügt werden.
     */
    @Test
    void testInsertNull() {
        List<String> list = new List<>();

        list.insert("Hallo");
        list.toFirst();
        list.insert(null);
        assertThat(list.getContent()).isEqualTo("Hallo");

        list.toFirst();
        list.remove();
        
        assertThat(list.isEmpty()).isTrue();
    }

    /**
     * Zwei Werte werden der Liste hinzugefügt.
     * Der zweite Wert wird auf die Position des zuerst Hinzugefügten geschoben.
     * Nun muss dieser sich vor dem zuerst Hinzugefügten befinden, ansonsten ist die Einreihung bei dem Einfügen von Elementen falsch.
     */
    @Test
    void testInsertAtFirst() {
        List<String> list = new List<>();

        list.insert("Hallo");
        list.toFirst();
        list.insert("Moien");
        list.toFirst();
        
        assertThat(list.getContent()).isEqualTo("Moien");
    }

    /**
     * Drei Werte werden der Liste hinzugefügt.
     * Sollte nun der letzte gelöscht werden, muss das als zweites eingefügte Element zurückgegeben werden.
     * Ansonsten ist die Reihenfolge bei dem Einfügen falsch.
     */
    @Test
    void testInsertAtLast() {
        List<String> list = new List<>();

        list.insert("Hallo");
        list.toLast();
        list.insert("Moien");
        list.toLast();
        list.insert("Ciao");
        list.toLast();
        
        assertThat(list.getContent()).isEqualTo("Hallo");
        list.remove();
        list.toLast();
        assertThat(list.getContent()).isEqualTo("Ciao");
        list.remove();
        list.toLast();
        assertThat(list.getContent()).isEqualTo("Moien");
    }  
}