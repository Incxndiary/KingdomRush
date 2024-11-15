import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IceTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IceTower extends Tower
{
    private int range;
    private int damage;
    private boolean AOE;
    int level = 0;
    Ice ice = new Ice();
    Label levels = new Label(level, 50); 
    GreenfootImage image = getImage();
    public IceTower(){
        image.scale(150, 200);
        setImage(image);
        
    }
    
    public void spawnObject(){
        
    }
    
    public void act(){
        getWorld().addObject(ice, getX(), getY() + 1);
    }
    public void spawnIce(){
        
    }
    public void slowEnemy(){
        
    }
}
