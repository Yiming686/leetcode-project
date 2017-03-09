package Connect4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Connct4Game {

	static int rows = 6;
	static int cols = 7;
	static char[][] panelArray = new char[rows][cols]; ;
	static int turn = 1;
	static int gameCount = 0;
	static boolean hasWinner = false;
	static int iPos = 0;
	static int jPos = 0;

//	the player 1 places the piece 'x' while the player 2 places the piece 'o'. 
//	'vvvv' indicates where and how the player wins
	
	public static void main(String[] args) {
//		while(hasWinner == true){
//			hasWinner = false;
			resetPanelArray();
			printPanelArray();
			int placeCount = 1;
			while(placeCount <= rows * cols){
				placeAPiece();
//				checkForWinner();
				checkForFourXorOs();
				if(hasWinner == true) {
					if(turn == 1){
						System.out.println("Congratulations! Player 2 Wins! \n");
					}else{
						System.out.println("Congratulations! Player 1 Wins! \n");	
					}
					break;	
				}
				placeCount++;
			}
			gameCount++;
//		}
//		System.out.println("GameCount: "+gameCount);
		if(hasWinner == false) System.out.println("Game is Over! No Winners! \n");
		printPanelArray();
	}
	static void placeAPiece(){
		int x = new Random().nextInt(rows);
		int y = new Random().nextInt(cols);
		while(panelArray[x][y] =='x' || panelArray[x][y] =='o'){
			x = new Random().nextInt(rows);
 			y = new Random().nextInt(cols);
		}
		if(turn == 1){
			panelArray[x][y] = 'x';
		}else{
			panelArray[x][y] = 'o';
		}
		iPos = x;
		jPos = y;
		changeTurn();
	}
	static void resetPanelArray(){
		if(panelArray == null) return;
		int rows = panelArray.length;
		int cols = panelArray[0].length;
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				panelArray[i][j] = '*';
			}
		}
		
	}
	

	static public void changeTurn() {
		if (turn == 1) {
			turn = 2;
		} else {
			turn = 1;
		}
	}

    public static void checkForFourXorOs() {
//    	hasWinner = checkForFourXOs(panelArray, "xxxx") || checkForFourXOs(panelArray, "oooo");
//    	System.out.println("2: "+hasWinner);

    	hasWord(panelArray, iPos, jPos);
    }
    public static boolean checkForFourXOs(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        if(word == null || word.length() == 0)
            return false;
//        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for(int i = 0; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
            	if(hasWord(board, i , j)){
            		return true;
            	}
            }
        }
        return false;
    }
    static void setVs(char[][] board, List<int[]> list){
    	printPanelArray();
    	for(int[] arr : list){
    		board[arr[0]][arr[1]] = 'v';
    	}
    }
    private static boolean hasWord(char[][] board, int i, int j) {
		// TODO Auto-generated method stub
    	int x = i, y = j;
    	String str = "";
    	List<int[]> list = new ArrayList<>();
    	while(x < i+4 && x > 0 && x < board.length && y > 0 && y < board[0].length){
    		int[] arr= {x, y};
    		list.add(arr);
    		str+=board[x][y];
//    		System.out.println(""+str);
    		if(str.equals("xxxx") || str.equals("oooo")){
    			setVs(board, list);
    			return true;
    		} 
    		x++;
    	}
    	list.clear();
    	x = i; y = j;
    	str = "";
    	while(x < i+4 && y < j+4 && x > 0 && x < board.length && y > 0 && y < board[0].length){
//    		System.out.println(MessageFormat.format("i:j:x:y  {0},{1},{2},{3}", i, j, x, y));
    		int[] arr= {x, y};
    		list.add(arr);
    		str+=board[x][y];
//    		System.out.println(""+str);
    		if(str.equals("xxxx") || str.equals("oooo")){
    			setVs(board, list);
    			return true;
    		}
    		x++;y++;
    	}
    	list.clear();
    	x = i; y = j;
    	str = "";
    	while(y < j+4 && x > 0 && x < board.length && y > 0 && y < board[0].length){
    		int[] arr= {x, y};
    		list.add(arr);
    		str+=board[x][y];
//    		System.out.println(""+str);
    		if(str.equals("xxxx") || str.equals("oooo")){
    			setVs(board, list);
    			return true;
    		}
    		y++;
    	}
    	list.clear();
    	x = i; y = j;
    	str = "";
    	while(x > i-4 && y < j+4 && x > 0 && x < board.length && y > 0 && y < board[0].length){
    		int[] arr= {x, y};
    		list.add(arr);
    		str+=board[x][y];
//    		System.out.println(""+str);
    		if(str.equals("xxxx") || str.equals("oooo")){
    			setVs(board, list);
    			return true;
    		}
    		x--;y++;
    	}
    	list.clear();
    	
    	x = i; y = j;
    	str = "";
    	while(x > i-4 && x > 0 && x < board.length && y > 0 && y < board[0].length){
    		int[] arr= {x, y};
    		list.add(arr);
    		str+=board[x][y];
//    		System.out.println(""+str);
    		if(str.equals("xxxx") || str.equals("oooo")){
    			setVs(board, list);
    			return true;
    		}
    		x--;
    	}
    	list.clear();
    	
    	x = i; y = j;
    	str = "";
    	while(x > i-4 && y > j-4 && x > 0 && x < board.length && y > 0 && y < board[0].length){
    		int[] arr= {x, y};
    		list.add(arr);
    		str+=board[x][y];
//    		System.out.println(""+str);
    		if(str.equals("xxxx") || str.equals("oooo")){
    			setVs(board, list);
    			return true;
    		}
    		x--;y--;
    	}
    	list.clear();
    	
    	x = i; y = j;
    	str = "";
    	while(y > j-4  && x > 0 && x < board.length && y > 0 && y < board[0].length){
    		int[] arr= {x, y};
    		list.add(arr);
    		str+=board[x][y];
//    		System.out.println(""+str);
    		if(str.equals("xxxx") || str.equals("oooo")){
    			setVs(board, list);
    			return true;
    		}
    		y--;
    	}
    	list.clear();
    	
    	x = i; y = j;
    	str = "";
    	while(x < i+4 && y > j-4  && x > 0 && x < board.length && y > 0 && y < board[0].length){
    		int[] arr= {x, y};
    		list.add(arr);
    		str+=board[x][y];
//    		System.out.println(""+str);
    		if(str.equals("xxxx") || str.equals("oooo")){
    			setVs(board, list);
    			return true;
    		}
    		x++;y--;
    	}
    	list.clear();
    	
    	return false;
	}
    
	static void checkForWinner() {
		// check if a horizontal winner
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				if (panelArray[i][j] != '*' && panelArray[i][j] == panelArray[i][j + 1]
						&& panelArray[i][j] == panelArray[i][j + 2] && panelArray[i][j] == panelArray[i][j + 3]) {

					hasWinner = true;
					panelArray[i][j] = 'v';
					panelArray[i][j + 1] = 'v';
					panelArray[i][j + 2] = 'v';
					panelArray[i][j + 3] = 'v';
				}
			}
		}
		// check if a vertical winner
		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < 3; i++) {
				if (panelArray[i][j] != '*' && panelArray[i][j] == panelArray[i + 1][j]
						&& panelArray[i][j] == panelArray[i + 2][j] && panelArray[i][j] == panelArray[i + 3][j]) {

					hasWinner = true;
					panelArray[i][j] = 'v';
					panelArray[i + 1][j] = 'v';
					panelArray[i + 2][j] = 'v';
					panelArray[i + 3][j] = 'v';
				}
			}
		}
		for (int i = 5; i > 2; i--) {
			for (int j = 0; j < 4; j++) {
				// j=0 diagonals
				if (panelArray[i][j] != '*' && panelArray[i][j] == panelArray[i - 1][j + 1]
						&& panelArray[i][j] == panelArray[i - 2][j + 2]
						&& panelArray[i][j] == panelArray[i - 3][j + 3]) {

					hasWinner = true;
					panelArray[i][j] = 'v';
					panelArray[i - 1][j + 1] = 'v';
					panelArray[i - 2][j + 2] = 'v';
					panelArray[i - 3][j + 3] = 'v';

				}
				if (j == 0) {
					// j=1-4 diagonals
					if (panelArray[i][j + 1] != '*' && panelArray[i][j + 1] == panelArray[i - 1][j + 2]
							&& panelArray[i][j + 1] == panelArray[i - 2][j + 3]
							&& panelArray[i][j + 1] == panelArray[i - 3][j + 4]) {

						hasWinner = true;
						panelArray[i][j + 1] = 'v';
						panelArray[i - 1][j + 2] = 'v';
						panelArray[i - 2][j + 3] = 'v';
						panelArray[i - 3][j + 4] = 'v';
					}
					// j=2-5 diagonals
					if (panelArray[i][j + 2] != '*' && panelArray[i][j + 2] == panelArray[i - 1][j + 3]
							&& panelArray[i][j + 2] == panelArray[i - 2][j + 4]
							&& panelArray[i][j + 2] == panelArray[i - 3][j + 5]) {

						hasWinner = true;
						panelArray[i][j + 2] = 'v';
						panelArray[i - 1][j + 3] = 'v';
						panelArray[i - 2][j + 4] = 'v';
						panelArray[i - 3][j + 5] = 'v';
					}
					// j=3-6 diagonals
					if (panelArray[i][j + 3] != '*' && panelArray[i][j + 3] == panelArray[i - 1][j + 4]
							&& panelArray[i][j + 3] == panelArray[i - 2][j + 5]
							&& panelArray[i][j + 3] == panelArray[i - 3][j + 6]) {

						hasWinner = true;
						panelArray[i][j + 3] = 'v';
						panelArray[i - 1][j + 4] = 'v';
						panelArray[i - 2][j + 5] = 'v';
						panelArray[i - 3][j + 6] = 'v';
					}
				}
			}
		}
		// check if a diagonal winner (negative slope)
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				// j=0-3 diagonal
				if (panelArray[i][j] != '*' && panelArray[i][j] == panelArray[i + 1][j + 1]
						&& panelArray[i][j] == panelArray[i + 2][j + 2]
						&& panelArray[i][j] == panelArray[i + 3][j + 3]) {

					hasWinner = true;
					panelArray[i][j] = 'v';
					panelArray[i + 1][j + 1] = 'v';
					panelArray[i + 2][j + 2] = 'v';
					panelArray[i + 3][j + 3] = 'v';
				}
				if (j == 0) {
					// j=1-4 diagonal
					if (panelArray[i][j + 1] != '*' && panelArray[i][j + 1] == panelArray[i + 1][j + 2]
							&& panelArray[i][j + 1] == panelArray[i + 2][j + 3]
							&& panelArray[i][j + 1] == panelArray[i + 3][j + 4]) {

						hasWinner = true;
						panelArray[i][j + 1] = 'v';
						panelArray[i + 1][j + 2] = 'v';
						panelArray[i + 2][j + 3] = 'v';
						panelArray[i + 3][j + 4] = 'v';
					}
					// j=2-5 diagonal
					if (panelArray[i][j + 2] != '*' && panelArray[i][j + 2] == panelArray[i + 1][j + 3]
							&& panelArray[i][j + 2] == panelArray[i + 2][j + 4]
							&& panelArray[i][j + 2] == panelArray[i + 3][j + 5]) {

						hasWinner = true;
						panelArray[i][j + 2] = 'v';
						panelArray[i + 1][j + 3] = 'v';
						panelArray[i + 2][j + 4] = 'v';
						panelArray[i + 3][j + 5] = 'v';
					}
					// j=3-6 diagonal
					if (panelArray[i][j + 3] != '*' && panelArray[i][j + 3] == panelArray[i + 1][j + 4]
							&& panelArray[i][j + 3] == panelArray[i + 2][j + 5]
							&& panelArray[i][j + 3] == panelArray[i + 3][j + 6]) {

						hasWinner = true;
						panelArray[i][j + 3] = 'v';
						panelArray[i + 1][j + 4] = 'v';
						panelArray[i + 2][j + 5] = 'v';
						panelArray[i + 3][j + 6] = 'v';
					}
				}
			}
		}
	}
	
	static void printPanelArray(){
		String str = "";
		if(panelArray == null)  throw new IllegalArgumentException("Null or Empty Matrix!");
		if(panelArray.length == 0) str =  "[]";
		int strLen = 0;
		for(int i = 0; i < panelArray.length; i++){
			for(int j = 0; j < panelArray[0].length; j++){
				strLen = Math.max(strLen, (String.valueOf(panelArray[i][j])).length());
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < panelArray.length; i++){
			sb.append(fromRowOfMatrixToString(panelArray, i));
 		}
		str = sb.toString();
		System.out.println(str);
	}
	
	static String fromRowOfMatrixToString(char[][] arr, int row){
		
		if(arr == null) throw new IllegalArgumentException("Null Matrix!");
		if(arr.length == 0) throw new IllegalArgumentException("Empty Matrix!");
		if(row <0 || row >= arr.length) throw new IllegalArgumentException("Illegal Arguments!");
		int valStrWidth = 0;
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				valStrWidth = Math.max(valStrWidth, (String.valueOf(arr[i][j])).length());
			}
		}
		String formatStr = " %" +valStrWidth+ "s, ";

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < arr[row].length; i++){
			sb.append(String.format(formatStr, arr[row][i]));
		}
		sb.append("]");
		sb.append("\n");
		return sb.toString();
	}

	

}
