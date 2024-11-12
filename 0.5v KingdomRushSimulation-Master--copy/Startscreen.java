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
    Label choose = new Label("Choose your Towers", 50);
    protected MainWorld world;
    GreenfootImage startImage;
    GreenfootImage otherImage;
    Button button = new Button();
    /**
     * Constructor for objects of class Startscreen.
     * 
     */
    public Startscreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 750, 1); 
        addObject(choose, getWidth()/2, 300);
        startImage = new GreenfootImage("Play1.png");
        otherImage = new GreenfootImage("Play2.png");
        
        button.setImage(startImage);
        addObject(button, getWidth()/2, 600);
        
    }
    
    public void act(){
        world = new MainWorld();
        
        if(Greenfoot.mousePressed(button)){
            button.setImage(otherImage);
        }
        
        if(Greenfoot.mouseClicked(button)){
            button.setImage(otherImage);
            Greenfoot.setWorld(world);
            }
    }
}
