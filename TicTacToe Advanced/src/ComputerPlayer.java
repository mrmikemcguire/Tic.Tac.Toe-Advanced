import java.util.Random;

public class ComputerPlayer
	{
	static int randomRow, randomColumn;
	static int x, y, i, j, lineSum;
	static boolean moveFound = false;
	static boolean checkTile;
	
	public static void makeRandomMoves()
		{
		do
			{
			double randomNumber1 = Math.random();
			randomRow = (int) ((randomNumber1 * 10) %3);
			double randomNumber2 = Math.random();
			randomColumn = (int) ((randomNumber2 * 10) %3);	
	
			PlayGame.currentColumnPlay = randomColumn;
			PlayGame.currentRowPlay = randomRow;
			PlayGame.isIllegalMove();
			}
		while (PlayGame.isIllegalMove());
		}
	

	public static String [][] makeGoodMoves()
		{
		
		// check for a winning move on each row
		
		if(moveFound = false)
			{
			for (i = 0; i < 3; i++)		// notice that i is for checking the row
				{
				lineSum = 0;
				for (j = 0; j < 3; j++)
					{
					lineSum = lineSum + Board.valueTable [i][j];
					if (lineSum == 10)
						{
						for (j = 0; j < 3; j++)
							{
							if (Board.board [i][j].equals(" "))
								{
								Board.board[i][j] = HumanPlayer.computerMarker;
								//setTableValue();
								moveFound = true;
								}
							}
						}
					}
				}
			}
		
		// check for a winning move on each column

		if(moveFound = false)
			{
			for (j = 0; j < 3; j++)		// notice that j is for checking the row
				{
				lineSum = 0;
				for (i = 0; i < 3; i++)
					{
					lineSum = lineSum + Board.valueTable [i][j];
					if (lineSum == 10)
						{
						for (j = 0; j < 3; j++)
							{
							if (Board.board [i][j].equals(" "))
								{
								Board.board[i][j] = HumanPlayer.computerMarker;
								//setTableValue();
								moveFound = true;
								}
							}
						}
					}
				}
			}
		
		// check for a winning move on the A1-C3 diagonal

		if(moveFound == false)
			{
			lineSum = 0;
			for (i = 0; i < 3; i++)
				{
				lineSum = lineSum + Board.valueTable [i][i];
				if (lineSum == 10)
					{
					for (i = 0; i < 3; i++)
						{
						if (Board.board [i][i].equals(" "))
							{
							Board.board [i][i] = HumanPlayer.computerMarker;
							//setTableValue2();
							moveFound = true;
							}
						}
					}
				}
			}
		
		// check for a winning move on the A3-C1 diagonal
		
		if(moveFound == false)
			{
			lineSum = 0;
			for (i = 0; i < 3; i++)
				{
				lineSum = lineSum + Board.valueTable [i][2 - i];
				if (lineSum == 10)
					{
					for (i = 0; i < 3; i++)
						{
						if (Board.board [i][2 - i].equals(" "))
							{
							Board.board [i][2 - i] = HumanPlayer.computerMarker;
							//setTableValue3();
							moveFound = true;
							}
						}
					}
				}
			}
		//check for a blocking move on each row 
		
		if(moveFound == false)
			{
			for (i = 0; i < 3; i++)
				{
				lineSum = 0;
				for (j = 0; j < 3; j++)
					{
					lineSum = lineSum + Board.valueTable [i][j];
					if (lineSum == 4)
						{
						for (j = 0; j < 3; j++)
							{
							if(Board.board [i][j].equals(" "))
								{
								Board.board [i][j] = HumanPlayer.computerMarker;
								//setTableValue();
								moveFound = true;
								}
							}
						}
					}
				}
			}
		
		//check for a blocking move on each column

		if(moveFound == false)
			{
			for (j = 0; j < 3; j++)
				{
				lineSum = 0;
				for (i = 0; i < 3; i++)
					{
					lineSum = lineSum + Board.valueTable [i][j];
					if (lineSum == 4)
						{
						for (i = 0; i < 3; i++)
							{
							if(Board.board [i][j].equals(" "))
								{
								Board.board [i][j] = HumanPlayer.computerMarker;
								//setTableValue();
								moveFound = true;
								}
							}
						}
					}
				}
			}
		
		//check for a blocking move on the A1-C3 diagonal

		if(moveFound == false)
			{
			lineSum = 0;
			for (i = 0; i < 3; i++)
				{
				lineSum = lineSum + Board.valueTable [i][i];
				if (lineSum == 4)
					{
					for (i = 0; i < 3; i++)
						{
						if (Board.board [i][i].equals(" "))
							{
							Board.board [i][i] = HumanPlayer.computerMarker;
							//setTableValue2();
							moveFound = true;
							}
						}
					}
				}
			}
		
		//check for a blocking move on the A3-C1 diagonal

		if(moveFound == false)
			{
			lineSum = 0;
			for (i = 0; i < 3; i++)
				{
				lineSum = lineSum + Board.valueTable [i][2 - i];
				if (lineSum == 4)
					{
					for (i = 0; i < 3; i++)
						{
						if (Board.board [i][2 - i].equals(" "))
							{
							Board.board [i][2 - i] = HumanPlayer.computerMarker;
							//setTableValue3();
							moveFound = true;
							}
						}
					}
				}
			}
		
		// play in the center if possible
		
		System.out.println("moveFound is " + moveFound);
		System.out.println(Board.board [1][1]);
		if ((moveFound == false) && (Board.board [1][1].equals(" ")))
			{
			Board.board [1][1] = HumanPlayer.computerMarker;
			i = 1;
			j = 1;
			setTableValue();
			moveFound = true;
			}
		
		// play randomly if no other rule to follow
		
		if (moveFound == false)
			{
			while(checkTile == false)
				{
				Random randomNumber = new Random();
				PlayGame.currentRowPlay = randomNumber.nextInt(3);
				Random randomNumber2 = new Random();
				PlayGame.currentColumnPlay = randomNumber.nextInt(3);
				if (Board.board [PlayGame.currentRowPlay][PlayGame.currentColumnPlay].equals(" "))
					{
					Board.board [PlayGame.currentRowPlay][PlayGame.currentColumnPlay] = HumanPlayer.computerMarker;
					setTableValue();
					checkTile = true;
					}
				}
			}
		return Board.board;
		}
	
	public static int [][] setTableValue()
		{
		Board.valueTable [i][j] = 5;
		return Board.valueTable;
		}
	
	public static int [][] setTableValue2()
		{
		Board.valueTable [i][i] = 5;
		return Board.valueTable;
		}
	
	public static int [][] setTableValue3()
		{
		Board.valueTable[i][2-i] = 5;
		return Board.valueTable;
		}
	}
	
								
		