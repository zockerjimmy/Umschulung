import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import ZJMath.ZJVector;

public class Firework
{
	public Particle _firework;	
	
	public Firework()
	{
		_firework = new Particle(ThreadLocalRandom.current().nextDouble(0, 1000 + 1),590.0);
	}
	 
	public void Update()
	{ 
		_firework.ApplyForce(_firework.gravity);
		_firework.Update();
	}
	
	public void Draw(Graphics g)
	{
		_firework.PDraw(g);
	}	
}
 