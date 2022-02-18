package Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




/**

Global Utils for TreeNode

 *
 */
public class TreeNodeUtils3 {
	
	public static void main(String[] args) {
//		TreeNodeUtil.printTree(COMPLETE_TREE);
//		TreeNodeUtil.printTree(ONLY_LEFT_CHILD_TREE);
//		TreeNodeUtil.printTree(ONLY_RIGHT_CHILD_TREE);
		TreeNodeUtils3.printTree(GENERAL_TREE);
//		String TreeNodeStr ="{1,2,8,#,#,-5555,-2,1,2,8,#,#,-5555,-2}";
		String TreeNodeStr ="{7,299999999,299999999}";
//		String  TreeNodeStr ="{-15,5,6,-8,1,3,9,2,6,#,#,#,#,#,0,#,#,#,#,4,-1,#,#,10}";
//		 TreeNodeStrIn ="{-15,5,6,-8,1,3,9,2,6}";

//		String TreeNodeStrIn ="{1,9,8}";
//		String  TreeNodeStr = COMPLETE_TREE;
		TreeNode3<Integer> root3 = TreeNodeUtils3.fromStringToTree(TreeNodeStr, TreeNode3.class, Integer.class);
//		TreeNodeUtil.printTree(root3);

		
		String TreeNodeStrIn ="{1,2,8,#,#,-5,2}";
//		String TreeNodeStrIn ="{1,9,8}";

//		TreeNode<Integer> root2 = TreeNodeUtil.fromStringToTree(TreeNodeStrIn); //.fromStringToTree(TreeNodeStrIn);
		TreeNode3<Integer> root2 = TreeNodeUtils3.fromStringToTree(TreeNodeStrIn, TreeNode3.class, Integer.class); //.fromStringToTree(TreeNodeStrIn);
		System.out.println(""+fromTreeToString(root2));
//		TreeNode<Integer> root = TreeNode.fromStringToTree(TreeNodeStrIn);
//		System.out.println(""+maxPathSum2(root));

		System.out.println("Goo");
		TreeNode3<Integer> root = fromStringToTree("{1,2,3}", TreeNode3.class, Integer.class);
		System.out.println(""+fromTreeToString(root));
//		TreeNode<String> root2 = fromStringToTree("{1,2,3}");
//		System.out.println(""+convertToString(root2));
	}
	
	public static class TreeNode3<T> {
		public T val;
		public TreeNode3<T> left;
		public TreeNode3<T> right;
		
		@JsonCreator
		public TreeNode3(T val) {
			super();
			this.val = val;
		}
		public TreeNode3() {
			super();
		}
		public T getVal() {
			return val;
		}
		public void setVal(T val) {
			this.val = val;
		}
		public TreeNode3<T> getLeft() {
			return left;
		}
		public void setLeft(TreeNode3<T> left) {
			this.left = left;
		}
		public TreeNode3<T> getRight() {
			return right;
		}
		public void setRight(TreeNode3<T> right) {
			this.right = right;
		}
		
	}
	
		
	public static final String LEFT_SPACES_OF_TREE = "    ";
	public static final char DEFAULT_CHAR = '\u0000';
	public static final char SPACE_CHAR = ' ';
	public static final char DELIMITER_CHAR = '|';
	public static final String SPACE = " ";
	public static final char EQUAL = '=';
	public static final char DASH = '-';
	
	public static final ObjectMapper objectMapper = new ObjectMapper();
	
