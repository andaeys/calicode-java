package andaeys.io.dp;

import static andaeys.io.util.TestUtil.test;

public class TileStacking {

    static int stacking(int n, int m, int k){
        int[][] dp = new int[m+1][n+1];
        dp[0][0]=1;
        for(int i=0;i<=m;i++){
            dp[0][i]=1;
        }

        // Fill the DP table
        for (int i=1;i<=n;i++){
            int p = k;
            for( int j=1; j<=m; j++){
                dp[i][j] = dp[i][j-1]; // Ways to build this height without using the current tile size
                if(j<=i && p>0){
                    dp[i][j] += dp[i-j][m];
                    p--;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        test(1, 1, stacking(3, 3, 1));
        test(2, 7, stacking(3, 3, 2));
    }
}
