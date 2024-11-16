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
    GreenfootImage arrowLeftPressed;
    GreenfootImage arrowRightPressed;
    GreenfootImage arrowLeft;
    GreenfootImage arrowRight;
    
    
    Arrowhead arrowheadLeft = new Arrowhead();
    Arrowhead arrowheadRight = new Arrowhead();
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
        
        arrowLeft = new GreenfootImage("Arrowhead.png");
        arrowLeft.scale(75, 50);
        arrowLeft.mirrorHorizontally();
        
        arrowRight = new GreenfootImage("Arrowhead.png");
        arrowRight.scale(75, 50);
        
        
        arrowLeftPressed = new GreenfootImage("Arrowhead1.png");
        arrowLeftPressed.scale(75, 50);
        arrowLeftPressed.mirrorHorizontally();
        
        arrowRightPressed = new GreenfootImage("Arrowhead1.png");
        arrowRightPressed.scale(75, 50);
        
        
        //setImage(arrowRight);
        
        //arrowleft = arrowstart;
        //arrowleft.rotate(180);
        
        //arrowRight = arrowstart;
        //arrowleft.rotate(180);
        
        arrowheadLeft.setImage(arrowLeft);
        arrowheadRight.setImage(arrowRight);
        
        
        button.setImage(startImage);
        addObject(button, getWidth()/2, 600);
        addObject(new ArrowTower(), 300, getHeight()/2);
        addObject(num, 300, 500);
        
        addObject(arrowheadRight, 400, 500);
        addObject(arrowheadLeft, 200, 500);
        //arrowhead.getImage().mirrorHorizontally();
        //arrowhead.setImage(arrowhead.getImage());//Mirror the image

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
        if(!mousePressed && Greenfoot.mousePressed(arrowheadRight)){
            arrowheadRight.setImage(arrowRightPressed);
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
            arrowheadLeft.setImage(arrowLeft);
            
            //Greenfoot.setWorld(world);
            mousePressed = false;
        }
    }
    
    public void subtract(){
        if(!mousePressed && Greenfoot.mousePressed(arrowheadLeft)){
            
            arrowheadLeft.setImage(arrowLeftPressed);
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
            arrowheadRight.setImage(arrowRight);
            
            //Greenfoot.setWorld(world);
            mousePressed = false;
        }
    }
    
}
