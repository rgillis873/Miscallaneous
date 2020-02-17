import java.util.*;

//Single or Multiplayer Tic Tac Toe Game
public class TicTacToe{
	String[][] whereToPlay = {{" "," "," "},{" "," "," "},{" "," "," "}};
	String[][] board = {{"1 |","2 |","3 "},{"4 |","5 |","6 "},{"7 |","8 |","9 "}};
	int[] moves = new int[9];
	int size = 0;
	
	//Executes an opponent random move in single player game
	public void randomMove(){
		if(size == 9){
			return;
		}
		Random rand = new Random();
		int newRand = rand.nextInt(9)+1;
		while(this.contains(newRand) == false){
			newRand = rand.nextInt(9)+1;
		}
		int row = (newRand-1)/3;
		this.moves[this.size]= newRand;
		this.size++;
		this.whereToPlay[row][(newRand-1)%3] = "o";
	}
	
	//Check if a player has won
	public boolean winner(){
		String rowOne = whereToPlay[0][0]+whereToPlay[0][1]+whereToPlay[0][2];
		String rowTwo = whereToPlay[1][0]+whereToPlay[1][1]+whereToPlay[1][2];
		String rowThree = whereToPlay[2][0]+whereToPlay[2][1]+whereToPlay[2][2];
		
		String colOne = whereToPlay[0][0]+whereToPlay[1][0]+whereToPlay[2][0];
		String colTwo = whereToPlay[0][1]+whereToPlay[1][1]+whereToPlay[2][1];
		String colThree = whereToPlay[0][2]+whereToPlay[1][2]+whereToPlay[2][2];
		
		String angleOne = whereToPlay[0][0]+whereToPlay[1][1]+whereToPlay[2][2];
		String angleTwo = whereToPlay[0][2]+whereToPlay[1][1]+whereToPlay[2][0];
		
		if(rowOne.equals("xxx") || rowTwo.equals("xxx") || rowThree.equals("xxx") || colOne.equals("xxx") || colTwo.equals("xxx") || colThree.equals("xxx") || angleOne.equals("xxx") || angleTwo.equals("xxx") ){
			System.out.println(Arrays.toString(this.whereToPlay[0]));
			System.out.println(Arrays.toString(this.whereToPlay[1]));
			System.out.println(Arrays.toString(this.whereToPlay[2]));
			System.out.println();
			System.out.println("Player x wins!");
			return true;
		}
		if(rowOne.equals("ooo") || rowTwo.equals("ooo") || rowThree.equals("ooo") || colOne.equals("ooo") || colTwo.equals("ooo") || colThree.equals("ooo") || angleOne.equals("ooo") || angleTwo.equals("ooo") ){
			System.out.println(Arrays.toString(this.whereToPlay[0]));
			System.out.println(Arrays.toString(this.whereToPlay[1]));
			System.out.println(Arrays.toString(this.whereToPlay[2]));
			System.out.println();
			System.out.println("Player o wins!");
			return true;
		}
		if(size == 9){
			System.out.println(Arrays.toString(this.whereToPlay[0]));
			System.out.println(Arrays.toString(this.whereToPlay[1]));
			System.out.println(Arrays.toString(this.whereToPlay[2]));
			System.out.println();
			System.out.println("It's a draw!");
			return true;
		}
		
		return false;
	}
	
	//Check if position has been filled
	public boolean contains(int move){
		for(int i = 0;i<this.size;i++){
			if(this.moves[i] == move){
				return false;
			}
		}
		return true;
	}
	
	//Make user move in a single player game
	public void singleGetMove(){
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Pick position for the move");
		int move = input.nextInt();
		while(move > 9 || move < 1  || this.contains(move)==false){
			System.out.println("Pick position for the move");
			move = input.nextInt();
		}
		System.out.println();
		int row = (move-1)/3;
		this.moves[this.size]= move;
		this.size++;
		this.whereToPlay[row][(move-1)%3] = "x";
		
	}
	
	//Make a move in a multi-player game
	public void multiGetMove(){
		Scanner input = new Scanner(System.in);
		System.out.println("Pick x or o");
		String player = input.next();
		
		while(!player.equals("x") && !player.equals("o")){
			System.out.println("Need to pick x or o");
			player = input.next();
		}
		
		System.out.println();	
		System.out.println("Pick position for the move");
		int move = input.nextInt();
		while(move > 9 || move < 1  || this.contains(move)==false){
			System.out.println("Pick position for the move");
			move = input.nextInt();
		}
		System.out.println();
		int row = (move-1)/3;
		this.moves[this.size]= move;
		this.size++;
		this.whereToPlay[row][(move-1)%3] = player;
		
	}
	
	//Display the game
	public void showPositions(){
		System.out.println(Arrays.toString(this.board[0]));
		System.out.println(Arrays.toString(this.board[1]));
		System.out.println(Arrays.toString(this.board[2]));
		
		System.out.println();
		
		System.out.println(Arrays.toString(this.whereToPlay[0]));
		System.out.println(Arrays.toString(this.whereToPlay[1]));
		System.out.println(Arrays.toString(this.whereToPlay[2]));
	}
	
	public static void main(String[] args){
		
		TicTacToe newGame = new TicTacToe();
		
		System.out.println("Choose A. Single-player Game or B. Multi-player Game");
		
		Scanner input = new Scanner(System.in);
		String choice = input.next();
		
		//If it's a single player game
		if(choice.equals("A")){
			System.out.println("You will be x's");
			while(newGame.winner()==false){
				newGame.showPositions();
				newGame.singleGetMove();
				newGame.randomMove();
			}
		}
		
		//If it's a multiplayer game
		if(choice.equals("B")){
			while(newGame.winner()==false){
				newGame.showPositions();
				newGame.multiGetMove();
			}
		}
		
	}
	
}