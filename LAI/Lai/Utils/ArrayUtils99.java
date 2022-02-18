package Lai.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class ArrayUtils99 {
	public static class TreeNode<T> {
		
		public T val;
//		public int liss;
		public TreeNode<T> left;
		public TreeNode<T> right;

	    Class<T> typeParameterClass;

	    public TreeNode(Class<T> typeParameterClass) {
	        this.typeParameterClass = typeParameterClass;
	    }
	    @JsonCreator
		public TreeNode(@JsonProperty("val") T val, @JsonProperty("typeParameterClass") Class<T> typeParameterClass) {
			super();
			this.val = val;
			this.typeParameterClass = typeParameterClass;
		}
	    
//		@JsonCreator
//		public TreeNode(@JsonProperty("val") T val) {
//			super();
//			this.val = val;
//		}

//	    private Class<T> inferedClass;
//
//	    public Class<T> getGenericClass(){
//	        if(inferedClass == null){
//	            Type mySuperclass = getClass().getGenericSuperclass();
//	            System.out.println("mySuperclass: "+ val);
//	            Type tType = ((ParameterizedType)mySuperclass).getActualTypeArguments()[0];
//	            String className = tType.toString().split(" ")[1];
//	            try {
//					inferedClass = (Class<T>) Class.forName(className);
//				} catch (ClassNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	        }
//	        return inferedClass;
//	    }
	    
		public T getVal() {
			return val;
		}

		public void setVal(T val) {
			this.val = val;
		}

		public TreeNode<T> getLeft() {
			return left;
		}

		public void setLeft(TreeNode<T> left) {
			this.left = left;
		}

		public TreeNode<T> getRight() {
			return right;
		}

		public void setRight(TreeNode<T> right) {
			this.right = right;
		}
		
	}
	public static final ObjectMapper objectMapper = new ObjectMapper();
	
//	public static String convertStr2JsonStr(String val) {
//		TreeNode<String> root = new TreeNode<>("99");
//		String json = null;
//		try {
//			json = objectMapper.writeValueAsString(root);
//			System.out.println("Before replaceAll: "+json);
//			json = json.replaceAll("99", val);
//			System.out.println("After replaceAll: "+json);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return json;
//	}
	
	public static String convertStr2JsonStr(String val) {
		return "{\"val\":\""+val+"\"}";
	}

	
//    public static <T> T readValue(String content, Class<T> clazz) {
//    	
//    		return readValue(content, Class<T> clazz);
//    }

	public static <T> TreeNode<T> convertJsonStr2GenericJavaObject(String content, Class<?> clazz0, Class<?> clazz1){ //Class<T> clazz0, Class<T> clazz1) {
		JavaType deserializeType = objectMapper.getTypeFactory().constructParametricType(clazz0, clazz1);
		  try {
			return objectMapper.readValue(content, deserializeType);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		String str = "[\"abc\",\"defg\"]";
		List<String> strList = new ArrayList<>();
		strList.add("hijk");
		strList.add("lmn");
		
		String jsonStr = "";
		try {
			jsonStr = objectMapper.writeValueAsString(strList);
			System.out.println("strList: "+ jsonStr);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JavaType type = objectMapper.getTypeFactory().constructParametricType(List.class, String.class);
		  try {
//			  List<String> strList2 = objectMapper.readValue(jsonStr, type);
//			  System.out.println("strList2: "+strList2);
			  
			  String[] strArr = objectMapper.readValue(jsonStr, type);
			  System.out.println("strArr: "+strArr);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		String content = convertStr2JsonStr("89");
		
		TreeNode<Integer> node = convertJsonStr2GenericJavaObject(content, TreeNode.class, Integer.class);
		System.out.println("NODE val: "+node.val);
		System.out.println("NODE Class: "+node.getClass());
		System.out.println("NODE Val Class: "+node.val.getClass());
		
//		System.out.println("T: "+node.getGenericClass());
		
		
//		System.out.println("ArrayUtils: "+"ddddddd");
//		System.out.println(""+convertStrValue2JsonString("26"));
//		TreeNode<Integer> node = new TreeNode<Integer>(8);
//		System.out.println("node
		
		
			
		
		//	     Type type = ((ParameterizedType)sooper).getActualTypeArguments()[0];
	      
		TreeNode<Integer> root = convert2("99");
		System.out.println("root66: "+ root.val);
		System.out.println("NODE Class: "+root.getClass());
		System.out.println("NODE Val Class: "+root.val.getClass().toString());

	}
	

	private static <T>  TreeNode<T> convert(String data) {
		TreeNode<T> root = null;
		TreeNode<Integer> node = new TreeNode<Integer>(8, Integer.class);
//		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(TreeNode.class, .class);  

		try {
			root = objectMapper.readValue(convertStr2JsonStr(data), new TypeReference<TreeNode<T>>() {});
//			root = (TreeNode<T>)mapper.readValue(jsonString, javaType);
//			root = objectMapper.readValue("{\"val\":\""+data+"\"}", new TypeReference<TreeNode<T>>() {});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			System.out.println("Last: "+objectMapper.writeValueAsString(root));
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		};

		return root;
	}

	private static <T>  TreeNode<T> convert2(String jsonString) {
		TreeNode<T> root = null;
		TreeNode<Integer> node = new TreeNode<Integer>(8, Integer.class);
//		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(TreeNode.class, classType);  

		try {
//			root = objectMapper.readValue(convertStr2JsonStr(data), new TypeReference<TreeNode<T>>() {});
//			root = (TreeNode<T>)mapper.readValue(jsonString, javaType);
//			root = objectMapper.readValue("{\"val\":\""+data+"\"}", new TypeReference<TreeNode<T>>() {});
//			Class<Integer> classType = node.getGenericClass();
			
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(TreeNode.class, Integer.class);
            return objectMapper.readValue(convertStr2JsonStr(jsonString), javaType);
//            return objectMapper.readValue(convertStr2JsonStr(jsonString), classType);

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("Last: "+objectMapper.writeValueAsString(root));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

		return root;
	}

	public static int[] generateIntArray(int size, int left, int right){
		int[] arr = new int[size];
		int range = right - left + 1;
		for(int i = 0; i < size; i++) {
			arr[i] = left + (int)(Math.random() * range );
			if(arr[i] == left || arr[i] == right || arr[i] == right - 1) {
//				System.out.println(""+arr[i]);
			}
		}
		System.out.println("Generated Int Array: "+Arrays.toString(arr));
		return arr;
	}
	
	public static void swapIntArray(int[] arr, int left, int right){
		int temp = arr[left];		
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public static void swapIntegerArray(Integer[] arr, int left, int right){
		int temp = arr[left];		
		arr[left] = arr[right];
		arr[right] = temp;
	}

}
