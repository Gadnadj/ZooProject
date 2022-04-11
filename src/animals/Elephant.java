/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package animals;
import diet.IDiet;
import diet.Omnivore;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import diet.Herbivore;
import utilities.MessageUtility;

/**
 * the utilities of this class is the creation of a new animal elephant. all function bear can be use is here or
 * from supers classes.
 * @version 26.03.2022
 * @author Rudy Haddad
 * @see animals.Animal
 *
 **/
public class Elephant extends Chew
{
    private double trunkLength;
    private static final Point location = new Point(50,90);
    private final static IDiet diet = new Herbivore();

    /**
     * the utilities of this class is the creation new animal elephant. all function elephant can be use is here or
     * from supers classes.
     * @version 26.03.2022
     * @author Rudy Haddad
     *
     **/


    /**
     * @param name : name of the animal
     */
    public Elephant(String name)
    {
        super(name, location);
        this.setName(name);
        MessageUtility.logConstractor("Elephant", name);
        this.setWeight(500);
        settrunkLength(1);
        this.setDiet(diet);
    }


    /**
     * @param name : name of the animal
     * @param trunkLength : length of the elephant trunk
     */
    public Elephant(String name, double trunkLength)
    {
        super(name, location);
        MessageUtility.logSetter(this.getName(), "setName", name, true);
        MessageUtility.logConstractor("Elephant", name);
        this.setWeight(500);
        if(trunkLength < 0.5 || trunkLength >3)
        {
            MessageUtility.logSetter(this.getName(),"settrunkLength", trunkLength, false);
            this.trunkLength = 1;
            MessageUtility.logSetter(this.getName(),"settrunkLength", this.trunkLength, true
            );

        }
        else
        {
            this.trunkLength = trunkLength;
            MessageUtility.logSetter(this.getName(),"settrunkLength", trunkLength, true);
        }
        this.setDiet(diet);
    }


    /**
     *
     * @return String :
     */
    public String toString()
    {
        return "[!]" + this.getName() + " : " + "total distance :" + "[" + this.gettotalDistance() + "]" + ", weight : " + "[" + this.getWeight() + "]";
    }


    /**
     *  @param trunkLength : length of the elephant trunk
     *
     * @return true if the placement worked
     */
    public boolean settrunkLength(double trunkLength)
    {
        if(trunkLength < 0.5 || trunkLength >3)
        {
            this.trunkLength = 1;
            MessageUtility.logSetter(this.getName(),"settrunkLength", trunkLength, false);
            return false;
        }
        else
        {
            this.trunkLength = trunkLength;
            MessageUtility.logSetter(this.getName(),"settrunkLength", trunkLength, true);
            return true;
        }
    }


    /**
     *
     * @return double : the length of the elephant trunk
     */
    public double gettrunkLength() {return this.trunkLength;}


    /**
     *
     */
    public void chew()
    {
        System.out.println("Trumpets with joy while flapping its ears, then chews");
    }



    /**
     *
     * @return EFoodType : return the type of food of the animal
     */
    @Override
    public EFoodType getFoodtype()
    {
        MessageUtility.logGetter(this.getName(), "getFoodType", EFoodType.MEAT);
        return EFoodType.MEAT;
    }


    /**
     * @param obj : edibility of animal
     *
     * @return boolean : true if the object is edible
     */
    @Override
    public boolean eat(IEdible obj) {
        {
            if (!this.getDiet().canEat(obj.getFoodtype())) {
                MessageUtility.logBooleanFunction(this.getName(), "eat", obj, false);
                return false;
            } else {
                MessageUtility.logBooleanFunction(this.getName(), "eat", obj, true);
                this.setWeight(getWeight() + this.getDiet().eat(this, obj));
                super.makeSound();
                return true;
            }
        }
    }
}