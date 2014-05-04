public class PlayGame
	{
	static int column;
	static int row;

	public static void main(String[] args)
		{
		Board.fillBoardWithBlankSpaces();
		//Board.fillTableWithZeroes();
		Board.displayBoard();
		HumanPlayer.choosePlayerMarker();
		
		while (!Board.isWonGame())
			{
			HumanPlayer.inputPlayerMove();
			Board.board[row][column] = HumanPlayer.playerMarker;
			Board.valueTable[row][column] = 2;
			ComputerPlayer.checkTile = true;
			ComputerPlayer.moveFound = false;
			Board.displayBoard();
			
			//ComputerPlayer.makeRandomMoves();
			
			ComputerPlayer.makeGoodMoves();
		System.out.println("The row is " + row);
		System.out.println("The column is " + column);
			
			Board.board[row][column] = HumanPlayer.computerMarker;
			Board.valueTable[row][column] = 5;
		

			Board.displayBoard();
			}
		}
	
	public static boolean isIllegalMove()
		{
		if (!Board.board[row][column].equals(" "))
			{
			return true;
			}
		return false;
		}
	}