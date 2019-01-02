import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Panel extends JPanel
{
	public final static int width = 640;
	public final static int height = 360;
//	public final static int width = 800;
//	public final static int height = 500;
	int r,g,b, rgb;
	float HSV[]= new float[3];
	public Panel()
	{
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(width, height));
		this.setFocusable(true);
		Start();
	}
	
	public void Start()
	{

	}

	@Override
	public void paintComponent(Graphics gg)
	{
		super.paintComponent(gg);
		
		this.rgb = Color.HSBtoRGB(0.3f, 1, 1);
		
		float temp = 2/8;
		System.out.println(temp);
	
		
		
		gg.setColor(new Color(this.rgb));
		gg.drawString("FSDJFHSKDJFHKSDFHKHF", 100, 100);
	}
}
