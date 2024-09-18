package animation;
import geometry.Point;

/**
 * name: aviv najibi
 * ID: 314621699
 * class name: geometry.Velocity
 * class explain: The animation.CollisionInfo class represents information about a
 * collision point and the collidable object involved in the collision.
 * It encapsulates the collision point and the collidable object for easy retrieval.
 */
public class CollisionInfo {
  // The point at which the collision occurred.
  private Point collisionP;
  // The collidable object involved in the collision.
  private Collidable collisionC;
  /**
   * Constructs an animation.CollisionInfo object with the specified collision point and collidable object.
   *
   * @param collisionP The point at which the collision occurred.
   * @param collisionC The collidable object involved in the collision.
   */
  public CollisionInfo(Point collisionP, Collidable collisionC) {
    this.collisionP = collisionP;
    this.collisionC = collisionC;
  }
  /**
   * Gets the point at which the collision occurred.
   *
   * @return The collision point.
   */
  public Point collisionPoint() {
    return this.collisionP;
  }
  /**
   * Gets the collidable object involved in the collision.
   *
   * @return The collidable object.
   */
  public Collidable collisionObject() {
    return this.collisionC;
  }
}
