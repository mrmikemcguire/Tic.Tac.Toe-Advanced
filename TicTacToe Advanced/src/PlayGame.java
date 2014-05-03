public class PlayGame
	{
	static int currentColumnPlay;
	static int currentRowPlay;

	public static void main(String[] args)
		{
		Board.fillBoardWithBlankSpaces();
		//Board.fillTableWithZeroes();
		Board.displayBoard();
		HumanPlayer.choosePlayerMarker();
		
		while (!Board.isWonGame())
			{
			HumanPlayer.inputPlayerMove();
			Board.board[currentRowPlay][currentColumnPlay] = HumanPlayer.playerMarker;
			Board.valueTable[currentRowPlay][currentColumnPlay] = 2;
			ComputerPlayer.checkTile = true;
			ComputerPlayer.moveFound = false;
			Board.displayBoard();
			
			//ComputerPlayer.makeRandomMoves();
			ComputerPlayer.makeGoodMoves();
			//Board.board[currentRowPlay][currentColumnPlay] = HumanPlayer.computerMarker;
			Board.valueTable[currentRowPlay][currentColumnPlay] = 5;

			Board.displayBoard();
			}
		}
	
	public static boolean isIllegalMove()
		{
		if (!Board.board[currentRowPlay][currentColumnPlay].equals(" "))
			{
			return true;
			}
		return false;
		}
	}