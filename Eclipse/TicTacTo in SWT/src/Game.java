import java.awt.Graphics;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.events.*;

public class Game extends MouseAdapter
{
	private Shell shell;
	private Canvas canvas;

	public static int[] field = new int[9];
	public int[] fieldCoords = new int[36];

	private GC gc;

	public Game(Display display)
	{
		InitShell(display);
	}

	private void InitShell(Display display)
	{
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		shell.setText("TicTacTo in SWT");

		// SetSize setzt normalerweise nur die Größe des kompletten Fensters (inkl.
		// Ränder)
		// Über addShellListener wird bei aktiviertem Fenster die Größe so geändert dass
		// die angebenen Werte nur für das "innere" Fenster gelten
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
				shell.setSize(300 + shell.getSize().x - shell.getClientArea().width,
						300 + shell.getSize().y - shell.getClientArea().height);
			}
		});

		shell.addListener(SWT.Paint, event -> DrawPlayfield(event));	

		//canvas = new Canvas(shell, SWT.NONE);
		//WENN GAME OVER DISPOSE
		 //gc = new GC(canvas);
		 
		shell.addMouseListener(new MouseListener() {
			@Override
			public void mouseDown(MouseEvent e)
			{		
				/*Point cursorLocation = Display.getCurrent().getCursorLocation();
				cursorLocation = Display.getCurrent().getFocusControl().toControl(cursorLocation);
				DrawPlayerInput(cursorLocation.x, cursorLocation.y);*/
				field[1] = 1;
				shell.addListener(SWT.Paint, event -> DrawPlayerInputs(event));	
				//canvas.getListeners(SWT.Paint);
				//DrawPlayerInputs();
			}

			@Override
			public void mouseDoubleClick(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseUp(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		});

		shell.open();

		// gc.dispose();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	private void DrawPlayfield(Event e)
	{
		GC gc = e.gc;

		// Color c1 = new Color(e.display, 0,0,0);

		gc.drawLine(100, 0, 100, 300);
		gc.drawLine(200, 0, 200, 300);
		gc.drawLine(0, 100, 300, 100);
		gc.drawLine(0, 200, 300, 200);

		gc.dispose();
	}

	private void DrawPlayerInputs(Event e)
	{
		GC gc = e.gc;
		int coordElement = 0;
		for (int i = 0; i < field.length; i++)
		{
			if (i == 0)
			{
				coordElement = 0;
			}
			else
			{
				coordElement += 4;
			}

			if (field[i] == 1)
			{
				//gc.drawOval(fieldCoords[coordElement], fieldCoords[coordElement + 2], 100, 100);
				e.gc.drawOval(0, 0, 100, 100);
			}
			else if (field[i] == 2)
			{
				/*DrawCross(g, fieldCoords[coordElement], fieldCoords[coordElement + 2], fieldCoords[coordElement + 1],
						fieldCoords[coordElement + 3]);*/
			}
			else
			{
				 System.out.println(field[i]);
			}
		}
		
		//canvas.redraw();

	}

	private void SetFieldCoords()
	{
		// Field 1
		fieldCoords[0] = 0; // x1
		fieldCoords[1] = 100; // x2
		fieldCoords[2] = 0; // y1
		fieldCoords[3] = 100; // y2

		// Field 2
		fieldCoords[4] = 100; // x1
		fieldCoords[5] = 200; // x2
		fieldCoords[6] = 0; // y1
		fieldCoords[7] = 100; // y2

		// Field 3
		fieldCoords[8] = 200; // x1
		fieldCoords[9] = 300; // x2
		fieldCoords[10] = 0; // y1
		fieldCoords[11] = 100; // y2

		// Field 4
		fieldCoords[12] = 0; // x1
		fieldCoords[13] = 100; // x2
		fieldCoords[14] = 100; // y1
		fieldCoords[15] = 200; // y2

		// Field 5
		fieldCoords[16] = 100; // x1
		fieldCoords[17] = 200; // x2
		fieldCoords[18] = 100; // y1
		fieldCoords[19] = 200; // y2

		// Field 6
		fieldCoords[20] = 200; // x1
		fieldCoords[21] = 300; // x2
		fieldCoords[22] = 100; // y1
		fieldCoords[23] = 200; // y2

		// Field 7
		fieldCoords[24] = 0; // x1
		fieldCoords[25] = 100; // x2
		fieldCoords[26] = 200; // y1
		fieldCoords[27] = 300; // y2

		// Field 8
		fieldCoords[28] = 100; // x1
		fieldCoords[29] = 200; // x2
		fieldCoords[30] = 200; // y1
		fieldCoords[31] = 300; // y2

		// Field 9
		fieldCoords[32] = 200; // x1
		fieldCoords[33] = 300; // x2
		fieldCoords[34] = 200; // y1
		fieldCoords[35] = 300; // y2
	}

	public static void main(String[] args)
	{
		Display display = new Display();
		Game game = new Game(display);
		display.dispose();
	}
}
