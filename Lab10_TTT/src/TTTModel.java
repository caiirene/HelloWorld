/**
 * an interface copy from canvas
 */
public interface TTTModel {

  /**
   * Places an X or O mark in the specified cell. Whether it places an X
   * or O depends on which player's turn it is.
   *
   * @param column the column of the cell
   * @param row    the row of the cell
   * @throws IllegalStateException if the game is over, or if there is
   * already a mark in the cell.
   * @throws IndexOutOfBoundsException if the cell is out of bounds.
   */
  void move(int column, int row);

  /**
   * Returns the player whose turn is next.
   *
   * @return the next player
   * @throws IllegalStateException if the game is over
   */
  Player nextPlayer();

  /**
   * Returns the {@link Player} whose mark is in the cell at the given
   * coordinates, or {@code null} if that cell is empty.
   *
   * @param column the column of the cell
   * @param row    the row of the cell
   * @return a {@code Player} or {@code null}
   * @throws IndexOutOfBoundsException if the cell is out of bounds.
   */
  Player getMarkAt(int column, int row);

  /**
   * Returns a two-dimensional array representing the state of the
   * grid. The first index is the column and the second the row.
   * The resulting array is newly allocated and unconnected to the model;
   * thus, mutating it will have no effect on the model or subsequent
   * calls to {@code getGrid}.
   *
   * @return a copy of the grid
   */
  Player[][] getGrid();
  /**
   * Determines whether the game is over.
   *
   * @return whether the game is over
   */
  boolean isGameOver();

  /**
   * Returns the winner of the game, or {@code null} if the game is a
   * tie.
   *
   * @return the winner or {@code null}
   * @throws IllegalStateException if the game isn't over
   */
  Player getWinner();

}
