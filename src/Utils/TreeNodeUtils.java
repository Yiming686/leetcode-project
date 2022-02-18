package Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.TreeNodeUtils.TracingLevelInfo.TracingLevelGroup;
import sun.font.TrueTypeFont;

/**
 * 
 * Global Utils for TreeNode
 * 
 * Single Tree Node：Singly Linked List, Doubly LinkedList Binary Tree
 * Node：TreeNode, BTreeNode Kinary Tree Node：KTreeNode
 *
 * 
 */
//? Comparable<T>
//public class TreeNodeUtil<T extends Comparable<T>> {
public class TreeNodeUtils {
	public static <M> boolean areSame(TreeNode<M> root1, TreeNode<M> root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null && root2 != null) {
			return false;
		}
		if (root1 != null && root2 == null) {
			return false;
		}
		if (!root1.val.equals(root2.val)) {
			return false;
		}
		if (!areSame(root1.left, root2.left) || !areSame(root1.right, root2.right)) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
//		TreeNodeUtil2.printTree(COMPLETE_TREE);
//		TreeNodeUtil2.printTree(ONLY_LEFT_CHILD_TREE);
//		TreeNodeUtil2.printTree(ONLY_RIGHT_CHILD_TREE);
		printTreeByTP(BST_BINARY_TREE_FIVE);
//		TreeNodeUtils.printTree(BINARY_TREE_TWO);
//		TreeNodeUtils.printTree(GENERAL_TREE);
//		String TreeNodeStr ="{1,2,8,#,#,-5555,-2,1,2,8,#,#,-5555,-2}";
		String TreeNodeStr = "{7,299999999,299999999}";
//		String  TreeNodeStr ="{-15,5,6,-8,1,3,9,2,6,#,#,#,#,#,0,#,#,#,#,4,-1,#,#,10}";
//		 TreeNodeStrIn ="{-15,5,6,-8,1,3,9,2,6}";

//		String TreeNodeStrIn ="{1,9,8}";
//		String  TreeNodeStr = COMPLETE_TREE;
		TreeNode<Integer> root3 = TreeNodeUtils.fromStringToTree(TreeNodeStr, TreeNode.class, Integer.class);
//		TreeNodeUtil.printTree(root3);

		String TreeNodeStrIn = "{1,2,8,#,#,-5,2}";
//		String TreeNodeStrIn ="{1,9,8}";

//		TreeNode<Integer> root2 = TreeNodeUtil.fromStringToTree(TreeNodeStrIn); //.fromStringToTree(TreeNodeStrIn);
		TreeNode<Integer> root2 = TreeNodeUtils.fromStringToTree(TreeNodeStrIn, TreeNode.class, Integer.class); // .fromStringToTree(TreeNodeStrIn);
		System.out.println("" + fromTreeToString(root2));
//		TreeNode<Integer> root = TreeNode.fromStringToTree(TreeNodeStrIn);
//		System.out.println(""+maxPathSum2(root));

		System.out.println("Goo");
		TreeNode<Integer> root = fromStringToTree("{1,2,3}", TreeNode.class, Integer.class);
		System.out.println("" + fromTreeToString(root));
//		TreeNode<String> root2 = fromStringToTree("{1,2,3}");
//		System.out.println(""+convertToString(root2));
	}

	public static class TreeNode<T> {
		public T val;
//		public int liss;
		public TreeNode<T> left;
		public TreeNode<T> right;

		@JsonCreator
		public TreeNode(T val) {
			super();
			this.val = val;
		}

		public TreeNode() {
			super();
		}

		public T getVal() {
			return val;
		}

		public void setVal(T val) {
			this.val = val;
		}

		public TreeNode<T> getLeft() {
			return left;
		}

		public void setLeft(TreeNode<T> left) {
			this.left = left;
		}

		public TreeNode<T> getRight() {
			return right;
		}

		public void setRight(TreeNode<T> right) {
			this.right = right;
		}

	}

	public static Boolean toPrintNullNode = Boolean.TRUE;

	public static final String LEFT_SPACES_OF_TREE = "    ";
	public static final char DEFAULT_CHAR = '\u0000';//
	public static final char SPACE_CHAR = ' ';
	public static final char DELIMITER_CHAR = '|';
	public static final String SPACE = " ";
	public static final char EQUAL = '=';
	public static final char DASH = '-';

	public static final ObjectMapper objectMapper = new ObjectMapper();

	public static TreeNode<Integer> COMPLETE_TREE = fromStringToTree("{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}",
			TreeNode.class, Integer.class);
	public static TreeNode<Integer> ONLY_LEFT_CHILD_TREE = fromStringToTree("{1,2,#,3,#,4,#,5,#,6,#}", TreeNode.class,
			Integer.class);
	public static TreeNode<Integer> ONLY_RIGHT_CHILD_TREE = fromStringToTree("{1,#,2,#,3,#,4,#,5,#,6,#}",
			TreeNode.class, Integer.class);
	public static TreeNode<Integer> BINARY_TREE_GENERAL = fromStringToTree(
			"{1,2,3,4,5,6,7,8,9,10,#,#,11,12,13,14,#,15,16,#,#,#,#,17,18,#,19,#,#,#,#,20,21,22,23,#,#,#,#,#,#,#,24,25}",
			TreeNode.class, Integer.class);

	public static TreeNode<Integer> BINARY_TREE_GENERAL_01 = fromStringToTree(
			"{1,2,3,4,5,6,7,8,9,10,#,#,11,12,13,14,#,15,16,#,#,#,#,17,18,#,19,#,#,#,#,20,21,22,23,#,#,#,#,#,#,#,24,25}",
			TreeNode.class, Integer.class);

	public static String BINARY_TREE_NULL_NODE_DEFAULT_STRING = "{}"; // TYPE O, COUNT: 0
	public static String BINARY_TREE_ONE_NODE_DEFAULT_STRING = "{9}";// TYPE 1, COUNT: 1
	public static String BINARY_TREE_TWO_NODE_SLASH_DEFAULT_STRING = "{7, 3}";// TYPE 2, COUNT: 2
	public static String BINARY_TREE_TWO_NODE_BACK_SLASH_DEFAULT_STRING = "{7, 4}";// TYPE 3, COUNT: 2
	public static String BINARY_TREE_THREE_NODE_DEFAULT_STRING = "{5, 2, 8}";// TYPE 4, COUNT: 3
	public static String BINARY_TREE_COMPLETE_DEFAULT_STRING = "{5, 2, 8, 3, 7, 1, 6}";// TYPE 5, COUNT: 7
	public static String BINARY_TREE_COMPLETE_PLUS_LEFT_DEFAULT_STRING = "{5, 2, 8, 3, 7, 1, 6, 9, 0, 8}";// TYPE 6, COUNT: 10
	public static String BINARY_TREE_COMPLETE_PLUS_RIGHT_DEFAULT_STRING = "{5, 2, 8, 3, 7, 1, 6, #, #, #, #, #, 9, 0, 8}";// TYPE 7, COUNT: 10
	public static String BINARY_TREE_SLASH_SLASH_DEFAULT_STRING = "{5, 8, #, 1, #, 9}";// TYPE 8, COUNT: 4
	public static String BINARY_TREE_BACK_SLASH_BACK_SLASH_DEFAULT_STRING = "{5, #, 8, #, 1, #, 9}";// TYPE 9, COUNT: 4
	public static String BINARY_TREE_DIAMOND_DEFAULT_STRING = "{5, 2, 8, 9, #, #, 0, #, 6, 4, #, #, 7, 9}";// TYPE 10, COUNT: 9
	public static String BINARY_TREE_FFFF_DEFAULT_STRING = "{5, 2, 8, 6, #, #, 1, 3, 1, 6, 5, #, #, 8, 4, 0, 9,#,#, 7, #, #, #, #, #, #, 2}";// TYPE 11, COUNT: 15

	public static TreeNode<Integer> BINARY_TREE_NULL_NODE = fromStringToTree(BINARY_TREE_NULL_NODE_DEFAULT_STRING,
			TreeNode.class, Integer.class); // TYPE O, COUNT: 0
	public static TreeNode<Integer> BINARY_TREE_ONE_NODE = fromStringToTree(BINARY_TREE_ONE_NODE_DEFAULT_STRING,
			TreeNode.class, Integer.class);// TYPE 1, COUNT: 1
	public static TreeNode<Integer> BINARY_TREE_TWO_NODE_SLASH = fromStringToTree(
			BINARY_TREE_TWO_NODE_SLASH_DEFAULT_STRING, TreeNode.class, Integer.class);// TYPE 2, COUNT: 2
	public static TreeNode<Integer> BINARY_TREE_TWO_NODE_BACK_SLASH = fromStringToTree(
			BINARY_TREE_TWO_NODE_BACK_SLASH_DEFAULT_STRING, TreeNode.class, Integer.class);// TYPE 3, COUNT: 2
	public static TreeNode<Integer> BINARY_TREE_THREE_NODE = fromStringToTree(BINARY_TREE_THREE_NODE_DEFAULT_STRING,
			TreeNode.class, Integer.class);// TYPE 4, COUNT: 3
	public static TreeNode<Integer> BINARY_TREE_COMPLETE = fromStringToTree(BINARY_TREE_COMPLETE_DEFAULT_STRING,
			TreeNode.class, Integer.class);// TYPE 5, COUNT: 7
	public static TreeNode<Integer> BINARY_TREE_COMPLETE_PLUS_LEFT = fromStringToTree(
			BINARY_TREE_COMPLETE_PLUS_LEFT_DEFAULT_STRING, TreeNode.class, Integer.class);// TYPE 6, COUNT: 10
	public static TreeNode<Integer> BINARY_TREE_COMPLETE_PLUS_RIGHT = fromStringToTree(
			BINARY_TREE_COMPLETE_PLUS_RIGHT_DEFAULT_STRING, TreeNode.class, Integer.class);// TYPE 7, COUNT: 10
	public static TreeNode<Integer> BINARY_TREE_SLASH_SLASH = fromStringToTree(BINARY_TREE_SLASH_SLASH_DEFAULT_STRING,
			TreeNode.class, Integer.class);// TYPE 8, COUNT: 4
	public static TreeNode<Integer> BINARY_TREE_BACK_SLASH_BACK_SLASH = fromStringToTree(
			BINARY_TREE_BACK_SLASH_BACK_SLASH_DEFAULT_STRING, TreeNode.class, Integer.class);// TYPE 9, COUNT: 4
	public static TreeNode<Integer> BINARY_TREE_DIAMOND = fromStringToTree(BINARY_TREE_DIAMOND_DEFAULT_STRING,
			TreeNode.class, Integer.class);// TYPE 10, COUNT: 9
	public static TreeNode<Integer> BINARY_TREE_FFFF = fromStringToTree(BINARY_TREE_FFFF_DEFAULT_STRING, TreeNode.class,
			Integer.class);// TYPE 11, COUNT: 15

	public static TreeNode<Integer> BINARY_TREE_NULL_NODE_NEW = fromStringToTree(
			applyNew(BINARY_TREE_NULL_NODE_DEFAULT_STRING), TreeNode.class, Integer.class); // TYPE O, COUNT: 0
	public static TreeNode<Integer> BINARY_TREE_ONE_NODE_NEW = fromStringToTree(
			applyNew(BINARY_TREE_ONE_NODE_DEFAULT_STRING), TreeNode.class, Integer.class);// TYPE 1, COUNT: 1
	public static TreeNode<Integer> BINARY_TREE_TWO_NODE_SLASH_NEW = fromStringToTree(
			applyNew(BINARY_TREE_TWO_NODE_SLASH_DEFAULT_STRING), TreeNode.class, Integer.class);// TYPE 2, COUNT: 2
	public static TreeNode<Integer> BINARY_TREE_TWO_NODE_BACK_SLASH_NEW = fromStringToTree(
			applyNew(BINARY_TREE_TWO_NODE_BACK_SLASH_DEFAULT_STRING), TreeNode.class, Integer.class);// TYPE 3, COUNT: 2
	public static TreeNode<Integer> BINARY_TREE_THREE_NODE_NEW = fromStringToTree(
			applyNew(BINARY_TREE_THREE_NODE_DEFAULT_STRING), TreeNode.class, Integer.class);// TYPE 4, COUNT: 3
	public static TreeNode<Integer> BINARY_TREE_COMPLETE_NEW = fromStringToTree(
			applyNew(BINARY_TREE_COMPLETE_DEFAULT_STRING), TreeNode.class, Integer.class);// TYPE 5, COUNT: 7
	public static TreeNode<Integer> BINARY_TREE_COMPLETE_PLUS_LEFT_NEW = fromStringToTree(
			applyNew(BINARY_TREE_COMPLETE_PLUS_LEFT_DEFAULT_STRING), TreeNode.class, Integer.class);// TYPE 6, COUNT: 10
	public static TreeNode<Integer> BINARY_TREE_COMPLETE_PLUS_RIGHT_NEW = fromStringToTree(
			applyNew(BINARY_TREE_COMPLETE_PLUS_RIGHT_DEFAULT_STRING), TreeNode.class, Integer.class);// TYPE 7, COUNT: 10
	public static TreeNode<Integer> BINARY_TREE_SLASH_SLASH_NEW = fromStringToTree(
			applyNew(BINARY_TREE_SLASH_SLASH_DEFAULT_STRING), TreeNode.class, Integer.class);// TYPE 8, COUNT: 4
	public static TreeNode<Integer> BINARY_TREE_BACK_SLASH_BACK_SLASH_NEW = fromStringToTree(
			applyNew(BINARY_TREE_BACK_SLASH_BACK_SLASH_DEFAULT_STRING), TreeNode.class, Integer.class);// TYPE 9, COUNT: 4
	public static TreeNode<Integer> BINARY_TREE_DIAMOND_NEW = fromStringToTree(
			applyNew(BINARY_TREE_DIAMOND_DEFAULT_STRING), TreeNode.class, Integer.class);// TYPE 10, COUNT: 9
	public static TreeNode<Integer> BINARY_TREE_FFFF_NEW = fromStringToTree(applyNew(BINARY_TREE_FFFF_DEFAULT_STRING),
			TreeNode.class, Integer.class);// TYPE 11, COUNT: 15

