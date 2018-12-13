import java.util.ArrayList;

import ZJMath.ZJVector;

public class Snake
{
	 public ArrayList<ZJVector> snakePos;
	 public int snakeSize;
	 public int snakeWidth;
	 public int snakeHeight;
	 
	 public enum direction {DOWN, TOP, LEFT, RIGHT};
	 public direction eDirection;
	 
	 public Snake()
	 {
		 this.snakeSize = 1;
		 this.snakePos = new ArrayList<ZJVector>();
		 this.snakePos.add(new ZJVector(150,150));
		 for(int i = 0; i < snakeSize; i++) 
		 {			 
			 this.snakePos.add(new ZJVector(150,150+(i*10)));
		 }
		 this.snakeWidth = 10;
		 this.snakeHeight = 10;
		 this.eDirection = direction.TOP;
	 }
	 
	 public direction getDirection()
	 {		 
		 return eDirection;
	 }
	 
	 public void setDirection(direction d)
	 {
		 this.eDirection = d;
	 }
	 
	 public void Update()
	 {
		 if(eDirection == direction.TOP)
		 {
			 for(int i = 0; i < snakeSize; i++) 
			 {			 
				 this.snakePos.get(i).y -= 10;
			 } 
		 }
		 else if(eDirection == direction.DOWN)
		 {
			 for(int i = 0; i < snakeSize; i++) 
			 {			 
				 this.snakePos.get(i).y += 10;
			 } 
		 }
		 else if(eDirection == direction.LEFT)
		 {
			 for(int i = 0; i < snakeSize; i++) 
			 {			 
				 this.snakePos.get(i).x -= 10;
			 } 
		 }
		 else if(eDirection == direction.RIGHT)
		 {
			 for(int i = 0; i < snakeSize; i++) 
			 {			 
				 this.snakePos.get(i).x += 10;
			 } 
		 }
	 }
}
