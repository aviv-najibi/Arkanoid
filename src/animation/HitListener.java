package animation;
import gameConfig.Block;
import geometry.Ball;
/**
 * name: aviv najibi
 * ID: 314621699
 * class name: HitListener
 * class explain: The HitListener interface represents an object that listens for hit events.
 * It defines a method to be called when a block is hit by a ball.
 */
public interface HitListener {
  /**
   * This method is called whenever the beingHit object is hit by the hitter ball.
   *
   * @param beingHit The Block that is being hit.
   * @param hitter   The Ball that is doing the hitting.
   */
  void hitEvent(Block beingHit, Ball hitter);
}