	public static TreeNode3<Integer> COMPLETE_TREE =  fromStringToTree("{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}", TreeNode3.class, Integer.class);
	public static TreeNode3<Integer> ONLY_LEFT_CHILD_TREE = fromStringToTree("{1,2,#,3,#,4,#,5,#,6,#}", TreeNode3.class, Integer.class);
	public static TreeNode3<Integer> ONLY_RIGHT_CHILD_TREE = fromStringToTree("{1,#,2,#,3,#,4,#,5,#,6,#}", TreeNode3.class, Integer.class);
	public static TreeNode3<Integer> GENERAL_TREE = fromStringToTree("{1,2,3,4,5,6,7,8,9,10,#,#,11,12,13,14,#,15,16,#,#,#,#,17,18,#,19,#,#,#,#,20,21,22,23,#,#,#,#,#,#,#,24,25}", TreeNode3.class, Integer.class);
	
	
	static class TreeInfo<T>{
		//global, never change
		char[][] finalCharMatrix;
		char[][] charMatrix;
		List<char[][]> trimedCharMatrixList = new ArrayList<>();
		String[][] matrix;
		int[] numOfNodesByLevel;//
		int widthInTotal;//widthOfAllNodeValues
		int numOfNodesInTotal;//numOfNodesInTheTree
		int maxWidth;
		String connectionStyle;
		boolean enableLorR;
		int height;
		boolean toShrink; // by default, false
		int max2Parent;
		char[] equalDelimiters;
		char[] dashDelimiters;
		String leftSpacesOfTree = LEFT_SPACES_OF_TREE;
		Map<T, LevelInfo> LevelLevelInfoMap = new HashMap<>();
		Map<TreeNode3<T>, TreeNodeInfo<T>> NodeNodeInfoMap = new HashMap<>();
		
		List<T> list = new ArrayList<>();
	}
	
	static class LevelInfo{
		int level;//PK
		int numOfNodes;
	}
	
	static class TreeNodeInfo<T>{
		TreeNode3<T> node;//PK
		String flag;
		int level;
		int left;
		int right;
	}

