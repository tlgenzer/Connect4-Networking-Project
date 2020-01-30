public interface ITicTacToe 
{
    /*
     *	Return the current player's piece (X or O)
     */
    public Player getCurrentPlayer();
    
    /*
     *	Change the current player from X to O, or from O to X
     */
    public void nextPlayer();
    
    /*
     *	Add the current player's piece to the board at the specified row,col and return true
     *	If there is already a piece at that location, do not add the piece and return false
     */
    public int addPiece(int row, int col);
    
    /*
     *	Return the piece that is located at the specified row, col
     *	If there is no piece at that location, return null
     */
    public Player getPiece(int row, int col);
    
    /*
     *	Return true if there is at least 1 empty space left on the board
     *	Return false if all spaces have a piece in them
     */
    public boolean hasEmptySpace();
    
    /*	Return null if there is no winner
     *	Return the appropriate TicTacToePiece (X or Y) if there is a winner.
     */
    public Player getWinner();
    
    /*
     *	Return true if there is a winner or if there are no empty spaces left on the board
     *	Otherwise, return false
     */
    public boolean isGameOver();
}