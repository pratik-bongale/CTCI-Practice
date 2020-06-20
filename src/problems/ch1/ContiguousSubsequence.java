package problems.ch1;

public class ContiguousSubsequence {

    int getContinuousSubsequenceWithLargestSum(int[] arr) {
        // returns the actual largest subsequence
        // Assumption: when all negative integers, return 0

        int maxSum = 0;
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            maxSum = Math.max(sum, maxSum);
            if(sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }

    int getContinuousSubsequenceWithLargestSumHandlesAllNeg(int[] arr) {
        // returns the actual largest subsequence
        // Assumption: when all negative integers, return the highest

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0)  {
                // current number is positive
                if(sum > 0) {
                    sum += arr[i];
                } else {
                    sum = arr[i];
                }
            } else {
                // current number is negative
                if( sum+arr[i] > 0 ) {
                    sum += arr[i];
                } else {
                    sum = arr[i];
                }
            }

            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}
