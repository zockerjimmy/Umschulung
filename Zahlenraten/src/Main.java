import static java.lang.System.out;
import java.util.Scanner;

public class Main
{

	//Schauen Sie in Tag2 Aufgaben und ergänzen Sie die Hardgecodeten Eingaben mit dynamischen
	
	//Nehmen Sie eine Zahl an, Konsole leeren, Neue Zahl annehmen, überprüfen ob größer oder kleiner, 
	//Hinweis geben, Wenn Abstand kleiner als 5 = besonderer Hinweis, Begrenze auf 5 Raterunden
	//wenn Zahl gefunden, gebe Zahl gefunden aus, ansonsten "leider verloren"
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int goalValue;
		int userInput;
		
		out.print("Zielwert: ");
		goalValue = scanner.nextInt();
		
		for(int i = 0; i < 100; i++)
		{
			out.println();
		}
		
		
	}

}
