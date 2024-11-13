import greenfoot.*;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Tower extends Actor
{
    protected int range; 
    protected boolean AOE;
    protected Monster targetMonster;
    protected ArrayList<Monster> monsters;
    protected int counter;
    protected int level;
    
    

    

    public Tower(){
        ArrayList<Integer> valueX = new ArrayList<>(Arrays.asList(150, 290, 475, 500, 880, 750));
        ArrayList<Integer> valueY = new ArrayList<>(Arrays.asList(375, 350, 300, 425, 300, 75));
        
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

        monsters = (ArrayList<Monster>)getObjectsInRange(range, Monster.class);
        
        if (monsters.size() > 0)
        {
            // set the first one as my target
            targetMonster = monsters.get(0);
            closestTargetDistance = MainWorld.getDistance (this, targetMonster);
            
        }
    }
    
    
    
    
    

}
