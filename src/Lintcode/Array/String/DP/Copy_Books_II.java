package Lintcode.Array.String.DP;

/**

Copy Books II 

 Description
 Notes
 Testcase
 Judge
Given n books( the page number of each book is the same) and an array of integer with size k means k people to copy the book and the i th integer is the time i th person to copy one book). You must distribute the continuous id books to one people to copy. (You can give book A[1],A[2] to one people, but you cannot give book A[1], A[3] to one people, because book A[1] and A[3] is not continuous.) Return the number of smallest minutes need to copy all the books.

Have you met this question in a real interview? Yes
Example
Given n = 4, array A = [3,2,4], .

Return 4( First person spends 3 minutes to copy book 1, Second person spends 4 minutes to copy book 2 and 3, Third person spends 4 minutes to copy book 4. )



 *
 */
public class Copy_Books_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	更符合生活实际，不同人想copy或者抄写同一版本的书
//	比如：有20个人抄写速度都不一样，想把一本书总共抄写100万遍，就像知道最快时间多长时间可以完成
//	抽象：有相同的工作对象若干，每种工作方法所需时间可能各不相同，寻求最短多长时间可以完成工作
    //worked, first solution, int[k][n+1], but Memory Limit Exceeded
    public static int copyBooksII00(int n, int[] times) {
        int k = times.length;
        int[][] f = new int[k][n+1];
        for (int j = 0 ; j <= n; ++j) {
            f[0][j] = j * times[0];
        }
        for (int i = 1; i < k; ++i) {
            for (int j = 1; j <= n; ++j) {
                //两层循环，更新f[i][j]
                f[i][j] = Integer.MAX_VALUE;
                //当前第i个人copy了l本书，那么前面i-1个人copy了j-l本书，把所有可能遍历一遍
                //for循环体现了j的组成是多路并列线，而不像backpack
                for (int l = 0; l <= j; ++l) {
                    // if (f[i-1][j-l] > times[i] * l) {//体现了总和是j，如果大于l还需要增加
                    //     f[i][j] = Math.min(f[i][j], f[i-1][j-l]);
                    // } else {
                    //     f[i][j] = Math.min(f[i][j], times[i] * l);
                    //     break;
                    // }
                    
                    f[i][j] = Math.min(f[i][j], Math.max(f[i-1][j-l], times[i] * l));
                    if (f[i-1][j-l] <= times[i] * l) {
                        break;
                    }
                }
                
            }
        }
        return f[k-1][n];
    }

    // worked, second solution, best solution, int[2][n+1];
    public  static int copyBooksII01(int n, int[] times) {
        int k = times.length;
        int[][] f = new int[2][n+1];
        for (int j = 0 ; j <= n; ++j) {
            f[0][j] = j * times[0];
        }
        for (int i = 1; i < k; ++i) {//第i个人
            for (int j = 1; j <= n; ++j) {//第j本书
                // int curr = i % 2;
                // int prev = (i - 1) % 2;
                //两层循环，更新f[i][j]
                f[i%2][j] = Integer.MAX_VALUE;
                //当前第i个人copy了l本书，那么前面i-1个人copy了j-l本书，把所有可能遍历一遍
                //for循环体现了j的组成是多路并列线，而不像backpack
                for (int l = 0; l <= j; ++l) {
                    if (f[(i-1)%2][j-l] > times[i] * l) {
                        //体现了总和是j，如果大于l还需要增加
                        f[i%2][j] = Math.min(f[i%2][j], f[(i-1)%2][j-l]);
                    } else {
                        f[i%2][j] = Math.min(f[i%2][j], times[i] * l);
                        break;
                    }
                    // f[i%2][j] = Math.min(f[i%2][j], Math.max(f[(i-1)%2][j-l], times[i%2] * l));
                    // if (f[(i-1)%2][j-l] <= times[i%2] * l) {
                    //     break;
                    // }
                }
            }
        }
        return f[(k-1)%2][n];
    }

    // worked, third solution only for pass OJ, best solution, int[2][n+1];
    public static int copyBooksII(int n, int[] times) {
        int k = times.length;
        int[][] f = new int[2][n+1];
        for (int j = 0 ; j <= n; ++j) {
            f[0][j] = j * times[0];
        }
        for (int i = 1; i < k; ++i) {//第i个人
            for (int j = 1; j <= n; ++j) {//第j本书
                int curr = i % 2;
                int prev = (i - 1) % 2;
                //两层循环，更新f[i][j]
                f[curr][j] = Integer.MAX_VALUE;
                //当前第i个人copy了l本书，那么前面i-1个人copy了j-l本书，把所有可能遍历一遍
                //for循环体现了j的组成是多路并列线，而不像backpack
                for (int l = 0; l <= j; ++l) {
                    if (f[prev][j-l] > times[i] * l) {
                        //体现了总和是j，如果大于l还需要增加
                        f[curr][j] = Math.min(f[curr][j], f[prev][j-l]);
                    } else {
                        f[curr][j] = Math.min(f[curr][j], times[i] * l);
                        break;
                    }
                    // f[i%2][j] = Math.min(f[i%2][j], Math.max(f[(i-1)%2][j-l], times[i%2] * l));
                    // if (f[(i-1)%2][j-l] <= times[i%2] * l) {
                    //     break;
                    // }
                }
            }
        }
        return f[(k-1)%2][n];
    }	
}
