import greenfoot.*;
import java.util.ArrayList;

/**
 * Write a description of class ArrowTower here.
 * 
 * @version (a version number or a date)
 */
public class ArrowTower extends Tower
{
    private int range;
    private boolean AOE;
    SimpleTimer timer = new SimpleTimer();
    private int counter = 0;
    
    
    
    
    public ArrowTower(int range, boolean AOE)
    {
        super(range, false);
        range = 100;
        
    }
    
    public void spawnObject(){
        
        Arrow arrow = new Arrow(); // Create a new instance of Arrow
        getWorld().addObject(arrow, this.getX(), this.getY());
        
                
    }
    
    public void act() {
        super.act();
        if(Monster.class != null){
            if(counter % 60 == 0){
                spawnObject();
            }
            counter++;
        }
        
        
    }
    

    
}
