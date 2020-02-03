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
        setPicture("img/buttonServer.png");
    }
    //opens server when button is clicked
    public void update()
    {
        if(this.isClicked())
        {
            new Connect4Server(1234);
            setPicture("img/buttonServerD.png");
        }
    }
}
