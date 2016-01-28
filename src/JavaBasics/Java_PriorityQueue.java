package JavaBasics;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/*
 * An unbounded priority queue based on a priority heap. 
 *  A priority queue does not permit null elements.
 *  A priority queue relying on natural ordering also does not permit insertion of non-comparable objects (doing so may result in ClassCastException).
 * The head of this queue is the least element with respect to the specified ordering. 
 *
 * 
 * Priority Queue ��backing DS ����Сheap,��һ��������ʵ��(������unsorted Array)
 * 
 * ע��:ͬ����һ��Ԫ��,��ͬ�Ĳ���˳��,���ɵ�heap�ǲ�һ����,���Ƕ�PQ��poll��remove��һ����,��Ϊ��������key��С��
 * ɾ��һ��Ԫ��,Ҳ����ɾ��һ����Сkey��Ԫ��, heap �仯����,�Ĳ���:
 * 1.ɾ����СԪ��:ɾ��������СԪ��
 * 2.������С����:���������СԪ��,���������ƶ�,�ճ�������·, ��������λ����
 * 3.ĩβƽ�Ʋ���:���������Ŀ�λ��,���ǻ�����ȫ������,���ò�λ��,�����, �Ͱ���ȫ�����������һλ,���������λ����.
 * 4.���ռ�������:�����Ժ�,��һ���ͱ������Ԫ�ض���,���Դ�ʱ��Ҫ�������Ƶ�����λ��
 * 
 * �о������������ġ���ʵ���£�  
 * 1.�����һ��Ԫ�أ��滻��СԪ�أ�Ҳ�ͺ���ɾ������СԪ�أ����Ԫ��������λ
 * 2.�Ӷ��˿�ʼdownheap�� ����downward path����ʼ�𲽽�������Ԫ�أ�ֱ��������������ĸ���Ϊֹ
 * 3��downheap��·��ѡ���ǣ�������������Ԫ��˭С��˭С������˭�ߡ�
 * 
 * 
 * 
 * 
 * 
 * ���������array��ά��,�����ά����С,O(1),��������Ҫ����,���Ĵ���ʱ��,���Բ���ȡ,����heap������ά��
 * 
 * ��Heap��˵,��������,����Ϊ��СԪ��,ÿһ��Ԫ�ض�����������Сֵ
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
		pq.add("banana");// �����ݼ��뵽 ���С�
		pq.add("pear");
		pq.add("apple");		
//		System.out.println(pq);
//
//		System.out.println(pq.poll() + " " + pq.peek());

//		PriorityQueue<String> reversed =
//			    new PriorityQueue<String>(, Collections.reverseOrder());
//			reversed.addAll();
		/*
		 * Java�����ȶ�����һ�ֶ�Heap�ṹ�� [-3,0,9,6]��ӳ���ǶѵĴ洢˳�򣬶��������˳��
		 *-3 0 9 6 ��������ģ����Բ������򣬵��������Ϊ���У����ε���ʱ���ž���˳��
		 *�ֲ���Ҳд�ţ�����ת����������Arrays.sort���� Arrays.sort(pq.toArray()). ���Ҿ��������ǳ��˷����ȶ����Ѿ���������ܡ����Բ��Ƽ�
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
//		Collections.sort
		System.out.println("size of pq2 is :"+pq2.size());
		System.out.println(pq2);
		System.out.println("Default order:");
		while(pq2.size()>0){
			System.out.print(" "+pq2.poll());
		}
		
		System.out.println();
		PriorityQueue<Integer> pq3 = new PriorityQueue<Integer>(3, new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
			
		});
		
		pq3.offer(-3);
		pq3.offer(-2);
		pq3.offer(0);
		pq3.offer(4);
		pq3.offer(6);
		pq3.offer(3);
		pq3.offer(3);
		pq3.offer(3);
		pq3.offer(7);
		pq3.offer(8);
		pq3.offer(8);
		pq3.offer(9);
		System.out.println("size of pq3 is :"+pq3.size());
//		System.out.println(pq2.size());
		System.out.println("Default order:");
		while(pq3.size()>0){
			System.out.print(" "+pq3.poll());
		}
		System.out.println();

//		pq3.
		
//		pq2.offer(10);

//pq2.add(3);
//pq2.offer(3);
		System.out.println(pq3);	
		Integer [] arr = pq3.toArray(new Integer[0]);
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(pq3.size());
		for(Integer i : arr){
			System.out.println(pq3.poll());	
			System.out.println(pq3);
		}
		System.out.println(pq3.size());
		System.out.println(pq3.poll() + " " + pq3.peek());
		System.out.println(pq3);	

		Integer i;
		while ((i = (Integer) pq3.poll()) != null)
			System.out.print(i + " ");
		System.out.println(pq3);	

	}
	
	
	public void method(){
		System.out.print( "  method(){}");

	}

}
