import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.events.*;

public class Game extends MouseAdapter
{
	private Shell shell;

	public static int[] field = new int[9];
	public int[] fieldCoords = new int[36];

	enum player
	{
		Player1, Player2
	};

	public static player ePlayer = player.Player1;
	private int actualField;
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
		// Color c1 = new Color(e.display, 0,0,0);
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
				gc.drawOval(fieldCoords[coordElement], fieldCoords[coordElement + 2], 100, 100);
			}
			else if (field[i] == 2)
			{
				gc.drawLine(fieldCoords[coordElement], fieldCoords[coordElement + 2], fieldCoords[coordElement + 1],
						fieldCoords[coordElement + 3]);
				gc.drawLine(fieldCoords[coordElement], fieldCoords[coordElement + 3], fieldCoords[coordElement + 1],
						fieldCoords[coordElement + 2]);
			}
		}
	}

	public void CheckPlayerInput(int posX, int posY)
	{
		if (posX >= 0 && posX < 100 && posY >= 0 && posY < 100)
		{
			if (ePlayer == player.Player1)
			{
				if (field[0] == 0)
				{
					field[0] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (field[0] == 0)
				{
					field[0] = 2;
				}
			}
			actualField = 0;
		}
		else if (posX >= 100 && posX < 200 && posY >= 0 && posY < 100)
		{
			if (ePlayer == player.Player1)
			{
				if (field[1] == 0)
				{
					field[1] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (field[1] == 0)
				{
					field[1] = 2;
				}
			}
			actualField = 1;
		}
		else if (posX >= 200 && posX <= 300 && posY >= 0 && posY < 100)
		{
			if (ePlayer == player.Player1)
			{
				if (field[2] == 0)
				{
					field[2] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (field[2] == 0)
				{
					field[2] = 2;
				}
			}
			actualField = 2;
		}
		else if (posX >= 0 && posX < 100 && posY >= 100 && posY < 200)
		{
			if (ePlayer == player.Player1)
			{
				if (field[3] == 0)
				{
					field[3] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (field[3] == 0)
				{
					field[3] = 2;
				}
			}
			actualField = 3;
		}
		else if (posX >= 100 && posX < 200 && posY >= 100 && posY < 200)
		{
			if (ePlayer == player.Player1)
			{
				if (field[4] == 0)
				{
					field[4] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (field[4] == 0)
				{
					field[4] = 2;
				}
			}
			actualField = 4;
		}
		else if (posX >= 200 && posX <= 300 && posY >= 100 && posY < 200)
		{
			if (ePlayer == player.Player1)
			{
				if (field[5] == 0)
				{
					field[5] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (field[5] == 0)
				{
					field[5] = 2;
				}
			}
			actualField = 5;
		}
		else if (posX >= 0 && posX < 100 && posY >= 200 && posY <= 300)
		{
			if (ePlayer == player.Player1)
			{
				if (field[6] == 0)
				{
					field[6] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (field[6] == 0)
				{
					field[6] = 2;
				}
			}
			actualField = 6;
		}
		else if (posX >= 100 && posX < 200 && posY >= 200 && posY <= 300)
		{
			if (ePlayer == player.Player1)
			{
				if (field[7] == 0)
				{
					field[7] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (field[7] == 0)
				{
					field[7] = 2;
				}
			}
			actualField = 7;
		}
		else if (posX >= 200 && posX <= 300 && posY >= 200 && posY <= 300)
		{
			if (ePlayer == player.Player1)
			{
				if (field[8] == 0)
				{
					field[8] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (field[8] == 0)
				{
					field[8] = 2;
				}
			}
			actualField = 8;
		}
		else
		{
			System.out.println("ERROR!");
		}
	}

	public void CheckFields()
	{
		switch (actualField)
		{
		case 0:
		{
			if (ePlayer == player.Player1)
			{
				if (field[0] == 1 && field[1] == 1 && field[2] == 1 || field[0] == 1 && field[4] == 1 && field[8] == 1
						|| field[0] == 1 && field[3] == 1 && field[6] == 1)
				{
					isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (field[0] == 2 && field[1] == 2 && field[2] == 2 || field[0] == 2 && field[4] == 2 && field[8] == 2
						|| field[0] == 2 && field[3] == 2 && field[6] == 2)
				{
					isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		case 1:
		{
			if (ePlayer == player.Player1)
			{
				if (field[0] == 1 && field[1] == 1 && field[2] == 1 || field[1] == 1 && field[4] == 1 && field[7] == 1)
				{
					isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (field[0] == 2 && field[1] == 2 && field[2] == 2 || field[0] == 2 && field[4] == 2 && field[8] == 2)
				{
					isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		case 2:
		{
			if (ePlayer == player.Player1)
			{
				if (field[0] == 1 && field[1] == 1 && field[2] == 1 || field[2] == 1 && field[5] == 1 && field[8] == 1
						|| field[2] == 1 && field[4] == 1 && field[6] == 1)
				{
					isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (field[0] == 2 && field[1] == 2 && field[2] == 2 || field[2] == 2 && field[5] == 2 && field[8] == 2
						|| field[2] == 2 && field[4] == 2 && field[6] == 2)
				{
					isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		case 3:
		{
			if (ePlayer == player.Player1)
			{
				if (field[3] == 1 && field[4] == 1 && field[5] == 1 || field[0] == 1 && field[3] == 1 && field[6] == 1)
				{
					isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (field[3] == 2 && field[4] == 2 && field[5] == 2 || field[0] == 2 && field[3] == 2 && field[6] == 2)
				{
					isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		case 4:
		{
			if (ePlayer == player.Player1)
			{
				if (field[3] == 1 && field[4] == 1 && field[5] == 1 || field[1] == 1 && field[4] == 1 && field[7] == 1
						|| field[0] == 1 && field[4] == 1 && field[8] == 1
						|| field[2] == 1 && field[4] == 1 && field[6] == 1)
				{
					isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (field[3] == 2 && field[4] == 2 && field[5] == 2 || field[1] == 2 && field[4] == 2 && field[7] == 2
						|| field[0] == 2 && field[4] == 2 && field[8] == 2
						|| field[2] == 2 && field[4] == 2 && field[6] == 2)
				{
					isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		case 5:
		{
			if (ePlayer == player.Player1)
			{
				if (field[2] == 1 && field[5] == 1 && field[8] == 1 || field[3] == 1 && field[4] == 1 && field[5] == 1)
				{
					isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (field[2] == 2 && field[5] == 2 && field[8] == 2 || field[3] == 2 && field[4] == 2 && field[5] == 2)
				{
					isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		case 6:
		{
			if (ePlayer == player.Player1)
			{
				if (field[0] == 1 && field[3] == 1 && field[6] == 1 || field[6] == 1 && field[7] == 1 && field[8] == 1
						|| field[6] == 1 && field[4] == 1 && field[2] == 1)
				{
					isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (field[0] == 2 && field[3] == 2 && field[6] == 2 || field[6] == 2 && field[7] == 2 && field[8] == 2
						|| field[6] == 2 && field[4] == 2 && field[2] == 2)
				{
					isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		case 7:
		{
			if (ePlayer == player.Player1)
			{
				if (field[6] == 1 && field[7] == 1 && field[8] == 1 || field[7] == 1 && field[4] == 1 && field[1] == 1)
				{
					isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (field[6] == 2 && field[7] == 2 && field[8] == 2 || field[7] == 2 && field[4] == 2 && field[1] == 2)
				{
					isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		case 8:
		{
			if (ePlayer == player.Player1)
			{
				if (field[8] == 1 && field[5] == 1 && field[2] == 1 || field[6] == 1 && field[7] == 1 && field[8] == 1
						|| field[8] == 1 && field[4] == 1 && field[0] == 1)
				{
					isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (field[8] == 2 && field[5] == 2 && field[2] == 2 || field[6] == 2 && field[7] == 2 && field[8] == 2
						|| field[8] == 2 && field[4] == 2 && field[0] == 2)
				{
					isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		}
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

	private void Reset()
	{
		System.out.println("Reset");
		for (int i = 0; i < field.length; i++)
		{
			field[i] = 0;
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
