package Lai.DFS_I;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import com.sun.org.apache.xml.internal.security.Init;

public class All_Permutations_I4 {

//	provide a TracingPara,
//	who is its parent, what are the tracing parameters, how to present the parameters
//	create tracing recursiong based on all this
	public static class TracingPara {
// Para section starts here		
		private List<String> result;
		private char[] arr;
		private int level;

		String generateParaFormat() {
			return "[level:id]";
		}

		String generateParaStr() {
			return String.format("[%d:%s]", this.tracingRecu.id, String.valueOf(arr));
		}

		public TracingPara(TracingPara parent, List<String> result, char[] arr, int level) {
			this.tracingRecu = new TracingRecu(parent == null ? null : parent.tracingRecu, this);

			this.parent = parent;
			this.result = result;
			this.arr = arr;
			this.level = level;

			this.paraFormat = "[id:arr]";
			this.paraStr = String.format("[%d:%s]", this.tracingRecu.id, String.valueOf(arr));
		}
//	Para section ends here
 		private String paraFormat;
		private String paraStr;
		private TracingPara parent;
		private TracingRecu tracingRecu;

		public void print() {
			// TODO Auto-generated method stub
			this.tracingRecu.print();
		}

	}

	public static class TracingRecu {

		TracingPara tracingPara;
		static int counter = 0;
		int id; // 调用次序 和 id
		int level = 0;

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

		public TracingRecu(TracingRecu parent, TracingPara para) {
			super();
			this.id = counter++;
			this.parent = parent;
			if (parent != null) {
				parent.children.add(this);
			}
			this.tracingPara = para;
//			this.nodeWidth = this.tracingPara.paraStr.length(); // not easy to maintain constancy of , multiple points to 
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
//			verifyLevelStrAndConnStr(true);
			topDown2UpdateWidthBtwSiblings();
//			verifyLevelStrAndConnStr(true);
			printLevelStrAndConnStr();
		}

		private void verifyLevelStrAndConnStr(boolean needVerify) {
			// from root to leaf, update widthBtwNodes for rightMostChild
			if (!needVerify) {
				return;
			}
			System.out.println("---[VERIFYING START]-----------------------------------------------------------------------------");
			int numOfTrue = 0, numOfFalse = 0;
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
					final String DELIMITER = "|";
					String expected = DELIMITER + node.nodeStr + DELIMITER + generateCharStr(node.widthBtwSiblings)
							+ DELIMITER;
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
					String result = (expected.length() == actural.length() ? "TRUE" : "FALSE");
					if(expected.length() == actural.length()) {
						numOfTrue++;
						result =  "TRUE";
					}else {
						numOfFalse++;
						result = "FALSE";
					}
					System.out.println("\n[Verifying ... ] id: " + node.id);
					System.out.println(expected);
					System.out.println(actural);
					System.out.println("[Result] " + result + "\n");
				}
			}
			String finalResult = "";
			String details = " NumOfTrue: " +numOfTrue +", NumOfFalse: "+numOfFalse +" ";
			if(numOfTrue == 0 && numOfFalse == 0) {
				finalResult += "NOT VERIFIED!" + details;
			}else if(numOfTrue == 0) {
				finalResult += "SORRY! ALL FALSE!" + details;
			}else if(numOfFalse == 0){
				finalResult += "CONGRATULATIONS! ALL TRUE!" + details;
			}else {
				finalResult += "WARNING! NOT ALL TRUE, NOT ALL FALSE!" + details;
			}			
			System.out.println("[VERIFYING SUMMARY] "+finalResult+" \n");
			System.out.println("---[VERIFYING START]-----------------------------------------------------------------------------\n");
		}

		private void bottomUp2UpdateWidthBtwChildren() {
//			got new widthBtwChildren, relocate nodeStr and update preWidth and postWidth of root
//			update parent.nodeStr 
			NavigableSet<Integer> set = LEVEL_NODE_MAP.descendingKeySet();
			for (Integer key : set) {
				for (TracingRecu node : LEVEL_NODE_MAP.get(key)) {
//					this.nodeWidth = this.tracingPara.paraStr.length();

					if (node.children.size() == 0) {
						node.nodeStr += generateCharStr(node.delimiterWidth + node.preWidth) + node.tracingPara.paraStr
								+ generateCharStr(node.postWidth + node.delimiterWidth);
						node.connStr += "";
						continue;
					}
//					int nodeLen = 2 * node.delimiterWidth + node.preWidth + node.nodeWidth + node.postWidth;
					int nodeLen = 2 * node.delimiterWidth + node.preWidth + node.tracingPara.paraStr.length() + node.postWidth;
					int childrenLen = 0;
					while (childrenLen < nodeLen) {
						node.widthBtwChildren++;
						System.out.printf("id:node.widthBtwChildren++ %d:%d \n", node.id, node.widthBtwChildren);
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
//							childrenLen += 2 * child.delimiterWidth + child.preWidth + child.nodeWidth
//									+ child.postWidth;
							childrenLen += 2 * child.delimiterWidth + child.preWidth + child.tracingPara.paraStr.length()
									+ child.postWidth;
							
						}
					}
//					System.out.printf("id:widthBtwSiblings %d:%d \n", node.id, node.widthBtwSiblings);
					// here : childrenLen >= nodeLen, got new widthBtwChildren,
					// relocate nodeStr and update preWidth and postWidth of
					// root
//					int diff = childrenLen - 2 * node.delimiterWidth - node.nodeWidth;
					int diff = childrenLen - 2 * node.delimiterWidth - node.tracingPara.paraStr.length();
					node.preWidth = diff / 2;
					node.postWidth = diff - node.preWidth;

					node.nodeStr += generateCharStr(node.delimiterWidth + node.preWidth) + node.tracingPara.paraStr
							+ generateCharStr(node.postWidth + node.delimiterWidth);
					System.out.println("nodeStr: "+node.nodeStr);
					System.out.printf("nodeLen:childrenLen %d:%d \n", nodeLen, childrenLen);
//					System.out.printf("nodeLen:childrenLen %d:%d \n", node.delimiterWidth,node.preWidth,node., childrenLen);

				}
			}
		}

		private void topDown2UpdateWidthBtwSiblings() {
			// from root to leaf, update widthBtwNodes for rightMostChild
			boolean needVerify = true;
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
								actural += child.nodeStr + DELIMITER + generateCharStr(child.widthBtwSiblings);
							}
						}
