public class PlayGame
	{
	static int currentColumnPlay;
	static int currentRowPlay;

	public static void main(String[] args)
		{
		Board.fillBoardWithBlankSpaces();
		Board.displayBoard();
		HumanPlayer.choosePlayerMarker();
		
		while (!Board.isWonGame())
			{
			HumanPlayer.inputPlayerMove();
			Board.board[currentRowPlay][currentColumnPlay] = HumanPlayer.playerMarker;
			Board.displayBoard();
			
			ComputerPlayer.makeRandomMoves();
			Board.board[currentRowPlay][currentColumnPlay] = HumanPlayer.computerMarker;
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