package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;




/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */

public class Collisions {} ;



/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */

class EnemyCollision implements CollisionListener {

    //Creates soundclip that plays whenever character collides with enemy

    /**
     * Creates soundclip that plays whenever character collides with enemy
     */


    private SoundClip enemyHealthDecreased;
    {
        try {
            enemyHealthDecreased = new SoundClip("data/enemy_health_decreased.wav");
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    //Creates soundclip that plays whenever character eliminates enemy
    /**
     * Creates soundclip that plays whenever character eliminates enemy
     */



    private SoundClip enemyEliminated;
    {
        try {
            enemyEliminated = new SoundClip("data/enemy_eliminated.wav");
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private Characters characters;

    public EnemyCollision(Characters character) {
        characters = character;
    }

    //Creates collision event that occurs whenever character collides with enemy

    /**
     * Creates collision event that occurs whenever character collides with enemy
     * <p>
     * Creates collision event that occurs whenever character collides with enemy
     *
     * @param  enemyHealthDecreased THe enemu health decreases
     * @return nothing
     */

    @Override
    public void collide(CollisionEvent enemyCollision) {
        if (enemyCollision.getOtherBody() instanceof Enemy) {
            ((Enemy) enemyCollision.getOtherBody()).setHealthPoints(((Enemy) enemyCollision.getOtherBody()).getHealthPoints() - 5);
            if (((Enemy) enemyCollision.getOtherBody()).getHealthPoints() > 0) {
                System.out.println("Collision with enemy, enemy health decreased, remaining HP: " + ((Enemy) enemyCollision.getOtherBody()).getHealthPoints());
                enemyHealthDecreased.setVolume(0.4);
                enemyHealthDecreased.play();
            }
            if (((Enemy) enemyCollision.getOtherBody()).getHealthPoints() <= 0) {
                System.out.println("Collision with enemy, enemy eliminated.");
                enemyEliminated.setVolume(0.4);
                enemyEliminated.play();
                enemyCollision.getOtherBody().destroy();
            }
        }
    }
}


/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */
class jumpPadCollision implements CollisionListener {
    /**
     * //Creates character field
     */

    private Characters characters;

    public jumpPadCollision(Characters character) {
        characters = character;
    }

    //Creates collision event that occurs whenever character collides with jump pad, increasing linear velocity of character




    /**
     * Creates collision event that occurs whenever character collides with jumPad
     * <p>
     * Creates collision event that occurs whenever character collides with jumPad
     *
     * @return nothing
     */



    @Override
    public void collide(CollisionEvent jumpPadCollision) {
        if (jumpPadCollision.getOtherBody() instanceof jumpPad) {
            //Upon collision with jump pad, calls function that increases character linear velocity
            jumpBoost();
            System.out.println("Jump Boosted!!!");
        }
    }

    //function that increases character linear velocity
    /**
     * Causes character to jump higher
     * <p>
     * Causes character to jump higher during collision with jumpPad
     *
     * @param characters the character
     * @return nothing
     */
    public void jumpBoost() {
        characters.setLinearVelocity(new Vec2(0, 13f));
    }

}

/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */
class PortalCollision implements CollisionListener{

    /**
     * //Creates GameLevel Level field
     */
    private GameLevel level;

    /**
     * //Creates Game field
     */
    private Game game;

    public PortalCollision(GameLevel level, Game game) {
        this.level = level;
        this.game = game;
    }


    /**
     * Causes character to go to next level
     * <p>
     *  Causes character to go to next level if condiitons are met
     *
     * @param level the current level
     *  @param game the current game world
     * @return nothing
     */


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Portal
                && level.isComplete()){
            game.goToNextLevel();
        }


    }
}

/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */
class minionEnemyCollision implements CollisionListener {

    //Creates soundclip that plays whenever character collides with enemy

    /**
     * //Creates soundClip for enemy health decreased
     */
    private SoundClip enemyHealthDecreased;
    {
        try {
            enemyHealthDecreased = new SoundClip("data/enemy_health_decreased.wav");
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    //Creates soundclip that plays whenever character eliminates enemy

    /**
     * //Creates soundClip for enemy eliminated
     */
    private SoundClip enemyEliminated;
    {
        try {
            enemyEliminated = new SoundClip("data/enemy_eliminated.wav");
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private Characters characters;

    public minionEnemyCollision(Characters character) {
        characters = character;
    }

    //Creates collision event that occurs whenever character collides with enemy


    /**
     *Creates collision event that occurs whenever character collides with enemy
     * <p>
     *  Creates collision event that occurs whenever character collides with enemy and plays sound
     *
     * @param enemyHealthDecreased the enemy health decreases
     *  @param enemyEliminated THe enemy is eliminated when health of enemy is 0 or less than 0
     * @return nothing
     */

    @Override
    public void collide(CollisionEvent minionEnemyCollision) {
        if (minionEnemyCollision.getOtherBody() instanceof minionEnemy) {
            ((minionEnemy) minionEnemyCollision.getOtherBody()).setHealthPoints(((minionEnemy) minionEnemyCollision.getOtherBody()).getHealthPoints() - 5);
            if (((minionEnemy) minionEnemyCollision.getOtherBody()).getHealthPoints() > 0) {
                System.out.println("Collision with enemy, enemy health decreased, remaining HP: " + ((minionEnemy) minionEnemyCollision.getOtherBody()).getHealthPoints());
                enemyHealthDecreased.setVolume(0.4);
                enemyHealthDecreased.play();
            }
            if (((minionEnemy) minionEnemyCollision.getOtherBody()).getHealthPoints() <= 0) {
                System.out.println("Collision with enemy, enemy eliminated.");
                enemyEliminated.setVolume(0.4);
                enemyEliminated.play();
                minionEnemyCollision.getOtherBody().destroy();
            }
        }
    }
}

/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */
class finalEnemyCollision implements CollisionListener {

    //Creates soundclip that plays whenever character collides with enemy
    /**
     * //Creates soundClip for when game finishes
     */
    private SoundClip gameFinished;

    {
        try {
            gameFinished = new SoundClip("data/gamefinished.wav");
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * //Creates soundClip for when final enemy is eliminated
     */
    private SoundClip dyingMonster;
    {
        try {
            dyingMonster = new SoundClip("data/dyingmonster.wav");
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    //Creates soundclip that plays whenever character eliminates enemy

    /**
     * //Creates character field
     */
    private Characters characters;

    public finalEnemyCollision(Characters character) {
        characters = character;
    }

    //Creates collision event that occurs whenever character collides with enemy

    /**
     *Creates collision event that occurs whenever character collides with final enemy
     * <p>
     *  Creates collision event that occurs whenever character collides with final enemy and plays sound
     *
     * @param dyingMonster soundClip that plays when monster eliminated
     *  @param gameFinished soundClip that plays when game is finished
     * @return nothing
     */

    @Override
    public void collide(CollisionEvent finalEnemyCollision) {
        if (finalEnemyCollision.getOtherBody() instanceof finalEnemy) {
            ((finalEnemy) finalEnemyCollision.getOtherBody()).setHealthPoints(((finalEnemy) finalEnemyCollision.getOtherBody()).getHealthPoints() - 5);
            if (((finalEnemy) finalEnemyCollision.getOtherBody()).getHealthPoints() == 0) {
                dyingMonster.setVolume(0.8);
                dyingMonster.play();
                finalEnemyCollision.getOtherBody().destroy();
                System.out.println("GAME FINISHED!");
                gameFinished.setVolume(1);
                gameFinished.play();
            }
        }
    }
}

