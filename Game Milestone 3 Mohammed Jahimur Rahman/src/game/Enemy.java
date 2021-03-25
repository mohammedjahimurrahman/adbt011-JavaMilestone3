package game;

import city.cs.engine.*;

public class Enemy extends Walker {
    /**
     * Name of enemy
     */
    private String name;
    /**
     * The Health point of enemy
     */
    private int healthPoints;

    /**
     * The character field to later initialise and accesss
     */
    private Characters characters;

    //Slime Enemy Image and Shape created


    /**
     * Creates enemy Image for body
     */
    private static final BodyImage slimeImage = new BodyImage("data/slime.gif", 8f);

    /**
     * Creates enemy Shape for body
     */

    private static final Shape slimeShape = new BoxShape(2, 4f);

    public Enemy(World world) {
        super(world);
    }

    // Assigns world, image and shape to constructor of Slime Enemy object

    public Enemy(World world, String name, int healthPoints) {
        super(world, slimeShape);
        addImage(slimeImage);
        this.name = name;
        this.healthPoints = healthPoints;
    }

    //Setters and Getters for Enemy fields
    /**
     * Returns health points of enemy
     * <p>
     * Returns health points of enemy
     *
     * @param  healthPoints the current health points of enemy
     * @return healthPoints
     */
    public int getHealthPoints() {
        return  healthPoints;
    }

    /**
     * Sets health points of enemy
     * <p>
     * Sets health points of enemy
     *
     * @param  healthPoints the current health points of enemy
     * @return nothing
     */
    public void setHealthPoints(int hp) {
        healthPoints = hp;
    }


}

class minionEnemy extends Walker {
    /**
     * Name of enemy
     */
    private String name;
    /**
     * The Health point of enemy
     */
    private int healthPoints;

    /**
     * The character field to later initialise and accesss
     */
    private Characters characters;

    //Slime Enemy Image and Shape created

    /**
     * Creates enemy Image for body
     */
    private static final BodyImage minionImage = new BodyImage("data/monsterminion.gif", 4f);
    /**
     * Creates enemy Shape for body
     */
    private static final Shape minionShape = new BoxShape(2, 1.8f);

    public minionEnemy(World world) {
        super(world);
    }

    // Assigns world, image and shape to constructor of Slime Enemy object

    public minionEnemy(World world, String name, int healthPoints) {
        super(world, minionShape);
        addImage(minionImage);
        this.name = name;
        this.healthPoints = healthPoints;
    }

    //Setters and Getters for Enemy fields
    /**
     * Returns health points of enemy
     * <p>
     * Returns health points of enemy
     *
     * @param  healthPoints the current health points of enemy
     * @return healthPoints
     */
    public int getHealthPoints() {
        return  healthPoints;
    }

    /**
     * Sets health points of enemy
     * <p>
     * Sets health points of enemy
     *
     * @param  healthPoints the current health points of enemy
     * @return nothing
     */
    public void setHealthPoints(int hp) {
        healthPoints = hp;
    }


}

class flyingEnemy extends Walker {
    /**
     * Name of enemy
     */
    private String name;
    /**
     * The Health point of enemy
     */
    private int healthPoints;

    /**
     * The character field to later initialise and accesss
     */
    private Characters characters;

    //Slime Enemy Image and Shape created

    /**
     * Creates enemy Image for body
     */
    private static final BodyImage flyingEnemyImage = new BodyImage("data/flyingenemy.gif", 4f);
    /**
     * Creates enemy Shape for body
     */
    private static final Shape flyingEnemyShape = new BoxShape(2, 1.8f);

    public flyingEnemy(World world) {
        super(world);
    }

    // Assigns world, image and shape to constructor of Slime Enemy object

    public flyingEnemy(World world, String name, int healthPoints) {
        super(world, flyingEnemyShape);
        addImage(flyingEnemyImage);
        this.name = name;
        this.healthPoints = healthPoints;
    }

    //Setters and Getters for Enemy fields
    /**
     * Returns health points of enemy
     * <p>
     * Returns health points of enemy
     *
     * @param  healthPoints the current health points of enemy
     * @return healthPoints
     */
    public int getHealthPoints() {
        return  healthPoints;
    }

    /**
     * Sets health points of enemy
     * <p>
     * Sets health points of enemy
     *
     * @param  healthPoints the current health points of enemy
     * @return nothing
     */
    public void setHealthPoints(int hp) {
        healthPoints = hp;
    }


}

class finalEnemy extends Walker {
    /**
     * Name of enemy
     */
    private String name;
    /**
     * The Health point of enemy
     */
    private int healthPoints;

    /**
     * The character field to later initialise and accesss
     */
    private Characters characters;

    //Slime Enemy Image and Shape created

    /**
     * Creates enemy Image for body
     */
    private static final BodyImage finalEnemyImage = new BodyImage("data/finalboss.gif", 12f);
    /**
     * Creates enemy Shape for body
     */
    private static final Shape finalEnemyShape = new BoxShape(3, 5f);

    public finalEnemy(World world) {
        super(world);
    }

    // Assigns world, image and shape to constructor of Slime Enemy object

    public finalEnemy(World world, String name, int healthPoints) {
        super(world, finalEnemyShape);
        addImage(finalEnemyImage);
        this.name = name;
        this.healthPoints = healthPoints;
    }

    //Setters and Getters for Enemy fields

    /**
     * Returns health points of enemy
     * <p>
     * Returns health points of enemy
     *
     * @param  healthPoints the current health points of enemy
     * @return healthPoints
     */
    public int getHealthPoints() {
        return  healthPoints;
    }


    /**
     * Sets health points of enemy
     * <p>
     * Sets health points of enemy
     *
     * @param  healthPoints the current health points of enemy
     * @return nothing
     */
    public void setHealthPoints(int hp) {
        healthPoints = hp;
    }



}




