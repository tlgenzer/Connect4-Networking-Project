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
    boolean isPressed;
    /**
     * Constructor for objects of class buttonConnect
     */
    public buttonConnect()
    {
        isPressed = false;
        setPicture("img/buttonConnect.png");
        titleSound = new Sound("sounds/title.wav");
        titleSound.loop();
    }
    public boolean getPress(){
        return isPressed;
    }
    public void update()
    {
        if(this.isClicked())
        {
            new Connect4Client(this);
            setPicture("img/buttonConnectD.png");
            titleSound.stop();
            isPressed=true;
        }
    }
}
