import java.util.Random;
import java.util.Scanner;

public class ComputerPlayer
	{
	static int randomRow, randomColumn;
	static int x, y, row, col, k, lineSum;
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
			randomRow = (int)(Math.random() * 3);
			randomColumn = (int)(Math.random() * 3);	
	
			PlayGame.column = randomColumn;
			PlayGame.row = randomRow;
			PlayGame.isIllegalMove();
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
		checkForTie();
	
		return Board.board;
		}
	
	public static void checkForTie()
		{
		for(int row = 0; row < 3; row++)
			{
			for(int col = 0; col < 3; col++)
				{
				if (!Board.board[row][col].equals(" "))
					{
					counter++;
					System.out.println(counter);
					}
				
				}
			}
		
		if (counter == 9 && !Board.isWonGame())
			{
			System.out.println("It's a tie.");
			System.exit(0);
			}
		}
	
	public static void checkForWinningRowMove()
		{
		if(moveFound == false)
			{
			for (row = 0; row < 3; row++)		
				{
				lineSum = 0;
				for (col = 0; col < 3; col++)
					{
					lineSum += Board.valueTable [row][col];
					if (lineSum == 10)
						{
						for (col = 0; col < 3; col++)
							{
							if (Board.board [row][col].equals(" "))
								{
								Board.board[row][col] = HumanPlayer.computerMarker;
								PlayGame.row = row;
								PlayGame.column = col;
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
			for (col = 0; col < 3; col++)		
				{
				lineSum = 0;
				for (row = 0; row < 3; row++)
					{
					lineSum += Board.valueTable [row][col];
					if (lineSum == 10)
						{
						for (k = 0; k < 3; k++)
							{
							if (Board.board [row][col].equals(" "))
								{
								Board.board[row][col] = HumanPlayer.computerMarker;
								PlayGame.row = row;
								PlayGame.column = col;
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
			for (row = 0; row < 3; row++)
				{
				lineSum += Board.valueTable [row][row];
				if (lineSum == 10)
					{
					for (row = 0; row < 3; row++)
						{
						if (Board.board [row][row].equals(" "))
							{
							Board.board [row][row] = HumanPlayer.computerMarker;
							PlayGame.row = row;
							PlayGame.column = col;
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
			for (row = 0; row < 3; row++)
				{
				lineSum += Board.valueTable [row][2 - row];
				if (lineSum == 10)
					{
					for (row = 0; row < 3; row++)
						{
						if (Board.board [row][2 - row].equals(" "))
							{
							Board.board [row][2 - row] = HumanPlayer.computerMarker;
							PlayGame.row = row;
							PlayGame.column = col;
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
			for (row = 0; row < 3; row++)
				{
				lineSum = 0;
				for (col = 0; col < 3; col++)
					{
					lineSum += Board.valueTable [row][col];
					if (lineSum == 4)
						{
						for (col = 0; col < 3; col++)
							{
							if(Board.board [row][col].equals(" "))
								{
								Board.board [row][col] = HumanPlayer.computerMarker;
								PlayGame.row = row;
								PlayGame.column = col;
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
			for (col = 0; col < 3; col++)
				{
				lineSum = 0;
				for (row = 0; row < 3; row++)
					{
					lineSum += Board.valueTable [row][col];
					if (lineSum == 4)
						{
						for (row = 0; row < 3; row++)
							{
							if(Board.board [row][col].equals(" "))
								{
								Board.board [row][col] = HumanPlayer.computerMarker;
								PlayGame.row = row;
								PlayGame.column = col;
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
			for (row = 0; row < 3; row++)
				{
				lineSum += Board.valueTable [row][row];
				if (lineSum == 4)
					{
					for (row = 0; row < 3; row++)
						{
						if (Board.board [row][row].equals(" "))
							{
							Board.board [row][row] = HumanPlayer.computerMarker;
							PlayGame.row = row;
							PlayGame.column = row;
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
			for (row = 0; row < 3; row++)
				{
				lineSum += Board.valueTable [row][2 - row];
				if (lineSum == 4)
					{
					for (row = 0; row < 3; row++)
						{
						if (Board.board [row][2 - row].equals(" "))
							{
							Board.board [row][2 - row] = HumanPlayer.computerMarker;
							PlayGame.row = row;
							PlayGame.column = 2 - row;
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
			row = 1;
			row = 1;
			PlayGame.row = row;
			PlayGame.column = row;
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

	
	
								
		