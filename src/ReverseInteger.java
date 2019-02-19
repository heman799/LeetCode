public class ReverseInteger {
    public int reverseInteger(int n){
        int res = 0;
        while (n != 0) {
            if (Math.abs(res) > Integer.MAX_VALUE / 10)
                return 0;

            res = res * 10 + n % 10;
            n /= 10;
        }

        return res;
    }
}
