package Connect4Package;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Connect4Window extends JFrame
{
	
	public Connect4Window()
	{
		Connect4Panel panel = new Connect4Panel();
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run()
			{
				Connect4Window window = new Connect4Window();
				window.setVisible(true);
			}
			});
	}

}
