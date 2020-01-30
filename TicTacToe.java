public class TicTacToe implements ITicTacToe
{
    //INSTANCE VARIABLES
    Player[][]board;

    Player current;
    //CONSTRUCTORS
    public TicTacToe() 
    {   board = new Player[6][7];

        current = Player.A;
    }

    //METHODS
    /*
     *  Return the current player's piece (X or O)
     */
    public Player getCurrentPlayer()
    {
        return current;
    }

    /*
     *  Change the current player from X to O, or from O to X
     */
    public void nextPlayer()
    {
        if(current == Player.A)
        {
            current = Player.B;
        }
        else
        {
            current = Player.A;
        }
    }

    /*
     *  Add the specified piece to the board at the specified row,col and return true
     *  If there is already a piece at that location, do not add the piece and return false
     */
    public int addPiece(int row, int col)
    {
        if(board[row][col]==null)
        {
            int under = 0;
            if(row==5){
                while(board[row-under][col]!=null){
                    if(row-under == 0){
                        if(board[row-under][col] !=null){
                            return 0;
                        }
                    }
                    under++;
                }
                row = row-under;
                board[row][col] = current;
                return row;
            }
            while(board[row+under][col]==null){
                if(row+under==5){
                    if(board[row+under][col]!=null){
                        return 0;
                    }
                    else{
                        row = row+under;
                        board[row][col] = current;
                        return row;
                    }
                }
                under++;
            }
            row = row+under;
            if(board[row][col]!=null){
                board[row-1][col] = current;
                return row-1;
            }
            board[row][col] = current;
            return row;
        }
        return 0;
    }

    /*
     *  Return the piece that is located at the specified row, col
     *  If there is no piece at that location, return null
     */
    public Player getPiece(int row, int col)
    {
        return board[row][col];
    }

    /*
     *  Return true if there is at least 1 empty space left on the board
     *  Return false if all spaces have a piece in them
     */
    public boolean hasEmptySpace()
    {
        for(int i=5; i>=0;i--)
        {
            for(int j=6; j>=0;j--)
            {
                if(board[i][j]==null)
                {
                    return true;   
                }
            }
        }
        return false;
    }

    /*  Return null if there is no winner
     *  Return the appropriate TicTacToePiece (X or Y) if there is a winner.
     *  Hint: use the helper methods: checkRowsForWinner(), checkColsForWinner(), and checkDiagsForWinner()
     */
    public Player getWinner()
    {
        if(checkForWin()!=null)
        {
            return checkForWin();
        }
        return null;
    }

    public Player checkForWin(){
        for(int r = 0; r<board.length; r++){
            for(int c = 0; c<board[0].length; c++){
                Player cur = board[r][c];
                if(cur!=null){
                    if(c <= board[0].length-4 && cur == board[r][c+1] && cur == board[r][c+2] && cur == board[r][c+3]){
                        return cur;
                    }
                    if(r <= board.length-4 && cur == board[r+1][c] && cur == board[r+2][c] && cur == board[r+3][c]){
                        return cur;
                    }
                    if(r <= board.length-4 && c <= board[0].length-4){
                        if(cur == board[r+1][c+1] && cur == board[r+2][c+2] && cur == board[r+3][c+3]){
                            return cur;
                        }
                    }
                    if(r <= board.length-4 && c >= board[0].length-4){
                        if(cur == board[r+1][c-1] && cur == board[r+2][c-2] && cur == board[r+3][c-3]){
                            return cur;
                        }
                    }
                }
            }
        }
        return null;
    }

    /*
     *  Return true if there is a winner or if there are no empty spaces left on the board
     *  Otherwise, return false
     */
    public boolean isGameOver()
    {
        if(getWinner()!=null)
        {
            return true;   
        }
        if(!hasEmptySpace())
        {
            return true;   
        }
        return false;
    }

    //HELPER METHODS
    /*
     *  If a, b, and c are all the same TicTacToe piece, then return that piece
     *  Otherwise, return null
     */
    private Player checkForWinner(Player a, Player b, Player c)
    {
        if(a==b && b==c)
        {
            return a;

        }
        return null;
    }

    /*
     *  Use the checkForWinner() helper method to check each of the 3 rows for a winner
     *  Return the first non-null winner that is found (starting from row 0)
     *  If no non-null winners are found, return null
     */
    private Player checkRowsForWinner()
    {
        Player ret= null;
        for(int i=2;i>=0; i--)
        {
            if(checkForWinner(board[i][0], board[i][1], board[i][2])==null)
            {
                ret=null;
            }
            else
            {
                return board[i][0];
            }
        }
        return ret;
    }

    /*
     *  Use the checkForWinner() helper method to check each of the 3 columns for a winner
     *  Return the first non-null winner that is found (starting from column 0)
     *  If no non-null winners are found, return null
     */
    private Player checkColsForWinner()
    {
        Player ret= null;
        for(int i=2;i>=0; i--)
        {
            if(checkForWinner(board[0][i], board[1][i], board[2][i])==null)
            {
                ret=null;
            }
            else
            {
                return board[0][i];
            }
        }
        return ret;
    }

    /*
     *  Use the checkForWinner() helper method to check both of the diagonals for a winner
     *  Check the top left -> bottom right diagonal first
     *  Check the top right -> bottom left diagonal second
     *  Return the first non-null winner that is found
     *  If no non-null winners are found, return null
     */
    private Player checkDiagsForWinner()
    {
        Player ret= null;
        if(checkForWinner(board[0][0], board[1][1], board[2][2])==null)
        {
            ret=null;
            if(checkForWinner(board[2][0], board[1][1], board[0][2])==null)
            {
                ret = null;
            }
            else
            {
                return board[2][0];
            }
        }
        else
        {
            return board[0][0];
        }
        return null;
    }

}