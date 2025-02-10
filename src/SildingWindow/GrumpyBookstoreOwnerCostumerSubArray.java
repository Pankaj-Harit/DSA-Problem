package SildingWindow;

public class GrumpyBookstoreOwnerCostumerSubArray {

    public static void main(String[] args) {
        System.out.println(MaxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }

    private static int MaxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int start = 0, end = 0;
        int satisfiedCust = 0;
        //temp variable
        int newCust = 0;
        //store the max unsatisfied customer bookkeepar can attend without being grumpy
        int preCust = 0;

        while (end < customers.length) {
            //add the satisfied customers directly
            if (grumpy[end] == 0) satisfiedCust += customers[end];
                //add the unsatisfied customer in temp variable
            else newCust += customers[end];

            //when window size reached
            if (end + 1 - start == minutes) {
                //find the maximum customer present in a sub array
                preCust = Math.max(newCust, preCust);

                if (grumpy[start] == 1) newCust -= customers[start];

                start++;
            }

            end++;

        }
        //add the satisfied customer with maximum unsatisfied customer a bookkeepar can be able to satisfied
        return preCust + satisfiedCust;
    }

}






