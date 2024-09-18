package gameConfig;
import animation.HitListener;
import geometry.Ball;
/**
 * name: aviv najibi
 * ID: 314621699
 * class name: BallRemover
 * class explain: The BlockRemover class implements the HitListener
 * interface and is responsible for removing blocks from the game upon collision.
 * It keeps track of the remaining blocks and removes them from the game when hit.
 */
public class BlockRemover implements HitListener {
  private Game game;
  private Counter remainingBlocks;
  /**
   * Constructs a BlockRemover with the specified game and remaining blocks counter.
   *
   * @param game            The game from which blocks are removed.
   * @param remainingBlocks The counter for remaining blocks.
   */
  public BlockRemover(Game game, Counter remainingBlocks) {
    this.game = game;
    this.remainingBlocks = remainingBlocks;
  }
  /**
   * Handles the hit event by decreasing the remaining blocks count,
   * changing the hitter's color, and removing the block from the game.
   * Also removes this listener from the block being removed.
   *
   * @param beingHit The block being hit.
   * @param hitter   The ball that hits the block.
   */
  public void hitEvent(Block beingHit, Ball hitter) {
    this.remainingBlocks.decrease(1);
    hitter.setColor(beingHit.getColor());
    beingHit.removeFromGame(this.game);
  }
  /**
   * Gets the counter for remaining blocks.
   *
   * @return The counter for remaining blocks.
   */
  public Counter getRemainingBlocks() {
    return remainingBlocks;
  }
}