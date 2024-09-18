package gameConfig;
import animation.HitListener;
import geometry.Ball;
/**
 * name: aviv najibi
 * ID: 314621699
 * class name: ScoreTrackingListener
 * class explain: The ScoreTrackingListener class implements the HitListener interface to track hits on blocks
 * and update the score accordingly.
 */
public class ScoreTrackingListener implements HitListener {
  private Counter currentScore;
  /**
   * Constructs a new ScoreTrackingListener with the specified score counter.
   *
   * @param scoreCounter The Counter object representing the current score.
   */
  public  ScoreTrackingListener(Counter scoreCounter) {
    this.currentScore = scoreCounter;
  }
  /**
   * Updates the score when a block is hit by a ball.
   *
   * @param beingHit The block being hit.
   * @param hitter   The ball that hits the block.
   */
  public void hitEvent(Block beingHit, Ball hitter) {
    this.currentScore.increase(5);
  }
}