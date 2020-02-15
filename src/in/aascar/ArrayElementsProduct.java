package in.aascar;

/**
 * Good morning! Here's your coding interview problem for today.
 * <p>
 * This problem was asked by Uber.
 * <p>
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 * <p>
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * <p>
 * Follow-up: what if you can't use division?
 */

public class ArrayElementsProduct {

    static Integer[] bruteForce(Integer[] input) {
        int product = 1;
        for (int value : input) {
            product *= value;
        }
        for(int i = 0; i < input.length; i++){
            input[i] = product / input[i];
        }
        return input;
    }

    /**
     * Algorithm:
     * 1) Construct a temporary array left[] such that left[i] contains product of all elements on left of arr[i] excluding arr[i].
     * 2) Construct another temporary array right[] such that right[i] contains product of all elements on on right of arr[i] excluding arr[i].
     * 3) To get prod[], multiply left[] and right[].
     * @param input
     * @return
     */
    static Integer[] optimized(Integer[] input) {
        Integer[] product = new Integer[input.length];
        for(int i = 0; i < input.length; i++){
            product[i] = 1;
        }
        int temp = 1;
        //Left
        for(int i = 0; i < input.length; i++){
            product[i] = temp;
            temp *= input[i];
        }
        Main.printArray(product);
        //Right
        temp = 1;
        for(int i = input.length - 1; i >= 0; i--){
            product[i] *= temp;
            temp *= input[i];
        }
        return product;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        //Main.printArray(bruteForce(arr));
        Main.printArray(optimized(arr));
    }

}
