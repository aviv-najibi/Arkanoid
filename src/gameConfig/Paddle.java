package gameConfig;

import animation.Collidable;
import animation.Sprite;
import biuoop.KeyboardSensor;
import biuoop.DrawSurface;
import biuoop.GUI;
import geometry.Ball;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

import java.awt.Color;
/**
 * name: aviv najibi
 * ID: 314621699
 * class name: paddle
 * class explain: The gameConfig.Paddle class represents a player-controlled paddle in a game.
 * It implements the animation.Sprite and animation.Collidable interfaces to integrate with the game's functionality.
 */
public class Paddle implements Sprite, Collidable {
  private biuoop.KeyboardSensor keyboard;
  private GUI g;
  private double w;
  private Rectangle rect;
  private java.awt.Color color = Color.BLUE;
  /**
   * Constructor for creating a gameConfig.Paddle.
   *
   * @param paddle      The initial geometry.Rectangle defining the dimensions and position of the gameConfig.Paddle.
   * @param g        The GUI object associated with the game.
   * @param spaceWidth  The width of the game screen.
   */
  public Paddle(Rectangle paddle, GUI g, double spaceWidth) {
    this.rect = paddle;
    this.g = g;
    this.w = spaceWidth;
    this.keyboard = g.getKeyboardSensor();
  }
  /**
   * Moves the paddle to the left within the game screen boundaries.
   */
  public void moveLeft() {
    // Implementation for moving the paddle to the left.
    // Ensure the paddle stays within the left boundary of the screen.
    int x1 = -5;
    // I add function in rect and point that change the x of the ball, so see it in rect and point
    double upperLeftX = this.rect.getUpperLeft().getX(), upperLeftY = this.rect.getUpperLeft().getY();
    if (upperLeftX + x1 >= 25) {
      this.rect = new Rectangle(new Point(upperLeftX + x1, upperLeftY), this.rect.getWidth(), this.rect.getHeight());
    } else {
      this.rect = new Rectangle(new Point(800 - this.rect.getWidth() - 25, 575 - this.rect.getHeight()),
          this.rect.getWidth(), this.rect.getHeight());
    }
  }
  /**
   * Moves the paddle to the right within the game screen boundaries.
   */
  public void moveRight() {
    // Implementation for moving the paddle to the right.
    // Ensure the paddle stays within the right boundary of the screen.
    int x1 = 5;
    double upperLeftX = this.rect.getUpperLeft().getX(), upperLeftY = this.rect.getUpperLeft().getY();
    if (upperLeftX + x1 + this.rect.getWidth() <= this.w - 25) {
      this.rect = new Rectangle(new Point(upperLeftX + x1, upperLeftY), this.rect.getWidth(), this.rect.getHeight());
    } else {
      this.rect = new Rectangle(new Point(25, 575 - this.rect.getHeight()),
          this.rect.getWidth(), this.rect.getHeight());
    }
  }
  /**
   * Checks for key presses to move the paddle and responds accordingly.
   */
  public void timePassed() {
    // Check for left and right key presses to move the paddle
    if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
      this.moveLeft();
    } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
      this.moveRight();
    }
  }
  /**
   * Draws the paddle on the given DrawSurface.
   *
   * @param d The DrawSurface on which the paddle is to be drawn.
   */
  public void drawOn(DrawSurface d) {
    // Implementation for drawing the paddle on the provided DrawSurface.
    double rectX = this.rect.getUpperLeft().getX();
    double rectY = this.rect.getUpperLeft().getY();
    d.setColor(this.color);
    d.fillRectangle((int) rectX, (int) rectY, (int) this.rect.getWidth(), (int) this.rect.getHeight());
    d.drawRectangle((int) rectX, (int) rectY, (int) this.rect.getWidth(), (int) this.rect.getHeight());
  }
  /**
   * Returns the collision rectangle of the paddle.
   *
   * @return The collision rectangle of the paddle.
   */
  public Rectangle getCollisionRectangle() {
    return this.rect;
  }
  /**
   * Calculates the new velocity of a ball after a collision with this collidable object.
   *
   * @param hitter          The ball that hits this collidable object.
   * @param collisionPoint  The point of collision between the ball and this collidable object.
   * @param currentVelocity The current velocity of the ball.
   * @return The new velocity of the ball after the collision.
   */
  public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
    // Implementation for handling collision with a ball and returning a new velocity.
    double collisionX = collisionPoint.getX();
    double collisionY = collisionPoint.getY();
    double upperLeftX = this.rect.getUpperLeft().getX();
    double upperLeftY = this.rect.getUpperLeft().getY();
    //inisialize a new velocity
    Velocity nextVelocity;
    //calculate the speed of the ball like azruchles told me
    double speed = Math.sqrt((currentVelocity.getDx() * currentVelocity.getDx())
        + (currentVelocity.getDy() * currentVelocity.getDy()));
    //here i divide the rectangle to five parts
    double x1 = rect.getUpperLeft().getX() + (rect.getWidth() / 5);
    double x2 = rect.getUpperLeft().getX() + (2 * (rect.getWidth() / 5));
    double x3 = rect.getUpperLeft().getX() + (3 * (rect.getWidth() / 5));
    double x4 = rect.getUpperLeft().getX() + (4 * (rect.getWidth() / 5));
    double x5 = rect.getUpperLeft().getX() + (5 * (rect.getWidth() / 5));
    //in those five ifs i check if the collision point are there and acording to that i change the degree of the ball
    //if tha collision point is not at the upper line of the rectangle then change only the dx to minus
    if (collisionX >= upperLeftX && collisionX <= x1 && collisionY == upperLeftY) {
      nextVelocity = new Velocity(30, (-1 * speed));
    } else if (collisionX >= x1 && collisionX <= x2 && collisionY == upperLeftY) {
      nextVelocity = new Velocity(60, (-1 * speed));
    } else if (collisionX >= x2 && collisionX <= x3 && collisionY == upperLeftY) {
      nextVelocity = new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
    } else if (collisionX >= x3 && collisionX <= x4 && collisionY == upperLeftY) {
      nextVelocity = new Velocity(300, speed);
    } else if (collisionX >= x4 && collisionX <= x5 && collisionY == upperLeftY) {
      nextVelocity = new Velocity(330, speed);
    } else {
      nextVelocity = new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
    }
    return nextVelocity;
  }
  /**
   * Adds the paddle to the game by registering it as a sprite and collidable.
   *
   * @param g The game to which the paddle is added.
   */
  public void addToGame(Game g) {
    g.addSprite(this);
    g.addCollidable(this);
  }
}