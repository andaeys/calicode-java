package andaeys.io.dp;

import static andaeys.io.util.TestUtil.test;

public class FiboPractice {

    public static int solveFibo(int N){
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=N;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }

    public static void main(String[] args) {
        //test case 1
        test(5, 5, solveFibo(5));
        //test case 2
        test(6, 8, solveFibo(6));
        //test case 3
        test(7, 13, solveFibo(7));
        test(8, 21, solveFibo(8));
    }
}
