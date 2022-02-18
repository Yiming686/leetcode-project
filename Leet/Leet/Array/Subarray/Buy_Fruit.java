package Leet.Array.Subarray;

public class Buy_Fruit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int numOfWays(int[] prices, int target) {
    // public int backPackIV_me(int[] nums, int target) {        
        if(prices == null || prices.length == 0){
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i < prices.length; i++){
            // for(int j = target; j >= 0; j--){
            for(int j = 0; j <= target; j++){    
                if(j - prices[i] >= 0 ){
                    dp[j] = dp[j] + dp[j-prices[i]];
                }
            }
        }
        return dp[target];
    }

}
