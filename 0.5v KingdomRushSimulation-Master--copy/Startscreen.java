import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Startscreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Startscreen extends World
{
    
    int counter = 0;
    Label label = new Label("Start", 100);
    Label choose = new Label("Choose your Towers", 50);
    Label num = new Label(counter, 50);
    
    protected MainWorld world;
    GreenfootImage startImage;
    GreenfootImage otherImage;
    GreenfootImage arrowstart;
    GreenfootImage arrowfinish;
    SimpleTimer timer = new SimpleTimer();
    Arrowhead arrowhead = new Arrowhead();
    Button button = new Button();
    
    protected boolean mousePressed;
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
        
        arrowstart = new GreenfootImage("Arrowhead.png");
        arrowstart.scale(75, 50);
        arrowfinish = new GreenfootImage("Arrowhead1.png");
        arrowfinish.scale(75, 50);
        arrowhead.setImage(arrowstart);
        button.setImage(startImage);
        addObject(button, getWidth()/2, 600);
        addObject(new ArrowTower(), 300, getHeight()/2);
        addObject(num, 300, 500);
        addObject(arrowhead, 400, 500);
        
        mousePressed = false;
        
    }
    
    public void act(){
        world = new MainWorld();
        
        if(!mousePressed && Greenfoot.mousePressed(button)){
            button.setImage(otherImage);
            mousePressed = true;
        }
        
        else if(Greenfoot.mouseClicked(null)){
            button.setImage(startImage);
            //Greenfoot.setWorld(world);
            mousePressed = false;
        }
        
        if(Greenfoot.mouseClicked(button)){
            button.setImage(otherImage);
            Greenfoot.setWorld(world);
        }
        if(Greenfoot.mousePressed(arrowhead)){
            arrowhead.setImage(arrowfinish);
        }
        if(Greenfoot.mouseClicked(arrowhead)){
            arrowhead.setImage(arrowfinish);
            Greenfoot.delay(30);
            arrowhead.setImage(arrowstart);
            counter++;
        }
        
    }
}
