import greenfoot.*;

/**
 * Write a description of class ArrowTower here.
 * 
 * @version (a version number or a date)
 */
public class ArrowTower extends Tower
{
    private int range;
    private int damage;
    private boolean AOE;
    
    Arrow arrow = new Arrow();
    
    
    public ArrowTower(int range, int damage, boolean AOE, int towerX, int towerY)
    {
        super(range, damage, false, towerX, towerY);
    }
    
    public boolean damageMonster(){
        return false;
    }
    
    public void act(){
        getWorld().addObject(arrow, getX(), getY() + 1);
    }
    public void spawnArrow(){
        
    }
    int x;
}
