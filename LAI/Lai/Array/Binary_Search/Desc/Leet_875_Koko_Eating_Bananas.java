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
//  ���ֺ�����ϵ���ݼ�������y = f(x)
//  x�ǳ��㽶���ٶȣ�y�ǳ��������㽶��Ҫ��ʱ��, ��֮�ٶȵ���������ʱ��ݼ���
//x=1ʱ,�ٶ�����������ʱ����ࣻxȡpiles���ֵʱ������ʱ��ΪN��NСʱ�ڿɱ��˳��ꣻ��������x���y��ֵ����N
//��Ŀ����H, H ��Ȼ ���ڻ���� N�� ��Ŀ����Ҫ�ҵ���С���Ǹ��ٶȣ���֤HСʱ�ڿ��Գ��������㽶
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
