package Class_3;

import javax.swing.*;   // Needed for Swing classes
import java.awt.event.*; // Needed for ActionListener Interface
import java.io.IOException;

public class PokemonViewerGUI extends JFrame{
    private JLabel message;
    private JTextField pokemonID;
    private JButton getDataButton;
    private JPanel panel;
    JLabel pokemonImage;
    JLabel nameLabel;

    public PokemonViewerGUI()
    {
        final int WINDOW_WIDTH = 350;   // Window width in pixels
        final int WINDOW_HEIGHT = 250;  // Window height in pixels

        message = new JLabel(
                "Enter a Pokemon ID");
        pokemonID = new JTextField(5);
        getDataButton = new JButton("Get Data");
        nameLabel = new JLabel();
        pokemonImage =  new JLabel();
        panel = new JPanel();
        panel.add(message);
        panel.add(pokemonID);
        panel.add(getDataButton);
        panel.add(pokemonImage);
        panel.add(nameLabel);
        setTitle("Pokemon Viewer");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Add an action listener to the button.
        getDataButton.addActionListener(new PokemonViewerGUI.getDataButtonListener());

        // Add the panel to the frame's content pane.
        add(panel);

        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Display the window.
        setVisible(true);
    }

    private class getDataButtonListener implements ActionListener
    {
        /**
         The actionPerformed method executes when the user
         clicks on the getData  button.
         @param e The event object.
         */

        public void actionPerformed (ActionEvent e)
        {

            String inputID;  // To hold the user's input

            // Get the text entered by the user into the
            // text field.
            inputID = pokemonID.getText();
            // get name and URL of the pokemon
            String URL = PokemonDataAPI.getPokemonImageURL(inputID);
            String name = PokemonDataAPI.getPokemonName(inputID);
            String destinationFile = name + ".png";
            try {
                PokemonDataAPI.saveImage(URL, destinationFile);
            }
            catch(IOException ex)
            {
                System.out.printf("Cannot load Image");
            }
            // load image and name into gui
            ImageIcon icon = new ImageIcon(name+".png");
            nameLabel.setText(name);
            pokemonImage.setIcon(icon);

        }
    }

}
