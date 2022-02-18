package Lai.Array.Binary_Search.Desc;

import static Utils.ArrayUtils.ppprintf;
import static Utils.ArrayUtils.print;
import static Utils.ArrayUtils.printf;

public class Leet_875_Koko_Eating_Bananas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		piles = [3,6,7,11], H = 8
//		[30, 11, 23, 4, 20] 6
		int[] piles ={30, 11, 23, 4, 20}; 
		int H = 6;
		System.out.println(""+minEatingSpeed(piles, H));
	}
//  发现函数关系：递减函数，y = f(x)
//  x是吃香蕉的速度，y是吃完所有香蕉需要的时间, 随之速度递增，所需时间递减，
//x=1时,速度最慢，所需时间最多；x取piles最大值时，所需时间为N，N小时内可便宜吃完；后面无论x多大，y的值都是N
//题目给定H, H 必然 大于或等于 N， 题目就是要找到最小的那个速度，保证H小时内可以吃完所有香蕉
     public static int minEatingSpeed(int[] piles, int H) {
         int left = 1;//low speed
         int right = 1;//lowest fast speed
         for(int pile : piles){
             right = pile > right ? pile : right;
         }
         while(left + 1 < right){
             int mid = left + (right - left) / 2;
             //correct, when == H, should not return mid
             if(countHours(piles, mid) > H){
                 left = mid;//left = mid + 1, both OK
             }else{
                 right = mid;
             }
             // //Wrong
             // if(countHours(piles, mid) < H){
             //     right = mid;
             // }else{
             //     left = mid;
             // }
         }
         if(countHours(piles, left) <= H){
             return left;
         }
         return right;
     }
     private static int countHours(int[] piles, int speed){
         int countOfHours = 0;
         for(int pile : piles){
             countOfHours += (pile + speed - 1) / speed;
         }
         return countOfHours;            
     }


}
