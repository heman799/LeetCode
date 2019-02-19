public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {


        for (int i = 1; i <= num / i; i++) {
            if (i * i == num) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        int num = 2147395600;
        System.out.print(isPerfectSquare(num));
    }
}
