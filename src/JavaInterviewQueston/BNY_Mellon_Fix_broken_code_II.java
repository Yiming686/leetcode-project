package JavaInterviewQueston;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class BNY_Mellon_Fix_broken_code_II {
	public static int help(int n){
        int temp = n;
        int count = 0;
         while (temp!=0) {
        	 temp = temp>>>1;
             count ++;
         }
 		int allOnes = 1;
 		allOnes <<=count;
 		allOnes-=1;
 		n^=allOnes;
		return n;
	}

	public static void main(String[] args) {
//		String s = "";
//		s.toCharArray();
		// TODO Auto-generated method stub
//		int num = 5;
//		int num = 50;
//		int num = 100;
//		System.out.println("num:"+help(num));

		Solution2.main(args);
	}

}

class Solution2 {

	interface StringSupplier {
		String getNext();
	}

	public static void compareStrings2(StringSupplier supplier1, StringSupplier supplier2, List<Boolean> results) {

		/*
		 * Fix this code.
		 */
		String string1 = null;
		String string2 = null;
//		try {
			while (true) {
				try {
					string1 = supplier1.getNext();
				} catch (ArrayIndexOutOfBoundsException ex1) {
					while (true) {
						try {
							string2 = supplier2.getNext();
							results.add(false);
						} catch (RuntimeException ex2) {
							break;
						}
					}
				} catch (RuntimeException e) {
					while (true) {
						try {
							string2 = supplier2.getNext();
							results.add(false);
						} catch (RuntimeException ex2) {
							break;
						}
					}
				}
				try {
					string2 = supplier2.getNext();
					
				} catch (NoSuchElementException ex2) {
					results.add(false);
					while (true) {
						try {
							string1 = supplier1.getNext();
							results.add(false);
						} catch (ArrayIndexOutOfBoundsException ex1) {
							break;
						}
					}
				} catch (RuntimeException e) {
					// TODO: handle exception
				}
				
				if (string1 == null && string2 == null) {
					results.add(true);
				}else if(string1 == null || string2 == null) {
					results.add(false);
				} else if (string1.equals(string2)) {
					results.add(true);
				} else {
					results.add(false);
				}
			}
//		}
	}
	
	//worked
	public static void compareStrings(StringSupplier supplier1, StringSupplier supplier2, List<Boolean> results) {

		/*
		 * Fix this code.
		 */
		String string1 = null;
		String string2 = null;
		try {
			while (true) {
				string1 = supplier1.getNext();
				string2 = supplier2.getNext();
				System.out.println("string1: "+string1);
				System.out.println("string2: "+string2);
				if (string1 == null && string2 == null) {
					results.add(true);
				}else if(string1 == null || string2 == null) {
					results.add(false);
				} else if (string1.equals(string2)) {
					results.add(true);
				} else {
					results.add(false);
				}
			}
		} catch (ArrayIndexOutOfBoundsException ex1) {
				while (true) {
					try {
						string2 = supplier2.getNext();
						results.add(false);
					} catch (NoSuchElementException ex2) {
						break;
					}
				}
		} catch (NoSuchElementException ex2) {
				results.add(false);
				while (true) {
					try {
						string1 = supplier1.getNext();
						results.add(false);
					} catch (ArrayIndexOutOfBoundsException ex1) {
						break;
					}
				}
//			}
		}
	}


	enum VALUES_LINE_TYPE {
		TWO_VALUES, FIRST_IS_NULL, SECOND_IS_NULL, NO_FIRST, NO_SECOND, END_OF_INPUT
	}

	private static class StringSupplierImpl implements StringSupplier {
		private final List<String> strings;
		private Class<? extends RuntimeException> endOfInputExceptionClass;
		private int index;

		public StringSupplierImpl(List<String> strings, Class<? extends RuntimeException> endOfInputExceptionClass) {
			this.strings = strings;
			this.endOfInputExceptionClass = endOfInputExceptionClass;
			this.index = 0;
		}

		@Override
		public String getNext() {
			
			if (index == strings.size()) {
				try {
					throw endOfInputExceptionClass.newInstance();
				} catch (InstantiationException e) {
					System.out.println("getNext(): InstantiationException while creating end of input exception "
							+ endOfInputExceptionClass.getCanonicalName());
					throw new RuntimeException();
				} catch (IllegalAccessException e) {
					System.out.println("getNext(): IllegalAccessException while creating end of input exception "
							+ endOfInputExceptionClass.getCanonicalName());
					throw new RuntimeException();
				}
			}
			return strings.get(index++);
		}

	}
	
	public static void main(String[] args) {
		String[][] arr = {{"TWO_VALUES",    "2", "2"},
				          {"FIRST_IS_NULL", "3", "4"},
				          {"SECOND_IS_NULL","5", "6"},
				          {"NO_FIRST",      "7", "8"}, 
				          {"NO_SECOND",     "9", "10"}, 
				          {"END_OF_INPUT", "11", "12"}};

		List<String> stringSequence1 = new ArrayList<String>();
		List<String> stringSequence2 = new ArrayList<String>();

//		stringSequence1: [2, null, 5, 9]
//		stringSequence2: [2, 4, null, 8]
//		stringSequence1.clear();stringSequence2.clear();
//		stringSequence1.add("2");stringSequence1.add(null);//stringSequence1.add(null);
//		stringSequence2.add("2");stringSequence2.add("4");stringSequence2.add(null);stringSequence2.add("8");stringSequence2.add(null);

		stringSequence1.clear();stringSequence2.clear();
		stringSequence2.add("2");stringSequence2.add(null);//stringSequence1.add(null);
		stringSequence1.add("2");stringSequence1.add("4");stringSequence1.add(null);stringSequence1.add("8");stringSequence1.add(null);

		System.out.println("stringSequence1: "+stringSequence1);
		System.out.println("stringSequence2: "+stringSequence2);
		StringSupplierImpl stringSupplier1 = new StringSupplierImpl(stringSequence1,
				ArrayIndexOutOfBoundsException.class);
		StringSupplierImpl stringSupplier2 = new StringSupplierImpl(stringSequence2, NoSuchElementException.class);
		List<Boolean> results = new ArrayList<Boolean>();

		compareStrings(stringSupplier1, stringSupplier2, results);

		for (Boolean result : results) {
			System.out.println(result);
		}
	}


}
