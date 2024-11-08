import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MageTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MageTower extends Tower
{
    private int range;
    private int damage;
    private boolean AOE;
    
    Fireball fireball = new Fireball();
    
    
    public MageTower(int range, int damage, boolean AOE)
    {
        super(range, damage, false);
    }
    
    public boolean damageMonster(){
        return false;
    }
    
    public void act(){
        getWorld().addObject(fireball, getX(), getY() + 1);
    }
    public void spawnFireball(){
        
    }
}
