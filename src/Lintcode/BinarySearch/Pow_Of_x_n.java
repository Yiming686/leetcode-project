package Lintcode.BinarySearch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pow_Of_x_n {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
        List<Integer> list = new ArrayList<Integer>();
        if(n == 0) return ;
        for(int i = 0; i < 10; i++)
            list.add(i);
        
        int base = 1;
        int count = 1;
        while(count < n){
            base *= 10;
            count++;
        }

        if(n == 1){
            list.remove(0);
            return ;
        }
        
        base = base/10;
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            Integer val = it.next();
            it.remove();
//            list.add(base + val);
        }
        
        return ;


	}
    //best solution, I have ever seen
    public double myPow(double x, int n) {
        // Write your code here
        if(n==0) return 1;
        if(n==1) return x;
        int num = n> 0 ? n : -n;
        double left = myPow(x, num/2);
        double pow = (num % 2==0) ? left * left : left*left*x;
        if( n > 0)
            return pow;
        else
            return 1/pow;
    }

    //worked, not best    
    public double myPow77(double x, int n) {
        // Write your code here
        if(n==0) 
            return 1;
        else if(n>0)
            return myPow(x, 0, n-1);
        else{
            double pow = myPow(x, 0, -n-1);
            return 1/pow;
        }
    }
    
    public double myPow(double x, int start, int end) {
        // Write your code here
        if(start == end){
            return x;
        }
        int mid = start + (end - start)/2;
        if((end - start + 1) % 2 == 0){
            double left = myPow(x, start, mid);
            return left * left;
        }else{
            double left = myPow(x, start, mid - 1);
            return left * left * x;
        }
                
    }
    
}
