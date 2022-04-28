package tictactoe;
//The default constructor, which just creates the two-dimensional array and fills each slot 
//with ' ' (a blank space) and initializes the other attributes.
public class TicTacToeClass
{
	// Instance Variables
	private char[][] board; //Two-dimensional array of chars
	private int turns;		//An integer keeping track of the number of turns played this game 

	// Constructors
	public TicTacToeClass()
	{
		//Two-dimensional array of chars
		board = new char[3][3];
		//Keep track of number of turns
		turns = 0;
		//Create the visual of rows and columns of Tic Tac Toe board
		for ( int r=0; r<3; r++ )
			for ( int c=0; c<3; c++ )
				board[r][c] = ' ';
	}

	// Accessor Methods
	//Returns true if the letter passed in currently has three in a row. 
	//That is, isWinner('X') will return true if X has won, 
	//and isWinner('O') will return true if O has won .
	public boolean isWinner( char p )
	{
		//The only tricky part about the game is determining if a given person has won. 
		//The more straightforward way to do it takes 8 if statements.
		if(p =='X'){
			   if ((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||
			      (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||
			      (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') ||
			      (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||
			      (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||
			      (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') ||
			      (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||
			      (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') ){

				   return true;
			   }
			  
		}
			if(p =='O'){
				   if ((board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') ||
				      (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') ||
				      (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') ||
				      (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') ||
				      (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') ||
				      (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') ||
				      (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ||
				      (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') ){

					return true;
				   }
			}
		//If no winner yet
		return false;
	}
	//Returns true if nine turns have been played and false otherwise 
	public boolean isFull()
	{
		if(turns == 9) {
			return true;
		}
		return false;
	}
	//Returns true if all nine spaces are filled AND neither X nor O has won 
	public boolean isCat()
	{
		if((isFull()) && ((isWinner('X') == false) && (isWinner('O') == false))) {
			return true;
			
		}
		return false;	
	}
	//Returns true if the given row and column corresponds to a valid space on the board
	public boolean isValid( int r, int c )
	{
		if ( 0 <= r && r <= 2 && 0 <= c && c <= 2 )
			return true;
		else
			return false;
	}
	//Returns number of turns played so far
	public int numTurns()
	{
		return turns;
	}
	//Returns the character representing the piece at the given location. 
	//Should return either ' ', 'X', or 'O'. 
	public char playerAt( int r, int c )
	{
		if ( isValid(r,c) )
			return board[r][c];
		else
			return '@';
	}
	//Displays current board on the screen
	public void displayBoard()
	{
		System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("    --+-+--");
		System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("    --+-+--");
		System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		System.out.println("     0 1 2 ");
	}

	// Modifiers
	//Allows the given player to place their move at the given row and column. 
	//The row and column numbers are 0-based, so valid numbers are 0, 1, or 2 
	public void playMove( char p, int r, int c )
	{
		board[r][c] = p;
		
		turns += 1;
	}

}
