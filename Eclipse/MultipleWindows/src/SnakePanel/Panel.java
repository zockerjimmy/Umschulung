package SnakePanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Panel extends JPanel
{
	public Snake _Snake;
	public Food _Food;
	public ActionListener listenerTimer;
	public KeyListener listenerKey;
	public Timer timer;
	public static boolean ISGAMEOVER;

	public static final int WINDOW_WIDTH = 300;
	public static final int WINDOW_HEIGHT = 300;

	public Panel()
	{
		this._Snake = new Snake();
		this._Food = new Food();
		setFocusable(true);
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setBackground(Color.WHITE);
		ISGAMEOVER = false;
		Init();
	}

	public void Init()
	{
		AddListenerTimer();
		AddListenerKey();
		timer = new Timer(200, listenerTimer);
		timer.start();
	}

	public void AddListenerTimer()
	{
		listenerTimer = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (!ISGAMEOVER)
				{
					_Snake.Update(_Food.foodPos.x, _Food.foodPos.y);
					if (_Snake.needNewFood)
					{
						_Food.NewFood();
						_Snake.needNewFood = false;
					}
					Repaint();
				}
				else
					timer.stop();
			}
		};
	}

	public void Repaint()
	{
		this.repaint();
	}

	public void AddListenerKey()
	{
		listenerKey = new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{

			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				int key = e.getKeyCode();

				if (!_Snake.isChangingDirectionHorizontal && !_Snake.isChangingDirectionVertical)
				{
					if (key == KeyEvent.VK_UP)
					{
						if (_Snake.eDirection == _Snake.eDirection.LEFT || _Snake.eDirection == _Snake.eDirection.RIGHT)
						{
							_Snake.isChangingDirectionVertical = true;
							_Snake.lastX = (int) _Snake.snakePos.get(0).x;
							_Snake.lastY = (int) _Snake.snakePos.get(0).y;
							_Snake.setDirection(_Snake.eDirection.TOP);
						}
					}
					if (key == KeyEvent.VK_DOWN)
					{
						if (_Snake.eDirection == _Snake.eDirection.LEFT || _Snake.eDirection == _Snake.eDirection.RIGHT)
						{
							_Snake.isChangingDirectionVertical = true;
							_Snake.lastX = (int) _Snake.snakePos.get(0).x;
							_Snake.lastY = (int) _Snake.snakePos.get(0).y;
							_Snake.setDirection(_Snake.eDirection.DOWN);
						}
					}

					if (key == KeyEvent.VK_LEFT)
					{
						if (_Snake.eDirection == _Snake.eDirection.TOP || _Snake.eDirection == _Snake.eDirection.DOWN)
						{
							_Snake.isChangingDirectionHorizontal = true;
							_Snake.lastX = (int) _Snake.snakePos.get(0).x;
							_Snake.lastY = (int) _Snake.snakePos.get(0).y;
							_Snake.setDirection(_Snake.eDirection.LEFT);
						}
					}
					if (key == KeyEvent.VK_RIGHT)
					{
						if (_Snake.eDirection == _Snake.eDirection.TOP || _Snake.eDirection == _Snake.eDirection.DOWN)
						{
							_Snake.isChangingDirectionHorizontal = true;
							_Snake.lastX = (int) _Snake.snakePos.get(0).x;
							_Snake.lastY = (int) _Snake.snakePos.get(0).y;
							_Snake.setDirection(_Snake.eDirection.RIGHT);
						}
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e)
			{

			}

		};
		addKeyListener(listenerKey);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.setColor(Color.RED);
		g.fillRect((int) _Food.foodPos.x, (int) _Food.foodPos.y, _Food.foodWidth, _Food.foodHeight);

		for (int i = 0; i < _Snake.snakePos.size(); i++)
		{
			 g.setColor(i==0 ? Color.BLUE : Color.BLACK);
			//g.setColor(Color.BLACK);
			g.fillRect((int) _Snake.snakePos.get(i).x, (int) _Snake.snakePos.get(i).y, _Snake.snakeWidth,
					_Snake.snakeHeight);
		}
	}
}
