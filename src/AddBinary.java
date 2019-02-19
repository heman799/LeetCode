public class AddBinary {
    //用了两个指针分别指向a和b的末尾，然后每次取出一个字符，转为数字，
    //若无法取出字符则按0处理，然后定义进位carry，初始化为0，将三者加起来，对2取余即为当前位的数字，
    //对2取商即为当前进位的值，记得最后还要判断下carry，如果为1的话，要在结果最前面加上一个1
    public String addBinary(String a, String b) {
        String ans = "";

        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += (i >= 0) ? a.charAt(i) - '0' : 0;
            sum += (j >= 0) ? b.charAt(j) - '0' : 0;
            ans = (sum % 2) + ans;
            carry = sum / 2;
        }

        if (carry != 0) {
            ans = carry + ans;
        }

        return ans;
    }
}
