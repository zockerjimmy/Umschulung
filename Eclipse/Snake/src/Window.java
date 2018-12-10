import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings({ "serial", "unused" })
public class Window extends JFrame
{

	public static void main(String[] args)
	{
			Window window = new Window();
			window.setVisible(true);
	}
	
	public Window()
	{
		Container content = this.getContentPane();
		Snake snake = new Snake();
		content.add(snake);
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}

}