//	update the template TREE STRING 
	private static String applyNew(String treeStr) {
		if (treeStr == null || treeStr.length() == 0) {
			return "{}";
		}
		if (treeStr.equals("{}") || treeStr.equals("[]")) {
			return "{}";
		}
		String[] vals = treeStr.substring(1, treeStr.length() - 1).split(",");
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < vals.length; i++) {
			String val = vals[i].trim();
			if (!val.equals("") && !val.equals("#")) {
				vals[i] = Integer.toString(new Random().nextInt(40) - 20);
			}
			sb.append(vals[i]);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("}");
		return sb.toString();
	}

	public static TreeNode<Integer> BST_BINARY_TREE_ONE = fromStringToTree("{}", TreeNode.class, Integer.class);
	public static TreeNode<Integer> BST_BINARY_TREE_TWO = fromStringToTree("{5}", TreeNode.class, Integer.class);
	public static TreeNode<Integer> BST_BINARY_TREE_THREE = fromStringToTree("{5, 2}", TreeNode.class, Integer.class);
	public static TreeNode<Integer> BST_BINARY_TREE_FOUR = fromStringToTree("{5,#,9}", TreeNode.class, Integer.class);
	public static TreeNode<Integer> BST_BINARY_TREE_FIVE = fromStringToTree("{5,2,9}", TreeNode.class, Integer.class);
	public static TreeNode<Integer> BST_BINARY_TREE_SIX = fromStringToTree("{}", TreeNode.class, Integer.class);
	public static TreeNode<Integer> BST_BINARY_TREE_SEVEN = fromStringToTree("{}", TreeNode.class, Integer.class);
	public static TreeNode<Integer> BST_BINARY_TREE_EIGHT = fromStringToTree("{}", TreeNode.class, Integer.class);
	public static TreeNode<Integer> BST_BINARY_TREE_NINE = fromStringToTree("{}", TreeNode.class, Integer.class);
	public static TreeNode<Integer> BST_BINARY_TREE_TEN = fromStringToTree("{}", TreeNode.class, Integer.class);
	public static TreeNode<Integer> BST_BINARY_TREE_ELEVEN = fromStringToTree("{}", TreeNode.class, Integer.class);
	public static TreeNode<Integer> BST_BINARY_TREE_TWELVE = fromStringToTree("{}", TreeNode.class, Integer.class);

	static class TreeInfo<T> {
		// global, never change
		char[][] finalCharMatrix;
		char[][] charMatrix;
		List<char[][]> trimedCharMatrixList = new ArrayList<>();
		String[][] matrix;
		int[] numOfNodesByLevel;//
		int widthInTotal;// widthOfAllNodeValues
		int numOfNodesInTotal;// numOfNodesInTheTree
		int maxWidth;
		CONNECTION_STYLE connectionStyle;
		boolean enableLorR;
		int height;
		boolean toShrink; // by default, false
		int max2Parent;
		char[] equalDelimiters;
		char[] dashDelimiters;
		String leftSpacesOfTree = LEFT_SPACES_OF_TREE;
		Map<T, LevelInfo> LevelLevelInfoMap = new HashMap<>();
		Map<TreeNode<T>, TreeNodeInfo<T>> NodeNodeInfoMap = new HashMap<>();

	}

	static class LevelInfo {
		int level;// PK
		int numOfNodes;
	}

	static class TreeNodeInfo<T> {
		TreeNode<T> node;// PK
		String flag;
		int level;
		int left;
		int right;
	}

//	哪里控制， 不出现null节点？withNullNode
	public static <T> void printTreeByTP(TreeNode<T> root) {
		boolean withNullNode = true;
		printTreeByTP(root, withNullNode);
	}

	public static <T> void printTreeByTP(TreeNode<T> root, boolean withNullNode) {
		toPrintNullNode = withNullNode;
		if (root == null) {
			System.out.println("Binary Tree: null");
			return;
		}
		TP tpRoot = TP.build("level:numOfNodes", "1", null, root.val);
		preOrder(root, tpRoot, withNullNode);
		tpRoot.print();
	}

	private static <T> void preOrder(TreeNode<T> root, TP tp) {
		boolean withNullNode = true;
		preOrder(root, tp, withNullNode);
	}

	private static <T> void preOrder(TreeNode<T> root, TP tpRoot, boolean withNullNode) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
//			preOrder(root.left, TP.build(tpRoot, root.left.val));
			preOrder(root.left, TP.build(tpRoot, root.left.val), withNullNode);
		} else {
			if (withNullNode) {
//				preOrder(root.left, TP.build(tpRoot, "null"));
				preOrder(root.left, TP.build(tpRoot, "null"), withNullNode);
			} else {
//				preOrder(root.left, null, withNullNode);
			}
		}
		if (root.right != null) {
//			preOrder(root.right, TP.build(tpRoot, root.right.val));
			preOrder(root.right, TP.build(tpRoot, root.right.val), withNullNode);
		} else {
			if (withNullNode) {
//				preOrder(root.right, TP.build(tpRoot, "null"));
				preOrder(root.right, TP.build(tpRoot, "null"), withNullNode);
			} else {
//				preOrder(root.right, null, withNullNode);
			}
		}
	}

	enum CONNECTION_STYLE {
		DASH("DASH"), SLASH("SLASH");
		String style;

		CONNECTION_STYLE(String style) {
			this.style = style;
		}
	}

//	has bugs by matrix width ??? not fixed yet
	public static <T> void printTree(TreeNode<T> root) {
		printTree(root, "1111");
//		printTree(root, "1000");
	}

	// worked
	public static <T> void printTree(TreeNode<T> root, String switches) {
		if (root == null) {
			return;
		}

		int height = calcHeight(root);
		int maxSpaces = (int) Math.pow(2, height);

		int rowEx = 2; // by default, add extra / \ / \ or -----^-----
		int colEx = 2; // by default, if no enough space, extend the columns

		String[][] matrix = new String[rowEx * height][colEx * maxSpaces];

//		determine how to extend columns
		boolean hasEnoughSpace = false;// by default, not enough space
		TreeInfo<T> treeInfo = new TreeInfo<>();
		TreeNodeInfo<T> treeNodeInfo = new TreeNodeInfo<T>();
//		find colEx: if not hasEnoughSpace, colEx++
		while (!hasEnoughSpace) {
//				System.out.println("colEx: "+ colEx);
			treeInfo.matrix = new String[rowEx * height][colEx * maxSpaces];
			treeInfo.numOfNodesByLevel = new int[height];
			treeInfo.connectionStyle = CONNECTION_STYLE.DASH; //"DASH";
			treeInfo.enableLorR = true;
			treeInfo.height = height;
			treeInfo.toShrink = false;
			treeInfo.max2Parent = 0;

			treeNodeInfo.flag = "[ROOT]";
			treeNodeInfo.level = 1;
			treeNodeInfo.left = 0;
			treeNodeInfo.right = colEx * maxSpaces - 1;
//			treeInfo.list.clear();
			hasEnoughSpace = hasEnoughSpace(treeInfo, root, "[ROOT]", 1, 0, colEx * maxSpaces - 1);
//				hasEnoughSpace = hasEnoughSpace(root, treeInfo, treeNodeInfo);
//			System.out.println("list: "+treeInfo.list);
			colEx++;
		}
		colEx--;

		final int rows = rowEx * height;
		final int cols = colEx * maxSpaces;

//		determine how to shrink the entire tree, so relocate the position of root
		treeInfo.max2Parent = 40;
		treeInfo.toShrink = false;// true; //false; //true; // true
		if (treeInfo.toShrink) {
			boolean isSmallest = false;// by default, not enough space
			treeInfo.max2Parent = 1;
			while (!isSmallest) {
//					System.out.println("max2Parent: "+ treeInfo.max2Parent);
				treeInfo.matrix = new String[rows][cols];
				treeInfo.numOfNodesByLevel = new int[height];
				treeInfo.connectionStyle = CONNECTION_STYLE.DASH;//"DASH";
				treeInfo.enableLorR = true;
				treeInfo.height = height;
				treeInfo.toShrink = true;

				treeNodeInfo.flag = "[ROOT]";
				treeNodeInfo.level = 1;
				treeNodeInfo.left = 0;
				treeNodeInfo.right = colEx * maxSpaces - 1;

				isSmallest = hasEnoughSpace(treeInfo, root, "[ROOT]", 1, 0, colEx * maxSpaces - 1);
//					isSmallest = hasEnoughSpace(root, treeInfo, treeNodeInfo);

				treeInfo.max2Parent++;
			}

			treeInfo.max2Parent = treeInfo.max2Parent - 1;

		}
//		System.out.println("max2Parent: "+treeInfo.max2Parent);

		char[] equalDelimiters = new char[3 * maxSpaces];
		Arrays.fill(equalDelimiters, '=');
		char[] dashDelimiters = new char[3 * maxSpaces];
		Arrays.fill(dashDelimiters, '-');
//		System.out.println("=== PRINT BINARY TREE ===" + new String(equalDelimiters) );
//		System.out.println("Height: " + height + ", MaxSpaces: " +maxSpaces);
//		System.out.println("Rows: " + matrix.length + ", Cols: " +matrix[0].length);

		// "ValueWidth, SumOfWidth: "+maxWidth[0] + ", NumOfValues: " +
		// maxWidth[1] + ", maxWidth: " + maxWidth[2] + ", Random
		// width[0--maxWith): " + width, numOf

//			 set for all cases
		treeInfo.toShrink = true; // false; // true;

// validate swithes
		if (switches == null || switches.length() == 0) {
			switches = "1111";
		}
		for (int i = 0; i < switches.length(); i++) {
			if (switches.charAt(i) != '1' && switches.charAt(i) != '0') {
				switches = "1111";
				break;
			}
		}

//	 	FIRST STYLE: Print Tree in Default Way
		int switchesLen = 1;
		if (switches.length() >= switchesLen && switches.charAt(switchesLen - 1) == '1') {
			treeInfo.enableLorR = false;
			treeInfo.connectionStyle = CONNECTION_STYLE.DASH;//"DASH";
			treeInfo.numOfNodesByLevel = new int[height];
			treeInfo.matrix = new String[rows][cols];
			treeInfo.charMatrix = new char[rows][cols];
			treeInfo.equalDelimiters = equalDelimiters;
			treeInfo.dashDelimiters = dashDelimiters;
			hasEnoughSpace(treeInfo, root, "[ROOT]", 1, 0, cols - 1);
			printBinaryTreeFromMatrix2(treeInfo);// Second Print

		}

//		SECOND STYLE: Print Tree in Default Way
		switchesLen = 2;
		if (switches.length() >= switchesLen && switches.charAt(switchesLen - 1) == '1') {
			treeInfo.enableLorR = true;
			treeInfo.connectionStyle = CONNECTION_STYLE.DASH; //"SLASH";//
			treeInfo.numOfNodesByLevel = new int[height];
			treeInfo.matrix = new String[rows][cols];
			treeInfo.charMatrix = new char[rows][cols];

			// newly added, built to print the whole tree in an array of Trees
			treeInfo.finalCharMatrix = new char[rows][cols];

			treeInfo.equalDelimiters = equalDelimiters;
			treeInfo.dashDelimiters = dashDelimiters;
			hasEnoughSpace(treeInfo, root, "[ROOT]", 1, 0, cols - 1);
			printBinaryTreeFromMatrix2(treeInfo);// First Print
		}

//		THIRD STYLE:
		switchesLen = 3;
		if (switches.length() >= switchesLen && switches.charAt(switchesLen - 1) == '1') {
			treeInfo.enableLorR = false;
			treeInfo.connectionStyle = CONNECTION_STYLE.DASH;//"SLASH";
			treeInfo.numOfNodesByLevel = new int[height];
			treeInfo.matrix = new String[rows][cols];
			treeInfo.charMatrix = new char[rows][cols];
			treeInfo.equalDelimiters = equalDelimiters;
			treeInfo.dashDelimiters = dashDelimiters;
			hasEnoughSpace(treeInfo, root, "[ROOT]", 1, 0, cols - 1);
			printBinaryTreeFromMatrix2(treeInfo);// Third Print
		}

//		FOURTH STYLE:
		switchesLen = 4;
		if (switches.length() >= switchesLen && switches.charAt(switchesLen - 1) == '1') {
//		boolean enableLorR = true;
//		String connectionStyle = "DASH";
//		buildTree(enableLorR, connectionStyle);
			treeInfo.enableLorR = false;
			treeInfo.connectionStyle = CONNECTION_STYLE.DASH;//"DASH";
			treeInfo.numOfNodesByLevel = new int[height];
			treeInfo.matrix = new String[rows][cols];
			treeInfo.charMatrix = new char[rows][cols];
			treeInfo.equalDelimiters = equalDelimiters;
			treeInfo.dashDelimiters = dashDelimiters;
			hasEnoughSpace(treeInfo, root, "[ROOT]", 1, 0, cols - 1);
			printBinaryTreeFromMatrix2(treeInfo);// Fourth Print
		}

//      PRINT: A ARRAY OF TREES
		print(treeInfo);

	}

