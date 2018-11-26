import java.util.Scanner;
import static java.lang.System.out;

public class Eingaben
{
	public static void main(String[] args)
	{
		Scanner derScanner = new Scanner(System.in);
		// String meinText = "Uebernices Texteingabe Programm";
		// int meineZahl;

		/*
		 * out.println(meinText); // String meineEingabe = Eingabe von der Konsole
		 * übernehmen // String eingaben mit nextLine out.print("Eingabe: "); String
		 * meineEingabe = derScanner.nextLine(); // Scanner wartet auf Eingabe und Enter
		 * out.println("Ausgabe: " + meineEingabe);
		 */

		/*
		 * out.print("Eingabe: "); meineZahl = derScanner.nextInt();
		 * out.println("Die Zahl lautet: " + meineZahl);
		 */

		/*
		 * //Eingabe als Int Wert, Quadrat bilden (mit sich selbst nult),
		 * "Die Quadratzahl von 4 ist 16" ausgeben
		 * out.print("Bitte geben Sie eine Zahl ein: "); meineZahl =
		 * derScanner.nextInt(); out.println("Die Quadratzahl von " + meineZahl +
		 * " lautet: " + meineZahl*meineZahl);
		 */

		// Zwei Zahlen annehmen, diese dann addieren
		/*
		 * int value1, value2; out.print("Bitte Wert 1 angeben: "); value1 =
		 * derScanner.nextInt(); out.print("Bitte Wert 2 angeben: "); value2 =
		 * derScanner.nextInt(); int temp = value1 + value2; out.println("Ergebnis: " +
		 * temp);
		 */

		/*
		 * float z1 = derScanner.nextFloat(); float z2 = derScanner.nextFloat();
		 * out.print(z1/z2);
		 */

		char repeat, operator;
		double z1, z2;

		do
		{
			out.print("Zahl1: ");
			z1 = derScanner.nextInt();
			out.print("Zahl1: ");
			z2 = derScanner.nextInt();
			out.print("Operator: ");
			operator = derScanner.next().charAt(0);

			switch (operator)
			{
				case '+':
				{
					out.print("Ergebnis: " + (z1 + z2));
					break;
				}
				case '-':
				{
					out.print("Ergebnis: " + (z1 + z2));
					break;
				}
				case '*':
				{
					out.print("Ergebnis: " + (z1 * z2));
					break;
				}
				case '/':
				{
					out.print("Ergebnis: " + (z1 / z2));
					break;
				}
				case '%':
				{
					out.print("Ergebnis: " + (z1 % z2));
					break;
				}
				default:
				{
					out.print("Bitte einen gueltigen Operanten eingeben!");
					break;
				}
			}
			out.println();
			out.print("Nochmal? (y/n): ");
			repeat = derScanner.next().charAt(0);
		} while (repeat == 'y');

		derScanner.close();
	}
}
