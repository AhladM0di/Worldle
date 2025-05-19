package project;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;


public class GUI extends JFrame
{
    private CountryGetter countryNames;
    private Country answerCountry;
    private int attempts = 0;
    private final int MAX_ATTEMPTS = 6;

    private JLabel imageLabel;
    private JTextField inputField;
    private JTextArea feedbackArea;

    public GUI()
    {
        setTitle("Worldle");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        try
        {
            countryNames = new CountryGetter("/Users/ahladmodi/Documents/Virginia Tech/Personal/countryNames.csv");
            answerCountry = countryNames.getRandomCountry();
            imageLabel = new JLabel();
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            showShapeImage(answerCountry);
            add(imageLabel, BorderLayout.CENTER);

        }
        
        catch (java.io.IOException e)
        {
            e.printStackTrace();
            // Optionally, show an error dialog or handle the error appropriately
        }
    }

    /**
     * This method is called when the user submits their guess.
     */
    private void showShapeImage(Country countryName)
    {
        String path = "/Users/ahladmodi/Documents/Virginia Tech/Personal/all/" + countryName.getCode() + "256.png";
        File file = new File(path);
        if (file.exists())
        {
            ImageIcon icon = new ImageIcon(path);
            Image scaled = icon.getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaled));
        }
        else
        {
            imageLabel.setText(" Image not found for " + countryName.getName());
        }
    }

    /**
     * This method is called when the user submits their guess.
     */
    private void checkGuess()
    {
        String guess = inputField.getText().toLowerCase();

        if (guess.equals(answerCountry.getName().toLowerCase()))
        {
            feedbackArea.setText("Correct! The country is " + answerCountry.getName());
            attempts = 0; // Reset attempts
            answerCountry = countryNames.getRandomCountry();
            showShapeImage(answerCountry);
        }
        else
        {
            attempts++;
            if (attempts >= MAX_ATTEMPTS)
            {
                feedbackArea.setText("Game Over! The correct country was " + answerCountry.getName());
                attempts = 0; // Reset attempts
                answerCountry = countryNames.getRandomCountry();
                showShapeImage(answerCountry);
            }
            else
            {
                feedbackArea.setText("Incorrect! Attempts left: " + (MAX_ATTEMPTS - attempts));
            }
        }
    }
}
