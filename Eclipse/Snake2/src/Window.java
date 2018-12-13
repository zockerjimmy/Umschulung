import java.awt.EventQueue;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame
{

	public Window()
	{
		Panel _panel = new Panel();
		this.add(_panel);
		setTitle("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();		
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				Window _window = new Window();
				_window.setVisible(true);
			}
		});
	}

}
