package Lintcode.BinarySearch;

/**
Smallest Rectangle Enclosing Black Pixels 

 Description
 Notes
 Testcase
 Judge
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

Have you met this question in a real interview? Yes
Example
For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.

Tags 
Binary Search Google

 *
 *
 */
public class Smallest_Rectangle_Enclosing_Black_Pixels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public static int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        
        int rows = image.length;
        int cols = image[0].length;
        
        int left = findLeft(image, 0, y);//TC is log(y)
        int right = findRight(image, y, cols - 1);//TC is log(cols-y)
        int top = findTop(image, 0, x);//TC is log(x)
        int bottom = findBottom(image, x, rows - 1);//TC is log(rows-x)

        return (right - left + 1) * (bottom - top + 1);
    }
    
  //find first bad column, must have one, log(y)
    private static  int findLeft(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (isEmptyColumn(image, start)) {
            return end;
        }
        return start;
    }
    
    //worked, 作为上面的参考，略有区别
    private static int findFirstBadVersion(int n) {
       int start = 1, end = n;
       while (start + 1 < end) {
           int mid = start + (end - start) / 2;
           if (SVNRepo.isBadVersion(mid)) {
               end = mid;
           } else {
               start = mid;
           }
       }
       return SVNRepo.isBadVersion(start) ? start : end;
   }
 
    private static int findRight(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (isEmptyColumn(image, end)) {
            return start;
        }
        return end;
    }
    
    private static int findTop(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (isEmptyRow(image, start)) {
            return end;
        }
        return start;
    }
    
    private static int findBottom(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (isEmptyRow(image, end)) {
            return start;
        }
        return end;
    }
    
    private static boolean isEmptyColumn(char[][] image, int col) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1') {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isEmptyRow(char[][] image, int row) {
        for (int j = 0; j < image[0].length; j++) {
            if (image[row][j] == '1') {
                return false;
            }
        }
        return true;
    }
    
    private interface SVNRepo{
		static boolean isBadVersion(int versionNum) {
			// TODO Auto-generated method stub
			return false;
		}
    }
}
