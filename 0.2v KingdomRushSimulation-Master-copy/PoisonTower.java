import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PoisonTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PoisonTower extends Tower
{
    private int range;
    private int damage;
    private boolean AOE;
    
    Poison poison = new Poison();
    
    
    public PoisonTower(int range, int damage, boolean AOE)
    {
        super(range, damage, false);
    }
    
    public boolean damageMonster(){
        return false;
    }
    
    public void act(){
        getWorld().addObject(poison, getX(), getY() + 1);
    }
    public void spawnPoison(){
        
    }
}
