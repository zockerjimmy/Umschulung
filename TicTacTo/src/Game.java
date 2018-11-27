import java.awt.EventQueue;
import javax.swing.JFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Hauptfenster
public class Game extends JFrame
{	
	public Game()
	{
		InitWindow();
	}

	public void InitWindow()
	{
		// Fuege dem Hauptfenster (JFrame) das gewuensche Panel hinzu
		add(new GamePanel());
		setResizable(false);
		pack();
		setTitle("TicTacTo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}	

	public static void main(String[] args)
	{
		PlayerInput playerInput = new PlayerInput();
		
		EventQueue.invokeLater(() ->
		{
			Game game = new Game();
			game.setVisible(true);

			game.addMouseListener(new MouseListener()
			{
				public void mousePressed(MouseEvent me){}
				public void mouseReleased(MouseEvent me){}
				public void mouseEntered(MouseEvent me){}
				public void mouseExited(MouseEvent me){}
				public void mouseClicked(MouseEvent me)
				{
					if (me.getButton() == MouseEvent.BUTTON1)
					{
						int x, y;
						x = me.getX();
						y = me.getY() - 25;
						
						playerInput.CheckPlayerInput(x,y);
						game.repaint();
						playerInput.CheckFields();
					}
				}
			});
		});
	}
	
}
