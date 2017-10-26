import java.util.Arrays;

public class TwoSum {
    /*
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int[] original = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            original[i] = numbers[i];
        }

        Arrays.sort(numbers);

        int start = 0;
        int end = numbers.length - 1;
        int num1 = -1;
        int num2 = -1;
        while (start != end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                num1 = numbers[start];
                num2 = numbers[end];
                break;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        //Find the num1, num2 in original array and record the index
        int[] rst = new int[2];
        rst[0] = -1;
        rst[1] = -1;
        for (int i = 0; i < original.length; i++) {
            if (original[i] == num1 || original[i] == num2){
                if (rst[0] == -1) {
                    rst[0] = i + 1;
                } else {
                    rst[1] = i + 1;
                    break;
                }
            }
        }

        return rst;

    }


}