package gameConfig;
import animation.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * name: aviv najibi
 * ID: 314621699
 * class name: ScoreIndicator
 * class explain: The ScoreIndicator class represents an indicator of the player's score in a game.
 * It implements the Sprite interface, allowing it to be drawn onto a DrawSurface
 */
public class ScoreIndicator implements Sprite {
  private Block block;
  private Counter score;
  /**
   * Constructs a new ScoreIndicator with the specified block and score counter.
   *
   * @param block The block used as a background for displaying the score indicator.
   * @param score The Counter object representing the player's score.
   */
  public ScoreIndicator(Block block, Counter score) {
    this.block = block;
    this.score = score;
  }
  /**
   * Draws the score indicator on the specified DrawSurface.
   *
   * @param d The DrawSurface on which the score indicator will be drawn.
   */
  @Override
  public void drawOn(DrawSurface d) {
    this.block.drawOn(d);
    d.setColor(Color.black);
    d.drawText(370, 15, "Score: " + this.score.getValue(), 15);
  }
  /**
   * Placeholder method; not used in this class.
   * This method is provided to fulfill the requirements of the Sprite interface.
   */
  public void timePassed() {
  }
}
