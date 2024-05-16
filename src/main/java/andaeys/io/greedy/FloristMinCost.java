package andaeys.io.greedy;

import java.util.Arrays;

import static andaeys.io.util.TestUtil.test;

public class FloristMinCost {

    static int getMinimumCost(int k, int[] c) {
        int modular = (int) Math.pow(2, 31);
        int n = c.length;
        int totalOnlyBuy1 = 0;
        Arrays.sort(c);
        for(int i = n-k;i<n;i++){
            totalOnlyBuy1 = (totalOnlyBuy1 + c[i]) % modular;
        }
        int remaingFLowers = n-k;
        int total = 0;

        int count=0;
        int multiplier = 2;
        for(int i=remaingFLowers-1;i>=0;i--){
            total = (total + multiplier*c[i]) % modular;
            count++;
            if(count==k){
                count=0;
                multiplier++;
            }
        }
        return (totalOnlyBuy1 + total) % modular;
    }


    public static void main(String[] args) {
        test(0, 11, getMinimumCost(3, new int[]{1, 2, 3, 4}));
        test(0, 13, getMinimumCost(3, new int[]{2, 5, 6}));
        test(0, 15, getMinimumCost(2, new int[]{2, 5, 6}));
        test(0, 29, getMinimumCost(3, new int[]{1, 3, 5, 7 ,9}));
        test(0, 44, getMinimumCost(2, new int[]{2, 4, 6, 8, 10}));
        test(0, 163578911, getMinimumCost(3, new int[]{390225, 426456, 688267, 800389, 990107, 439248, 240638, 15991, 874479, 568754, 729927, 980985, 132244, 488186, 5037, 721765, 251885, 28458, 23710, 281490, 30935, 897665, 768945, 337228, 533277, 959855, 927447, 941485, 24242, 684459, 312855, 716170, 512600, 608266, 779912, 950103, 211756, 665028, 642996, 262173, 789020, 932421, 390745, 433434, 350262, 463568, 668809, 305781, 815771, 550800}));
    }
}

