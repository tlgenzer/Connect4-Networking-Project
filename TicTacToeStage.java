import mayflower.*;
import java.awt.Color;

//Find the Mayflower documentation here: http://mrmaycs.com/mayflower/

//TODO:
/*
 *  1. Remember the following information:
 *      - the TicTacToePiece that is passed as a parameter to the constructor (this is your piece)
 *      - all of the PieceActor objects in a 2d array so they can be referenced in other methods
 *  2. Instead of creating a new TicTacToe game in the constructor, just remember the TicTacToe game that was passed as a parameter
 *  3. Implement the updatePiece method that tells the PieceActor at (row, col) to update itself to display the appropriate piece (X or O)
 *  4. Change the if/else condition in update so that it displays "Your turn" and "Waiting for opponent" instead of "It is X's turn" and "It is O's turn"
 *  5. Change the if/else condition in update so that it displays "You win!" and "You lose." instead of "X wins!" and "O wins!"
 */

public class TicTacToeStage extends Stage
{
    //INSTANCE VARIABLES
    private TicTacToe game;
    private Text currentPlayer, winner;
    private Player p;
    //SIZE CHANGED ----------------------------------------------------------------------
    private PieceActor[][]board = new PieceActor[7][6];
    private Player youAre;
    //CONSTRUCTOR
    public TicTacToeStage(TicTacToeClient client, TicTacToe g, Player piece)
    {
        //TODO: store parameters in instance variables

        setBackground("img/background2.png");
        youAre = piece;
        game = g;
        if(piece==Player.A)
        {
            System.out.println("x");
            Text youarex = new Text("You are X", Color.WHITE);
            addActor(youarex, 500, 0);

        }
        if(piece==Player.B)
        {

            System.out.println("o");
            Text youareo = new Text("You are O", Color.WHITE);
            addActor(youareo, 500, 0);

        }
        //Add a label to the top of the screen that displays the name of the game
        Text title = new Text("Connect 4", Color.WHITE);
        addActor(title, 0, 0);

        currentPlayer = new Text("Loading...", Color.WHITE);
        addActor(currentPlayer, 0, 30);

        winner = new Text("", Color.WHITE);
        addActor(winner, 0, 60);

        // Add a "blank" PieceActor to each of the 9 spots of the TicTacToe board
        // Each PieceActor needs a reference to the TicTacToe object
        // TODO: store each PieceActor in a 2d array instance variable
        int w = 50 + 30;
        int h = 50 + 30;
        for(int r = 0; r < 7; r++)
        {
            for(int c = 0; c < 6; c++)
            {
                PieceActor pa = new PieceActor(client, r, c);
                board[r][c] = pa;
                addActor(pa, r*w+40, c*h+100);
            }
        }
    }

    //METHODS
    /*
     *  Check if the game is over
     *      If the game is over, display the text "Game Over!" on the screen
     *      If there is a winner, display the text "You win!" or "You lose." on the screen
     *      If there is not a winner, display the text "Tie Game!" on the screen
     *  If the game is NOT over
     *      Display the current player's turn on the screen: "It your turn" or "Waiting for opponent."
     */
    public void update()
    {
        if(game.isGameOver())
        {
            currentPlayer.setText("Game Over!");

            Player win = game.getWinner();
            if(win == Player.A)
                winner.setText("X wins!");
            else if(win == Player.B)
                winner.setText("O Wins!");
            else
                winner.setText("Tie Game!");
        }
        else
        {
            Player curr = game.getCurrentPlayer();
            if(curr == Player.A)
                currentPlayer.setText("It is X's turn");
            else
                currentPlayer.setText("It is O's turn");
        }
    }

    /*
     *  Update the PieceActor located at (row, col) to display the specified TicTacToePiece
     */
    public void updatePiece(Player piece, int row, int col)
    {

        board[row][col].setPiece(piece);
    }
}