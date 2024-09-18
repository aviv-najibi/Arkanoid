package geometry;

/**
 * name: aviv najibi
 * ID: 314621699
 * class name: geometry.Point
 * class explain: Represents a 2D point with x and y coordinates.
 */
public class Point {
  /**
   * x value of the point.
   */
  private double x;
  /**
   * y value of the point.
   */
  private double y;
  /**
   * Constructs a new geometry.Point with the given x and y coordinates.
   *
   * @param x1 x value of the point.
   * @param y1 y value of the point.
   */
  public Point(double x1, double y1) {
    this.x = x1;
    this.y = y1;
  }
  /**
   * Calculates the Euclidean distance between this point and another point.
   *
   * @param other The other point to calculate the distance to.
   * @return The Euclidean distance between this point and the specified point.
   */
  public double distance(Point other) {
    return Math.sqrt(((this.x - other.getX())
        * (this.x - other.getX()))
        + ((this.y - other.getY()) * (this.y - other.getY())));
  }
  /**
   * Checks if this point is equal to another point.
   *
   * @param other The other point to compare with.
   * @return True if the points are equal, false otherwise.
   */
  public boolean equals(Point other) {
    if (other == null) {
      return false;
    }
    boolean mach = false;
    if ((x - other.getX() == 0) && (y - other.getY() == 0)) {
      mach = true;
    }
    return mach;
  }
  /**
   * Gets the x-coordinate of this point.
   *
   * @return The x-coordinate.
   */
  public double getX() {
    return this.x;
  }
  /**
   * Gets the y-coordinate of this point.
   *
   * @return The y-coordinate.
   */
  public double getY() {
    return this.y;
  }
}