//	????
	private static void arraysfill(char[][] charMatrix) {
		// TODO Auto-generated method stub
		if (charMatrix == null || charMatrix.length == 0) {
			return;
		}
		for (int i = 0; i < charMatrix.length; i++) {
			Arrays.fill(charMatrix[i], ' ');
		}
	}

	private static <T> void print(TreeInfo<T> treeInfo) {
		// TODO Auto-generated method stub
		List<char[][]> trimedCharMatrixList = treeInfo.trimedCharMatrixList;
		if (trimedCharMatrixList == null || trimedCharMatrixList.size() == 0) {
			return;
		}
		char[][] arr = trimedCharMatrixList.get(0);
		int rows = arr.length;

		String string = SPACE + SPACE + DELIMITER_CHAR + SPACE + SPACE;
		char[][] delimterArr = new char[rows][string.length()];
		for (int i = 0; i < arr.length; i++) {
			delimterArr[i] = string.toCharArray();
		}
//		System.out.println(""+Matrix.fromMatrixToString(delimterArr));

		int maxNumOfNodes = 0;
		for (int val : treeInfo.numOfNodesByLevel) {
			maxNumOfNodes = Math.max(maxNumOfNodes, val);
		}
		int widthOfLevel = String.valueOf(rows).length();
		int widthOfNumOfNodes = String.valueOf(maxNumOfNodes).length();

		string = "level: " + String.valueOf(rows) + ", Num: " + maxNumOfNodes;
		char[][] leadingArr = new char[rows][string.length()];
		for (int i = 0; i < arr.length; i++) {
			String str = "";
			if (i % 2 == 0) {
				str += String.format("level: %-" + widthOfLevel + "d, Num: %-" + widthOfNumOfNodes + "d", (i / 2 + 1),
						treeInfo.numOfNodesByLevel[i / 2]);
				leadingArr[i] = str.toCharArray();
			} else {
				Arrays.fill(leadingArr[i], SPACE_CHAR);
			}
		}
//		System.out.println(""+Matrix.fromMatrixToString(leadingArr));

		string = "";
		string += new String(delimterArr[0]);
		string += new String(leadingArr[0]);
		string += new String(delimterArr[0]);
		for (int j = 0; j < trimedCharMatrixList.size(); j++) {
			char[][] trimedCharMatrix = trimedCharMatrixList.get(j);
			string += new String(trimedCharMatrix[0]); // , 0,
														// trimedCharMatrix[i].length);
			string += new String(delimterArr[0]);
		}
		char[] headAndfooterArr = string.toCharArray();
		Arrays.fill(headAndfooterArr, EQUAL);
		String headAndfooter = new String(headAndfooterArr);
		System.out.println(headAndfooter);

		for (int i = 0; i < arr.length; i++) {
			string = "";
			string += new String(delimterArr[i]);
			string += new String(leadingArr[i]);
			string += new String(delimterArr[i]);
			for (int j = 0; j < trimedCharMatrixList.size(); j++) {
				char[][] trimedCharMatrix = trimedCharMatrixList.get(j);
				string += new String(trimedCharMatrix[i]); // , 0,
															// trimedCharMatrix[i].length);
				string += new String(delimterArr[i]);
			}
			System.out.println(string);
		}
		System.out.println(headAndfooter);
	}

	private static <T> boolean hasEnoughSpace(TreeNode<T> root, TreeNodeInfo<T> rootInfo, LevelInfo levelInfo,
			TreeInfo<T> treeInfo) {
		if (root == null) {
			return true;
		}
		String flag = rootInfo.flag;
		int level = rootInfo.level;
		int left = rootInfo.left;
		int right = rootInfo.right;
//			relocate mid if needed
		treeInfo.numOfNodesByLevel[level - 1]++;
		int mid = left + (right - left) / 2;
		int width = String.valueOf(root.val).length();
		treeInfo.widthInTotal += width;
		treeInfo.numOfNodesInTotal++;
		treeInfo.maxWidth = Math.max(treeInfo.maxWidth, width);

		if (treeInfo.enableLorR) {// if enableLorR, add L or R
			width += 3;
		}
		int delta = 0;
		int maxDiff = 1;
		if (mid + width - 1 >= right) {
			delta = -(mid + width - 1 - right + maxDiff);
		}
		if (mid + delta < left) {
			return false;
		}
		mid = mid + delta;

//			shink tree
		if (treeInfo.toShrink) {
			int start = mid;
			int end = mid + width - 1;
//			int max2Parent = 4 * (height - level)+4;
//			int max2Parent = 0;
			if (flag.equals("[L]") && right - end >= treeInfo.max2Parent) {
//				mid + width - 1 = right - max2Parent;
				mid = right - treeInfo.max2Parent - width + 1;
			} else if (flag.equals("[R]") && mid - left >= treeInfo.max2Parent) {
//				mid = left + max2Parent;
				mid = left + treeInfo.max2Parent;
			}
		}

//			fill values
		if (treeInfo.enableLorR) {// if enableLorR, add L or R
			treeInfo.matrix[2 * (level - 1)][mid] = "" + root.val + flag;
		} else {
			treeInfo.matrix[2 * (level - 1)][mid] = "" + root.val;
		}

// add connections
		if (flag.equals("[L]")) {
			if (treeInfo.connectionStyle.equals(CONNECTION_STYLE.DASH)) {
				Arrays.fill(treeInfo.matrix[2 * (level - 1) - 1], mid, right, "-");
				treeInfo.matrix[2 * (level - 1) - 1][right] = "^";
				treeInfo.matrix[2 * (level - 1) - 1][mid] = "+";
			} else {
				treeInfo.matrix[2 * (level - 1) - 1][mid + (right - mid) / 2] = "/";
			}

		} else if (flag.equals("[R]")) {
			if (treeInfo.connectionStyle.equals(CONNECTION_STYLE.DASH)) {
				Arrays.fill(treeInfo.matrix[2 * (level - 1) - 1], left, mid, "-");
				treeInfo.matrix[2 * (level - 1) - 1][left] = "^";
				treeInfo.matrix[2 * (level - 1) - 1][mid] = "+";
			} else {
				treeInfo.matrix[2 * (level - 1) - 1][left + (mid - left) / 2] = "\\";
			}
		}
//			boolean leftHasEnoughSpace = hasEnoughSpace(treeInfo, root.left,"[L]", level + 1, left, mid  );
		boolean leftHasEnoughSpace = hasEnoughSpace(root.left, rootInfo, levelInfo, treeInfo);
		if (!leftHasEnoughSpace) {
			return leftHasEnoughSpace;
		}
//			boolean rightHasEnoughSpace = hasEnoughSpace(treeInfo, root.right, "[R]", level + 1, mid, right);
		boolean rightHasEnoughSpace = hasEnoughSpace(root.right, rootInfo, levelInfo, treeInfo);

		if (!rightHasEnoughSpace) {
			return rightHasEnoughSpace;
		}
		return true;
	}

	private static <T> boolean hasEnoughSpace(TreeInfo<T> treeInfo, TreeNode<T> root, String flag, int level, int left,
			int right) {
		if (root == null) {
			return true;
		}
//			relocate mid if needed
		treeInfo.numOfNodesByLevel[level - 1]++;
		int mid = left + (right - left) / 2;
		int width = String.valueOf(root.val).length();
		treeInfo.widthInTotal += width;
		treeInfo.numOfNodesInTotal++;
		treeInfo.maxWidth = Math.max(treeInfo.maxWidth, width);

		if (treeInfo.enableLorR) {// if enableLorR, add L or R
			width += 3; // get from the string ???
		}
		int delta = 0;
		int maxDiff = 1;
		int diff = mid + width - 1 - right;
//		if(mid + width - 1 >= right) {
		if (diff >= 0) {
			delta = -(mid + width - 1 - right + maxDiff);
			if (mid + delta < left) {
//				treeInfo.list.add(root.val);				
				return false;
			}
			mid = mid + delta;
		} else if (Math.abs(diff) > 3) {
//			mid = right - 3 - width + 1;
		}

//			shink tree
		if (treeInfo.toShrink) {
			int start = mid;
			int end = mid + width - 1;
//			int max2Parent = 4 * (height - level)+4;
//			int max2Parent = 0;
			if (flag.equals("[L]") && right - end >= treeInfo.max2Parent) {
//				mid + width - 1 = right - max2Parent;
				mid = right - treeInfo.max2Parent - width + 1;
			} else if (flag.equals("[R]") && mid - left >= treeInfo.max2Parent) {
//				mid = left + max2Parent;
				mid = left + treeInfo.max2Parent;
			}
		}

//			fill values
		if (treeInfo.enableLorR) {// if enableLorR, add L or R
			treeInfo.matrix[2 * (level - 1)][mid] = "" + root.val + flag;
		} else {
			treeInfo.matrix[2 * (level - 1)][mid] = "" + root.val;
		}

// add connections
		if (flag.equals("[L]")) {
			if (treeInfo.connectionStyle.equals(CONNECTION_STYLE.DASH)) {
				Arrays.fill(treeInfo.matrix[2 * (level - 1) - 1], mid, right, "-");
				treeInfo.matrix[2 * (level - 1) - 1][right] = "^";
				treeInfo.matrix[2 * (level - 1) - 1][mid] = "+";
			} else {
				treeInfo.matrix[2 * (level - 1) - 1][mid + (right - mid) / 2] = "/";
			}

		} else if (flag.equals("[R]")) {
			if (treeInfo.connectionStyle.equals(CONNECTION_STYLE.DASH)) {
				Arrays.fill(treeInfo.matrix[2 * (level - 1) - 1], left, mid, "-");
				treeInfo.matrix[2 * (level - 1) - 1][left] = "^";
				treeInfo.matrix[2 * (level - 1) - 1][mid] = "+";
			} else {
				treeInfo.matrix[2 * (level - 1) - 1][left + (mid - left) / 2] = "\\";
			}
		}
		boolean leftHasEnoughSpace = hasEnoughSpace(treeInfo, root.left, "[L]", level + 1, left, mid);
		if (!leftHasEnoughSpace) {
			return leftHasEnoughSpace;
		}
		boolean rightHasEnoughSpace = hasEnoughSpace(treeInfo, root.right, "[R]", level + 1, mid, right);

		if (!rightHasEnoughSpace) {
			return rightHasEnoughSpace;
		}
		return true;
	}

	private static <T> void printBinaryTreeFromMatrix2(TreeInfo<T> treeInfo) {
		String[][] matrix = treeInfo.matrix;
		char[][] charMatrix = treeInfo.charMatrix;

		int width = new Random().nextInt(treeInfo.maxWidth) + 1;

		// check charMatrix columns
		int expected = treeInfo.maxWidth * treeInfo.numOfNodesInTotal;//
		int actual = charMatrix[0].length;
		int count = 1;// 放大系数
//			while(expected  >= count * actual) {
//				count++;
//			}
		charMatrix = new char[2 * treeInfo.height][count * actual + 2];
		arraysfill(charMatrix);

//		Matrix.fromMatrixToString(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == null) {
					if (charMatrix[i][j * count] == DEFAULT_CHAR) {
						charMatrix[i][j * count] = SPACE_CHAR;
					}
				} else {
					char[] arr = matrix[i][j].toCharArray();
					for (int k = 0; k < arr.length; k++) {
						charMatrix[i][j * count + k] = arr[k];
					}
				}
			}
		}
		int leftMost = charMatrix[0].length - 1;
		int rightMost = 0;

		for (int i = 0; i < charMatrix.length; i++) {
			for (int j = 0; j < charMatrix[0].length; j++) {
				if (charMatrix[i][j] != SPACE_CHAR) {
					leftMost = Math.min(leftMost, j);
					rightMost = Math.max(rightMost, j);
				}

			}
		}
		int colLen = rightMost - leftMost + 1;
		char[][] trimedMatrix = new char[charMatrix.length][colLen];

		for (int i = 0; i < charMatrix.length; i++) {
			System.arraycopy(charMatrix[i], leftMost, trimedMatrix[i], 0, colLen);
		}
		treeInfo.trimedCharMatrixList.add(trimedMatrix);
	}

	private static <T> void printBinaryTreeFromMatrix(TreeInfo<T> treeInfo) {
		String[][] matrix = treeInfo.matrix;
		char[][] charMatrix = treeInfo.charMatrix;

		for (int i = 0; i < treeInfo.height; i++) {
			System.out.println("NumOfElements: " + treeInfo.numOfNodesByLevel[i]);
		}

		System.out.println("height+2: " + (treeInfo.height + 2));
		System.out.println("maxWidth[height+2]: " + treeInfo.maxWidth);
		int width = new Random().nextInt(treeInfo.maxWidth) + 1;
		System.out.println(
				"ValueWidth, SumOfWidth: " + treeInfo.widthInTotal + ", NumOfValues: " + treeInfo.numOfNodesInTotal
						+ ", maxWidth: " + treeInfo.maxWidth + ", Random width[0--maxWith): " + width);
		System.out.println(new String(treeInfo.dashDelimiters));

		// check charMatrix columns
		System.out
				.println("maxWidth[height+2] * maxWidth[height+1]: " + treeInfo.maxWidth * treeInfo.numOfNodesInTotal);
		System.out.println("charMatrix[0].length: " + charMatrix[0].length);
		int expected = treeInfo.maxWidth * treeInfo.numOfNodesInTotal;//
		int actual = charMatrix[0].length;
		if (expected >= actual) {
			System.out.println("==>>> Overlap might Occured! <<<==");
		}
		int count = 1;
//			while(expected  >= count * actual) {
//				count++;
//			}
		charMatrix = new char[2 * treeInfo.height][count * actual];

		System.out.println("matrix: " + matrix.length + ", " + matrix[0].length);
		System.out.println("charMatrix: " + charMatrix.length + ", " + charMatrix[0].length);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == null) {
					if (charMatrix[i][j * count] == DEFAULT_CHAR) {
						charMatrix[i][j * count] = SPACE_CHAR;
					}
				} else {
					char[] arr = matrix[i][j].toCharArray();
					for (int k = 0; k < arr.length; k++) {
						charMatrix[i][j * count + k] = arr[k];
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

		for (int i = 0; i < charMatrix.length; i++) {
			for (int j = 0; j < charMatrix[0].length; j++) {
				if (charMatrix[i][j] != SPACE_CHAR) {
					leftMost = Math.min(leftMost, j);
					rightMost = Math.max(rightMost, j);
				}

			}
		}
		for (int i = 0; i < charMatrix.length; i++) {
			if (i % 2 == 0) {
				System.out.printf("%slevel: %-2s %s  %s  %s", treeInfo.leftSpacesOfTree, (i / 2 + 1), DELIMITER_CHAR,
						new String(charMatrix[i], leftMost, rightMost - leftMost + 1), DELIMITER_CHAR);
			} else {
				System.out.printf("%s       %-2s  %s  %s  %s", treeInfo.leftSpacesOfTree, DEFAULT_CHAR, DELIMITER_CHAR,
						new String(charMatrix[i], leftMost, rightMost - leftMost + 1), DELIMITER_CHAR);
			}
			System.out.println();
		}

		System.out.println();
//			System.out.println(treeInfo.leftSpacesOfTree+new String(charMatrix[i], leftMost, matrix[0].length - leftMost));
		System.out.println(new String(treeInfo.equalDelimiters));
	}

	public static <T> void levelAndPrint(TreeNode<T> root, int left, int right) {
		if (root == null) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		Deque<TreeNode<T>> queue = new LinkedList<>();
		queue.offer(root);
		int level = 1;
		int spaces = (int) Math.pow(2, level);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int count = left + (right - left) / (level + 1);
			for (int i = 0; i < size; i++) {
				TreeNode<T> node = queue.poll();
				if (node != null) {
					System.out.println("node: " + node.val);
					sb.append(String.format("%" + count * (i + 1) + "s", node.val));
//						System.out.println();
					queue.offer(node.left);
					queue.offer(node.right);
				} else {
					System.out.println("node: " + "#");
				}
			}
			System.out.println(sb.toString());
			sb.setLength(0);
			level++;
			spaces = (int) Math.pow(2, level);
		}

	}

	public static <T> int calcHeight(TreeNode<T> root) {
		if (root == null) {
			return 0;
		}
		int left = calcHeight(root.left);
		int right = calcHeight(root.right);
		return Math.max(left, right) + 1;
	}

	public static <T> TreeNode<T> convertJsonStr2GenericJavaObject(String content, Class<?> clazz0, Class<?> clazz1) { // Class<T>
																														// clazz0,
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

	public static <M> TreeNode<M> buildTreefromString(String[] vals) {
		return fromStringToTree(vals);
	}
	public static <M> TreeNode<M> buildTreefromString(String str) {
		return fromStringToTree(str);
	}
	public static <M> TreeNode<M> buildTreefromString(String[] data, Class<?> clazz0, Class<?> clazz1) {
		return fromStringToTree(data, clazz0, clazz1);
	}
	public static <M> TreeNode<M> buildTreefromString(String data, Class<?> clazz0, Class<?> clazz1) {
		return fromStringToTree(data, clazz0, clazz1);
	}
	
//	By default, TreeNode.class, Integer.class
	public static <M> TreeNode<M> fromStringToTree(String[] vals) {
		return fromStringToTree(vals, TreeNode.class, Integer.class);
	}

	//	By default, TreeNode.class, Integer.class
	public static <M> TreeNode<M> fromStringToTree(String data) {
		return fromStringToTree(data, TreeNode.class, Integer.class);
	}

//
//		public static TreeNode deserialize(String data) {
//	    public static <M>  TreeNode<M> fromStringToTree(String data){
	public static <M> TreeNode<M> fromStringToTree(String data, Class<?> clazz0, Class<?> clazz1) {
		if (data == null || data.length() == 0) {
			return null;
		}
		data = data.trim();
		if (data.equals("{}") || data.equals("[]")) {
			return null;
		}
		// 待处理集合，一个数组，一个list，list为空
		// 生成一个node的list,此list不包含null节点,只用来连接node
		String[] vals = data.substring(1, data.length() - 1).split(",");
		return fromStringToTree(vals, clazz0, clazz1);
	}

	public static <M> TreeNode<M> fromStringToTree(String[] vals, Class<?> clazz0, Class<?> clazz1) {
		if (vals == null || vals.length == 0) {
			return null;
		}
		ArrayList<TreeNode<M>> list = new ArrayList<TreeNode<M>>();
//	        TreeNode<T> root = convertStr2TreeNode(vals[0]);
		TreeNode<M> root = convertJsonStr2GenericJavaObject(vals[0].trim(), clazz0, clazz1);
		list.add(root);
		int index = 0;
		boolean isLeftChild = true;
		// 数组里面的只要不是null必须生成新的node，并且连接好
		// 数组里面的null不处理，只用来占位，所以不会生成新node
		// 循环变量i，isLeftChild 和 index
		for (int i = 1; i < vals.length; i++) {
			// index = (i-1)/2;
			vals[i] = vals[i].trim();
			if (vals[i].startsWith("\"") && vals[i].endsWith("\"")) {
				vals[i] = vals[i].substring(1, vals[i].length() - 1);
			}
			if (!vals[i].equals("") && !vals[i].equals("#") && !vals[i].equals("null")) {
//	                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
				TreeNode<M> node = convertJsonStr2GenericJavaObject(vals[i].trim(), clazz0, clazz1);
				if (isLeftChild) {
					list.get(index).left = node;
				} else {
					list.get(index).right = node;
				}
				list.add(node);
			}
			if (!isLeftChild) {
				index++;
			}
			// index = i/2;
			isLeftChild = !isLeftChild;
		}
		return root;
	}

//	    public static String serialize(TreeNode root) {
	public static <T> String fromTreeToString(TreeNode<T> root) {
		if (root == null) {
			return "{}";
		}
		// 生成一个node的list,此list包含null节点
		ArrayList<TreeNode<T>> list = new ArrayList<TreeNode<T>>();
		list.add(root);
		// 此时queue size是动态增长的
		for (int i = 0; i < list.size(); i++) {
			TreeNode<T> node = list.get(i);
			// [考点]精彩之处，是null跳过，不会死循环，size不会增长
			if (node == null) {
				continue;
			}
			// [考点]精彩之处，不用考察是否是null，闭着眼睛加入
			list.add(node.left);
			list.add(node.right);
		}
		// 去除list后面的可能的null
		while (list.get(list.size() - 1) == null) {
			list.remove(list.size() - 1);
		}
		// 下面简单了，根据node list生成String
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(list.get(0).val);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) == null) {
				sb.append(",#");
			} else {
				sb.append(",");
				sb.append(list.get(i).val);
			}
		}
		sb.append("}");
		return sb.toString();
	}

	public static class TracingNodeInfo {
		public List<Object> vals = new ArrayList<>();
		public String valsStr = "";

		public int lenghtInTotal;
		public int level;
//		public int groupId;
//		public int groupIndex;

		// how to print: delimiterStr + preWidth + valsStr + postWidth +
		// delimiterStr + widthBtwNodes
		// determine where the first character is in valsStr which is used to
		// connect nodes
		public String delimiterStr = " ";
		public int preWidth;// hard to say where it is except for the last one
		public int postWidth;// hard to say where it is except for the last one

		public List<TracingNodeInfo> children = new ArrayList<>();
		public int widthBtwNodes = 1;

		@JsonCreator
		public TracingNodeInfo(Object... objects) {
			super();
			valsStr += "[";
			for (Object object : objects) {
				valsStr += object.toString() + ", ";
				this.vals.add(object);
			}
			valsStr += "]";

		}

		public TracingNodeInfo() {
			super();
		}

		public int getWidthBtwNodes() {
			return widthBtwNodes;
		}

		public void setWidthBtwNodes(int widthBtwNodes) {
			this.widthBtwNodes = widthBtwNodes;
		}

		public int getLenghtInTotal() {
			return lenghtInTotal;
		}

		public void setLenghtInTotal(int lenghtInTotal) {
			this.lenghtInTotal = lenghtInTotal;
		}

		public String getDelimiterStr() {
			return delimiterStr;
		}

		public void setDelimiterStr(String delimiterStr) {
			this.delimiterStr = delimiterStr;
		}

		public List<Object> getVals() {
			return vals;
		}

		public void setVals(List<Object> vals) {
			this.vals = vals;
		}

		public String getValsStr() {
			return valsStr;
		}

		public void setValsStr(String valsStr) {
			this.valsStr = valsStr;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

//		public int getGroupId() {
//			return groupId;
//		}
//
//		public void setGroupId(int groupId) {
//			this.groupId = groupId;
//		}
//
//		public int getGroupIndex() {
//			return groupIndex;
//		}
//
//		public void setGroupIndex(int groupIndex) {
//			this.groupIndex = groupIndex;
//		}

		public int getPreWidth() {
			return preWidth;
		}

		public void setPreWidth(int preWidth) {
			this.preWidth = preWidth;
		}

		public int getPostWidth() {
			return postWidth;
		}

		public void setPostWidth(int postWidth) {
			this.postWidth = postWidth;
		}

		public List<TracingNodeInfo> getChildren() {
			return children;
		}

		public void setChildren(List<TracingNodeInfo> children) {
			this.children = children;
		}

	}

	public static class TracingLevelInfo {
		static public class TracingLevelGroup {

			public final String delimiterOfGroups = " "; // ;
			public TracingNodeInfo root;
			public List<TracingNodeInfo> children = new ArrayList<>();
			public int widthBtwNodes = 0; // only between internal nodes or to
											// be decided
			public String groupStr = "";
			public String connStr = "";

			public TracingNodeInfo getRoot() {
				return root;
			}

			public void setRoot(TracingNodeInfo root) {
				this.root = root;
			}

			public List<TracingNodeInfo> getChildren() {
				return children;
			}

			public void setChildren(List<TracingNodeInfo> children) {
				this.children = children;
			}

			public int getWidthBtwNodes() {
				return widthBtwNodes;
			}

			public void setWidthBtwNodes(int widthBtwNodes) {
				this.widthBtwNodes = widthBtwNodes;
			}

			public String getGroupStr() {
				return groupStr;
			}

			public void setGroupStr(String groupStr) {
				this.groupStr = groupStr;
			}

			public String getConnStr() {
				return connStr;
			}

			public void setConnStr(String connStr) {
				this.connStr = connStr;
			}

		}

		public int level;
		public int numOfNodes;
		public List<TracingLevelGroup> groups = new ArrayList<>();
		public TracingLevelInfo prev;

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public int getNumOfNodes() {
			return numOfNodes;
		}

		public void setNumOfNodes(int numOfNodes) {
			this.numOfNodes = numOfNodes;
		}

		public List<TracingLevelGroup> getGroups() {
			return groups;
		}

		public void setGroups(List<TracingLevelGroup> groups) {
			this.groups = groups;
		}

		public TracingLevelInfo getPrev() {
			return prev;
		}

		public void setPrev(TracingLevelInfo prev) {
			this.prev = prev;
		}

	}

	public static class TracingTreeInfo {
		public TracingNodeInfo root;
		public TreeMap<Integer, TracingLevelInfo> map = new TreeMap<>();

		public int height;
		public int numOfNodes;

		public TracingTreeInfo(TracingNodeInfo root) {
			this.root = root;
		}

		public TracingNodeInfo getRoot() {
			return root;
		}

		public void setRoot(TracingNodeInfo root) {
			this.root = root;
		}

		public TreeMap<Integer, TracingLevelInfo> getMap() {
			return map;
		}

		public void setMap(TreeMap<Integer, TracingLevelInfo> map) {
			this.map = map;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public int getNumOfNodes() {
			return numOfNodes;
		}

		public void setNumOfNodes(int numOfNodes) {
			this.numOfNodes = numOfNodes;
		}

		public void print() {
			// TODO Auto-generated method stub
			adjustTreeInfo();
			Set<Integer> set = map.keySet();
			for (Integer key : set) {
				TracingLevelInfo value = map.get(key);
				String connStr = "";
				String levelStr = "";
//				for(TracingLevelGroup group : value.groups){
				for (int i = 0; i < value.groups.size(); i++) {
					TracingLevelGroup group = value.groups.get(i);
//					if (group.root == null) {// real root node
//						levelStr += group.groupStr;
//					}else {
//					}
					connStr += group.connStr;
					levelStr += group.groupStr;
//					for (int j = 0; j < group.children.size(); j++) {
//						TracingNodeInfo node = group.children.get(j);
//							if( i == 0) {
//								levelStr += node.delimiterStr +generateCharStr(node.preWidth) + node.valsStr + generateCharStr(node.postWidth);
//							}else {
//								levelStr += generateCharStr(group.widthBtwNodes) + node.delimiterStr +generateCharStr(node.preWidth) + node.valsStr + generateCharStr(node.postWidth);
//							}
//					}
				}
				System.out.println(" connStr: " + connStr);
				System.out.println("levelStr: " + levelStr);
			}

		}

		private String generateCharStr(int widthBtwNodes) {
			// TODO Auto-generated method stub
			return generateCharStr(widthBtwNodes, ' ');
		}

		private String generateCharStr(int widthBtwNodes, char ch) {
			// TODO Auto-generated method stub
			String string = "";
			while (--widthBtwNodes >= 0) {
				string += ch;
			}
			return string;
		}

		private void adjustTreeInfo() {
			// TODO Auto-generated method stub
			NavigableSet<Integer> set = map.descendingKeySet();
			for (Integer key : set) {
				TracingLevelInfo value = map.get(key);
				System.out.printf("key:value  %d:%d \n", key, value.numOfNodes);
				String levelStr = "";
				for (TracingLevelGroup group : value.groups) {
//					levelStr += " || ";
//					for(TracingNodeInfo node : group.children) {
					if (group.root == null) {// real root node
						TracingNodeInfo node = group.children.get(0);
						group.groupStr += node.delimiterStr + generateCharStr(node.preWidth) + node.valsStr
								+ generateCharStr(node.postWidth);

						break;
					}
					int rootLen = 2 * group.root.delimiterStr.length() + group.root.preWidth
							+ group.root.valsStr.length() + group.root.postWidth;
					int groupLen = 0;
					while (groupLen < rootLen) {
						System.out.println("group.widthBtwNodes: " + group.widthBtwNodes);
						group.widthBtwNodes++;
						for (int i = 0; i < group.children.size(); i++) {
							// how to print: delimiterStr + preWidth + valsStr +
							// postWidth + delimiterStr + widthBtwNodes
							// determine where the first character is in valsStr
							// which is used to connect nodes
							TracingNodeInfo node = group.children.get(i);
							if (i == 0) {
								groupLen += 2 * node.delimiterStr.length() + node.preWidth + node.valsStr.length()
										+ node.postWidth;
							} else {
								groupLen += 2 * node.delimiterStr.length() + node.preWidth + node.valsStr.length()
										+ node.postWidth + group.widthBtwNodes;
							}
//						levelStr += ""+  node.delimiterStr + node.preWidth+"!"+node.valsStr+"!"+node.postWidth+node.delimiterStr; 
//						levelStr += ""+  2* node.delimiterStr + node.preWidth+"!"+node.valsStr+"!"+node.postWidth+group.widthBtwNodes;
//						System.out.println(""+  node.delimiterStr + node.preWidth+"!"+node.valsStr+"!"+node.postWidth+node.delimiterStr );
						}
					}
					// here : groupLen >= rootLen, got new widthBtwNodes, update
					// preWidth and postWidth of root
					// And, generate group string and connect, print group
					// string level by level later
					group.groupStr = "";
					group.connStr = "";
					for (int i = 0; i < group.children.size(); i++) {
						TracingNodeInfo node = group.children.get(i);
						node.widthBtwNodes = group.widthBtwNodes;
						if (i == 0) {
							group.connStr += node.delimiterStr + generateCharStr(node.preWidth)
									+ generateCharStr(1, '+') + generateCharStr(
											node.valsStr.length() - 1 + node.postWidth + node.widthBtwNodes, '-');
							group.groupStr += node.delimiterStr + generateCharStr(node.preWidth) + node.valsStr
									+ generateCharStr(node.postWidth + node.widthBtwNodes);
						} else if (i == group.children.size() - 1) {
							group.connStr += generateCharStr(
									group.widthBtwNodes + node.delimiterStr.length() + node.preWidth, '-')
									+ generateCharStr(1, '+')
									+ generateCharStr(node.valsStr.length() - 1 + node.postWidth + node.widthBtwNodes);
							group.groupStr += generateCharStr(group.widthBtwNodes) + node.delimiterStr
									+ generateCharStr(node.preWidth) + node.valsStr
									+ generateCharStr(node.postWidth + node.widthBtwNodes);
						} else {
							group.connStr += generateCharStr(
									group.widthBtwNodes + node.delimiterStr.length() + node.preWidth, '-')
									+ generateCharStr(1, '+') + generateCharStr(
											node.valsStr.length() - 1 + node.postWidth + node.widthBtwNodes, '-');
							group.groupStr += generateCharStr(group.widthBtwNodes) + node.delimiterStr
									+ generateCharStr(node.preWidth) + node.valsStr
									+ generateCharStr(node.postWidth + node.widthBtwNodes);
						}
//						group.connStr += generateCharStr(node.widthBtwNodes,'-');
//						group.groupStr += generateCharStr(node.widthBtwNodes);
					}

					group.connStr += generateCharStr(group.root.widthBtwNodes);// +group.delimiterOfGroups;
					group.groupStr += generateCharStr(group.root.widthBtwNodes);// +group.delimiterOfGroups;

					int diff = groupLen - 2 * group.root.delimiterStr.length() - group.root.valsStr.length();
					group.root.lenghtInTotal = groupLen;
					group.root.preWidth = diff / 2;
					group.root.postWidth = diff - group.root.preWidth;

					int prefix = group.root.delimiterStr.length() + group.root.preWidth;
					group.connStr = group.connStr.substring(0, prefix) + '^' + group.connStr.substring(prefix + 1);

					System.out.println(" connStr: " + group.connStr);
					System.out.println("groupStr: " + group.groupStr);

					// where is root and its children, lenth is groupLen

				}
			}

		}

	}

//=== Tracing Para for Binary Tree or Kinary-Tree ===================================

	public static class TPB {
		private String paraList = ""; //"[result]"
		private String paraFilter = ""; //"0110"

		public TPB paraList(String paraList) {
			this.paraList = paraList;
			return this;
		}

		public TPB paraFilter(String paraFilter) {
			this.paraFilter = paraFilter;
			return this;
		}

		public TP build(TP parent, Object... objects) {
			return new TP(paraList, paraFilter, parent, objects);
		}

	}

//	TP is an alias TracingPara
	public static class TP {
//		设计一个Singlton 存储 TP打印出来的外观方面的设置
//		父亲孩子连接字符 '---------' ; 指向父亲 '^' ; 指向孩子 '+', 二者重叠 '+-^'
//		数值包围字符'[',']'; 是否打印null，是否打印LR标记;
		public static final String PARA_VALUES_LEFT_BOUNDARY = "[";
		public static final String PARA_VALUES_RIGHT_BOUNDARY = "]";
//		public static final String BASE_CASE_MAKER = "*";
		public static final String PARA_CONNECTION_CHAR = ":";
//		public static String paraList = ""; //"[result]"
//		public static String paraFilter = ""; //"0110"

		private TracingRecu tracingRecu;
//		public TracingRecu tracingRecu;

		public static final String IS_MARKED_STR = "*";

		public static final Boolean IS_BASE_CASE = Boolean.TRUE;
		public static final Boolean NOT_BASE_CASE = Boolean.FALSE;
//		public static final String BASE_CASE_MARKER = " <== BASE CASE";
		public static final String BASE_CASE_MARKER = "<== Collected";
//		public static final String BASE_CASE_MARKER = "*";
//		public static final String BASE_CASE_MAKER = String.valueOf(Character.toChars(0x00AE));
		private boolean isCollected;// added on Jun 30, 2019// the base case that has been collected
		private static Map<String, TP> idTpMap = new HashMap<>();//仅仅服务于部分情况，不是所有的都存进来
		public boolean isMarked;// added on Jun 30, 2019//被标记了吗
		public boolean isOrderMarked;// added on Jun 30, 2019
		
		
		public boolean isCollected() {
			return isCollected;
		}

		public void setCollected(boolean isCollected) {
			if(!this.isCollected) {
				tracingRecu.paraStr += BASE_CASE_MARKER;
			}
			this.isCollected = isCollected;
		}

		//默认6个打印方法
		public void print() {
			this.tracingRecu.print();
		}

		public void print(boolean toLeft) {
			this.tracingRecu.print(toLeft);
		}

		public void print(String paraFilter) {
			this.tracingRecu.print(paraFilter);
		}

		public void print(String paraList, String paraFilter) {
			this.tracingRecu.print(paraList, paraFilter);
		}

		public void print(String paraFilter, boolean toLeft) {
			this.tracingRecu.print(paraFilter, toLeft);
		}

		public void print(String paraList, String paraFilter, boolean toLeft) {
			this.tracingRecu.print(paraList, paraFilter, toLeft);
		}

//   --- TP build() START ----------------------------------------------------------------------------------------------

//	 --- TP build() START --- For Root ---------------------------------------------------------------------------------
//		static class TPSetting{//for one TP or entire TP
//			String paraList;
//			String paraFilter;
//			String id;
//			
//		}
//		TP parent;
//		TPSetting settings;
//		public static TP build(TPSetting setting, TP parent, Object... objects) {
//			return null;
//		}
//		public static TP build(TP parent, Object... objects) {
//			return build(parent.setting, parent, objects);
//		}
		public static TP build(String paraList, String paraFilter, String id, TP parent) {
			TP tp = new TP(paraList, paraFilter, parent);
			String key = generateTpKey(id, parent);
			if (idTpMap.containsKey(key)) {
//				throw new Exception(
//						"TP Already Exist!!! ID and Parent are NOT unique! When TP build(Object id, TP parent)");
				System.out.println(
						"TP Already Exist!!! ID and Parent are NOT unique! When TP build(Object id, TP parent)");
			}
			idTpMap.put(key, tp);
			return tp;
		}

//		paraList用来解释后面的参数列表的含义, paraFilter用来过滤参数，parent表示父亲是谁，objects是参数列表
		public static TP build(String paraList, String paraFilter, TP parent, Object... objects) {
			return new TP(paraList, paraFilter, parent, objects);
		}

		public static TP build(String paraList, String paraFilter, String id, TP parent, Object... objects) {
			TP tp = new TP(paraList, paraFilter, parent, objects);
			String key = generateTpKey(id, parent);
			if (idTpMap.containsKey(key)) {
//				throw new Exception(
//						"TP Already Exist!!! ID and Parent are NOT unique! When TP build(Object id, TP parent)");
				System.out.println(
						"TP Already Exist!!! ID and Parent are NOT unique! When TP build(Object id, TP parent)");
			}
			idTpMap.put(key, tp);
			return tp;
		}

//   --- TP build() START --- For Children ---------------------------------------------------------------------------------

//		只有通过这样调用的才放进Map，然后取出来
		public static TP build(String id, TP parent) {
			// TODO Auto-generated method stub
			TP tp = new TP(id, parent);
			String key = generateTpKey(id, parent);
			if (idTpMap.containsKey(key)) {
//				throw new Exception(
//						"TP Already Exist!!! ID and Parent are NOT unique! When TP build(Object id, TP parent)");
				System.out.println(
						"\"TP Already Exist!!! ID and Parent are NOT unique! When TP build(Object id, TP parent)\"");
			}
			idTpMap.put(key, tp);
			return tp;
		}

		public static TP build(String id, TP parent, Object... objects) {
			// TODO Auto-generated method stub
			String key = generateTpKey(id, parent);
			TP tp = idTpMap.get(key);
			if (tp == null) {
//				throw new Exception("TP NOT Exist!!! When TP build(Object id, TP parent)");
				System.out.println("TP NOT Exist!!! When TP build(Object id, TP parent)");
				return null;
			}
			updatePara(false, "", "", tp, objects);
			return tp;
		}

		public static TP build(TP parent, Object... objects) {
			return new TP(parent, objects);
		}

//	   --- TP build() START --- For Base Case ---------------------------------------------------------------------------------

		public static TP build(boolean isBaseCaseTP, TP parent, Object... objects) {
			return new TP(isBaseCaseTP, parent, objects);
		}

//		public static TP build(boolean isBaseCaseTP, String id, TP parent, Object... objects) {
//			String key = generateTpKey(id, parent);
//			TP tp = idTpMap.get(key);
//			if (tp == null) {
////				throw new Exception("TP NOT Exist!!! When TP build(Object id, TP parent)");
//				System.out.println("TP NOT Exist!!! When TP build(Object id, TP parent)");
//				return null;
//			} 
//			updatePara(isBaseCaseTP, tp, objects);
////			builder(isBaseCaseTP, paraList, paraFilter, tp, objects);
//
//			return tp;
//		}

		private static String generateTpKey(String id, TP parent) {
			return String.valueOf(id) + String.valueOf(parent);
		}

//   --- TP build() END -------------------------------------------------------------------------------------

//   --- Constructors START ---------------------------------------------------------------------------------

		public TP(TP parent, Object... objects) {
			this(false, "", "", parent, objects);
		}

		public TP(boolean isBaseCaseTP, TP parent, Object... objects) {
			this(isBaseCaseTP, "", "", parent, objects);
		}

		public TP(boolean isBaseCaseTP, String id, TP parent, Object... objects) {//July 03, 2019
			this(isBaseCaseTP, "", "", parent, objects);
		}

		public TP(String id, TP parent) {//July 03, 2019
			this.tracingRecu = new TracingRecu(this, parent == null ? null : parent.tracingRecu);
		}

		public TP(boolean isBaseCaseTP, String paraList, String paraFilter, TP parent, Object... objects) {
			builder(isBaseCaseTP, paraList, paraFilter, parent, objects);
		}

		//本质实现：TracingParameters, 参数列表，参数过滤开关，父亲，参数列表
		public TP(String paraList, String paraFilter, TP parent, Object... objects) {
			builder(false, paraList, paraFilter, parent, objects);
		}

		private void builder(boolean isBaseCaseTP, String paraList, String paraFilter, TP parent, Object... objects) {
			this.isCollected = isBaseCaseTP;
			this.tracingRecu = new TracingRecu(this, parent == null ? null : parent.tracingRecu);
			this.tracingRecu.root = parent == null ? this.tracingRecu : parent.tracingRecu.root;//如果是root，整个树root就是自己；如果不是

			updatePara(isBaseCaseTP, paraList, paraFilter, this, objects);
		}

		private static void updatePara(boolean isBaseCaseTP, String paraList, String paraFilter, TP tp,
				Object... objects) {
//			this.rootOfTree = 
//			System.out.println("id: "+ this.tracingRecu.id);
			TracingRecu.PARA_LIST = paraList.isEmpty() ? TracingRecu.PARA_LIST : paraList;
			TracingRecu.PARA_FILTER = paraFilter.isEmpty() ? TracingRecu.PARA_FILTER : paraFilter;
			paraList = TracingRecu.PARA_LIST;
			paraFilter = TracingRecu.PARA_FILTER;
//			if(isBaseCaseTP) System.out.println("paraList: "+paraList);
//			if(isBaseCaseTP) System.out.println("paraFilter: "+paraFilter);

//			paraList = TracingRecu.PARA_LIST.isEmpty() ? paraList : TracingRecu.PARA_LIST;
//			paraFilter = TracingRecu.PARA_FILTER.isEmpty() ? paraFilter : TracingRecu.PARA_FILTER;

			for (int i = 0; i < paraFilter.length(); i++) { //Object ob : objects) {
				if (paraFilter.charAt(i) != '0' && paraFilter.charAt(i) != '1') {
					System.out.println("Error: Parameter Filter MUST contain only '0' or '1'! ");
					System.exit(0);
				}
			}
			StringBuilder sbParaStr = tp.tracingRecu.sbParaStr;
			if (objects == null || objects.length == 0) {
				tp.tracingRecu.paraStr = sbParaStr.toString();
			} else {
				if (paraFilter.length() != 0 && paraFilter.length() != objects.length) {
					System.out.println("Error: Length NOT Match! Parameter Filter and Parameters! ");
					System.exit(0);
				}
//				if(isBaseCaseTP) {
//					sb.append(BASE_CASE_MAKER);
//				}
				sbParaStr.append(PARA_VALUES_LEFT_BOUNDARY);
				String conn = "";
				for (int i = 0; i < objects.length; i++) { //Object ob : objects) {
					if (paraFilter.length() == 0 || (paraFilter.length() != 0 && paraFilter.charAt(i) == '1')) {
//						String para = String.valueOf(objects[i]);//trim() is so important that without it the length would not be accurate
						String para = String.valueOf(objects[i]).trim();//trim() is so important that without it the length would not be accurate
						sbParaStr.append(conn).append(para);
						conn = PARA_CONNECTION_CHAR;
					} else {
						sbParaStr.append(PARA_CONNECTION_CHAR);
					}
				}
				sbParaStr.append(PARA_VALUES_RIGHT_BOUNDARY);
				if (isBaseCaseTP) {
					sbParaStr.append(BASE_CASE_MARKER);
				}
//				System.out.println("paraStr: "+sb.toString());
				tp.tracingRecu.paraStr = sbParaStr.toString();
				if (tp.isMarked) {
//					tp.tracingRecu.paraStr += "*";
					System.out.println("tp.isMarked  "+tp.isMarked);
					tp.tracingRecu.paraStr += TP.IS_MARKED_STR;
				}
				if (tp.isOrderMarked) {
					System.out.println("tp.isOrderMarked  "+tp.isOrderMarked);
					tp.tracingRecu.paraStr += "*";
					tp.tracingRecu.paraStr += tp.tracingRecu.root.accessOrder;
				}

//				System.out.printf(">%s<:>%d<\n",this.tracingRecu.paraStr, this.tracingRecu.paraStr.length());
			}
		}

		public void mark() {
			if (!this.isMarked) {
				isMarked = true;
				this.tracingRecu.paraStr += TP.IS_MARKED_STR;
			}
		}

		public void markOrder() {
			if (!this.isOrderMarked) {
				isOrderMarked = true;
				this.tracingRecu.root.accessOrder++;
			}
		}

//  --- Constructors END ---------------------------------------------------------------------------------

//		public void hasReturn() {
//			// TODO Auto-generated method stub
//			hasReturn = true;
//		}

//	public TracingPara(TracingPara parent, String ... paras) {
//	this.tracingRecu = new TracingRecu(parent == null ? null : parent.tracingRecu);
//	
////	this.tracingRecu.paraFormat = "[id:arr]";
//	this.tracingRecu.paraFormat = "";
//	
//	StringBuilder sb = new StringBuilder();
//	if(paras == null) {
//		this.tracingRecu.paraStr = sb.toString();
//	}else {
//		sb.append("[");
//		String conn = "";
//		for(String para : paras) {
//			sb.append(conn).append(para);
//			conn = ":";
//		}
//		sb.append("]");
//		this.tracingRecu.paraStr = sb.toString();
//	}
//}

	}

	public static class TracingRecu {
		private TP tp;
//		public TP tp;
		private static String PARA_LIST = ""; //"[result]"
		private static String PARA_FILTER = ""; //"0110"

//		private String paraStr = "";
		public String paraStr = "";
		private StringBuilder sbParaStr = new StringBuilder();

		private static int MOVE_TO_RIGHT_TO_POINT_TO_PARENT = 2;
		private static int LENGTH_OF_TRACING_TREE = 0;
//		private static TreeMap<Integer, List<TracingRecu>> LEVEL_NODE_MAP = new TreeMap<>();
		private TreeMap<Integer, List<TracingRecu>> LEVEL_NODE_MAP = new TreeMap<>();
		private static int COUNTER = 0;//干什么用呢？
		private static char CHAR_POINT_TO_PARENT = '^';
		private static char CHAR_BTW_PARENT_AND_CHILDREN = '-';
		private static char CHAR_POINT_TO_CHILD = '+';
		private static char CHAR_SECTION = '=';
		private static char CHAR_DEFAULT_SPACE = ' ';

		private static char CHAR_DELIMETER = ' '; //' ' or '|'
		private static char CHAR_PRE = ' '; //' ' or '>'
		private static char CHAR_POST = ' '; //' ' or '<'
		private static char CHAR_BETWEEN_SIBLINGS = ' '; //' ' or 'H'
		private static char CHAR_BETWEEN_CHILDREN = ' '; //' ' or 'U'

//		private static char CHAR_DELIMETER = '|';        //' ' or '|'
//		private static char CHAR_PRE = '>';              //' ' or '>'
//		private static char CHAR_POST = '<';             //' ' or '<'
//		private static char CHAR_BETWEEN_SIBLINGS = 'H'; //' ' or 'H'
//		private static char CHAR_BETWEEN_CHILDREN = 'U'; //' ' or 'U'

		private int accessOrder = 0;//怎么用法？？
		private TracingRecu root;//指向自己所在树的根
		private TracingRecu parent;//指向自己的父亲
		private List<TracingRecu> children = new ArrayList<>();
		private TracingRecu rightMostChild;
		private boolean isRightMostChild = false;

		private int id; // 调用次序 和 id
		private int level = 0;
		private int pos = 0;//表明node的位置，相对于左侧起始点的位置，只可以在自上而下的过程中计算出来，父亲pos+相对父亲的pos

		private int delimiterWidth = 1;
		private int preWidth = 0;
		private String nodeStr = "";// Diff from paraStr, it is delimiter+pre+paraStr+ post+delimiter
		private String connStr = ""; // this is supposed to connect node and its children
		private int postWidth = 0;
		private int widthBtwSiblings = 0; // only between internal nodes or to be decided (Updated: for spaces
											// between siblings)
		private int widthBtwChildren = 0; // only between internal nodes or to
											// be decided (Updated: for spaces
											// between children)
		private Object[] objects;
		private int numOfNodesInTotal;// used yet
		private int numOfUsedBaseCases;// used yet

		public TracingRecu(TP tp,TracingRecu parent) {
			this(tp, parent, new Object[0]);
		}

		public TracingRecu(TP tp, TracingRecu parent, Object... objects) {
			super();
			this.tp = tp;
			this.id = COUNTER++;
			this.parent = parent;
			this.root = parent == null ? this : this.parent.root;

			if (parent != null) {
				parent.children.add(this);
			}
			if (parent == null) {
				this.level = 0;
			} else {
				this.level = parent.level + 1;
			}
			TreeMap<Integer, List<TracingRecu>> LEVEL_NODE_MAP = this.root.LEVEL_NODE_MAP;
			List<TracingRecu> list = LEVEL_NODE_MAP.getOrDefault(this.level, new ArrayList<>());
//			List<TracingRecu> list = parent.root.LEVEL_NODE_MAP.getOrDefault(this.level, new ArrayList<>());
			list.add(this);

			LEVEL_NODE_MAP.putIfAbsent(this.level, list);
			if (objects == null || objects.length == 0) {
				this.objects = new Object[0];
			} else {
				this.objects = new Object[objects.length];
				for (int i = 0; i < objects.length; i++) {
					this.objects[i] = objects[i].toString();
				}
			}

		}

		//when printing, 
//		String, comment what they are, defaults to ""
//		String, show what they are, defaults to ""
//		Boolean, if show them to the left most, defaults to False

		//by default, print all parameters and not to left most 
		public void print() {
			boolean toLeft = false;
			print(toLeft);
			toLeft = true;
			print(toLeft);
		}

		public void print(String paraStrFilter) {
			print();
		}

		//boolean toLeft determines if print the node to the left most 
		public void print(String paraList, String paraFilter) {
			print();
		}

		//by default, print specified parameters and print to left most 
		public void print(String paraStrFilter, boolean toLeft) {
			print(toLeft);
		}

		//boolean toLeft determines if print the node to the left most 
		public void print(String paraList, String paraFilter, boolean toLeft) {
			print(toLeft);
		}

//		bottomUp2UpdateWidthBtwChildren: 自下而上，从孩子看父亲，调整父亲本身宽度，保证属于同一父亲的孩子中间的宽度
//		topDown2UpdateWidthBtwSiblings:  自上而下，从父亲看孩子，调整孩子之间距离，更新属于同一父亲的孩子中间的宽度
		public void print(boolean toLeft) {
			bottomUp2UpdateWidthBtwChildren(toLeft);
//		verifyLevelStrAndConnStr(true);
			topDown2UpdateWidthBtwSiblings(toLeft);
//		verifyLevelStrAndConnStr(true);
			printLevelStrAndConnStr(toLeft);

		}

		private void verifyLevelStrAndConnStr(boolean needVerify) {
			// from root to leaf, update widthBtwNodes for rightMostChild
			if (!needVerify) {
				return;
			}
			System.out.println(
					"---[VERIFYING START]-----------------------------------------------------------------------------");
			int numOfTrue = 0, numOfFalse = 0;
			TreeMap<Integer, List<TracingRecu>> LEVEL_NODE_MAP = this.root.LEVEL_NODE_MAP;
			NavigableSet<Integer> set = LEVEL_NODE_MAP.navigableKeySet();
			for (Integer key : set) {
				for (TracingRecu node : LEVEL_NODE_MAP.get(key)) {
					if (node.children.size() == 0) {
						continue;
					}
					TracingRecu curr = node;
					while (curr.rightMostChild != null) {
						curr.rightMostChild.widthBtwSiblings = curr.widthBtwSiblings;
						curr = curr.rightMostChild;
					}
					final String DELIMITER = "|";
					String expected = DELIMITER + node.nodeStr + DELIMITER + generateCharStr(node.widthBtwSiblings)
							+ DELIMITER;
					String actural = DELIMITER;
					for (int i = 0; i < node.children.size(); i++) {
						TracingRecu child = node.children.get(i);
						if (i != node.children.size() - 1) {
							actural += child.nodeStr + generateCharStr(child.widthBtwSiblings);
						} else {
							actural += child.nodeStr;
						}
					}
					actural += DELIMITER + generateCharStr(node.widthBtwSiblings) + DELIMITER;
					String result = (expected.length() == actural.length() ? "TRUE" : "FALSE");
					if (expected.length() == actural.length()) {
						numOfTrue++;
						result = "TRUE";
					} else {
						numOfFalse++;
						result = "FALSE";
					}
					System.out.println("\n[Verifying ... ] id: " + node.id);
					System.out.println(expected);
					System.out.println(actural);
					System.out.println("[Result] " + result + "\n");
				}
			}
			String finalResult = "";
			String details = " NumOfTrue: " + numOfTrue + ", NumOfFalse: " + numOfFalse + " ";
			if (numOfTrue == 0 && numOfFalse == 0) {
				finalResult += "NOT VERIFIED!" + details;
			} else if (numOfTrue == 0) {
				finalResult += "SORRY! ALL FALSE!" + details;
			} else if (numOfFalse == 0) {
				finalResult += "CONGRATULATIONS! ALL TRUE!" + details;
			} else {
				finalResult += "WARNING! NOT ALL TRUE, NOT ALL FALSE!" + details;
			}
			System.out.println("[VERIFYING SUMMARY] " + finalResult + " \n");
			System.out.println(
					"---[VERIFYING START]-----------------------------------------------------------------------------\n");
		}

//		计算 node的nodeStr: delimeter+pre+paraStr+post+delimeter
//		从下而上，每一个节点都有widthBtwSiblings，每一个节点的widthBtwChildren表明孩子们间的距离，其值等于最后一个孩子们widthBtwSiblings
//		表明一个节点是不是isRightMostChild，寻找一个节点的rightMostChild == node.rightMostChild
		@SuppressWarnings("static-access")
		private void bottomUp2UpdateWidthBtwChildren(boolean toLeft) {
//		got new widthBtwChildren, relocate nodeStr and update preWidth and postWidth of root
//		update parent.nodeStr 
			this.numOfNodesInTotal = 0;
			TreeMap<Integer, List<TracingRecu>> LEVEL_NODE_MAP = this.root.LEVEL_NODE_MAP;
			NavigableSet<Integer> set = LEVEL_NODE_MAP.descendingKeySet();//自下而上，层数降序，逐层遍历
			for (Integer key : set) {
				List<TracingRecu> list = LEVEL_NODE_MAP.get(key);
				this.numOfNodesInTotal += list.size();
				for (TracingRecu node : list) {
//				this.nodeWidth = this.tracingPara.paraStr.length();
//					generateNodeParaStr(node);
					node.nodeStr = "";
					if (node.children.size() == 0) {//叶子节点
						node.nodeStr = generateCharStr(node.delimiterWidth, CHAR_DELIMETER)
								+ generateCharStr(node.preWidth, CHAR_PRE) + node.paraStr
								+ generateCharStr(node.postWidth, CHAR_POST)
								+ generateCharStr(node.delimiterWidth, CHAR_DELIMETER);

//						node.nodeStr += generateCharStr(node.delimiterWidth + node.preWidth) + node.paraStr
//								+ generateCharStr(node.postWidth + node.delimiterWidth);
						node.connStr += "";
						continue;
					}
//					==> 让node向外扩张，对齐孩子的宽度，调整了node.preWidth和node.postWidth
//				int nodeLen = 2 * node.delimiterWidth + node.preWidth + node.nodeWidth + node.postWidth;
					int nodeLen = 2 * node.delimiterWidth + node.preWidth + node.paraStr.length() + node.postWidth;
					int childrenLen = 0;
					while (childrenLen < nodeLen) {//孩子们同步膨胀，直到总宽度大于父亲为止
						node.widthBtwChildren++;
//					System.out.printf("id:node.widthBtwChildren++ %d:%d \n", node.id, node.widthBtwChildren);
						for (int i = 0; i < node.children.size(); i++) {
							TracingRecu child = node.children.get(i);
							child.widthBtwSiblings = node.widthBtwChildren; // increase child.widthBtwNodes
//						System.out.printf("id:widthBtwSiblings %d:%d \n", child.id, child.widthBtwSiblings);
							if (i != node.children.size() - 1) {
								childrenLen += child.widthBtwSiblings;
							} else {
								child.isRightMostChild = true;
								node.rightMostChild = child;// for each node, mark right most child
							}
//						childrenLen += 2 * child.delimiterWidth + child.preWidth + child.nodeWidth
//								+ child.postWidth;
							childrenLen += 2 * child.delimiterWidth + child.preWidth + child.paraStr.length()
									+ child.postWidth;
						}
					}
//				System.out.printf("id:widthBtwSiblings %d:%d \n", node.id, node.widthBtwSiblings);
					// here : childrenLen >= nodeLen, got new widthBtwChildren,
					// relocate nodeStr and update preWidth and postWidth of
					// root
//				int diff = childrenLen - 2 * node.delimiterWidth - node.nodeWidth;
					int diff = childrenLen - 2 * node.delimiterWidth - node.paraStr.length();//
					node.preWidth = diff / 2;
					node.postWidth = diff - node.preWidth;

					if (!toLeft) {
						node.nodeStr = generateCharStr(node.delimiterWidth, CHAR_DELIMETER)
								+ generateCharStr(node.preWidth, CHAR_PRE) + node.paraStr
								+ generateCharStr(node.postWidth, CHAR_POST)
								+ generateCharStr(node.delimiterWidth, CHAR_DELIMETER);
						LENGTH_OF_TRACING_TREE = Math.max(LENGTH_OF_TRACING_TREE, node.nodeStr.length());
					} else {
						node.nodeStr = generateCharStr(node.delimiterWidth) + node.paraStr
								+ generateCharStr(node.preWidth + node.postWidth + node.delimiterWidth);
						node.nodeStr = generateCharStr(node.delimiterWidth, CHAR_DELIMETER) + node.paraStr
								+ generateCharStr(node.preWidth, CHAR_PRE) + generateCharStr(node.postWidth, CHAR_POST)
								+ generateCharStr(node.delimiterWidth, CHAR_DELIMETER);
						LENGTH_OF_TRACING_TREE = Math.max(LENGTH_OF_TRACING_TREE, node.nodeStr.length());
					}

//				System.out.println("nodeStr: "+node.nodeStr);
//				System.out.printf("nodeLen:childrenLen %d:%d \n", nodeLen, childrenLen);
//				System.out.printf("nodeLen:childrenLen %d:%d \n", node.delimiterWidth,node.preWidth,node., childrenLen);
				}
			}
		}

//		计算当前节点和孩子的pos，就可以计算当前节点的connStr了
//		计算 node的connStr: delimeter+pre+paraStr+post+delimeter，一个孩子和多个孩子计算外观不一样
		private void topDown2UpdateWidthBtwSiblings(boolean toLeft) {
			// from root to leaf, update widthBtwNodes for rightMostChild
			boolean needVerify = false;
			TreeMap<Integer, List<TracingRecu>> LEVEL_NODE_MAP = this.root.LEVEL_NODE_MAP;
			NavigableSet<Integer> set = LEVEL_NODE_MAP.navigableKeySet();
			for (Integer key : set) {
				for (TracingRecu node : LEVEL_NODE_MAP.get(key)) {
					if (node.children.size() == 0) {//没有孩子connStr为空
						continue;
					}
					//从当前节点，把widthBtwSiblings不断向rightMostChild传递
					TracingRecu curr = node;
					while (curr.rightMostChild != null) {
						curr.rightMostChild.widthBtwSiblings = curr.widthBtwSiblings;
						curr = curr.rightMostChild;
					}
//					计算node和孩子们的connStr
					TracingRecu firstChild = node.children.get(0);
					TracingRecu lastChild = node.children.get(node.children.size() - 1);
					int len = node.nodeStr.length();
					StringBuilder sbConnStr = new StringBuilder(generateCharStr(len));
					if (!toLeft) {
						int first = firstChild.delimiterWidth + firstChild.preWidth;//index: first - 1
						int last = len - lastChild.paraStr.length() - lastChild.postWidth - lastChild.delimiterWidth;//index: last - 1
						int pointToParent = node.delimiterWidth + node.preWidth;
						if (first == last) {//last == first, only one child
							last = first + firstChild.paraStr.length();
							pointToParent += MOVE_TO_RIGHT_TO_POINT_TO_PARENT;//非左对齐时，但只有一个孩子，也必须右移动默认2位
						}
						sbConnStr.replace(first, last, generateCharStr(last - first, CHAR_BTW_PARENT_AND_CHILDREN));//----------------
						sbConnStr.setCharAt(pointToParent, CHAR_POINT_TO_PARENT);//^
					} else {
						int first = firstChild.delimiterWidth;//index: first - 1
						int last = len - lastChild.paraStr.length() - lastChild.preWidth - lastChild.postWidth
								- lastChild.delimiterWidth;//index: last - 1
						int pointToParent = node.delimiterWidth + MOVE_TO_RIGHT_TO_POINT_TO_PARENT;//左对齐时，必须右移动默认2位
						if (first == last) {//last == first, only one child
							last = first + firstChild.paraStr.length();
						}
						sbConnStr.replace(first, last, generateCharStr(last - first, CHAR_BTW_PARENT_AND_CHILDREN));//----------------
						sbConnStr.setCharAt(pointToParent, CHAR_POINT_TO_PARENT);//^ 右偏移两位，躲过 +
					}
//					TopDown 求解node的相对和决定位置,然后计算 父亲到孩子的sbConnStr
					int dist = 0;
					for (int i = 0; i < node.children.size(); i++) {
						TracingRecu child = node.children.get(i);//依次得到孩子
						child.pos = node.pos + dist;
						dist += child.nodeStr.length() + child.widthBtwSiblings; //nodeStr的含义包含?其不包含widthBtwSiblings，其widthBtwSiblings表示同层孩子们的间距
						if (!toLeft) {
							sbConnStr.setCharAt(child.pos - node.pos + child.delimiterWidth + child.preWidth,
									CHAR_POINT_TO_CHILD);//+
						} else {
							sbConnStr.setCharAt(child.pos - node.pos + child.delimiterWidth, CHAR_POINT_TO_CHILD);//+ ???
						}
					}

					node.connStr = sbConnStr.toString();
					if (needVerify) {
						System.out.println("\n[Verifying ... ] id: " + node.id);
						final String DELIMITER = "|";
						String expected = DELIMITER + node.nodeStr + DELIMITER + generateCharStr(node.widthBtwSiblings)
								+ DELIMITER;
						System.out.println(expected);
						String actural = DELIMITER;
						for (int i = 0; i < node.children.size(); i++) {
							TracingRecu child = node.children.get(i);//依次得到孩子
							if (i != node.children.size() - 1) {
								actural += child.nodeStr + generateCharStr(child.widthBtwSiblings);
							} else {
								actural += child.nodeStr + DELIMITER + generateCharStr(child.widthBtwSiblings);
							}
						}
//					actural += DELIMITER + generateCharStr(node.widthBtwSiblings) + DELIMITER;
						actural += DELIMITER;
						System.out.println(actural);
						System.out.println(
								"[Result] " + (expected.length() == actural.length() ? "TRUE" : "FALSE") + "\n");
					}
				}
			}
		}

//		version 002
//		原始版本，bug是最后一行没有对齐，如果左侧没有元素的话
//		原始版本数据都正确，就是打印位置有偏差，修正方法是：
//		不再采用每行级联成一个string 然后打印；而是针对每一个元素 找对位置打印自己和连接孩子的string
//		每一个节点应该在前面都有个pos的属性，它告诉了当前节点的string的起始位置
//		每一行共用一个sbNodeStr和一个sbConnStr，初始化为最长的string，也就是root的string，然后每次打印完毕，delete(0, n)

		//01/31/2020: check if null, not print null and connstr
		private void printLevelStrAndConnStr(boolean toLeft) {
			final String DELIMITER = "";
			TreeMap<Integer, List<TracingRecu>> LEVEL_NODE_MAP = this.root.LEVEL_NODE_MAP;
			NavigableSet<Integer> set = LEVEL_NODE_MAP.navigableKeySet();
			int len = 300;
			String emptyStr = generateCharStr(LENGTH_OF_TRACING_TREE);
			StringBuilder levelNodeStr = new StringBuilder(emptyStr);// for each node
			StringBuilder levelConnStr = new StringBuilder(emptyStr); // for each node sbNodeStr.insert(root.pos, nodeStr);

			System.out.println();
			System.out.println(generateCharStr(len, CHAR_SECTION));
			System.out.println(":: Num Of Tree Nodes: " + this.root.numOfNodesInTotal);//print Num Of Tree Nodes:  
			System.out.println(generateCharStr(len, CHAR_SECTION));
			for (Integer level : set) {
				for (TracingRecu node : LEVEL_NODE_MAP.get(level)) {
					if (node.children.size() == 0) {// 当没有孩子时，只打印自己NodeStr，没有sbConnStr
						levelNodeStr.replace(node.pos, node.pos + node.nodeStr.length(), node.nodeStr);
					} else {
						levelNodeStr.replace(node.pos, node.pos + node.nodeStr.length(), node.nodeStr);//pos当前child最左端的绝对位置，
						levelConnStr.replace(node.pos, node.pos + node.connStr.length(), node.connStr);//如何从parent到孩子建立连接，从最左端开始计算

//						for (int i = 0; i < node.children.size(); i++) {
//							TracingRecu child = node.children.get(0);
//							levelNodeStr.replace(child.pos, child.pos + child.nodeStr.length(), child.nodeStr);//pos当前child最左端的绝对位置，
//							levelConnStr.replace(child.pos, child.pos + child.connStr.length(), child.connStr);//如何从parent到孩子建立连接，从最左端开始计算
//						}						
					}
				}
//				打印sbNodeStr和sbConnStr
				System.out.printf(TracingRecu.PARA_LIST + " %3d:%-6d%s\n", level, LEVEL_NODE_MAP.get(level).size(),
						levelNodeStr);
				System.out.printf(TracingRecu.PARA_LIST + " %3s %-6s%s\n", "", "", levelConnStr);

//				恢复空字符串，sbNodeStr和sbConnStr
				levelNodeStr.replace(0, emptyStr.length(), emptyStr);
				levelConnStr.replace(0, emptyStr.length(), emptyStr);
			}
			System.out.println(generateCharStr(len, CHAR_SECTION));
		}

		//新版本，先打印root，然后逐行打印当前节点的孩子们的 ConnStr + NodeStr
		private void printLevelStrAndConnStr001(boolean toLeft) {
			final String DELIMITER = "";
			TreeMap<Integer, List<TracingRecu>> LEVEL_NODE_MAP = this.root.LEVEL_NODE_MAP;
			NavigableSet<Integer> set = LEVEL_NODE_MAP.navigableKeySet();
			int len = 300;
			System.out.println(generateCharStr(len, CHAR_SECTION));
			StringBuilder sbNodeStr = new StringBuilder(LENGTH_OF_TRACING_TREE);// for each node
			StringBuilder sbConnStr = new StringBuilder(LENGTH_OF_TRACING_TREE); // for each node
			//首先打印头结点
			TracingRecu root = LEVEL_NODE_MAP.get(0).get(0);
			nodeStr += DELIMITER + root.nodeStr + DELIMITER + generateCharStr(root.widthBtwSiblings) + DELIMITER;
			sbNodeStr.insert(root.pos, nodeStr);
			System.out.printf(TracingRecu.PARA_LIST + " %3s %-6s%s\n", "", "", sbConnStr);
			System.out.printf(TracingRecu.PARA_LIST + " %3d:%-6d%s\n", level, LEVEL_NODE_MAP.get(level).size(),
					sbNodeStr);

//			其次，逐层 插入当前节点的孩子们的 ConnStr + NodeStr，最后逐层打印
			for (Integer level : set) {
				String nodeStr = "";// for each level
				String connStr = "";// for each level

				for (TracingRecu node : LEVEL_NODE_MAP.get(level)) {
					if (level == 0) {
						nodeStr += DELIMITER + node.nodeStr + DELIMITER + generateCharStr(node.widthBtwSiblings)
								+ DELIMITER;
						sbNodeStr.insert(node.pos, nodeStr);
						break;
					}
					if (node.children.size() == 0) {
						nodeStr += DELIMITER + node.nodeStr + DELIMITER + generateCharStr(node.widthBtwSiblings)
								+ DELIMITER;
						sbNodeStr.insert(node.pos, nodeStr);
						continue;
					} else {
						String expected = DELIMITER + node.nodeStr + DELIMITER + generateCharStr(node.widthBtwSiblings)
								+ DELIMITER;
						String actural = DELIMITER;
						for (int i = 0; i < node.children.size(); i++) {
							TracingRecu child = node.children.get(i);
							if (i == 0) {//first child
								actural += child.nodeStr;
								if (node.children.size() != 1) {//first child and but more than one child, spaces  '+'  '----'
									if (!toLeft) {
										sbConnStr.append(generateCharStr(child.delimiterWidth + child.preWidth))
												.append(CHAR_POINT_TO_CHILD)
												.append(generateCharStr(
														child.paraStr.length() - 1 + child.postWidth
																+ child.delimiterWidth + child.widthBtwSiblings,
														CHAR_BTW_PARENT_AND_CHILDREN));
									} else {
										sbConnStr.append(generateCharStr(child.delimiterWidth))
												.append(CHAR_POINT_TO_CHILD)
												.append(generateCharStr(
														child.paraStr.length() - 1 + child.preWidth + child.postWidth
																+ child.delimiterWidth + child.widthBtwSiblings,
														CHAR_BTW_PARENT_AND_CHILDREN));
									}
								} else {// first node but the only one child, spaces  '+'  '----' + spaces
									if (!toLeft) {
										sbConnStr.append(generateCharStr(child.delimiterWidth + child.preWidth))
												.append(CHAR_POINT_TO_CHILD)
												.append(generateCharStr(child.paraStr.length() - 1,
														CHAR_BTW_PARENT_AND_CHILDREN))
												.append(generateCharStr(child.postWidth + child.delimiterWidth
														+ child.widthBtwSiblings));
									} else {
										sbConnStr.append(generateCharStr(child.delimiterWidth))
												.append(CHAR_POINT_TO_CHILD)
												.append(generateCharStr(child.paraStr.length() - 1,
														CHAR_BTW_PARENT_AND_CHILDREN))
												.append(generateCharStr(child.preWidth + child.postWidth
														+ +child.delimiterWidth + child.widthBtwSiblings));
									}

								}
							} else if (i != node.children.size() - 1) {//middle nodes,  '----' + '+' + '----'
								actural += child.nodeStr + generateCharStr(child.widthBtwSiblings);
								if (!toLeft) {
									sbConnStr
											.append(generateCharStr(child.delimiterWidth + child.preWidth,
													CHAR_BTW_PARENT_AND_CHILDREN))
											.append(CHAR_POINT_TO_CHILD)
											.append(generateCharStr(child.paraStr.length() - 1 + child.postWidth
													+ child.delimiterWidth + child.widthBtwSiblings,
													CHAR_BTW_PARENT_AND_CHILDREN));
								} else {
									sbConnStr
											.append(generateCharStr(child.delimiterWidth, CHAR_BTW_PARENT_AND_CHILDREN))
											.append(CHAR_POINT_TO_CHILD)
											.append(generateCharStr(
													child.paraStr.length() - 1 + child.preWidth + child.postWidth
															+ child.delimiterWidth + child.widthBtwSiblings,
													CHAR_BTW_PARENT_AND_CHILDREN));
								}

							} else { // last node, '----' + '+' + spaces
								actural += child.nodeStr;
								if (!toLeft) {
									sbConnStr
											.append(generateCharStr(child.delimiterWidth + child.preWidth,
													CHAR_BTW_PARENT_AND_CHILDREN))
											.append(CHAR_POINT_TO_CHILD)
											.append(generateCharStr(child.paraStr.length() - 1 + child.postWidth
													+ child.delimiterWidth + node.widthBtwSiblings));
								} else {
									sbConnStr
											.append(generateCharStr(child.delimiterWidth, CHAR_BTW_PARENT_AND_CHILDREN))
											.append(CHAR_POINT_TO_CHILD)
											.append(generateCharStr(child.paraStr.length() - 1 + child.preWidth
													+ child.postWidth + child.delimiterWidth + node.widthBtwSiblings));
								}
							}

						}
						actural += DELIMITER + generateCharStr(node.widthBtwSiblings) + DELIMITER;
						nodeStr += expected;
						sbNodeStr.setLength(0);

						if (!toLeft) {
							if (sbConnStr.charAt(node.delimiterWidth + node.preWidth) != CHAR_POINT_TO_CHILD) {
								sbConnStr.setCharAt(node.delimiterWidth + node.preWidth, CHAR_POINT_TO_PARENT);
							} else {
								sbConnStr.setCharAt(
										node.delimiterWidth + node.preWidth + MOVE_TO_RIGHT_TO_POINT_TO_PARENT,
										CHAR_POINT_TO_PARENT);
							}
						} else {
							if (sbConnStr.charAt(node.delimiterWidth) != CHAR_POINT_TO_CHILD) {
								sbConnStr.setCharAt(node.delimiterWidth, CHAR_POINT_TO_PARENT);
							} else {
								sbConnStr.setCharAt(node.delimiterWidth + MOVE_TO_RIGHT_TO_POINT_TO_PARENT,
										CHAR_POINT_TO_PARENT);
							}
						}
//					sbConnStr.setCharAt(node.delimiterWidth + node.preWidth, '^');
						connStr += sbConnStr.toString();
						sbConnStr.setLength(0);
					}
				}
//				System.out.printf(TracingRecu.PARA_LIST + " %3d:%-6d%s\n", level, LEVEL_NODE_MAP.get(level).size(), nodeStr);
//				System.out.printf(TracingRecu.PARA_LIST + " %3s %-6s%s\n", "", "", connStr);
				System.out.printf(TracingRecu.PARA_LIST + " %3s %-6s%s\n", "", "", sbConnStr);
				System.out.printf(TracingRecu.PARA_LIST + " %3d:%-6d%s\n", level, LEVEL_NODE_MAP.get(level).size(),
						sbNodeStr);

			}
			System.out.println(generateCharStr(len, CHAR_SECTION));
		}

		//原始版本，bug是最后一行没有对齐，如果左侧没有元素的话
		private void printLevelStrAndConnStr000(boolean toLeft) {
			final String DELIMITER = "";
			TreeMap<Integer, List<TracingRecu>> LEVEL_NODE_MAP = this.root.LEVEL_NODE_MAP;
			NavigableSet<Integer> set = LEVEL_NODE_MAP.navigableKeySet();
			int len = 300;
			System.out.println(generateCharStr(len, CHAR_SECTION));
			for (Integer level : set) {
				String nodeStr = "";// for each level
				String connStr = "";// for each level
				StringBuilder sbNodeStr = new StringBuilder();// for each node
				StringBuilder sbConnStr = new StringBuilder(); // for each node

				for (TracingRecu node : LEVEL_NODE_MAP.get(level)) {
					if (node.children.size() == 0) {
						nodeStr += DELIMITER + node.nodeStr + DELIMITER + generateCharStr(node.widthBtwSiblings)
								+ DELIMITER;
						continue;
					} else {
						String expected = DELIMITER + node.nodeStr + DELIMITER + generateCharStr(node.widthBtwSiblings)
								+ DELIMITER;
						String actural = DELIMITER;
						for (int i = 0; i < node.children.size(); i++) {
							TracingRecu child = node.children.get(i);
							if (i == 0) {//first child
								actural += child.nodeStr;
								if (node.children.size() != 1) {//first child and but more than one child, spaces  '+'  '----'
									if (!toLeft) {
										sbConnStr.append(generateCharStr(child.delimiterWidth + child.preWidth))
												.append(CHAR_POINT_TO_CHILD)
												.append(generateCharStr(
														child.paraStr.length() - 1 + child.postWidth
																+ child.delimiterWidth + child.widthBtwSiblings,
														CHAR_BTW_PARENT_AND_CHILDREN));
									} else {
										sbConnStr.append(generateCharStr(child.delimiterWidth))
												.append(CHAR_POINT_TO_CHILD)
												.append(generateCharStr(
														child.paraStr.length() - 1 + child.preWidth + child.postWidth
																+ child.delimiterWidth + child.widthBtwSiblings,
														CHAR_BTW_PARENT_AND_CHILDREN));
									}
								} else {// first node but the only one child, spaces  '+'  '----' + spaces
									if (!toLeft) {
										sbConnStr.append(generateCharStr(child.delimiterWidth + child.preWidth))
												.append(CHAR_POINT_TO_CHILD)
												.append(generateCharStr(child.paraStr.length() - 1,
														CHAR_BTW_PARENT_AND_CHILDREN))
												.append(generateCharStr(child.postWidth + child.delimiterWidth
														+ child.widthBtwSiblings));
									} else {
										sbConnStr.append(generateCharStr(child.delimiterWidth))
												.append(CHAR_POINT_TO_CHILD)
												.append(generateCharStr(child.paraStr.length() - 1,
														CHAR_BTW_PARENT_AND_CHILDREN))
												.append(generateCharStr(child.preWidth + child.postWidth
														+ +child.delimiterWidth + child.widthBtwSiblings));
									}

								}
							} else if (i != node.children.size() - 1) {//middle nodes,  '----' + '+' + '----'
								actural += child.nodeStr + generateCharStr(child.widthBtwSiblings);
								if (!toLeft) {
									sbConnStr
											.append(generateCharStr(child.delimiterWidth + child.preWidth,
													CHAR_BTW_PARENT_AND_CHILDREN))
											.append(CHAR_POINT_TO_CHILD)
											.append(generateCharStr(child.paraStr.length() - 1 + child.postWidth
													+ child.delimiterWidth + child.widthBtwSiblings,
													CHAR_BTW_PARENT_AND_CHILDREN));
								} else {
									sbConnStr
											.append(generateCharStr(child.delimiterWidth, CHAR_BTW_PARENT_AND_CHILDREN))
											.append(CHAR_POINT_TO_CHILD)
											.append(generateCharStr(
													child.paraStr.length() - 1 + child.preWidth + child.postWidth
															+ child.delimiterWidth + child.widthBtwSiblings,
													CHAR_BTW_PARENT_AND_CHILDREN));
								}

							} else { // last node, '----' + '+' + spaces
								actural += child.nodeStr;
								if (!toLeft) {
									sbConnStr
											.append(generateCharStr(child.delimiterWidth + child.preWidth,
													CHAR_BTW_PARENT_AND_CHILDREN))
											.append(CHAR_POINT_TO_CHILD)
											.append(generateCharStr(child.paraStr.length() - 1 + child.postWidth
													+ child.delimiterWidth + node.widthBtwSiblings));
								} else {
									sbConnStr
											.append(generateCharStr(child.delimiterWidth, CHAR_BTW_PARENT_AND_CHILDREN))
											.append(CHAR_POINT_TO_CHILD)
											.append(generateCharStr(child.paraStr.length() - 1 + child.preWidth
													+ child.postWidth + child.delimiterWidth + node.widthBtwSiblings));
								}
							}

						}
						actural += DELIMITER + generateCharStr(node.widthBtwSiblings) + DELIMITER;
						nodeStr += expected;
						sbNodeStr.setLength(0);

						if (!toLeft) {
							if (sbConnStr.charAt(node.delimiterWidth + node.preWidth) != CHAR_POINT_TO_CHILD) {
								sbConnStr.setCharAt(node.delimiterWidth + node.preWidth, CHAR_POINT_TO_PARENT);
							} else {
								sbConnStr.setCharAt(node.delimiterWidth + node.preWidth + 2, CHAR_POINT_TO_PARENT);
							}
						} else {
							if (sbConnStr.charAt(node.delimiterWidth) != CHAR_POINT_TO_CHILD) {
								sbConnStr.setCharAt(node.delimiterWidth, CHAR_POINT_TO_PARENT);
							} else {
								sbConnStr.setCharAt(node.delimiterWidth + 2, CHAR_POINT_TO_PARENT);
							}
						}
//					sbConnStr.setCharAt(node.delimiterWidth + node.preWidth, '^');
						connStr += sbConnStr.toString();
						sbConnStr.setLength(0);
					}
				}
				System.out.printf(TracingRecu.PARA_LIST + " %3d:%-6d%s\n", level, LEVEL_NODE_MAP.get(level).size(),
						nodeStr);
				System.out.printf(TracingRecu.PARA_LIST + " %3s %-6s%s\n", "", "", connStr);
			}
			System.out.println(generateCharStr(len, CHAR_SECTION));
		}

		private String generateCharStr(int width) {
			return generateCharStr(width, CHAR_DEFAULT_SPACE);
		}

		private String generateCharStr(int width, char ch) {
			StringBuilder sb = new StringBuilder();
			while (--width >= 0) {
				sb.append(ch);
			}
			return sb.toString();
		}
	}

}
