import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Calc extends JFrame
{
	private static final Font MYFONT = new Font("monospaced", Font.PLAIN, 20);
	
	private JTextField displayField;
	
	private boolean isFirstNumber = true;
	private String previousOp = "=";
	private CalcLogic logic = new CalcLogic();
	
	public static void main(String[] args)
	{
		//Set "look and feel" to the active OS
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception unused){;}
		
		//Create Window
		Calc window = new Calc();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
			
	}

	//Constructor
	public Calc()
	{
		//Set display attributes
		displayField = new JTextField("0", 12);
		displayField.setHorizontalAlignment(JTextField.RIGHT);
		displayField.setFont(MYFONT);
		
		//Create & Set clearButton attributes
		JButton clearButton = new JButton("Clear");
		clearButton.setFont(MYFONT);
		//Own Listener for clear button
		clearButton.addActionListener(new ClearListener());

		//One own listener for all keyevents
		ActionListener numListener = new NumListener();
		
		//Use chars in String to layout and draw number buttons 	
		String buttonOrder = "798456123 0 ";
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5,3,2,2));
		for(int i = 0; i < buttonOrder.length(); i++)
		{
			String keyTop = buttonOrder.substring(i, i+1);
			JButton b = new JButton(keyTop);
			if(keyTop.equals(" "))
			{
				//set dummy button at this position
				b.setEnabled(false);
			}
			else
			{
				//set button with digit and add listener to the button
				b.addActionListener(numListener);
				b.setFont(MYFONT);
			}
		}
	}
	
	class NumListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//set listener 
		}		
	}
		
	class ClearListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//actionClear();
		}
	}

}
