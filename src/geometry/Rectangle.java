package geometry;

import java.util.List;
import java.util.ArrayList;
/**
 * name: aviv najibi
 * ID: 314621699
 * class name: geometry.Velocity
 * class explain: The geometry.Rectangle class represents a rectangle in a 2D space defined by its upper-left corner,
 * width, and height.
 */
public class Rectangle {

    private Point upperLeft;
    private double width;
    private double height;
    /**
     * Constructs a new rectangle with a specified upper-left corner, width, and height.
     *
     * @param upperLeft The upper-left corner of the rectangle.
     * @param width     The width of the rectangle.
     * @param height    The height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }
    /**
     * Copy constructor for creating a new rectangle based on an existing one.
     *
     * @param rect The rectangle to copy.
     */
    public Rectangle(Rectangle rect) {
        this.upperLeft = rect.getUpperLeft();
        this.width = rect.getWidth();
        this.height = rect.getHeight();
    }
    /**
     * Calculates and returns a list of intersection points between the rectangle and a given line.
     *
     * @param line The line to find intersection points with.
     * @return A list of intersection points. May be empty if there are no intersections.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersections = new ArrayList<Point>();
        // Generate the four lines that form the triangle.
        double upperX = this.upperLeft.getX();
        double upperY = this.upperLeft.getY();
        Line[] lines = new Line[4];
        lines[0] = new Line(this.upperLeft, new Point(upperX + this.width, upperY));
        lines[1] = new Line(this.upperLeft, new Point(upperX, upperY + this.height));
        lines[2] = new Line(new Point(upperX + this.width, upperY), new Point(upperX + this.width,
                upperY + this.height));
        lines[3] = new Line(new Point(upperX, upperY + this.height), new Point(upperX + this.width,
                upperY + this.height));

        // Loop through lines array, check for intersections and add them to the List.
        Point intersect;
        int count = 0;
        for (Line l : lines) {
            intersect = l.intersectionWith(line);
            if (intersect != null) {
                intersections.add(new Point(intersect.getX(), intersect.getY()));
            }
        }
        return intersections;
    }
    /**
     * Returns the width of the rectangle.
     *
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * Returns the height of the rectangle.
     *
     * @return The height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }
    /**
     * Returns the upper-left point of the rectangle.
     *
     * @return The upper-left point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}