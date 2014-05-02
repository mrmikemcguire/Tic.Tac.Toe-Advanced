public class ComputerPlayer
	{
	static int randomRow;
	static int randomColumn;
	
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
	}