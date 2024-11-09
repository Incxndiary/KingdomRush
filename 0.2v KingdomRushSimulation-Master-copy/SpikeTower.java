import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpikeTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpikeTower extends Tower
{
    private int range;
    private int damage;
    private boolean AOE;
    
    Spike spike = new Spike();
    
    
    public SpikeTower(int range, int damage, boolean AOE)
    {
        super(range, damage, false);
    }
    
    public void spawnObject(){
        
    }
    
    public void act(){
        getWorld().addObject(spike, getX(), getY() + 1);
    }
    public void spawnSpike(){
        
    }
}
