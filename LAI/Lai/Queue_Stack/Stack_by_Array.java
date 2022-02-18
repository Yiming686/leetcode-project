package Lai.Queue_Stack;

public class Stack_by_Array {
	//head��tail��ʲôʱ���ã�ֻҪ��Ԫ�أ�headһ��ָ���һ����tailָ�����һ����Ϊ��(û��Ԫ��)����ֻ��һ��Ԫ��ʱ��������ȵģ���Ϊnull��
	//����headΪnullʱ��tailҲΪnull����֮��Ȼ���κ�һ��Ϊnull��������Ϊ�գ�
	//�����ķ��������������
	private Integer[] arr = new Integer[16];
	private int head;//point to first element; ���ָ���push����λ��
//	private int size; size == head+1
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack_by_Array q = new Stack_by_Array();
		System.out.println(""+q);
		q.peek();
		q.pop();
		q.push(5);
		q.pop();
		q.push(2);
		q.push(4);
		q.push(8);
		q.pop();
		q.pop();
		q.pop();
		q.pop();
	}
	
	public void push(Integer val) {
		//ensure capacity��ȷ�� head+2 �ܷŵ���
		arr[head] = val;
		head++;
//		�˴�ȷ��ensure capacity����Ҫʱ����resize
		return ;
	}
	
	public Integer pop() {
		if(head == 0) {//ȫ�����
			return null;
		}
		Integer val = arr[head-1];
		head--;
		return val;
	}
	
	public Integer peek() {
		if(head == 0) {
			return null;
		}
		return arr[head-1];
	}
	
	

}
