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
 * the celebrity‘s label if there is a celebrity in the party. If there is no
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
//	题目综述n个人，每个人和其他n-1个人有两个连接，总共有n(n-1)个连接，全部检测复杂度为 O(N^2)。
//	其实不必，根据题意，下面第一个循环只需要检测(n-1)的即可锁定怀疑目标，但是不能确定
//	下面根据题意，遍历所有人，全面检测所有连接，即可知锁定目标是不是，是返回label不是返回-1，
//	第二个循环需要检测(n-1)*2个连接，此算法总共需要检测 (n-1)*3 次， 复杂度变为 O(N).
//	终极漂亮的解决方案
//	注意: 一个是++， 一个是--，left++， right--.

//	本质：图的问题， 双向图
//	问题：找出图中唯一一个特殊的点
//	方法：唯一最快的方法就是立即针对这个特殊点的特殊之处，迅速找到它。
//	celebrity：1.(n-1)person knows him, must be (n-1), not (n-2) or (n-3) ...，（特点：拥有最大范围的知名度）  
//	           2. he knows nobody.（特点：富有极其高傲的姿态）
//	confusing case: 1. 别人都认识他，他也认识所有的人，和群众打成一片的人， 结论：此人拥有‘最大范围’的知名度， 但是‘没有一点高傲’的姿态，不是celebrity
//	                2. 别人都认识他，他也认识一些人但是认识不全所有人，结论：此人拥有‘最大范围’的知名度， 但是‘姿态高傲程度不够’，不是celebrity
//                  3. 别人都认识他，他一个也不认识，结论：此人拥有‘最大范围’的知名度， 但是姿态‘极其高傲’，肯定是唯一的一个celebrity
//                  4. 不是所有人都认识他，但他却认识所有的人， 结论：此人知名度不高， 但是没有一点高傲的姿态，不是celebrity
//                  5. 不是所有人都认识他，他也认识一些人但是认识不全所有人，结论：此人知名度不高， 但是姿态不高，不是celebrity
//                  6. 不是所有人都认识他，他一个也不认识，结论：此人拥有‘一定范围’的知名度， 但是姿态‘极其高傲’，所以不是一个celebrity
//	                7. 所有人都不认识他，他也不认识任何人， 结论：孤立点的人，图上的孤立点
	

//	 Celebrity和普通人的本质区别：普通人都认识celebrity，可能认识比人也能被别人认识；celebrity一个人也不认识

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
//		now left == right，如果有就是这个，但是要用规则严格验证
		for (int i = 0; i < len; i++) {
//			当i不等于left时，i不认识left 或者 left认识i，一定不存在，返回-1
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
