public class ComputerPlayer
	{
	static int randomRow, randomColumn;
	static int x, y, i, j, lineSum;
	static boolean moveFound = false;
	
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
		// check for a win on each row
		
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
								setTableValue();
								moveFound = true;
								}
							}
						}
					}
				}
			}
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
								setTableValue();
								moveFound = true;
								}
							}
						}
					}
				}
			}
		
								
		