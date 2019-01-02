package TTTPanel;
import java.awt.EventQueue;
import javax.swing.JFrame;

import SnakePanel.WindowSnake;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Hauptfenster
@SuppressWarnings("serial")
public class GameTTT extends JFrame
{	
	
	public static int[][] fields = new int[3][3];
	public static int[][] fieldCoordX = new int[3][3];
	public static int[][] fieldCoordY = new int[3][3];
	public static int[][] fieldCoordXEnd = new int[3][3];
	public static int[][] fieldCoordYEnd = new int[3][3];
		
	public GameTTT()
	{
		GamePanel gamePanel = new GamePanel();
	
		add(gamePanel);
		setResizable(false);
		setTitle("TicTacTo");
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
			
				GameTTT game = new GameTTT();
				game.setVisible(true);
			}						
		});
		

	}
	
}
