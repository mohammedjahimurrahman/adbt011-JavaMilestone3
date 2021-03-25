package game;

import city.cs.engine.*;



/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */


public class PointsPickup implements CollisionListener {

    /**
     * Creates character field
     */
    private Characters character;


    public PointsPickup(Characters c) {
        this.character = c;
    }


    //Collision event that calls a function that adds points to character, and then destroys other body

    /**
     * Adds point on collision.
     * <p>
     * Adds point to character if collision is with a point object
     *
     * @param  character the character object
     * @return nothing
     */

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Points) {
            character.addPoints();
            System.out.println("Point Gained!!!");
            e.getOtherBody().destroy();
        }


      }
}
