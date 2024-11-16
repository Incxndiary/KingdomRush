import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ice extends Projectile
{
    /**
     * Act - do whatever the Ice wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private double angle1;
    IceTower ice = new IceTower();
    GreenfootImage image = getImage();
    
    public Ice(double angle){
        this.angle1 = angle;
        image.scale(50, 50);
        image.rotate(90);
        
    }
    
    public void act()
    {
        super.act();
        move(50);
    }
    
    
    public void traveledMax(){
        int dx = getX() - ice.getX();
        int dy = getY() - ice.getY();
        double distance = Math.sqrt(dx*dx + dy*dy);
        if(distance >= 200){
            getWorld().removeObject(this);
        }
    }
}
