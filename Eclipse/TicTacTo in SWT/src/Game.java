import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.events.*;

public class Game extends MouseAdapter
{
	private Shell shell;
	
	private int[][] fields = new int[3][3];
	private int[][] fieldCoordX = new int[3][3];
	private int[][] fieldCoordY = new int[3][3];
	private int[][] fieldCoordXEnd = new int[3][3];
	private int[][] fieldCoordYEnd = new int[3][3];
	
	enum player
	{
		Player1, Player2
	};

	public static player ePlayer = player.Player1;
	private boolean isGameOver = false;
	private String output;
	private Button button;

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

		shell.addListener(SWT.Paint, event -> DrawGame(event));

		shell.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseDown(MouseEvent e)
			{
				Point cursorLocation = Display.getCurrent().getCursorLocation();
				cursorLocation = Display.getCurrent().getFocusControl().toControl(cursorLocation);

				if (!isGameOver)
				{
					CheckPlayerInput(cursorLocation.x, cursorLocation.y);
					CheckFields();
					shell.redraw();
				}
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

		button = new Button(shell, SWT.PUSH);
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
		SetFieldCoords();

		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	private void DrawGame(Event e)
	{
		GC gc = e.gc;
		gc.drawLine(100, 0, 100, 300);
		gc.drawLine(200, 0, 200, 300);
		gc.drawLine(0, 100, 300, 100);
		gc.drawLine(0, 200, 300, 200);

		DrawPlayerInputs(gc);

		if (isGameOver)
		{
			if (ePlayer == player.Player1)
			{
				output = "Player 1 won!";
			}
			else output = "Player 2 won!";

			Font font = new Font(e.display, "Tahoma", 18, SWT.BOLD);
			gc.setFont(font);
			gc.setForeground(e.display.getSystemColor(SWT.COLOR_WHITE));
			gc.setBackground(e.display.getSystemColor(SWT.COLOR_BLUE));
			gc.drawString(output, 65, 135);
			button.setVisible(true);
		}
		gc.dispose();
	}

	private void DrawPlayerInputs(GC gc)
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (fields[i][j] == 1)
				{
					gc.drawOval(fieldCoordX[i][j], fieldCoordY[i][j], 100, 100);
				}
				else if (fields[i][j] == 2)
				{
					gc.drawLine(fieldCoordX[i][j], fieldCoordY[i][j], fieldCoordXEnd[i][j],
							fieldCoordYEnd[i][j]);
					gc.drawLine(fieldCoordX[i][j], fieldCoordYEnd[i][j], fieldCoordXEnd[i][j],
							fieldCoordY[i][j]);
				}
			}
		}
	}

	public void CheckPlayerInput(int posX, int posY)
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if ((posX >= fieldCoordX[i][j] && posY >= fieldCoordY[i][j])
						&& (posX < fieldCoordXEnd[i][j] && posY < fieldCoordYEnd[i][j]))
				{
					if (ePlayer == player.Player1)
					{
						if (fields[i][j] == 0)
						{
							fields[i][j] = 1;
						}
					}
					else if (ePlayer == player.Player2)
					{
						if (fields[i][j] == 0)
						{
							fields[i][j] = 2;
						}
					}
				}
			}
		}		
	}

	public void CheckFields()
	{
		int iPlayer = 1;

		if (ePlayer == player.Player1)
		{
			iPlayer = 1;
		}
		else if (ePlayer == player.Player2)
		{
			iPlayer = 2;
		}	
				// horizontalCheck
				for (int i = 0; i < 3; i++)
				{
					for (int j = 0; j < 1; j++)
					{
						if (fields[i][j] == iPlayer && fields[i][j + 1] == iPlayer && fields[i][j + 2] == iPlayer)
						{
							isGameOver = true;
							break;
						}
					}
				}
				// verticalCheck
				for (int i = 0; i < 1; i++)
				{
					for (int j = 0; j < 3; j++)
					{
						if (fields[i][j] == iPlayer && fields[i + 1][j] == iPlayer && fields[i + 2][j] == iPlayer)
						{
							isGameOver = true;
							break;
						}
					}
				}				
				// ascendingDiagonalCheck
				for (int i = 0; i < 1; i++)
				{
					for (int j = 0; j < 1; j++)
					{
						if (fields[i][j] == iPlayer && fields[i+1][j+1] == iPlayer && fields[i+2][j+2] == iPlayer)
						{
							isGameOver = true;
							break;
						}
					}
				}				
				// ascendingDiagonalCheck
				for (int i = 0; i < 1; i++)
				{
					for (int j = 0; j < 1; j++)
					{
						if (fields[i+2][j] == iPlayer && fields[i+1][j+1] == iPlayer && fields[i][j+2] == iPlayer)
						{
							isGameOver = true;
							break;
						}
					}
				}			
				
		if(!isGameOver)
		{
			ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
		}
	}

	private void SetFieldCoords()
	{
		int slotWidth = 100;
		int slotHeight = 100;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				fieldCoordX[i][j] = slotWidth * j;
				fieldCoordXEnd[i][j] = (slotWidth * j) + slotWidth;
				fieldCoordY[i][j] = slotHeight * i;
				fieldCoordYEnd[i][j] = (slotHeight * i) + slotHeight;
			}
		}
	}

	private void Reset()
	{
		System.out.println("Reset");
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
			fields[i][j] = 0;
			}
		}
		isGameOver = false;
		button.setVisible(false);
		ePlayer = player.Player1;
		shell.redraw();
	}

	public static void main(String[] args)
	{
		Display display = new Display();
		Game game = new Game(display);
		display.dispose();
	}
}
