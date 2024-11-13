import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class ArrowTower extends Tower {
    private int range = 200;  // Range within which the tower will detect monsters
    private int shootCooldown = 30;  // Cooldown period between shots
    private int shootTimer = 0;  // Timer to track cooldown
    
    
    
    public void act() {
        Monster target = getTargetMonsterInRange();  // Get target monster within range

        if (target != null && shootTimer <= 0) {
            shootArrowAt(target);  // Shoot an arrow at the target
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

    private void shootArrowAt(Monster target) {
        // Calculate the angle towards the target
        int dx = target.getX() - getX();
        int dy = target.getY() - getY();
        double angle = Math.atan2(dy, dx);

        // Create an arrow and set its rotation towards the target
        Arrow arrow = new Arrow(angle);  // Pass angle to arrow
        getWorld().addObject(arrow, getX(), getY());  // Add arrow to the world
    }
}
