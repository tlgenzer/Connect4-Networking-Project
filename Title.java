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
    buttonConnect b;
    Sound a;
    Text ip;
    Text con;
    /**
     * Constructor for objects of class Title
     */
    public Title()
    {
        ip = new Text("", Color.WHITE);
        con = new Text("", Color.WHITE);
        addActor(con, 225, 200);
        addActor(ip, 175, 200);
        b = new buttonConnect();
        setBackground("img/background2.png");
        addActor(b, 250, 450);
        addActor(new buttonServer(), 550, 450);
    }
    public void add(){
        
    }
    public void update()
    {
        b.setText(ip);
        if(b.getCon()){
            b.setText2("Connected", ip);
        }
    }
}
