package Connect4Package;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import ZJMath.ZJVector;

public class Connect4Panel extends JPanel
{
	final static int MAX_WIDTH = 400;
	final static int MAX_HEIGHT = 400;
	
	public int slotWidth;
	public int slotHeight;
	public ZJVector[][] slots = new ZJVector[6][7];
	public int[][] slotsState = new int[6][7];
	
	public MouseListener mouseListener;
	
	public Connect4Panel()
	{
		this.slotWidth = (MAX_WIDTH / 9);
		this.slotHeight = (MAX_HEIGHT / 9);
		
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				this.slotsState[i][j] = 0;			
			}
		}
		
		this.setFocusable(true);
		this.setPreferredSize(new Dimension(MAX_WIDTH, MAX_HEIGHT));
		this.setBackground(Color.BLUE);
		
		mouseListener = new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				CheckSlots(e.getPoint());
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		};			
		this.addMouseListener(mouseListener); 		

		DrawPlayfield();
	}
	
	public void DrawPlayfield()
	{
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				this.slots[i][j] = new ZJVector(30+(j*(this.slotWidth+5)), 70+(i*(this.slotWidth+10)));				
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				g.fillOval((int)this.slots[i][j].x, (int)this.slots[i][j].y, this.slotWidth, this.slotHeight);
			}
		}
		
		
	}
		
	public boolean CheckSlots(Point v)
	{
		boolean columFree = true;
		int colum = 0;
		
		for(int i = 0; i < 1; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				
				if((v.x >= this.slots[i][j].x && v.x < (this.slots[i][j].x+slotWidth)))
				{
					colum = j;
				}
			}
		}
		
		for(int i = 5; i >= 0; i--)
		{
			for(int j = 0; j < 1; j++)
			{
				if(this.slotsState[i][j] != 0)
				{
					columFree = false;
				}
				else columFree = true;				
			}
		}
		
		if(columFree)
		{
			
		}
	
		return false;
	}
}
