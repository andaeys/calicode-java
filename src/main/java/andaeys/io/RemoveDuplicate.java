package andaeys.io;

import java.util.Arrays;

class RemoveDuplication {
    public static int removeDuplicates(int[] nums) {
        int[] dstNums = Arrays.stream(nums).distinct().toArray();
        int k = dstNums.length;
        for (int i = 0; i < nums.length && i<k; i++) {
            nums[i] = dstNums[i];
        }
        return k;
    }

    public static void main(String[] args) {
        int[] input1 = new int[] {1,1,2};
        int expResult = 2;
        int result = removeDuplicates(input1);
        //assert
        System.out.println("unique: "+result+"; nums: "+ Arrays.toString(input1)+" | correct: "+(expResult==result));

        int[] input2 = new int[] {0,0,1,1,1,2,2,3,3,4};
        int expResult2 = 5;
        int result2 = removeDuplicates(input2);
        //assert
        System.out.println("unique: "+result2+"; nums: "+ Arrays.toString(input2)+" | correct: "+(expResult2==result2));

        int[] input3 = new int[] {1,1,2};
        int expResult3 = 2;
        int result3 = removeDuplicates(input3);
        //assert
        System.out.println("unique: "+result3+"; nums: "+ Arrays.toString(input3)+" | correct: "+(expResult3==result3));
    }
}