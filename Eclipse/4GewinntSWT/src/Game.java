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
	private int maxColums = 7;
	private int maxRows = 6;
	private int[][] slots = new int[maxRows][maxColums];
	private int[][] slotsPosX = new int[maxRows][maxColums];
	private int[][] slotsPosY = new int[maxRows][maxColums];
	private int[][] slotsPosXEnd = new int[maxRows][maxColums];
	private int[][] slotsPosYEnd = new int[maxRows][maxColums];
	private String output;
	private Button button;
	
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

		button = new Button(canvas, SWT.PUSH);
		button.setText("Reset");
		button.setLocation(130, 50);
		button.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent event)
			{
				Reset();
			}

			public void widgetDefaultSelected(SelectionEvent event)
			{

			}
		});
		button.setVisible(false);
		button.pack();
		
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
	}

	private void DrawGamefield(Event event, Display display)
	{
		GC gc = event.gc;
		Rectangle clientArea = canvas.getClientArea();
		gc.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
		gc.fillRectangle(clientArea);
		gc.setBackground(display.getSystemColor(SWT.COLOR_BLACK));

		int slotWidth = clientArea.width / 10;
		for (int i = 0; i < maxRows; i++)
		{
			for (int j = 0; j < maxColums; j++)
			{
				slotPosx = (slotWidth + (slotWidth * j)) + (5 * (j + 0));

				slotsPosX[i][j] = slotPosx;
				slotsPosXEnd[i][j] = slotPosx + slotWidth;
				slotsPosY[i][j] = 40 * (i + 1);
				slotsPosYEnd[i][j] = 40 * (i + 1) + slotWidth;

				if (slots[i][j] == 0)
				{
					gc.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
					gc.fillOval(slotPosx, slotsPosY[i][j], slotWidth, slotWidth);
				}
				if (slots[i][j] == 1)
				{
					gc.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));
					gc.fillOval(slotPosx, slotsPosY[i][j], slotWidth, slotWidth);
				}
				if (slots[i][j] == 2)
				{
					gc.setBackground(display.getSystemColor(SWT.COLOR_RED));
					gc.fillOval(slotPosx, slotsPosY[i][j], slotWidth, slotWidth);
				}
			}
		}
		
		if(isGameOver)
		{
			Font font = new Font(event.display, "Tahoma", 18, SWT.BOLD);
			gc.setFont(font);
			gc.setForeground(event.display.getSystemColor(SWT.COLOR_WHITE));
			gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GREEN));
			gc.drawString(output, 65, 135);
			button.setVisible(true);
		}
		gc.dispose();
	}

	private void CheckPlayerInput(int x, int y)
	{
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				if ((x >= slotsPosX[i][j] && y >= slotsPosY[i][j])
						&& (x < slotsPosXEnd[i][j] && y < slotsPosYEnd[i][j]))
				{
					DropCoin(i, j);
					if (!isGameOver)
					{
						player = player == ePlayer.Player1 ? ePlayer.Player2 : ePlayer.Player1;
					}
				}
			}
		}
	}

	private void DropCoin(int indexRow, int indexColum)
	{
		int tempSlotRow = 0;

		if (slots[0][indexColum] == 0)
		{
			if (player == ePlayer.Player1)
			{
				for (int i = 0; i < maxRows; i++)
				{
					if (slots[i][indexColum] == 0)
						tempSlotRow = i;
				}
				slots[tempSlotRow][indexColum] = 1;
				canvas.redraw();
			}
			else if (player == ePlayer.Player2)
			{
				for (int i = 0; i < maxRows; i++)
				{
					if (slots[i][indexColum] == 0)
						tempSlotRow = i;
				}
				slots[tempSlotRow][indexColum] = 2;
				canvas.redraw();
			}
			CheckSlots();
		}
	}

	private void CheckSlots()
	{
		int iPlayer = 1;

		if (player == ePlayer.Player1)
		{
			iPlayer = 1;
		}
		else if (player == ePlayer.Player2)
		{
			iPlayer = 2;
		}
		
		// horizontalCheck
		for (int j = 0; j < maxColums - 3; j++)
		{
			for (int i = 0; i < maxRows; i++)
			{
				if (slots[i][j] == iPlayer && slots[i][j + 1] == iPlayer && slots[i][j + 2] == iPlayer
						&& slots[i][j + 3] == iPlayer)
				{
					isGameOver = true;
					break;
				}
			}
		}
		// verticalCheck
		for (int j = 0; j < maxColums; j++)
		{
			for (int i = 0; i < maxRows - 3; i++)
			{
				if (slots[i][j] == iPlayer && slots[i + 1][j] == iPlayer && slots[i + 2][j] == iPlayer
						&& slots[i + 3][j] == iPlayer)
				{
					isGameOver = true;
					break;
				}
			}
		}
		// ascendingDiagonalCheck
		for (int i = 3; i < maxRows; i++)
		{
			for (int j = 0; j < maxColums - 3; j++)
			{
				if (slots[i][j] == iPlayer && slots[i - 1][j + 1] == iPlayer && slots[i - 2][j + 2] == iPlayer
						&& slots[i - 3][j + 3] == iPlayer)
				{
					isGameOver = true;
					break;
				}
			}
		}
		// descendingDiagonalCheck
		for (int i = 3; i < maxRows; i++)
		{
			for (int j = 3; j < maxColums; j++)
			{
				if (slots[i][j] == iPlayer && slots[i - 1][j - 1] == iPlayer && slots[i - 2][j - 2] == iPlayer
						&& slots[i - 3][j - 3] == iPlayer)
				{
					isGameOver = true;
					break;
				}
			}
		}		
		if (isGameOver)
		{
			if(isGameOver)
			{				
				output = player + " won";
			}
		}
	}

	private void Reset()
	{
		System.out.println("Reset");
		for (int i = 0; i < maxRows; i++)
		{
			for (int j = 0; j < maxColums; j++)
			{
			slots[i][j] = 0;
			}
		}
		isGameOver = false;
		button.setVisible(false);
		player = ePlayer.Player1;
		canvas.redraw();
	}
}
