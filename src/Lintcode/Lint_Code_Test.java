package Lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lint_Code_Test {

	
	public static void main(String[] args) {
		double x = 34.00515;
		int n = -3;
		String s = "ddcaef";
		
		System.out.println(""+s.indexOf('c'));
		// TODO Auto-generated method stub
//		String[] strs = {"123","123"};
//		List<String> list = anagrams(strs);
//		System.out.println(""+list.size());
//		int[] candidates =  {8,7,4,3};
//		int target = 11;
//		System.out.println("result: "+combinationSum(candidates, target));
	}

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     write your code here
    // }
    // public  ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    //     ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (candidates == null) {
            return result;
        }
        //为什么path?它里面存储什么呢？
        ArrayList<Integer> path = new ArrayList<Integer>();
        //sort了，后面才好处理，否则麻烦了
         Arrays.sort(candidates);
        //所有需要的数据，准备完毕！
        helper(candidates, target, path, 0, result);

        return result;
    }

    //小伙，去给我干下面这件事吧
    //从数组caditates里面找出所有的和为target的组合list of path，从0开始
    //一种错误的思维方式是，直接想着怎么去找数据，进入了，又出不来
    //正确地是：如何巧妙递进式减少求解问题的规模，减一或者减半，这才是正解
    static void  helper(int[] candidates, int target, ArrayList<Integer> path, int index,
        ArrayList<List<Integer>> result) {
    	if(path.size() == 0 || path.size() == 1 || path.size() == 2 ||path.size() == 3||path.size() == 4||path.size() == 5) {
    		System.out.println(""+path);
//    		return;	
    	}
    	if(path.size() == 9) {
//    		System.out.println(""+path);
    		return;	
    	}
//        if (target == 0) {
//            result.add(new ArrayList<Integer>(path));
//            return;
//        }
        // if(target < 0) return;

        //因为假定数组全部为正数
        // int prev = -1;
        for (int i = index; i < candidates.length; i++) {
//            if (candidates[i] > target) {
//                break;
//            }
            //对于数组里面的值，如果和前面的一个值相等，跳过
            // if (prev != -1 && prev == candidates[i]) {
            //     continue;
            // }
            //
            path.add(candidates[i]);
            //最大考点：经典问题就是对index参数的理解，到底是i还是i+1
            //如果把i位置的元素，放入了，index变为i+1,那就漏掉了很多想求的解
            //i位置保持不变，和循环变量一样，但是保证不是死循环呢
            //题目要求元素可重复多次，就体现在index取值为i上
            helper(candidates, target - candidates[i], path, i, result);
            path.remove(path.size() - 1);

            // prev = candidates[i];
        }
    }

    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> result = new ArrayList<String>();
        if(strs == null || strs.length == 0) return result;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr); 
            if(!map.containsKey(str)){
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(str, list);
            }else{
                map.get(str).add(str);
            }
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            if(entry.getValue().size() > 1){
                result.addAll(entry.getValue());
            }
        }
        return result;
    }

}
