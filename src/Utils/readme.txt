
/Users/yiming/Work/Projects/LeetLintCodeProject/Utils/readme.txt
/Users/yiming/Work/Projects/LeetLintCodeProject/src/Utils/ArrayUtils.java
/Users/yiming/Work/Projects/LeetLintCodeProject/LAI/Lai/Utils/Result.java

=== ����ʵ�ֵ��Ǻܶ๤������䷽�� ======================================================================================

ĥ�����󿳲񹤣� ĥ�����󿳲񹤣�
������Ϊ��ʵ�� ���Դ��� ��������
������Ϊ��ʵ�� �о����� ��������
������Ϊ��ʵ�� ������ ��������
������Ϊ��ʵ�� ������� ��������


ÿ����ͷ������Ե������ԣ�
ddddhhhh dnihao  hao  
--------------------------------------------------------------------------------------------------------------------
Array Utils:
//---Generate Int Array---------------------------------------------------------------------------------------------------------------
	0.generateIntArray(): ����ģ���ָ��[start, end]��Χ�ڣ����ɴ�СΪn���������飬û���ظ�Ԫ�أ�
	1.generateIntArrayNoDup():    ��ָ��[start, end]��Χ�ڣ����ɴ�СΪn���������飬û���ظ�Ԫ�أ�
	2.generateIntArrayWithDup():  ��ָ��[start, end]��Χ�ڣ����ɴ�СΪn���������飬�������ظ�Ԫ�أ����ظ�����������n/2����
	3.generateIntArrayAllDup():   ��ָ��[start, end]��Χ�ڣ����ɴ�СΪn���������飬ȫ�������ظ�Ԫ�أ�
	
	4.generateIntArraySorted(): ����ģ���ָ��[start, end]��Χ�ڣ����ɴ�СΪn���������飬û���ظ�Ԫ��, ͬʱ�ź���;
	5.generateIntArrayNoDupSorted():    ��ָ��[start, end]��Χ�ڣ����ɴ�СΪn���������飬û���ظ�Ԫ��, ͬʱ�ź���;
	6.generateIntArrayWithDupSorted():  ��ָ��[start, end]��Χ�ڣ����ɴ�СΪn���������飬�������ظ�Ԫ�أ����ظ�����������n/2����, ͬʱ�ź���;
	
	7. convert Int Array to Integer Array;
	8. convert Integer Array to Int Array;
	
	7. print(int[] arr)
	8. printIntArray(int[] arr)
	9. printIntArrayWithIndex(int[] arr)
	10. printIntArrayNoIndex(int[] arr)
	
	//method with log: Ĭ�Ͼ������������ǲ���Ҫ����log�ģ������������Ҫ��������log��
//---Generate Char Array---------------------------------------------------------------------------------------------------------------	
	4.generateCharArray(): ����ģ���ָ��[start, end]��Χ�ڣ����ɴ�СΪn���ַ����飬û���ظ�Ԫ�أ�
	5.generateCharArrayNoDup():    ��ָ��[start, end]��Χ�ڣ����ɴ�СΪn���ַ����飬û���ظ�Ԫ�أ�
	6.generateCharArrayWithDup():  ��ָ��[start, end]��Χ�ڣ����ɴ�СΪn���ַ����飬�������ظ�Ԫ�أ����ظ�����������n/2����
	7.generateCharArrayAllDup():   ��ָ��[start, end]��Χ�ڣ����ɴ�СΪn���ַ����飬ȫ�������ظ�Ԫ�أ�
	
	4.generateCharArraySorted(): ����Ҫ�ģ���ָ��[start, end]��Χ�ڣ����ɴ�СΪn���ַ����飬û���ظ�Ԫ��, ͬʱ�ź���;��
	5.generateCharArrayNoDupSorted():    ��ָ��[start, end]��Χ�ڣ����ɴ�СΪn���ַ����飬û���ظ�Ԫ��, ͬʱ�ź���;��
	6.generateCharArrayWithDupSorted():  ��ָ��[start, end]��Χ�ڣ����ɴ�СΪn���ַ����飬�������ظ�Ԫ�أ����ظ�����������n/2����, ͬʱ�ź���;
	
--------------------------------------------------------------------------------------------------------------------
ArrayUtils99
	������generic ��ԭ�� ʵ�� ͨ�õ� ArrayUtils�� for Integer, Character
	
--------------------------------------------------------------------------------------------------------------------
Matrix Utils:
	
	1.���������������
	
--------------------------------------------------------------------------------------------------------------------
ListNodeUtils:
����Listʱ����Ҫһ��List, ��ʱ�����ʹ������ַ���������List��
//---Generate LinkedList ---------------------------------------------------------------------------------------------------------------

	1. ListNode<Integer> generateList(int[] arr);
	2. ListNode<Integer> generateList(Integer[] arr)
	3. ListNode<Character> generateList(char[] arr)
	4. ListNode<Character> generateList(Character[] arr)

	5. CycleList buildCycle(int n) //������0����������n��
	6. CycleList buildCycleList(int m, int n) //������m����������n��
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


	
	