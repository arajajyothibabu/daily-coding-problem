package in.aascar;


/**
 * This problem was asked by Stripe.
 * <p>
 * Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
 * <p>
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * <p>
 * You can modify the input array in-place.
 */

public class LowestPositiveInteger {

    static int solution(Integer[] input) {
        int temp;
        for(int i = 0, j = input.length - 1; i < input.length / 2 && j >= 0 && i < j;){
            if(input[i] > 0 && input[j] < 0){
                temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
            } else if(input[j] > 0) {
                j--;
            }
        }
        Main.printArray(input);
        int startIndex = 0;
        for(int c : input){
            if(c > 0) {
                break;
            }
            startIndex++;
        }
        for()
        return 0;
    }

    public static void main(String[] args) {
        Integer[] arr = { 3, 4, -1, 1 };
        System.out.println(solution(arr));
    }

}
