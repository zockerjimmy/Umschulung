package SnakePanel;
import java.awt.EventQueue;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class WindowSnake extends JFrame
{

	public WindowSnake()
	{
		Panel _panel = new Panel();
		this.add(_panel);
		setTitle("Snake");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();		
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				WindowSnake _window = new WindowSnake();
				_window.setVisible(true);
			}
		});
	}

}
