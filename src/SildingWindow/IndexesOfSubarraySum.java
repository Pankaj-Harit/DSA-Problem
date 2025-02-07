package SildingWindow;

import java.util.ArrayList;

public class IndexesOfSubarraySum {
    public static void main(String[] args){
        System.out.println(indexesOfSubarraySum(new int[]{5, 3, 4}, 2));
    }

    public static ArrayList<Integer> indexesOfSubarraySum(int[] arr, int target){

        int start = 0, end =0;
        ArrayList<Integer> indexes = new ArrayList<>();
        int sum = 0;
        while(end < arr.length){
            //calc
            sum += arr[end];

            if(sum > target){
                //remove elements from start if the sum is greater than target
                while(sum > target && start < end) {
                    sum -= arr[start];
                    start++;
                }
            }

            //return the indexes if the sum is equal to target
            if(sum == target){
                indexes.add(start + 1);
                indexes.add(end + 1);
                return  indexes;
            }

            end++;
        }


        indexes.add(-1);
        return indexes;
    }
}
