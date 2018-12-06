public class PlayerInput
{
	GamePanel gPanel = new GamePanel();

	enum player
	{
		Player1, Player2
	};

	public static player ePlayer = player.Player1;

	int actualField;

	public void CheckPlayerInput(int posX, int posY)
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if ((posX >= Game.fieldCoordX[i][j] && posY >= Game.fieldCoordY[i][j])
						&& (posX < Game.fieldCoordXEnd[i][j] && posY < Game.fieldCoordYEnd[i][j]))
				{
					if (ePlayer == player.Player1)
					{
						if (Game.fields[i][j] == 0)
						{
							Game.fields[i][j] = 1;
						}
					}
					else if (ePlayer == player.Player2)
					{
						if (Game.fields[i][j] == 0)
						{
							Game.fields[i][j] = 2;
						}
					}
				}
			}
		}		
	}

	public void CheckFields()
	{
		int iPlayer = 1;

		if (ePlayer == player.Player1)
		{
			iPlayer = 1;
		}
		else if (ePlayer == player.Player2)
		{
			iPlayer = 2;
		}	
				// horizontalCheck
				for (int i = 0; i < 3; i++)
				{
					for (int j = 0; j < 1; j++)
					{
						if (Game.fields[i][j] == iPlayer && Game.fields[i][j + 1] == iPlayer && Game.fields[i][j + 2] == iPlayer)
						{
							Game.isGameOver = true;
							break;
						}
					}
				}
				// verticalCheck
				for (int i = 0; i < 1; i++)
				{
					for (int j = 0; j < 3; j++)
					{
						if (Game.fields[i][j] == iPlayer && Game.fields[i + 1][j] == iPlayer && Game.fields[i + 2][j] == iPlayer)
						{
							Game.isGameOver = true;
							break;
						}
					}
				}				
				// ascendingDiagonalCheck
				for (int i = 0; i < 1; i++)
				{
					for (int j = 0; j < 1; j++)
					{
						if (Game.fields[i][j] == iPlayer && Game.fields[i+1][j+1] == iPlayer && Game.fields[i+2][j+2] == iPlayer)
						{
							Game.isGameOver = true;
							break;
						}
					}
				}				
				// ascendingDiagonalCheck
				for (int i = 0; i < 1; i++)
				{
					for (int j = 0; j < 1; j++)
					{
						if (Game.fields[i+2][j] == iPlayer && Game.fields[i+1][j+1] == iPlayer && Game.fields[i][j+2] == iPlayer)
						{
							Game.isGameOver = true;
							break;
						}
					}
				}			
				
		if(!Game.isGameOver)
		{
			ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
		}
	}
}
