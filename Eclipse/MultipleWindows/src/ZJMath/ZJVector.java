package ZJMath;
import java.util.concurrent.ThreadLocalRandom;

public class ZJVector
{ 
	public double x;
	public double y;

	public ZJVector(double value1, double value2)
	{
		x = value1;
		y = value2;
	}

	/*public ZJVector(int value1, int value2)
	{ 
		x = value1;
		y = value2;
	}*/
	
	public ZJVector AddZJVector(ZJVector v)
	{
		ZJVector temp = new ZJVector(this.x + v.x, this.y + v.y);	
		return temp;
	}
	
	public ZJVector AddZJVector(double v)
	{
		ZJVector temp = new ZJVector(this.x + v, this.y + v);	
		return temp;
	}
	
	public ZJVector MultZJVector(ZJVector v)
	{
		ZJVector temp = new ZJVector(this.x * v.x, this.y * v.y);	
		return temp;
	}
	
	public ZJVector MultZJVector(double v)
	{
		ZJVector temp = new ZJVector(this.x * v, this.y * v);	
		return temp;
	}
	
	
	public ZJVector Random2D()
	{
		ZJVector temp = new ZJVector(0,0);
		temp.x += ThreadLocalRandom.current().nextDouble(-1, 0 + 1);
		temp.y += ThreadLocalRandom.current().nextDouble(-1, 0 + 1);
		return temp;
	}
}
