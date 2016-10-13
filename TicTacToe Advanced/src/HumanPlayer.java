import java.util.Scanner;

public class HumanPlayer
	{
	public static String	playerMarker;
	public static String	computerMarker;
	public static String	playerMove;

	public static void inputPlayerMove()	
		{			
		do 
			{
			System.out.println("Please enter the column and row of your move (e.g. A1)");
			Scanner moveScan = new Scanner(System.in);
			playerMove = moveScan.nextLine();
			switch (playerMove.substring(0,1))
				{
				case "A":
				case "a":
						{
						PlayGame.row = 0;
						break;
						}
				case "B":
				case "b":
						{
						PlayGame.row = 1;
						break;
						}
				case "C": 
				case "c":
						{
						PlayGame.row = 2;
						break;
						}
				}
			PlayGame.column = Integer.parseInt(playerMove.substring(1)) - 1;
			System.out.println();
			}
				while (PlayGame.isIllegalMove());
		}
	
	public static void choosePlayerMarker()
		{
		System.out.println("Would you prefer playing X or O?");
		Scanner markerScan = new Scanner(System.in);
		playerMarker = markerScan.nextLine();
		
		if ((!"X".equals(playerMarker) && (!"O".equals(playerMarker))))
			{
			System.out.println("That is not a valid option.");
			}
		if ("X".equals(playerMarker))
			{
			computerMarker = "O";
			System.out.println("You will play " + playerMarker);
			}
		else 
			{
			computerMarker = "X";
			System.out.println("You will play O");
			}
		
		System.out.println("The computer will play " + computerMarker);
		System.out.println();
		}
	}