import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    private GreenfootImage projectileImage;
    private int damage;
    private boolean isHit;
    protected Monster targetMonster;
    protected ArrayList<Monster> monsters;
    protected int range; 
    
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Projectile(){
        
    }
    public void act()
    {
        targetClosestMonster();
        
    }
    
    protected void targetClosestMonster ()
    {
        double closestTargetDistance = 0;
        double distanceToActor;
        // Get a list of all monster in the World, cast it to ArrayList
        // for easy management

        monsters = (ArrayList<Monster>)getObjectsInRange(200, Monster.class);
        
        if (monsters.size() > 0)
        {
            // set the first one as my target
            targetMonster = monsters.get(0);
            closestTargetDistance = MainWorld.getDistance (this, targetMonster);

            // Loop through the objects in the ArrayList to find the closest target
            for (Monster m : monsters)
            {
                // Cast for use in generic method
                //Actor a = (Actor) o;
                // Measure distance from me
                distanceToActor = MainWorld.getDistance(this, m);
                // If I find a Monsters closer than my current target, I will change
                // targets
                if (distanceToActor < closestTargetDistance)
                {
                    targetMonster = m;
                    closestTargetDistance = distanceToActor;
                }
            }
            turnTowards(targetMonster.getX(), targetMonster.getY());
            
            
        }
        return;
    }
    
    
    
}
