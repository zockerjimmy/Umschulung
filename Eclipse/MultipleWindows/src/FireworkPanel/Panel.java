package FireworkPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings(
{ "unused", "serial" })
public class Panel extends JPanel
{
	// Particle _particle;
	// Firework _fireworks;
	ArrayList<Firework> _fireworks = new ArrayList<Firework>();
	
	Timer timer;
	ActionListener timerAction;
	boolean listSorted, isSortingList;

	public Panel()
	{
		listSorted = true;
		isSortingList = false;
		setFocusable(true);
		setBackground(new Color(0, 0, 5));
		setPreferredSize(new Dimension(1000, 600));

		StartSimulation();
	}

	public void StartSimulation()
	{
		AddTimerListener();

		timer = new Timer(4, timerAction); // Notify timerAction (Listener) alle 4 ms
		timer.setInitialDelay(0); // Starte sofort / ohne Delay
		timer.start();
	}

	public void AddTimerListener() // Listener für den Timer, wird alle 4 ms ausgeführt
	{
		timerAction = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (ThreadLocalRandom.current().nextDouble(0, 1) < 0.01)
				{
					_fireworks.add(new Firework());
				}
				Repaint();
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
		setBackground(new Color(0, 0, 5, 15));
		super.paintComponent(g);			
		for (int i = _fireworks.size() - 1; i >= 0; i--)
		{
			if(_fireworks.get(i).Done())
			{
				_fireworks.remove(i);
			}
			else
			{				
				_fireworks.get(i).Update();
				_fireworks.get(i).Draw(g);			
			}
		}	
	}
}