	//worked
	public static <T> void printTree(TreeNode3<T> root) {
		if(root == null) {
			return;
		}

		int height = calcHeight(root);
		int maxSpaces = (int)Math.pow(2, height);

		int rowEx = 2; //by default, add extra / \  / \  or -----^-----
		int colEx = 2; //by default, if no enough space, extend the columns

		String[][] matrix = new String[rowEx*height][colEx*maxSpaces];

//		determine how to extend columns
		boolean hasEnoughSpace = false;// by default, not enough space
		TreeInfo<T> treeInfo = new TreeInfo<>();
		TreeNodeInfo<T> treeNodeInfo = new TreeNodeInfo<T>(); 
//		find colEx: if not hasEnoughSpace, colEx++
		while(!hasEnoughSpace) {
//				System.out.println("colEx: "+ colEx);
			treeInfo.matrix = new String[rowEx*height][colEx*maxSpaces];
			treeInfo.numOfNodesByLevel = new int[height];
			treeInfo.connectionStyle = "DASH";
			treeInfo.enableLorR = true;
			treeInfo.height = height;
			treeInfo.toShrink = false;
			treeInfo.max2Parent = 0;

			treeNodeInfo.flag = "[ROOT]";
			treeNodeInfo.level = 1;
			treeNodeInfo.left = 0;
			treeNodeInfo.right = colEx*maxSpaces-1;
			treeInfo.list.clear();
			hasEnoughSpace = hasEnoughSpace(treeInfo, root, "[ROOT]",1, 0, colEx*maxSpaces-1 );
//				hasEnoughSpace = hasEnoughSpace(root, treeInfo, treeNodeInfo);
			System.out.println("list: "+treeInfo.list);
			colEx++;
		}
		colEx--;
		
		final int rows = rowEx*height;
		final int cols = colEx*maxSpaces;
		
//		determine how to shrink the entire tree, so relocate the position of root
		treeInfo.max2Parent = 40;
		treeInfo.toShrink = false;//true; //false; //true; // true
		if(treeInfo.toShrink) {
			boolean isSmallest = false;// by default, not enough space
			treeInfo.max2Parent = 1;
			while(!isSmallest) {
//					System.out.println("max2Parent: "+ treeInfo.max2Parent);
				treeInfo.matrix = new String[rows][cols];
				treeInfo.numOfNodesByLevel = new int[height];
				treeInfo.connectionStyle = "DASH";
				treeInfo.enableLorR = true;
				treeInfo.height = height;
				treeInfo.toShrink = true;

				treeNodeInfo.flag = "[ROOT]";
				treeNodeInfo.level = 1;
				treeNodeInfo.left = 0;
				treeNodeInfo.right = colEx*maxSpaces-1;

				isSmallest = hasEnoughSpace(treeInfo, root, "[ROOT]",1, 0, colEx*maxSpaces-1 );
//					isSmallest = hasEnoughSpace(root, treeInfo, treeNodeInfo);

				treeInfo.max2Parent++;
			}
			
			treeInfo.max2Parent = treeInfo.max2Parent - 1;
	
		}
		System.out.println("max2Parent: "+treeInfo.max2Parent);
		
		char[] equalDelimiters = new char[3*maxSpaces];
		Arrays.fill(equalDelimiters, '=');
		char[] dashDelimiters = new char[3*maxSpaces];
		Arrays.fill(dashDelimiters, '-');
//		System.out.println("=== PRINT BINARY TREE ===" + new String(equalDelimiters) );
//		System.out.println("Height: " + height + ", MaxSpaces: " +maxSpaces);
//		System.out.println("Rows: " + matrix.length + ", Cols: " +matrix[0].length);
		
		//"ValueWidth, SumOfWidth: "+maxWidth[0] + ", NumOfValues: " + maxWidth[1] + ", maxWidth: " + maxWidth[2] + ", Random width[0--maxWith): " + width, numOf
		
//			 set for all cases
		treeInfo.toShrink = true; //false; // true;

//	 	FIRST: Print Tree in Default Way
		treeInfo.enableLorR = true;
		treeInfo.connectionStyle = "SLASH";
		treeInfo.numOfNodesByLevel = new int[height];
		treeInfo.matrix = new String[rows][cols];
		treeInfo.charMatrix = new char[rows][cols];
		//newly added, built to print the whole tree in an array of Trees
		treeInfo.finalCharMatrix = new char[rows][cols]; 
		
		treeInfo.equalDelimiters = equalDelimiters;
		treeInfo.dashDelimiters = dashDelimiters;
		hasEnoughSpace(treeInfo, root, "[ROOT]",1, 0, cols - 1 );
		printBinaryTreeFromMatrix2(treeInfo);//First Print
		
//		SECOND: Print Tree in Default Way
		treeInfo.enableLorR = false;
		treeInfo.connectionStyle = "DASH";
		treeInfo.numOfNodesByLevel = new int[height];
		treeInfo.matrix = new String[rows][cols];
		treeInfo.charMatrix = new char[rows][cols];
		treeInfo.equalDelimiters = equalDelimiters;
		treeInfo.dashDelimiters = dashDelimiters;
		hasEnoughSpace(treeInfo, root, "[ROOT]",1, 0, cols - 1 );
		printBinaryTreeFromMatrix2(treeInfo);//Second Print

//		THIRD: 
		treeInfo.enableLorR = false;
		treeInfo.connectionStyle = "SLASH";
		treeInfo.numOfNodesByLevel = new int[height];
		treeInfo.matrix = new String[rows][cols];
		treeInfo.charMatrix = new char[rows][cols];
		treeInfo.equalDelimiters = equalDelimiters;
		treeInfo.dashDelimiters = dashDelimiters;
		hasEnoughSpace(treeInfo, root, "[ROOT]",1, 0, cols - 1 );
		printBinaryTreeFromMatrix2(treeInfo);//Third Print

//		FOURTH:
//		boolean enableLorR = true;
//		String connectionStyle = "DASH";
//		buildTree(enableLorR, connectionStyle);
		treeInfo.enableLorR = false;
		treeInfo.connectionStyle = "DASH";
		treeInfo.numOfNodesByLevel = new int[height];
		treeInfo.matrix = new String[rows][cols];
		treeInfo.charMatrix = new char[rows][cols];
		treeInfo.equalDelimiters = equalDelimiters;
		treeInfo.dashDelimiters = dashDelimiters;
		hasEnoughSpace(treeInfo, root, "[ROOT]",1, 0, cols - 1 );
		printBinaryTreeFromMatrix2(treeInfo);//Fourth Print
		
//      PRINT: A ARRAY OF TREES
		print(treeInfo);

	}
		

