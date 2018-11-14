public class SumOfSquareNumbers {
    public boolean checkSumOfSquareNumbers(int sum) {
        if (sum < 0)
            return false;
        if (sum == 0)
            return true;

        for (int i = (int)Math.sqrt(sum); i >= 0; i--) {
            if (i * i == sum)
                return true;
            double a = Math.sqrt(sum - i * i);
            if (a == (int) a)
                return true;
        }
        return false;
    }
}
