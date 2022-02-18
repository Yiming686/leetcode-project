package LeetCode.JavaArray;

import java.util.Arrays;

/**
 * Find the Celebrity
 * 
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among
 * them, there may exist one celebrity. The definition of a celebrity is that
 * all the other n - 1people know him/her but he/she does not know any of them.
 * 
 * Now you want to find out who the celebrity is or verify that there is not
 * one. The only thing you are allowed to do is to ask questions like: "Hi, A.
 * Do you know B?" to get information of whether A knows B. You need to find out
 * the celebrity (or verify there is not one) by asking as few questions as
 * possible (in the asymptotic sense).
 * 
 * You are given a helper function bool knows(a, b) which tells you whether A
 * knows B. Implement a function int findCelebrity(n), your function should
 * minimize the number of calls to knows.
 * 
 * Note: There will be exactly one celebrity if he/she is in the party. Return
 * the celebrity��s label if there is a celebrity in the party. If there is no
 * celebrity, return -1.
 *
 * 
 */
public class LC_277_Find_the_Celebrity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 10;
		Person[] persons = new Person[num];
		for (int i = 0; i < num; i++) {
			persons[i] = new Person(i, false);
		}
		System.out.println("All False: " + findCelebrity(persons));
		for (int i = 0; i < num; i++) {
			persons[i].isCelebrirty = true;
//			System.out.println("Only "+i+" is True :" + findCelebrity(persons));
			persons[i].isCelebrirty = false;
		}
		System.out.println("" + printPersons(persons));

		int index = 7;
		persons[index].isCelebrirty = true;
		System.out.println("" + printPersons(persons));
		System.out.println("Only " + index + " is True :" + findCelebrity(persons));
		persons[index].isCelebrirty = false;

	}
//	��Ŀ����n���ˣ�ÿ���˺�����n-1�������������ӣ��ܹ���n(n-1)�����ӣ�ȫ����⸴�Ӷ�Ϊ O(N^2)��
//	��ʵ���أ��������⣬�����һ��ѭ��ֻ��Ҫ���(n-1)�ļ�����������Ŀ�꣬���ǲ���ȷ��
//	����������⣬���������ˣ�ȫ�����������ӣ�����֪����Ŀ���ǲ��ǣ��Ƿ���label���Ƿ���-1��
//	�ڶ���ѭ����Ҫ���(n-1)*2�����ӣ����㷨�ܹ���Ҫ��� (n-1)*3 �Σ� ���Ӷȱ�Ϊ O(N).
//	�ռ�Ư���Ľ������
//	ע��: һ����++�� һ����--��left++�� right--.

//	���ʣ�ͼ�����⣬ ˫��ͼ
//	���⣺�ҳ�ͼ��Ψһһ������ĵ�
//	������Ψһ���ķ���������������������������֮����Ѹ���ҵ�����
//	celebrity��1.(n-1)person knows him, must be (n-1), not (n-2) or (n-3) ...�����ص㣺ӵ�����Χ��֪���ȣ�  
//	           2. he knows nobody.���ص㣺���м���߰�����̬��
//	confusing case: 1. ���˶���ʶ������Ҳ��ʶ���е��ˣ���Ⱥ�ڴ��һƬ���ˣ� ���ۣ�����ӵ�С����Χ����֪���ȣ� ���ǡ�û��һ��߰�������̬������celebrity
//	                2. ���˶���ʶ������Ҳ��ʶһЩ�˵�����ʶ��ȫ�����ˣ����ۣ�����ӵ�С����Χ����֪���ȣ� ���ǡ���̬�߰��̶Ȳ�����������celebrity
//                  3. ���˶���ʶ������һ��Ҳ����ʶ�����ۣ�����ӵ�С����Χ����֪���ȣ� ������̬������߰������϶���Ψһ��һ��celebrity
//                  4. ���������˶���ʶ��������ȴ��ʶ���е��ˣ� ���ۣ�����֪���Ȳ��ߣ� ����û��һ��߰�����̬������celebrity
//                  5. ���������˶���ʶ������Ҳ��ʶһЩ�˵�����ʶ��ȫ�����ˣ����ۣ�����֪���Ȳ��ߣ� ������̬���ߣ�����celebrity
//                  6. ���������˶���ʶ������һ��Ҳ����ʶ�����ۣ�����ӵ�С�һ����Χ����֪���ȣ� ������̬������߰��������Բ���һ��celebrity
//	                7. �����˶�����ʶ������Ҳ����ʶ�κ��ˣ� ���ۣ���������ˣ�ͼ�ϵĹ�����
	

//	 Celebrity����ͨ�˵ı���������ͨ�˶���ʶcelebrity��������ʶ����Ҳ�ܱ�������ʶ��celebrityһ����Ҳ����ʶ

	public static int findCelebrity(Person[] persons) {
		if (persons == null || persons.length == 0)
			return -1;
		int len = persons.length;
		int left = 0;
		int right = len - 1;
		while (left < right) {
			if (Person.knows(persons[left], persons[right])) {
				left++;
			} else {
				right--;
			}
		}
//		now left == right������о������������Ҫ�ù����ϸ���֤
		for (int i = 0; i < len; i++) {
//			��i������leftʱ��i����ʶleft ���� left��ʶi��һ�������ڣ�����-1
			if (i != left && (!Person.knows(persons[i], persons[left]) || Person.knows(persons[left], persons[i]))) {
				return -1;
			}
		}
		return left;
	}

	static String printPersons(Person[] persons) {
		if (persons == null || persons.length == 0)
			return "";
		String result = "";
		for (int i = 0; i < persons.length; i++) {
			result += persons[i];
		}
		return result;
	}

	static class Person {
		int label;
		boolean isCelebrirty;

		public Person(int label, boolean isCelebrity) {
//			 TODO Auto-generated constructor stub
			this.label = label;
			this.isCelebrirty = isCelebrity;
		}

		@Override
		public String toString() {
			return String.format("[%s_%-5s] ", label, isCelebrirty);
		}

		static boolean knows(Person p1, Person p2) {
//			if (p1.isCelebrirty && !p2.isCelebrirty)
//				return false;
////			if(!p1.isCelebrirty && !p2.isCelebrirty) return true;
////			if(!p1.isCelebrirty && p2.isCelebrirty) return true;
			return true;
		}
	}

}
