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
    Label invalid = new Label("Max towers reached", 50);
    Label invalid1 = new Label("Min towers reached", 50);
    protected MainWorld world;
    GreenfootImage startImage;
    GreenfootImage otherImage;
    GreenfootImage arrowstart;
    GreenfootImage arrowfinish;
    GreenfootImage arrowleft;
    GreenfootImage arrowleft1;
    
    
    Arrowhead arrowhead = new Arrowhead();
    Arrowhead arrowhead1 = new Arrowhead();
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
        
        arrowleft = arrowstart;
        arrowleft.rotate(180);
        
        arrowleft1 = arrowfinish;
        arrowleft.rotate(180);
        
        arrowhead.setImage(arrowstart);
        arrowhead1.setImage(arrowleft);
        
        
        button.setImage(startImage);
        addObject(button, getWidth()/2, 600);
        addObject(new ArrowTower(), 300, getHeight()/2);
        addObject(num, 300, 500);
        
        addObject(arrowhead, 400, 500);
        addObject(arrowhead1, 200, 500);
        
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
        
        
        add();
        subtract();
        
        if(Greenfoot.mouseClicked(button)){
            button.setImage(otherImage);
            Greenfoot.setWorld(world);
        }
        
        
    }
    
    public void add(){
        if(!mousePressed && Greenfoot.mousePressed(arrowhead)){
            arrowhead.setImage(arrowfinish);
            mousePressed = true;
            if(counter >= 6){
                addObject(invalid, getWidth()/2, 100);
                Greenfoot.delay(30);
                removeObject(invalid);
            }else{
                counter += 1;
                num.setValue(counter);
            }
            
        }
        
        else if(Greenfoot.mouseClicked(null)){
            arrowhead.setImage(arrowstart);
            
            //Greenfoot.setWorld(world);
            mousePressed = false;
        }
    }
    
    public void subtract(){
        if(!mousePressed && Greenfoot.mousePressed(arrowhead1)){
            arrowhead1.setImage(arrowleft1);
            mousePressed = true;
            if(counter <= 0){
                addObject(invalid1, getWidth()/2, 100);
                Greenfoot.delay(30);
                removeObject(invalid1);
            }else{
                counter = counter - 1;
                num.setValue(counter);
            }
            
        }
        
        else if(Greenfoot.mouseClicked(null)){
            arrowhead1.setImage(arrowleft);
            
            //Greenfoot.setWorld(world);
            mousePressed = false;
        }
    }
    
}
