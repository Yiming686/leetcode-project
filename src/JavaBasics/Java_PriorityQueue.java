package JavaBasics;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import org.junit.Test;

/*
 * An unbounded priority queue based on a priority heap. 
 *  A priority queue does not permit null elements.
 *  A priority queue relying on natural ordering also does not permit insertion of non-comparable objects (doing so may result in ClassCastException).
 * The head of this queue is the least element with respect to the specified ordering. 
 *
 * 
 * Priority Queue 的backing DS 是最小heap,由一个数组来实现(所以是unsorted Array)
 * 
 * 注意:同样是一堆元素,不同的插入顺序,构成的heap是不一样的,但是对PQ的poll和remove是一样的,因为他总是找key最小的
 * 删除一个元素,也就是删除一个最小key的元素, heap 变化如下,四步大法:
 * 1.删除最小元素:删除顶端最小元素
 * 2.横向最小上移:下面横向最小元素,依次向上移动,空出此条线路, 下面最大的位置了
 * 3.末尾平移补空:如果有上面的空位了,但是还是完全二叉树,不用补位了,如果不, 就把完全二叉树的最后一位,补到这个空位上来.
 * 4.补空继续上移:补来以后,不一定就比上面的元素都大,所以此时需要依次上移到合适位置
 * 
 * 感觉是上面这样的。其实如下：  
 * 1.用最后一个元素，替换最小元素，也就好像删除了最小元素，最后元素留出空位
 * 2.从顶端开始downheap， 沿着downward path，开始逐步交换顶端元素，直到他并不比下面的更大为止
 * 3，downheap的路线选择是，看他的左右子元素谁小，谁小就沿着谁走。
 * 
 * 
 * 
 * 
 * 
 * 如果仅仅是array来维护,最左端维持最小,O(1),但是老是要排序,消耗大量时间,所以不可取,采用heap方法来维护
 * 
 * 对Heap来说,仅仅满足,顶端为最小元素,每一个元素都是子树的最小值
 * 
 * 
 */


public class Java_PriorityQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<String> pq = new PriorityQueue<String>(16, Collections.reverseOrder());
		pq.add("banana");// 把数据加入到 队列。
		pq.add("pear");
		pq.add("apple");		
//		System.out.println(pq);
//
//		System.out.println(pq.poll() + " " + pq.peek());

//		PriorityQueue<String> reversed =
//			    new PriorityQueue<String>(, Collections.reverseOrder());
//			reversed.addAll();
		/*
		 * Java的优先队列是一种堆Heap结构。 [-3,0,9,6]反映的是堆的存储顺序，而非排序的顺序
		 *-3 0 9 6 堆是有序的，所以不用排序，当你把其作为队列，依次弹出时，才具有顺序
		 *手册上也写着，可以转换成数组在Arrays.sort排序 Arrays.sort(pq.toArray()). 但我觉得这样非常浪费优先队列已经有序的性能。所以不推荐
		 */
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(3);
		
		pq2.offer(-3);
		pq2.offer(-2);
		pq2.offer(0);
		pq2.offer(4);
		pq2.offer(6);
		pq2.offer(3);
		pq2.offer(3);
		pq2.offer(3);
		pq2.offer(7);
		pq2.offer(8);
		pq2.offer(8);
		pq2.offer(9);
		System.out.println(pq2.size());
		while(pq2.size()>0){
			System.out.print(" "+pq2.poll());
		}
		System.out.println();
//		pq2.offer(10);

//pq2.add(3);
//pq2.offer(3);
		System.out.println(pq2);	
		Integer [] arr = pq2.toArray(new Integer[0]);
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(pq2.size());
		for(Integer i : arr){
			System.out.println(pq2.poll());	
			System.out.println(pq2);
		}
		System.out.println(pq2.size());
		System.out.println(pq2.poll() + " " + pq2.peek());
		System.out.println(pq2);	

		Integer i;
		while ((i = (Integer) pq2.poll()) != null)
			System.out.print(i + " ");
		System.out.println(pq2);	

	}
	
	
	public void method(){
		System.out.print( "  method(){}");

	}

}
