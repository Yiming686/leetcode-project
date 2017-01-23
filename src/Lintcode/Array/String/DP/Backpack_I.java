package Lintcode.Array.String.DP;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

import org.omg.PortableServer.POA;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import Lintcode.Matrix.Matrix;

/**

Backpack I

 Problem ����ѡ��+������

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
                if (j-size>=0){ //A[i-1]Ϊ��װ��Ʒ��С  
                	max[j] = Math.max(max[j-size]+size, max[j]);	
                }  
                System.out.println("i:j "+ i + ":"+j+" "+Arrays.toString(max));
            }
             System.out.println();
        }
        return max[m];  
    }  
//1.�����ظ�ȡ�ã�������Ӵ���ȫ��ͣ�ֱ�ӷ���
//2.ÿ����������������Ż��߲��ţ����Ա���Ƚ�Math.max()
//3.��Ž����������������һ��������Ʒ���Ϊ0������������Ϊ0����ʼ��Ϊ0������ѭ�����������ǣ�   
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
                if (j-A[i-1]>=0 && isFull[j-A[i-1]])//A[i-1]Ϊ��װ��Ʒ��С  
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
    	
        //��һ����ȷ��״̬��f[i][j],��sizeΪj�Ĵ��ӣ�ǰi����Ʒ�ܷ����װ����true����false 
        boolean isFull[][] = new boolean[items.length + 1][size + 1];
        //�ڶ�����״̬��ʼ��
        isFull[0][0] = true;
        for (int i = 1; i <= items.length; i++) {
            for (int j = 0; j <= size; j++) {
            	//��������ʵ�ֵ��Ƶ�״̬����
            	//��ʼ���������ˣ���һ������ֵҲ���ˣ��Ϳ���ô������һ��������
            	//�������״̬���̵�ʵ�֣�f[i-1][j]��μ����f[i][j]��
            	//ʵ�ʣ��ڴ�block������μ���f[i][j]��
            	//����������: 1, ���ѵ�i-1����Ʒ���룻2���ѵ�i����Ʒ����
                //1, ���ѵ�i-1����Ʒ���룬��ôǰA[i-1]��Ʒ�������sizeΪj�İ���������A[i]��Ʒ��Ҳ����
                //ǰA[i-1]��Ʒ���������sizeΪj�İ�����ôĬ�ϣ�������A[i]��Ʒ��Ҳ����
            	//2���ѵ�i����Ʒ���룬����...
                isFull[i][j] = isFull[i-1][j];
                //���Ƿ���������������ſ���
                //ʲô�����أ�����sizeΪj�ı���������װ��sizeΪA[i-1]�Ķ���������ʣ���Ҳ�ǵ�
                //��i����Ʒ�Ĵ�С�Ƕ��٣���items[i-1]
                if (j - items[i-1] >= 0 && isFull[i-1][j - items[i-1]]) {
                    isFull[i][j] = true;
                }
                System.out.println(""+Matrix.fromMatrixToString(isFull));
//                isFull[i][j] = Math.max(isFull[i - 1][j - items[i] + items[i], isFull[i-1][j]);
            } // for j
        } // for i
    	//���Ĳ���״̬���̵�����ϣ�������ǰȷ����״̬�������ս��
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
���������Ƕ�̬�滮�����һ�ֵ�����Ŀ�� ��̬�滮��������һ��Ҫ�����������ĵ㡣
1. ״̬ State
2. ���� Function
3. ��ʼ�� Intialization
4. �� Answer

������������ı������⣬�ص��ǣ�ÿ����Ʒ����һ��������ѡ��Ż򲻷ţ����������������������⶯̬�滮���ĵ�����ô�����أ�

1. State: dp[i][S] ��ʾǰi����Ʒ��ȡ��һЩ,�ܷ���ɺ�ΪS����ı���
2. Function: f[i][S] = f[i-1][S - A[i]] or f[i-1][S] (A[i]��ʾ��i����Ʒ�Ĵ�С)
ת�Ʒ�����õ�f[i][S]ǰi����Ʒȡ��һЩ��Ʒ�����S����ı����� ��ô���Դ�����״̬ת���õ���

��1��f[i-1][S - A[i]] �����i����Ʒ������ǰi-1����Ʒ�ܷ�ȡ��һЩ��ɺ�ΪS-A[i] �����С�ı�����

��2��f[i-1][S] �������i����Ʒ�� ����ǰi-1����Ʒ�ܷ�ȡ��һЩ��ɺ�ΪS �����С�ı�����

3. Intialize: f[1...n][0] = true; f[0][1... m] = false
��ʼ�� f[1...n][0] ��ʾǰ1...n����Ʒ��ȡ��һЩ�ܷ���ɺ�Ϊ0 ��С�ı���ʼ��Ϊ�档
������ʼ��Ϊ��

4. Answer: Ѱ��ʹf[n][S] ֵΪtrue������S. ��S��ȡֵ��Χ1��m��

���������ռ�����һЩҪ��������֪����˼·�𰸹������ǻ���Ҫ�����Ż��ռ临�Ӷ�.�ȿ������潲�Ļ���˼·���ʵ�֣��϶�����һ����ѭ��i=1..N��ÿ���������ά����f[i][0..S]������ֵ����ô�����ֻ��һ������f[0..S]���ܲ��ܱ�֤��i��ѭ��������f[S]�б�ʾ�ľ������Ƕ����״̬f[i][S]�أ�f[i][S]���� f[i-1][S - a[i]] �� f[i-1][S] ������������ƶ������ܷ�֤����f[i][S]ʱ��Ҳ���ڵ�i����ѭ������f[S]ʱ���ܹ��õ� f[i-1][S - a[i]] �� f[i-1][S] ��ֵ�أ���ʵ�ϣ���Ҫ����ÿ����ѭ����������S=m...0��˳����f[S]���������ܱ�֤��f[S]ʱf[S-a[i]]�������״̬f[i-1][S-a[i]]��ֵ��α�������£�
for i=1..N
for S=m...0
f[S]=f[S] or f[S-a[i]];

 * */
