package SnakePanel;
import java.util.ArrayList;
import ZJMath.ZJVector;

public class Snake
{
	public ArrayList<ZJVector> snakePos;
	public ArrayList<ZJVector> snakePosBuffer;
	public ZJVector snakePosTemp;
	public ZJVector snakePosTemp2;
	public int snakeSizeBuffer;
	public int snakeWidth;
	public int snakeHeight;
	public int lastX;
	public int lastY;
	public boolean isChangingDirectionHorizontal;
	public boolean isChangingDirectionVertical;
	public boolean canAddTail;
	public boolean needNewFood;

	public enum direction
	{
		DOWN, TOP, LEFT, RIGHT
	};
	public direction eDirection;

	public Snake()
	{
		this.snakeSizeBuffer = 0;
		this.snakePosBuffer = new ArrayList<ZJVector>();
		this.snakePos = new ArrayList<ZJVector>();
		this.snakePosTemp = new ZJVector(0,0);
		this.snakePosTemp2 = new ZJVector(0,0);
		this.snakePos.add(new ZJVector(Panel.WINDOW_WIDTH / 2, Panel.WINDOW_HEIGHT / 2));
		for (int i = 0; i < 1; i++)
		{
			this.snakePos.add(new ZJVector(150, 150 + (i * 10)));
		}
		this.lastX = (int) this.snakePos.get(0).x;
		this.lastY = (int) this.snakePos.get(0).y;
		this.snakeWidth = 10;
		this.snakeHeight = 10;
		this.eDirection = direction.TOP;
		this.isChangingDirectionHorizontal = false;
		this.isChangingDirectionVertical = false;
		this.canAddTail = false;
		this.needNewFood = false;
	}
	public direction getDirection()
	{
		return eDirection;
	}
	public void setDirection(direction d)
	{
		this.eDirection = d;
	}
	public void Update(double foodPosX, double foodPosY)
	{
		Move();
		if (this.canAddTail)
		{
			this.snakePos.add(new ZJVector(this.snakePosBuffer.get(0).x, this.snakePosBuffer.get(0).y));
			this.snakePosBuffer.remove(0);
			this.snakeSizeBuffer--;
			this.canAddTail = false;
		}
		if (CheckFoodCollision(foodPosX, foodPosY))
		{
			EatFood(foodPosX, foodPosY);
		}
		if (CheckTailCollision(this.snakePos.get(0).x, this.snakePos.get(0).y))
		{
			Panel.ISGAMEOVER = true;
		}
		if (this.snakeSizeBuffer > 0)
		{
			CheckFoodBufferAndCollision();
		}
	}
	public void Move()
	{			
			this.snakePosTemp.x = 0;
			this.snakePosTemp.y = 0;
			
			//move head
			if (eDirection == direction.TOP)
			{	
				this.snakePosTemp.x = this.snakePos.get(0).x;
				this.snakePosTemp.y = this.snakePos.get(0).y;
				this.snakePos.get(0).y -= 10;			
			}
			else if (eDirection == direction.DOWN)
			{
				this.snakePosTemp.x = this.snakePos.get(0).x;
				this.snakePosTemp.y = this.snakePos.get(0).y;
				this.snakePos.get(0).y += 10;
			}
			else if (eDirection == direction.LEFT)
			{
				this.snakePosTemp.x = this.snakePos.get(0).x;
				this.snakePosTemp.y = this.snakePos.get(0).y;
				this.snakePos.get(0).x -= 10;
			}
			else if (eDirection == direction.RIGHT)
			{
				this.snakePosTemp.x = this.snakePos.get(0).x;
				this.snakePosTemp.y = this.snakePos.get(0).y;
				this.snakePos.get(0).x += 10;
			}			
			//move tail
			for (int i = 1; i < this.snakePos.size(); i++)
			{
				this.snakePosTemp2.x = this.snakePos.get(i).x;
				this.snakePosTemp2.y = this.snakePos.get(i).y;
				
				this.snakePos.get(i).x = this.snakePosTemp.x;				
				this.snakePos.get(i).y = this.snakePosTemp.y;
				
				this.snakePosTemp.x = this.snakePosTemp2.x;
				this.snakePosTemp.y = this.snakePosTemp2.y;
			}	
		if (this.isChangingDirectionHorizontal)
		{
			if (this.lastY != (int) this.snakePos.get(0).x)
			{
				this.isChangingDirectionHorizontal = false;
			}
		}
		if (isChangingDirectionVertical)
		{
			if (this.lastX != (int) this.snakePos.get(0).y)
			{
				this.isChangingDirectionVertical = false;
			}
		}
	}
	public boolean CheckFoodCollision(double foodPosX, double foodPosY)
	{
		if (this.snakePos.get(0).x == foodPosX && this.snakePos.get(0).y == foodPosY)
		{
			return true;
		}
		return false;
	}
	public boolean CheckTailCollision(double HeadPosX, double HeadPosY)
	{
		for (int i = 1; i < this.snakePos.size(); i++)
		{
			if (HeadPosX == (int)this.snakePos.get(i).x && HeadPosY ==  (int)this.snakePos.get(i).y)
			{
				return true;
			} 
		}
		return false;
	}
	public void EatFood(double foodPosX, double foodPosY)
	{
		this.snakePosBuffer.add(new ZJVector(foodPosX, foodPosY));
		this.snakeSizeBuffer++;
		this.needNewFood = true;
	}
	public void CheckFoodBufferAndCollision()
	{
		for (int i = 0; i < this.snakePosBuffer.size(); i++)
		{
			if (this.snakePos.get(this.snakePos.size() - 1).x == this.snakePosBuffer.get(i).x
					&& this.snakePos.get(this.snakePos.size() - 1).y == this.snakePosBuffer.get(i).y)
			{
				this.canAddTail = true;
				break;
			}
		}
	}

}
