package patterns.slidingwindow;

import java.util.Arrays;

/**
 * Created by George Fouche on 1/28/20.
 */
public class AverageOfSubArrayOfSizeK {

    public static void main(String[] args) {
        double[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        System.out.println(Arrays.toString(findAverage1(arr, 5)));
        System.out.println(Arrays.toString(findAverage2(arr, 5)));
    }

    /**
     * O(N * K)
     *
     * @param arr
     * @param k
     * @return
     */
    private static double[] findAverage1(double[] arr, int k) {
        double[] result = new double[arr.length - k + 1];
        for (int i = 0; i <= arr.length - k; i++) {
            // find sum of next 'k' elements
            double sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            result[i] = sum / k; // calculate average
        }

        return result;

    }

    private static double[] findAverage2(double[] arr, int k) {
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];// add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= k- 1) {
                result[windowStart] = windowSum / k; // calculate the average
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return result;
        }
    }

