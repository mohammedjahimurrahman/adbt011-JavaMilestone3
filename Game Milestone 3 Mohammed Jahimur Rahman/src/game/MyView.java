package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;


/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */
public class MyView extends UserView {
    /**
     * Creates background image variable
     */
    private Image background;

    public MyView(World w, int width, int height) {
        super(w, width, height);
    }

    //Sets background image as background

    @Override
    protected void paintBackground(Graphics2D g) {
       g.drawImage(background, 0, 0, this);
    }




    //sets the current background

    /**
     * Allows setting of game background
     * <p>
     * Allows setting of game background
     *
     * @param  background The current background
     * @return nothing
     */
    public void setBackground(Image background) {
        this.background = background;
    }






}




