package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */

public class CharacterController implements KeyListener {

    /**
     * The default walking speed set
     */
    private static final float WALKING_SPEED = 4;

    /**
     * Creates character field
     */
    private Characters character;

    public CharacterController(Characters s) {
        character = s;
    }


    @Override
    public void keyTyped(KeyEvent e){
    }


    /**
     *Allows the player to start walking and jump
     * <p>
     *  Allows the player to start walking and jump
     *
     * @param character the character object
     *  @param code the variable used to get the key pressed
     * @return nothing
     */

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // key commands that start and stop walking when A or D key is pressed
        if (code == KeyEvent.VK_A) {
            character.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_D) {
            character.startWalking(WALKING_SPEED);
        } else if (code == KeyEvent.VK_SPACE) {
            character.jump(10);
        }
    }

    //When A or D key is released, the character stops walking

    /**
     *Allows the player to stop walking
     * <p>
     *  Allows the player to start walking when key is released
     *
     * @param character the character object
     *  @param code the variable used to get the key pressed
     * @return nothing
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            character.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            character.stopWalking();
        }
    }

    /**
     * Updates the controller to focus on current character object
     * <p>
     *  Updates the controller to focus on current character object
     *
     * @param character the character object
     * @return nothing
     */

    public void updateCharacter(Characters character) {
        this.character = character;
    }


}
