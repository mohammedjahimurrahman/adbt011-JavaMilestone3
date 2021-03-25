package game;

import city.cs.engine.*;




/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */

public class Points extends StaticBody {


    /**
     * Creates orb shape for point object
     */
    private static final Shape orbShape = new CircleShape(1);
    /**
     * Creates orb image for point object
     */
    private static final BodyImage image =
            new BodyImage("data/orb.gif", 1f);

    public Points(World w) {
        super(w,orbShape);
        addImage(image);
    }
}
