package Lai.DFS_I;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;

import Utils.TreeNodeUtils.TracingLevelInfo;
import Utils.TreeNodeUtils.TracingNodeInfo;
import Utils.TreeNodeUtils.TracingTreeInfo;

public class All_Permutations_I2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String str = "56789";
		String str = "abc";
		System.out.println(""+permutations(str));
	}

	public static List<String> permutations(String str) {
		// Write your solution here
		List<String> result = new ArrayList<>();
		char[] arr = str.toCharArray();
		
//		TreeNodeUtils.DebugTreeNode<String> dgroot = new TreeNodeUtils.DebugTreeNode<>(String.valueOf(arr));
		TracingNodeInfo nodeInfo = new TracingNodeInfo(0, String.valueOf(arr));
		
		TracingLevelInfo levelInfo = new TracingLevelInfo();
		levelInfo.numOfNodes++;
		levelInfo.level= 0;
		TracingLevelInfo.TracingLevelGroup group = new TracingLevelInfo.TracingLevelGroup();
		levelInfo.groups = (levelInfo.groups != null) ? levelInfo.groups : new ArrayList<>();
		levelInfo.groups.add(group);
		group.children.add(nodeInfo);

		group.root = null;
		
		TracingTreeInfo treeInfo = new TracingTreeInfo(nodeInfo);
		treeInfo.root = nodeInfo;
		treeInfo.map.put(0, levelInfo);
		treeInfo.numOfNodes++;
		

		
		helper(result, arr, 0, nodeInfo, treeInfo);
//		TracingTreeInfo.printTree(nodeInfo);
//		NavigableMap<Integer, TracingLevelInfo> map2 = treeInfo.map.descendingMap();
		
		treeInfo.print();

		return result;
	}

	//(1) result存放所有最终的结果，也就是所有可能的排列
	//(2) arr 单个变量，初始化为静态的值，但是经过递归变化，可以动态遍历所有可能的排列，当符合条件的时候，其快照存入result，
	//(3) index表示它的左边从0开始不包含它的位置已经选好元素了，
	//所以只给index这个位置，从目前arr里面可能选择的字符里面，选取一个
	//index初始化为0，从0位置开始选择所有可能的元素放入，一个都不能缺，当index变为len-1或者len时就可以结束了。
	//要将元素搬来搬去，还能随机选取，string要变为数组
//	private static void helper(List<String> result, char[] arr, int index, TreeNodeUtils.DebugTreeNode<String> dgroot) {
	private static void helper(List<String> result, char[] arr, int level, TracingNodeInfo nodeInfo, TracingTreeInfo treeInfo) {		
		// TODO Auto-generated method stub
		if(level == arr.length - 1) {
			result.add(String.valueOf(arr));
			return;
		}
		Integer nextLevel = level + 1;
		TracingLevelInfo levelInfo = treeInfo.map.getOrDefault(nextLevel, new TracingLevelInfo());
		treeInfo.map.putIfAbsent(nextLevel, levelInfo);
		levelInfo.level = nextLevel;
		
		TracingLevelInfo.TracingLevelGroup group = new TracingLevelInfo.TracingLevelGroup();
		levelInfo.groups = (levelInfo.groups != null) ? levelInfo.groups : new ArrayList<>();
		levelInfo.groups.add(group);
		group.root = nodeInfo;
		
		for(int i = level; i < arr.length; i++ ) {
			swap(arr, level, i);
			System.out.printf("index:arr %d:%s \n",level, new String(arr));
//			TreeNodeUtils.DebugTreeNode<String> child = new TreeNodeUtils.DebugTreeNode<>(new String(arr));
//			TreeNodeUtils.DebugTreeNode<String> child = new TreeNodeUtils.DebugTreeNode<>(new String(arr));
			TracingNodeInfo childNodeInfo = new TracingNodeInfo(nextLevel, new String(arr));
			nodeInfo.children.add(childNodeInfo);
			childNodeInfo.level = nextLevel;
			
			
			levelInfo.numOfNodes++;
			group.children.add(childNodeInfo);
			
			treeInfo.height = Math.max(treeInfo.height, nextLevel);
			treeInfo.numOfNodes++;
			
			helper(result, arr, nextLevel, childNodeInfo, treeInfo);
			swap(arr, level, i);
		}
	}

	private static void swap(char[] arr, int left, int right) {
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
