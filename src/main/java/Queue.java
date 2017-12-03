/**
 * Created by simon.knott on 17.11.2017.
 */
public class Queue<ContentType> {
    class Node<ContentType> {
      private ContentType content;
      private Node<ContentType> next;

      /**
       *
       * @param content
       */
      public Node(ContentType content) {
        this.content = content;
      }

      public ContentType getContent() {
        return content;
      }

      public void setContent(ContentType content) {
        this.content = content;
      }

      public Node<ContentType> getNext() {
        return next;
      }

      public void setNext(Node<ContentType> next) {
        this.next = next;
      }
    }

    /*
     * Attributes
     */
    private Node<ContentType> head;
    private Node<ContentType> tail;

    /*
     * # Constructor
     */

    /**
     * Constructs an empty Queue.
     */
    Queue() {}

    /*
     * # Interface
     */
    /**
     * ## Standard
     */

    public void enqueue(ContentType value) {
      if (value == null) return;

      Node<ContentType> node = new Node<>(value);

      if (isEmpty()) {
        this.head = node;
        this.tail = node;
      } else {
        tail.setNext(node);
        this.tail = node;
      }
    }

    /**
     * Pop the first value off the stack
     * @return first value
     */
    public void dequeue() {
        if (isEmpty()) return;

        head = head.getNext();
    }

    /**
     * Get Value of front Node without removing it
     * @return null if empty
     */
    public ContentType front() {
        if (isEmpty()) return null;

        return head.getContent();
    }

    /**
     * Checks if the stack is empty
     * @return true if empty
     */
    public boolean isEmpty() {
        return head == null;
    }
}
