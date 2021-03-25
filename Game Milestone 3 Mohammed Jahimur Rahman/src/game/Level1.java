package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import game.Characters;
import org.jbox2d.common.Vec2;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */

public class Level1 extends GameLevel {

    /**
     * Creates Collision field for collision with slime
     */
    private EnemyCollision slimeCollision;
    /**
     * Creates SoundClip field for background music
     */
    private SoundClip slimeBoss;
    /**
     * Creates Collision field for collision with jumpPad
     */
    private jumpPadCollision jumpPadCollision;
    /**
     * Creates Array of crows for later implementation
     */
    private Crow[] crows;

    public Level1(Game game) {
        super(game);

        //Slime battle background music track

        try {
            slimeBoss = new SoundClip("data/slime boss.wav");
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }


        slimeBoss.setVolume(0.01);
        slimeBoss.play();
        slimeBoss.loop();

        Shape shape = new BoxShape(15, 2f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -11.5f));
        ground.setFillColor(Color.darkGray);

        Shape platform2Shape = new BoxShape(4, 0.5f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(6, -4.7f));

        Shape platform3Shape = new BoxShape(4, 0.5f);
        StaticBody platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(3, 0f));


        Shape platform5Shape = new BoxShape(4, 0.5f);
        StaticBody platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(-12, 5.5f));

        //Portal created


        getPortal().setPosition(new Vec2(-12, 8f));


        generateCrows();

        //Main character created

        getCharacter().setPosition(new Vec2(5, -9f));

        //Non player characters created

        getInjured().setPosition(new Vec2(9, -8f));
        getInjured().rotate(-4);
        NonPlayerCharacters injuredFamily2 = new NonPlayerCharacters(this);
        injuredFamily2.setPosition(new Vec2(7, -8f));
        injuredFamily2.rotate(-4);


        //Jump pad created

        getJumpPad().setPosition(new Vec2(0, 1f));

        //Slime enemy created

        getEnemy().setPosition(new Vec2(-7, -9f));
        getEnemy().setLinearVelocity(new Vec2(7, 0));

        //Collisions created

        slimeCollision = new EnemyCollision(getCharacter());
        jumpPadCollision = new jumpPadCollision(getCharacter());

        Points point = new Points(this);
        point.setPosition(new Vec2(-8,-9f));


        //Collisions added to collision listener

        getCharacter().addCollisionListener(new PointsPickup(getCharacter()));
        getCharacter().addCollisionListener(slimeCollision);
        getCharacter().addCollisionListener(jumpPadCollision);



    }

//checks if level is complete

    /**
     * Chwcks if conditions are met to go to next level
     * <p>
     * States that level is complete once conditions are met returning true, or false if not met
     *
     * @return either true or false depending on if conditions are met.
     */

    @Override
    public boolean isComplete() {
        if (getCharacter().getPoints() == 1) {
            System.out.println("all points acquired, go to the portal");
            return true;
        }
        return false;
    }

    //Generates a flock of crows using an Array of crows


    /**
     * Generates a flock of crows.
     * <p>
     * Generates a flock of crows given increasing x and y co-ordinates.
     *
     * @param  crows the crow object
     * @param i integer used to increment
     * @param index the current index of the Crows array
     * @return nothing
     */

    public void generateCrows() {
        for (int i = 0; i < 10; i++) {
            crows = new Crow[10];
            int index = 0;
            crows[index] = new Crow(this);
            crows[index].setPosition(new Vec2(-12+i+i, 8f));
            crows[index].setLinearVelocity(new Vec2(3, 0f));
            crows[index].setGravityScale(0);
            index++;
        }
    }


    /**
     * Returns the music used for level 1.
     * <p>
     * Returns the music used for level 1.
     *
     * @param  slimeBoss the background music played
     * @return slimeBoss, the music Soundclip
     */


    public SoundClip getSlimeBoss() {
        return  slimeBoss;
    }


}
