import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Particle
{
	public Point particlePos;
	public double vel, acc, gravity;
	public int rad;
		
	public Particle(int x, int r, double acc, double grav)
	{
		if(x == 0)
		{			
			this.particlePos = new Point((int)(Math.random()*Panel.rCanvas.width), Panel.rCanvas.height);
		}
		else this.particlePos.x = x;
		this.rad = r;
		this.acc = acc;
		this.vel = 0;
		this.gravity = grav;
	}

	public void Update()
	{
		this.vel += this.acc;
		this.particlePos.y -= this.vel;
		this.vel += this.gravity;
		this.acc = 0;
	}
	
	public void Show(Graphics g)
	{
		g.setColor(new Color(0,0,255));
		g.fillOval(this.particlePos.x, this.particlePos.y, this.rad*2, this.rad*2);
	}
}
