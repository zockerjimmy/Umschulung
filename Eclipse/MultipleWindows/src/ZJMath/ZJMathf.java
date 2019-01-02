package ZJMath;

public class ZJMathf
{

	public static int RoundToDeci(double value)
	{
		String stemp = Integer.toString((int)value);		
		stemp.toCharArray();
		stemp = Character.toString(stemp.charAt(stemp.length()-1));
		double temp = 0;
		temp = Double.parseDouble(stemp);
		temp = 10 - (int)temp;
		
		if(temp == 10)
		{
			return (int)value;
		}
		else
		{
			temp = temp + (int)value;
			return (int)temp;
		}
	}
}
