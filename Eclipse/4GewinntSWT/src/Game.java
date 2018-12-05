import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.FillLayout;

public class Game
{
	private Shell shell;
	private Canvas canvas;
	private int slotPosx;
	private int maxWidthField = 7;
	private int maxHeightField = 6;
	private int[][] slots = new int[maxHeightField][maxWidthField];
	private int[][] slotsPosX = new int[maxHeightField][maxWidthField];
	private int[][] slotsPosY = new int[maxHeightField][maxWidthField];
	private int[][] slotsPosXEnd = new int[maxHeightField][maxWidthField];
	private int[][] slotsPosYEnd = new int[maxHeightField][maxWidthField];

	private enum ePlayer
	{
		Player1, Player2
	};

	private ePlayer player = ePlayer.Player1;
	private boolean isGameOver = false;

	public static void main(String[] args)
	{
		Display display = new Display();
		Game game = new Game(display);
		display.dispose();
	}

	private Game(Display display)
	{
		InitShell(display);
	}

	private void InitShell(Display display)
	{
		shell = new Shell(display);
		shell.setText("4 Gewinnt");
		shell.setLayout(new FillLayout());
		canvas = new Canvas(shell, SWT.NONE);
		shell.addShellListener(new ShellListener()
		{
			@Override
			public void shellActivated(ShellEvent e)
			{
				shell.setSize(300 + shell.getSize().x - shell.getClientArea().width,
						300 + shell.getSize().y - shell.getClientArea().height);
			}

			@Override
			public void shellClosed(ShellEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void shellDeactivated(ShellEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void shellDeiconified(ShellEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void shellIconified(ShellEvent e)
			{
				// TODO Auto-generated method stub

			}

		});

		shell.open();
		InitGame(display);

		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	private void InitGame(Display display)
	{
		canvas.addListener(SWT.Paint, event -> DrawGame(event, display));

		canvas.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseDoubleClick(MouseEvent e)
			{
			}

			@Override
			public void mouseDown(MouseEvent e)
			{
				Point curserPosition = display.getCursorLocation();
				curserPosition = display.getFocusControl().toControl(curserPosition);
				if (!isGameOver)
				{
					CheckPlayerInput(curserPosition.x, curserPosition.y);
				}
			}

			@Override
			public void mouseUp(MouseEvent e)
			{
			}
		});
		canvas.redraw();
	}

	private void DrawGame(Event event, Display display)
	{
		DrawGamefield(event, display);
		//DrawPlayerInput(event, display);
	}
	
	private void DrawGamefield(Event event, Display display)
	{
		GC gc = event.gc;
		Rectangle clientArea = canvas.getClientArea();
		gc.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
		gc.fillRectangle(clientArea);
		gc.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
		
		int slotWidth = clientArea.width / 10;
		for (int i = 0; i < maxHeightField; i++)
		{
			for (int j = 0; j < maxWidthField; j++)
			{
				slotPosx = (slotWidth + (slotWidth * j)) + (5 * (j + 0));

				slotsPosX[i][j] = slotPosx;
				slotsPosXEnd[i][j] = slotPosx + slotWidth;
				slotsPosY[i][j] = 40 * (i + 1);
				slotsPosYEnd[i][j] = 40 * (i + 1) + slotWidth;
				//slots[i][j] = 0;
				
				if(slots[i][j] == 0)
				{
					gc.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
					gc.fillOval(slotPosx, 40 * (i + 1), slotWidth, slotWidth);
				}
				if(slots[i][j] == 1)
				{
					gc.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));
					gc.fillOval(slotPosx, 40 * (i + 1), slotWidth, slotWidth);
				}
				if(slots[i][j] == 2)
				{
					gc.setBackground(display.getSystemColor(SWT.COLOR_RED));
					gc.fillOval(slotPosx, 40 * (i + 1), slotWidth, slotWidth);
				}

				//System.out.print((j + (7 * i)) < 10 ? "0" + (j + (7 * i)) + " " : (j + (7 * i)) + " ");
			}
		}
		gc.dispose();
	}

	private void DrawPlayerInput(Event event, Display display)
	{
		
	}
	
	//https://stackoverflow.com/questions/32770321/connect-4-check-for-a-win-algorithm
	
	private void CheckPlayerInput(int x, int y)
	{
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				if ((x >= slotsPosX[i][j] && y >= slotsPosY[i][j])
						&& (x < slotsPosXEnd[i][j] && y < slotsPosYEnd[i][j]))
				{				
					CheckSlots(i, j);
					if (!isGameOver)
					{
					//	player = player == ePlayer.Player1 ? ePlayer.Player2 : ePlayer.Player1;
					}
				}
			}
		}
	}

	private void CheckSlots(int chosenSlotIndexI, int chosenSlotIndexJ)
	{
		//check vertical
		//chip fallen lassen dann alles andere check0rn
		
		
		int counter = 1;
		if (slots[chosenSlotIndexI][chosenSlotIndexJ] == 0)
		{		
			//check horizontal
			if (player == ePlayer.Player1)
			{
				//canvas.notifyListeners(SWT.Paint, new Event());
				canvas.redraw();
				for (int i = 0; i < maxWidthField; i++)
				{				
					if (slots[chosenSlotIndexI][i] == 1)						
						counter++;
					else
						counter = 1;
					if (counter == 4)
						System.out.println("win 1");
				}
			} else if (player == ePlayer.Player2)
			{
				//slots[chosenSlotIndexI][chosenSlotIndexJ] = 2;	
				//canvas.notifyListeners(SWT.Paint, new Event());
				canvas.redraw();
				for (int i = 0; i < maxWidthField; i++)
				{				
					if (slots[chosenSlotIndexI][i] == 1)
						counter++;
					else
						counter = 1;
					if (counter == 4)
						System.out.println("win 1");
				}
			}
		}
	}

}
