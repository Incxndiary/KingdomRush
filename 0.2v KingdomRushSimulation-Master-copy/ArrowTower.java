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
    SimpleTimer timer = new SimpleTimer();
    
    Arrow arrow = new Arrow();
    
    
    public ArrowTower(int range, int damage, boolean AOE)
    {
        super(range, damage, false);
    }
    
    public boolean damageMonster(){
        return false;
    }
    
    public void act(){
        spawnArrow();
    }
    public void spawnArrow(){
        if((timer.millisElapsed() + 6000)% 6000 == 0){
            getWorld().addObject(arrow, getX(), getY());
        }
        
    }
    
    int x;
}
