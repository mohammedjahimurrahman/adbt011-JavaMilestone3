package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */
public class Characters extends Walker {

    /**
     * The poinst gained by the charcter
     */
    private int points;


    //Character Image and Shape created
    /**
     * Vreates character shape
     */

    private static final Shape characterShape = new CircleShape(1, 0, 0f);
    /**
     * Creates charcacter bodyImage
     */
    private static final BodyImage image = new BodyImage("data/giphy.gif", 6f);

    // Assigns world, image and shape to constructor of Character object

    public Characters(World world) {
        super(world, characterShape);
        addImage(image);
        points = 0;
    }

    //Setters and Getters for Character fields

    /**
     * Returns character's points
     * <p>
     * Returns character's points
     *
     * @param  points the current amount of points
     * @return points
     */

    public int getPoints() {
        return  points;
    }

    /**
     * Sets character's points
     * <p>
     * Swts character's points
     *
     * @param  points the current amount of points
     * @return nothing
     */

    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Adds to character's points
     * <p>
     * Adds to character's points
     *
     * @param  points the current amount of points
     * @return nothing
     */
    public void addPoints(){
        points++;
        System.out.println("Points Increased: " +
                "Points Count = " + points);
    }


}
