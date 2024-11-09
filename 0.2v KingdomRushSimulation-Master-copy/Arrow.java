import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Arrow extends Projectile
{
    /**
     * Act - do whatever the Arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    

    GreenfootImage image = getImage();
    public Arrow(){
        image.scale(50, 100);
        image.rotate(90);
        
    }
    
    public void act()
    {
        super.act();
        move(3);

    }
    
    
}