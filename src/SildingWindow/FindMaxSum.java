package SildingWindow;

public class FindMaxSum {
    public static void main(String[] args){
        int result = maximumSumSubarray(new int[]{1,2,3,4,5,6,7}, 3);
        System.out.println(result);
    }

    public static int maximumSumSubarray(int[] arr , int k){

        int max = 0;
        int result = 0;

        for(int i = 0; i < arr.length; i++){
            result += arr[i];

            if(i+ 1 >= k){
                max = Math.max(max, result);
                result = result - arr[i + 1- k];
            }
        }

        return  max;
    }
}
