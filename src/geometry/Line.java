package geometry;

import java.util.List;

/**
 * name: aviv najibi
 * ID: 314621699
 * class name: geometry.Line
 * class explain: The geometry.Line class represents a line segment in 2D space defined by its start and end points.
 * It provides methods to calculate the length, find the middle point, get the starting and ending points,
 * check for intersection with other lines, find intersection points, and determine equality with another line.
 */
public class Line {
  private Point start;
  private Point end;
  /**
   * Constructs a line segment using two given points.
   *
   * @param start The starting point of the line.
   * @param end   The ending point of the line.
   */
  public Line(Point start, Point end) {
    this.start = start;
    this.end = end;
  }
  /**
   * Constructs a line segment using coordinates of two points.
   *
   * @param x1 The x-coordinate of the starting point.
   * @param y1 The y-coordinate of the starting point.
   * @param x2 The x-coordinate of the ending point.
   * @param y2 The y-coordinate of the ending point.
   */
  public Line(double x1, double y1, double x2, double y2) {
    this.start = new Point(x1, y1);
    this.end = new Point(x2, y2);
  }
  /**
   * Calculates and returns the length of the line segment.
   *
   * @return The length of the line segment.
   */
  public double length() {
    return this.start.distance(this.end);
  }
  /**
   * Returns the middle point of the line.
   *
   * @return The middle point of the line.
   */
  public Point middle() {
    return new Point((end.getX() + start.getX()) / 2, (end.getY() + start.getY()) / 2);
  }
  /**
   * Returns the starting point of the line.
   *
   * @return The starting point of the line.
   */
  public Point start() {
    return this.start;
  }
  /**
   * Returns the ending point of the line.
   *
   * @return The ending point of the line.
   */
  public Point end() {
    return this.end;
  }
  /**
   * Checks if this line intersects with another line.
   *
   * @param other The other line to check for intersection.
   * @return True if the lines intersect, false otherwise.
   */
  public boolean isIntersecting(Line other) {
    /* checks the case that the slope of the two lines are infinity */
    if ((this.start.getX() - this.end.getX()) == 0 && (other.start.getX() - other.end.getX()) == 0) {
      if (this.start.distance(other.start()) + this.start.distance(other.end())
          == other.start().distance(other.end()) || this.end.distance(other.start())
          + this.end.distance(other.end()) == other.start().distance(other.end())) {
        return true;
      }
      return false;
    }
    /*
     * check if there is an intersection in that the two slopes are equals.
     */
    /*calculate the slopes of the two lines.*/
    double m1 = ((this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX()));
    double m2 = ((other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX()));
    /*
     * if the slope are equal and one of the ends of this point is into other line then return true
     * anf if one of the condition aren't true then return false.
     */
    if (m1 == m2) {
      if (this.start.distance(other.start()) + this.start.distance(other.end())
          == other.start().distance(other.end()) || this.end.distance(other.start())
          + this.end.distance(other.end()) == other.start().distance(other.end())) {
        return true;
      }
    }
    if (intersectionWith(other) != null) {
      return true;
    }
    return false;
  }
  /**
   * Checks if this line intersects with two other lines.
   *
   * @param other1 The first other line to check for intersection.
   * @param other2 The second other line to check for intersection.
   * @return True if this line intersects with both other lines, false otherwise.
   */
  public boolean isIntersecting(Line other1, Line other2) {
    if (isIntersecting(other1) && isIntersecting(other2)) {
      return true;
    }
    return false;
  }
  /**
   * Finds the intersection point between this line and another line.
   *
   * @param other The other line to find the intersection point with.
   * @return The intersection point if the lines intersect, null otherwise.
   */
  public Point intersectionWith(Line other) {
    /*
     * Declaring variables in order from left to right:
     * The slope of this line, the slop of the argument line, the free constant of this line,
     * the free constant of the other line, the X value of the intersection point,
     * the Y value of the intersection point.
     */
    double currentSlope, otherSlope, currentFree, otherFree, xIntersection, yIntersection;
    // If both lines are vertical, they are either parallel or coincident, return null.
    if (this.end.getX() == this.start.getX() && other.end().getX() == other.start().getX()) {
      if (this.end.equals(other.end()) || this.end.equals(other.start())) {
        return this.end;
      } else if (this.start.equals(other.end()) || this.start.equals(other.start())) {
        return this.start;
      }
      return null;
    } else if (this.end.getX() == this.start.getX() && other.end().getX() != other.start().getX()) {
      // Calculate slope of other line.
      otherSlope = ((other.end().getY() - other.start().getY())) / (other.end().getX() - other.start().getX());
      // Calculate free member of the equation representing the other line.
      otherFree = (other.start().getY() - (otherSlope * other.start().getX()));
      // Find intersection between equations of this line and other line.
      xIntersection = this.start.getX();
      yIntersection = (otherSlope * xIntersection) + otherFree;
    } else if (other.end().getX() == other.start().getX() && this.end.getX() != this.start.getX()) {
      // Calculate slope of this line.
      currentSlope = ((this.end.getY() - this.start.getY())) / (this.end.getX() - this.start.getX());
      // Calculate free member of the equation representing this line.
      currentFree = (this.start.getY() - (currentSlope * this.start.getX()));
      // Find intersection between equations of this line and other line.
      xIntersection = other.start().getX();
      yIntersection = (currentSlope * xIntersection) + currentFree;
    } else {
      // Calculate slope of this line.
      currentSlope = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
      // Calculate slope of other line.
      otherSlope = (other.end().getY() - other.start().getY()) / (other.end().getX() - other.start().getX());
      // If the slopes are equal there is no intersection and method returns null.
      if (currentSlope == otherSlope) {
        if (this.end.equals(other.end()) || this.end.equals(other.start())) {
          return this.end;
        } else if (this.start.equals(other.end()) || this.start.equals(other.start())) {
          return this.start;
        }
        return null;
      }
      // Calculate free constant of the equation representing this line.
      currentFree = (this.start.getY() - (currentSlope * this.start.getX()));
      // Calculate free constant of the equation representing the other line.
      otherFree = (other.start().getY() - (otherSlope * other.start().getX()));
      // Find intersection between equations of this line and other line.
      xIntersection = (otherFree - currentFree) / (currentSlope - otherSlope);
      yIntersection = (currentSlope * xIntersection) + currentFree;
    }
    // geometry.Point object containing the intersection point between the equations of the two lines.
    Point intersection = new Point(xIntersection, yIntersection);
    /* Check if the intersection point is outside one of the lines.
     * This is done by comparing the length of each line with the sum of the distances between
     * the intersection and the two ends of the line.
     * (In the case of an actual intersection between the lines, these should be equal).
     * If the intersection is outside one of the lines, return null.
     */
    double d1 = (this.length() - (intersection.distance(this.start) + intersection.distance(this.end)));
    double d2 = (other.length() - (intersection.distance(other.start()) + intersection.distance(other.end())));
    if ((d1 <= (-0.0000001) || d1 >= (0.0000001)) || (d2 <= (-0.0000001) || d2 >= (0.0000001))) {
      return null;
    }
    // Return the intersection point between the two lines.
    return intersection;
  }
  /**
   * Checks if this line is equal to another line.
   *
   * @param other The other line to compare with.
   * @return True if the lines are equal, false otherwise.
   */
  public boolean equals(Line other) {
    /*calculate the slopes of the two lines.*/
    double m1 = ((this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX()));
    double m2 = ((other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX()));
    /*
     * if the slope are equal and one of the ends of this point is into other line then return true
     * anf if one of the condition aren't true then return false.
     */
    if (m1 == m2) {
      if (this.start.distance(other.start) + this.start.distance(other.end) == other.start.distance(other.end)
          || this.end.distance(other.start) + this.end.distance(other.end) == other.start.distance(other.end)) {
        return true;
      }
    }
    return false;
  }
  /**
   * Finds the closest intersection point between the current line and a given rectangle.
   *
   * @param rect The rectangle to find intersections with.
   * @return The closest intersection point to the starting point of the line.
   * Returns null if there are no intersections.
   */
  public Point closestIntersectionToStartOfLine(Rectangle rect) {
    Point closestIntersection = null;
    double shortestDistance;
    List<Point> intersections = rect.intersectionPoints(this);
    if (!intersections.isEmpty()) {
      shortestDistance = intersections.get(0).distance(this.start);
      closestIntersection = intersections.get(0);
      for (Point p : intersections) {
        double currentDistance = p.distance(this.start);
        if (currentDistance < shortestDistance) {
          shortestDistance = currentDistance;
          closestIntersection = p;
        }
      }
    }
    return closestIntersection;
  }
}


