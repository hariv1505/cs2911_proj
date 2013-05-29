
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;

/**
   Presents a phone GUI for the voice mail system.
*/
public class TheBoard
{
   /**
      Constructs a telephone with a speaker, keypad,
      and microphone.
   */
   public TheBoard()
   {
      JPanel sudokuPanel = new JPanel();
      sudokuPanel.setLayout(new BorderLayout());
      sudokuPanel.add(new JLabel("Sudoku Game"),
            BorderLayout.NORTH);
      
      
      theGame = new Game();
      
      JPanel gridPanel = new JPanel();
      gridPanel.setLayout(new GridLayout(9, 9));
      for (int i = 0; i < 3; i++) {
    	  for (int j = 0; j < 3; j++) {
    		  for (int k = 0; k < 3; k++) {
    			  for (int l = 0; l < 3; l++) {
    				  final String label;
    				  if (theGame.getCurrentBoard().getBoard(i,k).getNum(j,l) != 0) {
    	    			  label = "" + theGame.getCurrentBoard().getBoard(i,k).getNum(j, l) + "";
    	    		  }
    	    		  
    	    		  else {
    	    			  label = "";
    	    		  }
    	    		  
    	    		  final JButton keyButton = new JButton(label);
    	    		  if ((i + k) % 2 == 1) {
    	    			  keyButton.setBackground(Color.YELLOW);  
    	    		  }
	    	          
    	    		  else keyButton.setBackground(Color.CYAN);
	    	          gridPanel.add(keyButton);
	    	          newNum(keyButton);
    			  }
    		  }
    	  }
      }
      
      JLabel hintArea = new JLabel("Right input");
      

      JButton hintButton = new JButton("Toggle Hint");
      hintButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
            	theGame.toggleHint();
            }
         });
      
      JButton clueButton = new JButton("Get Clue");
      clueButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
            	theGame.getExplanation(null); //fix
            }
         });

      JButton quitButton = new JButton("Quit");
      quitButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
            	System.exit(0);
            }
         });

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(clueButton);
      buttonPanel.add(hintButton);
      buttonPanel.add(quitButton);
      
      JPanel consoleArea = new JPanel();
      consoleArea.setLayout(new BorderLayout());
      JLabel consoleTitle = new JLabel("Console");
      newInput = new JTextArea();
      consoleArea.add(consoleTitle, BorderLayout.NORTH);
      consoleArea.add(newInput, BorderLayout.SOUTH);

      JPanel optionsPanel = new JPanel();
      optionsPanel.setLayout(new BorderLayout());
      optionsPanel.add(new JLabel("Options:"),
            BorderLayout.CENTER);
      optionsPanel.add(hintArea, BorderLayout.NORTH);
      optionsPanel.add(buttonPanel, BorderLayout.CENTER);
      optionsPanel.add(consoleArea, BorderLayout.SOUTH);

      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(sudokuPanel, BorderLayout.NORTH);
      frame.add(gridPanel, BorderLayout.CENTER);
      frame.add(optionsPanel, BorderLayout.SOUTH);

      frame.pack();
      frame.setVisible(true);
   }

   private void newNum(final JButton keyButton) {
	   keyButton.addActionListener(new
	             ActionListener()
	             {
	                public void actionPerformed(ActionEvent event)
	                {
	             	   String newNum = newInput.getText();
	                   keyButton.setText(newNum);
	                   newInput.setText("");
	                }
	             });	
}

/**
      Give instructions to the mail system user.
   */
   public void speak(String output)
   {
      speakerField.setText(output);
   }

   public void run()
   {
   }

   private JTextArea speakerField;
   private final Game theGame;
   private JTextArea newInput;
}
