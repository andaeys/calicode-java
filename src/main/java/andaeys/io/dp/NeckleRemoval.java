package andaeys.io.dp;

import static andaeys.io.util.TestUtil.test;

public class NeckleRemoval {

    static int neckleRemoval(int N, String left, String right){
        // Special case where already equal
        if (check(left+right)){
            return 0;
        }

        int minRemove = 2*N;
        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                String combine = left.substring(i) + right.substring(0, N-j);
                if(check(combine)) {
                    minRemove = Math.min(minRemove, i+j);
                }
            }
        }
        return minRemove;
    }

    static boolean check(String s){
        int rCount=0; int bCount = 0;
        for(char c: s.toCharArray()){
            if(c=='R') rCount++;
            else bCount++;
        }
        return rCount==bCount;
    }

    static int neckleRemoval2(int N, String left, String right){
        int minRemove = 2*N;
        // track left (prefix) diff R and B at position -i
        int[] leftDiff = new int[N+1];
        int[] rightDiff =  new int[N+1];
        for(int i=1;i<=N;i++){
            leftDiff[i] = leftDiff[i-1] + (left.charAt(i-1)=='R' ? 1:-1);
        }
        for(int i=N-1;i>=0;i--){
            rightDiff[i] = rightDiff[i+1] + (right.charAt(i)=='R' ? 1:-1);
        }

        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                if(leftDiff[i]+rightDiff[j]==0){
                    minRemove = Math.min(minRemove, i+(N-j));
                }
            }
        }
        return minRemove;
    }

    static int neckleRemoval3(int N, String left, String right){
        int totalR = 0, totalB = 0;
        for(char c: left.toCharArray()) if (c=='R') totalR++; else totalB++;
        for(char c: right.toCharArray()) if (c=='R') totalR++; else totalB++;

        // The goal is to make the number of Rs and Bs equal.
        // Start with considering removing all characters (where differences are zero).
        int minRemovals = Math.abs(totalR-totalB);
        // Track the balance of R and B as we consider removals.
        int leftBalance = 0, rightBalance = 0;

        // Calculate the minimum removals required by adjusting
        // from the left of L and the right of R.
        for(int i=0;i<=N;i++){
            // Update balance for L based on removed character.
            if(i>0) leftBalance+= left.charAt(i-1)=='R' ? 1:-1;

            rightBalance = 0;   //reset every -i
            for (int j = 0; j <= N; j++) {
                if(j>0){
                    // Update balance for R based on removed character.
                    rightBalance += right.charAt(N-j)=='R' ? 1:-1;
                }
                // Calculate the total imbalance after removals.
                int currentImabalance = Math.abs((totalR-leftBalance-rightBalance) -
                        (totalB-leftBalance-rightBalance));
                minRemovals = Math.min(minRemovals, i+j+currentImabalance);
            }
        }
        return minRemovals;
    }

    public static void main(String[] args) {
        test(0, 0, neckleRemoval3(3, "RBR", "RBB"));
        test(0, 2, neckleRemoval3(2, "BR", "RR"));
        test(0, 6, neckleRemoval3(3, "RRR", "RRR"));
        test(0, 8, neckleRemoval3(6, "RRRBBR", "RRRRRR"));
    }
}
