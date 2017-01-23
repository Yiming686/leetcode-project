package Lintcode.String;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;



/**
�����⡿��������String�������һ��String������˳�����ΰ����ڶ���String�е��ַ����У�
�򷵻�true�����򷵻�false
�����
�������׼ȷ��¼�ڶ���String����ϸ��Ϣ���ַ���Ϣ��λ����Ϣ

����google����ʣ���¼���£�
g:0,3 (g����ַ�����0��3��λ��)
o:1,2 (o����ַ�����1, 2��λ��)
l:4   (l����ַ�����4��λ��)
e:5   (e����ַ�����5��λ��)
ע���õ���Щ��Ϣ�Ϳ���׼ȷ����ԭ���ַ�����.
��Test Cases��
null, null --> false
"", null   --> false
null, ""   --> false
"a", null
null, "b"
"",""
"", "a"
"c", ""



 *
 */
public class ProofPoint_contains_All_Chars_In_Same_Order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//			String str1 = "gogloe";google
			String str2 = "google";
			String str1 = "goe";
			System.out.println(""+containsAllCharsInSameOrder(str1, str2));
			str2 = "geo";
			System.out.println(""+containsAllCharsInSameOrder(str1, str2));
			str2 = "gto";
			System.out.println(""+containsAllCharsInSameOrder(str1, str2));
			str2 = "goo";
			System.out.println(""+containsAllCharsInSameOrder(str1, str2));
			str1 = "ooooooooo";
			str2 = "ooo";
			System.out.println(""+containsAllCharsInSameOrder(str1, str2));

	}

	//��ʵ�֣��ǳ��ã����������ַ�������
	//������String1�����Ƿ���ȫ����String2��str1 = "google";str2 = "goe";�򷵻�true
	//����ĿString1��String2���Գƣ����String1������ȫ����String2��String2������ܲ���ȫ����String1
	static boolean containsAllCharsInSameOrder(String string1, String string2)
	{ 
		if(string1 == null|| string2 == null) return false;             //if null string is not allowed
		if(string1.length() == 0 || string2.length() == 0) return false;//if empty string is not allowed 
	    char[] arr1 = string1.toCharArray();
	    char[] arr2 = string2.toCharArray();
	    int len1 = arr1.length;
	    int len2 = arr2.length;
	    int i1 = 0;
	    int i2 = 0;
	    for(; i1 < len1 && i2 < len2; i1++, i2++){
	    	char ch2 = arr2[i2];
	    	while(i1<len1 && ch2 != arr1[i1]){
//	    		System.out.println("ch2:ch1  "+ch2 +" : "+arr1[i1]);
	    		i1++;
	    	}
	    }
	    if(i2 == len2) 
	    	return true;
	    else
	    	return false;
	}
	
	//�Ե�һ��string����map���Եڶ����ַ�����ַ�ɨ�裬����map�����Ƿ��������������������true��һ�����ֲ�����������false��
	static boolean containsAllCharsInSameOrder2(String string1, String string2)
	{ 
		if(string1 == null|| string2 == null) return false;//if null string is not allowed
		if(string1.length() == 0 || string2.length() == 0) return false;//if empty string is not allowed 
	    char[] arr1 = string1.toCharArray();
	    char[] arr2 = string2.toCharArray();
	    int len1 = arr1.length;
	    int len2 = arr2.length;
	    Map<Character, LinkedList<Integer>> map = new HashMap<Character, LinkedList<Integer>>();
	    for(int i = 0; i < len1; i++){
	    	char key1 = arr1[i];
	    	LinkedList<Integer> list = map.containsKey(key1) ? map.get(key1) : new LinkedList<Integer>();
		    list.addLast(i);
		    map.put(arr1[i], list);
	    }
	    int prevIndex = -1;//index of the previous element
	    for(int i = 0; i < len2; i++){
	    	char key2 = arr2[i];
	        if(!map.containsKey(key2)){ 
	        	return false; 
	        }else{
	        	LinkedList<Integer> list = map.get(key2);
	        	if(list.size() == 0){
	        		return false;
	        	}else{
	        		Integer currIndex = list.removeFirst();//index of the current element
	                if(currIndex < prevIndex) return false;  
	                prevIndex = currIndex;		        		
	        	}
	        }
	    }
//	    System.out.println("prevIndex:"+prevIndex);
	    return true;
	}


}
