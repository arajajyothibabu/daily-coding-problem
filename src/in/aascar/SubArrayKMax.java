package in.aascar;

/**
 * This problem was asked by Google.
 * <p>
 * Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.
 * <p>
 * For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
 * <p>
 * 10 = max(10, 5, 2)
 * 7 = max(5, 2, 7)
 * 8 = max(2, 7, 8)
 * 8 = max(7, 8, 7)
 * Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
 */

public class SubArrayKMax {

    static void solution(int[] input, int k) {
        int max, secondMax, maxIndex, secondMaxIndex;
        if(input[0] > input[1]){
            max = input[0];
            secondMax = input[1];
            maxIndex = 0;
            secondMaxIndex = 1;
        } else {
            max = input[1];
            secondMax = input[0];
            maxIndex = 1;
            secondMaxIndex = 0;
        }
        for(int i = 2; i < input.length; i++){
            if(max <= input[i]){
                if(secondMax <= max){
                    secondMax = max;
                    secondMaxIndex = maxIndex;
                }
                max = input[i];
                maxIndex = i;
            }
            if(i >= k - 1){
                System.out.println(max);
                if(secondMaxIndex != i - k + 1){
                    max = secondMax;
                    maxIndex = secondMaxIndex;
                }
                if(i + 1 < input.length) {
                    secondMax = input[i + 1];
                    secondMaxIndex = i + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 8, 7, 11, 1, 4, 5, 1, 7, 9, 9, 2};
        solution(arr, 3);
    }

}
