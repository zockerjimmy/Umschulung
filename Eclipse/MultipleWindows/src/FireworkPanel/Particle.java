package FireworkPanel;
import ZJMath.ZJVector;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.concurrent.ThreadLocalRandom;

public class Particle
{
	private Ellipse2D.Double spark;
	private Ellipse2D.Double sparks;
	public ZJVector position;
	public ZJVector acceleration;
	public ZJVector velocity;
	public ZJVector gravity;

	public int width;
	public int height;
	public int alpha;
	public int rColor;
	public int bColor;
	public int gColor;
	
	public boolean isexploded;

	public Color white;

	public Particle(double x, double y, int rcolor,int bColor,int gColor, boolean exploded)
	{
		this.isexploded = exploded;
		if (!isexploded)
		{
			this.width = 10;
			this.height = 10;
		} else
		{
			this.width = 5;
			this.height = 5;
		}
		this.rColor = rcolor;
		this.bColor = bColor;
		this.gColor = gColor;
		this.alpha = 255;
		this.gravity = new ZJVector(0, 0.05);
		this.position = new ZJVector(x, y);
		this.spark = new Ellipse2D.Double(x, y, 11, 11);
		this.acceleration = new ZJVector(0, 0);
		if (!isexploded)
		{
			this.velocity = new ZJVector(0, (ThreadLocalRandom.current().nextDouble(5, 7 + 1) * -1));
		} else
		{
			this.velocity = new ZJVector(0, 0);
			this.velocity = this.velocity.Random2D();
			this.velocity = this.velocity.MultZJVector(ThreadLocalRandom.current().nextDouble(2, 10));
		}
	}

	public void Update()
	{
		if (isexploded)
		{
			this.velocity = this.velocity.MultZJVector(0.94);
		}
		this.velocity = this.velocity.AddZJVector(this.acceleration);
		this.position = this.position.AddZJVector(this.velocity);
		this.spark.x = this.position.x + this.velocity.x;
		this.spark.y = this.position.y + this.velocity.y;
		this.acceleration = this.acceleration.MultZJVector(0);

	}

	public void PDraw(Graphics g)
	{
		g.setColor(new Color(this.rColor, this.bColor, this.gColor, alpha));
		g.fillOval((int) this.position.x, (int) this.position.y, this.width, this.height);

	}

	public boolean Done()
	{
		if (alpha <= 0)
		{
			return true;
		} else
			return false;
	}

	public void ApplyForce(ZJVector force)
	{
		this.acceleration = this.acceleration.AddZJVector(force);

	}
}
