package gameConfig;
import animation.HitListener;
import geometry.Ball;
/**
 * name: aviv najibi
 * ID: 314621699
 * class name: BallRemover
 * class explain: The SpriteCollection class represents a collection of sprites in a game.
 * It provides methods for adding sprites, updating their time, and drawing them on a DrawSurface.
 */
public class BallRemover implements HitListener {
  private Game game;
  private Counter remainingBalls;
  /**
   * Constructs a BallRemover with the specified game and remaining balls counter.
   *
   * @param game           The game from which balls are removed.
   * @param remainingBalls The counter for remaining balls.
   */
  public BallRemover(Game game, Counter remainingBalls) {
    this.game = game;
    this.remainingBalls = remainingBalls;
  }
  /**
   * Handles the hit event by decreasing the remaining balls count and removing the ball from the game.
   *
   * @param beingHit The block being hit.
   * @param hitter   The ball that hits the block.
   */
  public void hitEvent(Block beingHit, Ball hitter) {
    this.remainingBalls.decrease(1);
    game.removeSprite(hitter);
  }
  /**
   * Gets the counter for remaining balls.
   *
   * @return The counter for remaining balls.
   */
  public Counter getRemainingBalls() {
    return remainingBalls;
  }
}
