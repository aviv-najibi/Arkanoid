package gameConfig;
import animation.Collidable;
import animation.CollisionInfo;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import java.util.ArrayList;
import java.util.List;
/**
 * name: aviv najibi
 * ID: 314621699
 * class name: geometry.Velocity
 * class explain: The gameConfig.GameEnvironment class represents the environment of a game,
 * containing collidable objects and the game frame.
 */
public class GameEnvironment {
  // List containing all the collidable objects in the game environment.
  private List<Collidable> collidables;
  // The rectangle representing the game frame.
  private Rectangle gameFrame;
  /**
   * Constructs a new gameConfig.GameEnvironment with an empty list of collidables and a specified game frame rectangle.
   */
  public GameEnvironment() {
    List<Collidable> c = new ArrayList<Collidable>();
    Point p = new Point(0, 0);
    Rectangle r = new Rectangle(p, 800, 600);
    this.collidables = c;
    this.gameFrame = r;
  }
  /**
   * Gets the rectangle representing the game frame.
   *
   * @return The game frame rectangle.
   */
  public Rectangle getGameFrame() {
    return this.gameFrame;
  }
  /**
   * Adds a new collidable object to the List of collidable objects.
   *
   * @param c - New collidable object to be added.
   */
  public void addCollidable(Collidable c) {
    this.collidables.add(c);
  }
  /**
   * Assumes an object moving along a trajectory. If this object will not collide with any of the collidables in this
   * collection, return null. Otherwise, return information about the closest collision that is going to occur.
   *
   * @param trajectory - The line along which the object is moving.
   * @return The animation.CollisionInfo of the closest collision or null if there is no collision.
   */
  public CollisionInfo getClosestCollision(Line trajectory) {
    CollisionInfo closestCollision;
    List<CollisionInfo> ci = new ArrayList<>();
    List<Point> closestCollisions = new ArrayList<>();
    Collidable closestCollidable = null;
    Point collision;
    for (Collidable c : this.collidables) {
      collision = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
      if (collision != null) {
        ci.add(new CollisionInfo(collision, c));
      }
    }
    if (ci.isEmpty()) {
      return null;
    }
    closestCollision = ci.get(0);
    for (CollisionInfo c : ci) {
      if (c.collisionPoint().distance(trajectory.start())
          < closestCollision.collisionPoint().distance(trajectory.start())) {
        closestCollision = c;
      }
    }
    return closestCollision;
  }
  /**
   * Finds the intersection point between the game environment and a trajectory.
   *
   * @param trajectory - The line along which the object is moving.
   * @return The intersection point with the game environment, or null if there is no intersection.
   */
  public Point gameEnvironmentIntersection(Line trajectory) {
    return trajectory.closestIntersectionToStartOfLine(new Rectangle(this.gameFrame.getUpperLeft(),
        this.gameFrame.getWidth(), this.gameFrame.getHeight()));
  }
  /**
   * Retrieves the list of collidable objects currently present in the game environment.
   *
   * @return A List containing all the collidable objects.
   */
  public List<Collidable> getCollidables() {
    return collidables;
  }
}
