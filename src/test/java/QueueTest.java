import org.testng.annotations.Test;
import static org.fest.assertions.api.Assertions.assertThat;

public class QueueTest {

  /**
   * enqueue() on filled Stack
   */
  @Test
  void testEnqueue() {
    Queue<String> queue = new Queue<>();

    queue.enqueue("Hallo");
    queue.enqueue("Test");
    queue.enqueue("Queue");

    assertThat(queue.front()).isEqualTo("Hallo");
  }

  /**
   * enqueue() null on filled Stack
   */
  @Test
  void testEnqueueNull() {
    Queue<String> queue = new Queue<>();

    queue.enqueue("Hallo");
    queue.enqueue(null);

    assertThat(queue.front()).isEqualTo("Hallo");
  }

  /**
   * enqueue() null on empty Stack
   */
  @Test
  void testEnqueueNullOnEmptyStack() {
    Queue<String> queue = new Queue<>();

    queue.enqueue(null);

    assertThat(queue.front()).isNull();
  }

  /**
   * enqueue() on empty Stack
   */
  @Test
  void testEnqueueEmptyStack() {
    Queue<String> queue = new Queue<>();

    queue.enqueue("Hallo");

    assertThat(queue.front()).isEqualTo("Hallo");
  }

  /**
   * enqueue() massive
   */
  @Test
  void testEnqueueMassive() {
    Queue<Integer> queue = new Queue<>();

    for (int i = 0; i < 10000; i++) queue.enqueue(i);

    for (int i = 0; i < 10000; i++) {
      assertThat(queue.front()).isEqualTo(i);
      queue.dequeue();
    }
  }

  /**
   * dequeue()
   */
  @Test
  void testDequeueMassive() {
    Queue<Integer> queue = new Queue<>();

    for (int i = 0; i < 100; i++) queue.enqueue(i);
    for (int i = 100; i > 1; i--) queue.dequeue();

    assertThat(queue.isEmpty()).isFalse();

    queue.dequeue();
    assertThat(queue.isEmpty()).isTrue();
  }

  /**
   * isEmpty()
   */
  @Test
  void testIsEmpty() {
    Queue<Integer> queue = new Queue<>();
    queue.enqueue(1);
    assertThat(queue.isEmpty()).isFalse();
  }

  /**
   * isEmpty() on empty queue
   */
  @Test
  void testIsEmptyOnEmpty() {
    Queue<Integer> queue = new Queue<>();
    assertThat(queue.isEmpty()).isTrue();
  }

  /**
   * front()
   */
  @Test
  void testFront() {
    Queue<Integer> queue = new Queue<>();
    queue.enqueue(1);

    assertThat(queue.front()).isEqualTo(1);
  }

  /**
   * front() on empty queue
   */
  @Test
  void testFrontOnEmpty() {
    Queue<Integer> queue = new Queue<>();

    assertThat(queue.front()).isNull();
  }
}