	private static<T> void print(TreeInfo<T> treeInfo ) {
		// TODO Auto-generated method stub
		List<char[][]> trimedCharMatrixList = treeInfo.trimedCharMatrixList;
		if(trimedCharMatrixList == null || trimedCharMatrixList.size() == 0) {
			return;
		}
		char[][] arr = trimedCharMatrixList.get(0);
		int rows = arr.length;
		
		String string = SPACE + SPACE + DELIMITER_CHAR + SPACE +SPACE;
		char[][] delimterArr = new char[rows][string.length()];
		for(int i = 0; i < arr.length; i++) {
			delimterArr[i] = string.toCharArray();
		}
//		System.out.println(""+Matrix.fromMatrixToString(delimterArr));
		
		int maxNumOfNodes = 0;
		for(int val : treeInfo.numOfNodesByLevel) {
			maxNumOfNodes = Math.max(maxNumOfNodes, val);
		}
		int widthOfLevel = String.valueOf(rows).length();
		int widthOfNumOfNodes = String.valueOf(maxNumOfNodes).length();
		
		string = "level: "+ String.valueOf(rows) + ", Num: " + maxNumOfNodes;
		char[][] leadingArr = new char[rows][string.length()]; 
		for(int i = 0; i < arr.length; i++) {
			String str = "";
			if(i % 2 == 0) {
				str += String.format("level: %-"+widthOfLevel+"d, Num: %-"+widthOfNumOfNodes+"d",(i/2+1), treeInfo.numOfNodesByLevel[i/2]);
				leadingArr[i] = str.toCharArray(); 
			}else {
				Arrays.fill(leadingArr[i], SPACE_CHAR);
			}
		}
//		System.out.println(""+Matrix.fromMatrixToString(leadingArr));
		
		string = "";
		string += new String(delimterArr[0]);
		string += new String(leadingArr[0]);
		string += new String(delimterArr[0]);
		for(int j = 0; j < trimedCharMatrixList.size(); j++) {
			char[][] trimedCharMatrix = trimedCharMatrixList.get(j);
			string += new String(trimedCharMatrix[0]); //, 0, trimedCharMatrix[i].length);
			string += new String(delimterArr[0]);
		}
		char[] headAndfooterArr = string.toCharArray();
		Arrays.fill(headAndfooterArr, EQUAL);
		String headAndfooter = new String(headAndfooterArr);
		System.out.println(headAndfooter);

		for(int i = 0; i < arr.length; i++) {
			string = "";
			string += new String(delimterArr[i]);
			string += new String(leadingArr[i]);
			string += new String(delimterArr[i]);
			for(int j = 0; j < trimedCharMatrixList.size(); j++) {
				char[][] trimedCharMatrix = trimedCharMatrixList.get(j);
				string += new String(trimedCharMatrix[i]); //, 0, trimedCharMatrix[i].length);
				string += new String(delimterArr[i]);
			}
			System.out.println(string);
		}
		System.out.println(headAndfooter);
	}

