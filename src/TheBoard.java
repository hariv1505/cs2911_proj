
import java.awt.*;
import java.awt.event.*;
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
      
      
      final Game theGame = new Game();
      
      JPanel gridPanel = new JPanel();
      gridPanel.setLayout(new GridLayout(9, 9));
      for (int i = 0; i < 9; i++)
      {
    	  for (int j = 0; j < 9; j++) {
    		  final String label;
    		  if (theGame.getCurrentBoard().getBoard(i/3,j/3).getNum(i%3, j%3) != 0) {
    			  label = "" + theGame.getCurrentBoard().getBoard(i/3,j/3).getNum(i%3, j%3) + "";
    		  }
    		  
    		  else {
    			  label = "";
    		  }
    	         JButton keyButton = new JButton(label);
    	         gridPanel.add(keyButton);
    	         keyButton.addActionListener(new
    	            ActionListener()
    	            {
    	               public void actionPerformed(ActionEvent event)
    	               {
    	            	   //insert click on to change number function
    	               }
    	            });
    	  }
      }

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
            }
         });

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(clueButton);
      buttonPanel.add(hintButton);
      buttonPanel.add(quitButton);

      JPanel optionsPanel = new JPanel();
      optionsPanel.setLayout(new BorderLayout());
      optionsPanel.add(new JLabel("Options:"),
            BorderLayout.CENTER);
      optionsPanel.add(buttonPanel, BorderLayout.SOUTH);

      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(sudokuPanel, BorderLayout.NORTH);
      frame.add(gridPanel, BorderLayout.CENTER);
      frame.add(optionsPanel, BorderLayout.SOUTH);

      frame.pack();
      frame.setVisible(true);
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
}
