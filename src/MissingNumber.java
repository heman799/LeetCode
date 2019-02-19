public class MissingNumber {
    public int findMissing(int[] nums) {
        //bit manipulation
        //based on a ^ a = 0, a ^ 0 = a

        int res = 0;
        for (int i = 0 ; i < nums.length; i++) {
            //why i + 1?
            //cuz i should from 0 to N, but nums.length is N - 1, 0 ^ 1 = 1
            //so start with i + 1
            res ^= (i + 1) ^ nums[i];
        }

        return res;
    }
}