	private static <T> boolean hasEnoughSpace(TreeNode3<T> root, TreeNodeInfo<T> rootInfo, LevelInfo levelInfo, TreeInfo<T> treeInfo) {
		if(root == null) {
			return true;
		}
		 String flag = rootInfo.flag;
		 int level = rootInfo.level;
		 int left = rootInfo.left;
		 int right = rootInfo.right;
//			relocate mid if needed
		treeInfo.numOfNodesByLevel[level-1]++;
		int mid = left + (right - left)/2;
		int width = String.valueOf(root.val).length();
		treeInfo.widthInTotal += width;
		treeInfo.numOfNodesInTotal++;
		treeInfo.maxWidth = Math.max(treeInfo.maxWidth, width);

		if(treeInfo.enableLorR) {//if enableLorR, add L or R
			width += 3;
		}
		int delta = 0;
		int maxDiff = 1;
		if(mid + width - 1 >= right) {
			delta = -(mid + width - 1 - right + maxDiff);
		}
		if(mid + delta < left) {
			return false;
		}
		mid = mid + delta;
		
//			shink tree
		if(treeInfo.toShrink) {
			int start = mid;
			int end = mid + width - 1 ;
//			int max2Parent = 4 * (height - level)+4;
//			int max2Parent = 0;
			if(flag.equals("[L]") && right - end >= treeInfo.max2Parent)  {
//				mid + width - 1 = right - max2Parent;
				mid  = right - treeInfo.max2Parent - width + 1;
			}else if(flag.equals("[R]") && mid - left >= treeInfo.max2Parent){
//				mid = left + max2Parent;
				mid  = left + treeInfo.max2Parent;
			}
		}

//			fill values
		if(treeInfo.enableLorR) {//if enableLorR, add L or R
			treeInfo.matrix[2*(level -1)][mid] = ""+root.val + flag;
		}else {
			treeInfo.matrix[2*(level -1)][mid] = ""+root.val;
		}
				
// add connections
		if(flag.equals("[L]"))  { 
			if(treeInfo.connectionStyle.equals("DASH")) {
				Arrays.fill(treeInfo.matrix[2*(level -1)-1], mid, right, "-");	
				treeInfo.matrix[2*(level -1)-1][right] = "^";
				treeInfo.matrix[2*(level -1)-1][mid] = "+";
			}else {
				treeInfo.matrix[2*(level -1)-1][mid + (right - mid)/2] = "/";
			}
			
		}else if(flag.equals("[R]")){
			if(treeInfo.connectionStyle.equals("DASH")) {
				Arrays.fill(treeInfo.matrix[2*(level -1)-1], left, mid, "-");
				treeInfo.matrix[2*(level -1)-1][left] = "^";
				treeInfo.matrix[2*(level -1)-1][mid] = "+";
			}else {
				treeInfo.matrix[2*(level -1)-1][left + (mid - left)/2 ] = "\\";
			}
		}
//			boolean leftHasEnoughSpace = hasEnoughSpace(treeInfo, root.left,"[L]", level + 1, left, mid  );
		boolean leftHasEnoughSpace = hasEnoughSpace(root.left, rootInfo, levelInfo, treeInfo);
		if(!leftHasEnoughSpace) {
			return leftHasEnoughSpace;
		}
//			boolean rightHasEnoughSpace = hasEnoughSpace(treeInfo, root.right, "[R]", level + 1, mid, right);
		boolean rightHasEnoughSpace = hasEnoughSpace(root.right, rootInfo, levelInfo, treeInfo);


		if(!rightHasEnoughSpace) {
			return rightHasEnoughSpace;
		}
		return true;			
	}

		
	private static<T> boolean hasEnoughSpace(TreeInfo<T> treeInfo, TreeNode3<T> root, String flag, int level, int left, int right) {
		if(root == null) {
			return true;
		}
//			relocate mid if needed
		treeInfo.numOfNodesByLevel[level-1]++;
		int mid = left + (right - left)/2;
		int width = String.valueOf(root.val).length();
		treeInfo.widthInTotal += width;
		treeInfo.numOfNodesInTotal++;
		treeInfo.maxWidth = Math.max(treeInfo.maxWidth, width);

		if(treeInfo.enableLorR) {//if enableLorR, add L or R
			width += 3; // get from the string ???
		}
		int delta = 0;
		int maxDiff = 1;
		int diff = mid + width - 1 - right;
//		if(mid + width - 1 >= right) {
		if(diff >= 0) {			
			delta = -(mid + width - 1 - right + maxDiff);
			if(mid + delta < left) {
				treeInfo.list.add(root.val);				
				return false;
			}
			mid = mid + delta;
		}else if( Math.abs(diff) > 3 ) {
//			mid = right - 3 - width + 1;
		}
		
//			shink tree
		if(treeInfo.toShrink) {
			int start = mid;
			int end = mid + width - 1 ;
//			int max2Parent = 4 * (height - level)+4;
//			int max2Parent = 0;
			if(flag.equals("[L]") && right - end >= treeInfo.max2Parent)  {
//				mid + width - 1 = right - max2Parent;
				mid  = right - treeInfo.max2Parent - width + 1;
			}else if(flag.equals("[R]") && mid - left >= treeInfo.max2Parent){
//				mid = left + max2Parent;
				mid  = left + treeInfo.max2Parent;
			}
		}

//			fill values
		if(treeInfo.enableLorR) {//if enableLorR, add L or R
			treeInfo.matrix[2*(level -1)][mid] = ""+root.val + flag;
		}else {
			treeInfo.matrix[2*(level -1)][mid] = ""+root.val;
		}
				
// add connections
		if(flag.equals("[L]"))  { 
			if(treeInfo.connectionStyle.equals("DASH")) {
				Arrays.fill(treeInfo.matrix[2*(level -1)-1], mid, right, "-");	
				treeInfo.matrix[2*(level -1)-1][right] = "^";
				treeInfo.matrix[2*(level -1)-1][mid] = "+";
			}else {
				treeInfo.matrix[2*(level -1)-1][mid + (right - mid)/2] = "/";
			}
			
		}else if(flag.equals("[R]")){
			if(treeInfo.connectionStyle.equals("DASH")) {
				Arrays.fill(treeInfo.matrix[2*(level -1)-1], left, mid, "-");
				treeInfo.matrix[2*(level -1)-1][left] = "^";
				treeInfo.matrix[2*(level -1)-1][mid] = "+";
			}else {
				treeInfo.matrix[2*(level -1)-1][left + (mid - left)/2 ] = "\\";
			}
		}
		boolean leftHasEnoughSpace = hasEnoughSpace(treeInfo, root.left,"[L]", level + 1, left, mid  );
		if(!leftHasEnoughSpace) {
			return leftHasEnoughSpace;
		}
		boolean rightHasEnoughSpace = hasEnoughSpace(treeInfo, root.right, "[R]", level + 1, mid, right);

		if(!rightHasEnoughSpace) {
			return rightHasEnoughSpace;
		}
		return true;			
	}


