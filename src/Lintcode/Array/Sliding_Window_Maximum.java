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
思路 
我们用双向队列可以在O(N)时间内解决这题。当我们遇到新的数时，将新的数和双向队列的末尾比较，如果末尾比新数小，则把末尾扔掉，
直到该队列的末尾比新数大或者队列为空的时候才住手。这样，我们可以保证队列里的元素是从头到尾降序的，由于队列里只有窗口内的数，
所以他们其实就是窗口内第一大，第二大，第三大...的数。保持队列里只有窗口内数的方法和上个解法一样，
也是每来一个新的把窗口最左边的扔掉，然后把新的加进去。然而由于我们在加新数的时候，已经把很多没用的数给扔了，
这样队列头部的数并不一定是窗口最左边的数。这里的技巧是，我们队列中存的是那个数在原数组中的下标，这样我们既可以直到这个数的值，
也可以知道该数是不是窗口最左边的数。这里为什么时间复杂度是O(N)呢？因为每个数只可能被操作最多两次，一次是加入队列的时候，
一次是因为有别的更大数在后面，所以被扔掉，或者因为出了窗口而被扔掉。
	 * */

    // new solution, TC is O(N), worked, 8147 ms
    public int[] maxSlidingWindow11(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length + 1 - k];
        for(int i = 0; i < nums.length; i++){
            // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
            if(!deque.isEmpty() && deque.peekFirst() == i - k) deque.poll();
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.removeLast();
            // 加入新数
            deque.offerLast(i);
            // 队列头部就是该窗口内第一大的
            if((i + 1) >= k) res[i + 1 - k] = nums[deque.peek()];
        }
        return res;
    }

    // new solution, TC is O(N), worked, 8147 ms
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return list;
        LinkedList<Integer> deque = new LinkedList<Integer>();
        //队列干好两件事：针对当前值，维护数据进出，维护左端，使得处理完毕后，其值最大
        for(int i = 0; i < nums.length; i++){
            //第一步：处理当前元素，先处理队列，然后加入，也是先处理好队列尾部问题
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) 
                deque.removeLast();
            // 加入新数
            deque.offerLast(nums[i]);
            //第二步：再处理队列的头部问题，
            // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
            if(i >= k && !deque.isEmpty() && deque.peekFirst() == nums[i - k]) 
                deque.poll();
            // 队列头部就是该窗口内第一大的
            if(i >= k - 1) 
                list.add(deque.peek());
        }
        return list;
    }
    
    //难点在最大值的寻找
    //双端队列：
    //jiuzhang solution，TC is O(N), worked
    public static ArrayList<Integer> maxSlidingWindow55(int[] nums, int k) {
        // write your code here
    	ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int i = 0;
        for(int currVal : nums) {
            i++;//表示第第几个元素
            //如果为空，直接加入， 若不空，先从后到前删除小于的元素，等于的不删，删完再加当前元素
            //如果在左边，比当前元素小，存在没有必要了。
            //此队列顶多k个元素
            // if(deque.isEmpty())
    		while((!deque.isEmpty() && currVal > deque.peekLast())) {
    			deque.pollLast();
    		} 
    		deque.offer(currVal);
    		//此后队列是递减的，如果i大于了k，并且第一个最大的是i-k-1个应该删除，因为此时已经无效了
    		if(i > k  && deque.peekFirst() == nums[i - k - 1])
    		         deque.pollFirst();
    		//队列是从大到小的次序，数目不确定，只能peek不能poll因为此最大值后面可能还要用
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
            // 把窗口最左边的数去掉
            if(i >= k) pq.remove(nums[i - k]);
            // 把新的数加入窗口的堆中
            pq.offer(nums[i]);
            // 堆顶就是窗口的最大值
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
