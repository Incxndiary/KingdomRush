import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Startscreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Startscreen extends World
{
    
    public int counter = 0;
    public int counter1 = 0;
    Label label = new Label("Start", 100);
    Label choose = new Label("Choose your Towers", 50);
    Label num = new Label(counter, 50);
    Label num1 = new Label(counter1, 50);
    Label invalid = new Label("Max towers reached", 50);
    Label invalid1 = new Label("Min towers reached", 50);
    protected Slotscreen world;
    GreenfootImage startImage;
    GreenfootImage otherImage;
    GreenfootImage arrowLeftPressed;
    GreenfootImage arrowRightPressed;
    GreenfootImage arrowLeft;
    GreenfootImage arrowRight;
    
    
    GreenfootImage aIR;
    GreenfootImage aIL;
    GreenfootImage aIR1;
    GreenfootImage aIL1;
    
    Arrowhead arrowheadLeft = new Arrowhead();
    Arrowhead arrowheadRight = new Arrowhead();
    Arrowhead aHL1 = new Arrowhead();
    Arrowhead aHR1 = new Arrowhead();
    
    
    
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
        
        aIR = new GreenfootImage("Arrowhead.png");
        aIR.scale(75, 50);
        
        aIL = new GreenfootImage("Arrowhead.png");
        aIL.scale(75, 50);
        aIL.mirrorHorizontally();
        
        aIR1 = new GreenfootImage("Arrowhead1.png");
        aIR1.scale(75, 50);
        
        aIL1 = new GreenfootImage("Arrowhead1.png");
        aIL1.scale(75, 50);
        aIL1.mirrorHorizontally();
        
        arrowheadLeft.setImage(arrowLeft);
        arrowheadRight.setImage(arrowRight);
        aHL1.setImage(aIL);
        aHR1.setImage(aIR);
        
        
        button.setImage(startImage);
        addObject(button, getWidth()/2, 600);
        addObject(new ArrowTower(), 100, getHeight()/2);
        addObject(num, 100, 500);
        addObject(new IceTower(), 400, getHeight()/2);
        addObject(num1, 400, 500);
        
        
        addObject(arrowheadRight, 175, 500);
        addObject(arrowheadLeft, 25, 500);
        addObject(aHR1, 475, 500);
        addObject(aHL1, 325, 500);
        
        //arrowhead.getImage().mirrorHorizontally();
        //arrowhead.setImage(arrowhead.getImage());//Mirror the image

        mousePressed = false;
        
    }
    
    public void act() {
        if (!mousePressed && Greenfoot.mousePressed(button)) {
            button.setImage(otherImage);
            mousePressed = true;
        } else if (Greenfoot.mouseClicked(null)) {
            button.setImage(startImage);
            mousePressed = false;
        }
    
        add();
        subtract();
    
        if (Greenfoot.mouseClicked(button)) {
            button.setImage(otherImage);
    
            // Pass the counter values to the new Slotscreen world
            Slotscreen world = new Slotscreen(counter, counter1);
            Greenfoot.setWorld(world);
        }
    }

    
    public void add(){
        if(!mousePressed && Greenfoot.mousePressed(arrowheadRight)){
            arrowheadRight.setImage(arrowRightPressed);
            mousePressed = true;
            if(counter + counter1 >= 6){
                addObject(invalid, getWidth()/2, 100);
                Greenfoot.delay(30);
                removeObject(invalid);
            }else{
                counter += 1;
                num.setValue(counter);
            }
            
        }else if(!mousePressed && Greenfoot.mousePressed(aHR1)){
            aHR1.setImage(aIR1);
            mousePressed = true;
            if(counter + counter1 >= 6){
                addObject(invalid, getWidth()/2, 100);
                Greenfoot.delay(30);
                removeObject(invalid);
            }else{
                counter1 += 1;
                num1.setValue(counter1);
            }
        }else if(Greenfoot.mouseClicked(null)){
            arrowheadRight.setImage(arrowRight);
            aHR1.setImage(aIR);
            
            //Greenfoot.setWorld(world);
            mousePressed = false;
        }
        
        
    }
    
    public void subtract() {
        if (!mousePressed && Greenfoot.mousePressed(arrowheadLeft)) {
            arrowheadLeft.setImage(arrowLeftPressed);
            mousePressed = true;
    
            
            if (counter <= 0) {
                addObject(invalid1, getWidth() / 2, 100);
                Greenfoot.delay(30);
                removeObject(invalid1);
            } else {
                counter = counter - 1;
                num.setValue(counter);
            }
    
        } else if (!mousePressed && Greenfoot.mousePressed(aHL1)) {
            aHL1.setImage(aIL1);
            mousePressed = true;
    
            
            if (counter1 <= 0) {
                addObject(invalid1, getWidth() / 2, 100);
                Greenfoot.delay(30);
                removeObject(invalid1);
            } else {
                counter1 = counter1 - 1;
                num1.setValue(counter1);
            }
    
        } else if (Greenfoot.mouseClicked(null)) {
            arrowheadLeft.setImage(arrowLeft);
            aHL1.setImage(aIL);
            mousePressed = false;
        }
    }

    
    public int getcount(){
        return counter;
    }
    
    public int getcount1(){
        return counter1;
    }
}
