package factory;

import javax.swing.JOptionPane;

import animals.Animal;
import animals.Bear;
/**
 * Omnivore Factory class
 * @author Gad Nadjar, Rudy Haddad
 */
public class FactoryOmnivore implements AbstractZooFactory{
    /**
     * produceAnimal by his Factory(OmnivoreFactory)
     */
    @Override
    public Animal produceAnimal(String animal, int sz, int hor, int ver,String c) {
        if(animal.equals("Bear"))
            return new Bear(sz,0,0,hor,ver,c);
        else
        {
            JOptionPane.showMessageDialog(null, "Omnivore Factory Can Create Only : Bear");
            return null;
        }
    }

}
