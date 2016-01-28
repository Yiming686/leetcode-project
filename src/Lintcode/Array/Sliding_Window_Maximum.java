package Lintcode.Array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**

Sliding Window Maximum Show result 

Given an array of n integer with duplicate number, and a moving window(size k), move the window at each iteration from the start of the array, find the maximum number inside the window at each moving.

Have you met this question in a real interview? Yes
Example
For array [1, 2, 7, 7, 8], moving window size k = 3. return [7, 7, 8]

At first the window is at the start of the array like this

[|1, 2, 7| ,7, 8] , return the maximum 7;

then the window move one step forward.

[1, |2, 7 ,7|, 8], return the maximum 7;

then the window move one step forward again.

[1, 2, |7, 7, 8|], return the maximum 8;

Challenge
o(n) time and O(k) memory

Tags Expand 
LintCode Copyright Deque Zenefits


Related Problems Expand 


 *
 *
 */
public class Sliding_Window_Maximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
˼· 
������˫����п�����O(N)ʱ���ڽ�����⡣�����������µ���ʱ�����µ�����˫����е�ĩβ�Ƚϣ����ĩβ������С�����ĩβ�ӵ���
ֱ���ö��е�ĩβ����������߶���Ϊ�յ�ʱ���ס�֡����������ǿ��Ա�֤�������Ԫ���Ǵ�ͷ��β����ģ����ڶ�����ֻ�д����ڵ�����
����������ʵ���Ǵ����ڵ�һ�󣬵ڶ��󣬵�����...���������ֶ�����ֻ�д��������ķ������ϸ��ⷨһ����
Ҳ��ÿ��һ���µİѴ�������ߵ��ӵ���Ȼ����µļӽ�ȥ��Ȼ�����������ڼ�������ʱ���Ѿ��Ѻܶ�û�õ��������ˣ�
��������ͷ����������һ���Ǵ�������ߵ���������ļ����ǣ����Ƕ����д�����Ǹ�����ԭ�����е��±꣬�������Ǽȿ���ֱ���������ֵ��
Ҳ����֪�������ǲ��Ǵ�������ߵ���������Ϊʲôʱ�临�Ӷ���O(N)�أ���Ϊÿ����ֻ���ܱ�����������Σ�һ���Ǽ�����е�ʱ��
һ������Ϊ�б�ĸ������ں��棬���Ա��ӵ���������Ϊ���˴��ڶ����ӵ���
	 * */

    // new solution, TC is O(N), worked, 8147 ms
    public int[] maxSlidingWindow11(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length + 1 - k];
        for(int i = 0; i < nums.length; i++){
            // ÿ����������ʱ��������ֶ���ͷ���������±꣬�Ǵ�������������±꣬���ӵ�
            if(!deque.isEmpty() && deque.peekFirst() == i - k) deque.poll();
            // �Ѷ���β�����б�����С�Ķ��ӵ�����֤�����ǽ����
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.removeLast();
            // ��������
            deque.offerLast(i);
            // ����ͷ�����Ǹô����ڵ�һ���
            if((i + 1) >= k) res[i + 1 - k] = nums[deque.peek()];
        }
        return res;
    }

    // new solution, TC is O(N), worked, 8147 ms
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return list;
        LinkedList<Integer> deque = new LinkedList<Integer>();
        //���иɺ������£���Ե�ǰֵ��ά�����ݽ�����ά����ˣ�ʹ�ô�����Ϻ���ֵ���
        for(int i = 0; i < nums.length; i++){
            //��һ��������ǰԪ�أ��ȴ�����У�Ȼ����룬Ҳ���ȴ���ö���β������
            // �Ѷ���β�����б�����С�Ķ��ӵ�����֤�����ǽ����
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) 
                deque.removeLast();
            // ��������
            deque.offerLast(nums[i]);
            //�ڶ������ٴ�����е�ͷ�����⣬
            // ÿ����������ʱ��������ֶ���ͷ���������±꣬�Ǵ�������������±꣬���ӵ�
            if(i >= k && !deque.isEmpty() && deque.peekFirst() == nums[i - k]) 
                deque.poll();
            // ����ͷ�����Ǹô����ڵ�һ���
            if(i >= k - 1) 
                list.add(deque.peek());
        }
        return list;
    }
    
    //�ѵ������ֵ��Ѱ��
    //˫�˶��У�
    //jiuzhang solution��TC is O(N), worked
    public static ArrayList<Integer> maxSlidingWindow55(int[] nums, int k) {
        // write your code here
    	ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int i = 0;
        for(int currVal : nums) {
            i++;//��ʾ�ڵڼ���Ԫ��
            //���Ϊ�գ�ֱ�Ӽ��룬 �����գ��ȴӺ�ǰɾ��С�ڵ�Ԫ�أ����ڵĲ�ɾ��ɾ���ټӵ�ǰԪ��
            //�������ߣ��ȵ�ǰԪ��С������û�б�Ҫ�ˡ�
            //�˶��ж���k��Ԫ��
            // if(deque.isEmpty())
    		while((!deque.isEmpty() && currVal > deque.peekLast())) {
    			deque.pollLast();
    		} 
    		deque.offer(currVal);
    		//�˺�����ǵݼ��ģ����i������k�����ҵ�һ��������i-k-1��Ӧ��ɾ������Ϊ��ʱ�Ѿ���Ч��
    		if(i > k  && deque.peekFirst() == nums[i - k - 1])
    		         deque.pollFirst();
    		//�����ǴӴ�С�Ĵ�����Ŀ��ȷ����ֻ��peek����poll��Ϊ�����ֵ������ܻ�Ҫ��
    		if(i >= k) {
    			list.add(deque.peekFirst());
    		}
        }
        return list;
    }
    
    //Total Runtime: 10613 ms, Time Limit Exceeded
    public int[] maxSlidingWindow66(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        int[] res = new int[nums.length + 1 - k];
        for(int i = 0; i < nums.length; i++){
            // �Ѵ�������ߵ���ȥ��
            if(i >= k) pq.remove(nums[i - k]);
            // ���µ������봰�ڵĶ���
            pq.offer(nums[i]);
            // �Ѷ����Ǵ��ڵ����ֵ
            if(i + 1 >= k) res[i + 1 - k] = pq.peek();
        }
        return res;
    }
    
    //my solution, worked, Time Limit Exceeded
    public ArrayList<Integer> maxSlidingWindow77(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return list;

        PriorityQueue<Integer> queue  = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        // PriorityQueue<Integer> queue  = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
        //     @Override
        //     public int compare(Integer i1, Integer i2){
        //         return i2 - i1;
        //     }
        // });
        for(int i = 0; i<nums.length; i++){
            if( i >= k) 
                queue.remove(nums[i-k]);
            queue.offer(nums[i]);   
            if(i >= k-1) 
                list.add(queue.peek());    
        }
        return list;
    }
	
}
