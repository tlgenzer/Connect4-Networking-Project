import mayflower.*;
import java.awt.Color;

/**
 * Write a description of class Title here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Title extends Stage
{
    //creates a background, 2 buttons, and starts playing music
    Sound a;
    /**
     * Constructor for objects of class Title
     */
    public Title()
    {
        setBackground("img/background2.png");
        addActor(new buttonConnect(), 250, 450);
        addActor(new buttonServer(), 550, 450);
    }

    public void update()
    {
        
    }
}
