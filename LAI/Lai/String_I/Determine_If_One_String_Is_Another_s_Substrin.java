package Lai.String_I;

public class Determine_If_One_String_Is_Another_s_Substrin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("strstr: " + strstr("abcdef", "bc"));
//		System.out.println("strstr: " + strstrRobinCarp("abcdef", "bc"));
//		System.out.println("strstr: " + strstrRobinCarp("abbadeaszabb/ab", "deasz"));
		System.out.println("strstr: " + strstrRobinCarp("abbaabbab", "bbab"));

//		System.out.println(""+generateHash("zbcd", 0, 0));
//		System.out.println(""+generateHash("abcd", 0, 1));
//		System.out.println(""+generateHash("abcd", 0, 2));
//		System.out.println(""+generateHash("abcd", 0, 3));

//		System.out.println("TorF:" + (Long.MAX_VALUE + 100 < Long.MAX_VALUE));
//		System.out.println("" + (Integer.MAX_VALUE));
//		long k = 26;
//		int count = 0;
//		while (k > 0 && k < Integer.MAX_VALUE) {
//			System.out.println("" + k);
//			k *= 26;
//			count++;
//		}
//		System.out.println("count: " + count);

	}

//【标准】best in interview, O(N*M) + O(1)
	public static int strstr(String large, String small) {
		// Write your solution here
		if (large == null || small == null) {
			return -1;
		}
		if (small.length() == 0) {
			return 0;
		}
		if (large.length() < small.length()) {
			return -1;
		}
		for (int i = 0; i <= large.length() - small.length(); i++) {//等号不可忘记
			int j = 0;
			while (j < small.length() && large.charAt(i + j) == small.charAt(j)) {
				j++;
			}
			if (j == small.length()) {
				return i;
			}
		}
		return -1;
	}

	public static int strstrRobinCarp(String large, String small) {
		if (large.length() < small.length()) {
			return -1;
		}
		if (small.length() == 0) {
			return 0;
		}
		int largePrime = 101;
		int prime = 31;
		int seed = 1;
		int targetHash = small.charAt(0) % largePrime;
		for (int i = 1; i < small.length(); i++) {
			seed = hash(seed, 0, prime, largePrime);
			targetHash = hash(targetHash, small.charAt(i), prime, largePrime);
		}
		int hash = 0;
		for (int i = 0; i < small.length(); i++) {
			hash = hash(hash, large.charAt(i), prime, largePrime);
		}
		if (hash == targetHash && equals(large, 0, small)) {
			return 0;
		}
		for (int i = 1; i <= large.length() - small.length(); i++) {
			hash -= seed * large.charAt(i - 1) % largePrime;
			if (hash < 0) {//possible
				hash += largePrime;
			}
			hash = hash % largePrime;
			hash = hash(hash, large.charAt(i + small.length() - 1), prime, largePrime);
			if (hash == targetHash && equals(large, i, small)) {
				return i;
			}
		}
		return -1;
	}

	private static boolean equals(String large, int start, String small) {
		for (int i = start; i < small.length(); i++) {
			if (large.charAt(i + start) != small.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private static int hash(int hash, int addition, int prime, int largePrime) {
		return (hash * prime % largePrime + addition) % largePrime;
	}

//	【标准】best in interview, O(N+M) + O(1)
	public static int strstrRobinCarpByMe(String large, String small) {
		if (large == null || small == null) {
			return -1;
		}
		if (small.length() == 0) {
			return 0;
		}
		if (large.length() < small.length()) {
			return -1;
		}
		long targetHash = generateHash(small, 0, small.length() - 1);
		int numOfSmall = small.length();
		long firstWeight = 1;
		while (--numOfSmall > 0) {
			firstWeight *= 27;
		}
		numOfSmall = small.length();
		long currHash = generateHash(large, 0, small.length() - 1);
		if (currHash == targetHash) {
			return 0;
		}
		for (int i = 1; i <= large.length() - small.length(); i++) {
//			int j = 0;
//			while (j < small.length() && large.charAt(i + j) == small.charAt(j)) {
//				j++;
//			}			
//			currHash = generateHash(currHash, large, i, firstWeight, numOfSmall);

//			currHash = currHash - firstWeight * (large.charAt(i-1)- 'a'+1) + (large.charAt(i + numOfSmall - 1)- 'a'+1);
			long head = firstWeight * (large.charAt(i - 1) - 'a' + 1);
			long tail = large.charAt(i + numOfSmall - 1) - 'a' + 1;
			currHash = 27 * (currHash - head) + tail;

			if (currHash == targetHash) {
				return i;
			}
		}
		return -1;

	}

//	private static int generateHash(int currHash, String large, int i, int firstWeight, int numOfSmall) {
//		return currHash - firstWeight * large.charAt(i) + large.charAt(i + numOfSmall - 1);
//	}

	private static long generateHash(String small, int start, int end) {
//		int k = 26;
		long hash = 0;
		for (int i = start; i <= end; i++) {
			hash = 27 * hash + (small.charAt(i) - 'a' + 1);
		}
		return hash;
	}

//	worked, no extra space，  这里必要转换为数组，但是变量定义太多
	public static int strstr00(String large, String small) {
		// Write your solution here
		if (small.length() == 0) {
			return 0;
		}
		if (large.length() < small.length()) {
			return -1;
		}
		for (int i = 0; i <= large.length() - small.length(); i++) {
			int indexLarge = i;
			int indexSmall = 0;
			while (indexSmall < small.length() && large.charAt(indexLarge) == small.charAt(indexSmall)) {
				indexLarge++;
				indexSmall++;
			}
			if (indexSmall == small.length()) {
				return i;
			}
		}
		return -1;
	}

	//worked， not good ,extra space, 没有必要转换为数组，变量定义不妥
	public static int strstr01(String large, String small) {
		// Write your solution here
		if (large == null || small == null) {
			return -1;
		}
		if (small.length() == 0) {
			return 0;
		}
		if (large.length() < small.length()) {
			return -1;
		}
		char[] arrLarge = large.toCharArray();
		char[] arrSmall = small.toCharArray();
		for (int i = 0; i <= arrLarge.length - arrSmall.length; i++) {
			int j = 0;
			int pos = i;//没必要
			while (j < arrSmall.length && arrLarge[pos] == arrSmall[j]) {
				pos++;
				j++;
			}
			if (j == arrSmall.length) {
				return i;
			}
		}
		return -1;
	}

}
