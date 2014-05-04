import java.util.Random;

public class ComputerPlayer
	{
	static int randomRow, randomColumn;
	static int x, y, i, j, lineSum;
	static boolean moveFound = false;
	static boolean checkTile = false;
	
	public static void makeRandomMoves()
		{
		do
			{
			double randomNumber1 = Math.random();
			randomRow = (int) ((randomNumber1 * 10) %3);
			double randomNumber2 = Math.random();
			randomColumn = (int) ((randomNumber2 * 10) %3);	
	
			PlayGame.column = randomColumn;
			PlayGame.row = randomRow;
			PlayGame.isIllegalMove();
			}
		while (PlayGame.isIllegalMove());
		}
	

	public static String [][] makeGoodMoves()
		{
		
		// check for a winning move on each row
		
		if(moveFound == false)
			{
			System.out.println("check for a winning move on each row");

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
								PlayGame.row = i;
								PlayGame.column = j;
								moveFound = true;
								}
							}
						}
					}
				}
			}
		
		// check for a winning move on each column

		if(moveFound == false)
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
								PlayGame.row = i;
								PlayGame.column = j;
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
							PlayGame.row = i;
							PlayGame.column = j;
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
							PlayGame.row = i;
							PlayGame.column = j;
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
								PlayGame.row = i;
								PlayGame.column = j;
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
								PlayGame.row = i;
								PlayGame.column = j;
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
							PlayGame.row = i;
							PlayGame.column = i;
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
							PlayGame.row = i;
							PlayGame.column = 2 - i;
							moveFound = true;
							}
						}
					}
				}
			}
		
		// play in the center if possible
		if (moveFound == false)
			{
			System.out.println("moveFound is " + moveFound);
			System.out.println(Board.board [1][1]);
			}
		if ((moveFound == false) && (Board.board [1][1].equals(" ")))
			{
			System.out.println("This shouldn't execute if B2..");
			Board.board [1][1] = HumanPlayer.computerMarker;
			i = 1;
			j = 1;
			PlayGame.row = i;
			PlayGame.column = j;
			setTableValue();
			moveFound = true;
			}
		
		// play randomly if no other rule to follow
		
		if (moveFound == false)
			{
			System.out.println("This opens the random number section");
//			while(checkTile == false)
//				{
//				System.out.println("Generate random number here");
//				Random randomNumber = new Random();
//				PlayGame.row = randomNumber.nextInt(3);
//				Random randomNumber2 = new Random();
//				PlayGame.column = randomNumber.nextInt(3);
//				if (Board.board [PlayGame.row][PlayGame.column].equals(" "))
//					{
//					Board.board [PlayGame.row][PlayGame.column] = HumanPlayer.computerMarker;
//					setTableValue();
//					checkTile = true;
//					}
//				}
			makeRandomMoves();
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
	
								
		