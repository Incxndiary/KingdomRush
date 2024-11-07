import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PoisonTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PoisonTower extends Tower
{
    
    /**
     * Act - do whatever the PoisonTower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public PosionTower(int range, int damage, boolean AOE, int towerX, int towerY)
    {
        super(range, damage, false, towerX, towerY);
    }
    
    public void act(){
        // Add your action code here.
    }
    
    public boolean damageMonster() {
        return false;
    }
}
