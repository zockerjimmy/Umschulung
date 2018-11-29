import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.FontMetrics;

//Inhalt des Hauptfensters
@SuppressWarnings("serial")
public class GamePanel extends JPanel
{
	private final int P_WIDTH = 300;
	private final int P_HEIGHT = 300;

	public static int[] field = new int[9];
	public int[] fieldCoords = new int[36];

	private static Font monoFont = new Font("Monospaced", Font.BOLD, 26);

	private JButton button = new JButton("Restart");

	public GamePanel()
	{
		InitScene();
	}

	private void InitScene()
	{
		setLayout(null);		
		add(button);		
		//button.setLocation(250,250);
		button.setBounds(105, 200, 90, 30);
		button.setVisible(false);
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(P_WIDTH, P_HEIGHT));
		SetFieldCoords();
	}

	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		super.paintComponent(g);
		DrawField(g);
		DrawPlayerInputs(g);
		
		if (Game.isGameOver)
		{
			if (PlayerInput.ePlayer == PlayerInput.player.Player1)
			{
				g.setFont(monoFont);
				FontMetrics fm = g.getFontMetrics();
				int w = fm.stringWidth("Player 1 won!");
				int h = fm.getAscent();
				g.setColor(Color.BLUE);
				g.fillRect(140 - (w / 2), 140, w + 20, h + 10);
				g.setColor(Color.BLACK);
				g.drawString("Player 1 won!", 150 - (w / 2), 150 + (h / 2));
			}
			else if (PlayerInput.ePlayer == PlayerInput.player.Player2)
			{
				g.setFont(monoFont);
				FontMetrics fm = g.getFontMetrics();
				int w = fm.stringWidth("Player 2 won!");
				int h = fm.getAscent();
				g.setColor(Color.BLUE);
				g.fillRect(140 - (w / 2), 140, w + 20, h + 10);
				g.setColor(Color.BLACK);
				g.drawString("Player 2 won!", 150 - (w / 2), 150 + (h / 2));
			}
			button.setVisible(true);
			button.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					ResetGame();
				}
			});
		}
	}
	
	private void ResetGame()
	{
		for(int i = 0; i < field.length; i++)
		{
			field[i] = 0;
		}
		
		PlayerInput.ePlayer = PlayerInput.player.Player1;
		Game.isGameOver = false;
		button.setVisible(false);
		repaint();
	}

	private void DrawPlayerInputs(Graphics g)
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
				DrawCircle(g, fieldCoords[coordElement], fieldCoords[coordElement + 2]);
			}
			else if (field[i] == 2)
			{
				DrawCross(g, fieldCoords[coordElement], fieldCoords[coordElement + 2], fieldCoords[coordElement + 1],
						fieldCoords[coordElement + 3]);
			}
			else
			{
				// System.out.println(pInput.field[i]);
			}
		}

	}

	private void DrawField(Graphics g)
	{
		// drawLine(int x1, int y1, int x2, int y2)
		// is used to draw a straight line from point (x1,y1) to (x2,y2).

		// Vertikal
		g.drawLine(100, 0, 100, 300); // x:100 y:0 - x:100 y:300
		g.drawLine(200, 0, 200, 300); // x:200 y:0 - x:200 y:300
		// Horizontal
		g.drawLine(0, 100, 300, 100); // x:0 y:100 - x:300 y:100
		g.drawLine(0, 200, 300, 200); // x:0 y:200 - x:300 y:200
	}

	public void DrawCircle(Graphics g, int x, int y)
	{
		g.fillOval(x, y, 100, 100);
	}

	public void DrawCross(Graphics g, int x1, int y1, int x2, int y2)
	{
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x2, y1, x1, y2);
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
}
