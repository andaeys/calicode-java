package andaeys.io;

import java.util.*;
import java.util.stream.Collectors;

public class TreeHeapExplore {

    public static void main(String[] args) {
        int[] intArray = new int[]{5, 6, 4, 3, 10, 9, 15, 12};

        //from collection
         List<Integer> iList = Arrays.stream(intArray)
                 .boxed().collect(Collectors.toList());
        List<Integer> intList = new ArrayList<>(iList);
        PriorityQueue<Integer> pqFromList = new PriorityQueue<>(intList);
        System.out.println("pqList peek: "+pqFromList.peek());

        //max heap
        PriorityQueue<Integer> maxHeapList = new PriorityQueue<>(intArray.length, Comparator.reverseOrder());
        Arrays.stream(intArray).forEach(maxHeapList::offer);
        System.out.println("maxHeapList peek: "+maxHeapList.peek());
        System.out.println("comparator: "+ maxHeapList.comparator());

        //min heap from collection
        PriorityQueue<Integer> minHeapList = new PriorityQueue<>(intList);
        System.out.println("minHeapList peek: "+minHeapList.peek());

        System.out.println("===========================");

        //reference to a value
        Cat[] itemArray = new Cat[]{
                new Cat(2, "Momo"),
                new Cat(1, "Kitty"),
                new Cat(10, "Gembul"),
                new Cat(7, "Pepsi"),
                new Cat(12, "Karen"),
                new Cat(5, "Tompey")
        };

        List<Cat> catList = Arrays.stream(itemArray).collect(Collectors.toList());
        PriorityQueue<Cat> catPQ = new PriorityQueue<>(catList);
        System.out.println("peek cat: "+ catPQ.poll().name);
        System.out.println("peek cat: "+ catPQ.poll().name);
        System.out.println("comparator: "+ catPQ.comparator());

        int[] nums = new int[]{3,2,1,5,6,4};
        int result = findKthLargest(nums, 2);
        System.out.println(result);
    }

    static class Cat implements Comparable<Cat>{
        int age;  String name;
        Cat(int age, String name){
            this.age = age; this.name = name;
        }
        @Override public int compareTo(Cat cat) {
            return cat.age - this.age;
        }
    }

    static int findKthLargest(int[] nums, int k) {
        if(nums.length==1){
            return nums[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(nums.length);
//        for(int num: nums){
//            heap.add(num);
//        }
//
//        int result = 0;
//        for(int i=1;i<=k;i++){
//            result = heap.poll();
//        }

        for(int i=0;i<k;i++){
            heap.offer(nums[i]);
        }

        for(int i=k;i<nums.length;i++){
            if(nums[i]>heap.peek()){
                heap.poll();
                heap.offer(nums[i]);
            }
        }

        int result = 0;
        for(int i=k;i>k-1;i--){
            result = heap.poll();
        }
        return result;
    }

}
