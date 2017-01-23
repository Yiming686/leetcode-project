package JavaBasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

public class Java_Comparator {
	// UserComparator
	
	public static void main(String[] args) {
//		Condition cond = (new AbstractQueuedSynchronizer()).new ConditionObject();
//		AbstractQueuedSynchronizer n = new AbstractQueuedSynchronizer();
//		Condition cond = n.new ConditionObject();
//		try {
//			cond.await();
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		cond.signal();
		
		new SupperA();
		List<User> users = new ArrayList<User>();
		try {
			users.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		users.notify();
		
		users.add(new User(10, "a"));
		users.add(new User(11, "d"));
		users.add(new User(15, "s"));
		users.add(new User(6, "x"));
		users.add(new User(17, "a"));
		users.add(new User(17, "b"));
		users.add(new User(17, "c"));
		users.add(new User(17, "d"));
		UserComparator comparator = new UserComparator();
		Collections.sort(users, comparator);

		for (User u : users) {
			System.out.println(u);
		}
	}
}

 class UserComparator implements Comparator<User> {

//	 ע������int��String�Ƚϴ�С�Ķ���
//	 ͨ������һ�������͵ڶ��������Ƚ�
//	 һ�����Ҫ�õ�������С���������ַ���a��z����
//	 ��������һ������С�ڵڶ������� ����-1�����ڷ���0�����ڷ���1
//	 �ַ�����һ����������CompareTo����������Ϊ�ڶ�������
	public int compare(User u1, User u2) {
		if (u1.equals(u2)) {
			return 0;
		} else if (u1.getAge() < u2.getAge()) {
			return -1;
		} else if (u1.getAge() == u2.getAge()) {
			int f = u1.getName().compareTo(u2.getName());
//			if (f < 0) {
//				return -1;
//			}
//			return 0;
			return f;
		} else {
			return 1;
		}
	}


}

class User {
	private int age;
	private String name;

	public User() {

	}

	public User(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + "]";
	}

}
