import java.util.Scanner;

public class Main
{
	// Rechner in oop
	// Scanner, objekt von klasse rechner, progrmam in schleife

	public static void main(String[] args)
	{
		Rechner rechner = new Rechner();
		Scanner scanner = new Scanner(System.in);

		double value1, value2;
		char operator, cLoop;

		String input = "";
		
		//Der coole Weg
		do
		{
		System.out.println("Eingabe: ");
		input = scanner.next();
		rechner.SetTerm(input);
		
		//Manuelles fortführen/beenden der Schleife
		System.out.println();
		System.out.print("Nochmal? (y/n)");
		cLoop = scanner.next().charAt(0);
		//if(cLoop != 'y' || cLoop != 'Y') break; //Weder y noch Y wird erkannt???
		if(cLoop != 'y') break;			
		System.out.println("############################################");
		System.out.println();
		} while (true);
		
		//Der Olle Weg
		/*do
		{
			//Eingabe der Werte und des gewünschten Operatoren
			System.out.print("Wert1: ");
			value1 = scanner.nextInt();
			System.out.print("Rechenart: ");
			operator = scanner.next().charAt(0);
			System.out.print("Wert2: ");
			value2 = scanner.nextInt();
			//Übergebe Eingaben an Rechner.java
			rechner.SetCalc(value1, value2, operator);
			
			//Manuelles fortführen/beenden der Schleife
			System.out.println();
			System.out.print("Nochmal? (y/n)");
			cLoop = scanner.next().charAt(0);
			//if(cLoop != 'y' || cLoop != 'Y') break; //Weder y noch Y wird erkannt???
			if(cLoop != 'y') break;			
			System.out.println("############################################");
			System.out.println();
		} while (true);*/
		
		scanner.close();
	}
}