	private static <T> void printBinaryTreeFromMatrix2(TreeInfo<T> treeInfo) {
		String[][] matrix =  treeInfo.matrix;
		char[][] charMatrix = treeInfo.charMatrix;
		
		int width = new Random().nextInt(treeInfo.maxWidth) + 1;
		
		//check charMatrix columns
		int expected = treeInfo.maxWidth * treeInfo.numOfNodesInTotal;//
		int actual = charMatrix[0].length;
		int count = 1;//放大系数
//			while(expected  >= count * actual) {
//				count++;
//			}
		charMatrix = new char[2*treeInfo.height][count * actual];

//		Matrix.fromMatrixToString(matrix);
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == null) {
					if(charMatrix[i][j*count ] == DEFAULT_CHAR) {
						charMatrix[i][j*count] = SPACE_CHAR ;
					}
				}else {
					char[] arr = matrix[i][j].toCharArray();
					for(int k = 0; k < arr.length; k++) {
						charMatrix[i][j*count+k] = arr[k] ;
					}
				}
			}
		}
		int leftMost = charMatrix[0].length - 1;
		int rightMost = 0;
		
		for(int i = 0; i < charMatrix.length; i++) {
			for(int j = 0; j < charMatrix[0].length; j++) {
				if(charMatrix[i][j] != SPACE_CHAR) {
					leftMost = Math.min(leftMost, j);
					rightMost = Math.max(rightMost, j);
				}
				
			}
		}
		int colLen =  rightMost - leftMost + 1;
		char[][] trimedMatrix = new char[charMatrix.length][colLen];
		for(int i = 0; i < charMatrix.length; i++) {
			System.arraycopy(charMatrix[i], leftMost, trimedMatrix[i], 0, colLen); 
		}
		treeInfo.trimedCharMatrixList.add(trimedMatrix);
	}
	
	private static <T> void printBinaryTreeFromMatrix(TreeInfo<T> treeInfo) {
		String[][] matrix =  treeInfo.matrix;
		char[][] charMatrix = treeInfo.charMatrix;
		
		for(int i = 0; i< treeInfo.height; i++) {
			System.out.println("NumOfElements: " + treeInfo.numOfNodesByLevel[i]);	
		}

		System.out.println("height+2: "+(treeInfo.height+2));
		System.out.println("maxWidth[height+2]: "+treeInfo.maxWidth);
		int width = new Random().nextInt(treeInfo.maxWidth) + 1;
		System.out.println("ValueWidth, SumOfWidth: "+treeInfo.widthInTotal + ", NumOfValues: " + treeInfo.numOfNodesInTotal + ", maxWidth: " + treeInfo.maxWidth + ", Random width[0--maxWith): " + width);
		System.out.println(new String(treeInfo.dashDelimiters) );
		
		//check charMatrix columns
		System.out.println("maxWidth[height+2] * maxWidth[height+1]: "+treeInfo.maxWidth * treeInfo.numOfNodesInTotal);
		System.out.println("charMatrix[0].length: "+charMatrix[0].length);
		int expected = treeInfo.maxWidth * treeInfo.numOfNodesInTotal;//
		int actual = charMatrix[0].length;
		if(expected  >= actual) {
			System.out.println("==>>> Overlap might Occured! <<<==");
		}
		int count = 1;
//			while(expected  >= count * actual) {
//				count++;
//			}
		charMatrix = new char[2*treeInfo.height][count * actual];

		System.out.println("matrix: "+matrix.length +", " +matrix[0].length);
		System.out.println("charMatrix: "+charMatrix.length +", " +charMatrix[0].length);
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == null) {
					if(charMatrix[i][j*count ] == DEFAULT_CHAR) {
						charMatrix[i][j*count] = SPACE_CHAR ;
					}
				}else {
					char[] arr = matrix[i][j].toCharArray();
					for(int k = 0; k < arr.length; k++) {
						charMatrix[i][j*count+k] = arr[k] ;
					}
				}
