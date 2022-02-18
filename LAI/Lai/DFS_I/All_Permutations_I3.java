package Lai.DFS_I;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeMap;

import javax.swing.plaf.ComponentInputMapUIResource;
import javax.xml.bind.helpers.AbstractUnmarshallerImpl;

import Lintcode.BinaryTree.TreeNode;
import Lintcode.String.Space_Replacement;
import Utils.TreeNodeUtils.TracingLevelInfo;
import Utils.TreeNodeUtils.TracingNodeInfo;
import Utils.TreeNodeUtils.TracingTreeInfo;
import jdk.internal.dynalink.beans.StaticClass;

public class All_Permutations_I3 {
	public static class TracingRecu {
		//provide a TracingPara 
		public static class TracingPara {
			List<String> result;
			char[] arr;
			int level;
			String paraStr = "";

			public TracingPara(List<String> result, char[] arr, int level) {
				super();
				this.result = result;
				this.arr = arr;
				this.level = level;
				this.paraStr = String.format("[%d:%s]", level, String.valueOf(arr));
			}

		}

		static int counter = 0;
		int id; // 调用次序 和 id
		int level = 0;
		TracingPara tracingPara;

		int delimiterWidth = 1;
		int preWidth = 0;
		int nodeWidth;
		int postWidth = 0;
		public int widthBtwSiblings = 0; // only between internal nodes or to be
											// decided (Updated: for spaces
											// between siblings)
		public int widthBtwChildren = 0; // only between internal nodes or to be
											// decided(Updated: for spaces
											// between children)

		TracingRecu parent;
		List<TracingRecu> children = new ArrayList<>();
		public static TreeMap<Integer, List<TracingRecu>> LEVEL_NODE_MAP = new TreeMap<>();
		TracingRecu rightMostChild;

		public String nodeStr = "";// seems no need this, delimiter + pre +
									// paraStr+ post+delimiter
		public String connStr = ""; // this is supposed to connect node and its
									// children
		private boolean isRightMostChild = false;

		public TracingRecu(TracingRecu parent, List<String> result, char[] arr, int level) {
			this(parent, new TracingPara(result, arr, level));
		}

		public TracingRecu(TracingRecu parent, TracingPara para) {
			super();
			this.id = counter++;
			this.parent = parent;
			if (parent != null) {
				parent.children.add(this);
			}
			this.tracingPara = para;
			this.nodeWidth = this.tracingPara.paraStr.length();
			if (parent == null) {
				this.level = 0;
			} else {
				this.level = parent.level + 1;
			}
			List<TracingRecu> list = LEVEL_NODE_MAP.getOrDefault(this.level, new ArrayList<>());
			list.add(this);
			LEVEL_NODE_MAP.putIfAbsent(this.level, list);
		}

		public void print() {
			bottomUp2UpdateWidthBtwChildren();
			topDown2UpdateWidthBtwSiblings();
			printLevelStrAndConnStr();
		}

		private void bottomUp2UpdateWidthBtwChildren() {
//			got new widthBtwChildren, relocate nodeStr and update preWidth and postWidth of root
//			update parent.nodeStr 
			NavigableSet<Integer> set = LEVEL_NODE_MAP.descendingKeySet();
			for (Integer key : set) {
				for (TracingRecu node : LEVEL_NODE_MAP.get(key)) {
					if (node.children.size() == 0) {
						node.nodeStr += generateCharStr(node.delimiterWidth + node.preWidth) + node.tracingPara.paraStr
								+ generateCharStr(node.postWidth + node.delimiterWidth);
						node.connStr += "";
						continue;
					}
					int nodeLen = 2 * node.delimiterWidth + node.preWidth + node.nodeWidth + node.postWidth;
					int childrenLen = 0;
					while (childrenLen < nodeLen) {
						node.widthBtwChildren++;
//						System.out.println("node.widthBtwChildren++ : "+node.widthBtwChildren);
						for (int i = 0; i < node.children.size(); i++) {
							TracingRecu child = node.children.get(i);
							child.widthBtwSiblings = node.widthBtwChildren; // increase
																			// child.widthBtwNodes
//							System.out.printf("id:widthBtwSiblings %d:%d \n", child.id, child.widthBtwSiblings);
							if (i != node.children.size() - 1) {
								childrenLen += child.widthBtwSiblings;
							} else {
								child.isRightMostChild = true;
								node.rightMostChild = child;// for each node,
															// mark right most
															// child
							}
							childrenLen += 2 * child.delimiterWidth + child.preWidth + child.nodeWidth
									+ child.postWidth;
						}
					}
//					System.out.printf("id:widthBtwSiblings %d:%d \n", node.id, node.widthBtwSiblings);
					// here : childrenLen >= nodeLen, got new widthBtwChildren,
					// relocate nodeStr and update preWidth and postWidth of
					// root
					int diff = childrenLen - 2 * node.delimiterWidth - node.nodeWidth;
					node.preWidth = diff / 2;
					node.postWidth = diff - node.preWidth;

					node.nodeStr += generateCharStr(node.delimiterWidth + node.preWidth) + node.tracingPara.paraStr
							+ generateCharStr(node.postWidth + node.delimiterWidth);

				}
			}
		}

