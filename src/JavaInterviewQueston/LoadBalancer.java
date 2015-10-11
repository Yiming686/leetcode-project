package JavaInterviewQueston;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/*
 ���һ�����ݽṹ���Է�����Server��֧�����²�����

����һ��Server��
ɾ��һ��Server��
���ѡ��һ��Server��
�������в�����ʱ�临�Ӷȶ�����ΪO(1)�������γ����ڸ������Գ��ϣ�2012��Google�绰���Եȣ���

����ʹ��һ������͹�ϣ����ʵ����Щ���������������е�Server����ϣ���¼ÿ��Server�������е�λ�ã��±꣩������3�ֲ������㷨���£�

����һ��Server����Server���뵽����β���������¹�ϣ��
ɾ��һ��Server���ӹ�ϣ���л����Ҫɾ����Server�������е��±�index�����ӹ�ϣ����ɾ����Server�����ݡ�Ȼ����������һ��Ԫ�غ�indexλ�õ�Ԫ�ؽ������������鳤�ȼ�1��
���ѡ��һ��Server���������鳤��Ϊn������һ��0��n-1�����������������������Ӧλ�õ�Server��
ע�����һ��Ԫ�ص�����ʱ��Ҫ�Զ����������С������C++��vector��java�е�ArrayList�������Ǿ�̯ʱ�临�Ӷ���ȻΪO(1)��

��Java��ʵ�ֵĴ������£�

���������ʱ�临�Ӷ�ȫ��ΪO(1)�����ƣ��кܶ�������˼·��

ʹ��������Server����ϣ����Server�������ж�Ӧ�Ľ�㣬�����ɾ������ʱ�临�Ӷ�ΪO(1)���������ѡ�������ʱ�临�Ӷ�ΪO(n)��
ʹ��ƽ�����������(Balanced Binary Search Tree)�����Server�����еĽ����Ҫ����һ��size��������Ըý��Ϊ���������Ľ�������ܶ����ⶼ���õ�������ɡ�
���ڼ����ɾ��������ʱ�临�Ӷ�ΪO(logn)���������ѡ����������Ȳ���һ��0��n-1�����index��Ȼ�������в�����������ĵ�index����㣨�൱����BST�в��ҵ�kС��������
����ÿ����㶼��size��������������ʱ�临�Ӷ�Ҳ��O(logn)��
 */
class RandomSet<T> {
	ArrayList<T> list = new ArrayList<T>();
	HashMap<T, Integer> map = new HashMap<T, Integer>();

	// T(1)
	public boolean add(T item) {
		if (map.containsKey(item))
			return false; // already there

		list.add(item);
		map.put(item, list.size() - 1);
		return true;
	}

	// T(1)
	public boolean delete(T item) {
		if (!map.containsKey(item))
			return false; // not there

		if (map.get(item) < list.size() - 1) {
			T last = list.get(list.size() - 1);
			list.set(map.get(item), last);
			map.put(last, map.get(item));
		}
		list.remove(list.size() - 1);
		map.remove(item);
		return true;
	}

	// T(1)
	public T random() {
		if (list.size() == 0)
			return null;
		return list.get(new Random().nextInt(list.size()));
	}
}
class Servers {
	
    private ArrayList<String> serverIdList = new ArrayList<String>();
    private Map<String, Integer> serverIdIndexMap = new HashMap<String, Integer>();

    // ����һ��Server
    public void add(String hostId) {
        serverIdList.add(hostId);
        serverIdIndexMap.put(hostId, serverIdList.size() - 1);
    }

    // ɾ��һ��Server
    public void remove(String hostId) {
        int index = serverIdIndexMap.get(hostId);
        serverIdIndexMap.remove(hostId);
        serverIdList.set(index, serverIdList.get(serverIdList.size() - 1));
        //�������һ��Ԫ���ƶ���indexλ�ã���Ҫ����hash���е��±�
        serverIdIndexMap.put(serverIdList.get(index), index);
        serverIdList.remove(serverIdList.size() - 1);
    }

    // ���ѡ��һ��Server
    public String randomSelect() {
        if (serverIdList.size() == 0) return null;
        Random random = new Random();
        return serverIdList.get(random.nextInt(serverIdList.size()));
    }
}

/*
 * Amazon is a service oriented company. All services need a Load Balancer to
 * distribute load among different servers. The question is to design a data
 * structure for developing a Load Balancer. Load Balancer performs following 3
 * operations.
 * 
 * 1. boolean addServer(String hostId) - If host is already added to Load Balancer
 * return false else add this host and return true. 
 * 2. boolean deleteServer(String name) - If host is not in Load Balancer return false else delete this host
 * and return true. 
 * 3. String getRandomServer() - return a random host from the
 * lists of hosts in Load Balancer.
 * 
 * All the above operations should be performed in constant time. Please assume
 * you have a function Random.random(i) which returns a random number from 0 to
 * i.
 * 
 * 
 * 
 * Please fill in the methods of this class. Add any class members which you
 * would think is necessary to perform these operations
 */
public class LoadBalancer {
    private ArrayList<String> list = new ArrayList<String>();
    private HashMap<String, Integer> map = new HashMap<String, Integer>();
    
	/*
	 * Operation should run in O(1) time
	 */
	boolean addServer(String hostId) {
		if(map.containsKey(hostId)){
			return false;
		}
		list.add(hostId);
		map.put(hostId, list.size()-1);
		return true;
	}

	/*
	 * Operation should run in O(1) time
	  */
	boolean deleteServer(String hostId) {
		if(!map.containsKey(hostId)){
			return false; 
		}
		Integer index = map.get(hostId);
//		String lastHostId = list.get(list.size() -1);
		list.set(index, list.get(list.size() - 1));
		list.remove(list.size() -1);
		map.remove(hostId);
		map.put(hostId, index);
		return true;
	}

	/*
	 * Operation should run in O(1) time
	 */
	String getRandomServer() {
		if(list.size() == 0) return null;
		Integer index = (int)(Math.random()*(list.size()-1));
//		Integer index = Random.random(list.size()-1);
		return list.get(index);
	}
}

// Example Input and Output:
//
// addServer("host1") -> true
// addServer("host2") -> true
// addServer("host3") -> true
// addServer("host2") -> false //since host2 was already added
//
// getRandomServer() -> host2 //random host from host1,host2,host3
// getRandomServer() -> host3 //random host from host1,host2,host3
//
// deleteServer("host1") -> true
// deleteServer("host2") -> true
// deleteServer("host1") -> false //since host1 was already deleted
