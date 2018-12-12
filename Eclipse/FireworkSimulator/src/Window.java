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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //"X"-Schaltfläche schließt das Fenster
		this.pack(); //Passe größe des Fensters an. (Größe des Inhalts von panel)
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
