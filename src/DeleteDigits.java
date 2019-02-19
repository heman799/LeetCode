public class DeleteDigits {
    public static String DeleteDigits(String A, int k) {
        StringBuffer sb = new StringBuffer(A);
        int i, j;
        for (i = 0; i < k; i++) {
            for (j = 0; j < sb.length() - 1 && sb.charAt(j) <= sb.charAt(j + 1); j++) {

            }
            sb.delete(j, j + 1);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String  A = "12348973897";
        int k = 4;

        System.out.println(DeleteDigits(A, k));
    }
}

