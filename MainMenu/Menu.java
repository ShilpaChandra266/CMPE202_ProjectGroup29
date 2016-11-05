 

import greenfoot.*;
import java.awt.Color;

public class Menu extends World
{
    boolean Key1; // tracks the down state of the '1' key (Graph1) //Madhuri
    boolean Key2; // tracks the down state of the '2' key (Graph2) //Jon
    boolean Key3; // tracks the down state of the '3' key (Graph3) //Anubha
    boolean Key4; // tracks the down state of the '4' key (Graph4) //Shilpa
        
    public Menu()
    {
        super(800, 500, 1);
        GreenfootImage background = new GreenfootImage("Background.jpg");
        setBackground(background);
        background = getBackground();
        GreenfootImage text;
        text = new GreenfootImage("Welcome to the Graph Coloring Game!", 40, Color.black, new Color(0, 0, 0, 0));
        background.drawImage(text, 400-text.getWidth()/2, 50);
        text = new GreenfootImage("Graph Selection Menu", 32, Color.black, new Color(0, 0, 0, 0));
        background.drawImage(text, 400-text.getWidth()/2, 200);
        text = new GreenfootImage("Use '1' key to go to Graph1", 32, Color.black, new Color(0, 0, 0, 0));
        background.drawImage(text, 400-text.getWidth()/2, 300);
        text = new GreenfootImage("Use '2' key to go to Graph2", 32, Color.black, new Color(0, 0, 0, 0));
        background.drawImage(text, 400-text.getWidth()/2, 340);
        text = new GreenfootImage("Use '3' key to go to Graph3", 32, Color.black, new Color(0, 0, 0, 0));
        background.drawImage(text, 400-text.getWidth()/2, 380);
        text = new GreenfootImage("Use '4' key to go to Graph4", 32, Color.black, new Color(0, 0, 0, 0));
        background.drawImage(text, 400-text.getWidth()/2, 420);
    }
    
    public void act()
    {
        if (!Key1 && Greenfoot.isKeyDown("1"))
        {
            Greenfoot.setWorld(new Graph1());
            Key1 = true;
        }

        if (!Key2 && Greenfoot.isKeyDown("2"))
        {
            Greenfoot.setWorld(new Graph2());
            Key2 = true;
        }
        
        if (!Key3 && Greenfoot.isKeyDown("3"))
        {
            Greenfoot.setWorld(new Graph3());
            Key3 = true;
        }
        
        if (!Key4 && Greenfoot.isKeyDown("4"))
        {
            Greenfoot.setWorld(new Graph4());
            Key4 = true;
        }
    }
}