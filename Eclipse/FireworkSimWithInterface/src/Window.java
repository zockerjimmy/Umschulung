import java.awt.EventQueue;

import javax.swing.JFrame;

public class Window extends JFrame
{

	public Window()
	{
		Panel panel = new Panel();
		this.add(panel);
		this.setTitle("Firework Simulator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				Window window = new Window();
				window.setVisible(true);
			}
		});
	}
}
