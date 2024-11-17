import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Slotscreen handles tower placement by the player and transitions to MainWorld.
 */
public class Slotscreen extends World {
    private int arrowTowerCount;
    private int iceTowerCount;
    private List<Frame> availableSlots;
    private List<TowerPlacement> placedTowers;
    private Label promptLabel;
    private boolean isPlacingArrowTowers = true;

    public Slotscreen(int arrowTowerCount, int iceTowerCount) {
        super(1080, 750, 1);
        this.arrowTowerCount = arrowTowerCount;
        this.iceTowerCount = iceTowerCount;
        availableSlots = new ArrayList<>();
        placedTowers = new ArrayList<>();

        
        addSlot(new Frame(), 150, 375);
        addSlot(new Frame(), 390, 350);
        addSlot(new Frame(), 575, 300);
        addSlot(new Frame(), 540, 530);
        addSlot(new Frame(), 830, 330);
        addSlot(new Frame(), 750, 150);

        promptLabel = new Label("", 50);
        addObject(promptLabel, getWidth() / 2, 50);

       
        placeTowers();
    }

    private void addSlot(Frame frame, int x, int y) {
        addObject(frame, x, y);
        availableSlots.add(frame);
    }

    private void placeTowers() {
        if (isPlacingArrowTowers) {
            if (arrowTowerCount > 0) {
                promptLabel.setValue("Place an Arrow Tower: Click a slot");
            } else {
                isPlacingArrowTowers = false;
                placeTowers();
            }
        } else {
            if (iceTowerCount > 0) {
                promptLabel.setValue("Place an Ice Tower: Click a slot");
            } else {
                promptLabel.setValue("All towers placed!");
                Greenfoot.setWorld(new MainWorld(placedTowers));
            }
        }
    }

    public void act() {
        if (Greenfoot.mouseClicked(null)) {
            Actor clickedSlot = Greenfoot.getMouseInfo().getActor();
            if (clickedSlot instanceof Frame && availableSlots.contains(clickedSlot)) {
                int x = clickedSlot.getX();
                int y = clickedSlot.getY();

                if (isPlacingArrowTowers) {
                    addObject(new ArrowTower(), x, y);
                    placedTowers.add(new TowerPlacement("ArrowTower", x, y));
                    arrowTowerCount--;
                } else {
                    addObject(new IceTower(), x, y);
                    placedTowers.add(new TowerPlacement("IceTower", x, y));
                    iceTowerCount--;
                }

                availableSlots.remove(clickedSlot);
                removeObject(clickedSlot);
                placeTowers();
            }
        }
    }
}
