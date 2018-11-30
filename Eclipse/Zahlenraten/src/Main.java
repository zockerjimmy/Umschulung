import static java.lang.System.out;
import java.util.Scanner;

public class Main
{
	// Nehmen Sie eine Zahl an, Konsole leeren, Neue Zahl annehmen, überprüfen ob
	// größer oder kleiner,
	// Hinweis geben, Wenn Abstand kleiner als 5 = besonderer Hinweis, Begrenze auf
	// 5 Raterunden
	// wenn Zahl gefunden, gebe Zahl gefunden aus, ansonsten "leider verloren"
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int goalValue;
		int userInput;
		int counter = 0;
		int counterMax = 5;

		out.print("Zielwert: ");
		goalValue = scanner.nextInt();

		for (int i = 0; i < 10; i++)
		{
			out.println();
		}

		do
		{
			out.println();
			out.print("Eingabe: ");
			userInput = scanner.nextInt();
			if (userInput == goalValue)
			{
				out.println("Korrekt!");
				break;
			} else if (userInput > goalValue)
			{
				out.println("Zu hoch!");
			} else if (userInput < goalValue)
			{
				out.println("Zu niedrig!");
			}

			if ((goalValue - userInput) < 5 && (goalValue - userInput) > -5 && (goalValue - userInput) != 0)
			{
				out.println("Knapp!");
			}
			counter++;
			if (counter == counterMax)
			{
				out.print("Vorbei!");
			}
		} while (counter < counterMax);

		scanner.close();

		// int x = 4;
		// System.out.print((x&1) == 1 ?(x + " is ungerade") : (x + " is gerade"));
	}

}
