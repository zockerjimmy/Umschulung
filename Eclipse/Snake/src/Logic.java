import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Logic
{
	protected int snake;
	protected int snakeSizeX;
	protected int snakeSizeY;

	protected ArrayList<Integer> snakePosX = new ArrayList<>();
	protected ArrayList<Integer> snakePosY = new ArrayList<>();

	protected int foodPosX;
	protected int foodPosY;
	protected int foodSizeX;
	protected int foodSizeY;

	protected boolean isGameOver;

	protected enum direction
	{
		RIGHT, LEFT, UP, DOWN
	};

	protected direction eDirection = direction.DOWN;

	public Logic()
	{
		snake = 2;
		foodPosX = 150;
		foodPosY = 150;
		foodSizeX = 10;
		foodSizeY = 10;
		snakePosX.add(50);
		snakePosX.add(50);
		snakePosY.add(50);
		snakePosY.add(50);
		snakeSizeX = 10;
		snakeSizeY = 10;
		isGameOver = false;
	}

//	public void ResetGame()
//	{
//		snakePosX.clear();
//		snakePosY.clear();
//
//		snake = 1;
//		foodPosX = 150;
//		foodPosY = 150;
//		foodSizeX = 10;
//		foodSizeY = 10;
//		snakePosX.add(50);
//		snakePosX.add(50);
//		snakePosY.add(50);
//		snakePosY.add(50);
//		snakeSizeX = 10;
//		snakeSizeY = 10;
//		isGameOver = false;
//	}

	public void MoveSnake()
	{
		for (int i = 0; i < snake; i++)
		{
			if (eDirection == direction.DOWN)
			{
				snakePosY.set(i, snakePosY.get(i) + snakeSizeY);
			} else if (eDirection == direction.UP)
			{
				snakePosY.set(i, snakePosY.get(i) - snakeSizeY);
			} else if (eDirection == direction.RIGHT)
			{
				snakePosX.set(i, snakePosX.get(i) + snakeSizeX);
			} else if (eDirection == direction.LEFT)
			{
				snakePosX.set(i, snakePosX.get(i) - snakeSizeX);
			}
		}
	}
	
}
