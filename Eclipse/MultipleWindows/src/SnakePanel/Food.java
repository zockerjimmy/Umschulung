package SnakePanel;
import ZJMath.ZJVector;
import ZJMath.ZJMathf;
public class Food
{
	public ZJVector foodPos;
	
	public int foodWidth;
	public int foodHeight;
	
	public Food()
	{
		this.foodWidth = 10;
		this.foodHeight = 10;
		this.foodPos = new ZJVector(Math.random() * (Panel.WINDOW_WIDTH-foodWidth), Math.random() * (Panel.WINDOW_HEIGHT-foodHeight));
		this.foodPos.x = ZJMathf.RoundToDeci(this.foodPos.x);
		this.foodPos.y = ZJMathf.RoundToDeci(this.foodPos.y);
	}	
	public void NewFood()
	{
		foodPos.x = Math.random() * (Panel.WINDOW_WIDTH-foodWidth);
		foodPos.y = Math.random() * (Panel.WINDOW_HEIGHT-foodHeight);
		foodPos.x = ZJMathf.RoundToDeci(foodPos.x);
		foodPos.y = ZJMathf.RoundToDeci(foodPos.y);
	}
	
}
