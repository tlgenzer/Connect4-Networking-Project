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
    Sound titleSound;
    /**
     * Constructor for objects of class buttonConnect
     */
    public buttonConnect()
    {
        setPicture("img/buttonConnect.png");
        titleSound = new Sound("sounds/nokia_arabic.wav");
        titleSound.loop();
    }

    public void update()
    {
        if(this.isClicked())
        {
            new TicTacToeClient();
            setPicture("img/buttonConnectD.png");
            titleSound.stop();
        }
    }
}
