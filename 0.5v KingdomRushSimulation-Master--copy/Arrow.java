import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Arrow extends Projectile
{
    /**
     * Act - do whatever the Arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private double angle1;
    ArrowTower arrow = new ArrowTower();
    GreenfootImage image = getImage();
    public Arrow(double angle){
        this.angle1 = angle;
        image.scale(50, 100);
        image.rotate(90);
        
    }
    
    public void act()
    {
        super.act();
        move(50);
        
    }
    
    
    public void traveledMax(){
        int dx = getX() - arrow.getX();
        int dy = getY() - arrow.getY();
        double distance = Math.sqrt(dx*dx + dy*dy);
        if(distance >= 200){
            getWorld().removeObject(this);
        }
    }
    
    
}