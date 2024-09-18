package animation;
import biuoop.DrawSurface;
import geometry.Ball;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

/**
 * name: aviv najibi
 * ID: 314621699
 * class name: gameConfig.Block
 * class explain: The animation.Collidable interface represents an object that can be collided with.
 * It defines methods for retrieving the collision shape, handling collisions, and drawing the object on a DrawSurface.
 */
public interface Collidable {
  /**
   * Returns the "collision shape" of the object.
   *
   * @return The collision rectangle representing the shape of the object.
   */
  Rectangle getCollisionRectangle();
  /**
   * Handles a collision with the block and returns the new velocity after the collision.
   *
   * @param hitter          The ball that hit the block.
   * @param collisionPoint  The point at which the collision occurs.
   * @param currentVelocity The current velocity of the colliding object.
   * @return The new velocity after the collision.
   */
  Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
  /**
   * Draws the collidable object on a DrawSurface.
   *
   * @param d The DrawSurface on which the object will be drawn.
   */
  void drawOn(DrawSurface d);
}
