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
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Projectile(){
        
    }
    public void act()
    {
        // Add your action code here.
    }
    public void doDamageAOE(int radius){
        ArrayList<Monster> enemies = (ArrayList<Monster>)getObjectsInRange(radius, Monster.class);
        for (Monster m : enemies){
            m.takeDamage(damage);
            if(m.getHealth() <=0){
                getWorld().removeObject(m);
            }
        }
    }
}