//					if(j == leftMost || j == rightMost) {
//						charMatrix[i][j] = DELIMITER_CHAR;
//					}
			}
//				System.out.println(""+treeInfo.leftSpacesOfTree+new String(charMatrix[i], leftMost, charMatrix[i].length - leftMost ));
//				System.out.println("i: "+(i+1)+treeInfo.leftSpacesOfTree+new String(charMatrix[i], leftMost, rightMost - leftMost + 1 ));
		}
		int leftMost = matrix[0].length - 1;
		int rightMost = 0;
		
		for(int i = 0; i < charMatrix.length; i++) {
			for(int j = 0; j < charMatrix[0].length; j++) {
				if(charMatrix[i][j] != SPACE_CHAR) {
					leftMost = Math.min(leftMost, j);
					rightMost = Math.max(rightMost, j);
				}
				
			}
		}
		for(int i = 0; i < charMatrix.length; i++) {
			if(i % 2 == 0) {
				System.out.printf("%slevel: %-2s %s  %s  %s",treeInfo.leftSpacesOfTree,(i/2+1),DELIMITER_CHAR, new String(charMatrix[i], leftMost, rightMost - leftMost + 1 ),DELIMITER_CHAR);
			}else {
				System.out.printf("%s       %-2s  %s  %s  %s",treeInfo.leftSpacesOfTree,DEFAULT_CHAR,DELIMITER_CHAR, new String(charMatrix[i], leftMost, rightMost - leftMost + 1 ), DELIMITER_CHAR);
			}
			System.out.println();
		}


		System.out.println();
