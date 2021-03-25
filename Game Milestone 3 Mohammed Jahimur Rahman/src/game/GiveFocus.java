package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */

public class GiveFocus implements MouseListener {



    /**
     * Creates MyView view
     */
    private MyView view;


    //GIVES FOCUS TO KEYBOARD WHEN GAME IS FOCUSED ON

    /**
     * GIVES FOCUS TO KEYBOARD WHEN GAME IS FOCUSED ON
     * <p>
     * GIVES FOCUS TO KEYBOARD WHEN GAME IS FOCUSED ON
     *
     * @param  view The current view
     * @return nothing
     */

    public GiveFocus(MyView v){
        this.view = v;
    }

    /**
     * Necessary empty method
     * <p>
     * Necessary empty method
     *
     * @return nothing
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    /**
     * Necessary empty method
     * <p>
     * Necessary empty method
     *
     * @return nothing
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }
    /**
     * Necessary empty method
     * <p>
     * Necessary empty method
     *
     * @return nothing
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    /**
     * Necessary empty method
     * <p>
     * Necessary empty method
     *
     * @return nothing
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        view.requestFocus();
    }
    /**
     * Necessary empty method
     * <p>
     * Necessary empty method
     *
     * @return nothing
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
