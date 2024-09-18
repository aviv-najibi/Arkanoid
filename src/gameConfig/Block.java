package gameConfig;

import animation.Collidable;
import animation.HitListener;
import animation.HitNotifier;
import animation.Sprite;
import biuoop.DrawSurface;
import geometry.Ball;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * name: aviv najibi
 * ID: 314621699
 * class name: gameConfig.Block
 * class explain: The gameConfig.Block class represents a rectangular block that
 * implements both the animation.Collidable and animation.Sprite interfaces.It has a rectangle
 * shape, a color,and methods for collision handling and drawing on a DrawSurface.
 */
public class Block implements Collidable, Sprite, HitNotifier {
  // The rectangle representing the block's shape.
  private Rectangle rect;
  // The color of the block (default is black).
  private java.awt.Color color = Color.BLACK;
  private List<HitListener> hitListeners;
  /**
   * Constructor for the gameConfig.Block class.
   *
   * @param rect The rectangle representing the block's shape.
   */
  public Block(Rectangle rect) {
    this.hitListeners = new ArrayList<HitListener>();
    this.rect = rect;
  }
  /**
   * Constructs a gameConfig.Block with the specified geometry.Rectangle and color.
   *
   * @param rect  The geometry.Rectangle defining the dimensions and position of the gameConfig.Block.
   * @param color The color to be applied to the gameConfig.Block.
   */
  public Block(Rectangle rect, java.awt.Color color) {
    this.hitListeners = new ArrayList<HitListener>();
    this.rect = rect;
    this.color = color;
  }
  /**
   * Returns the collision rectangle of the block.
   *
   * @return The collision rectangle of the block.
   */
  public Rectangle getCollisionRectangle() {
    return this.rect;
  }
  /**
   * Handles a collision with the block and returns the new velocity after the collision.
   *
   * @param hitter          The ball that hit the block.
   * @param collisionPoint  The point at which the collision occurs.
   * @param currentVelocity The current velocity of the colliding object.
   * @return The new velocity after the collision.
   */
  public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
    double collisionX = collisionPoint.getX();
    Velocity nextVelocity;
    double upperLeftX = rect.getUpperLeft().getX();
    if (collisionX > upperLeftX && collisionX < upperLeftX + rect.getWidth()) {
      nextVelocity = new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
    } else {
      nextVelocity = new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
    }
    if (!ballColorMatch(hitter) || this.rect.getUpperLeft().getY() == 560) {
      this.notifyHit(hitter);
    }
    return nextVelocity;
  }
  /**
   * Draws the block on a DrawSurface by filling and drawing its rectangle.
   *
   * @param d The DrawSurface on which the block will be drawn.
   */
  public void drawOn(DrawSurface d) {
    double rectX = this.rect.getUpperLeft().getX();
    double rectY = this.rect.getUpperLeft().getY();
    d.setColor(this.color);
    d.fillRectangle((int) rectX + 2, (int) rectY + 2, (int) this.rect.getWidth() - 2, (int) this.rect.getHeight() - 2);
    d.drawRectangle((int) rectX + 2, (int) rectY + 2, (int) this.rect.getWidth() - 2, (int) this.rect.getHeight() - 2);
  }
  /**
   * Updates the block's state based on the passage of time.
   * (Currently, the method does not have any functionality.)
   */
  public void timePassed() {
  }
  /**
   * The addToGame method is part of a class that represents a game entity,
   * allowing it to be added to a gameConfig.Game instance for rendering and collision handling.
   * This method adds the current entity (represented by 'this') to the specified gameConfig.Game.
   *
   * @param g The gameConfig.Game instance to which the current entity is added.
   */
  public void addToGame(Game g) {
    // Add the current entity as a sprite to the specified gameConfig.Game
    g.addSprite(this);
    // Add the current entity as a collidable object to the specified gameConfig.Game
    g.addCollidable(this);
  }
  /**
   * Checks if the color of the block matches the color of the ball.
   *
   * @param ball The ball to compare color with.
   * @return True if colors match, false otherwise.
   */
  public boolean ballColorMatch(Ball ball) {
    if (ball.getColor() == this.color) {
      return true;
    }
    return false;
  }
  /**
   * Removes the block from the specified Game instance.
   *
   * @param game The Game instance from which the block is removed.
   */
  public void removeFromGame(Game game) {
    game.removeCollidable(this);
    game.removeSprite(this);
  }
  /**
   * Adds a HitListener to the block.
   *
   * @param hl The HitListener to be added.
   */
  public void addHitListener(HitListener hl) {
    this.hitListeners.add(hl);
  }
  /**
   * Removes a HitListener from the block.
   *
   * @param hl The HitListener to be removed.
   */
  // Remove hl from the list of listeners to hit events.
  public void removeHitListener(HitListener hl) {
    this.hitListeners.remove(hl);
  }
  /**
   * Notifies all HitListeners about a hit event.
   *
   * @param hitter The ball that hit the block.
   */
  private void notifyHit(Ball hitter) {
    // Make a copy of the hitListeners before iterating over them.
    List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
    // Notify all listeners about a hit event:
    for (HitListener hl : listeners) {
      hl.hitEvent(this, hitter);
    }
  }
  /**
   * Gets the color of the block.
   *
   * @return The color of the block.
   */
  public Color getColor() {
    return this.color;
  }
}
