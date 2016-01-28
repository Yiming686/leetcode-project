package JavaInterviewQueston;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BNY_Mellon_Fix_broken_code {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}

class Solution {

	interface StringSupplier {
		String getNext();
	}

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
				if (string1 == null || string2 == null) {
					results.add(false);
				} else if (string1.equals(string2)) {
					results.add(true);
				} else {
					results.add(false);
				}
			}
		} catch (RuntimeException e) {
			try {
				string1 = supplier1.getNext();
			} catch (RuntimeException er) {
				while (true) {
					try {
						string2 = supplier2.getNext();
						results.add(false);
					} catch (RuntimeException err) {
						break;
					}
				}
			}

			try {
				string2 = supplier2.getNext();
			} catch (RuntimeException er) {
				while (true) {
					try {
						string1 = supplier1.getNext();
						results.add(false);
					} catch (RuntimeException err) {
						break;
					}
				}
			}
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
		Scanner scanner = new Scanner(System.in);

		List<String> stringSequence1 = new ArrayList<String>();
		List<String> stringSequence2 = new ArrayList<String>();

		VALUES_LINE_TYPE line_type = null;

		while (line_type != VALUES_LINE_TYPE.END_OF_INPUT) {
			String token = scanner.next();
			line_type = Enum.valueOf(VALUES_LINE_TYPE.class, token);

			switch (line_type) {

			case TWO_VALUES:
				stringSequence1.add(scanner.next());
				stringSequence2.add(scanner.next());
				break;

			case FIRST_IS_NULL:
				stringSequence1.add(null);
				stringSequence2.add(scanner.next());
				break;

			case SECOND_IS_NULL:
				stringSequence1.add(scanner.next());
				stringSequence2.add(null);
				break;

			case NO_FIRST:
				stringSequence2.add(scanner.next());
				break;

			case NO_SECOND:
				stringSequence1.add(scanner.next());
				break;

			case END_OF_INPUT:
				break;
			}
		}

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
