import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainWorld extends World
{
    MonsterSpawner origin = new MonsterSpawner();
    private GreenfootImage background;
    
    SimpleTimer timer = new SimpleTimer();
    int level = 1;
    Label levels = new Label(level, 50); 
    IceTower ice = new IceTower();
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MainWorld()
    {    
        
        super(1080, 750, 1, false); 
        MonsterSpawner spawner1 = new MonsterSpawner();
        addObject(spawner1, 300, 200);
        
        background = new GreenfootImage ("background.png");
        setBackground (background);
        spawn();
        addObject (new ArrowTower(), 150, 375);
        addObject(new IceTower(), 390, 350);
        
        addObject (new ArrowTower(), 150, 375);
        
        
    }
    
    public void act(){
        ArrayList<Integer> valueX = new ArrayList<>(Arrays.asList(150, 390, 575, 540, 830, 750));
        ArrayList<Integer> valueY = new ArrayList<>(Arrays.asList(375, 350, 300, 500, 300, 150));
        
        
        /*addObject (new ArrowTower(100, 10, false), 390, 350);
        addObject (new ArrowTower(100, 10, false), 575, 300);
        addObject (new ArrowTower(100, 10, false), 540, 500);
        addObject (new ArrowTower(100, 10, false), 830, 300);
        addObject (new ArrowTower(100, 10, false), 750, 150);
        */
    }
    private void spawn () {
        
        
        addObject (new Placeholder(origin), 500, -100);
        return;
        
    }
    
    /**
     * A z-sort method which will sort Actors so that Actors that are
     * displayed "higher" on the screen (lower y values) will show up underneath
     * Actors that are drawn "lower" on the screen (higher y values), creating a
     * better perspective. 
     */
    public static void zSort (ArrayList<Actor> actorsToSort, World world){
        ArrayList<ActorContent> acList = new ArrayList<ActorContent>();
        // Create a list of ActorContent objects and populate it with all Actors sent to be sorted
        for (Actor a : actorsToSort){
            acList.add (new ActorContent (a, a.getX(), a.getY()));
        }    
        // Sort the Actor, using the ActorContent comparitor (compares by y coordinate)
        Collections.sort(acList);
        // Replace the Actors from the ActorContent list into the World, inserting them one at a time
        // in the desired paint order (in this case lowest y value first, so objects further down the 
        // screen will appear in "front" of the ones above them).
        for (ActorContent a : acList){
            Actor actor  = a.getActor();
            world.removeObject(actor);
            world.addObject(actor, a.getX(), a.getY());
        }
    }
     public static double getDistance(Actor a, Actor b){
        return Math.hypot(a.getX() - b.getX(), a.getY() - b.getY());
    }
}
    
    /**
 * Container to hold and Actor and an LOCAL position (so the data isn't lost when the Actor is temporarily
 * removed from the World).
 */
class ActorContent implements Comparable <ActorContent> {
    private Actor actor;
    private int xx, yy;
    public ActorContent(Actor actor, int xx, int yy){
        this.actor = actor;
        this.xx = xx;
        this.yy = yy;
    }

    public void setLocation (int x, int y){
        xx = x;
        yy = y;
    }

    public int getX() {
        return xx;
    }

    public int getY() {
        return yy;
    }

    public Actor getActor(){
        return actor;
    }

    public String toString () {
        return "Actor: " + actor + " at " + xx + ", " + yy;
    }

    public int compareTo (ActorContent a){
        return this.getY() - a.getY();
    }

}

