package Utils;

import java.util.HashMap;
import java.util.Map;

import Utils.TreeNodeUtils.TP;

public class TrieNodeUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class TrieNode {
		public boolean isWord;
		public String word;
		public Map<Character, TrieNode> children;

		public TrieNode() {
			this.children = new HashMap<>();
		}
	}

	public static void print(TrieNode root) {
		TP tp = new TP("isWord:word", "111", null, null, root.isWord, root.word);
		print(root, tp);
		tp.print();
	}

	private static void print(TrieNode root, TP parent) {
		for (int i = 0; i < 26; i++) {
			char ch = (char) (i + 'a');
			TrieNode child = root.children.get(ch);
			if (child != null) {
				print(child, TP.build(parent, ch, child.isWord, child.word));
			}
		}
	}
}
