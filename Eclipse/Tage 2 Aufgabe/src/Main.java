import static java.lang.System.out;

public class Main
{
	public static void main(String[] args)
	{
		int laenge = 5;
		int breite = 4;
		boolean setBlankChar = false;

		for (int i = 0; i < laenge; i++)
		{
			for (int j = 0; j < breite; j++)
			{
				out.print((setBlankChar) ? "#" : " ");
				setBlankChar = (!setBlankChar) ? true : false;
			}
			if(breite%2==0) 
			{
				setBlankChar = (!setBlankChar) ? true : false;
			}			
			out.println();
		}
	}
}
