package geometry;
/**
 * name: aviv najibi
 * ID: 314621699
 * class name: geometry.Velocity
 * class explain: Represents a 2D velocity with components dx and dy.
 */
public class Velocity {
  // Components of the velocity
  private double dx;
  private double dy;
  /**
   * Constructs a velocity with the given components.
   *
   * @param dx1 The x-component of the velocity.
   * @param dy1 The y-component of the velocity.
   */
  public Velocity(double dx1, double dy1) {
    this.dx = dx1;
    this.dy = dy1;
  }
  /**
   * Creates a velocity from an angle in radians and speed.
   *
   * @param angle The angle in radians.
   * @param speed The speed of the velocity.
   */
  public  Velocity(int angle, double speed) {
    double dx = Math.cos(Math.toRadians(angle)) * speed;
    double dy = Math.sin(Math.toRadians(angle)) * speed;
    this.dx = dx;
    this.dy = dy;
  }
  /**
   * Gets the x-component of the velocity.
   *
   * @return The x-component of the velocity.
   */
  public double getDx() {
    return this.dx;
  }
  /**
   * Gets the y-component of the velocity.
   *
   * @return The y-component of the velocity.
   */
  public double getDy() {
    return this.dy;
  }

  /**
   * Applies the velocity to a point and returns the new point.
   *
   * @param p The point to which the velocity is applied.
   * @return A new point resulting from applying the velocity to the given point.
   */
  public Point applyToPoint(Point p) {
    return new Point(p.getX() + dx, p.getY() + dy);
  }
}
