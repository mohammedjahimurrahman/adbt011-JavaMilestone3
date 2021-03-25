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

public class Level3 extends GameLevel{

    //private fields for sounds and collision
    /**
     * Creates Sound clip field for background music
     */
    private SoundClip finalbattle;

    /**
     * Creates Collision field for collision with jumpPad
     */
    private jumpPadCollision jumpPadCollision;

    /**
     * Creates Collision field for collision with final enemy
     */
    private finalEnemyCollision finalEnemyCollision;

    public Level3(Game game) {

        super(game);

        //creates sounds and sets up to play and loop

        try {
            finalbattle = new SoundClip("data/finalbattle.wav");
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        finalbattle.setVolume(0.05);
        finalbattle.play();
        finalbattle.loop();

        //destroys objects not needed
        getInjured().destroy();
        getPortal().destroy();
        getEnemy().destroy();


        //creates final enemy and sets gravity scale

        finalEnemy finalEnemy = new finalEnemy(this, "boss", 5);
        finalEnemy.setGravityScale(0);


        //creates collisions and adds to character

        jumpPadCollision = new jumpPadCollision(getCharacter());
        finalEnemyCollision = new finalEnemyCollision(getCharacter());
        getCharacter().addCollisionListener(jumpPadCollision);
        getCharacter().addCollisionListener(finalEnemyCollision);


      //sets position of character, jumppad and enemy

        getJumpPad().setPosition(new Vec2(0, -9));
        finalEnemy.setPosition(new Vec2(8, 4));
        getCharacter().setPosition(new Vec2(-12, -10));

        Shape platform1Shape = new BoxShape(15, 2f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(0, -11.5f));


    }

    /**
     * Chwcks if conditions are met to go to next level
     * <p>
     * States that level is complete once conditions are met returning true, or false if not met
     *
     * @return either true or false depending on if conditions are met.
     */
    @Override
    public boolean isComplete() {
        return false;
    }


    /**
     * Returns the level 3 background music
     * <p>
     *  Returns the level 3 background music
     * @param finalbattle the level 3 background music
     * @return finalbattle, the level 3 background music
     */
    public SoundClip getFinalbattle() {
        return finalbattle;
    }

}


