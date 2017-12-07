import org.testng.annotations.Test;
import static org.fest.assertions.api.Assertions.assertThat;

public class QueueTest {
  @Test
  void testEnqueue1() {
    Queue<String> queue = new Queue<>();

    queue.enqueue("Hallo");
    queue.enqueue(null);

    assertThat(queue.front()).isEqualTo("Hallo");
  }

  @Test
  void testEnqueue3() {
    Queue<Integer> queue = new Queue<>();

    for (int i = 0; i < 100; i++) queue.enqueue(i);

    for (int i = 0; i < 100; i++) {
      assertThat(queue.front()).isEqualTo(i);
      queue.dequeue();
    }
  }

  @Test
  void testIsEmpty1() {
    Queue<Integer> queue = new Queue<>();
    assertThat(queue.isEmpty()).isTrue();
  }

  @Test
  void testIsEmpty2() {
    Queue<Integer> queue = new Queue<>();
    queue.enqueue(1);
    assertThat(queue.isEmpty()).isFalse();
  }
}
