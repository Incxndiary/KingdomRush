import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Startscreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Startscreen extends World
{
    Label label = new Label("Start", 100);
    protected MainWorld world;
    /**
     * Constructor for objects of class Startscreen.
     * 
     */
    public Startscreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 750, 1); 
        addObject(label, getWidth()/2, 500);
        
    }
    
    public void act(){
        world = new MainWorld();
        if(Greenfoot.mouseClicked(label)){
            Greenfoot.setWorld(world);
        }
    }
}
