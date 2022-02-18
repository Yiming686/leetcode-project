package LeetCode.Union.Find;


public class Weighted_Tree_Union_Find {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] id;
	private int count;
	public Weighted_Tree_Union_Find(int n) {
		id = new int[n];
		for(int i = 0; i < n; i++) {
			id[i] = i;
		}
		count = n;
	} 
	// It¡¯s a connectivity problem of [0, 1, 2¡­, n - 1]

	public void union(int a, int b) {
		// connect two points a, b
		if(id[a] == id[b]) {
			return;
		}
		int idb = id[b];
		for(int i = 0; i < id.length; i++) {
			if(id[i] == idb) {
				id[i] = id[a];
			}
		}
		count--;
	}

	public boolean isConnected(int a, int b) {
		// query if two points a, b are connected
		return id[a] == id[b];
	} 

	public int id(int a) {
		// query label of connected component of a
		return id[a];
	} 

	public int count() {
		// query how many connected components right now
		return count;
	} 


	    
}

// class UnionFind {
//
//    public UnionFind(int n) 
//    // It¡¯s a connectivity problem of [0, 1, 2¡­, n - 1]
//
//    public void union(int a, int b) 
//    // connect two points a, b
//
//    public boolean isConnected(int a, int b) 
//    // query if two points a, b are connected
//
//    public int id(int a) 
//    // query label of connected component of a
//
//    public int count() 
//    // query how many connected components right now
//
//}
//
