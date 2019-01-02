import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainWindow extends JFrame
{
	
	
	public MainWindow() throws IOException
	{
		MainPanel _mainPanel = new MainPanel();
		this.add(_mainPanel);
		this.setTitle("Main Window");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
	}
		
	public static void main(String[] args)
	{		
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				MainWindow _mainPanel;
				try
				{
					_mainPanel = new MainWindow();
					_mainPanel.setVisible(true);
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
