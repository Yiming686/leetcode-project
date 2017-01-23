package Lintcode;

import java.util.HashMap;


/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，BAT国内班
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

public class LRU_Cache {
    private class Node<K,V>{
        Node<K, V> prev;
        Node<K, V> next;
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }


    private int capacity;
    private HashMap<Integer, Node<Integer, Integer>> hs = new HashMap<>();
    private Node<Integer, Integer> head = new Node<>(-1, -1);
    private Node<Integer, Integer> tail = new Node<>(-1, -1);
//    private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
//    private Node head = new Node(-1, -1);
//    private Node tail = new Node(-1, -1);

    public LRU_Cache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if( !hs.containsKey(key)) {
            return -1;
        }

        // remove current
        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current to tail
        move_to_tail(current);

        return hs.get(key).value;
    }

    public void set(int key, int value) {
        if( get(key) != -1) {
            hs.get(key).value = value;
            return;
        }

        if (hs.size() == capacity) {
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key, value);
        hs.put(key, insert);
        move_to_tail(insert);
    }

    private void move_to_tail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
    private void move_to_tail2(Node current) {
    	tail.prev.next = current;
        current.prev = tail.prev;
        current.next = tail;
        tail.prev = current;
    }
    
    
    
    
    
    
}