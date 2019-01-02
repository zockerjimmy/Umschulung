package FireworkPanel;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JFrame;
 
@SuppressWarnings({ "unused", "serial" })
public class FireworkWindow extends JFrame
{
		
	public FireworkWindow()
	{
		Panel panel = new Panel();
		this.add(panel); //Fenster einen Inhalt geben
		this.setTitle("Firework Simulator"); //Fenstertitel
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //"X"-Schaltfl�che schlie�t das Fenster
		this.pack(); //Passe gr��e des Fensters an. (Gr��e des Inhalts von panel)
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run()
			{
				FireworkWindow window = new FireworkWindow();
				window.setVisible(true);
			}		
		});

	}

}
