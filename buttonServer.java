import mayflower.*;
import java.awt.Color;
/**
 * Write a description of class buttonServer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class buttonServer extends Actor
{

    /**
     * Constructor for objects of class buttonServer
     */
    public buttonServer()
    {
        setPicture("img/test.png");
    }

    public void update()
    {
        if(this.isClicked())
        {
            new TicTacToeServer(1234);
        }
    }
}
