package Lintcode.Array.String.DP;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

import org.omg.PortableServer.POA;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import Lintcode.Matrix.Matrix;

/**

Backpack I

 Problem 单次选择+最大体积

Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?

Have you met this question in a real interview? Yes
Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.

Note
You can not divide any item into small pieces.

Challenge
O(n x m) time and O(m) memory.

O(n x m) memory is also acceptable if you do not know how to optimize memory.

Tags Expand 
LintCode Copyright Dynamic Programming Backpack


Related Problems Expand 
Medium Backpack II *
 */
public class Backpack_I {

    public static int backPack44(int m, int[] A) {  
        if (A.length==0) return 0;  
        int len = A.length;  
        int[] max = new int[m+1];  
        // max[0] = 0;  
        for (int i=0;i<len;i++){  
            int size = A[i];
//            for (int j=0;j<=m;j++){  //wrong here
             for (int j=m;j>=0;j--){  //not easy to understand here
                if (j-size>=0){ //A[i-1]为带装物品大小  
                	max[j] = Math.max(max[j-size]+size, max[j]);	
                }  
                System.out.println("i:j "+ i + ":"+j+" "+Arrays.toString(max));
            }
             System.out.println();
        }
        return max[m];  
    }  
//1.不可重复取用，如果袋子大于全体和，直接返回
//2.每件东西两种情况，放或者不放，所以必须比较Math.max()
//3.求放进袋子最大体积，添加一个虚拟物品体积为0，虚拟袋子体积为0，初始化为0，但是循环不遍历他们，   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {3,4,8,5};
		int k = 10;
		int[] arr = {2,3,5,7};
//		int[] arr = {3,7,8,5};
//		int k = 20;
		System.out.println("num:"+backPack44(k, arr));

//		System.out.println(""+p);
//		System.out.println("num:"+backPack(k, arr));
		System.out.println("++++++++++++++++++++++");
//		System.out.println("num:"+backPack3(k, arr));
	}
	//Best Best solution, not easy to understand
    public static int backPack(int m, int[] A) {  
        if (A.length==0) return 0;  
        int len = A.length;  
        boolean[] isFull = new boolean[m+1];  
        isFull[0] = true;  
        for (int i=1;i<=len;i++){  
            for (int j=0;j<=m;j++){  //not easy to understand here
            // for (int j=m;j>=0;j--){  //not easy to understand here
                if (j-A[i-1]>=0 && isFull[j-A[i-1]])//A[i-1]为带装物品大小  
                {
                	System.out.println("i:j:A[i-1] "+ i +".." +j+".." +A[i-1]);
                	isFull[j] = true;	
                }  
            }  
        }
        for (int i=m; i>=0;i--)  
            if (isFull[i]) return i;  
   
        return 0;  
    }  

    //solution, worked, O(n x m) time and O( m) memory.
    public static int backPack22(int m, int[] A) {
        boolean f[][] = new boolean[2][m + 1];
        f[0][0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[(i + 1)%2][j] = f[i%2][j];
                if (j >= A[i] && f[i%2][j - A[i]]) {
                    f[(i + 1)%2][j] = true;
                }
            } 
        } 
        for (int i = m; i >= 0; i--) {
            if (f[A.length %2][i]) {
                return i;
            }
        }
        return 0;
    }
    
	//worked, fastest
    public static int backPack3(int size, int[] items) {
//    	it does not matter if change the order of A 
//        int temp = A[0];
//        A[0]= A[A.length-1];
//        A[A.length-1] = temp;
    	
        //第一步：确定状态，f[i][j],对size为j的袋子，前i个物品能否把他装满，true或者false 
        boolean isFull[][] = new boolean[items.length + 1][size + 1];
        //第二步：状态初始化
        isFull[0][0] = true;
        for (int i = 1; i <= items.length; i++) {
            for (int j = 0; j <= size; j++) {
            	//第三步：实现递推的状态方程
            	//初始化数组有了，第一个数组值也有了，就看怎么计算下一行数组了
            	//这里就是状态方程的实现：f[i-1][j]如何计算出f[i][j]？
            	//实质：在此block里面如何计算f[i][j]？
            	//有两种做法: 1, 不把第i-1个物品放入；2，把第i个物品放入
                //1, 不把第i-1个物品放入，那么前A[i-1]物品，能组成size为j的包，到下面A[i]物品的也就能
                //前A[i-1]物品，不能组成size为j的包，那么默认，到下面A[i]物品的也就能
            	//2，把第i个物品放入，除非...
                isFull[i][j] = isFull[i-1][j];
                //除非符合下面的条件，才可以
                //什么条件呢？除非size为j的背包，可以装下size为A[i-1]的东西，并且剩余的也是的
                //第i行物品的大小是多少？是items[i-1]
                if (j - items[i-1] >= 0 && isFull[i-1][j - items[i-1]]) {
                    isFull[i][j] = true;
                }
                System.out.println(""+Matrix.fromMatrixToString(isFull));
//                isFull[i][j] = Math.max(isFull[i - 1][j - items[i] + items[i], isFull[i-1][j]);
            } // for j
        } // for i
    	//第四步：状态方程递推完毕，根据先前确定的状态，找最终结果
        System.out.println(""+Matrix.fromMatrixToString(isFull));
        for (int i = size; i >= 0; i--) {
            if (isFull[items.length][i]) {
                return i;
            }
        }
        return 0;
    }
    
    // solution, worked, O(n x m) time and O( m) memory.
    public static int backPack6(int m, int[] A) {
        boolean f[][] = new boolean[2][m + 1];
        f[0][0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[1][j] = f[0][j];
                if (j >= A[i] && f[0][j - A[i]]) {
                    f[1][j] = true;
                }
            }
            boolean [] temp = f[0];
            f[0] = f[1];
            f[1] = temp;
        } 
        for (int i = m; i >= 0; i--) {
            if (f[0][i]) {
                return i;
            }
        }
        return 0;
    }

    
    //worked,but slow
    public int backPack9(int m, int[] A) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        TreeSet<Integer>  newSet = new TreeSet<Integer>();
        // AAA:
        for(int size : A){
            for(int el : set){
                if(size+el<=m){
                    newSet.add(size+el);
                    // break AAA;
                    // break ;
                }
            }
            set.add(size);
            set.addAll(newSet);
            
            newSet.clear();
        }
        for(Iterator<Integer> iter = set.descendingIterator(); iter.hasNext(); ) { 
            Integer val = iter.next();
            if(val <= m) return val;
        }
        return 0;
        
    }

}

