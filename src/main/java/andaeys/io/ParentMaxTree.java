package andaeys.io;

import static andaeys.io.util.TestUtil.test;

public class ParentMaxTree {

    static int parentGroups(int[] a){
        int max =1;
        int n = a.length;
        for(int i=0;i<n;i++){
            if(a[i]!=-1){
                int h = checkHRecur(1, i, a);
                max = Math.max(max, h);
            }
        }
        return max;
    }

    private static int checkHRecur(int total, int node, int[] a) {
        if(a[node]==-1){
            return total;
        }else {
            return checkHRecur(total+1, a[node], a);
        }
    }

    public static void main(String[] args) {
        test(0, 4, parentGroups(new int[]{2, -1, 5, -1, 0, -1, 3}));
        test(0, 4, parentGroups(new int[]{3, 7, 4, 5, -1, 7, 5 ,-1}));
        test(0, 7, parentGroups(new int[]{-1, 0, 1, 2, 3, 4, 5}));
        test(0, 1, parentGroups(new int[]{-1, -1, -1}));
    }
}
