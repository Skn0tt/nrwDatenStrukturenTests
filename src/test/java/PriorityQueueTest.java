import org.testng.annotations.Test;
import static org.fest.assertions.api.Assertions.assertThat;

public class PriorityQueueTest {
  @Test
  void testIsEmpty1() {
    PriorityQueue<String> queue = new PriorityQueue<>();

    assertThat(queue.isEmpty()).isTrue();
  }

  @Test
  void testIsEmpty2() {
    PriorityQueue<String> queue = new PriorityQueue<>();
    queue.enqueue("Hallo", 0);

    assertThat(queue.isEmpty()).isFalse();
  }

  /**
   * Tests wether Inserting at the right priority works
   */
  @Test
  void testFront1() {
    PriorityQueue<String> queue = new PriorityQueue<>();
    queue.enqueue("Hallo", 0);
    queue.enqueue("Test", 0);

    assertThat(queue.front()).isEqualTo("Hallo");
  }

  /**
   * Tests Empty Queue
   * Should return null
   */
  @Test
  void testFront2() {
    PriorityQueue<String> queue = new PriorityQueue<>();

    assertThat(queue.front()).isNull();
  }

  @Test
  void testFrontPriority1() {
    PriorityQueue<String> queue = new PriorityQueue<>();
    queue.enqueue("Hallo", 0);
    queue.enqueue("Hallo", 1);

    assertThat(queue.frontPriority()).isEqualTo(1);
  }

  @Test
  void testDequeue1() {
    PriorityQueue<String> queue = new PriorityQueue<>();

    queue.enqueue("Message 1", 0);
    queue.enqueue("Message 2", 0);

    queue.dequeue();

    assertThat(queue.front()).isEqualTo("Message 2");
  }

  @Test
  void testDequeue2() {
    PriorityQueue<String> queue = new PriorityQueue<>();

    queue.enqueue("Message 1", 0);
    queue.dequeue();

    assertThat(queue.front()).isNull();
  }

  @Test
  void testDequeue3() {
    PriorityQueue<String> queue = new PriorityQueue<>();

    queue.dequeue();

    assertThat(queue.front()).isNull();
  }

  @Test
  void testEnqueue1() {
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for (int i = 0; i < 100; i++) queue.enqueue(i, 0);

    for (int i = 0; i < 100; i++) {
      assertThat(queue.front()).isEqualTo(i);

      queue.dequeue();
    }
  }

  @Test
  void testEnqueue2() {
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for (int i = 0; i <= 100; i++) queue.enqueue(i, i);

    for (int i = 100; i > 0; i--) {
      assertThat(queue.front()).isEqualTo(i);

      queue.dequeue();
    }
  }
}
