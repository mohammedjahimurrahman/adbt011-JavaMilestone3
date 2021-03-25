package game;

import city.cs.engine.*;

public abstract class GameLevel extends World {

    //private fields for objects

    private Enemy enemy;
    private Characters character;
    private NonPlayerCharacters injured;
    private Crow crow;
    private minionEnemy minionEnemy;
    private jumpPad jumpPad;
    private Portal portal;

    //Sets up gamelevel by creating object instances of characters


    /**
     * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
     * @version     Version X
     * @since       2020/2021
     */


    public GameLevel(Game game) {
        enemy = new Enemy(this, "donald", 30);
        character = new Characters(this);
        injured = new NonPlayerCharacters(this);
        jumpPad = new jumpPad(this);
        portal = new Portal(this);
        character.addCollisionListener(new PortalCollision(this, game));


    }


    //setters and getters for characters and properties


    /**
     * Returns Character object
     * <p>
     * Returns Character object
     *
     * @param  character the character object
     * @return character
     */


    public Characters getCharacter() {
        return character;
    }


    /**
     * Returns Enemy object
     * <p>
     * Returns Enemy object
     *
     * @param  enemy the enemy object
     * @return enemy
     */
    public Enemy getEnemy() {
        return enemy;
    }

    /**
     * Returns Portal object
     * <p>
     * Returns Portal object
     *
     * @param  portal the portal object
     * @return portal
     */


    public Portal getPortal() {
        return portal;
    }

    /**
     * Returns injured non player character object
     * <p>
     * Returns injured non player character object
     *
     * @param  injured the injured non player character object
     * @return injured
     */



    public NonPlayerCharacters getInjured() {
        return injured;
    }

    /**
     * Returns jumpPad object
     * <p>
     * Returns jumpPad object
     *
     * @param  jumpPad object
     * @return jumpPad
     */


    public jumpPad getJumpPad() {
        return jumpPad;
    }

    /**
     * Sets up isComplete boolean
     * <p>
     * Sets up isComplete boolean for condition to change level
     *
     * @return nothing
     */


    public abstract boolean isComplete();

}

//portal shape, image and bodu





 class Portal extends StaticBody {

    private static final BodyImage portalImage = new BodyImage("data/portal.gif", 3f);
    private static final Shape portalShape = new CircleShape(1);

    public Portal(World world) {
        super(world, portalShape);
        addImage(portalImage);
    }
}

