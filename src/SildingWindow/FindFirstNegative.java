package SildingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindFirstNegative {
    public static void main(String[] args) {
        List<Integer> result = findFirstNegative(new int[]{1, -2, -3, 4, 5, -6, 7}, 2);
        System.out.println(result);
    }

    public static List<Integer> findFirstNegative(int[] arr, int k) {
        int i = 0;
        int j = 0;

        List<Integer> negativeList = new ArrayList<Integer>();
        List<Integer> resultList = new ArrayList<Integer>();

        while (j < arr.length) {

            if (arr[j] < 0) negativeList.add(arr[j]);

            if (j - i + 1 < k){
                j++;
            }
            else if (j - i + 1 == k) {

                if (negativeList.isEmpty()) {
                    resultList.add(0);
                } else {
                    resultList.add(negativeList.getFirst());
                    if (arr[i] == negativeList.getFirst()) {
                        negativeList.removeFirst();
                    }
                }

                i++;
                j++;
            }



        }


        return resultList;
    }
}
