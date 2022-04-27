/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package animals;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.*;

/** this class is for animals can chew. so all animals can chew has from here
 *
 *  * @see animals.Animal
 *  * @author Gad Nadjar
 */

public abstract class Chew extends Animal
{

    /**
     * @param name : name of the animal
     */
    public Chew(String name)
    {
        super(name);
    }

    /**
     *
     * @param size : size of the animal
     * @param horSpeed : horizontal speed of the animal
     * @param verSpeed : vertical speed of the animal
     * @param color : color of the animal
     * @param pan : panel of zoopanel
     */
    public Chew(int size, int horSpeed, int verSpeed, String color, ZooPanel pan) {
        super(size, horSpeed, verSpeed, color, pan);
    }


    /**
     *
     * return void
     */
    public void makeSound()
    {
        if(this instanceof Giraffe)
        {
            MessageUtility.logSound(getName(),"Bleats and Stomps its legs, then chews" );
        }
        if(this instanceof Elephant)
        {
            MessageUtility.logSound(getName(), "Trumpets with joy while flapping its ears, then chews");
        }
        if(this instanceof Turtle)
        {
            MessageUtility.logSound(getName(),"Retracts its head in then eats quietly" );
        }
    }


}