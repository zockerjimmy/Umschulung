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
		if (posX >= 0 && posX < 100 && posY >= 0 && posY < 100)
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[0] == 0)
				{
					GamePanel.field[0] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[0] == 0)
				{
					GamePanel.field[0] = 2;
				}
			}
			actualField = 0;
		}
		else if (posX >= 100 && posX < 200 && posY >= 0 && posY < 100)
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[1] == 0)
				{
					GamePanel.field[1] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[1] == 0)
				{
					GamePanel.field[1] = 2;
				}
			}
			actualField = 1;
		}
		else if (posX >= 200 && posX <= 300 && posY >= 0 && posY < 100)
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[2] == 0)
				{
					GamePanel.field[2] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[2] == 0)
				{
					GamePanel.field[2] = 2;
				}
			}
			actualField = 2;
		}
		else if (posX >= 0 && posX < 100 && posY >= 100 && posY < 200)
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[3] == 0)
				{
					GamePanel.field[3] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[3] == 0)
				{
					GamePanel.field[3] = 2;
				}
			}
			actualField = 3;
		}
		else if (posX >= 100 && posX < 200 && posY >= 100 && posY < 200)
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[4] == 0)
				{
					GamePanel.field[4] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[4] == 0)
				{
					GamePanel.field[4] = 2;
				}
			}
			actualField = 4;
		}
		else if (posX >= 200 && posX <= 300 && posY >= 100 && posY < 200)
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[5] == 0)
				{
					GamePanel.field[5] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[5] == 0)
				{
					GamePanel.field[5] = 2;
				}
			}
			actualField = 5;
		}
		else if (posX >= 0 && posX < 100 && posY >= 200 && posY <= 300)
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[6] == 0)
				{
					GamePanel.field[6] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[6] == 0)
				{
					GamePanel.field[6] = 2;
				}
			}
			actualField = 6;
		}
		else if (posX >= 100 && posX < 200 && posY >= 200 && posY <= 300)
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[7] == 0)
				{
					GamePanel.field[7] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[7] == 0)
				{
					GamePanel.field[7] = 2;
				}
			}
			actualField = 7;
		}
		else if (posX >= 200 && posX <= 300 && posY >= 200 && posY <= 300)
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[8] == 0)
				{
					GamePanel.field[8] = 1;
				}
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[8] == 0)
				{
					GamePanel.field[8] = 2;
				}
			}
			actualField = 8;
		}
		else
		{
			System.out.println("ERROR!");
		}
	}

	public void CheckFields()
	{
		switch (actualField)
		{
		case 0:
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[0] == 1 && GamePanel.field[1] == 1 && GamePanel.field[2] == 1
						|| GamePanel.field[0] == 1 && GamePanel.field[4] == 1 && GamePanel.field[8] == 1
						|| GamePanel.field[0] == 1 && GamePanel.field[3] == 1 && GamePanel.field[6] == 1)
				{
					Game.isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[0] == 2 && GamePanel.field[1] == 2 && GamePanel.field[2] == 2
						|| GamePanel.field[0] == 2 && GamePanel.field[4] == 2 && GamePanel.field[8] == 2
						|| GamePanel.field[0] == 2 && GamePanel.field[3] == 2 && GamePanel.field[6] == 2)
				{
					Game.isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		case 1:
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[0] == 1 && GamePanel.field[1] == 1 && GamePanel.field[2] == 1
						|| GamePanel.field[1] == 1 && GamePanel.field[4] == 1 && GamePanel.field[7] == 1)
				{
					Game.isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[0] == 2 && GamePanel.field[1] == 2 && GamePanel.field[2] == 2
						|| GamePanel.field[0] == 2 && GamePanel.field[4] == 2 && GamePanel.field[8] == 2)
				{
					Game.isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		case 2:
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[0] == 1 && GamePanel.field[1] == 1 && GamePanel.field[2] == 1
						|| GamePanel.field[2] == 1 && GamePanel.field[5] == 1 && GamePanel.field[8] == 1
						|| GamePanel.field[2] == 1 && GamePanel.field[4] == 1 && GamePanel.field[6] == 1)
				{
					Game.isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[0] == 2 && GamePanel.field[1] == 2 && GamePanel.field[2] == 2
						|| GamePanel.field[2] == 2 && GamePanel.field[5] == 2 && GamePanel.field[8] == 2
						|| GamePanel.field[2] == 2 && GamePanel.field[4] == 2 && GamePanel.field[6] == 2)
				{
					Game.isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		case 3:
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[3] == 1 && GamePanel.field[4] == 1 && GamePanel.field[5] == 1
						|| GamePanel.field[0] == 1 && GamePanel.field[3] == 1 && GamePanel.field[6] == 1)
				{
					Game.isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[3] == 2 && GamePanel.field[4] == 2 && GamePanel.field[5] == 2
						|| GamePanel.field[0] == 2 && GamePanel.field[3] == 2 && GamePanel.field[6] == 2)
				{
					Game.isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		case 4:
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[3] == 1 && GamePanel.field[4] == 1 && GamePanel.field[5] == 1
						|| GamePanel.field[1] == 1 && GamePanel.field[4] == 1 && GamePanel.field[7] == 1
						|| GamePanel.field[0] == 1 && GamePanel.field[4] == 1 && GamePanel.field[8] == 1
						|| GamePanel.field[2] == 1 && GamePanel.field[4] == 1 && GamePanel.field[6] == 1)
				{
					Game.isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[3] == 2 && GamePanel.field[4] == 2 && GamePanel.field[5] == 2
						|| GamePanel.field[1] == 2 && GamePanel.field[4] == 2 && GamePanel.field[7] == 2
						|| GamePanel.field[0] == 2 && GamePanel.field[4] == 2 && GamePanel.field[8] == 2
						|| GamePanel.field[2] == 2 && GamePanel.field[4] == 2 && GamePanel.field[6] == 2)
				{
					Game.isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		case 5:
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[2] == 1 && GamePanel.field[5] == 1 && GamePanel.field[8] == 1
						|| GamePanel.field[3] == 1 && GamePanel.field[4] == 1 && GamePanel.field[5] == 1)
				{
					Game.isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[2] == 2 && GamePanel.field[5] == 2 && GamePanel.field[8] == 2
						|| GamePanel.field[3] == 2 && GamePanel.field[4] == 2 && GamePanel.field[5] == 2)
				{
					Game.isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		case 6:
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[0] == 1 && GamePanel.field[3] == 1 && GamePanel.field[6] == 1
						|| GamePanel.field[6] == 1 && GamePanel.field[7] == 1 && GamePanel.field[8] == 1
						|| GamePanel.field[6] == 1 && GamePanel.field[4] == 1 && GamePanel.field[2] == 1)
				{
					Game.isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[0] == 2 && GamePanel.field[3] == 2 && GamePanel.field[6] == 2
						|| GamePanel.field[6] == 2 && GamePanel.field[7] == 2 && GamePanel.field[8] == 2
						|| GamePanel.field[6] == 2 && GamePanel.field[4] == 2 && GamePanel.field[2] == 2)
				{
					Game.isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		case 7:
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[6] == 1 && GamePanel.field[7] == 1 && GamePanel.field[8] == 1
						|| GamePanel.field[7] == 1 && GamePanel.field[4] == 1 && GamePanel.field[1] == 1)
				{
					Game.isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[6] == 2 && GamePanel.field[7] == 2 && GamePanel.field[8] == 2
						|| GamePanel.field[7] == 2 && GamePanel.field[4] == 2 && GamePanel.field[1] == 2)
				{
					Game.isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		case 8:
		{
			if (ePlayer == player.Player1)
			{
				if (GamePanel.field[8] == 1 && GamePanel.field[5] == 1 && GamePanel.field[2] == 1
						|| GamePanel.field[6] == 1 && GamePanel.field[7] == 1 && GamePanel.field[8] == 1
						|| GamePanel.field[8] == 1 && GamePanel.field[4] == 1 && GamePanel.field[0] == 1)
				{
					Game.isGameOver = true;
					System.out.println("Player1 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			else if (ePlayer == player.Player2)
			{
				if (GamePanel.field[8] == 2 && GamePanel.field[5] == 2 && GamePanel.field[2] == 2
						|| GamePanel.field[6] == 2 && GamePanel.field[7] == 2 && GamePanel.field[8] == 2
						|| GamePanel.field[8] == 2 && GamePanel.field[4] == 2 && GamePanel.field[0] == 2)
				{
					Game.isGameOver = true;
					System.out.println("Player2 won");
				}
				else ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
			}
			break;
		}
		}
	}
}
