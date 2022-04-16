package graphics;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is a child class of JFrame and implements the ActionListener interface. It creates a new frame,
 * and allows us to modify the x and y coordinates of each animal in the table
 * @author Gad Nadjar
 * @see JFrame
 */
public class NewWindow2 extends JFrame implements ActionListener
{
    /**
     * frame
     */
    JFrame frame;

    /**
     * label of the coordinate x
     */
    JLabel select_X;

    /**
     * label of the coordinate y
     */
    JLabel select_Y;

    /**
     * label of the button confirmation
     */
    JLabel Confirmation;

    /**
     * label of all animal
     */
    JLabel allAnimal;

    /**
     * combo box of the coordinate x
     */
    JComboBox cSelect_X;

    /**
     * combo box of the coordinate y
     */
    JComboBox cSelect_Y;

    /**
     * combo box of the animal
     */
    JComboBox cAllAnimal;

    /**
     * button confirmation
     */
    JButton bConfirmation;

    /**
     * number of animal
     */
    private int counter = 0;

    /**
     * constructor
     */
    public NewWindow2()
    {
        frame = new JFrame();
        frame.setTitle("Add Animal");
        frame.setSize(new Dimension(600, 100));
        frame.setLayout(new GridLayout(2, 6));
        //this.pack();
        frame.setVisible(true);
        allAnimal = new JLabel("Animal");
        select_X = new JLabel("Coordinate X");
        select_Y = new JLabel("Coordinate y");
        Confirmation = new JLabel("Confirmation");

        cSelect_X = new JComboBox();
        cSelect_Y = new JComboBox();
        bConfirmation = new JButton("Confirm");
        cAllAnimal = new JComboBox();


        frame.add(allAnimal);
        frame.add(select_X);
        frame.add(select_Y);
        frame.add(Confirmation);
        frame.add(cAllAnimal);
        frame.add(cSelect_X);
        frame.add(cSelect_Y);
        frame.add(bConfirmation);


        for (int i = 0; i <= 800; i++) {
            cSelect_X.addItem(i);
        }
        for (int i = 0 ; i <= 600; i++) {
            cSelect_Y.addItem(i);
        }
        for(int i = 0 ; i < ZooPanel.data.size(); i++)
        {
            cAllAnimal.addItem(ZooPanel.data.get(i).getClass().getSimpleName());
        }

        cSelect_X.addActionListener(this);
        cSelect_Y.addActionListener(this);
        bConfirmation.addActionListener(this);

    }

    /**
     *
     * @param e : e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == cAllAnimal)
        {
            counter = cAllAnimal.getSelectedIndex();
        }

        if (e.getSource() == cSelect_X)
        {
            ZooPanel.data.get(counter).settX(cSelect_X.getSelectedIndex());
        }

        if(e.getSource() == cSelect_Y)
        {
            ZooPanel.data.get(counter).settY(cSelect_Y.getSelectedIndex());
        }

        if(e.getSource() == bConfirmation)
        {
            JOptionPane.showMessageDialog(null, "Coordinate Changed", "Coordinate", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
            System.out.println(ZooPanel.data.get(counter).getLocation());
        }
    }
}