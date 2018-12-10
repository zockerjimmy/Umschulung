import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.Timer;

@SuppressWarnings({ "unused", "serial" })
public class Snake extends JPanel
{
	private Logic _logic = new Logic();
	
	protected Timer timer;
	protected int frame;	
	
	public Snake()
	{
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(300,300));
		frame = 250;
		StartGame();
	}
	
	public void StartGame()
	{	
		ActionListener action = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (!_logic.isGameOver)
				{
					_logic.MoveSnake();
					Repaint();
				} else if(_logic.isGameOver)
				{
					timer.stop();
				}
			}
		};
		timer = new Timer(frame, action);
		timer.setInitialDelay(0);
		timer.start();
	}
	
	public void Repaint()
	{
		this.repaint();
	}
	
	@Override public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawSnake(g);
		drawFood(g);		
	}
		
	public void drawSnake(Graphics g)
	{
		g.setColor(Color.BLACK);		
		for(int i = 0; i < _logic.snake; i++)
		{
			g.fillRect(_logic.snakePosX.get(i), _logic.snakePosY.get(i) + (i*11), _logic.snakeSizeX, _logic.snakeSizeY);
		}
	}
	
	public void drawFood(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(_logic.foodPosX, _logic.foodPosY, _logic.foodSizeX, _logic.foodSizeY);
		g.setColor(Color.BLACK);
	}
}
