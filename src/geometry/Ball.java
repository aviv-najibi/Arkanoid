package geometry;
import animation.CollisionInfo;
import animation.Sprite;
import biuoop.DrawSurface;
import gameConfig.Game;
import gameConfig.GameEnvironment;
import java.awt.Color;

/**
 * name: aviv najibi
 * ID: 314621699
 * class name: geometry.Ball
 * class explain: Represents a 2D ball with point, radius size, velocity and color coordinates.
 */
public class Ball implements Sprite {
  private double boundaryX;
  private double boundaryY;
  private Velocity v;
  private Point p;
  private int size;
  private java.awt.Color color;
  private GameEnvironment ge;
  /**
   * Constructs a new geometry.Ball with a given center point, radius, and color.
   *
   * @param center The center point of the ball.
   * @param r      The radius of the ball.
   * @param color  The color of the ball.
   * @param ge     The game environment in which the ball operates.
   */
  public Ball(Point center, int r, java.awt.Color color, GameEnvironment ge) {
    this.p = center;
    this.size = r;
    this.color = color;
    this.ge = ge;
  }
  /**
   * Constructs a new geometry.Ball with given x, y coordinates, radius, and color.
   *
   * @param x     The x-coordinate of the ball's center.
   * @param y     The y-coordinate of the ball's center.
   * @param r     The radius of the ball.
   * @param color The color of the ball.
   * @param ge    The game environment in which the ball operates.
   */
  public Ball(int x, int y, int r, java.awt.Color color, GameEnvironment ge) {
    this.p = new Point(x, y);
    this.size = r;
    this.color = color;
    this.ge = ge;
  }
  /**
   * Gets the x-coordinate of the ball's center.
   *
   * @return The x-coordinate.
   */
  public int getX() {
    return (int) this.p.getX();
  }
  /**
   * Gets the y-coordinate of the ball's center.
   *
   * @return The y-coordinate.
   */
  public int getY() {
    return (int) this.getY();
  }
  /**
   * Gets the x-coordinate of the ball's boundary.
   *
   * @return The x-coordinate of the boundary.
   */
  public double getboundaryX() {
    return this.boundaryX;
  }
  /**
   * Gets the x-coordinate of the ball's boundary.
   *
   * @return The x-coordinate of the boundary.
   */
  public double getboundaryY() {
    return this.boundaryY;
  }
  /**
   * Gets the y-coordinate of the ball's boundary.
   *
   * @return The y-coordinate of the boundary.
   */
  public int getSize() {
    return this.size;
  }
  /**
   * Gets the color of the ball.
   *
   * @return The color.
   */
  public java.awt.Color getColor() {
    return this.color;
  }
  /**
   * Draws the ball on the given DrawSurface.
   *
   * @param surface The DrawSurface on which to draw the ball.
   */
  public void drawOn(DrawSurface surface) {
    surface.setColor(this.color);
    surface.fillCircle((int) this.p.getX(), (int) this.p.getY(), this.size);
    surface.drawCircle((int) this.p.getX(), (int) this.p.getY(), this.size);
  }
  /**
   * Sets the velocity of the ball.
   *
   * @param v The new velocity.
   */
  public void setVelocity(Velocity v) {
    this.v = v;
  }
  /**
   * Sets the velocity of the ball using individual speed components.
   *
   * @param dx The change in x-coordinate per time unit.
   * @param dy The change in y-coordinate per time unit.
   */
  public void setVelocity(double dx, double dy) {
    this.v = new Velocity(dx, dy);
  }
  /**
   * Gets the velocity of the ball.
   *
   * @return The velocity.
   */
  public Velocity getVelocity() {
    return this.v;
  }
  /**
   * Moves the ball one step according to its current velocity.
   * Handles collisions with boundaries and changes in direction.
   */
  public void moveOneStep() {
    double proximity = 1;
    double dx = this.v.getDx();
    double dy = this.v.getDy();
    CollisionInfo ci;
    // Calculate trajectory end point.
    Line trajectory = new Line(this.p, this.v.applyToPoint(this.p));
    ci = this.ge.getClosestCollision(trajectory);
    // If the ball has not reached a collisable object or the GUI frame, move normally.
    if (ci == null) {
      this.p = this.v.applyToPoint(this.p);
    } else {
      double nextX, nextY;
      if (this.p.getX() <= ci.collisionPoint().getX()) {
        nextX = ci.collisionPoint().getX() - proximity;
      } else {
        nextX = ci.collisionPoint().getX() + proximity;
      }
      if (this.p.getY() <= ci.collisionPoint().getY()) {
        nextY = ci.collisionPoint().getY() - proximity;
      } else {
        nextY = ci.collisionPoint().getY() + proximity;
      }
      this.p = new Point(nextX, nextY);
      this.v = ci.collisionObject().hit(this, ci.collisionPoint(), this.v);
    }
  }
  boolean inPaddle(CollisionInfo ci) {
    if (ci.collisionPoint().getY() >= ci.collisionObject().getCollisionRectangle().getUpperLeft().getY()
        && ci.collisionPoint().getX() <= 600) {
      return true;
    }
    return false;
  }
  /**
   * Implements the timePassed method from the animation.Sprite interface.
   * Calls the moveOneStep method to update the ball's position.
   */
  public void timePassed() {
    this.moveOneStep();
  }
  /**
   * Adds the ball as a sprite to the specified game.
   *
   * @param g The game to which the ball is added.
   */
  public void addToGame(Game g) {
    g.addSprite(this);
  }
  /**
   * Sets the color of the ball.
   *
   * @param c The new color.
   */
  public void setColor(Color c) {
    this.color = c;
  }
}
