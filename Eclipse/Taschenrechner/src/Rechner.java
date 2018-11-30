public class Rechner
{
	// private double total;
	private double value1, value2, total;
	private char operator;
	private boolean isValue1Set = false;

	public void SetTerm(String str)
	{
		StringBuilder sb = new StringBuilder();

		if (str == null || str == "" || str.isEmpty())
		{
			// Reset
		}
		else
		{
			for (int i = 0; i < str.length(); i++)
			{
				if (!isValue1Set)
				{
					//Prüfe auf Zahlen und . und kommas so lange bis etwas anderes kommt (Operator)
					//Fülle value1 und operator...
					if (Character.isDigit(str.charAt(i)))
					{
						sb.append(str.charAt(i));
					}
					else
					{
						if (str.charAt(i) == '.')
						{								
						sb.append(str.charAt(i));	
						continue;
						}
						else if(str.charAt(i) == ',')
						{
							sb.append(".");	
							continue;
						}
						else
						{
							value1 = Double.parseDouble(sb.toString());	
							operator = (char) str.charAt(i);
							sb.setLength(0);
							isValue1Set = true;
						}
					}
				}
				else
				{
					//... anschließend prüfe rest der Eingabe
					if (Character.isDigit(str.charAt(i)))
					{
						sb.append(str.charAt(i));
					}
					else
					{
						if (str.charAt(i) == '.')
						{								
						sb.append(str.charAt(i));	
						continue;
						}
						else if(str.charAt(i) == ',')
						{
							sb.append(".");	
							continue;
						}
					}
					if (i == str.length() - 1)
					{
						value2 = Double.parseDouble(sb.toString());
					}
				}
			}
		}
		SetCalc(value1, value2, operator);
	}

	public void SetCalc(double v1, double v2, char op)
	{
		if (op == '+')
			Add(v1, v2);
		else if (op == '-')
			Sub(v1, v2);
		else if (op == '*')
			Mult(v1, v2);
		else if (op == '/')
			Div(v1, v2);
		else if (op == '%')
			Mod(v1, v2);
	}

	public void Add(double v1, double v2)
	{
		System.out.println(v1 + " + " + v2 + " = " + (v1 + v2));
	}

	public void Sub(double v1, double v2)
	{
		System.out.println(v1 + " - " + v2 + " = " + (v1 - v2));
	}

	public void Mult(double v1, double v2)
	{
		System.out.println(v1 + " * " + v2 + " = " + (v1 * v2));
	}

	public void Div(double v1, double v2)
	{
		System.out.println(v1 + " / " + v2 + " = " + (v1 / v2));
	}

	public void Mod(double v1, double v2)
	{
		System.out.println(v1 + " % " + v2 + " = " + (v1 % v2));
	}
}
