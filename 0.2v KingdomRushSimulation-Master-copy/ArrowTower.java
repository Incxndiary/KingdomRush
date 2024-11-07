import greenfoot.*;

/**
 * Write a description of class ArrowTower here.
 * 
 * @version (a version number or a date)
 */
public class ArrowTower extends Towers
{
    private int range;
    private int damage;
    private boolean AOE;

    Arrow arrow = new Arrow();
    
    
    public ArrowTower(int range, int damage, boolean AOE)
    {
        super(range, damage, false);
    }
    
    public boolean damageMonster(){
        return false;
    }
    
    public void act(){
        getWorld().addObject(arrow, getX(), getY() + 1);
    }
    
    int x;
}
