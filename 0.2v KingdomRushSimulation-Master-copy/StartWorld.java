import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.*; 
/**
 * Write a description of class StartWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartWorld extends World
{
    Label Start = new Label("Start", 100);
    
    /**
     * Constructor for objects of class StartWorld.
     * 
     */
    public StartWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super(1080, 750, 1); 
        addObject(Start, getWidth()/2, 600);
        ArrayList<Integer> valueX = new ArrayList<>(Arrays.asList(150, 390, 575, 540, 830, 750));
        ArrayList<Integer> valueY = new ArrayList<>(Arrays.asList(375, 350, 300, 500, 300, 150));
        possibleSlots();
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(Start)){
            MainWorld main = new MainWorld();
            Greenfoot.setWorld(main);
        }
    }
    
    public void possibleSlots(){
        Frame frame = new Frame();
        addObject(frame, 150, 375);
    }
    
    
}
