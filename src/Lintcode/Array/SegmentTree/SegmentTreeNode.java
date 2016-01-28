package Lintcode.Array.SegmentTree;

public class SegmentTreeNode {

    public int start, end, max;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max;
        this.left = this.right = null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
