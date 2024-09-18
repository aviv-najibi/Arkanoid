package animation;
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;
/**
 * name: aviv najibi
 * ID: 314621699
 * class name: geometry.Velocity
 * class explain: The animation.SpriteCollection class represents a collection of sprites in a game.
 * It provides methods for adding sprites, updating their time, and drawing them on a DrawSurface.
 */
public class SpriteCollection {
  // A list to store the sprites in the collection.
  private List<Sprite> sprites;
  /**
   * Constructs a new animation.SpriteCollection.
   * Initializes an empty list to store sprites.
   */
  public SpriteCollection() {
    // Create a new ArrayList to store sprites
    this.sprites = new ArrayList<>();
  }
  /**
   * Adds a sprite to the collection.
   *
   * @param s The sprite to be added.
   */
  public void addSprite(Sprite s) {
    this.sprites.add(s);
  }
  /**
   * Calls the timePassed() method on all sprites in the collection.
   * This method should be called in each game cycle to update the sprites.
   */
  public void notifyAllTimePassed() {
    for (int i = 0; i < this.sprites.size(); i++) {
      sprites.get(i).timePassed();
    }
  }
  /**
   * Calls the drawOn(d) method on all sprites in the collection.
   * This method should be called in each frame to draw the sprites on a DrawSurface.
   *
   * @param d The DrawSurface on which the sprites will be drawn.
   */
  public void drawAllOn(DrawSurface d) {
    for (int i = 0; i < this.sprites.size(); i++) {
      this.sprites.get(i).drawOn(d);
    }
  }
  /**
   * Gets the list of sprites in the collection.
   *
   * @return The list of sprites.
   */
  public List<Sprite> getSprites() {
    return sprites;
  }
}