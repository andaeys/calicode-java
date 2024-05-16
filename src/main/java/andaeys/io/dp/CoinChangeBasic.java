package andaeys.io.dp;

import static andaeys.io.util.TestUtil.test;

public class CoinChangeBasic {

    static int coinChange(int[] coins, int target){
        int n = coins.length;
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;

        for(int i=1;i<=n;i++){
            for (int j=0;j<=target;j++){
                dp[i][j] = dp[i-1][j]; //without coin-i
                //now with coin-i
                int d = j-coins[i-1]; //check remaining target -d
                if(d>=0){
                    //add with total of remaining target d
                    dp[i][j] += dp[i][d];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        test(4, 4, coinChange(new int[]{1,2,3}, 4));
        test(10, 5, coinChange(new int[]{2,5,3,6}, 10));
    }
}
