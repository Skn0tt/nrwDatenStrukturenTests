import org.testng.annotations.Test;
import static org.fest.assertions.api.Assertions.assertThat;

public class PriorityQueueTest {

  /**
   * isEmpty() on filled Queue
   */
  @Test
  void testIsEmpty() {
    PriorityQueue<String> queue = new PriorityQueue<>();
    queue.enqueue("Hallo", 0);

    assertThat(queue.isEmpty()).isFalse();
  }

  /**
   * isEmpty() on empty PriorityQueue
   */
  @Test
  void testIsEmptyOnEmpty() {
    PriorityQueue<String> queue = new PriorityQueue<>();

    assertThat(queue.isEmpty()).isTrue();
  }

  /**
   * isEmpty() on PriorityQueue with null value
   */
  @Test
  void testIsEmptyOnNull() {
    PriorityQueue<String> queue = new PriorityQueue<>();
    queue.enqueue(null, 0);

    assertThat(queue.isEmpty()).isTrue();
  }

  /**
   * enqueue() a high priority value
   */
  @Test
  void testEnqueueHighPriority() {
    PriorityQueue<String> queue = new PriorityQueue<>();
    queue.enqueue("Hallo", 10);
    queue.enqueue("Test", 20);

    assertThat(queue.front()).isEqualTo("Test");
  }

  /**
   * enqueue() a low priority value
   */
  @Test
  void testEnqueueLowPriority() {
    PriorityQueue<String> queue = new PriorityQueue<>();
    queue.enqueue("Hallo", 10);
    queue.enqueue("Test", 5);

    assertThat(queue.front()).isEqualTo("Hallo");
  }

  /**
   * enqueue() a zero priority value
   */
  @Test
  void testEnqueueZeroPriority() {
    PriorityQueue<String> queue = new PriorityQueue<>();
    queue.enqueue("Hallo", 10);
    queue.enqueue("Test", 0);

    assertThat(queue.front()).isEqualTo("Hallo");
  }

  /**
   * enqueue() a zero priority value on empty queue
   */
  @Test
  void testEnqueueZeroPriorityOnEmpty() {
    PriorityQueue<String> queue = new PriorityQueue<>();
    queue.enqueue("Test", 0);

    assertThat(queue.front()).isEqualTo("Test");
  }

  /**
   * enqueue() same priority
   * should enqueue() second behind first
   */
  @Test
  void testEnqueueSamePriority() {
    PriorityQueue<String> queue = new PriorityQueue<>();
    queue.enqueue("Hallo", 10);
    queue.enqueue("Test", 10);

    assertThat(queue.front()).isEqualTo("Hallo");
  }

  /**
   * enqueue() same priority zero
   * should enqueue() second behind first
   */
  @Test
  void testEnqueueSamePriorityZero() {
    PriorityQueue<String> queue = new PriorityQueue<>();
    queue.enqueue("Hallo", 0);
    queue.enqueue("Test", 0);

    assertThat(queue.front()).isEqualTo("Hallo");
  }

  /**
   * enqueue() invalid prio -1
   * should enqueue() second behind first
   */
  @Test
  void testEnqueueInvalidPrio() {
    PriorityQueue<String> queue = new PriorityQueue<>();
    queue.enqueue("Hallo", -1);
    queue.enqueue("Test", 0);

    assertThat(queue.front()).isEqualTo("Hallo");
  }

  /**
   * front() on empty PriorityQueue
   */
  @Test
  void testFrontOnEmpty() {
    PriorityQueue<String> queue = new PriorityQueue<>();

    assertThat(queue.front()).isNull();
  }

  /**
   * frontPriority()
   */
  @Test
  void testFrontPriority() {
    PriorityQueue<String> queue = new PriorityQueue<>();
    queue.enqueue("Hallo", 0);
    queue.enqueue("Hallo", 1);

    assertThat(queue.frontPriority()).isEqualTo(1);
  }

  /**
   * frontPriority() on empty
   */
  @Test
  void testFrontPriorityOnEmpty() {
    PriorityQueue<String> queue = new PriorityQueue<>();

    assertThat(queue.frontPriority()).isEqualTo(-1);
  }

  /**
   * frontPriority() on null value
   */
  @Test
  void testFrontPriorityOnNull() {
    PriorityQueue<String> queue = new PriorityQueue<>();
    queue.enqueue(null, 10);

    assertThat(queue.frontPriority()).isEqualTo(-1);
  }

  /**
   * frontPriority() after dequeue()
   */
  @Test
  void testFrontPriorityAfterDequeue() {
    PriorityQueue<String> queue = new PriorityQueue<>();
    queue.enqueue("Hallo", 10);
    queue.enqueue("Test", 11);

    queue.dequeue();

    assertThat(queue.frontPriority()).isEqualTo(10);
  }

  /**
   * dequeue() on same priority
   */
  @Test
  void testDequeueSamePriority() {
    PriorityQueue<String> queue = new PriorityQueue<>();

    queue.enqueue("Message 1", 0);
    queue.enqueue("Message 2", 0);

    queue.dequeue();

    assertThat(queue.front()).isEqualTo("Message 2");
  }

  /**
   * dequeue() on null
   */
  @Test
  void testDequeueOnNullValues() {
    PriorityQueue<String> queue = new PriorityQueue<>();

    queue.enqueue(null, 0);
    queue.enqueue(null, 0);

    queue.dequeue();

    assertThat(queue.front()).isNull();
  }

  /**
   * dequeue() all
   */
  @Test
  void testDequeueAll() {
    PriorityQueue<String> queue = new PriorityQueue<>();

    queue.enqueue("Message 1", 0);
    queue.enqueue("Message 1", 0);
    queue.dequeue();
    queue.dequeue();

    assertThat(queue.front()).isNull();
  }

  /**
   * dequeue() on empty
   */
  @Test
  void testDequeueOnEmpty() {
    PriorityQueue<String> queue = new PriorityQueue<>();

    queue.dequeue();

    assertThat(queue.front()).isNull();
  }

  /**
   * enqueue() massive with same priority
   * should stay in order
   */
  @Test
  void testEnqueueMassiveSamePrio() {
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for (int i = 0; i < 100; i++) queue.enqueue(i, 0);

    for (int i = 0; i < 100; i++) {
      assertThat(queue.front()).isEqualTo(i);

      queue.dequeue();
    }
  }

  /**
   * enqueue() massive with ascending priority
   * should reverse order
   */
  @Test
  void testEnqueueMassiveAscendingPriority() {
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for (int i = 0; i <= 100; i++) queue.enqueue(i, i);

    for (int i = 100; i > 0; i--) {
      assertThat(queue.front()).isEqualTo(i);
      assertThat(queue.frontPriority()).isEqualTo(i);

      queue.dequeue();
    }
  }
  /**
   * enqueue() massive with descending priority
   * should stay in order
   */
  @Test
  void testEnqueueDescendingPriority() {
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    final int amount = 100;

    for (int i = 0; i <= amount; i++) queue.enqueue(i, amount - i);

    for (int i = 0; i <= amount; i++) {
      assertThat(queue.front()).isEqualTo(i);
      assertThat(queue.frontPriority()).isEqualTo(amount - i);

      queue.dequeue();
    }
  }

}
