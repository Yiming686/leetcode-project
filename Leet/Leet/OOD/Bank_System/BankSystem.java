package Leet.OOD.Bank_System;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import Utils.SU;

/**
 * 
 * 我们以一道亚麻经典题目为例，看看亚麻的OOD有多难！
 * 
 * 设计一个银行账户管理系统，实现以下三个函数： 1.void deposite(int id,int amount,long timestamp)
 * 2.boolean withdraw(int id,int amount,long timestamp) 3.int[] check(int
 * id,long startTime,long endTime) id ：用户账号ID amoun : 用户存取钱的数目 timestamp
 * ：用户存取钱的日期 startTime : 该日期时账号ID的余额 endTime ：该日期账号ID 的余额
 这道题是面向对象设计中比较难又比较有代表性的一道题了，难度为medium，也是去年秋招Amazon考过的，备战Amazon的同学请重点关注一下。

OOD做为面试当中的万精油题型，在很多职位的面试当中都有可能出现，尤其对于应届毕业生和经验不多的engineer来说，
由于没有在工作中接触大规模/流量的系统，面试官通常会倾向于通过OOD来考察你的设计能力。

Design OO food delivery appcatering.

Design Amazon recommendationsfeature.

Design an OO parking lot.

Design a class to implementchess and checkers game individually.

Create a restful micro servicethat implements a card shuffling algorithm.

Design Uber low level OOdesign.

Design the classes for aBattleship game.

Design a client-serverapplication which allows people to play chess and checkers with one another.

What’s difference betweenJavascript and JAVA in terms of OOP principles.

Design a Binary search treeusing Epic as input

看一下singleton 和 factory design pattern
了解override 和 overlording
注意fields和 method 的命名
特别注意Clarify the ambiguity，避免over design

在设计中，如果有需求，最好能考虑到enum、static、final 这些关键词。具体到实现，要考虑reusable，
切忌为了代码的简洁丧失可读性和maintainability。

虽然OOD面向对象需要有一定的经验，但是其实OOD面试是有套路可寻的。因为设计的思路是大概相似的：分析每一个类的外部方法和内部状态是什么，
什么样的方法可以抽象成通用的接口，什么样的类之间存在继承关系等。

除了实战练习外，可以看些OOD相关的教学视频或者书。想在面试中快速脱颖而出，你需要进行更加深入系统的学习，九章算法的

《面向对象设计》

由经验丰富的面试官梳理所有OOD面试题目，进行归类汇总，同时提供解题套路，是你备战OOD面试的必听课程。

由经验丰富的面试官梳理所有OOD面试题目，进行归类汇总，同时提供解题套路，是你备战OOD面试的必听课程。

讲什么


以面试求职为导向，全面讲解设计模式，包括，Strategy, Singleton, Factory, Adaptor, etc。
整理深度剖析所有IT技术面试中的高频OOD面试题，包括，停车场设计、酒店预定系统设计、Black Jack 棋牌设计等等。

适合谁


应届毕业生，有1-3年工作经验的工程师
准备求职Facebook, LinkedIn, Google, Amazon等IT企业的工程师
希望学习OOD面向对象设计的同学

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
