public class PlayerInput
{
	GamePanel gPanel = new GamePanel();

	enum player
	{
		Player1, Player2
	};

	player ePlayer = player.Player1;

	int actualField;

	public void CheckPlayerInput(int posX, int posY)
	{
		if (posX >= 0 && posX < 100 && posY >= 0 && posY < 100)
		{
			if (ePlayer == player.Player1)
			{
				if(GamePanel.field[0] == 0)
				{					
					GamePanel.field[0] = 1;
				}
			} else if (ePlayer == player.Player2)
			{
				if(GamePanel.field[0] == 0)
				{					
					GamePanel.field[0] = 2;
				}
			}

			actualField = 0;
			ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
		} else if (posX >= 100 && posX < 200 && posY >= 0 && posY < 100)
		{
			if (ePlayer == player.Player1)
			{
				if(GamePanel.field[1] == 0)
				{					
					GamePanel.field[1] = 1;
				}
			} else if (ePlayer == player.Player2)
			{
				if(GamePanel.field[1] == 0)
				{					
					GamePanel.field[1] = 2;
				}
			}
			actualField = 1;
			ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
		} else if (posX >= 200 && posX <= 300 && posY >= 0 && posY < 100)
		{
			if (ePlayer == player.Player1)
			{
				if(GamePanel.field[2] == 0)
				{					
					GamePanel.field[2] = 1;
				}
			} else if (ePlayer == player.Player2)
			{
				if(GamePanel.field[2] == 0)
				{					
					GamePanel.field[2] = 2;
				}
			}
			actualField = 2;
			ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
		} else if (posX >= 0 && posX < 100 && posY >= 100 && posY < 200)
		{
			if (ePlayer == player.Player1)
			{
				if(GamePanel.field[3] == 0)
				{					
					GamePanel.field[3] = 1;
				}
			} else if (ePlayer == player.Player2)
			{
				if(GamePanel.field[3] == 0)
				{					
					GamePanel.field[3] = 2;
				}
			}
			actualField = 3;
			ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
		} else if (posX >= 100 && posX < 200 && posY >= 100 && posY < 200)
		{
			if (ePlayer == player.Player1)
			{
				if(GamePanel.field[4] == 0)
				{					
					GamePanel.field[4] = 1;
				}
			} else if (ePlayer == player.Player2)
			{
				if(GamePanel.field[4] == 0)
				{					
					GamePanel.field[4] = 2;
				}
			}
			actualField = 4;
			ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
		} else if (posX >= 200 && posX <= 300 && posY >= 100 && posY < 200)
		{
			if (ePlayer == player.Player1)
			{
				if(GamePanel.field[5] == 0)
				{					
					GamePanel.field[5] = 1;
				}
			} else if (ePlayer == player.Player2)
			{
				if(GamePanel.field[5] == 0)
				{					
					GamePanel.field[5] = 2;
				}
			}
			actualField = 5;
			ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
		} else if (posX >= 0 && posX < 100 && posY >= 200 && posY <= 300)
		{
			if (ePlayer == player.Player1)
			{
				if(GamePanel.field[6] == 0)
				{					
					GamePanel.field[6] = 1;
				}
			} else if (ePlayer == player.Player2)
			{
				if(GamePanel.field[6] == 0)
				{					
					GamePanel.field[6] = 2;
				}
			}
			actualField = 6;
			ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
		} else if (posX >= 100 && posX < 200 && posY >= 200 && posY <= 300)
		{
			if (ePlayer == player.Player1)
			{
				if(GamePanel.field[7] == 0)
				{					
					GamePanel.field[7] = 1;
				}
			} else if (ePlayer == player.Player2)
			{
				if(GamePanel.field[7] == 0)
				{					
					GamePanel.field[7] = 2;
				}
			}
			actualField = 7;
			ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
		} else if (posX >= 200 && posX <= 300 && posY >= 200 && posY <= 300)
		{
			if (ePlayer == player.Player1)
			{
				if(GamePanel.field[8] == 0)
				{					
					GamePanel.field[8] = 1;
				}
			} else if (ePlayer == player.Player2)
			{
				if(GamePanel.field[8] == 0)
				{					
					GamePanel.field[8] = 2;
				}
			}
			actualField = 8;
			ePlayer = ePlayer == player.Player1 ? player.Player2 : player.Player1;
		} else
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
			if (GamePanel.field[0] == 1 && GamePanel.field[1] == 1 && GamePanel.field[2] == 1 ||
					GamePanel.field[0] == 1 && GamePanel.field[4] == 1 && GamePanel.field[8] == 1 ||
					GamePanel.field[0] == 1 && GamePanel.field[3] == 1 && GamePanel.field[6] == 1 )
			{
				System.out.println("Player1 won");
			}
			if (GamePanel.field[0] == 2 && GamePanel.field[1] == 2 && GamePanel.field[2] == 2 ||
					GamePanel.field[0] == 2 && GamePanel.field[4] == 2 && GamePanel.field[8] == 2 ||
					GamePanel.field[0] == 2 && GamePanel.field[3] == 2 && GamePanel.field[6] == 2 )
			{
				System.out.println("Player2 won");
			}
						
			break;
		}
		case 1:
		{
			if (GamePanel.field[0] == 1 && GamePanel.field[1] == 1 && GamePanel.field[2] == 1 ||
					GamePanel.field[1] == 1 && GamePanel.field[4] == 1 && GamePanel.field[7] == 1)
			{
				System.out.println("Player1 won");
			}
			if (GamePanel.field[0] == 2 && GamePanel.field[1] == 2 && GamePanel.field[2] == 2 ||
					GamePanel.field[0] == 2 && GamePanel.field[4] == 2 && GamePanel.field[8] == 2 )
			{
				System.out.println("Player2 won");
			}
			break;
		}
		case 2:
		{
			if (GamePanel.field[0] == 1 && GamePanel.field[1] == 1 && GamePanel.field[2] == 1 ||
					GamePanel.field[2] == 1 && GamePanel.field[5] == 1 && GamePanel.field[8] == 1 ||
					GamePanel.field[2] == 1 && GamePanel.field[4] == 1 && GamePanel.field[6] == 1 )
			{
				System.out.println("Player1 won");
			}
			if (GamePanel.field[0] == 2 && GamePanel.field[1] == 2 && GamePanel.field[2] == 2 ||
					GamePanel.field[2] == 2 && GamePanel.field[5] == 2 && GamePanel.field[8] == 2 ||
					GamePanel.field[2] == 2 && GamePanel.field[4] == 2 && GamePanel.field[6] == 2 )
			{
				System.out.println("Player2 won");
			}
			break;
		}
		case 3:
		{
			if (GamePanel.field[3] == 1 && GamePanel.field[4] == 1 && GamePanel.field[5] == 1 ||
					GamePanel.field[0] == 1 && GamePanel.field[3] == 1 && GamePanel.field[6] == 1)
			{
				System.out.println("Player1 won");
			}
			if (GamePanel.field[3] == 2 && GamePanel.field[4] == 2 && GamePanel.field[5] == 2 ||
					GamePanel.field[0] == 2 && GamePanel.field[3] == 2 && GamePanel.field[6] == 2)
			{
				System.out.println("Player2 won");
			}
			break;
		}
		case 4:
		{
			if (GamePanel.field[3] == 1 && GamePanel.field[4] == 1 && GamePanel.field[5] == 1 ||
					GamePanel.field[1] == 1 && GamePanel.field[4] == 1 && GamePanel.field[7] == 1 ||
					GamePanel.field[0] == 1 && GamePanel.field[4] == 1 && GamePanel.field[8] == 1 ||
					GamePanel.field[2] == 1 && GamePanel.field[4] == 1 && GamePanel.field[6] == 1 )
			{
				System.out.println("Player1 won");
			}
			if (GamePanel.field[3] == 2 && GamePanel.field[4] == 2 && GamePanel.field[5] == 2 ||
					GamePanel.field[1] == 2 && GamePanel.field[4] == 2 && GamePanel.field[7] == 2 ||
					GamePanel.field[0] == 2 && GamePanel.field[4] == 2 && GamePanel.field[8] == 2 ||
					GamePanel.field[2] == 2 && GamePanel.field[4] == 2 && GamePanel.field[6] == 2 )
			{
				System.out.println("Player2 won");
			}
			break;
		}
		case 5:
		{
			if (GamePanel.field[2] == 1 && GamePanel.field[5] == 1 && GamePanel.field[8] == 1 ||
					GamePanel.field[2] == 1 && GamePanel.field[4] == 1 && GamePanel.field[6] == 1)
			{
				System.out.println("Player1 won");
			}
			if (GamePanel.field[2] == 2 && GamePanel.field[5] == 2 && GamePanel.field[8] == 2 ||
					GamePanel.field[2] == 2 && GamePanel.field[4] == 2 && GamePanel.field[6] == 2)
			{
				System.out.println("Player2 won");
			}
			break;
		}
		case 6:
		{
			if (GamePanel.field[0] == 1 && GamePanel.field[3] == 1 && GamePanel.field[6] == 1 ||
					GamePanel.field[6] == 1 && GamePanel.field[7] == 1 && GamePanel.field[8] == 1 ||
					GamePanel.field[6] == 1 && GamePanel.field[4] == 1 && GamePanel.field[2] == 1 )
			{
				System.out.println("Player1 won");
			}
			if (GamePanel.field[0] == 2 && GamePanel.field[3] == 2 && GamePanel.field[6] == 2 ||
					GamePanel.field[6] == 2 && GamePanel.field[7] == 2 && GamePanel.field[8] == 2 ||
					GamePanel.field[6] == 2 && GamePanel.field[4] == 2 && GamePanel.field[2] == 2 )
			{
				System.out.println("Player2 won");
			}
			break;
		}
		case 7:
		{
			if (GamePanel.field[6] == 1 && GamePanel.field[7] == 1 && GamePanel.field[8] == 1 ||
					GamePanel.field[7] == 1 && GamePanel.field[4] == 1 && GamePanel.field[1] == 1)
			{
				System.out.println("Player1 won");
			}
			if (GamePanel.field[6] == 2 && GamePanel.field[7] == 2 && GamePanel.field[8] == 2 ||
					GamePanel.field[7] == 2 && GamePanel.field[4] == 2 && GamePanel.field[1] == 2)
			{
				System.out.println("Player2 won");
			}
			break;
		}
		case 8:
		{
			if (GamePanel.field[8] == 1 && GamePanel.field[5] == 1 && GamePanel.field[2] == 1 ||
					GamePanel.field[6] == 1 && GamePanel.field[7] == 1 && GamePanel.field[8] == 1 ||
					GamePanel.field[8] == 1 && GamePanel.field[4] == 1 && GamePanel.field[0] == 1 )
			{
				System.out.println("Player1 won");
			}
			if (GamePanel.field[8] == 2 && GamePanel.field[5] == 2 && GamePanel.field[2] == 2 ||
					GamePanel.field[6] == 2 && GamePanel.field[7] == 2 && GamePanel.field[8] == 2 ||
					GamePanel.field[8] == 2 && GamePanel.field[4] == 2 && GamePanel.field[0] == 2 )
			{
				System.out.println("Player2 won");
			}
			break;
		}
		}
	}
}
