package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;




/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */


public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel level;
    private GameLevel level1;
    private GameLevel level2;
    private GameLevel level3;

    private Game game;

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;

    /**
     * The background image of each level
     */
    private Image background = new ImageIcon("data/background3.gif").getImage();
    private Image background2 = new ImageIcon("data/background4.gif").getImage();
    private Image background3 = new ImageIcon("data/level3.gif").getImage();



    private CharacterController controller;

    /** Initialise a new Game. */
    public Game() {
        // make the world
        level = new Level1(this);

        // make a view
//        view = new MyView(world, 500, 500);
        view = new MyView(level, 600, 450);



        // add this to the view, so coordinates are relative to the view
     //   view.addMouseListener(new MouseHandler(view));
        controller = new CharacterController(level.getCharacter());
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));



        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Basic world");
        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel.getMainPanel(), BorderLayout.WEST);
        getView().setBackground(background);
        frame.add(view, BorderLayout.CENTER);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);



        // start our game world simulation!
        level.start();
    }

  //fuction that makes game go the next level

    /**
     * Restarts the level.
     * <p>
     * Restarts the current level the player is at, resetting the state.
     *
     * @param  level the current level
     * @param view the current level the world is focused on through the JFrame
     * @param controller controller used to control the character
     * @return nothing
     */

    public void restartLevel() {

        if (level instanceof Level1) {
                        ((Level1) level).getSlimeBoss().stop();
            level = null;
            level1 = new Level1(this);
            level = level1;
            view.setWorld(level);
            level.start();
            controller.updateCharacter(level.getCharacter());

        }

        if (level instanceof Level2) {
            ((Level2) level).level2Sound().stop();
            level = null;
            level2 = new Level2(this);
            level = level2;
            view.setWorld(level);
            level.start();
            controller.updateCharacter(level.getCharacter());
        }

        if (level instanceof Level3) {
            ((Level3) level).getFinalbattle().stop();
            level = null;
            level3 = new Level3(this);
            level = level3;
            view.setWorld(level);
            level.start();
            controller.updateCharacter(level.getCharacter());
        }


    }

    /**
     * Goes to the next level
     * <p>
     * Goes to the next level when conditions are met
     *
     * @param  level the current level
     * @param view the current level the world is focused on through the JFrame
     * @param controller controller used to control the character
     * @return nothing
     */

    public void goToNextLevel() {
        if (level instanceof Level1) {
            level.stop();
            ((Level1) level).getSlimeBoss().stop();
            level = new Level2(this);
            view.setBackground(background2);
            view.setWorld(level);
            view.repaint();
            controller.updateCharacter(level.getCharacter());
            level.start();
        } else if (level instanceof Level2) {
            System.out.println("WELL DONE!");
            level.stop();
            ((Level2) level).level2Sound().stop();
            level = new Level3(this);
            getView().setBackground(background3);
            view.setWorld(level);
            controller.updateCharacter(level.getCharacter());
            level.start();
        } else if (level instanceof Level3) {
            level.stop();
            ((Level3) level).getFinalbattle().stop();
            level = new Level3(this);
            getView().setBackground(background3);
            view.setWorld(level);
            controller.updateCharacter(level.getCharacter());
            level.start();
        }
    }

//getter for view

    /**
     * Returns the view
     * <p>
     * Returns the view
     *
     * @param view the current level the world is focused on through the JFrame
     * @return view
     */

   public MyView getView() {
        return view;
   }


    /**
     * Pauses the current game state and music
     * <p>
     * Pauses the current game state and music while saving the state
     *
     * @param  level the current level
     * @param level1 an instance of the first level
     * @return nothing
     */

    public void Pause() {
        level.stop();


        if (level instanceof Level1) {
            ((Level1) level).getSlimeBoss().pause();
        }

        if (level instanceof Level2) {
            ((Level2) level).level2Sound().pause();
        }

        if (level instanceof Level3) {
            ((Level3) level).getFinalbattle().pause();
        }


   }

    /**
     * Resumes the current game state and music
     * <p>
     * Resumes the current game state and resumes music while saving the state
     *
     * @param  level the current level
     * @param level1 an instance of the first level
     * @return nothing
     */


   public void Resume() {
        level.start();

       if (level instanceof Level1) {
           ((Level1) level).getSlimeBoss().play();
       }

       if (level instanceof Level2) {
           ((Level2) level).level2Sound().play();
       }

       if (level instanceof Level3) {
           ((Level3) level).getFinalbattle().play();
       }

   }





    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}
