import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Arrow extends Projectile
{
    /**
     * Act - do whatever the Arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    ArrowTower tower = new ArrowTower(5, 20, false);
    double X = tower.getX();
    double Y = tower.getY();
    
    public Arrow(){
        
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void spawn(){
        addObject(X, Y);
    }
}