package Leet.OOD.Bank_System;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import Utils.SU;

/**
 * 
 * ������һ�����龭����ĿΪ�������������OOD�ж��ѣ�
 * 
 * ���һ�������˻�����ϵͳ��ʵ���������������� 1.void deposite(int id,int amount,long timestamp)
 * 2.boolean withdraw(int id,int amount,long timestamp) 3.int[] check(int
 * id,long startTime,long endTime) id ���û��˺�ID amoun : �û���ȡǮ����Ŀ timestamp
 * ���û���ȡǮ������ startTime : ������ʱ�˺�ID����� endTime ���������˺�ID �����
 ������������������бȽ����ֱȽ��д����Ե�һ�����ˣ��Ѷ�Ϊmedium��Ҳ��ȥ������Amazon�����ģ���սAmazon��ͬѧ���ص��עһ�¡�

OOD��Ϊ���Ե��е��������ͣ��ںܶ�ְλ�����Ե��ж��п��ܳ��֣��������Ӧ���ҵ���;��鲻���engineer��˵��
����û���ڹ����нӴ����ģ/������ϵͳ�����Թ�ͨ����������ͨ��OOD������������������

Design OO food delivery appcatering.

Design Amazon recommendationsfeature.

Design an OO parking lot.

Design a class to implementchess and checkers game individually.

Create a restful micro servicethat implements a card shuffling algorithm.

Design Uber low level OOdesign.

Design the classes for aBattleship game.

Design a client-serverapplication which allows people to play chess and checkers with one another.

What��s difference betweenJavascript and JAVA in terms of OOP principles.

Design a Binary search treeusing Epic as input

��һ��singleton �� factory design pattern
�˽�override �� overlording
ע��fields�� method ������
�ر�ע��Clarify the ambiguity������over design

������У��������������ܿ��ǵ�enum��static��final ��Щ�ؼ��ʡ����嵽ʵ�֣�Ҫ����reusable��
�м�Ϊ�˴���ļ��ɥʧ�ɶ��Ժ�maintainability��

��ȻOOD���������Ҫ��һ���ľ��飬������ʵOOD����������·��Ѱ�ġ���Ϊ��Ƶ�˼·�Ǵ�����Ƶģ�����ÿһ������ⲿ�������ڲ�״̬��ʲô��
ʲô���ķ������Գ����ͨ�õĽӿڣ�ʲô������֮����ڼ̳й�ϵ�ȡ�

����ʵս��ϰ�⣬���Կ�ЩOOD��صĽ�ѧ��Ƶ�����顣���������п�����ӱ����������Ҫ���и�������ϵͳ��ѧϰ�������㷨��

�����������ơ�

�ɾ���ḻ�����Թ���������OOD������Ŀ�����й�����ܣ�ͬʱ�ṩ������·�����㱸սOOD���Եı����γ̡�

�ɾ���ḻ�����Թ���������OOD������Ŀ�����й�����ܣ�ͬʱ�ṩ������·�����㱸սOOD���Եı����γ̡�

��ʲô


��������ְΪ����ȫ�潲�����ģʽ��������Strategy, Singleton, Factory, Adaptor, etc��
���������������IT���������еĸ�ƵOOD�����⣬������ͣ������ơ��Ƶ�Ԥ��ϵͳ��ơ�Black Jack ������Ƶȵȡ�

�ʺ�˭


Ӧ���ҵ������1-3�깤������Ĺ���ʦ
׼����ְFacebook, LinkedIn, Google, Amazon��IT��ҵ�Ĺ���ʦ
ϣ��ѧϰOOD���������Ƶ�ͬѧ

 *
 * 
 */
public class BankSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.ll("589. N-ary Tree Preorder Traversal\n" + 
				"");
	}

	Map<Integer, Integer> accountBalance; // id -> balance
	Map<Integer, Map<Long, Integer>> accountStatement; // id -> timestamp -> balance

	public BankSystem() {
		this.accountBalance = new HashMap<>();
		this.accountStatement = new HashMap<>();
	}

	public void deposite(int id, int amount, long timestamp) {
		if (!accountBalance.containsKey(id)) {
			accountBalance.put(id, 0);
			accountStatement.put(id, new HashMap<>());
		}
		accountBalance.put(id, accountBalance.get(id) + amount);
		accountStatement.get(id).put(timestamp, accountBalance.get(id));
	}

	public boolean withdraw(int id, int amount, long timestamp) {
		if (!accountBalance.containsKey(id) || accountBalance.get(id) < amount) {
			return false;
		}

		accountBalance.put(id, accountBalance.get(id) - amount);
		accountStatement.get(id).put(timestamp, accountBalance.get(id));
		return true;
	}

	public int[] check(int id, long startTime, long endTime) {
		if (!accountBalance.containsKey(id)) {
			return new int[0];
		}

		int[] res = new int[2];
		Map<Long, Integer> statement = accountStatement.get(id);
		List<Long> timestamps = new ArrayList<>(statement.keySet());
		Collections.sort(timestamps);

		if (statement.containsKey(startTime)) {
			res[0] = statement.get(startTime);
		} else {
			int index = -(Collections.binarySearch(timestamps, startTime) + 1);
			res[0] = index == 0 ? 0 : statement.get(timestamps.get(index - 1));
		}
		if (statement.containsKey(endTime)) {
			res[1] = statement.get(endTime);
		} else {
			int index = -(Collections.binarySearch(timestamps, endTime) + 1);
			res[1] = index == 0 ? 0 : statement.get(timestamps.get(index - 1));
		}

		return res;
	}
}
