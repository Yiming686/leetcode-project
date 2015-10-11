package JavaInterviewQueston;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/*
 设计一个数据结构，对服务器Server类支持以下操作：

加入一个Server。
删除一个Server。
随机选择一个Server。
以上所有操作的时间复杂度都必须为O(1)。此题多次出现于各种面试场合（2012年Google电话面试等）。

可以使用一个数组和哈希表来实现这些操作。数组存放所有的Server，哈希表记录每个Server在数组中的位置（下标）。以上3种操作的算法如下：

加入一个Server：将Server加入到数组尾部，并更新哈希表。
删除一个Server：从哈希表中获得需要删除的Server在数组中的下标index，并从哈希表中删除该Server的数据。然后将数组的最后一个元素和index位置的元素交换，并将数组长度减1。
随机选择一个Server：假设数组长度为n，产生一个0到n-1的随机数，并返回数组中相应位置的Server。
注意加入一个元素到数组时需要自动调整数组大小（比如C++的vector，java中的ArrayList），但是均摊时间复杂度仍然为O(1)。

用Java来实现的代码如下：

如果不考虑时间复杂度全部为O(1)的限制，有很多其它的思路：

使用链表存放Server，哈希表存放Server在链表中对应的结点，加入和删除操作时间复杂度为O(1)，但是随机选择操作的时间复杂度为O(n)。
使用平衡二叉搜索树(Balanced Binary Search Tree)来存放Server，树中的结点需要加入一个size域来存放以该结点为根的子树的结点数（很多问题都会用到这个技巧。
对于加入和删除操作，时间复杂度为O(logn)。对于随机选择操作，首先产生一个0到n-1的序号index，然后在树中查找中序遍历的第index个结点（相当于在BST中查找第k小的数），
由于每个结点都有size域，因此这个操作的时间复杂度也是O(logn)。
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

    // 加入一个Server
    public void add(String hostId) {
        serverIdList.add(hostId);
        serverIdIndexMap.put(hostId, serverIdList.size() - 1);
    }

    // 删除一个Server
    public void remove(String hostId) {
        int index = serverIdIndexMap.get(hostId);
        serverIdIndexMap.remove(hostId);
        serverIdList.set(index, serverIdList.get(serverIdList.size() - 1));
        //由于最后一个元素移动到index位置，需要更新hash表中的下表
        serverIdIndexMap.put(serverIdList.get(index), index);
        serverIdList.remove(serverIdList.size() - 1);
    }

    // 随机选择一个Server
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
