package LeetCode.JavaArray;

/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Hide Tags Array Math

 */
public class LC_066_Plus_One {

    public int[] plusOne2(int[] digits) {
        if(digits==null || digits.length==0) return digits;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]+=1;
                return digits;
            }
            else{
                digits[i]=0;
            }
        }
        int[] newDigits=new int[digits.length+1];
        newDigits[0]=1;
        return newDigits;
    }
    
    // The complexity is O(1)
    // f(n) = 9/10 + 1/10 * O(n-1)
    //  ==>  O(n) =  10 / 9 = 1.1111 = O(1)
    
    public int[] plusOne(int[] digits) {
        int carries = 1;
        for(int i = digits.length-1; i>=0 && carries > 0; i--){  // fast break when carries equals zero
            int sum = digits[i] + carries;
            digits[i] = sum % 10;
            carries = sum / 10;
        }
        if(carries == 0)
            return digits;
            
        int[] rst = new int[digits.length+1];
        rst[0] = 1;
        // for(int i=1; i< rst.length; i++){
        //     rst[i] = digits[i-1];
        // } 
        return rst;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
