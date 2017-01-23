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
	//������еĳ���
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
	
//	����
//	�ܵ��͵�union-find�⡣��Ϊ�����Ƕ�̬������land��Ҫ����ʱ����ж��ٸ�island����򵥵ķ�������union-find��
//	���ǿ��Զ���һ��counter, ÿ����һ��land, ����counter, Ȼ�����������Ǹ�land�ھ����򣬷���root��һ���Ļ���
//	��ζ�ſ���union, ÿunionһ�Σ���ζ������island�ϲ���һ������Сcounter, ͳ�����յ�counterֵ����������land�������island�ĸ�����
//
//	Ϊ�˼�Сʱ�临�Ӷȣ�����ʵ����QuickUnion + Path Compression, Path CompressionĿ����Ϊ�˵������ĸ߶ȣ����ֺ�ƽ������������Խ��Խ�ߣ�������root�������worst case.
//
//	���Ӷ�
//	time: O(Mlog(N)), space: O(N)
//	M��ʾ����land��������N��ʾ�����е�ĸ�����m*n��
//
//	����
    public List<Integer> numIslands24(int m, int n, int[][] positions) {
        int[] id = new int[m * n]; // ��ʾ����index��Ӧ��root
        
        List<Integer> res = new ArrayList<Integer>();
        Arrays.fill(id, -1); // ��ʼ��rootΪ-1���������water, ��-1��ʾland
        int count = 0; // ��¼island������
        
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < positions.length; i++) {
            count++;
            int index = positions[i][0] * n + positions[i][1];           
            id[index] = index; // root��ʼ��
            
            for (int j = 0; j < dirs.length; j++) {
                int x = positions[i][0] + dirs[j][0];
                int y = positions[i][1] + dirs[j][1];
                if (x >= 0 && x < m && y >= 0 && y < n && id[x * n + y] != -1) {
                    int root = root(id, x * n + y);

                    // ����root���ȵ�����£���union, ͬʱ��Сcount
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
            id[i] = id[id[i]]; // �Ż���Ϊ�˼�С���ĸ߶�                
            i = id[i];
        }
        return i;
    }


}
