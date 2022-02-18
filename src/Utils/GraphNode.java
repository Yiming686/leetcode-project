package Utils;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + key;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GraphNode other = (GraphNode) obj;
		if (key != other.key)
			return false;
		return true;
	}

	@Override
//	public String toString() {
//		return "GraphNode [key=" + key + "]";
//	}
//	public String toString() {
//		return "[" + key + "]";
//	}
	public String toString() {
		return "" + key + "";
	}
	
	public String toNeis() {
		return "" + key + ":"+neighbors.toString();
	}
	public int key;
	public List<GraphNode> neighbors;

	public GraphNode(int key) {
		this.key = key;
		this.neighbors = new ArrayList<GraphNode>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//public class GraphNode<E> {
//
//	public E val;
//	public List<GraphNode> neighbors;
//
//	public GraphNode(E val) {
//		this.val = val;
//		this.neighbors = new ArrayList<GraphNode>();
//	}
//
//}
