import java.util.Arrays;
import java.util.HashMap;

public class PairSum {
    
    /**
     * This method finds a pair of indices whose values in the array add up to a given target
     * @param arr The array to search
     * @param k The target sum
     * @return An array that contains the indices whose values add up o the target, or null if no pair is found
     */
    public static int[] pairSum(int[] arr, int k) {
        // Iterate through the values in the array
        for (int i = 0; i < arr.length - 1; i++) {
            // Create a pair between the current index (i) and each of the following indices (j)
            for (int j = i + 1; j < arr.length; j++) {
                // If we have a good pair, return the array
                if (arr[i] + arr[j] == k) {
                    return new int[]{i, j};
                }
            }
        }
        // Return null if no pair
        return null;
    }

    /**
     * This method finds a pair of indices whose values in the array add up to a given target
     * @param arr The array to search
     * @param k The target sum
     * @return An array that contains the indices whose values add up o the target, or null if no pair is found
     */
    public static int[] pairSumNew(int[] arr, int k) {
        // Create a HashMap for storing the past values and indices
        HashMap<Integer, Integer> history = new HashMap<Integer, Integer>();
        // Iterate through each element of the array
        for (int i = 0; i < arr.length; i++) {
            // See if we have a complement, -1 if not
            int complement = history.getOrDefault(k - arr[i], -1);
            // If no complement, update the HashMap
            if (complement == -1) {
                history.put(arr[i], i);
            } else {
                // Otherwise, return the array of indices
                return new int[]{complement, i};
            }
        }
        // Return null if no pair is found
        return null;
    }

    /**
     * Method that computes the average of an array
     * @param x The array to compute the average of
     * @return The average value of the array
     */
    public static double calcAvg(long[] x) {
        long sum = 0;
        // Calculate a running sum
        for (long i : x) {
            sum += i;
        }
        // Return the average
        return (double)sum / x.length;
    }

    public static void main(String[] args) {
        // Test cases for both of the methods
        int[] arr = {3, 1, 6, 2, 4};
        System.out.println(Arrays.toString(pairSum(arr, 5)));
        System.out.println(Arrays.toString(pairSumNew(arr, 5)));
        System.out.println(Arrays.toString(pairSum(arr, 15)));
        System.out.println(Arrays.toString(pairSumNew(arr, 15)));

        // My experiment to create a quantitative comparison between the two methods
        long[] olds = new long[10000];
        long[] news = new long[10000];
        for (int j = 0; j < olds.length; j++) {
            // Create a random array of 50,000 values
            int[] x = new int[50000];
            for (int i = 0; i < x.length; i++) {
                x[i] = (int)(Math.random() * 100000);
            }

            // Create a random target
            int k = (int)(Math.random() * 100000);

            // Compute the time for the first method
            long before = System.nanoTime();
            pairSum(x, k);
            long after = System.nanoTime();
            olds[j] = after - before;

            // Compute the time for teh second method
            before = System.nanoTime();
            pairSumNew(x, k);
            after = System.nanoTime();
            news[j] = after - before;

            // Visual for the iteration we are on
            if ((j + 1) % 100 == 0) {
                System.out.println("Iterations completed: " + (j + 1));
            }
        }

        // Output the averages
        System.out.println("Old alg avg: " + calcAvg(olds) + " ns");
        System.out.println("New alg avg: " + calcAvg(news) + " ns");
    }
}