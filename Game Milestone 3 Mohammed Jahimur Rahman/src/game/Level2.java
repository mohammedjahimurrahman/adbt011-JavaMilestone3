package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;



/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */

public class Level2 extends GameLevel{

    //private fields for objects, sounds, and colliisons

    /**
     * Creates Sound clip field for background music
     */
    private SoundClip music2;

    /**
     * Creates Collision field for collision with jumpPad
     */
    private jumpPadCollision jumpPadCollision;

    /**
     * Creates Portal field for character to go to next level by colliding with
     */
    private Portal portal;

    /**
     * Creates Collision field for collision with Slime
     */
    private EnemyCollision slimeCollision;

    /**
     * Creates Collision field for collision with enemy minion
     */
    private minionEnemyCollision minionEnemyCollision;




    public Level2(Game game) {

        //sounds created

        super(game);
        try {
            music2 = new SoundClip("data/music2.wav");
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        music2.setVolume(0.05);
        music2.play();
        music2.loop();

        //destroying objects not needed in level 2

        getPortal().destroy();
        getInjured().destroy();


        //collisions made

        slimeCollision = new EnemyCollision(getCharacter());
        PointsPickup pointsPickup= new PointsPickup(getCharacter());
        jumpPadCollision = new jumpPadCollision(getCharacter());
        minionEnemyCollision = new minionEnemyCollision(getCharacter());

        //collisions attached to character

        getCharacter().addCollisionListener(pointsPickup);
        getCharacter().addCollisionListener(slimeCollision);
        getCharacter().addCollisionListener(jumpPadCollision);
        getCharacter().addCollisionListener(minionEnemyCollision);
        getCharacter().addCollisionListener(new PortalCollision(this, game));


        //creates monsters and sets position

        minionEnemy minionEnemy = new minionEnemy(this, "donovan", 20);
        flyingEnemy flyingEnemy = new flyingEnemy(this, "ok", 10);
        minionEnemy.setPosition(new Vec2(8, 8f));
        flyingEnemy.setPosition(new Vec2(0, 8f));
        flyingEnemy.setGravityScale(0);
        getCharacter().setPosition(new Vec2(0, -10f));
        getEnemy().setPosition(new Vec2(-5, -10f));


        //creates platforms



        Shape groundShape = new BoxShape(20, 2f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));

        Shape platform2Shape = new BoxShape(2, 0.5f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(-12, -7f));
        Points point = new Points(this);
        point.setPosition(new Vec2(-12, -6f));


        Shape platform3Shape = new BoxShape(2, 0.5f);
        StaticBody platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(12, -8f));
        Points point2 = new Points(this);
        point2.setPosition(new Vec2(12,-7f));


        Shape platform4Shape = new BoxShape(4, 0.5f);
        StaticBody platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(0, 0f));
        Points point3 = new Points(this);
        point3.setPosition(new Vec2(-3,1f));
        getJumpPad().setPosition(new Vec2(1,1f));


        Shape platform5Shape = new BoxShape(2, 0.5f);
        StaticBody platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(8, -3f));
        Points point4 = new Points(this);
        point4.setPosition(new Vec2(7,-2f));

        Shape platform6Shape = new BoxShape(7, 0.5f);
        StaticBody platform6 = new StaticBody(this, platform6Shape);
        platform6.setPosition(new Vec2(10, 7f));
        Points point5 = new Points(this);
        point5.setPosition(new Vec2(10,8f));
        portal = new Portal(this);
        portal.setPosition(new Vec2(13,9f));




    }


    //checks if level complete
    /**
     * Chwcks if conditions are met to go to next level
     * <p>
     * States that level is complete once conditions are met returning true, or false if not met
     *
     * @return either true or false depending on if conditions are met.
     */
    @Override
    public boolean isComplete() {
        if (getCharacter().getPoints() == 5) {
            System.out.print("all points acquired, go to the portal");
            return true;
        }
        return false;
    }

    //getter for sound
    /**
     * Returns the level 2 background music
     * <p>
     *  Returns the level 2 background music
     * @param music2 the level 2 background music
     * @return music2, the level 2 background music
     */
    public SoundClip level2Sound() {
        return music2;
    }


}


