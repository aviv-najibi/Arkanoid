import gameConfig.Game;
/**
 * name: aviv najibi
 * ID: 314621699
 * class name: Ass3Game
 * class explain:The Ass3Game class serves as the entry point for the game application.
 * It creates an instance of the gameConfig.Game class, initializes it, and then runs the game.
 * The main method orchestrates the overall flow of the game.
 */
public class Ass5Game {
  /**
   * The main method creates an instance of the gameConfig.Game class,
   * initializes the game, and then runs it.
   * @param args Command line arguments (unused in this application).
   */
  public static void main(String[] args) {
    // Create an instance of the gameConfig.Game class
    Game game = new Game();
    // Initialize the game
    game.initialize();
    // Run the game
    game.run();
  }
}
