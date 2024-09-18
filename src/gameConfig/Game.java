package gameConfig;
import animation.Collidable;
import animation.Sprite;
import animation.SpriteCollection;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import geometry.Ball;
import geometry.Point;
import geometry.Rectangle;
import java.awt.Color;
import java.util.Random;
/**
 * name: aviv najibi
 * ID: 314621699
 * class name: geometry.Velocity
 * class explain: The gameConfig.Game class represents the main class for a game application.
 */
public class Game {
  private Counter scoreCounter = new Counter();
  private ScoreTrackingListener sTl = new ScoreTrackingListener(this.scoreCounter);
  private Counter numBlocks = new Counter();
  private BlockRemover br = new BlockRemover(this, numBlocks);
  private Counter numBalls = new Counter();
  private BallRemover ballR = new BallRemover(this, numBalls);
  private SpriteCollection sprites;
  private GameEnvironment environment;
  private GUI g;
  private DrawSurface d;
  private Sleeper s;
  /**
   * Constructs a new gameConfig.Game instance, initializing sprites, the game environment, GUI, and Sleeper.
   */
  public  Game() {
    this.sprites = new SpriteCollection();
    this.environment = new GameEnvironment();
    this.g = new GUI("Arkanoid", 800, 600);
    this.d = g.getDrawSurface();
    this.s = new Sleeper();
  }
  /**
   * Adds a collidable object to the game environment.
   *
   * @param c The collidable object to be added.
   */
  public void addCollidable(Collidable c) {
    this.environment.addCollidable(c);
  }
  /**
   * Adds a sprite to the sprite collection.
   *
   * @param s The sprite to be added.
   */
  public void addSprite(Sprite s) {
    this.sprites.addSprite(s);
  }
  /**
   * Initializes a new game by creating Blocks, geometry.Ball, and gameConfig.Paddle, and adding them to the game.
   * This method is responsible for setting up the initial state of the game.
   */
  public void initialize() {
    int widthSizeEnd = 15;
    int widthSizeStart = 0;
    int heighSizeStart = 0;
    int heighSizeEnd = 5;
    Random rand = new Random();
    java.awt.Color c = new Color(rand.nextInt());
    Point upperPointPaddle =  new geometry.Point(373.5, 570);
    geometry.Rectangle paddleRectangle = new geometry.Rectangle(upperPointPaddle, 100, 20);
    Paddle paddle = new Paddle(paddleRectangle, g, 800);
    paddle.addToGame(this);
    for (int j = heighSizeStart; j < heighSizeEnd; j++) {
      for (int i = widthSizeStart; i < widthSizeEnd; i++) {
        // creating the top left point of the rectangle and between the rectangle will be a gap of 10 width and 5 height
        geometry.Point p =  new geometry.Point((25 + (i * 50)), (145 + (j * 25)));
        //create a rectangle object and put the p in the top point intager and the sizes of the rectangle.
        geometry.Rectangle r = new Rectangle(p, 49.7, 25);
        //create a block object and put r into it.
        Block block = new Block(r, c);
        block.addHitListener(this.sTl);
        block.addHitListener(br);
        br.getRemainingBlocks().increase(1);
        block.addToGame(this);
      }
      c = new Color(rand.nextInt());
    }
    // Border Blocks
    Color borderColor = Color.DARK_GRAY;
    Block leftBorder = new Block(new geometry.Rectangle(new geometry.Point(0, 0), 25, 600), borderColor);
    leftBorder.addToGame(this);
    Block topBorder = new Block(new geometry.Rectangle(new geometry.Point(25, 20), 750, 25), borderColor);
    topBorder.addToGame(this);
    Block rightBorder = new Block(new geometry.Rectangle(new geometry.Point(775, 0), 25, 600), borderColor);
    rightBorder.addToGame(this);
    Block bottomBorder = new Block(new geometry.Rectangle(new geometry.Point(0, 600), 800, 25), borderColor);
    bottomBorder.addHitListener(ballR);
    ballR.getRemainingBalls().increase(3);
    bottomBorder.addToGame(this);
    Block b = new Block(new Rectangle(new Point(0, 0), 800, 20), Color.WHITE);
    ScoreIndicator scoreIndicator = new ScoreIndicator(b, this.scoreCounter);
    this.addSprite(scoreIndicator);
    //first ball
    //initialize the point that will be in geometry.Ball object.
    geometry.Point p = new geometry.Point(400, 300);
    //initialize the ball and the color is black
    Ball ball = new Ball(p, 5, Color.black, environment);
    ball.setVelocity(3, 7);
    //add the ball b to the list in sprites.
    ball.addToGame(this);
    // the padle needs to be here and add it to sprites and environment (collidable).
    //draw all the sprite in the game(ball, blocks, padale)
    //second ball
    //initialize the point that will be in geometry.Ball object.
    geometry.Point p2 = new geometry.Point(400, 300);
    //initialize the ball and the color is black
    Ball ball2 = new Ball(p2, 5, Color.black, environment);
    ball2.setVelocity(3, 6);
    //add the ball b to the list in sprites.
    ball2.addToGame(this);
    // the padle needs to be here and add it to sprites and environment (collidable).
    //draw all the sprite in the game(ball, blocks, padale)
    //third ball
    //initialize the point that will be in geometry.Ball object.
    geometry.Point p3 = new geometry.Point(400, 300);
    //initialize the ball and the color is black
    Ball ball3 = new Ball(p3, 5, Color.black, environment);
    ball3.setVelocity(3, 5);
    //add the ball b to the list in sprites.
    ball3.addToGame(this);
    // the padle needs to be here and add it to sprites and environment (collidable).
    //draw all the sprite in the game(ball, blocks, padale)
    sprites.drawAllOn(d);
    g.show(d);
  }
  /**
   * Runs the game by starting the animation loop.
   * This method is responsible for managing the game's main loop.
   */
  public void run() {
    //...
    int framesPerSecond = 60;
    int millisecondsPerFrame = 1000 / framesPerSecond;
    while (true) {
      long startTime = System.currentTimeMillis(); // timing
      if (this.numBalls.getValue() == 0) {
        g.close();
        return;
      }
      if (this.numBlocks.getValue() == 0) {
        this.scoreCounter.increase(100);
        d = g.getDrawSurface();
        this.sprites.notifyAllTimePassed();
        this.sprites.drawAllOn(d);
        g.show(d);
        g.close();
        return;
      }
      d = g.getDrawSurface();
      this.sprites.notifyAllTimePassed();
      this.sprites.drawAllOn(d);
      g.show(d);
      // timing
      long usedTime = System.currentTimeMillis() - startTime;
      long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
      if (milliSecondLeftToSleep > 0) {
        s.sleepFor(milliSecondLeftToSleep);
      }
    }
  }
  /**
   * Removes a collidable object from the game environment.
   *
   * @param c The collidable object to be removed.
   */
  public void removeCollidable(Collidable c) {
    this.environment.getCollidables().remove(c);
  }
  /**
   * Removes a sprite from the sprite collection.
   *
   * @param s The sprite to be removed.
   */
  public void removeSprite(Sprite s) {
    this.sprites.getSprites().remove(s);
  }
}
