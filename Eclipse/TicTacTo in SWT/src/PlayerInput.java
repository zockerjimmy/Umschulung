import org.eclipse.swt.events.*;

public class PlayerInput extends MouseAdapter 
{
	
	@Override
	public void mouseDown(MouseEvent event)
	{
		if(event.button == 1)
		{
			System.out.println("sdf");
		}
	}
}
