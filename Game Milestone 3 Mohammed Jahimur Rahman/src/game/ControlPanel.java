package game;

import city.cs.engine.World;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.logging.Level;


/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */

public class ControlPanel {

    //private fields for components, buttons and other objects needed to be accessed

    /**
     * Creates JPanel mainPanel for GUI buttons to go on
     */
    private JPanel mainPanel;

    /**
     * Creates JButton quitButton for player to quit game
     */
    private JButton quitButton;

    /**
     * Creates JButton pauseButton for player to pause game
     */
    private JButton pauseButton;


    /**
     * Creates Game field to access game methods
     */
    private Game game;


    /**
     * Creates JButton restartButton for player to restart game
     */
    private JButton restartButton;


    /**
     * Creates boolean that is set to tru or false depending if game is paused
     */
    private boolean isPaused;



    public ControlPanel(Game game) {
        this.game = game;


        //exits java program when quit button is pressed

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPaused) {
                    game.Resume();
                    isPaused = false;
                } else {
                    game.Pause();
                    isPaused = true;
                }
            }
        });


        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.restartLevel();
            }
        }
        );






    }




    /**
     * Returns the mainPanel (to add to main JPanel in Game)
     * <p>
     * Returns the mainPanel (to add to main JPanel in Game)
     *
     * @param  mainPanel the JPanel which holds the GUI buttons
     * @return mainPanel
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }


}
