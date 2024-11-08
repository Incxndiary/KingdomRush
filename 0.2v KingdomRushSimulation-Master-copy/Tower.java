import greenfoot.*;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Tower extends Actor
{
    protected int range; 
    protected int damage; 
    protected boolean AOE;
    protected Monster targetMonster;
    protected ArrayList<Monster> monsters;
    protected int towerX;
    protected int towerY;
    
    
    
    
    
    protected abstract boolean damageMonster();

    public Tower(int range, int damage, boolean AOE)
    {
        this.range = range;
        this.damage = damage;
        this.AOE = AOE;
        this.towerX = towerX;
        this.towerY = towerY;
        
        ArrayList<Integer> valueX = new ArrayList<>(Arrays.asList(150, 290, 475, 500, 880, 750));
        ArrayList<Integer> valueY = new ArrayList<>(Arrays.asList(375, 350, 300, 425, 300, 75));
        
    }

    public void act()
    {
        
    }
    
    

}
