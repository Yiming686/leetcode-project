package Lintcode;

import java.nio.charset.StandardCharsets;
import java.util.Stack;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

/**
Mock Hanoi Tower by Stacks

 Description
 Notes
 Testcase
 Judge
In the classic problem of Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following constraints:

Only one disk can be moved at a time.
A disk is slid off the top of one tower onto the next tower.
A disk can only be placed on the top of a larger disk.
Write a program to move the disks from the first tower to the last using stacks.

Have you met this question in a real interview? Yes
Example
Tags 
Stack


 *
 */
public class Mock_Hanoi_Tower_by_Stacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tower source = new Tower(1);
		Tower buffer = new Tower(1);
		Tower dest = new Tower(1);
		
		Stack<Integer> sourceStack = source.getDisks();
		Stack<Integer> destStack = dest.getDisks();
		sourceStack.add(10);
		sourceStack.add(9);
		sourceStack.add(8);
		sourceStack.add(7);
		destStack.add(3);
		destStack.add(2);
		destStack.add(1);
		System.out.println(""+source);
		System.out.println(""+buffer);
		System.out.println(""+dest);

		sourceStack.add(10);
		sourceStack.add(9);
		sourceStack.add(8);
		sourceStack.add(7);
		destStack.add(3);
		destStack.add(2);
		destStack.add(1);
		
		source.moveDisks(1, dest, buffer);
		
		System.out.println(""+source);
		System.out.println(""+buffer);
		System.out.println(""+dest);

	}
	
	public static class Tower {
		
	    @Override
		public String toString() {
	    	String s ="";
	    	while(!disks.isEmpty()){
	    		s+=disks.pop() + ", ";
	    	}
			return "Tower [disks=" + s + "]";
		}

		private Stack<Integer> disks;
	    // create three towers (i from 0 to 2)
	    public Tower(int i) {
	        disks = new Stack<Integer>();
	    }
		
	    // Add a disk into this tower
	    public void add(int d) {
	        if (!disks.isEmpty() && disks.peek() <= d) {
	            System.out.println("Error placing disk " + d);
	        } else {
	            disks.push(d);
	        }
	    }
		
	    // @param t a tower
	    // Move the top disk of this tower to the top of t.
	    public void moveTopTo(Tower t) {
	        // Write your code here
	        if(t == null) return;
	        t.add(disks.pop());
	    }
		
	    // @param n an integer
	    // @param destination a tower
	    // @param buffer a tower
	    // Move n Disks from this tower to destination by buffer tower
	    public void moveDisks(int n, Tower destination, Tower buffer) {
	        // Write your code here
	        // 如果pop()一个，如果能放在dest上，就放， 如果不能放，就放buffer上.总之二选一，肯定可以将pop()出来的放置好。然后pop
	        if(n <= 0) return;
	        moveDisks(n - 1, buffer, destination);
	        moveTopTo(destination);
	        buffer.moveDisks(n - 1, destination, this);

	        // Stack<Integer> disks2 = buffer.getDisks();
	        // Stack<Integer> disks3 = dest.getDisks();
	        // while(--n >= 0){
	        //     Integer val = disks.pop();
	        //     while(!disks3.isEmpty() && val <= disks3.peek()){
	        //       moveTopTo(buffer);
	               
	        //     }
	        //     dest.add(val);
	        // }
	        // return;
	    }

	    public Stack<Integer> getDisks() {
	        return disks;
	    }
	}

}