//			System.out.println(treeInfo.leftSpacesOfTree+new String(charMatrix[i], leftMost, matrix[0].length - leftMost));
		System.out.println(new String(treeInfo.equalDelimiters) );
	}

	public static <T> void levelAndPrint(TreeNode3<T> root, int left, int right) {
		if(root == null) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		Deque<TreeNode3<T>> queue = new LinkedList<>();
		queue.offer(root);
		int level = 1;
		int spaces = (int)Math.pow(2, level);
		while(!queue.isEmpty()) {
			int size = queue.size();
			int count = left + (right - left)/(level+ 1);
			for(int i = 0; i < size; i++) {
				TreeNode3<T> node = queue.poll();
				if(node != null) {
					System.out.println("node: "+ node.val);
					sb.append(String.format("%"+count*(i+1)+"s", node.val));
//						System.out.println();
					queue.offer(node.left);
					queue.offer(node.right);
				}else {
					System.out.println("node: "+ "#");
				}
			}
			System.out.println(sb.toString());
			sb.setLength(0);
			level++;
			spaces = (int)Math.pow(2, level);
		}
		
	}
		
	public static <T> int calcHeight(TreeNode3<T> root) {
		if(root == null) {
			return 0;
		}
		int left = calcHeight(root.left);
		int right = calcHeight(root.right);
		return Math.max(left, right) + 1;
	}
		
	public static <T> TreeNode3<T> convertJsonStr2GenericJavaObject(String content, Class<?> clazz0, Class<?> clazz1){ //Class<T> clazz0, Class<T> clazz1) {
		JavaType deserializeType = objectMapper.getTypeFactory().constructParametricType(clazz0, clazz1);
		  try {
			return objectMapper.readValue(content, deserializeType);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		

//		public static TreeNode deserialize(String data) {
//	    public static <M>  TreeNode<M> fromStringToTree(String data){
	public static <M>  TreeNode3<M> fromStringToTree(String data, Class<?> clazz0, Class<?> clazz1){
//	 public TreeNode deserialize(String data) {
	        if (data == null || !data.startsWith("{") ||!data.endsWith("}")|| data.equals("{}")) {
	            return null;
	        }
	        //待处理集合，一个数组，一个list，list为空
	        String[] vals = data.substring(1, data.length() - 1).split(",");
	        int len = vals.length;
	        System.out.println("len: "+len);
	        int index = 0;
//	        TreeNode<M> root = new TreeNode(Integer.valueOf(vals[index++]));
	        TreeNode3<M> root = convertJsonStr2GenericJavaObject(vals[index++], clazz0, clazz1);
	        Queue<TreeNode3<M>> queue = new LinkedList<>();
	        queue.offer(root);
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            for(int i = 0; i < size; i++){
	                TreeNode3<M> node = queue.poll();
	                if(node!=null){
	                		System.out.println("index: "+index);
	                		System.out.println("node.val: "+ node.val);
	                    if(index < len && !vals[index].equals("#")){
//	                        node.left = new TreeNode(Integer.valueOf(vals[index++]));
	                        node.left = convertJsonStr2GenericJavaObject(vals[index++], clazz0, clazz1);
	                    }else{
	                        node.left = null;
	                        index++;
	                    }
	                    if(index < len && !vals[index].equals("#")){
//	                        node.right = new TreeNode(Integer.valueOf(vals[index++]));
	                        node.right = convertJsonStr2GenericJavaObject(vals[index++], clazz0, clazz1);
	                    }else{
	                        node.right = null;
	                        index++;
	                    }
	                    queue.offer(node.left);
	                    queue.offer(node.right);
	                }
	            }
	            TreeNodeUtils3.printTree(root);
	        }
	        return root;
	    }
    	public static <M>  TreeNode3<M> fromStringToTree上5(String data, Class<?> clazz0, Class<?> clazz1){
        if (data == null || !data.startsWith("{") ||!data.endsWith("}")|| data.equals("{}")) {
            return null;
        }
        //待处理集合，一个数组，一个list，list为空
        String[] vals = data.substring(1, data.length() - 1).split(",");
        int len = vals.length;
        int index = 0;
//        TreeNode root = new TreeNode(Integer.valueOf(vals[index++]));
        TreeNode3<M> root = convertJsonStr2GenericJavaObject(vals[index++], clazz0, clazz1);
        Queue<TreeNode3<M>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode3<M> node = queue.poll();
                if(node!=null){
                    if(!vals[index].equals("#")){
//                        node.left = new TreeNode(Integer.valueOf(vals[index++]));
                        node.left = convertJsonStr2GenericJavaObject(vals[index++], clazz0, clazz1); //new TreeNode(Integer.valueOf(vals[index++]));
                    }else{
                        node.left = null;
                        index++;
                    }
                    if(!vals[index].equals("#")){
//                        node.right = new TreeNode(Integer.valueOf(vals[index++]));
                        node.right = convertJsonStr2GenericJavaObject(vals[index++], clazz0, clazz1);
                    }else{
                        node.right = null;
                        index++;
                    }
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return root;

    }

//	    public static String serialize(TreeNode root) {
    public static<T> String fromTreeToString(TreeNode3<T> root) {
        String result = "";
        if(root == null) return result;
        result += "{";
        String prefix = "";
        Queue<TreeNode3<T>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode3<T> node = queue.poll();
                if(node != null){
                    result += prefix + node.val;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }else{
                    result += prefix + "#";
                }
            }
            prefix = ",";
        }
        result += "}";
        return result;
    }

	
	
	
	
	

}
