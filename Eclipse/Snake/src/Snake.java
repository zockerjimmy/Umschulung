import java.awt.event.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.Timer;

@SuppressWarnings(
{ "unused", "serial" })
public class Snake extends JPanel
{
	private Logic _logic = new Logic();

	protected Timer timer;
	protected int frame;
	private Thread thread;
	ActionListener action;

	public Snake()
	{		
		setFocusable(true); //Setze JPanel als aktiven focus, damit Key-Eingaben erkannt werden
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(300, 300));
		frame = 250;
		StartGame();
	}
	
	public void StartGame()
	{		
		AddKeyListener();
		AddActionListener();
		
		timer = new Timer(frame, action);
		timer.setInitialDelay(0);
		timer.start();
	}
	
	public void AddKeyListener()
	{
		KeyListener keyAcction = new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				int key = e.getKeyCode();

				if ((key == KeyEvent.VK_UP))
				{
					if (_logic.getDirection() != _logic.eDirection.UP
							&& _logic.getDirection() != _logic.eDirection.DOWN)
						_logic.setDirection(_logic.eDirection.UP);
				} else if ((key == KeyEvent.VK_DOWN))
				{
					if (_logic.getDirection() != _logic.eDirection.UP
							&& _logic.getDirection() != _logic.eDirection.DOWN)
						_logic.setDirection(_logic.eDirection.DOWN);
				} else if ((key == KeyEvent.VK_LEFT))
				{
					if (_logic.getDirection() != _logic.eDirection.LEFT
							&& _logic.getDirection() != _logic.eDirection.RIGHT)
						_logic.setDirection(_logic.eDirection.LEFT);
				} else if ((key == KeyEvent.VK_RIGHT))
				{
					System.out.println(_logic.getDirection());
					if (_logic.getDirection() != _logic.eDirection.LEFT
							&& _logic.getDirection() != _logic.eDirection.RIGHT)
						_logic.setDirection(_logic.eDirection.RIGHT);
				}
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		};
		addKeyListener(keyAcction);
	}

	public void AddActionListener()
	{
		action = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (!_logic.isGameOver)
				{
					_logic.MoveSnake();
					Repaint();
				} else if (_logic.isGameOver)
				{
					timer.stop();
				}
			}
		};
	}
	
	public void Repaint()
	{
		this.repaint();
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawSnake(g);
		drawFood(g);
	}

	public void drawSnake(Graphics g)
	{
		g.setColor(Color.BLACK);
		for (int i = 0; i < _logic.snake; i++)
		{
			g.fillRect(_logic.snakePosX.get(i), _logic.snakePosY.get(i), _logic.snakeSizeX, _logic.snakeSizeY);
		}
	}

	public void drawFood(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(_logic.foodPosX, _logic.foodPosY, _logic.foodSizeX, _logic.foodSizeY);
		g.setColor(Color.BLACK);
	}

}
