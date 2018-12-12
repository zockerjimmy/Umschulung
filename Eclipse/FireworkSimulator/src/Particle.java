import ZJMath.ZJVector;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

public class Particle
{	
	public ZJVector position;
	public ZJVector acceleration;
	public ZJVector velocity;
	public ZJVector gravity;
	
	public int width;
	public int height;
	   
	
	public Particle(double x, double y)
	{
		this.width = 10;
		this.height = 10; 
		this.gravity = new ZJVector(0,0.05);
		this.position = new ZJVector(x,y);
		this.acceleration = new ZJVector(0,0);
		this.velocity = new ZJVector(0,(ThreadLocalRandom.current().nextDouble(5, 7 + 1)*-1));
	}

	public void Update()
	{
		this.velocity = this.velocity.AddZJVector(this.acceleration);
		this.position = this.position.AddZJVector(this.velocity);
		this.acceleration = this.acceleration.MultZJVector(0);
	
	}
	
	public void PDraw(Graphics g)
	{
		g.setColor(Color.white);
		g.fillOval((int)this.position.x, (int)this.position.y,this.width, this.height);
	}	
	
	public void ApplyForce(ZJVector force)
	{
		this.acceleration = this.acceleration.AddZJVector(force);

	}
}
