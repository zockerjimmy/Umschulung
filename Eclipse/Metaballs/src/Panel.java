import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.geom.Point2D;
import javax.swing.JPanel;
import javax.swing.Timer;

import ZJMath.ZJVector;

public class Panel extends JPanel
{
	public final static int width = 640;
	public final static int height = 360;
//	public final static int width = 800;
//	public final static int height = 500;
	
	public int index;
	public BufferedImage img;
	public Timer timer;
	public ActionListener timerListener;
	int r,g,b, rgb;
	int distance;
	float temp;
	int colSum;
	Blob blobs[] = new Blob[5];
	ZJVector pixels[];
	public Panel()
	{
		this.img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(width, height));
		this.setFocusable(true);
		this.pixels = new ZJVector[width*height];
		for(int i = 0; i < this.blobs.length; i++)
		{
			this.blobs[i] = new Blob(ThreadLocalRandom.current().nextInt(0, width), ThreadLocalRandom.current().nextInt(0, height));
		}
		Start();
	}

	public void AddTimeListener()
	{
		this.timerListener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				SetPixels();
				Repaint();
				for(int i = 0; i < blobs.length; i++)
				{
					blobs[i].Update();
				}
			}
		};
	}

	public void Repaint()
	{
		this.repaint();
	}
	
	public void Start()
	{
		AddTimeListener();
		timer = new Timer(10, timerListener);
		timer.setInitialDelay(0);
		timer.start();
	}
	
	public void SetPixels()
	{
		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{				
			/*	this.distance = (int)Point2D.distance((double)x, (double)y, (double)width*0.5, (double)height*0.5);
				this.distance = distance <= 255 ? distance : 255;
				this.rgb = (this.distance << 16) | (this.distance << 8) | this.distance;*/
				
				//f(x,y) = r
				//	  	  ________________
				//		  dist(blob(x,y))
				this.colSum = 0;
				for(Blob bb : blobs)
				{
					
				this.distance = (int)Point2D.distance((double)x, (double)y, (bb.pos.x + bb.r), (bb.pos.y + bb.r));				
				this.distance = distance < 1 ? 1 : distance;					
				this.colSum += 150 * bb.r / this.distance;
				this.colSum = this.colSum <= 360 ? this.colSum : 360;
				
				}
				temp = (float)this.colSum/360.0f;
				this.rgb = Color.HSBtoRGB(temp, 1, 1);		
				this.img.setRGB(x, y, this.rgb);
			
			}
		}		
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this);
		/*g.setColor(Color.BLACK);
		for(Blob b : blobs)
		{
			g.drawOval((int)b.pos.x, (int)b.pos.y, b.r*2, b.r*2);
		}		*/	
	}
}