		private void topDown2UpdateWidthBtwSiblings() {
			// from root to leaf, update widthBtwNodes for rightMostChild
			boolean needVerify = false;
			NavigableSet<Integer> set = LEVEL_NODE_MAP.navigableKeySet();
			for (Integer key : set) {
				for (TracingRecu node : LEVEL_NODE_MAP.get(key)) {
					if (node.children.size() == 0) {
						continue;
					}
					TracingRecu curr = node;
					while (curr.rightMostChild != null) {
						curr.rightMostChild.widthBtwSiblings = curr.widthBtwSiblings;
						curr = curr.rightMostChild;
					}
					if (needVerify) {
						System.out.println("\n[Verifying ... ] id: " + node.id);
						final String DELIMITER = "|";
						String expected = DELIMITER + node.nodeStr + DELIMITER + generateCharStr(node.widthBtwSiblings)
								+ DELIMITER;
						System.out.println(expected);
						String actural = DELIMITER;
						for (int i = 0; i < node.children.size(); i++) {
							TracingRecu child = node.children.get(i);
							if (i != node.children.size() - 1) {
								actural += child.nodeStr + generateCharStr(child.widthBtwSiblings);
							} else {
								actural += child.nodeStr;
							}
						}
						actural += DELIMITER + generateCharStr(node.widthBtwSiblings) + DELIMITER;
						System.out.println(actural);
						System.out.println(
								"[Result] " + (expected.length() == actural.length() ? "TRUE" : "FALSE") + "\n");
					}
				}
			}
		}

		private void printLevelStrAndConnStr() {
			final String DELIMITER = "";
			NavigableSet<Integer> set = LEVEL_NODE_MAP.navigableKeySet();
			for (Integer level : set) {
				String nodeStr = "";// for each level
				String connStr = "";// for each level
				StringBuilder sbNodeStr = new StringBuilder();// for each node
				StringBuilder sbConnStr = new StringBuilder(); // for each node

				for (TracingRecu node : LEVEL_NODE_MAP.get(level)) {
					if (node.children.size() == 0) {
						nodeStr += DELIMITER + node.nodeStr + DELIMITER + generateCharStr(node.widthBtwSiblings)
								+ DELIMITER;
						continue;
					} else {
						String expected = DELIMITER + node.nodeStr + DELIMITER + generateCharStr(node.widthBtwSiblings)
								+ DELIMITER;
						String actural = DELIMITER;
						for (int i = 0; i < node.children.size(); i++) {
							TracingRecu child = node.children.get(i);
							if (i == 0) {
								actural += child.nodeStr;
								sbConnStr.append(generateCharStr(child.delimiterWidth + child.preWidth)).append("+")
										.append(generateCharStr(child.tracingPara.paraStr.length() - 1 + child.postWidth
												+ child.delimiterWidth + child.widthBtwSiblings, '-'));
							} else if (i != node.children.size() - 1) {
								actural += child.nodeStr + generateCharStr(child.widthBtwSiblings);
								sbConnStr.append(generateCharStr(child.delimiterWidth + child.preWidth, '-'))
										.append("+")
										.append(generateCharStr(child.tracingPara.paraStr.length() - 1 + child.postWidth
												+ child.delimiterWidth + child.widthBtwSiblings, '-'));
							} else {
								actural += child.nodeStr;
								sbConnStr.append(generateCharStr(child.delimiterWidth + child.preWidth, '-'))
										.append("+").append(generateCharStr(child.tracingPara.paraStr.length() - 1
												+ child.postWidth + child.delimiterWidth + node.widthBtwSiblings));
							}

						}
						actural += DELIMITER + generateCharStr(node.widthBtwSiblings) + DELIMITER;
						nodeStr += expected;
						sbNodeStr.setLength(0);

						sbConnStr.setCharAt(node.delimiterWidth + node.preWidth, '^');
						connStr += sbConnStr.toString();
						sbConnStr.setLength(0);
					}
				}
				System.out.printf("level:nodeStr  %d:%s \n", level, nodeStr);
				System.out.printf("level:connStr  %d:%s \n", level, connStr);
			}

		}

		private String generateCharStr(int width) {
			return generateCharStr(width, ' ');
		}

		private String generateCharStr(int width, char ch) {
			StringBuilder sb = new StringBuilder();
			while (--width >= 0) {
				sb.append(ch);
			}
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcd";
		System.out.println("" + permutations(str));
	}

	public static List<String> permutations(String str) {
		// Write your solution here
		List<String> result = new ArrayList<>();
		char[] arr = str.toCharArray();

		TracingRecu rec = new TracingRecu(null, result, arr, 0);
		helper(result, arr, 0, rec);
		rec.print();

		return result;
	}

	// (1) result存放所有最终的结果，也就是所有可能的排列
	// (2) arr 单个变量，初始化为静态的值，但是经过递归变化，可以动态遍历所有可能的排列，当符合条件的时候，其快照存入result，
	// (3) index表示它的左边从0开始不包含它的位置已经选好元素了，
	// 所以只给index这个位置，从目前arr里面可能选择的字符里面，选取一个
	// index初始化为0，从0位置开始选择所有可能的元素放入，一个都不能缺，当index变为len-1或者len时就可以结束了。
	// 要将元素搬来搬去，还能随机选取，string要变为数组

	private static void helper(List<String> result, char[] arr, int level, TracingRecu tracingRec) {
		if (level == arr.length - 1) {
			result.add(String.valueOf(arr));
			System.out.printf("index:arr %d:%s \n", level, new String(arr));
			return;
		}
		for (int i = level; i < arr.length; i++) {
			swap(arr, level, i);
			helper(result, arr, level + 1, new TracingRecu(tracingRec, result, arr, level + 1));
			swap(arr, level, i);
		}
	}

	private static void swap(char[] arr, int left, int right) {
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
