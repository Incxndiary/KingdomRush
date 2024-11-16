import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class IceTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IceTower extends Tower
{
    private int range = 150;  // Range within which the tower will detect monsters
    private int shootCooldown = 20;  // Cooldown period between shots
    private int shootTimer = 0;  // Timer to track cooldown
    GreenfootImage image = getImage();
    
    public IceTower(){
        image.scale(100, 100);
    }
    
    
    public void act() {
        Monster target = getTargetMonsterInRange();  // Get target monster within range

        if (target != null && shootTimer <= 0) {
            shootIceAt(target);  // Shoot an arrow at the target
            shootTimer = shootCooldown;  // Reset cooldown timer
        }

        if (shootTimer > 0) {
            shootTimer--;  // Decrement timer
        }
    }

    private Monster getTargetMonsterInRange() {
        List<Monster> monsters = getObjectsInRange(range, Monster.class);  // Get all monsters within range
        if (!monsters.isEmpty()) {
            return monsters.get(0);  // Return the first monster found in range
        }
        return null;  // Return null if no monster is in range
    }

    private void shootIceAt(Monster target) {
        // Calculate the angle towards the target
        int dx = target.getX() - getX();
        int dy = target.getY() - getY();
        double angle = Math.atan2(dy, dx);

        // Create an arrow and set its rotation towards the target
        Ice ice = new Ice(angle);  // Pass angle to arrow
        getWorld().addObject(ice, getX(), getY());  // Add arrow to the world
    }
}
