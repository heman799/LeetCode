public class AddStrings {
    public static String addString(String num1, String num2){
    //二进制数相加，链表相加，或者字符串加1
    //基本思路：一位一位相加，然后算和算进位，最后根据进位情况看需不需要补一个高位
        String result = "";
        int m = num1.length(), n = num2.length(), i = m - 1, j = n - 1, carry = 0;
        while (i >=0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = a + b + carry;
            result = Integer.toString(sum % 10) + result;
            carry = sum / 10;
        }

        return carry != 0 ? "1" + result : result;

    }



    public static void main(String[] args) {
        String num1 = "9999999999981";
        String num2 = "19";

        System.out.print(addString(num1, num2));
    }


}
