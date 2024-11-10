import greenfoot.*;

public abstract class Monster extends SuperSmoothMover {
    protected int health, maxHealth, barDisappearDelay;
    protected double speed, maxSpeed;
    protected Path path;
    protected MonsterSpawner origin;

    protected int poisonDamageInterval;
    protected boolean poison;
    protected int poisonedDamage;

    private SuperStatBar healthBar;
    private boolean damagedThisAct, showHealth;
    protected GreenfootImage image;

    public Monster(MonsterSpawner origin, int health, double speed) {
        this.origin = origin;
        this.health = health;
        this.maxHealth = health;
        this.speed = speed;
        this.maxSpeed = speed;

        healthBar = new SuperStatBar(maxHealth, health, this, 36, 4, -20, Color.GREEN, Color.RED, true, Color.BLACK, 0);
        showHealth = false;
        
        poison = false;
        poisonDamageInterval = 0;
        poisonedDamage = 0;

        path = new Path(0.1);
        initializePath();
        damagedThisAct = false;
    }
    
    private void initializePath() {
        path.addPoint(525, 130);
        path.addPoint(560, 170);
        path.addPoint(580, 220);
        path.addPoint(645, 235);
        path.addPoint(690, 245);
        path.addPoint(780, 250);
        path.addPoint(845, 250);
        path.addPoint(950, 300);
        path.addPoint(955, 350);
        path.addPoint(950, 450);
        path.addPoint(925, 500);
        path.addPoint(828, 543);
        path.addPoint(675, 580);
        path.addPoint(571, 596);
        path.addPoint(452, 585);
        path.addPoint(386, 444);
        path.addPoint(280, 374);
        path.addPoint(278, 349);
        path.addPoint(290, 280);
        path.calculateRotationVectors();
        enableStaticRotation();
    }
    
    public void act() {
        PathResult start = path.move(this, speed, 3.6);
        setLocation(start.getNewX(), start.getNewY());
        setRotation(start.getRotationAngle());

        if (poison) {
            poisonDamageInterval--;
            if (poisonDamageInterval % 10 == 0) {
                health -= poisonedDamage;
            }
            if (poisonDamageInterval <= 0) {
                poison = false;
                speed = maxSpeed;
                setImage("man01.png"); 
            }
        }
        
        updateHealthBar();
    }
    
    private void updateHealthBar() {
        if (damagedThisAct || barDisappearDelay > 0) {
            showHealth = true;
            barDisappearDelay--;
        }
        if (showHealth) {
            getWorld().addObject(healthBar, getX(), getY());
            healthBar.update(health);
        }
    }
    
    public void addedToWorld(World w) {}

    public void takeDamage(int damage, boolean isPoisoned) {
        health -= damage;
        damagedThisAct = true;

        if (isPoisoned) {
            poisonDamageInterval = 100;
            speed = maxSpeed / 2;
            poison = true;
            setImage("poisonedImage.png");
            poisonedDamage = damage / 10;
        }
    }
    
    public void arrowDamage(int damage){
        
        health =- damage;
        System.out.println(health);
    }
    
    public double getHealth() {
        return health;
    }
}
