import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Slowdown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlowEffect extends Actor {
    public SlowEffect(int radius) {
        GreenfootImage image = new GreenfootImage(radius * 2, radius * 2);
        image.setColor(new Color(0, 0, 255, 100)); // Blue with transparency
        image.fillOval(0, 0, radius * 2, radius * 2);
        setImage(image);
    }
}
