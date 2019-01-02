import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import FireworkPanel.FireworkWindow;
import SnakePanel.WindowSnake;
import TTTPanel.GameTTT;

@SuppressWarnings("serial")
public class MainPanel extends JPanel
{
	public JButton buttonTempPanel;
	public JButton buttonTempPanel2;
	public JButton buttonTempPanel3;
	Rectangle[] slots = new Rectangle[8];
	

	public MainPanel() throws IOException
	{
		this.setLayout(null);
		this.setFocusable(true);
		this.setPreferredSize(new Dimension(1000, 700));
		this.setBackground(Color.DARK_GRAY);

		for (int i = 0; i < 3; i++)
		{
			this.slots[i] = new Rectangle(0, 0);
			this.slots[i].setBounds(1 + (i * 332), 0, 332, 500);
		}

		CreateImages();

		this.CreateButton1();
		this.CreateButton2();
		this.CreateButton3();
	}

	public void CreateImages() throws IOException
	{				
		Image fireworkImage = ImageIO.read(getClass().getResource("firework.PNG"));
		Image snakeImage = ImageIO.read(getClass().getResource("snake.PNG"));
		Image connectImage = ImageIO.read(getClass().getResource("connect.PNG"));

		JLabel fireworkLabel = new JLabel(new ImageIcon(fireworkImage));
		JLabel snakeLabel = new JLabel(new ImageIcon(snakeImage));
		JLabel connectLabel = new JLabel(new ImageIcon(connectImage));

		fireworkImage = fireworkImage.getScaledInstance(this.slots[0].width - 1, this.slots[0].height / 2,
				Image.SCALE_SMOOTH);
		fireworkLabel.setBounds(this.slots[0].x + 1, this.slots[0].y + 1, this.slots[0].width - 1,
				this.slots[0].height -170);
	
		snakeImage = snakeImage.getScaledInstance(this.slots[1].width - 1, this.slots[1].height -170,
				Image.SCALE_SMOOTH);
		
		snakeLabel.setBounds(this.slots[1].x + 1, this.slots[1].y + 1, this.slots[1].width - 1,
				this.slots[1].height -170);
	
		connectImage = connectImage.getScaledInstance(this.slots[2].width - 1, this.slots[2].height / 2,
				Image.SCALE_SMOOTH);
		connectLabel.setBounds(this.slots[2].x + 1, this.slots[2].y + 1, this.slots[2].width - 1,
				this.slots[2].height -170);
		
		this.add(fireworkLabel);
		this.add(snakeLabel);
		this.add(connectLabel);

	}

	public void CreateButton1()
	{
		this.buttonTempPanel = new JButton("Firework Sim.");
		this.buttonTempPanel.setBounds(this.slots[0].width / 3, this.slots[0].height - 100, 100, 50);
		this.add(this.buttonTempPanel);
		this.buttonTempPanel.setVisible(true);
		this.buttonTempPanel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CreateWindow1();
			}
		});
	}

	public void CreateButton2()
	{
		this.buttonTempPanel2 = new JButton("Snake");
		this.buttonTempPanel2.setBounds(this.slots[1].x + (this.slots[1].width / 3), this.slots[1].height - 100, 100,
				50);
		this.add(this.buttonTempPanel2);
		this.buttonTempPanel2.setVisible(true);
		this.buttonTempPanel2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CreateWindow2();
			}
		});
	}

	public void CreateButton3()
	{
		this.buttonTempPanel3 = new JButton("Connect 4");
		this.buttonTempPanel3.setBounds(this.slots[2].x + (this.slots[2].width / 3), this.slots[2].height - 100, 100,
				50);
		this.add(this.buttonTempPanel3);
		this.buttonTempPanel3.setVisible(true);
		this.buttonTempPanel3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CreateWindow3();
			}
		});
	}

	public void CreateWindow1()
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				FireworkWindow _fireworkWindow = new FireworkWindow();
				_fireworkWindow.setVisible(true);
			}

		});
	}

	public void CreateWindow2()
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				WindowSnake _Snake = new WindowSnake();
				_Snake.setVisible(true);
			}

		});
	}

	public void CreateWindow3()
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				GameTTT ttt = new GameTTT();
				ttt.setVisible(true);
			}

		});
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		for (int i = 0; i < 3; i++)
		{
			g.drawRect(this.slots[i].x, this.slots[i].y, this.slots[i].width, this.slots[i].height);			
		}
	}
}