//						actural += DELIMITER + generateCharStr(node.widthBtwSiblings) + DELIMITER;
						actural += DELIMITER;
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

						if(sbConnStr.charAt(node.delimiterWidth + node.preWidth) == '+') {
							sbConnStr.setCharAt(node.delimiterWidth + node.preWidth, '^');
						}else {
							sbConnStr.setCharAt(node.delimiterWidth + node.preWidth +2, '^');
						}
						connStr += sbConnStr.toString();
						sbConnStr.setLength(0);
					}
				}
				System.out.printf(this.tracingPara.paraFormat + " %d:%-4d%s \n", level, LEVEL_NODE_MAP.get(level).size(), nodeStr);
				System.out.printf(this.tracingPara.paraFormat + " %d:%-4d%s \n", level, LEVEL_NODE_MAP.get(level).size(), connStr);
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

		TracingPara tracingPara = new TracingPara(null, result, arr, 0);
		helper(result, arr, 0, tracingPara);
		tracingPara.print();

		return result;
	}

	// (1) result存放所有最终的结果，也就是所有可能的排列
	// (2) arr 单个变量，初始化为静态的值，但是经过递归变化，可以动态遍历所有可能的排列，当符合条件的时候，其快照存入result，
	// (3) index表示它的左边从0开始不包含它的位置已经选好元素了，
	// 所以只给index这个位置，从目前arr里面可能选择的字符里面，选取一个
	// index初始化为0，从0位置开始选择所有可能的元素放入，一个都不能缺，当index变为len-1或者len时就可以结束了。
	// 要将元素搬来搬去，还能随机选取，string要变为数组

	private static void helper(List<String> result, char[] arr, int level, TracingPara tracingPara) {
		if (level == arr.length - 1) {
			result.add(String.valueOf(arr));
			System.out.printf("index:arr %d:%s \n", level, new String(arr));
			return;
		}
		for (int i = level; i < arr.length; i++) {
			swap(arr, level, i);
			helper(result, arr, level + 1, new TracingPara(tracingPara, result, arr, level + 1));
			swap(arr, level, i);
		}
	}

	private static void swap(char[] arr, int left, int right) {
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
