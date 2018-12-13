import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Firework
{
	public Particle _firework;
	public ArrayList<Particle> _explosion = new ArrayList<Particle>();

	public boolean isExploded;
	public int rColor;
	public int bColor;
	public int gColor;

	public Firework()
	{
		this.rColor = ThreadLocalRandom.current().nextInt(0,255);
		this.bColor = ThreadLocalRandom.current().nextInt(0,255);
		this.gColor = ThreadLocalRandom.current().nextInt(0,255);
		this._firework = new Particle(ThreadLocalRandom.current().nextDouble(0, 1000 + 1), 590.0, rColor,bColor,gColor, false);
		this.isExploded = false;
	}

	public void Update()
	{
		if (!this.isExploded)
		{
			this._firework.ApplyForce(this._firework.gravity);
			this._firework.Update();

			if (this._firework.velocity.y >= 0)
			{
				this.Explode();
			}
		} else
		{
			for (int i = this._explosion.size() - 1; i >= 0; i--)
			{
				this._explosion.get(i).ApplyForce(this._firework.gravity);
				this._explosion.get(i).Update();

				if (this._explosion.get(i).Done())
				{
					this._explosion.remove(i);
				}
			}
		}
	}

	public boolean Done()
	{
		if (this.isExploded && this._explosion.size() == 0)
		{
			return true;
		} else
		{
			return false;
		}
	}

	public void Explode()
	{
		this.isExploded = true;
		for (int i = 0; i < 100; i++)
		{
			_explosion.add(new Particle(this._firework.position.x, this._firework.position.y,rColor,bColor,gColor, true));
		}
	}

	public void Draw(Graphics g)
	{
		if (!this.isExploded)
		{
			this._firework.PDraw(g);
		} else
		{
			for (int i = this._explosion.size() - 1; i >= 0; i--)
			{
				if (this._explosion.get(i).alpha > 0.5)
				{
					this._explosion.get(i).alpha -= 1.5;
				} else
					this._explosion.get(i).alpha = 0;

				this._explosion.get(i).PDraw(g);
			}
		}
	}
}
