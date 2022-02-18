
/Users/yiming/Work/Projects/LeetLintCodeProject/Utils/readme.txt
/Users/yiming/Work/Projects/LeetLintCodeProject/src/Utils/ArrayUtils.java
/Users/yiming/Work/Projects/LeetLintCodeProject/LAI/Lai/Utils/Result.java

=== 这里实现的是很多工具类和其方法 ======================================================================================

磨刀不误砍柴工！ 磨刀不误砍柴工！
这里是为了实现 测试代码 的利器！
这里是为了实现 研究代码 的利器！
这里是为了实现 理解代码 的利器！
这里是为了实现 记忆代码 的利器！


每个类和方法可以单独测试：
ddddhhhh dnihao  hao  
--------------------------------------------------------------------------------------------------------------------
Array Utils:
//---Generate Int Array---------------------------------------------------------------------------------------------------------------
	0.generateIntArray(): 最常见的，在指定[start, end]范围内，生成大小为n的整数数组，没有重复元素：
	1.generateIntArrayNoDup():    在指定[start, end]范围内，生成大小为n的整数数组，没有重复元素：
	2.generateIntArrayWithDup():  在指定[start, end]范围内，生成大小为n的整数数组，必须有重复元素：（重复个数不超过n/2个）
	3.generateIntArrayAllDup():   在指定[start, end]范围内，生成大小为n的整数数组，全部都是重复元素：
	
	4.generateIntArraySorted(): 最常见的，在指定[start, end]范围内，生成大小为n的整数数组，没有重复元素, 同时排好序;
	5.generateIntArrayNoDupSorted():    在指定[start, end]范围内，生成大小为n的整数数组，没有重复元素, 同时排好序;
	6.generateIntArrayWithDupSorted():  在指定[start, end]范围内，生成大小为n的整数数组，必须有重复元素：（重复个数不超过n/2个）, 同时排好序;
	
	7. convert Int Array to Integer Array;
	8. convert Integer Array to Int Array;
	
	7. print(int[] arr)
	8. printIntArray(int[] arr)
	9. printIntArrayWithIndex(int[] arr)
	10. printIntArrayNoIndex(int[] arr)
	
	//method with log: 默认绝大多数情况，是不需要多余log的，特殊情况，需要看看更多log，
//---Generate Char Array---------------------------------------------------------------------------------------------------------------	
	4.generateCharArray(): 最常见的，在指定[start, end]范围内，生成大小为n的字符数组，没有重复元素：
	5.generateCharArrayNoDup():    在指定[start, end]范围内，生成大小为n的字符数组，没有重复元素：
	6.generateCharArrayWithDup():  在指定[start, end]范围内，生成大小为n的字符数组，必须有重复元素：（重复个数不超过n/2个）
	7.generateCharArrayAllDup():   在指定[start, end]范围内，生成大小为n的字符数组，全部都是重复元素：
	
	4.generateCharArraySorted(): 最需要的，在指定[start, end]范围内，生成大小为n的字符数组，没有重复元素, 同时排好序;：
	5.generateCharArrayNoDupSorted():    在指定[start, end]范围内，生成大小为n的字符数组，没有重复元素, 同时排好序;：
	6.generateCharArrayWithDupSorted():  在指定[start, end]范围内，生成大小为n的字符数组，必须有重复元素：（重复个数不超过n/2个）, 同时排好序;
	
--------------------------------------------------------------------------------------------------------------------
ArrayUtils99
	想利用generic 的原理 实现 通用的 ArrayUtils， for Integer, Character
	
--------------------------------------------------------------------------------------------------------------------
Matrix Utils:
	
	1.生成随机整数矩阵
	
--------------------------------------------------------------------------------------------------------------------
ListNodeUtils:
测试List时候，需要一个List, 这时候可以使用这里分方法，生成List。
//---Generate LinkedList ---------------------------------------------------------------------------------------------------------------

	1. ListNode<Integer> generateList(int[] arr);
	2. ListNode<Integer> generateList(Integer[] arr)
	3. ListNode<Character> generateList(char[] arr)
	4. ListNode<Character> generateList(Character[] arr)

	5. CycleList buildCycle(int n) //环外面0个，环里面n个
	6. CycleList buildCycleList(int m, int n) //环外面m个，环里面n个
	7. ListNode buildOnlyCycle(int n)
	
//--- Print LinkedList ---------------------------------------------------------------------------------------------------------------
	
	5. public static String print(ListNode head) 

//--- Print Matrix char[][] ---------------------------------------------------------------------------------------------------------------
	0. APIs
		public static char[][] buildMatrix(int rows, int cols, Map<Character, Integer> char2ProbMap);
	
		public static char[][] buildMatrix(int rows, int cols, Map<Character, Integer> char2ProbMap, boolean toPrint);
	
		public static char[][] buildMatrix(int rows, int cols, List<Character> list);
	
		public static char[][] buildMatrix(int rows, int cols, List<Character> list, boolean toPrint);
	
	1. Using List, evenly distributed
		List<Character> list = new ArrayList<>();
		list.add('D');		list.add('E');		list.add('F');
	
		char[][] matrix0 = MatrixUtils.buildMatrix(6, 6, list);
	
	2. Using map to provide probability distribution
	
		Map<Character, Integer> char2ProbMap = new HashMap<>();
		char2ProbMap.put(YELLOW, 8);
		char2ProbMap.put(BLUE, 6);
		char2ProbMap.put(RED, 2);
		
	3. rows, cols, probs
	
		char[][] matrix = MatrixUtils.buildMatrix(6, 6, char2ProbMap);
//		two connected blue areas: 
//		char[][] matrix =  {{'_','_','R','_','_','R'},{'_','_','_','_','R','R'},{'_','_','R','R','_','R'},{'_','_','R','_','_','R'},{'_','_','R','_','_','R'},{'_','_','R','_','_','R'}};
//		Good Example:
//		char[][] matrix =   {{'_','_','Y','Y','_','_'},{'Y','_','_','_','_','Y'},{'Y','_','Y','_','Y','Y'},{'Y','_','_','Y','Y','_'},{'Y','_','R','Y','Y','_'},{'R','Y','Y','R','_','Y'}};
	
	4. how to print
		print(matrix);


--------------------------------------------------------------------------------------------------------------------


	
	