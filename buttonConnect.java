import mayflower.*;
import java.awt.Color;
import java.util.Scanner;
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
    String ip;
    String curkey;
    boolean enter;
    boolean up;
    String curkey2;
    boolean isCon;
    /**
     * Constructor for objects of class buttonConnect
     */
    public buttonConnect()
    {
        isCon = false;
        up = false;
        enter = false;
        ip = "";
        curkey = null;
        curkey2 = null;
        isPressed = false;
        setPicture("img/buttonConnect.png");
        titleSound = new Sound("sounds/title.wav");
        titleSound.loop();
    }
    public Text setText(Text t){
        t.setText("Enter IP Here: " + ip);
        return t;
    }
    public Text setText2(String a, Text t){
        t.setText(""+a);
        return t;
    }
    public boolean getPress(){
        return isPressed;
    }
    public String getIP(){
        if(enter){
            return ip;
        }
        return null;
    }
    public void setEnter(boolean a){
        enter = a;
    }
    public void setCon(boolean a){
        isCon = a;
    }
    public boolean getCon(){
        return isCon;
    }
    public void update()
    {
        if(this.isClicked())
        {
            setPicture("img/buttonConnectD.png");
            titleSound.stop();
            isPressed=true;
            System.out.println("Use localhost to connect to a server running on your computer.");
            System.out.println("Press l For localhost");
        }
        if(isPressed==true){
            String curip = ip;
            String add = "";
            if(getKeyboard().isKeyReleased(curkey)){
                curkey=null;
            }
            if(getKeyboard().isKeyReleased(curkey2)){
                curkey2=null;
            }
            for(int i = 0; i<10; i++){
                if(getKeyboard().isKeyReleased(curkey) || curkey==null){
                    if(getKeyboard().isKeyPressed("" + i) || getKeyboard().isKeyPressed("period") || getKeyboard().isKeyPressed("backspace")){
                        if(getKeyboard().isKeyPressed("period")){
                            ip += ".";
                            add = ".";
                            curkey = "period";
                        }
                        else if(getKeyboard().isKeyPressed("backspace")){
                            if(ip.length()>0){
                                ip = ip.substring(0, ip.length()-1);
                                curkey = "backspace";
                            }
                        }
                        else{
                            ip += "" + i;
                            add = "" + i;
                            curkey = ""+i;
                        }
                    }
                }
            }
            if(getKeyboard().isKeyPressed("l")){
                ip = "localhost";
            }
            if(getKeyboard().isKeyReleased(curkey2) || curkey2==null){
                if(getKeyboard().isKeyPressed("enter")){
                    enter=true;
                    new Connect4Client(this);
                    up = true;
                    curkey2 = "enter";
                }
            }
        }
    }
}
