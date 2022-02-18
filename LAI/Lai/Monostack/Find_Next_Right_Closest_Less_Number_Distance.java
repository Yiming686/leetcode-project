package Lai.Monostack;

import static Utils.ArrayUtils.print;
import static Utils.ArrayUtils.printf;
import static Utils.ArrayUtils.toStr;

import java.util.Deque;
import java.util.LinkedList;

import Utils.ArrayUtils;
import Utils.StringUtils;

public class Find_Next_Right_Closest_Less_Number_Distance {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Deque<Integer> monoStack = new LinkedList<>();
//		monoStack.offer(1);
//		monoStack.offer(9);
//		monoStack.offer(2);
//		monoStack.offer(3);
//		monoStack.offer(0);
//		monoStack.offer(6);
//		monoStack.offer(5);
//		monoStack.offer(4);
//		monoStack.offer(7);
//		monoStack.offer(1);
//		System.out.println(""+toStr(monoStack));;

//		int[] arr = { 5, 3, 1, 2, 4 };
//		int[] arr = ArrayUtils.generateIntArrayNoDup(6, 0,20);
//		int[] arr = ArrayUtils.generateIntArrayWithDup(6, 0,20);
		int[] arr = { 3,  3,  7, 19, 16, 13 };
		print(arr);
		System.out.println("" + toStr(findNextRighCloestLessDis(arr)));
	}

	
//	�����Ҳֻࣺ��һ��������Сֵ������Stack�� ֻ��һ��ı��Լ�С�����ֵĸ������߱��Լ�������ֵĸ�������segment tree����merge sort
//	�Ҳ��һ���������Ԫ�غ��Լ��ľ���: ֻ��index���Ҵ�
//	����һ���������Ԫ�غ��Լ��ľ���
//	�Ҳ��һ���������Ԫ�غ��Լ��ľ��� <==> �Ƶ�����stack�洢�������У������������У� �������У���Сջ��С�ˣ��ͱ�pop��ȥ�� 
//	���δ洢�����ֵ�����Ǹ�С��ֵ��ջ��Ϊ�����ջ���ߵ�������ջ�����δ洢��С��ֵ����Ϊ��Сջ���ߵ����ݼ�ջ��һ����Ŀʹ��ʲôջ����ʲô�������أ�
//	ջ�Ĳ����������ɾ��������Heap������ɾ����ʱ������Сֵ����Ҫ�ˣ��������ֵ����Ҫ���أ�
//	ֻ������һ��С���� ���ǣ�
	
//	ֻҪ�ı䣺 < Ϊ >, ���Ϊ ����Ҳ��һ��С���Լ���ֵ���Լ��ľ��롣==> while (!monoStack.isEmpty() && arr[monoStack.peekFirst()] > arr[i]) {

//	Linear Scan ��ͷ��N������ʲô��������ֵ��Ҳ��λ�ã���������ʱ���������
	
//	�������飺��ÿһ��Ԫ�أ� �������඼������ģ���ô�������඼������ͼѰ�ң�
//	A: �������⣺���ڵ��ڻ���С�ڵ����Լ���Ԫ�صĸ�����
//	B: �������⣺�����Լ�����Ĵ����Լ�Ԫ�صľ��룬�����Լ������С���Լ�Ԫ�صľ���
//	B: �������⣺�����Լ���Զ�Ĵ����Լ�Ԫ�صľ���
	
//	���������Ҳ������С���Լ���Ԫ�صľ���
//	findNextRighCloestLessDis
//	Next: �ɸ��¹��������res����
//	Right:
//	Closest:
//	Distance:
	public static int[] findNextRighCloestLessDis(int[] arr) {
		int[] res = new int[arr.length];
		Deque<Integer> monoStack = new LinkedList<>();//��Сջ���Ӵ�С����
		for (int i = 0; i < arr.length; i++) {
			res[i] = -1;//���λ�õĳ�ʼֵ����ʾû���Ҳ��һ���������Ԫ��
			while (!monoStack.isEmpty() && arr[monoStack.peekFirst()] > arr[i]) {
				////ջ����Ĵ����index, ������array value;
//				res[monoStack.peekFirst()] = i - monoStack.peekFirst();
				res[monoStack.peekFirst()] = i;
				monoStack.pollFirst();
			}
			monoStack.offerFirst(i);//һ���÷Ž�ȥ����Ҫ������������Ƚ�
			printf("stack:res: %20s:%-20s ", StringUtils.toStr(monoStack), toStr(res));
		}
		print(toStr(res, true));
		return res;
	}


}
