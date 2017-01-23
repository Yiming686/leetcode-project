package Lintcode.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Number of Islands II
 * 
 * Given a n,m which means the row and column of the 2D matrix and an array of
 * pair A( size k ). Originally, the 2D matrix is all 0 which means there is
 * only sea in the matrix. The list pair has k operator and each operator has
 * two integer A[i].x, A[i].y means that you can change the grid
 * matrix[A[i].x][A[i].y] from sea to island. Return how many island are there
 * in the matrix after each operator.
 * 
 * Have you met this question in a real interview? Yes
 * 
 * Example
 * 
 * Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].
 * 
 * return [1,1,2,2].
 * 
 * Note
 * 
 * 0 is represented as the sea, 1 is represented as the island. If two 1 is
 * adjacent, we consider them in the same island. We only consider
 * up/down/left/right adjacent.
 * 
 * 
 * Method 1: Union Find
 * 
 * Analysis
 * 
 * We can use Union Find algorithm to solve this question. We can use a id to
 * represent each islands, and construct a tree like structure for each island.
 * If two islands meet each other, simply set one's parent to the other so that
 * they are marked as one island.
 * 
 * Complexity
 * 
 * Time: O(p*p), p is the number of points. Another p is used to find the root
 * of the island.
 * 
 * Space: O(p)
 *
 *
 * 
 * 
 */
public class Number_of_Islands_II {
	public static void main(String[] args) {
	}

	private Map<Integer, Integer> rootMap = new HashMap<Integer, Integer>();
	private static final int[][] DIRS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public List<Integer> numIslands2(int n, int m, Point[] operators) {
		List<Integer> result = new ArrayList<Integer>();
		if (operators == null || n <= 0 || m <= 0) {
			return result;
		}
		boolean[][] islands = new boolean[n][m];
		int count = 0;
		for (Point p : operators) {
			if (!islands[p.x][p.y]) {
				islands[p.x][p.y] = true;
				count++;
				int id = getId(p.x, p.y, m);
				rootMap.put(id, id);
				for (int i = 0; i < 4; ++i) {
					int newX = p.x + DIRS[i][0];
					int newY = p.y + DIRS[i][1];
					if (newX >= 0 && newX < n && newY >= 0 && newY < m && islands[newX][newY]) {
						int newId = getId(newX, newY, m);
						int root = findRoot(id);
						int newRoot = findRoot(newId);
						if (root != newRoot) {
							--count;
							union(root, newRoot);
						}
					}
				}
			}
			result.add(count);
		}
		return result;
	}
	//坐标和列的长度
	private int getId(int x, int y, int m) {
		return x * m + y;
	}

	private int findRoot(int id) {
		int root = rootMap.get(id);
		while (root != rootMap.get(root)) {
			root = rootMap.get(root);
		}
		return root;
	}

	private void union(int root1, int root2) {
		rootMap.put(root1, root2);
	}

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
	
//	分析
//	很典型的union-find题。因为这里是动态的增加land，要能随时求出有多少个island，最简单的方法就是union-find。
//	我们可以定义一个counter, 每增加一个land, 增加counter, 然后我们搜索那个land邻居区域，发现root不一样的话，
//	意味着可以union, 每union一次，意味着两个island合并成一个，减小counter, 统计最终的counter值，即是增加land后的最终island的个数。
//
//	为了减小时间复杂度，代码实现是QuickUnion + Path Compression, Path Compression目的是为了调整树的高度，保持很平的树，而不是越来越高，这样找root不会出现worst case.
//
//	复杂度
//	time: O(Mlog(N)), space: O(N)
//	M表示增加land的数量，N表示矩阵中点的个数即m*n。
//
//	代码
    public List<Integer> numIslands24(int m, int n, int[][] positions) {
        int[] id = new int[m * n]; // 表示各个index对应的root
        
        List<Integer> res = new ArrayList<Integer>();
        Arrays.fill(id, -1); // 初始化root为-1，用来标记water, 非-1表示land
        int count = 0; // 记录island的数量
        
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < positions.length; i++) {
            count++;
            int index = positions[i][0] * n + positions[i][1];           
            id[index] = index; // root初始化
            
            for (int j = 0; j < dirs.length; j++) {
                int x = positions[i][0] + dirs[j][0];
                int y = positions[i][1] + dirs[j][1];
                if (x >= 0 && x < m && y >= 0 && y < n && id[x * n + y] != -1) {
                    int root = root(id, x * n + y);

                    // 发现root不等的情况下，才union, 同时减小count
                    if (root != index) {
                        id[root] = index;
                        count--;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
    
    public int root(int[] id, int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // 优化，为了减小树的高度                
            i = id[i];
        }
        return i;
    }


}
