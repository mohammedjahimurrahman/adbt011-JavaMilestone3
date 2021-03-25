package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.function.BiPredicate;


/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */

public class NonPlayerCharacters extends StaticBody {

    //Injured Family Image and Shape created

    /**
     * Creates shape for injuredFamiily object
     */
    private static final Shape injuredFamilyShape = new CircleShape(1);
    /**
     * Creates image for injuredFamiily object
     */
    private static final BodyImage injuredFamilyImage = new BodyImage("data/giphy.gif", 5f);

    // Assigns world, image and shape to constructor of Non Player Character

    public NonPlayerCharacters(World w) {
        super(w, injuredFamilyShape);
        addImage(injuredFamilyImage);;
    }

}


/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */

class Crow extends Walker {

    //Crow Image and Shape created

    /**
     * Creates shape for Crow object
     */
    private static final Shape crowShape = new BoxShape(2, 1);

    /**
     * Creates image for crow object
     */
    private static final BodyImage crowImage = new BodyImage("data/crow.gif", 3f);

    // Assigns world, image and shape to constructor of Crow object

    public Crow(World w) {
        super(w, crowShape);
        addImage(crowImage);

    }
}


/**
 * @author      Mohammed Jahimur, Rahman, Mohammed.Rahman.33@city.ac.uk
 * @version     Version X
 * @since       2020/2021
 */

class jumpPad extends StaticBody {

    //Jump pad Image and Shape created
    /**
     * Creates image for jumpPad object
     */
    private static final Shape jumpPadShape = new BoxShape(1, 0.5f);

    /**
     * Creates image for jumpPad object
     */
    private static final BodyImage jumpPadImage = new BodyImage("data/jumppad.png", 1f);

    // Assigns world, image and shape to constructor of Jump Pad object

    public jumpPad(World w) {
        super(w, jumpPadShape);
        addImage(jumpPadImage);

    }
}

