import mayflower.*;
import java.awt.Color;
/**
 * Write a description of class buttonConnect here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class buttonConnect extends Actor
{

    /**
     * Constructor for objects of class buttonConnect
     */
    public buttonConnect()
    {
        setPicture("img/buttonConnect.png");
    }

    public void update()
    {
        if(this.isClicked())
        {
            new TicTacToeClient();
        }
    }
}
