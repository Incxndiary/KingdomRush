import greenfoot.*;
import java.util.ArrayList;

public abstract class Tower extends Actor
{
    protected int range; 
    protected int damage; 
    protected boolean AOE;
    protected Monster targetMonster;
    protected ArrayList<Monster> monsters;
    protected int towerX;
    protected int towerY;
    
    ArrayList<int> Xvalue = 
    
    
    protected abstract boolean damageMonster();

    public Tower(int range, int damage, boolean AOE, int towerX, int towerY)
    {
        this.range = range;
        this.damage = damage;
        this.AOE = AOE;
        this.towerX = towerX;
        this.towerY = towerY;
        
        
    }

    public void act()
    {
        damageClosestMonster();
    }
    
    public void damageClosestMonster()
    {
        Monster closestMonster = getClosestMonsterInRange();
        if (closestMonster != null) {
            closestMonster.takeDamage(damage); 
        }
    }
    
    private Monster getClosestMonsterInRange()
    {
        ArrayList<Monster> monsters = (ArrayList<Monster>) getObjectsInRange(range, Monster.class);
        Monster closestMonster = null;
        double closestDistance = Double.MAX_VALUE;

        for (Monster monster : monsters) {
            double distance = getDistance(monster);
            if (distance < closestDistance) {
                closestDistance = distance;
                closestMonster = monster;
            }
        }

        return closestMonster;
    }
    private void targetClosestMonster ()
    {
        double closestTargetDistance = 0;
        double distanceToActor;
        // Get a list of all monster in the World, cast it to ArrayList
        // for easy management

        monsters = (ArrayList<Monster>)getObjectsInRange(40, Monster.class);
        if (monsters.size() == 0){

            monsters = (ArrayList<Monster>)getObjectsInRange(150, Monster.class);
        } 
        if (monsters.size() == 0){

            monsters = (ArrayList<Monster>)getObjectsInRange(300, Monster.class);
        } 
        if (monsters.size() == 0){
            //monster = (ArrayList<Monsters>)getWorld().getObjects(Monsters.class);
        } 

        if (monsters.size() > 0)
        {
            // set the first one as my target
            targetMonster = monsters.get(0);
            // Use method to get distance to target. This will be used
            // to check if any other targets are closer
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
    }
    
    private double getDistance(Actor actor)
    {
        int dx = actor.getX() - getX();
        int dy = actor.getY() - getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

}
