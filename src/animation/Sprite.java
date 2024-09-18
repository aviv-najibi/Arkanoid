package animation;

import biuoop.DrawSurface;
/**
 * name: aviv najibi
 * ID: 314621699
 * class name: geometry.Velocity
 * class explain: The animation.Sprite interface represents an object
 * that can be drawn on a DrawSurface and is updated over time.
 */
public interface Sprite {
  /**
   * Draws the sprite on a DrawSurface.
   *
   * @param d The DrawSurface on which the sprite will be drawn.
   */
  void drawOn(DrawSurface d);
  /**
   * Notifies the sprite that a unit of time has passed.
   * This method should be called in each game cycle to update the sprite's state.
   */
  void timePassed();
}
