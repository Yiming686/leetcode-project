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
        //Ϊʲôpath?������洢ʲô�أ�
        ArrayList<Integer> path = new ArrayList<Integer>();
        //sort�ˣ�����źô��������鷳��
         Arrays.sort(candidates);
        //������Ҫ�����ݣ�׼����ϣ�
        helper(candidates, target, path, 0, result);

        return result;
    }

    //С�ȥ���Ҹ���������°�
    //������caditates�����ҳ����еĺ�Ϊtarget�����list of path����0��ʼ
    //һ�ִ����˼ά��ʽ�ǣ�ֱ��������ôȥ�����ݣ������ˣ��ֳ�����
    //��ȷ���ǣ��������ݽ�ʽ�����������Ĺ�ģ����һ���߼��룬���������
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

        //��Ϊ�ٶ�����ȫ��Ϊ����
        // int prev = -1;
        for (int i = index; i < candidates.length; i++) {
//            if (candidates[i] > target) {
//                break;
//            }
            //�������������ֵ�������ǰ���һ��ֵ��ȣ�����
            // if (prev != -1 && prev == candidates[i]) {
            //     continue;
            // }
            //
            path.add(candidates[i]);
            //��󿼵㣺����������Ƕ�index��������⣬������i����i+1
            //�����iλ�õ�Ԫ�أ������ˣ�index��Ϊi+1,�Ǿ�©���˺ܶ�����Ľ�
            //iλ�ñ��ֲ��䣬��ѭ������һ�������Ǳ�֤������ѭ����
            //��ĿҪ��Ԫ�ؿ��ظ���Σ���������indexȡֵΪi��
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