/*
背包问题是动态规划问题的一种典型题目。 动态规划问题我们一般要考虑下面这四点。
1. 状态 State
2. 方程 Function
3. 初始化 Intialization
4. 答案 Answer

本题是最基础的背包问题，特点是：每种物品仅有一件，可以选择放或不放，那下面我们来看背包这题动态规划的四点是怎么样的呢？

1. State: dp[i][S] 表示前i个物品，取出一些,能否组成和为S体积的背包
2. Function: f[i][S] = f[i-1][S - A[i]] or f[i-1][S] (A[i]表示第i个物品的大小)
转移方程想得到f[i][S]前i个物品取出一些物品想组成S体积的背包。 那么可以从两个状态转换得到。

（1）f[i-1][S - A[i]] 放入第i个物品，并且前i-1个物品能否取出一些组成和为S-A[i] 体积大小的背包。

（2）f[i-1][S] 不放入第i个物品， 并且前i-1个物品能否取出一些组成和为S 体积大小的背包。

3. Intialize: f[1...n][0] = true; f[0][1... m] = false
初始化 f[1...n][0] 表示前1...n个物品，取出一些能否组成和为0 大小的背包始终为真。
其他初始化为假

4. Answer: 寻找使f[n][S] 值为true的最大的S. （S的取值范围1到m）

由于这道题空间上有一些要求，所以在知道了思路答案过后我们还需要进行优化空间复杂度.先考虑上面讲的基本思路如何实现，肯定是有一个主循环i=1..N，每次算出来二维数组f[i][0..S]的所有值。那么，如果只用一个数组f[0..S]，能不能保证第i次循环结束后f[S]中表示的就是我们定义的状态f[i][S]呢？f[i][S]是由 f[i-1][S - a[i]] 和 f[i-1][S] 两个子问题递推而来，能否保证在推f[i][S]时（也即在第i次主循环中推f[S]时）能够得到 f[i-1][S - a[i]] 和 f[i-1][S] 的值呢？事实上，这要求在每次主循环中我们以S=m...0的顺序推f[S]，这样才能保证推f[S]时f[S-a[i]]保存的是状态f[i-1][S-a[i]]的值。伪代码如下：
for i=1..N
for S=m...0
f[S]=f[S] or f[S-a[i]];

 * */
