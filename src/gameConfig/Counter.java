package gameConfig;
/**
 * name: aviv najibi
 * ID: 314621699
 * class name: Counter
 * class explain: The BlockRemover class implements the HitListener
 * interface and is responsible for removing blocks from the game upon collision.
 * It keeps track of the remaining blocks and removes them from the game when hit.
 */
public class Counter {
  private int num;
  /**
   * Constructs a Counter with an initial count of zero.
   */
  public Counter() {
    this.num = 0;
  }
  /**
   * Increases the counter by the specified number.
   *
   * @param number The number to increase the counter by.
   */
  public void increase(int number) {
    this.num += number;
  }
  /**
   * Decreases the counter by the specified number.
   *
   * @param number The number to decrease the counter by.
   */
  public void decrease(int number) {
    this.num -= number;
  }
  /**
   * Gets the current count value.
   *
   * @return The current count value.
   */
  public int getValue() {
    return this.num;
  }
}
