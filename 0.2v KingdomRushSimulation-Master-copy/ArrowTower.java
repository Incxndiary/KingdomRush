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
    private int counter = 0;
    

    
    
    public ArrowTower(int range, int damage, boolean AOE)
    {
        super(range, damage, false);
    }
    
    public void spawnObject(){
        Arrow arrow = new Arrow(); // Create a new instance of Arrow
        getWorld().addObject(arrow, this.getX(), this.getY());
                
    }
    
    public void act() {
        super.act();
        if (counter % 60 == 0) {
            spawnObject(); // Call spawnObject to add a new arrow
        }
        counter++; // Increment the counter every act
    }
    

    
}
