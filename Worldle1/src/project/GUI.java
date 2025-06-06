package project;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
    private String[][] tableData = new String[6][3]; 
    private String[] columnNames = {"Country", "Distance", "Feedback"};

    private JFrame window;
    private JLabel imageLabel;
    private JTextField inputField;
    private JTextArea feedbackArea;
    private JPanel inputPanel;
    private JPanel feedbackPanel;

    public GUI()
    {
        window = new JFrame();
        window.setTitle("Worldle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 800);
        
        try
        {
            countryNames = new CountryGetter("/Users/ahladmodi/Documents/Virginia Tech/Personal/countryNames.csv");
            answerCountry = countryNames.getRandomCountry();
            imageLabel = new JLabel();
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            showShapeImage(answerCountry);
        }
        catch (java.io.IOException e)
        {
            e.printStackTrace();
            // Optionally, show an error dialog or handle the error appropriately
        }
        
        inputField = new JTextField();
        JButton guessButton = new JButton("Guess");
        inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Your Guess: "), BorderLayout.WEST);
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(guessButton, BorderLayout.EAST);
        window.add(inputPanel, BorderLayout.NORTH);

        feedbackPanel = new JPanel(new BorderLayout());
        // Table for entered guesses
        JTable guessTable = new JTable(tableData, columnNames);
        guessTable.setEnabled(false); // Disable editing
        feedbackPanel.add(new JScrollPane(guessTable), BorderLayout.NORTH);


        // Feedback
        feedbackArea = new JTextArea(3,7);
        feedbackArea.setEditable(false);
        feedbackArea.setSize(300, 100);
        feedbackPanel.add(new JScrollPane(feedbackArea), BorderLayout.SOUTH);
        window.add(feedbackPanel, BorderLayout.SOUTH);

        // Action on guess
        guessButton.addActionListener(e -> checkGuess(countryNames));
        
        
    }


    private void checkGuess(CountryGetter countries)
    {
        String guess = inputField.getText().toLowerCase();
        Country guessedCountry = new Country(guess);
        if (!countries.isValidCountry(guessedCountry))
        {
            feedbackArea.setText("Invalid country name. Please try again.");
            return;
        }
        else if (guessedCountry.equals(answerCountry))
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
    
    
    private void showShapeImage(Country countryName)
    {
        String path = "/Users/ahladmodi/Documents/Virginia Tech/Personal/all/" + answerCountry.getCode() + "/256.png";
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
        window.add(imageLabel, BorderLayout.CENTER);
    }
    public void show()
    {
        window.setVisible(true);
    }

}
