package LeetCode;

/*******
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 */
public class LC_075_SortColors {

	public void f() {
		int arr[] = ArrayBuilder.createIntegerArray_WithDups(10, 0, 2);
		ArrayPrinter.printIntegerArray(arr);
		System.out.println(arr);
	}

	public void sortColors3() {
//		int nums[] = ArrayBuilder.createIntegerArray(10, 0, 2);
		 int[] nums = { 2, 0, 1, 1, 1, 1, 1, 2, 2, 2 };

		boolean isDebug = ( 0 == 0 )?true:false;

//		boolean isDebug = false;
//		boolean isDebug = true;
		String formatStr = null;
 		int len = nums.length;
        int left = 0;
        int right = len -1;
        int curr = 0;
        if(isDebug){
    		formatStr = " %6s %6s %6s %25s \n";
    		System.out.printf(formatStr, "left", "curr", "right",  " Array");
    		System.out
    		.printf("--------------------------------------------------------------------------------\n");
        }


        while(curr <= right){
        	if(isDebug){
        		System.out.printf(formatStr, left, curr, right,  ArrayPrinter.printIntegerArrayToStr(nums));
        	}

            if(nums[curr] == 0){
                nums[curr] = nums[left];
                nums[left++] = 0;
                if(left>curr){
                    curr++;
                }
            }else if(nums[curr] == 2){
                nums[curr] = nums[right];
                nums[right--] = 2;
            }else{
                curr++;
            }
        }

	}

	// two pass solution
	public void sortColors2() {
		int arr[] = ArrayBuilder.createIntegerArray_WithDups(10, 0, 2);
		ArrayPrinter.printIntegerArray(arr);
		int len = arr.length;
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;

		for (int i = 0; i < len; i++) {
			int e = arr[i];
			if (e == 0) {
				count0++;
			}
			if (e == 1) {
				count1++;
			}
			if (e == 2) {
				count2++;
			}
		}
		int i = 0;
		for (i = 0; i < count0; i++) {
			arr[i] = 0;
		}
		for (; i < count0 + count1; i++) {
			arr[i] = 1;
		}
		for (; i < len; i++) {
			arr[i] = 2;
		}
		ArrayPrinter.printIntegerArray(arr);
	}

	public void sortColors1() {
		int nums[] = ArrayBuilder.createIntegerArray_WithDups(8, 0, 2);
		// int[] nums = { 2, 0, 0, 0, 0, 1, 2, 2, 0, 2 };
		// int[] nums ={0, 1, 0, 1, 2, 1, 2, 0, 1, 0};
		ArrayPrinter.printIntegerArray(nums);
		int len = nums.length;
		int start0 = 0;
		int len0 = 0;
		int start1 = 0;
		int len1 = 0;
		int start2 = len - 1;
		int len2 = 0;

		String star = "*";
		String formatStr = "%2s%6s %6s %6s %6s %6s %6s %6s %25s \n";
		System.out.printf(formatStr, star, "i", "start0", "len0", "start1",
				"len1", "start2", "len2", " Array");
		star = "";

		System.out
				.printf("--------------------------------------------------------------------------------\n");
		aba: for (int i = 0; i < len; i++) {
			// System.out
			// .printf("i=%3s,start0=%s,len0=%s,start1=%s,len1=%s,start2=%s,len2=%s,  %s \n",
			// i, start0, len0, start1, len1, start2, len2,
			// ArrayPrinter.printIntegerArrayToStr(nums));

			System.out.printf(formatStr, star, i, start0, len0, start1, len1,
					start2, len2, ArrayPrinter.printIntegerArrayToStr(nums));

			int e = nums[i];
			boolean isFinished = false;
			switch (e) {
			case 0:
				if (len1 > 0) {
					nums[i] = 1;
					nums[start1] = 0;
				}
				len0++;
				start1++;
				break;
			case 1:
				len1++;
				break;
			case 2:
				// 1.fist job is to find position to insert this 2
				// start2 is the position, len2 is the number of previous 2s
				// note: start2 >= 0
				while (start2 >= 0 && nums[start2] == 2) {
					start2--;
					len2++;
				}
				// 2.if start2 is less than i, means finished, nothing to do
				if (start2 <= i) {
					star = "*";
					isFinished = true;
					break aba;
				}
				// 3.move value 0 in start0
				if (nums[start2] == 0) {
					if (len1 > 0) {
						nums[start1] = 0;
						nums[i] = 1;
					} else {
						nums[i] = 0;
					}
					len0++;
					start1++;
				}
				// 4.move value 1 in start0
				if (nums[start2] == 1) {
					nums[i] = 1;
					len1++;
				}
				// 5.set value in start2
				nums[start2] = 2;
				break;
			}
			// do not need to loop under this condition
			// if (isFinished) {
			// star = "*";
			// System.out
			// .printf("%%%%%%%%%%%%%");
			// break;
			// }
		}

		ArrayPrinter.printIntegerArray(nums);

	}
}
