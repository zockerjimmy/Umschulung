import ZJMath.ZJVector;

public class Food
{
	public ZJVector foodPos;
	
	public int foodWidth;
	public int foodHeight;
	
	public Food()
	{
		this.foodPos = new ZJVector(Math.random() * 350, Math.random() * 350);
		this.foodWidth = 10;
		this.foodHeight = 10;
	}
}
