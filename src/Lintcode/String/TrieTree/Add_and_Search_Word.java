package Lintcode.String.TrieTree;

import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.StackInstruction;

/**
 Add and Search Word

Design a data structure that supports the following two operations: addWord(word) and search(word)

search(word) can search a literal word or a regular expression string containing only letters a-z or ..

A . means it can represent any one letter.

Have you met this question in a real interview? Yes
Example
addWord("bad")
addWord("dad")
addWord("mad")
search("pad")  // return false
search("bad")  // return true
search(".ad")  // return true
search("b..")  // return true
Note
You may assume that all words are consist of lowercase letters a-z.

Tags Expand 
Trie


Related Problems Expand 
Medium Implement Trie

 *
 */
public class Add_and_Search_Word {

	public static void main(String[] args) {
		System.out.println(""+Integer.MAX_VALUE);
		// TODO Auto-generated method stub
		addWord("a");
//		addWord("ab");
//		addWord("abc");
		addWord("d");
		addWord("dc");
		System.out.println(""+search("."));
		System.out.println(""+search("ab"));
	}
	
	static class TrieNode {
        // Initialize your data structure here.
        public HashMap<Character, TrieNode> children;
        public boolean hasWord;
        
        // Initialize your data structure here.
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            hasWord = false;
        }
    }

    private static TrieNode root = new TrieNode();;
 
    public Add_and_Search_Word(){
        root = new TrieNode();
    }
 
    // Adds a word into the data structure.
    public static void addWord(String word) {
        // Write your code here
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.hasWord = true;
    }
    
    //�ڵ�ǰTrieTree��,��Word�ĵ�index���ַ���ʼ���ַ�����
    private static boolean search(TrieNode node, String word, int index) {
        if(index >= word.length()){
//        	if(node.children.size()==0) 
////            if(node.hasWord == true) //worked as well
//                return true; 
//            else
                return false;
        }
        char ch = word.charAt(index);//׼������indexָ����ַ����ؼ���������ʲôʱ��ſ��Դ�����һ���ַ�
        if (node.children.containsKey(ch)) {
        	//index��ָ��������һ���ַ�,�����ӽڵ��Ƿ���Ҷ�ӣ����ǣ�˵���ҵ���������
            if(index == word.length()-1 && node.children.get(ch).hasWord)
                return true;
            else
            	return search(node.children.get(ch), word, index+1 );//��indexָ��Ĳ������һ���ַ�������������Ҷ�ӣ���������·���������  
        }else if(ch == '.'){
            boolean result = false;
            //��ʼ����·������
            for(Map.Entry<Character, TrieNode> child: node.children.entrySet()){
            	//index��ָ��������һ���ַ�,�����ӽڵ��Ƿ���Ҷ�ӣ����Ǿ���ƥ�����ˣ�������
            	//�����ǣ��������ŵ�ǰ�����������ҵ����Ƿ����棬û����һ������
                if(index == word.length()-1 && child.getValue().hasWord){
                    return true;
                } 
                //��������߼�����ģ��������������'.'���
                // return find(word, index+1, child.getValue());
                //���������ȷ�أ�ֻҪ��Ե�ǰ��child������һ��path���ҵ����Ϳ��Է�������
                //if any path is true, set result to be true; 
                if(search(child.getValue(), word, index+1) ){
                    result = true;
                }
            }
 
            return result;
        }else{
            return false;
        }
    }
    
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public static boolean search(String word) {
        // Write your code here
        return search(root, word, 0);
    }


}
