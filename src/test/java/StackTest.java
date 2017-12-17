import org.testng.annotations.Test;
import static org.fest.assertions.api.Assertions.assertThat;

public class StackTest {
  /**
   * push() valid value
   */
  @Test
  public void testPush() {
    Stack<String> stack = new Stack<>();

    stack.push("100");
  }

  /**
   * push() a lot of valid values
   */
  @Test
  public void testPushMassive() {
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < 1000000; i++) stack.push(i);
  }

  /**
   * push() invalid value
   */
  @Test
  public void testPushNull() {
    Stack<String> stack = new Stack<>();

    stack.push("1");
    stack.push(null);

    assertThat(stack.top()).isEqualTo("1");
  }

  /**
   * pop() on filled Stack
   */
  @Test
  public void testPopFilledStack() {
    Stack<String> stack = new Stack<>();

    stack.push("1");
    stack.push("2");

    stack.pop();

    assertThat(stack.top()).isEqualTo("1");
  }

  /**
   * pop() on empty Stack
   */
  @Test
  public void testPopEmptyStack() {
    Stack<Integer> stack = new Stack<>();

    stack.pop();
  }

  /**
   * pop() massive
   */
  @Test
  public void testPopMassive() {
    Stack<String> stack = new Stack<>();

    for (int i = 0; i <= 100000; i++) stack.push("" + i);

    for (int i = 100000; i > 0; i--) {
      assertThat(stack.top()).isEqualTo("" + i);
      stack.pop();
    }
  }

  /**
   * top() on single value Stack
   */
  @Test
  public void testTopSingleValue() {
    Stack<String> stack = new Stack<>();

    stack.push("1");

    assertThat(stack.top()).isEqualTo("1");
  }

  /**
   * top() on Stack
   */
  @Test
  public void testTop() {
    Stack<String> stack = new Stack<>();

    stack.push("1");
    stack.push("2");

    assertThat(stack.top()).isEqualTo("2");
  }

  /**
   * top() on empty Stack
   */
  @Test
  public void testTopEmpty() {
    Stack<String> stack = new Stack<>();

    assertThat(stack.top()).isNull();
  }

  /**
   * isEmpty() on empty Stack
   */
  @Test
  public void testIsEmptyEmptyStack() {
    Stack<String> stack = new Stack<>();

    assertThat(stack.isEmpty()).isTrue();
  }

  /**
   * isEmpty() on non-empty Stack
   */
  @Test
  public void testIsEmpty() {
    Stack<String> stack = new Stack<>();
    stack.push("Test");

    assertThat(stack.isEmpty()).isFalse();
  }

}
