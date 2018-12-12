import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JFrame;
 
@SuppressWarnings({ "unused", "serial" })
public class Window extends JFrame
{
		
	private Window()
	{
		Panel panel = new Panel();
		this.add(panel); //Fenster einen Inhalt geben
		this.setTitle("Firework Simulator"); //Fenstertitel
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //"X"-Schaltfl�che schlie�t das Fenster
		this.pack(); //Passe gr��e des Fensters an. (Gr��e des Inhalts von panel)
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run()
			{
				Window window = new Window();
				window.setVisible(true);
			}		
		});

	}

}
