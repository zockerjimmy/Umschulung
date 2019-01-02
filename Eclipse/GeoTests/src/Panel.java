import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel
{
	
	public Panel()
	{
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(1500, 1000));
		this.setFocusable(true);
	
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		
	}
}
