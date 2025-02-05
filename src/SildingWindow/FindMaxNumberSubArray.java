package SildingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FindMaxNumberSubArray {
    public static void main(String[] args) {
        List<Integer> result = findMaxNUmbrSubArray(new int[]{
                1, 3, 2, 1, 5, 4
        }, 3);
        System.out.println(result);
    }

    public static List<Integer> findMaxNUmbrSubArray(int[] arr, int window) {

        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();

        int start = 0, end = 0;
        while (end < arr.length) {
            //remove all the smallest element from the last
            while (!queue.isEmpty() && queue.peekLast() < arr[end]) queue.removeLast();
            queue.add(arr[end]);

            if (end - start + 1 == window) {
                result.add(queue.peekFirst());
                if (arr[start] == queue.peekFirst()) queue.removeFirst();
                start++;
            }

            end++;
        }
        return result;
    }
}
