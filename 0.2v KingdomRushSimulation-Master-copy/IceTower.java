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
    
    Ice ice = new Ice();
    
    
    public IceTower(int range, int damage, boolean AOE)
    {
        super(range, damage, false);
    }
    
    public boolean damageMonster(){
        return false;
    }
    
    public void act(){
        getWorld().addObject(ice, getX(), getY() + 1);
    }
    public void spawnIce(){
        
    }
    public void slowEnemy(){
        
    }
}
