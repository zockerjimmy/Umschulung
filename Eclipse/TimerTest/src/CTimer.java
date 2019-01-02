import javax.swing.JPanel;
import javax.swing.Timer;
//import java.util.Timer;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CTimer extends JPanel
{

	private Timer timer;
	private static CTimer ctimer;
	
	int count = 5;

	private CTimer()
	{
		Start();
	}

	public void Start()
	{
		System.out.println("START");
		ActionListener action = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (count > 0)
				{
					System.out.println("Counter: " + count);
					count--;
				} else if(count <= 0)
				{
					System.out.println("ENDE");
					timer.stop();					
				}
			}
		};

		timer = new Timer(1000, action);
		timer.setInitialDelay(100);
		timer.start();
	}

	public static void main(String[] args)
	{
		ctimer = new CTimer();		
	synchronized(ctimer)
	{
		try
		{
			ctimer.wait();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	}

}
