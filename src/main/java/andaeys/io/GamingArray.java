package andaeys.io;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static andaeys.io.util.TestUtil.test;

public class GamingArray {

    /*
    https://www.hackerrank.com/challenges/an-interesting-game-1/problem
    * */

    public static String gamingArray(List<Integer> arr) {
        int n = arr.size();
        int turn = 0;

        //pq check
        PriorityQueue<Cell> pq = new PriorityQueue<>(n);
        for(int i=0;i<n;i++){
            pq.offer(new Cell(arr.get(i), i));
        }
        int pivot = n;
        while (!pq.isEmpty() && pivot>0){
            Cell topCell = pq.poll();
            int idTop = topCell.idx;
            //check right (id>idMax)
            if(idTop<=pivot){
                pivot = idTop;
                turn++;
            }
        }

        //result wrap
        String result = "BOB";
        if(turn %2==0){
            result = "ANDY";
        }
        return result;
    }

    static class Cell implements Comparable<Cell> {
        int val; int idx;
        Cell(int v, int i){this.val = v; this.idx = i;}
        @Override public int compareTo(Cell cell) {return cell.val - this.val;}
    }

    public static void main(String[] args) {
        test(0, "ANDY", gamingArray(Arrays.asList(5,2,6,3,4)));
        test(0, "BOB", gamingArray(Arrays.asList(3,1)));
        test(0, "BOB", gamingArray(Arrays.asList(1,3,5,7,9)));
        test(0, "ANDY", gamingArray(Arrays.asList(7,4,6,5,9)));
        test(0, "BOB", gamingArray(Arrays.asList(65194,8115,6117,29036,32362,61968,33097,8933,48404,20798,22878,79156,12529,85569,6694,2312,95138,48680,83657,61801,67326,14165,92214,4546,84948,27986,88208,57285,60345,19284,2502,81434,95271,64223,38949,53020,26690,15360,95263,53404,36099,43951,58886,53245,42341,71994,74035,66042,78917,26868,23754,47366)));
    }
}
