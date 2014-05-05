import java.util.Random;
import java.util.Scanner;

public class ComputerPlayer
	{
	static int randomRow, randomColumn;
	static int x, y, i, j, k, lineSum;
	static int difficultyLevel;
	static boolean moveFound = false;
	static boolean checkTile = false;
	static int counter = 0;
	
	public static int chooseAILevel()
		{
		System.out.println("What level of AI do you wish to play?");
		System.out.println("(1) Regis");
		System.out.println("(2) Mullen");
		//System.out.println("(3) Unbeatable");
		Scanner input = new Scanner(System.in);
		difficultyLevel = input.nextInt();
		return difficultyLevel;
		}
	
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
			counter++;
			if (counter == 100)
				{
				System.out.println("It's a tie");
				System.exit(0);
				}
			}
		while (PlayGame.isIllegalMove());
		}
	
	public static String [][] makeGoodMoves()
		{
		checkForWinningRowMove();
		checkForWinningColumnMove();
		checkForWinningDiagonalMove();
		checkForBlockingRowMove();
		checkForBlockingColumnMove();
		checkForBlockingDiagonalMove();
		playInCenter();
		makeRandomMove();
		return Board.board;
		}
	
	public static void checkForWinningRowMove()
		{
		if(moveFound == false)
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
								PlayGame.row = i;
								PlayGame.column = j;
								moveFound = true;
								}
							}
						}
					}
				}
			}
		}
				
	public static void checkForWinningColumnMove()
		{
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
						for (k = 0; k < 3; k++)
							{
							if (Board.board [i][j].equals(" "))
								{
								Board.board[i][j] = HumanPlayer.computerMarker;
								PlayGame.row = i;
								PlayGame.column = j;
								moveFound = true;
								}
							}
						}
					}
				}
			}
		}
			
	public static void checkForWinningDiagonalMove()
		{
		
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
							PlayGame.row = i;
							PlayGame.column = j;
							moveFound = true;
							}
						}
					}
				}
			}
		}
				
	public static void checkForBlockingRowMove()
		{
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
								PlayGame.row = i;
								PlayGame.column = j;
								moveFound = true;
								}
							}
						}
					}
				}
			}
		}
	
	public static void checkForBlockingColumnMove()
		{
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
								PlayGame.row = i;
								PlayGame.column = j;
								moveFound = true;
								}
							}
						}
					}
				}
			}
		}
		
	public static void checkForBlockingDiagonalMove()
		{
		
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
							PlayGame.row = i;
							PlayGame.column = 2 - i;
							moveFound = true;
							}
						}
					}
				}
			}
		}
					
	public static void playInCenter()
		{
		if ((moveFound == false) && (Board.board [1][1].equals(" ")))
			{
			Board.board [1][1] = HumanPlayer.computerMarker;
			i = 1;
			j = 1;
			PlayGame.row = i;
			PlayGame.column = j;
			moveFound = true;
			}
		}
		
	public static void makeRandomMove()
		{
		if (moveFound == false)
			{
			makeRandomMoves();
			}
		}
	
	}

	
	
								
		