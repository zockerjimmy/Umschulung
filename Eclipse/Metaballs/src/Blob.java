import java.util.concurrent.ThreadLocalRandom;

import ZJMath.ZJVector;

public class Blob
{
	
	public ZJVector pos;
	public int r;
	public ZJVector vel;
	
	public Blob(int x, int y)
	{
		this.pos = new ZJVector(x,y);
		this.r = ThreadLocalRandom.current().nextInt(30, 60);
		this.vel = new ZJVector(ThreadLocalRandom.current().nextDouble(0.4, 1), ThreadLocalRandom.current().nextDouble(0.4, 1));
		this.vel.x *= 4;
		this.vel.y *= 4;
	}
	
	public void Update()
	{
		this.pos.x += this.vel.x;
		this.pos.y += this.vel.y;
		
		if(this.pos.x > Panel.width || this.pos.x < 0)
		{
			this.vel.x *= -1;
		}
		if(this.pos.y > Panel.height || this.pos.y < 0)
		{
			this.vel.y *= -1;
		}
	}
}
