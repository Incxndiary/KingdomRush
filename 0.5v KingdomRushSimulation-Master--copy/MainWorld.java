import greenfoot.*;  
import java.util.List;

/**
 * MainWorld initializes the gameplay with towers placed in the Slotscreen.
 */
public class MainWorld extends World {
    private GreenfootImage background;

    public MainWorld(List<TowerPlacement> towerPlacements) {
        super(1080, 750, 1, false);

        background = new GreenfootImage("background.png");
        setBackground(background);

        for (TowerPlacement placement : towerPlacements) {
            if (placement.getTowerType().equals("ArrowTower")) {
                addObject(new ArrowTower(), placement.getX(), placement.getY());
            } else if (placement.getTowerType().equals("IceTower")) {
                addObject(new IceTower(), placement.getX(), placement.getY());
            }
        }

        addObject(new MonsterSpawner(), 500, -100);
    }
    
     public static double getDistance(Actor a, Actor b){
        return Math.hypot(a.getX() - b.getX(), a.getY() - b.getY());
    }
    
}

/**
 * TowerPlacement class to store data about placed towers.
 */
class TowerPlacement {
    private String towerType;
    private int x, y;

    public TowerPlacement(String towerType, int x, int y) {
        this.towerType = towerType;
        this.x = x;
        this.y = y;
    }

    public String getTowerType() {
        return towerType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
