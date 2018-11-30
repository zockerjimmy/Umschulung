import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.events.*;

public class Game
{
	private Shell shell;
	
	public Game(Display display)
	{
		InitShell(display);
	}
	
	private void InitShell(Display display)
	{
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);		
		shell.setText("TicTacTo in SWT");

		//SetSize setzt normalerweise nur die Größe des kompletten Fensters (inkl. Ränder)
		//Über addShellListener wird bei aktiviertem Fenster die Größe so geändert dass die angebenen Werte nur für das "innere" Fenster gelten
		shell.addShellListener(new ShellListener()
				{
				public void shellClosed(ShellEvent e)
				{
					
				}

				public void shellDeactivated(ShellEvent e)
				{
					
				}


				public void shellDeiconified(ShellEvent e)
				{

					
				}

				public void shellIconified(ShellEvent e)
				{
					
				}
				
				public void shellActivated(ShellEvent e)
				{
					shell.setSize(300 + shell.getSize().x - shell.getClientArea().width, 300 + shell.getSize().y - shell.getClientArea().height);
				}
				});
		
		shell.addListener(SWT.Paint, event -> DrawPlayfield(event));	
		
		shell.open();
		
		while(!shell.isDisposed())
		{
			if(!display.readAndDispatch()) 
				display.sleep();
		}
	}
	
	private void DrawPlayfield(Event e)
	{
		GC gc = e.gc;
		
		Color c1 = new Color(e.display, 0,0,0);
		
		gc.drawLine(100, 0, 100, 300);
		gc.drawLine(200, 0, 200, 300);
		gc.drawLine(0, 100, 300, 100);
		gc.drawLine(0, 200, 300, 200);
		
		c1.dispose();
	}
	
	public static void main(String[] args)
	{
		Display display = new Display();
		Game game = new Game(display);
		display.dispose();			
	}
}
