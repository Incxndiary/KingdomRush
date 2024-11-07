import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PoisonTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PoisonTower extends Towers
{
    
    /**
     * Act - do whatever the PoisonTower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public PoisonTower(int range, int damage, boolean AOE){
        super(range, damage, true);
    }
    
    public void act(){
        // Add your action code here.
    }
    
    public boolean damageMonster() {
        return false;
    }
}
