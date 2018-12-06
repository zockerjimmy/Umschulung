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
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
			Game.fields[i][j] = 0;
			}
		}		
		PlayerInput.ePlayer = PlayerInput.player.Player1;
		Game.isGameOver = false;
		button.setVisible(false);
		repaint();
	}

	private void DrawPlayerInputs(Graphics g)
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (Game.fields[i][j] == 1)
				{
					DrawCircle(g, Game.fieldCoordX[i][j], Game.fieldCoordY[i][j]);
				}
				else if (Game.fields[i][j] == 2)
				{
					DrawCross(g, Game.fieldCoordX[i][j], Game.fieldCoordY[i][j], Game.fieldCoordXEnd[i][j],
							Game.fieldCoordYEnd[i][j]);
				}
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
		
		int slotWidth = 100;
		int slotHeight = 100;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				Game.fieldCoordX[i][j] = slotWidth * j;
				Game.fieldCoordXEnd[i][j] = (slotWidth * j) + slotWidth;
				Game.fieldCoordY[i][j] = slotHeight * i;
				Game.fieldCoordYEnd[i][j] = (slotHeight * i) + slotHeight;
			}
		}
	}
}
